
package com.flyingrain.autotest.service.model.zhongtong;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class ZhongtongPriceQueryRequest {

    private Integer receiveDest;
    private Integer productType;
    private String actualWeight;
    private Integer goodsType;
    private String goodsName;
    private String sendDate;
    private String volume;
    private String pickUp;
    private Integer customerVipFlag;
    private String goodsCategory;
    private String piece;
    private String serviceAdd;
    private Boolean chkReturnFlag;
    private Boolean chkBackFlag;
    private String cbxTown;
    private String insuredAmount;
    private Integer insuredScheme;
    private String actualTotalAmount;
    private String freightCharge;
    private String payModeId;
    private Integer sendCustomerId;
    private Integer vipCustomerId;
    private String expressTime;
    private Boolean accurateCheck;
    private Boolean exclusiveCheck;
    private String rewbNo;
    private Integer sendReceiptFlag;
    private String shippingMethod;
    private String villagesFeeParamter;
    private String pickStock;
    private String ewbNo;
    private Boolean dzMainInput;
    private String townSelf;
    private String dispatchSecondSiteId;
    private Integer medicineService;
    @JSONField(serialize = false)
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Integer getReceiveDest() {
        return receiveDest;
    }

    public void setReceiveDest(Integer receiveDest) {
        this.receiveDest = receiveDest;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public String getActualWeight() {
        return actualWeight;
    }

    public void setActualWeight(String actualWeight) {
        this.actualWeight = actualWeight;
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getPickUp() {
        return pickUp;
    }

    public void setPickUp(String pickUp) {
        this.pickUp = pickUp;
    }

    public Integer getCustomerVipFlag() {
        return customerVipFlag;
    }

    public void setCustomerVipFlag(Integer customerVipFlag) {
        this.customerVipFlag = customerVipFlag;
    }

    public String getGoodsCategory() {
        return goodsCategory;
    }

    public void setGoodsCategory(String goodsCategory) {
        this.goodsCategory = goodsCategory;
    }

    public String getPiece() {
        return piece;
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }

    public String getServiceAdd() {
        return serviceAdd;
    }

    public void setServiceAdd(String serviceAdd) {
        this.serviceAdd = serviceAdd;
    }

    public Boolean getChkReturnFlag() {
        return chkReturnFlag;
    }

    public void setChkReturnFlag(Boolean chkReturnFlag) {
        this.chkReturnFlag = chkReturnFlag;
    }

    public Boolean getChkBackFlag() {
        return chkBackFlag;
    }

    public void setChkBackFlag(Boolean chkBackFlag) {
        this.chkBackFlag = chkBackFlag;
    }

    public String getCbxTown() {
        return cbxTown;
    }

    public void setCbxTown(String cbxTown) {
        this.cbxTown = cbxTown;
    }

    public String getInsuredAmount() {
        return insuredAmount;
    }

    public void setInsuredAmount(String insuredAmount) {
        this.insuredAmount = insuredAmount;
    }

    public Integer getInsuredScheme() {
        return insuredScheme;
    }

    public void setInsuredScheme(Integer insuredScheme) {
        this.insuredScheme = insuredScheme;
    }

    public String getActualTotalAmount() {
        return actualTotalAmount;
    }

    public void setActualTotalAmount(String actualTotalAmount) {
        this.actualTotalAmount = actualTotalAmount;
    }

    public String getFreightCharge() {
        return freightCharge;
    }

    public void setFreightCharge(String freightCharge) {
        this.freightCharge = freightCharge;
    }

    public String getPayModeId() {
        return payModeId;
    }

    public void setPayModeId(String payModeId) {
        this.payModeId = payModeId;
    }

    public Integer getSendCustomerId() {
        return sendCustomerId;
    }

    public void setSendCustomerId(Integer sendCustomerId) {
        this.sendCustomerId = sendCustomerId;
    }

    public Integer getVipCustomerId() {
        return vipCustomerId;
    }

    public void setVipCustomerId(Integer vipCustomerId) {
        this.vipCustomerId = vipCustomerId;
    }

    public String getExpressTime() {
        return expressTime;
    }

    public void setExpressTime(String expressTime) {
        this.expressTime = expressTime;
    }

    public Boolean getAccurateCheck() {
        return accurateCheck;
    }

    public void setAccurateCheck(Boolean accurateCheck) {
        this.accurateCheck = accurateCheck;
    }

    public Boolean getExclusiveCheck() {
        return exclusiveCheck;
    }

    public void setExclusiveCheck(Boolean exclusiveCheck) {
        this.exclusiveCheck = exclusiveCheck;
    }

    public String getRewbNo() {
        return rewbNo;
    }

    public void setRewbNo(String rewbNo) {
        this.rewbNo = rewbNo;
    }

    public Integer getSendReceiptFlag() {
        return sendReceiptFlag;
    }

    public void setSendReceiptFlag(Integer sendReceiptFlag) {
        this.sendReceiptFlag = sendReceiptFlag;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getVillagesFeeParamter() {
        return villagesFeeParamter;
    }

    public void setVillagesFeeParamter(String villagesFeeParamter) {
        this.villagesFeeParamter = villagesFeeParamter;
    }

    public String getPickStock() {
        return pickStock;
    }

    public void setPickStock(String pickStock) {
        this.pickStock = pickStock;
    }

    public String getEwbNo() {
        return ewbNo;
    }

    public void setEwbNo(String ewbNo) {
        this.ewbNo = ewbNo;
    }

    public Boolean getDzMainInput() {
        return dzMainInput;
    }

    public void setDzMainInput(Boolean dzMainInput) {
        this.dzMainInput = dzMainInput;
    }

    public String getTownSelf() {
        return townSelf;
    }

    public void setTownSelf(String townSelf) {
        this.townSelf = townSelf;
    }

    public String getDispatchSecondSiteId() {
        return dispatchSecondSiteId;
    }

    public void setDispatchSecondSiteId(String dispatchSecondSiteId) {
        this.dispatchSecondSiteId = dispatchSecondSiteId;
    }

    public Integer getMedicineService() {
        return medicineService;
    }

    public void setMedicineService(Integer medicineService) {
        this.medicineService = medicineService;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ZhongtongPriceQueryRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("receiveDest");
        sb.append('=');
        sb.append(((this.receiveDest == null) ? "<null>" : this.receiveDest));
        sb.append(',');
        sb.append("productType");
        sb.append('=');
        sb.append(((this.productType == null) ? "<null>" : this.productType));
        sb.append(',');
        sb.append("actualWeight");
        sb.append('=');
        sb.append(((this.actualWeight == null) ? "<null>" : this.actualWeight));
        sb.append(',');
        sb.append("goodsType");
        sb.append('=');
        sb.append(((this.goodsType == null) ? "<null>" : this.goodsType));
        sb.append(',');
        sb.append("goodsName");
        sb.append('=');
        sb.append(((this.goodsName == null) ? "<null>" : this.goodsName));
        sb.append(',');
        sb.append("sendDate");
        sb.append('=');
        sb.append(((this.sendDate == null) ? "<null>" : this.sendDate));
        sb.append(',');
        sb.append("volume");
        sb.append('=');
        sb.append(((this.volume == null) ? "<null>" : this.volume));
        sb.append(',');
        sb.append("pickUp");
        sb.append('=');
        sb.append(((this.pickUp == null) ? "<null>" : this.pickUp));
        sb.append(',');
        sb.append("customerVipFlag");
        sb.append('=');
        sb.append(((this.customerVipFlag == null) ? "<null>" : this.customerVipFlag));
        sb.append(',');
        sb.append("goodsCategory");
        sb.append('=');
        sb.append(((this.goodsCategory == null) ? "<null>" : this.goodsCategory));
        sb.append(',');
        sb.append("piece");
        sb.append('=');
        sb.append(((this.piece == null) ? "<null>" : this.piece));
        sb.append(',');
        sb.append("serviceAdd");
        sb.append('=');
        sb.append(((this.serviceAdd == null) ? "<null>" : this.serviceAdd));
        sb.append(',');
        sb.append("chkReturnFlag");
        sb.append('=');
        sb.append(((this.chkReturnFlag == null) ? "<null>" : this.chkReturnFlag));
        sb.append(',');
        sb.append("chkBackFlag");
        sb.append('=');
        sb.append(((this.chkBackFlag == null) ? "<null>" : this.chkBackFlag));
        sb.append(',');
        sb.append("cbxTown");
        sb.append('=');
        sb.append(((this.cbxTown == null) ? "<null>" : this.cbxTown));
        sb.append(',');
        sb.append("insuredAmount");
        sb.append('=');
        sb.append(((this.insuredAmount == null) ? "<null>" : this.insuredAmount));
        sb.append(',');
        sb.append("insuredScheme");
        sb.append('=');
        sb.append(((this.insuredScheme == null) ? "<null>" : this.insuredScheme));
        sb.append(',');
        sb.append("actualTotalAmount");
        sb.append('=');
        sb.append(((this.actualTotalAmount == null) ? "<null>" : this.actualTotalAmount));
        sb.append(',');
        sb.append("freightCharge");
        sb.append('=');
        sb.append(((this.freightCharge == null) ? "<null>" : this.freightCharge));
        sb.append(',');
        sb.append("payModeId");
        sb.append('=');
        sb.append(((this.payModeId == null) ? "<null>" : this.payModeId));
        sb.append(',');
        sb.append("sendCustomerId");
        sb.append('=');
        sb.append(((this.sendCustomerId == null) ? "<null>" : this.sendCustomerId));
        sb.append(',');
        sb.append("vipCustomerId");
        sb.append('=');
        sb.append(((this.vipCustomerId == null) ? "<null>" : this.vipCustomerId));
        sb.append(',');
        sb.append("expressTime");
        sb.append('=');
        sb.append(((this.expressTime == null) ? "<null>" : this.expressTime));
        sb.append(',');
        sb.append("accurateCheck");
        sb.append('=');
        sb.append(((this.accurateCheck == null) ? "<null>" : this.accurateCheck));
        sb.append(',');
        sb.append("exclusiveCheck");
        sb.append('=');
        sb.append(((this.exclusiveCheck == null) ? "<null>" : this.exclusiveCheck));
        sb.append(',');
        sb.append("rewbNo");
        sb.append('=');
        sb.append(((this.rewbNo == null) ? "<null>" : this.rewbNo));
        sb.append(',');
        sb.append("sendReceiptFlag");
        sb.append('=');
        sb.append(((this.sendReceiptFlag == null) ? "<null>" : this.sendReceiptFlag));
        sb.append(',');
        sb.append("shippingMethod");
        sb.append('=');
        sb.append(((this.shippingMethod == null) ? "<null>" : this.shippingMethod));
        sb.append(',');
        sb.append("villagesFeeParamter");
        sb.append('=');
        sb.append(((this.villagesFeeParamter == null) ? "<null>" : this.villagesFeeParamter));
        sb.append(',');
        sb.append("pickStock");
        sb.append('=');
        sb.append(((this.pickStock == null) ? "<null>" : this.pickStock));
        sb.append(',');
        sb.append("ewbNo");
        sb.append('=');
        sb.append(((this.ewbNo == null) ? "<null>" : this.ewbNo));
        sb.append(',');
        sb.append("dzMainInput");
        sb.append('=');
        sb.append(((this.dzMainInput == null) ? "<null>" : this.dzMainInput));
        sb.append(',');
        sb.append("townSelf");
        sb.append('=');
        sb.append(((this.townSelf == null) ? "<null>" : this.townSelf));
        sb.append(',');
        sb.append("dispatchSecondSiteId");
        sb.append('=');
        sb.append(((this.dispatchSecondSiteId == null) ? "<null>" : this.dispatchSecondSiteId));
        sb.append(',');
        sb.append("medicineService");
        sb.append('=');
        sb.append(((this.medicineService == null) ? "<null>" : this.medicineService));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null) ? "<null>" : this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.sendReceiptFlag == null) ? 0 : this.sendReceiptFlag.hashCode()));
        result = ((result * 31) + ((this.dzMainInput == null) ? 0 : this.dzMainInput.hashCode()));
        result = ((result * 31) + ((this.sendDate == null) ? 0 : this.sendDate.hashCode()));
        result = ((result * 31) + ((this.accurateCheck == null) ? 0 : this.accurateCheck.hashCode()));
        result = ((result * 31) + ((this.pickStock == null) ? 0 : this.pickStock.hashCode()));
        result = ((result * 31) + ((this.goodsCategory == null) ? 0 : this.goodsCategory.hashCode()));
        result = ((result * 31) + ((this.pickUp == null) ? 0 : this.pickUp.hashCode()));
        result = ((result * 31) + ((this.insuredScheme == null) ? 0 : this.insuredScheme.hashCode()));
        result = ((result * 31) + ((this.villagesFeeParamter == null) ? 0 : this.villagesFeeParamter.hashCode()));
        result = ((result * 31) + ((this.rewbNo == null) ? 0 : this.rewbNo.hashCode()));
        result = ((result * 31) + ((this.actualWeight == null) ? 0 : this.actualWeight.hashCode()));
        result = ((result * 31) + ((this.sendCustomerId == null) ? 0 : this.sendCustomerId.hashCode()));
        result = ((result * 31) + ((this.actualTotalAmount == null) ? 0 : this.actualTotalAmount.hashCode()));
        result = ((result * 31) + ((this.exclusiveCheck == null) ? 0 : this.exclusiveCheck.hashCode()));
        result = ((result * 31) + ((this.ewbNo == null) ? 0 : this.ewbNo.hashCode()));
        result = ((result * 31) + ((this.medicineService == null) ? 0 : this.medicineService.hashCode()));
        result = ((result * 31) + ((this.chkBackFlag == null) ? 0 : this.chkBackFlag.hashCode()));
        result = ((result * 31) + ((this.insuredAmount == null) ? 0 : this.insuredAmount.hashCode()));
        result = ((result * 31) + ((this.townSelf == null) ? 0 : this.townSelf.hashCode()));
        result = ((result * 31) + ((this.goodsName == null) ? 0 : this.goodsName.hashCode()));
        result = ((result * 31) + ((this.serviceAdd == null) ? 0 : this.serviceAdd.hashCode()));
        result = ((result * 31) + ((this.productType == null) ? 0 : this.productType.hashCode()));
        result = ((result * 31) + ((this.payModeId == null) ? 0 : this.payModeId.hashCode()));
        result = ((result * 31) + ((this.shippingMethod == null) ? 0 : this.shippingMethod.hashCode()));
        result = ((result * 31) + ((this.dispatchSecondSiteId == null) ? 0 : this.dispatchSecondSiteId.hashCode()));
        result = ((result * 31) + ((this.freightCharge == null) ? 0 : this.freightCharge.hashCode()));
        result = ((result * 31) + ((this.cbxTown == null) ? 0 : this.cbxTown.hashCode()));
        result = ((result * 31) + ((this.chkReturnFlag == null) ? 0 : this.chkReturnFlag.hashCode()));
        result = ((result * 31) + ((this.goodsType == null) ? 0 : this.goodsType.hashCode()));
        result = ((result * 31) + ((this.volume == null) ? 0 : this.volume.hashCode()));
        result = ((result * 31) + ((this.expressTime == null) ? 0 : this.expressTime.hashCode()));
        result = ((result * 31) + ((this.vipCustomerId == null) ? 0 : this.vipCustomerId.hashCode()));
        result = ((result * 31) + ((this.piece == null) ? 0 : this.piece.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.customerVipFlag == null) ? 0 : this.customerVipFlag.hashCode()));
        result = ((result * 31) + ((this.receiveDest == null) ? 0 : this.receiveDest.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ZhongtongPriceQueryRequest) == false) {
            return false;
        }
        ZhongtongPriceQueryRequest rhs = ((ZhongtongPriceQueryRequest) other);
        return (((((((((((((((((((((((((((((((((((((this.sendReceiptFlag == rhs.sendReceiptFlag) || ((this.sendReceiptFlag != null) && this.sendReceiptFlag.equals(rhs.sendReceiptFlag))) && ((this.dzMainInput == rhs.dzMainInput) || ((this.dzMainInput != null) && this.dzMainInput.equals(rhs.dzMainInput)))) && ((this.sendDate == rhs.sendDate) || ((this.sendDate != null) && this.sendDate.equals(rhs.sendDate)))) && ((this.accurateCheck == rhs.accurateCheck) || ((this.accurateCheck != null) && this.accurateCheck.equals(rhs.accurateCheck)))) && ((this.pickStock == rhs.pickStock) || ((this.pickStock != null) && this.pickStock.equals(rhs.pickStock)))) && ((this.goodsCategory == rhs.goodsCategory) || ((this.goodsCategory != null) && this.goodsCategory.equals(rhs.goodsCategory)))) && ((this.pickUp == rhs.pickUp) || ((this.pickUp != null) && this.pickUp.equals(rhs.pickUp)))) && ((this.insuredScheme == rhs.insuredScheme) || ((this.insuredScheme != null) && this.insuredScheme.equals(rhs.insuredScheme)))) && ((this.villagesFeeParamter == rhs.villagesFeeParamter) || ((this.villagesFeeParamter != null) && this.villagesFeeParamter.equals(rhs.villagesFeeParamter)))) && ((this.rewbNo == rhs.rewbNo) || ((this.rewbNo != null) && this.rewbNo.equals(rhs.rewbNo)))) && ((this.actualWeight == rhs.actualWeight) || ((this.actualWeight != null) && this.actualWeight.equals(rhs.actualWeight)))) && ((this.sendCustomerId == rhs.sendCustomerId) || ((this.sendCustomerId != null) && this.sendCustomerId.equals(rhs.sendCustomerId)))) && ((this.actualTotalAmount == rhs.actualTotalAmount) || ((this.actualTotalAmount != null) && this.actualTotalAmount.equals(rhs.actualTotalAmount)))) && ((this.exclusiveCheck == rhs.exclusiveCheck) || ((this.exclusiveCheck != null) && this.exclusiveCheck.equals(rhs.exclusiveCheck)))) && ((this.ewbNo == rhs.ewbNo) || ((this.ewbNo != null) && this.ewbNo.equals(rhs.ewbNo)))) && ((this.medicineService == rhs.medicineService) || ((this.medicineService != null) && this.medicineService.equals(rhs.medicineService)))) && ((this.chkBackFlag == rhs.chkBackFlag) || ((this.chkBackFlag != null) && this.chkBackFlag.equals(rhs.chkBackFlag)))) && ((this.insuredAmount == rhs.insuredAmount) || ((this.insuredAmount != null) && this.insuredAmount.equals(rhs.insuredAmount)))) && ((this.townSelf == rhs.townSelf) || ((this.townSelf != null) && this.townSelf.equals(rhs.townSelf)))) && ((this.goodsName == rhs.goodsName) || ((this.goodsName != null) && this.goodsName.equals(rhs.goodsName)))) && ((this.serviceAdd == rhs.serviceAdd) || ((this.serviceAdd != null) && this.serviceAdd.equals(rhs.serviceAdd)))) && ((this.productType == rhs.productType) || ((this.productType != null) && this.productType.equals(rhs.productType)))) && ((this.payModeId == rhs.payModeId) || ((this.payModeId != null) && this.payModeId.equals(rhs.payModeId)))) && ((this.shippingMethod == rhs.shippingMethod) || ((this.shippingMethod != null) && this.shippingMethod.equals(rhs.shippingMethod)))) && ((this.dispatchSecondSiteId == rhs.dispatchSecondSiteId) || ((this.dispatchSecondSiteId != null) && this.dispatchSecondSiteId.equals(rhs.dispatchSecondSiteId)))) && ((this.freightCharge == rhs.freightCharge) || ((this.freightCharge != null) && this.freightCharge.equals(rhs.freightCharge)))) && ((this.cbxTown == rhs.cbxTown) || ((this.cbxTown != null) && this.cbxTown.equals(rhs.cbxTown)))) && ((this.chkReturnFlag == rhs.chkReturnFlag) || ((this.chkReturnFlag != null) && this.chkReturnFlag.equals(rhs.chkReturnFlag)))) && ((this.goodsType == rhs.goodsType) || ((this.goodsType != null) && this.goodsType.equals(rhs.goodsType)))) && ((this.volume == rhs.volume) || ((this.volume != null) && this.volume.equals(rhs.volume)))) && ((this.expressTime == rhs.expressTime) || ((this.expressTime != null) && this.expressTime.equals(rhs.expressTime)))) && ((this.vipCustomerId == rhs.vipCustomerId) || ((this.vipCustomerId != null) && this.vipCustomerId.equals(rhs.vipCustomerId)))) && ((this.piece == rhs.piece) || ((this.piece != null) && this.piece.equals(rhs.piece)))) && ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties)))) && ((this.customerVipFlag == rhs.customerVipFlag) || ((this.customerVipFlag != null) && this.customerVipFlag.equals(rhs.customerVipFlag)))) && ((this.receiveDest == rhs.receiveDest) || ((this.receiveDest != null) && this.receiveDest.equals(rhs.receiveDest))));
    }

}
