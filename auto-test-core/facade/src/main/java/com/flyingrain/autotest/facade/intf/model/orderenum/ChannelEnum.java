package com.flyingrain.autotest.facade.intf.model.orderenum;

public enum ChannelEnum {

    YIMI("yim   i", "薏米"),
    YUNDA("yunda", "韵达"),

    BAISHI("baishi", "百世"),

    zhongtong("zhongtong", "中通"),

    anneng("anneng", "安能");

    public static ChannelEnum getByCode(String code) {
        for (ChannelEnum channelEnum : ChannelEnum.values()) {
            if (channelEnum.getCode().equals(code)) {
                return channelEnum;
            }
        }
        return null;
    }

    private String code;

    private String desc;

    ChannelEnum(String code, String desc) {
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
