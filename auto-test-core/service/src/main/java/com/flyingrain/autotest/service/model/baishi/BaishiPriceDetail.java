package com.flyingrain.autotest.service.model.baishi;

public class BaishiPriceDetail {

    private Integer lockVersion;

    private Integer priceTypeId;

    private String priceType;

    private Double money;

    private String settleExp;

    public Integer getLockVersion() {
        return lockVersion;
    }

    public void setLockVersion(Integer lockVersion) {
        this.lockVersion = lockVersion;
    }

    public Integer getPriceTypeId() {
        return priceTypeId;
    }

    public void setPriceTypeId(Integer priceTypeId) {
        this.priceTypeId = priceTypeId;
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getSettleExp() {
        return settleExp;
    }

    public void setSettleExp(String settleExp) {
        this.settleExp = settleExp;
    }
}
