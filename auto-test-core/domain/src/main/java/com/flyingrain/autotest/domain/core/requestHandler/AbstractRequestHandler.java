package com.flyingrain.autotest.domain.core.requestHandler;

import com.alibaba.fastjson.JSONObject;
import com.flyingrain.autotest.domain.constant.AutoTestConstants;
import com.flyingrain.autotest.domain.constant.AutoTestResultCodeEnum;
import com.flyingrain.autotest.domain.core.executor.CaseResultCache;
import com.flyingrain.autotest.domain.core.typehandle.CommonTypeHandler;
import com.flyingrain.autotest.domain.exception.AutoTestException;
import com.flyingrain.autotest.domain.model.Case;
import com.flyingrain.autotest.domain.model.Service;
import com.flyingrain.autotest.domain.utils.TemplateHandleHelper;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wally
 * @date 2021-12-16
 */
public abstract class AbstractRequestHandler implements RequestHandler {

    private final Logger logger = LoggerFactory.getLogger(AbstractRequestHandler.class);

    @Autowired
    private CommonTypeHandler commonTypeHandler;


    String generateContent(Case runCase, CaseResultCache caseResultCache) {
        Service service = runCase.getService();
        String template = service.getRequestDataModule();
        if (StringUtils.isEmpty(template)) {
            return null;
        }
        String data = runCase.getData();

        template = replaceStaticParam(template, data);

        template = replaceDynamicParam(template, caseResultCache);

        return template;
    }

    public String replaceDynamicParam(String template, CaseResultCache caseResultCache) {
        if (StringUtils.isEmpty(template)) {
            logger.error("target string is empty.");
            return StringUtils.EMPTY;
        }
        while (template.contains(AutoTestConstants.DYNAMIC_STR_START)) {
            int start = template.indexOf(AutoTestConstants.DYNAMIC_STR_START);
            int end = template.indexOf(AutoTestConstants.REPLACE_STR_END);
            String paramName = template.substring(start + AutoTestConstants.DYNAMIC_STR_START.length(), end);
            String[] paramPaths = paramName.split("\\.");
            if (paramPaths.length <= 1) {
                logger.error("error format !content is :[{}]", template);
                throw new AutoTestException(AutoTestResultCodeEnum.ERROR_TYPE_FORMAT);
            }
            Map<Long, Map<String, Object>> depResult = caseResultCache.getDepResult();
            Map<String, Object> params = depResult.get(Long.parseLong(paramPaths[0]));
            String newParam = replaceFromMap(paramPaths, params);
            String oldValue = template.substring(start, end + 1);
            template = template.replaceAll(oldValue, newParam);
        }
        return template;
    }

    protected String replaceFromMap(String[] paramPaths, Map<String, Object> params) {
        if (MapUtils.isEmpty(params)) {
            logger.error("no result to replace!");
            throw new AutoTestException(AutoTestResultCodeEnum.RESULT_NOT_EXIST);
        }
        Map<String, Object> p = params;
        Object o = null;
        for (int i = 1; i < paramPaths.length; i++) {
            String first = paramPaths[i];
            if (!p.containsKey(first)) {
                logger.error("result not contain key:[{}]", first);
                throw new AutoTestException(AutoTestResultCodeEnum.RESULT_NOT_EXIST);
            }
            o = p.get(first);
            if (o instanceof Map) {
                p = (Map<String, Object>) o;
            } else if (i < paramPaths.length - 1) {
                logger.error("result not expected!key:[{}]", paramPaths[i + 1]);
                throw new AutoTestException(AutoTestResultCodeEnum.RESULT_NOT_EXIST);
            }
        }
        return handleDynamicObject(o);
    }

    public String replaceStaticParam(String template, String data) {
        Map<String, Object> params = new HashMap<>();
        if (StringUtils.isNotEmpty(data)) {
            params = JSONObject.parseObject(data, Map.class);
        }
        while (template.contains(AutoTestConstants.REPLACE_STR_START)) {
            int start = template.indexOf(AutoTestConstants.REPLACE_STR_START);
            int end = template.indexOf(AutoTestConstants.REPLACE_STR_END);
            String paramName = template.substring(start + AutoTestConstants.DYNAMIC_STR_START.length(), end);
            String type = TemplateHandleHelper.extractParamType(paramName);
            String name = TemplateHandleHelper.extractParamName(paramName);
            if (params.containsKey(name)) {
                logger.error("pls set key value:[{}]", name);
                throw new AutoTestException(AutoTestResultCodeEnum.NO_TEMPLATE_KEY);
            }
            Object value = params.get(name) == null ? "null" : params.get(name.trim());
            Object handledValue = handleType(value, type);
            String oldValue = template.substring(start, end + 1);
            template = template.replaceAll(oldValue, handledValue.toString());
        }
        return template;
    }

    protected abstract Object handleType(Object value, String type);

    protected abstract String handleDynamicObject(Object o);
}
