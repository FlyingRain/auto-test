package com.flyingrain.autotest.domain.core.request;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.flyingrain.autotest.common.util.AutoTestResultCodeEnum;
import com.flyingrain.autotest.common.util.constant.HTTPRequestTypeEnum;
import com.flyingrain.autotest.common.util.exception.AutoTestException;
import com.flyingrain.autotest.domain.core.CaseExecutorHelper;
import com.flyingrain.autotest.domain.core.ExecuteContext;
import com.flyingrain.autotest.domain.core.executor.HttpRequestBody;
import com.flyingrain.autotest.domain.core.model.ExecuteParam;
import com.flyingrain.autotest.domain.core.model.HttpExecuteParam;
import com.flyingrain.autotest.domain.model.ParamMap;
import com.flyingrain.autotest.domain.model.ParamValue;
import com.flyingrain.autotest.domain.model.Service;
import com.flyingrain.autotest.domain.model.ServiceParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpRequestAssemble implements RequestAssemble {

    private final Logger logger = LoggerFactory.getLogger(HttpRequestAssemble.class);
    private List<ParamValue> paramValueList;

    private Service service;

    public HttpRequestAssemble(List<ParamValue> paramValueList, Service service) {
        this.paramValueList = paramValueList;
        this.service = service;
    }

    /**
     * 基于case中的变量，替换service中的配置
     *
     * @param executeContext
     * @return
     */
    @Override
    public ExecuteParam assembleRequest(ExecuteContext executeContext) {

        //先替换case里的变量
        Map<String, String> params = replaceParamValue(paramValueList, executeContext);

        //校验填充字段是否满足,
        checkParamsPair(params, service.getParams());

        //再根据map和service生成相应的请求
//        CaseExecutorHelper.fillService(service, params);
        return generateExecuteParam(params);
    }

    private ExecuteParam generateExecuteParam(Map<String, String> params) {
        HttpExecuteParam httpExecuteParam = new HttpExecuteParam();
        httpExecuteParam.setPath(CaseExecutorHelper.replaceParam(params, service.getRequestUrl()));
        httpExecuteParam.setHeaders(extractHeaders(CaseExecutorHelper.replaceParam(params, service.getHeaders())));
        httpExecuteParam.setRequestTypeEnum(HTTPRequestTypeEnum.valueOf(service.getRequestType()));
        String bodyStr = CaseExecutorHelper.replaceParam(params, service.getRequestDataModule());
        HttpRequestBody requestBody = JSONObject.parseObject(bodyStr, HttpRequestBody.class);
        httpExecuteParam.setBody(requestBody);
        return httpExecuteParam;
    }

    private Map<String, String> extractHeaders(String headerStr) {
        Map<String, String> headerMap = new HashMap<>();
        List<ParamMap> headers = JSONArray.parseArray(headerStr).toJavaList(ParamMap.class);
        headers.forEach(httpHeader -> headerMap.put(httpHeader.getKey(), httpHeader.getValue()));
        return headerMap;
    }

    private void checkParamsPair(Map<String, String> params, List<ServiceParam> params1) {
        if (CollectionUtils.isEmpty(params1)) {
            return;
        }
        for (ServiceParam serviceParam : params1) {
            if (!params.containsKey(serviceParam.getParam())) {
                logger.error("service param  not exist! param:[{}]", serviceParam.getParam());
                throw new AutoTestException(AutoTestResultCodeEnum.PARAM_NOT_EXIST.getCode(), "参数值不存在：" + serviceParam.getParam());
            }
        }
    }


    private Map<String, String> replaceParamValue(List<ParamValue> paramValueList, ExecuteContext executeContext) {
        Map<String, String> params = new HashMap<>(executeContext.getParams());
        if (CollectionUtils.isEmpty(paramValueList)) {
            return params;
        }
        paramValueList.forEach(paramValue -> {
            if (!paramValue.isGlobal()) {
                String value = paramValue.getValue();
                if (isDynamicVar(value)) {
                    value = replaceValue(value, executeContext);
                }
                params.put(paramValue.getName(), value);
            }
        });
        return params;
    }

    private boolean isGlobalKey(String value) {
        return value.startsWith("global_");
    }

    private String replaceValue(String value, ExecuteContext executeContext) {
        return CaseExecutorHelper.replaceParam(executeContext.getParams(), value);
    }

    private boolean isDynamicVar(String str) {
        return StringUtils.hasText(str) && str.contains("${");
    }
}
