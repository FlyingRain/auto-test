
package com.flyingrain.autotest.service.model.anneng;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class ResultInfo {

    private List<ChargeItemFee> chargeItemFeeList = new ArrayList<ChargeItemFee>();
    private Object priceTypeMap;
    private Double transAmountDiscountNum;
    private Integer transferFeeOriginalFirstPrice;
    private Integer transferFeeOriginalRenewalPrice;
    private Integer transferFeeDiscountFirstPrice;
    private Integer transferFeeDiscountRenewalPrice;
    private Integer sendInFeeOriginalFirstPrice;
    private Integer sendInFeeOriginalRenewalPrice;
    private Integer operationFeeOriginalFirstPrice;
    private Integer operationFeeOriginalRenewalPrice;
    private Integer operationFeeDiscountFirstPrice;
    private Integer operationFeeDiscountRenewalPrice;
    private Object chargeItemFeeMap;
    private Double totalFee;
    private List<AmountInfo> amountInfos = new ArrayList<AmountInfo>();
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public List<ChargeItemFee> getChargeItemFeeList() {
        return chargeItemFeeList;
    }

    public void setChargeItemFeeList(List<ChargeItemFee> chargeItemFeeList) {
        this.chargeItemFeeList = chargeItemFeeList;
    }

    public Object getPriceTypeMap() {
        return priceTypeMap;
    }

    public void setPriceTypeMap(Object priceTypeMap) {
        this.priceTypeMap = priceTypeMap;
    }

    public Double getTransAmountDiscountNum() {
        return transAmountDiscountNum;
    }

    public void setTransAmountDiscountNum(Double transAmountDiscountNum) {
        this.transAmountDiscountNum = transAmountDiscountNum;
    }

    public Integer getTransferFeeOriginalFirstPrice() {
        return transferFeeOriginalFirstPrice;
    }

    public void setTransferFeeOriginalFirstPrice(Integer transferFeeOriginalFirstPrice) {
        this.transferFeeOriginalFirstPrice = transferFeeOriginalFirstPrice;
    }

    public Integer getTransferFeeOriginalRenewalPrice() {
        return transferFeeOriginalRenewalPrice;
    }

    public void setTransferFeeOriginalRenewalPrice(Integer transferFeeOriginalRenewalPrice) {
        this.transferFeeOriginalRenewalPrice = transferFeeOriginalRenewalPrice;
    }

    public Integer getTransferFeeDiscountFirstPrice() {
        return transferFeeDiscountFirstPrice;
    }

    public void setTransferFeeDiscountFirstPrice(Integer transferFeeDiscountFirstPrice) {
        this.transferFeeDiscountFirstPrice = transferFeeDiscountFirstPrice;
    }

    public Integer getTransferFeeDiscountRenewalPrice() {
        return transferFeeDiscountRenewalPrice;
    }

    public void setTransferFeeDiscountRenewalPrice(Integer transferFeeDiscountRenewalPrice) {
        this.transferFeeDiscountRenewalPrice = transferFeeDiscountRenewalPrice;
    }

    public Integer getSendInFeeOriginalFirstPrice() {
        return sendInFeeOriginalFirstPrice;
    }

    public void setSendInFeeOriginalFirstPrice(Integer sendInFeeOriginalFirstPrice) {
        this.sendInFeeOriginalFirstPrice = sendInFeeOriginalFirstPrice;
    }

    public Integer getSendInFeeOriginalRenewalPrice() {
        return sendInFeeOriginalRenewalPrice;
    }

    public void setSendInFeeOriginalRenewalPrice(Integer sendInFeeOriginalRenewalPrice) {
        this.sendInFeeOriginalRenewalPrice = sendInFeeOriginalRenewalPrice;
    }

    public Integer getOperationFeeOriginalFirstPrice() {
        return operationFeeOriginalFirstPrice;
    }

    public void setOperationFeeOriginalFirstPrice(Integer operationFeeOriginalFirstPrice) {
        this.operationFeeOriginalFirstPrice = operationFeeOriginalFirstPrice;
    }

    public Integer getOperationFeeOriginalRenewalPrice() {
        return operationFeeOriginalRenewalPrice;
    }

    public void setOperationFeeOriginalRenewalPrice(Integer operationFeeOriginalRenewalPrice) {
        this.operationFeeOriginalRenewalPrice = operationFeeOriginalRenewalPrice;
    }

    public Integer getOperationFeeDiscountFirstPrice() {
        return operationFeeDiscountFirstPrice;
    }

    public void setOperationFeeDiscountFirstPrice(Integer operationFeeDiscountFirstPrice) {
        this.operationFeeDiscountFirstPrice = operationFeeDiscountFirstPrice;
    }

    public Integer getOperationFeeDiscountRenewalPrice() {
        return operationFeeDiscountRenewalPrice;
    }

    public void setOperationFeeDiscountRenewalPrice(Integer operationFeeDiscountRenewalPrice) {
        this.operationFeeDiscountRenewalPrice = operationFeeDiscountRenewalPrice;
    }

    public Object getChargeItemFeeMap() {
        return chargeItemFeeMap;
    }

    public void setChargeItemFeeMap(Object chargeItemFeeMap) {
        this.chargeItemFeeMap = chargeItemFeeMap;
    }

    public Double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Double totalFee) {
        this.totalFee = totalFee;
    }

    public List<AmountInfo> getAmountInfos() {
        return amountInfos;
    }

    public void setAmountInfos(List<AmountInfo> amountInfos) {
        this.amountInfos = amountInfos;
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
        sb.append(ResultInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("chargeItemFeeList");
        sb.append('=');
        sb.append(((this.chargeItemFeeList == null)?"<null>":this.chargeItemFeeList));
        sb.append(',');
        sb.append("priceTypeMap");
        sb.append('=');
        sb.append(((this.priceTypeMap == null)?"<null>":this.priceTypeMap));
        sb.append(',');
        sb.append("transAmountDiscountNum");
        sb.append('=');
        sb.append(((this.transAmountDiscountNum == null)?"<null>":this.transAmountDiscountNum));
        sb.append(',');
        sb.append("transferFeeOriginalFirstPrice");
        sb.append('=');
        sb.append(((this.transferFeeOriginalFirstPrice == null)?"<null>":this.transferFeeOriginalFirstPrice));
        sb.append(',');
        sb.append("transferFeeOriginalRenewalPrice");
        sb.append('=');
        sb.append(((this.transferFeeOriginalRenewalPrice == null)?"<null>":this.transferFeeOriginalRenewalPrice));
        sb.append(',');
        sb.append("transferFeeDiscountFirstPrice");
        sb.append('=');
        sb.append(((this.transferFeeDiscountFirstPrice == null)?"<null>":this.transferFeeDiscountFirstPrice));
        sb.append(',');
        sb.append("transferFeeDiscountRenewalPrice");
        sb.append('=');
        sb.append(((this.transferFeeDiscountRenewalPrice == null)?"<null>":this.transferFeeDiscountRenewalPrice));
        sb.append(',');
        sb.append("sendInFeeOriginalFirstPrice");
        sb.append('=');
        sb.append(((this.sendInFeeOriginalFirstPrice == null)?"<null>":this.sendInFeeOriginalFirstPrice));
        sb.append(',');
        sb.append("sendInFeeOriginalRenewalPrice");
        sb.append('=');
        sb.append(((this.sendInFeeOriginalRenewalPrice == null)?"<null>":this.sendInFeeOriginalRenewalPrice));
        sb.append(',');
        sb.append("operationFeeOriginalFirstPrice");
        sb.append('=');
        sb.append(((this.operationFeeOriginalFirstPrice == null)?"<null>":this.operationFeeOriginalFirstPrice));
        sb.append(',');
        sb.append("operationFeeOriginalRenewalPrice");
        sb.append('=');
        sb.append(((this.operationFeeOriginalRenewalPrice == null)?"<null>":this.operationFeeOriginalRenewalPrice));
        sb.append(',');
        sb.append("operationFeeDiscountFirstPrice");
        sb.append('=');
        sb.append(((this.operationFeeDiscountFirstPrice == null)?"<null>":this.operationFeeDiscountFirstPrice));
        sb.append(',');
        sb.append("operationFeeDiscountRenewalPrice");
        sb.append('=');
        sb.append(((this.operationFeeDiscountRenewalPrice == null)?"<null>":this.operationFeeDiscountRenewalPrice));
        sb.append(',');
        sb.append("chargeItemFeeMap");
        sb.append('=');
        sb.append(((this.chargeItemFeeMap == null)?"<null>":this.chargeItemFeeMap));
        sb.append(',');
        sb.append("totalFee");
        sb.append('=');
        sb.append(((this.totalFee == null)?"<null>":this.totalFee));
        sb.append(',');
        sb.append("amountInfos");
        sb.append('=');
        sb.append(((this.amountInfos == null)?"<null>":this.amountInfos));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.sendInFeeOriginalFirstPrice == null)? 0 :this.sendInFeeOriginalFirstPrice.hashCode()));
        result = ((result* 31)+((this.transferFeeDiscountRenewalPrice == null)? 0 :this.transferFeeDiscountRenewalPrice.hashCode()));
        result = ((result* 31)+((this.priceTypeMap == null)? 0 :this.priceTypeMap.hashCode()));
        result = ((result* 31)+((this.sendInFeeOriginalRenewalPrice == null)? 0 :this.sendInFeeOriginalRenewalPrice.hashCode()));
        result = ((result* 31)+((this.operationFeeDiscountRenewalPrice == null)? 0 :this.operationFeeDiscountRenewalPrice.hashCode()));
        result = ((result* 31)+((this.operationFeeDiscountFirstPrice == null)? 0 :this.operationFeeDiscountFirstPrice.hashCode()));
        result = ((result* 31)+((this.transferFeeOriginalRenewalPrice == null)? 0 :this.transferFeeOriginalRenewalPrice.hashCode()));
        result = ((result* 31)+((this.transferFeeOriginalFirstPrice == null)? 0 :this.transferFeeOriginalFirstPrice.hashCode()));
        result = ((result* 31)+((this.operationFeeOriginalFirstPrice == null)? 0 :this.operationFeeOriginalFirstPrice.hashCode()));
        result = ((result* 31)+((this.totalFee == null)? 0 :this.totalFee.hashCode()));
        result = ((result* 31)+((this.amountInfos == null)? 0 :this.amountInfos.hashCode()));
        result = ((result* 31)+((this.chargeItemFeeMap == null)? 0 :this.chargeItemFeeMap.hashCode()));
        result = ((result* 31)+((this.chargeItemFeeList == null)? 0 :this.chargeItemFeeList.hashCode()));
        result = ((result* 31)+((this.transAmountDiscountNum == null)? 0 :this.transAmountDiscountNum.hashCode()));
        result = ((result* 31)+((this.transferFeeDiscountFirstPrice == null)? 0 :this.transferFeeDiscountFirstPrice.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.operationFeeOriginalRenewalPrice == null)? 0 :this.operationFeeOriginalRenewalPrice.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ResultInfo) == false) {
            return false;
        }
        ResultInfo rhs = ((ResultInfo) other);
        return ((((((((((((((((((this.sendInFeeOriginalFirstPrice == rhs.sendInFeeOriginalFirstPrice)||((this.sendInFeeOriginalFirstPrice!= null)&&this.sendInFeeOriginalFirstPrice.equals(rhs.sendInFeeOriginalFirstPrice)))&&((this.transferFeeDiscountRenewalPrice == rhs.transferFeeDiscountRenewalPrice)||((this.transferFeeDiscountRenewalPrice!= null)&&this.transferFeeDiscountRenewalPrice.equals(rhs.transferFeeDiscountRenewalPrice))))&&((this.priceTypeMap == rhs.priceTypeMap)||((this.priceTypeMap!= null)&&this.priceTypeMap.equals(rhs.priceTypeMap))))&&((this.sendInFeeOriginalRenewalPrice == rhs.sendInFeeOriginalRenewalPrice)||((this.sendInFeeOriginalRenewalPrice!= null)&&this.sendInFeeOriginalRenewalPrice.equals(rhs.sendInFeeOriginalRenewalPrice))))&&((this.operationFeeDiscountRenewalPrice == rhs.operationFeeDiscountRenewalPrice)||((this.operationFeeDiscountRenewalPrice!= null)&&this.operationFeeDiscountRenewalPrice.equals(rhs.operationFeeDiscountRenewalPrice))))&&((this.operationFeeDiscountFirstPrice == rhs.operationFeeDiscountFirstPrice)||((this.operationFeeDiscountFirstPrice!= null)&&this.operationFeeDiscountFirstPrice.equals(rhs.operationFeeDiscountFirstPrice))))&&((this.transferFeeOriginalRenewalPrice == rhs.transferFeeOriginalRenewalPrice)||((this.transferFeeOriginalRenewalPrice!= null)&&this.transferFeeOriginalRenewalPrice.equals(rhs.transferFeeOriginalRenewalPrice))))&&((this.transferFeeOriginalFirstPrice == rhs.transferFeeOriginalFirstPrice)||((this.transferFeeOriginalFirstPrice!= null)&&this.transferFeeOriginalFirstPrice.equals(rhs.transferFeeOriginalFirstPrice))))&&((this.operationFeeOriginalFirstPrice == rhs.operationFeeOriginalFirstPrice)||((this.operationFeeOriginalFirstPrice!= null)&&this.operationFeeOriginalFirstPrice.equals(rhs.operationFeeOriginalFirstPrice))))&&((this.totalFee == rhs.totalFee)||((this.totalFee!= null)&&this.totalFee.equals(rhs.totalFee))))&&((this.amountInfos == rhs.amountInfos)||((this.amountInfos!= null)&&this.amountInfos.equals(rhs.amountInfos))))&&((this.chargeItemFeeMap == rhs.chargeItemFeeMap)||((this.chargeItemFeeMap!= null)&&this.chargeItemFeeMap.equals(rhs.chargeItemFeeMap))))&&((this.chargeItemFeeList == rhs.chargeItemFeeList)||((this.chargeItemFeeList!= null)&&this.chargeItemFeeList.equals(rhs.chargeItemFeeList))))&&((this.transAmountDiscountNum == rhs.transAmountDiscountNum)||((this.transAmountDiscountNum!= null)&&this.transAmountDiscountNum.equals(rhs.transAmountDiscountNum))))&&((this.transferFeeDiscountFirstPrice == rhs.transferFeeDiscountFirstPrice)||((this.transferFeeDiscountFirstPrice!= null)&&this.transferFeeDiscountFirstPrice.equals(rhs.transferFeeDiscountFirstPrice))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.operationFeeOriginalRenewalPrice == rhs.operationFeeOriginalRenewalPrice)||((this.operationFeeOriginalRenewalPrice!= null)&&this.operationFeeOriginalRenewalPrice.equals(rhs.operationFeeOriginalRenewalPrice))));
    }

}
