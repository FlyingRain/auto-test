package com.flyingrain.autotest.common.util;

public enum RunLogStatusEnum {

    SUCCESS("SUCCESS","执行成功"),

    FAIL("FAIL","执行失败"),

    EXECUTING("EXECUTING","执行中"),

    ;


    private String code;

    private String desc;

    RunLogStatusEnum(String code, String desc) {
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
