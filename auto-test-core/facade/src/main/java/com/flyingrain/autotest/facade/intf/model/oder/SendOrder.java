package com.flyingrain.autotest.facade.intf.model.oder;

public class SendOrder {

    private String customerId;

    private String orderNo;

    private String customerNo;

    private String sendTime;

    private String receiveNo;

    private UserContactInfo sendInfo;

    private UserContactInfo receiveInfo;

    private GoodInfo goodsInfo;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getReceiveNo() {
        return receiveNo;
    }

    public void setReceiveNo(String receiveNo) {
        this.receiveNo = receiveNo;
    }

    public UserContactInfo getSendInfo() {
        return sendInfo;
    }

    public void setSendInfo(UserContactInfo sendInfo) {
        this.sendInfo = sendInfo;
    }

    public UserContactInfo getReceiveInfo() {
        return receiveInfo;
    }

    public void setReceiveInfo(UserContactInfo receiveInfo) {
        this.receiveInfo = receiveInfo;
    }

    public GoodInfo getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(GoodInfo goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    @Override
    public String toString() {
        return "sendOrder{" +
                "customerId='" + customerId + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", customerNo='" + customerNo + '\'' +
                ", sendTime='" + sendTime + '\'' +
                ", receiveNo='" + receiveNo + '\'' +
                ", sendInfo=" + sendInfo +
                ", receiveInfo=" + receiveInfo +
                ", goodsInfo=" + goodsInfo +
                '}';
    }
}
