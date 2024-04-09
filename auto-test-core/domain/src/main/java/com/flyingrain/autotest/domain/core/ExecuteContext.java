package com.flyingrain.autotest.domain.core;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public class ExecuteContext {

    private Map<String, String> params;

    private Map<String, JSONObject> results;

    private String executeCode;

    private String executor;

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public String getExecuteCode() {
        return executeCode;
    }

    public void setExecuteCode(String executeCode) {
        this.executeCode = executeCode;
    }

    public Map<String, JSONObject> getResults() {
        return results;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public void setResults(Map<String, JSONObject> results) {
        this.results = results;
    }
}
