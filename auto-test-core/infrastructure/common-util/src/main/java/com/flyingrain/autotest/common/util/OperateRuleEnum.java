package com.flyingrain.autotest.common.util;

public enum OperateRuleEnum {

    OUTWEIGH("2", "大于"),

    LESS("3", "小于"),

    EQUAL("1", "等于"),


    OUTWEIGH_EQUAL("4", "大于等于"),

    LESS_EQUAL("5", "小于等于"),

    NOT_EQUAL("6", "不等于");

    private String code;

    private String desc;

    public static OperateRuleEnum codeOf(String code) {
        for (OperateRuleEnum operate : OperateRuleEnum.values()) {
            if (operate.code.equals(code)) {
                return operate;
            }
        }
        return null;
    }

    OperateRuleEnum(String code, String desc) {
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
