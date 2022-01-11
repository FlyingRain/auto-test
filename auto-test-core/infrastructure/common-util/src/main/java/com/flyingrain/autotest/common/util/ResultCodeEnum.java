package com.flyingrain.autotest.common.util;

public enum ResultCodeEnum {

    SUCCESS("200","成功"),

    FAIL("500","失败"),
    ;

    private String code;

    private String message;

    ResultCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
