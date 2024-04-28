package com.flyingrain.autotest.domain.core.model;

import com.flyingrain.autotest.common.util.constant.HTTPRequestTypeEnum;
import com.flyingrain.autotest.domain.core.executor.HttpRequestBody;

import java.util.Map;

public class HttpExecuteParam extends ExecuteParam<HttpRequestBody>{


    private Map<String,String> headers;

    private HTTPRequestTypeEnum requestTypeEnum;


    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public HTTPRequestTypeEnum getRequestTypeEnum() {
        return requestTypeEnum;
    }

    public void setRequestTypeEnum(HTTPRequestTypeEnum requestTypeEnum) {
        this.requestTypeEnum = requestTypeEnum;
    }

    @Override
    public String toString() {
        return "HttpExecuteParam{" +
                "headers=" + headers +
                ", requestTypeEnum=" + requestTypeEnum +
                "} " + super.toString();
    }
}
