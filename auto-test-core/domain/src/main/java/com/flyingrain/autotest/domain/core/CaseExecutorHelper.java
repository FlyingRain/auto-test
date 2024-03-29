package com.flyingrain.autotest.domain.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.flyingrain.autotest.common.util.DynamicParamExtract;
import com.flyingrain.autotest.domain.model.Case;
import com.flyingrain.autotest.domain.model.ParamValue;
import com.flyingrain.autotest.domain.model.Service;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Component
public class CaseExecutorHelper {


    /**
     * 填充用例中的变量
     *
     * @param runCase
     */
    public void fillDynamicParam(Case runCase, Map<String, String> params) {
        Service service = runCase.getService();
        if (StringUtils.hasText(runCase.getParamValue())) {
            List<ParamValue> paramValueList = JSONArray.parseArray(runCase.getParamValue()).toJavaList(ParamValue.class);
            paramValueList.forEach(paramValue -> {
                params.put(paramValue.getName(), paramValue.getValue());
            });
        }
        fillService(service, params);
    }

    private void fillService(Service service, Map<String, String> params) {
        String url = service.getRequestUrl();
        url = replaceParam(params, url);
    }

    private static String replaceParam(Map<String, String> params, String str) {
        if (StringUtils.hasText(str)) {
            List<String> dynamicParams = DynamicParamExtract.extractParam(str);
            if (!CollectionUtils.isEmpty(dynamicParams)) {
                for (String param : dynamicParams) {
                    String value = params.get(param);
                    if (StringUtils.hasText(value)) {
                        str = str.replace("${" + param + "}", value);
                    }
                }
            }
        }
        return str;
    }


}
