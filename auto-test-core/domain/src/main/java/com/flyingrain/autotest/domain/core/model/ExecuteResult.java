package com.flyingrain.autotest.domain.core.model;

import java.util.HashMap;
import java.util.Map;

public class ExecuteResult {

    private boolean success;

    private String result;

    private long spendTime;

    private String extractResult;

    private Map<String,String> resultMap = new HashMap<>(8);

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Map<String, String> getResultMap() {
        return resultMap;
    }

    public long getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(long spendTime) {
        this.spendTime = spendTime;
    }

    public String getExtractResult() {
        return extractResult;
    }

    public void setExtractResult(String extractResult) {
        this.extractResult = extractResult;
    }

    public void setResultMap(Map<String, String> resultMap) {
        this.resultMap = resultMap;
    }
}
