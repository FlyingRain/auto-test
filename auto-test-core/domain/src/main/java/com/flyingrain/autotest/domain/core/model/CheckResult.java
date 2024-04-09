package com.flyingrain.autotest.domain.core.model;

public class CheckResult {

    private Boolean valid = true;

    private String message;


    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CheckResult{" +
                "valid=" + valid +
                ", message='" + message + '\'' +
                '}';
    }
}
