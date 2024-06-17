package com.flyingrain.autotest.service.model.yunda;

public class YunDaPriceDetail {

    private String name;

    private String oneTotal;

    private String twoTotal;

    private String parentCode;

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOneTotal() {
        return oneTotal;
    }

    public void setOneTotal(String oneTotal) {
        this.oneTotal = oneTotal;
    }

    public String getTwoTotal() {
        return twoTotal;
    }

    public void setTwoTotal(String twoTotal) {
        this.twoTotal = twoTotal;
    }
}
