package com.flyingrain.autotest.facade.intf.model;

public class AutoTestAES {

    private String key;

    private String iv;
    private Object originStr;

    private String encryptStr;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getOriginStr() {
        return originStr;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public void setOriginStr(Object originStr) {
        this.originStr = originStr;
    }

    public String getEncryptStr() {
        return encryptStr;
    }

    public void setEncryptStr(String encryptStr) {
        this.encryptStr = encryptStr;
    }

    @Override
    public String toString() {
        return "AutoTestAES{" +
                "key='" + key + '\'' +
                ", iv='" + iv + '\'' +
                ", originStr='" + originStr + '\'' +
                ", encryptStr='" + encryptStr + '\'' +
                '}';
    }
}
