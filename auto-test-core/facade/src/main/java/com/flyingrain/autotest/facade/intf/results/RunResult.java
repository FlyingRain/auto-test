package com.flyingrain.autotest.facade.intf.results;

import java.util.List;

public class RunResult {

    private boolean isSuccess;

    private String result;

    private List<RunResultDetail> runResultDetails;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<RunResultDetail> getRunResultDetails() {
        return runResultDetails;
    }

    public void setRunResultDetails(List<RunResultDetail> runResultDetails) {
        this.runResultDetails = runResultDetails;
    }
}
