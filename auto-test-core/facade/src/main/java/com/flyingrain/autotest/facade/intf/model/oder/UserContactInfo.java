package com.flyingrain.autotest.facade.intf.model.oder;

import com.flyingrain.autotest.facade.intf.model.oder.Address;

public class UserContactInfo {

    private String telNo;

    private String sendName;

    private Address address;

    private String customerId;

    private String detailArea;

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getSendName() {
        return sendName;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDetailArea() {
        return detailArea;
    }

    public void setDetailArea(String detailArea) {
        this.detailArea = detailArea;
    }

    @Override
    public String toString() {
        return "UserContactInfo{" +
                "telNo='" + telNo + '\'' +
                ", sendName='" + sendName + '\'' +
                ", address=" + address +
                ", customerId='" + customerId + '\'' +
                ", detailArea='" + detailArea + '\'' +
                '}';
    }
}
