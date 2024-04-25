package com.flyingrain.autotest.facade.intf.model;

public class AutoTestAES extends AutoTestEncryptDecrypt {

    private String key;

    private String iv;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }



    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }


    @Override
    public String toString() {
        return "AutoTestAES{" +
                "key='" + key + '\'' +
                ", iv='" + iv + '\'' +
                "} " + super.toString();
    }
}
