package com.flyingrain.autotest.common.util;

public enum RequestBodyTypeEnum {
    FORM(1, "form表单"),

    TEXT(2, "文件格式"),

    ;

    public static RequestBodyTypeEnum codeOf(int code) {
        for (RequestBodyTypeEnum bodyType : RequestBodyTypeEnum.values()) {
            if (bodyType.code == code) {
                return bodyType;
            }
        }
        return null;
    }

    private int code;
    private String desc;

    RequestBodyTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
