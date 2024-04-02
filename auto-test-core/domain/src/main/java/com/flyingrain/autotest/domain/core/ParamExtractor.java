package com.flyingrain.autotest.domain.core;

import com.alibaba.fastjson.JSONArray;
import com.flyingrain.autotest.common.util.AutoTestResultCodeEnum;
import com.flyingrain.autotest.common.util.constant.HTTPRequestTypeEnum;
import com.flyingrain.autotest.common.util.constant.ProtocolTypeEnum;
import com.flyingrain.autotest.common.util.exception.AutoTestException;
import com.flyingrain.autotest.domain.core.model.ExecuteParam;
import com.flyingrain.autotest.domain.core.model.HttpExecuteParam;
import com.flyingrain.autotest.domain.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ParamExtractor {

    @Autowired
    private CaseExecutorHelper caseExecutorHelper;
    private final Logger logger = LoggerFactory.getLogger(ParamExtractor.class);

    public <T> ExecuteParam<T> extract(Case runCase, ExecuteContext executeContext) {
        ExecuteParam executeParam = null;
        Map<String, String> params = fuseParam(runCase, executeContext);
        Service service = runCase.getService();
        checkParamsPair(params, service.getParams());
        caseExecutorHelper.fillDynamicParam(runCase, params);
        String protocolType = service.getProtocolType();
        ProtocolTypeEnum protocolTypeEnum = ProtocolTypeEnum.valueOf(protocolType);
        switch (protocolTypeEnum) {
            case HTTP:
                executeParam = new HttpExecuteParam();
                ((HttpExecuteParam) executeParam).setHeaders(extractHeader(service, params));
                ((HttpExecuteParam) executeParam).setRequestTypeEnum(HTTPRequestTypeEnum.valueOf(service.getRequestType()));
                executeParam.setPath(service.getRequestUrl());
                break;
            case DUBBO:
                throw new AutoTestException(AutoTestResultCodeEnum.NOT_SUPPORT_PROTOCOL);
            default:
                break;
        }
        return executeParam;
    }

    private void checkParamsPair(Map<String, String> params, List<ServiceParam> params1) {
        for (ServiceParam serviceParam : params1) {
            if (!params.containsKey(serviceParam.getParam())) {
                logger.error("service param  not exist! param:[{}]", serviceParam.getParam());
                throw new AutoTestException(AutoTestResultCodeEnum.PARAM_NOT_EXIST.getCode(), "参数值不存在：" + serviceParam.getParam());
            }
        }
    }

    private Map<String, String> fuseParam(Case runCase, ExecuteContext executeContext) {
        Map<String, String> params = executeContext.getParams();
        if (StringUtils.hasText(runCase.getParamValue())) {
            try {
                List<ParamValue> paramValueList = JSONArray.parseArray(runCase.getParamValue()).toJavaList(ParamValue.class);
                paramValueList.forEach(paramValue -> {
                    params.put(paramValue.getName(), paramValue.getValue());
                });
            } catch (Exception e) {
                logger.error("param:[{}]", runCase.getParamValue());
                logger.error("parse param value error!,set param null!", e);
            }
        }
        return params;
    }

    private Map<String, String> extractHeader(Service service, Map<String, String> params) {
        Map<String, String> headerMap = new HashMap<>();
        String headerStr = service.getHeaders();
        if (StringUtils.hasText(headerStr)) {
            try {
                List<ParamMap> headers = JSONArray.parseArray(headerStr).toJavaList(ParamMap.class);
                headers.forEach(httpHeader -> headerMap.put(httpHeader.getKey(), httpHeader.getValue()));
            } catch (Exception e) {
                logger.error("parse http header error:[{}]", headerStr);
                logger.error("happen error when parse header!", e);
            }
        }
        return headerMap;
    }

}
