package com.flyingrain.autotest.service.model.yunda;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;

public class YundaOrder {

    @JSONField(name = "order_no")
    private String orderNo;
    @JSONField(name = "serial_no")

    private String serialNo;
    @JSONField(name = "wave_no")

    private String waveNo;
    @JSONField(name = "service_type")

    private int serviceType;
    @JSONField(name = "product_type")

    private int productType;
    @JSONField(name = "delivery_type")

    private int deliveryType;
    @JSONField(name = "receipt_flag")

    private int receiptFlag;

    private BigDecimal weight;

    private BigDecimal volume;

    private BigDecimal value;
    @JSONField(name = "piece_amount")

    private int pieceAmount;

    @JSONField(name = "cargo_name")
    private String cargoName;

    @JSONField(name = "pack_type")
    private PackageType packType;

    @JSONField(name = "pay_type")
    private int payType;

    @JSONField(name = "insure_fee")
    private BigDecimal insureFee;

    @JSONField(name = "sale_platform")
    private String salePlatform;

    @JSONField(name = "package_length")
    private BigDecimal packageLength;

    @JSONField(name = "package_width")
    private BigDecimal packageWidth;

    @JSONField(name = "package_height")
    private BigDecimal packageHeight;

    private String remark;

    @JSONField(name = "sender_name")
    private String senderName;

    @JSONField(name = "sender_company")
    private String senderCompany;

    @JSONField(name = "sender_phone")
    private String senderPhone;

    @JSONField(name = "sender_tel")
    private String senderTel;

    @JSONField(name = "sender_province")
    private String senderProvince;

    @JSONField(name = "sender_city")
    private String senderCity;

    @JSONField(name = "sender_county")
    private String senderCounty;

    @JSONField(name = "sender_street")
    private String senderStreet;

    @JSONField(name = "sender_postcode")
    private String senderPostcode;

    @JSONField(name = "receiver_name")
    private String receiverName;


    @JSONField(name = "receiver_company")
    private String receiverCompany;

    @JSONField(name = "receiver_phone")
    private String receiverPhone;

    @JSONField(name = "receiver_tel")
    private String receiverTel;

    @JSONField(name = "receiver_province")
    private String receiverProvince;

    @JSONField(name = "receiver_city")
    private String receiverCity;

    @JSONField(name = "receiver_county")
    private String receiverCounty;

    @JSONField(name = "receiver_street")
    private String receiverStreet;

    @JSONField(name = "receiver_detail_address")
    private String receiverDetailAddress;

    @JSONField(name = "receiver_postcode")
    private String receiverPostcode;

    @JSONField(name = "business_attr")
    private int businessAttr;

    @JSONField(name = "platform_source")
    private String platformSource;

    @JSONField(name = "item_type")
    private int itemType;

    @JSONField(name = "pay_fee")
    private BigDecimal payFee;

    @JSONField(name = "cod_fee")
    private BigDecimal codFee;

    @JSONField(name = "platform_order_no")
    private String platformOrderNo;

    @JSONField(name = "mail_first_center_code")
    private int mailFirstCenterCode;

    @JSONField(name = "is_cod")
    private int isCod;

    @JSONField(name = "captcha_sign")
    private int captchaSign;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getWaveNo() {
        return waveNo;
    }

    public void setWaveNo(String waveNo) {
        this.waveNo = waveNo;
    }

    public int getServiceType() {
        return serviceType;
    }

    public void setServiceType(int serviceType) {
        this.serviceType = serviceType;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public int getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(int deliveryType) {
        this.deliveryType = deliveryType;
    }

    public int getReceiptFlag() {
        return receiptFlag;
    }

    public void setReceiptFlag(int receiptFlag) {
        this.receiptFlag = receiptFlag;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public int getPieceAmount() {
        return pieceAmount;
    }

    public void setPieceAmount(int pieceAmount) {
        this.pieceAmount = pieceAmount;
    }

    public String getCargoName() {
        return cargoName;
    }

    public void setCargoName(String cargoName) {
        this.cargoName = cargoName;
    }

    public PackageType getPackType() {
        return packType;
    }

    public void setPackType(PackageType packType) {
        this.packType = packType;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public BigDecimal getInsureFee() {
        return insureFee;
    }

    public void setInsureFee(BigDecimal insureFee) {
        this.insureFee = insureFee;
    }

    public String getSalePlatform() {
        return salePlatform;
    }

    public void setSalePlatform(String salePlatform) {
        this.salePlatform = salePlatform;
    }

    public BigDecimal getPackageLength() {
        return packageLength;
    }

    public void setPackageLength(BigDecimal packageLength) {
        this.packageLength = packageLength;
    }

    public BigDecimal getPackageWidth() {
        return packageWidth;
    }

    public void setPackageWidth(BigDecimal packageWidth) {
        this.packageWidth = packageWidth;
    }

    public BigDecimal getPackageHeight() {
        return packageHeight;
    }

    public void setPackageHeight(BigDecimal packageHeight) {
        this.packageHeight = packageHeight;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderCompany() {
        return senderCompany;
    }

    public void setSenderCompany(String senderCompany) {
        this.senderCompany = senderCompany;
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    public String getSenderTel() {
        return senderTel;
    }

    public void setSenderTel(String senderTel) {
        this.senderTel = senderTel;
    }

    public String getSenderProvince() {
        return senderProvince;
    }

    public void setSenderProvince(String senderProvince) {
        this.senderProvince = senderProvince;
    }

    public String getSenderCity() {
        return senderCity;
    }

    public void setSenderCity(String senderCity) {
        this.senderCity = senderCity;
    }

    public String getSenderCounty() {
        return senderCounty;
    }

    public void setSenderCounty(String senderCounty) {
        this.senderCounty = senderCounty;
    }

    public String getSenderStreet() {
        return senderStreet;
    }

    public void setSenderStreet(String senderStreet) {
        this.senderStreet = senderStreet;
    }

    public String getSenderPostcode() {
        return senderPostcode;
    }

    public void setSenderPostcode(String senderPostcode) {
        this.senderPostcode = senderPostcode;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverCompany() {
        return receiverCompany;
    }

    public void setReceiverCompany(String receiverCompany) {
        this.receiverCompany = receiverCompany;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverTel() {
        return receiverTel;
    }

    public void setReceiverTel(String receiverTel) {
        this.receiverTel = receiverTel;
    }

    public String getReceiverProvince() {
        return receiverProvince;
    }

    public void setReceiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince;
    }

    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    public String getReceiverCounty() {
        return receiverCounty;
    }

    public void setReceiverCounty(String receiverCounty) {
        this.receiverCounty = receiverCounty;
    }

    public String getReceiverStreet() {
        return receiverStreet;
    }

    public void setReceiverStreet(String receiverStreet) {
        this.receiverStreet = receiverStreet;
    }

    public String getReceiverDetailAddress() {
        return receiverDetailAddress;
    }

    public void setReceiverDetailAddress(String receiverDetailAddress) {
        this.receiverDetailAddress = receiverDetailAddress;
    }

    public String getReceiverPostcode() {
        return receiverPostcode;
    }

    public void setReceiverPostcode(String receiverPostcode) {
        this.receiverPostcode = receiverPostcode;
    }

    public int getBusinessAttr() {
        return businessAttr;
    }

    public void setBusinessAttr(int businessAttr) {
        this.businessAttr = businessAttr;
    }

    public String getPlatformSource() {
        return platformSource;
    }

    public void setPlatformSource(String platformSource) {
        this.platformSource = platformSource;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public BigDecimal getPayFee() {
        return payFee;
    }

    public void setPayFee(BigDecimal payFee) {
        this.payFee = payFee;
    }

    public BigDecimal getCodFee() {
        return codFee;
    }

    public void setCodFee(BigDecimal codFee) {
        this.codFee = codFee;
    }

    public String getPlatformOrderNo() {
        return platformOrderNo;
    }

    public void setPlatformOrderNo(String platformOrderNo) {
        this.platformOrderNo = platformOrderNo;
    }

    public int getMailFirstCenterCode() {
        return mailFirstCenterCode;
    }

    public void setMailFirstCenterCode(int mailFirstCenterCode) {
        this.mailFirstCenterCode = mailFirstCenterCode;
    }

    public int getIsCod() {
        return isCod;
    }

    public void setIsCod(int isCod) {
        this.isCod = isCod;
    }

    public int getCaptchaSign() {
        return captchaSign;
    }

    public void setCaptchaSign(int captchaSign) {
        this.captchaSign = captchaSign;
    }
}
