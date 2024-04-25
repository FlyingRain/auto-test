package com.flyingrain.autotest.facade.intf.model;

public class AutoTestEncryptDecrypt {
    private Object originStr;

    private String encryptStr;


    public Object getOriginStr() {
        return originStr;
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
        return "AutoTestEncryptDecrypt{" +
                "originStr=" + originStr +
                ", encryptStr='" + encryptStr + '\'' +
                '}';
    }
}
