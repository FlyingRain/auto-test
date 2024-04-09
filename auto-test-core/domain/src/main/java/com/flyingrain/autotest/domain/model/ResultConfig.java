package com.flyingrain.autotest.domain.model;

import java.util.List;

public class ResultConfig {

    private String responseDataType;

    private List<ParamMap> responseParam;

    public String getResponseDataType() {
        return responseDataType;
    }

    public void setResponseDataType(String responseDataType) {
        this.responseDataType = responseDataType;
    }

    public List<ParamMap> getResponseParam() {
        return responseParam;
    }

    public void setResponseParam(List<ParamMap> responseParam) {
        this.responseParam = responseParam;
    }

    @Override
    public String toString() {
        return "ResultConfig{" +
                "responseDataType='" + responseDataType + '\'' +
                ", responseParam=" + responseParam +
                '}';
    }
}
