package com.flyingrain.autotest.service.model;

import com.flyingrain.autotest.facade.intf.model.oder.Address;

import java.util.List;
import java.util.Map;

public class YunDaAddressQuery {
    private String BuyerProvince;
    private String BuyerCity;
    private String BuyerArea;
    private String CreatedDotCode;
    private String IsCod;
    private String PaymentType;
    private String ServiceType;
    private String GetIsProvinceSite;
    private String IsOrderAddress;
    private String LogisticsId;
    private String IsInternational;
    private String SplitWord;
    private String ShortAddress;
    private String BuyerAddress;
    private String SettleNumber;





    public static YunDaAddressQuery fromAddress(Address address){
        String addressInfo = address.getProvince()+address.getCity()+address.getArea() + address.getCounty()+address.getDetailAddr();
        YunDaAddressQuery yunDaAddressQuery= new YunDaAddressQuery();
        yunDaAddressQuery.setBuyerProvince(address.getProvince());
        yunDaAddressQuery.setBuyerCity(address.getCity());
        yunDaAddressQuery.setBuyerArea(address.getArea());
        yunDaAddressQuery.setCreatedDotCode("56572779");
        yunDaAddressQuery.setIsCod("0");
        yunDaAddressQuery.setPaymentType("102");
        yunDaAddressQuery.setServiceType("111");
        yunDaAddressQuery.setGetIsProvinceSite("1");
        yunDaAddressQuery.setIsInternational("0");
        yunDaAddressQuery.setSplitWord("0");
        yunDaAddressQuery.setSettleNumber("200");
        yunDaAddressQuery.setShortAddress(addressInfo);
        yunDaAddressQuery.setBuyerAddress(addressInfo);
        return yunDaAddressQuery;
    }

    public String getBuyerProvince() {
        return BuyerProvince;
    }

    public void setBuyerProvince(String buyerProvince) {
        BuyerProvince = buyerProvince;
    }

    public String getBuyerCity() {
        return BuyerCity;
    }

    public void setBuyerCity(String buyerCity) {
        BuyerCity = buyerCity;
    }

    public String getBuyerArea() {
        return BuyerArea;
    }

    public void setBuyerArea(String buyerArea) {
        BuyerArea = buyerArea;
    }

    public String getCreatedDotCode() {
        return CreatedDotCode;
    }

    public void setCreatedDotCode(String createdDotCode) {
        CreatedDotCode = createdDotCode;
    }

    public String getIsCod() {
        return IsCod;
    }

    public void setIsCod(String isCod) {
        IsCod = isCod;
    }

    public String getPaymentType() {
        return PaymentType;
    }

    public void setPaymentType(String paymentType) {
        PaymentType = paymentType;
    }

    public String getServiceType() {
        return ServiceType;
    }

    public void setServiceType(String serviceType) {
        ServiceType = serviceType;
    }

    public String getGetIsProvinceSite() {
        return GetIsProvinceSite;
    }

    public void setGetIsProvinceSite(String getIsProvinceSite) {
        GetIsProvinceSite = getIsProvinceSite;
    }

    public String getIsOrderAddress() {
        return IsOrderAddress;
    }

    public void setIsOrderAddress(String isOrderAddress) {
        IsOrderAddress = isOrderAddress;
    }

    public String getLogisticsId() {
        return LogisticsId;
    }

    public void setLogisticsId(String logisticsId) {
        LogisticsId = logisticsId;
    }

    public String getIsInternational() {
        return IsInternational;
    }

    public void setIsInternational(String isInternational) {
        IsInternational = isInternational;
    }

    public String getSplitWord() {
        return SplitWord;
    }

    public void setSplitWord(String splitWord) {
        SplitWord = splitWord;
    }

    public String getShortAddress() {
        return ShortAddress;
    }

    public void setShortAddress(String shortAddress) {
        ShortAddress = shortAddress;
    }

    public String getBuyerAddress() {
        return BuyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        BuyerAddress = buyerAddress;
    }

    public String getSettleNumber() {
        return SettleNumber;
    }

    public void setSettleNumber(String settleNumber) {
        SettleNumber = settleNumber;
    }

    @Override
    public String toString() {
        return "YunDaAddressQuery{" +
                "BuyerProvince='" + BuyerProvince + '\'' +
                ", BuyerCity='" + BuyerCity + '\'' +
                ", BuyerArea='" + BuyerArea + '\'' +
                ", CreatedDotCode='" + CreatedDotCode + '\'' +
                ", IsCod='" + IsCod + '\'' +
                ", PaymentType='" + PaymentType + '\'' +
                ", ServiceType='" + ServiceType + '\'' +
                ", GetIsProvinceSite='" + GetIsProvinceSite + '\'' +
                ", IsOrderAddress='" + IsOrderAddress + '\'' +
                ", LogisticsId='" + LogisticsId + '\'' +
                ", IsInternational='" + IsInternational + '\'' +
                ", SplitWord='" + SplitWord + '\'' +
                ", ShortAddress='" + ShortAddress + '\'' +
                ", BuyerAddress='" + BuyerAddress + '\'' +
                ", SettleNumber='" + SettleNumber + '\'' +
                '}';
    }
}
