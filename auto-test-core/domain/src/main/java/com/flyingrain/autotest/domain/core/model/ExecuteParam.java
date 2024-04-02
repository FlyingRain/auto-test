package com.flyingrain.autotest.domain.core.model;

public class ExecuteParam<T> {

    private String path;

    private T  body;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
