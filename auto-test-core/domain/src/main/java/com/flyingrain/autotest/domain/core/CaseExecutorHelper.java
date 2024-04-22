package com.flyingrain.autotest.domain.core;

import com.alibaba.fastjson.JSONArray;
import com.flyingrain.autotest.common.util.DynamicParamExtract;
import com.flyingrain.autotest.domain.model.Case;
import com.flyingrain.autotest.domain.model.ParamValue;
import com.flyingrain.autotest.domain.model.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Component
public class CaseExecutorHelper {

    private static final Logger logger = LoggerFactory.getLogger(CaseExecutorHelper.class);

    /**
     * 填充用例中的变量
     *
     * @param runCase
     */
    public static void fillDynamicParam(Case runCase, Map<String, String> params) {
        Service service = runCase.getService();
        if (StringUtils.hasText(runCase.getParamValue())) {
            try {
                List<ParamValue> paramValueList = JSONArray.parseArray(runCase.getParamValue()).toJavaList(ParamValue.class);
                paramValueList.forEach(paramValue -> {
                    params.put(paramValue.getName(), paramValue.getValue());
                });
            } catch (Exception e) {
                logger.error("parse case paramValue failed!case value:[{}]", runCase.getParamValue());
                logger.error("exception:", e);
            }
        }
        fillService(service, params);
    }

    public static void fillService(Service service, Map<String, String> params) {
        service.setRequestUrl(replaceParam(params, service.getRequestUrl()));
        service.setHeaders(replaceParam(params, service.getHeaders()));
        service.setRequestDataModule(replaceParam(params, service.getRequestDataModule()));
    }

    public static String replaceParam(Map<String, String> params, String str) {
        if (StringUtils.hasText(str)) {
            List<String> dynamicParams = DynamicParamExtract.extractParam(str);
            if (!CollectionUtils.isEmpty(dynamicParams)) {
                for (String param : dynamicParams) {
                    String value = params.get(param);
                    if (StringUtils.hasText(value)) {
                        str = str.replace("${" + param + "}", value);
                    } else {
                        //如果没有值，那么根据配置上下文，确定是替换成空字符串，还是null
                        int index = str.indexOf("${" + param + "}");
                        if ("\"".equals(str.substring(index - 1, index)))
                            str = str.replace("${" + param + "}", "");
                        else
                            str = str.replace("${" + param + "}", "null");
                    }
                }
            }
        }
        return str;
    }


}
