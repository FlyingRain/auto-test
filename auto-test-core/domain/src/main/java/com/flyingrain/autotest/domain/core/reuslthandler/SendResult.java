package com.flyingrain.autotest.domain.core.reuslthandler;

import java.util.Map;

/**
 * @author wally
 * @date 2021-12-16
 */
public class SendResult {

    private Long caseId;

    private Object originResult;

    private Map<String ,Object> resultValues;

    private String errorCode;

    private String msg;

    private boolean success = true;

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public Map<String, Object> getResultValues() {
        return resultValues;
    }

    public void setResultValues(Map<String, Object> resultValues) {
        this.resultValues = resultValues;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


    public Object getOriginResult() {
        return originResult;
    }

    public void setOriginResult(Object originResult) {
        this.originResult = originResult;
    }

    @Override
    public String toString() {
        return "SendResult{" +
                "caseId=" + caseId +
                ", resultValues=" + resultValues +
                ", errorCode='" + errorCode + '\'' +
                ", msg='" + msg + '\'' +
                ", success=" + success +
                '}';
    }
}
