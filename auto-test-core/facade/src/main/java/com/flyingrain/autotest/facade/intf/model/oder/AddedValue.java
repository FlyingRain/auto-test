package com.flyingrain.autotest.facade.intf.model.oder;

public class AddedValue {

    private Double insureAmount;

    private String upstairs;

    private String backOrderType;

    private String backOrderNo;

    private String settleType;

    public Double getInsureAmount() {
        return insureAmount;
    }

    public void setInsureAmount(Double insureAmount) {
        this.insureAmount = insureAmount;
    }

    public String getUpstairs() {
        return upstairs;
    }

    public void setUpstairs(String upstairs) {
        this.upstairs = upstairs;
    }

    public String getBackOrderType() {
        return backOrderType;
    }

    public void setBackOrderType(String backOrderType) {
        this.backOrderType = backOrderType;
    }

    public String getBackOrderNo() {
        return backOrderNo;
    }

    public void setBackOrderNo(String backOrderNo) {
        this.backOrderNo = backOrderNo;
    }

    public String getSettleType() {
        return settleType;
    }

    public void setSettleType(String settleType) {
        this.settleType = settleType;
    }
}
