package com.flyingrain.autotest.common.util;

public enum FunctionEnum {

    NOW("now", "当前时间"),
    BASE64_ENCODE("base64encode", "base64编码"),
    BASE64_DECODE("base64decode", "base64解码"),

    URL_ENCODE("urlencode", "url编码"),
    URL_DECODE("urldecode", "url解码"),


    ;

    public static FunctionEnum codeOf(String code) {
        for (FunctionEnum function : FunctionEnum.values()) {
            if (function.code.equals(code)) {
                return function;
            }
        }
        return null;
    }


    private String code;

    private String desc;

    FunctionEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
