package com.flyingrain.autotest.facade.intf.model.oder;

public class SendOrder {

    private String customerId;

    private String orderNo;

    private String customerNo;

    private String sendTime;

    private String receiveNo;

    private UserContactInfo sendInfo;

    private UserContactInfo receiverInfo;

    private GoodInfo goodsInfo;

    private AddedValue addedValue;

    private Income income;

    private Cost cost;

    private String thirdBusiness;


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

    public UserContactInfo getReceiverInfo() {
        return receiverInfo;
    }

    public void setReceiverInfo(UserContactInfo receiverInfo) {
        this.receiverInfo = receiverInfo;
    }

    public AddedValue getAddedValue() {
        return addedValue;
    }

    public void setAddedValue(AddedValue addedValue) {
        this.addedValue = addedValue;
    }

    public GoodInfo getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(GoodInfo goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public Income getIncome() {
        return income;
    }

    public void setIncome(Income income) {
        this.income = income;
    }

    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }

    public String getThirdBusiness() {
        return thirdBusiness;
    }

    public void setThirdBusiness(String thirdBusiness) {
        this.thirdBusiness = thirdBusiness;
    }

    @Override
    public String toString() {
        return "SendOrder{" +
                "customerId='" + customerId + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", customerNo='" + customerNo + '\'' +
                ", sendTime='" + sendTime + '\'' +
                ", receiveNo='" + receiveNo + '\'' +
                ", sendInfo=" + sendInfo +
                ", receiverInfo=" + receiverInfo +
                ", goodsInfo=" + goodsInfo +
                ", addedValue=" + addedValue +
                ", income=" + income +
                ", cost=" + cost +
                ", thirdBusiness='" + thirdBusiness + '\'' +
                '}';
    }
}
