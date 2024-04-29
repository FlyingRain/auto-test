package com.flyingrain.autotest.domain.core.executor;

import com.flyingrain.autotest.common.util.RequestBodyTypeEnum;

import java.util.List;

public class HttpRequestBody {

    private RequestBodyTypeEnum requestBodyTypeEnum;

    private int requestBodyType;
    private String content;

    private List<HttpEntityModel> entities;

    public RequestBodyTypeEnum getRequestBodyTypeEnum() {
        return requestBodyTypeEnum;
    }

    public void setRequestBodyTypeEnum(RequestBodyTypeEnum requestBodyTypeEnum) {
        this.requestBodyTypeEnum = requestBodyTypeEnum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<HttpEntityModel> getEntities() {
        return entities;
    }

    public void setEntities(List<HttpEntityModel> entities) {
        this.entities = entities;
    }

    public int getRequestBodyType() {
        return requestBodyType;
    }

    public void setRequestBodyType(int requestBodyType) {
        this.requestBodyType = requestBodyType;
        this.requestBodyTypeEnum = RequestBodyTypeEnum.codeOf(requestBodyType);
    }

    @Override
    public String toString() {
        return "HttpRequestBody{" +
                "requestBodyTypeEnum=" + requestBodyTypeEnum +
                ", requestBodyType=" + requestBodyType +
                ", content='" + content + '\'' +
                ", entities=" + entities +
                '}';
    }
}
