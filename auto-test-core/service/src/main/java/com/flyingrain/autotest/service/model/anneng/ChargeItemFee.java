
package com.flyingrain.autotest.service.model.anneng;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class ChargeItemFee {

    private Integer chargeItemId;
    private String chargeItemAbbreviation;
    private String paramOutputOrder;
    private Integer amount;
    private Integer transType;
    private Object childrenResponse;
    private Integer getQuoteFlag;
    private String feeName;
    private String billType;
    private String displayClassification;
    private Integer classificationSort;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Integer getChargeItemId() {
        return chargeItemId;
    }

    public void setChargeItemId(Integer chargeItemId) {
        this.chargeItemId = chargeItemId;
    }

    public String getChargeItemAbbreviation() {
        return chargeItemAbbreviation;
    }

    public void setChargeItemAbbreviation(String chargeItemAbbreviation) {
        this.chargeItemAbbreviation = chargeItemAbbreviation;
    }

    public String getParamOutputOrder() {
        return paramOutputOrder;
    }

    public void setParamOutputOrder(String paramOutputOrder) {
        this.paramOutputOrder = paramOutputOrder;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getTransType() {
        return transType;
    }

    public void setTransType(Integer transType) {
        this.transType = transType;
    }

    public Object getChildrenResponse() {
        return childrenResponse;
    }

    public void setChildrenResponse(Object childrenResponse) {
        this.childrenResponse = childrenResponse;
    }

    public Integer getGetQuoteFlag() {
        return getQuoteFlag;
    }

    public void setGetQuoteFlag(Integer getQuoteFlag) {
        this.getQuoteFlag = getQuoteFlag;
    }

    public String getFeeName() {
        return feeName;
    }

    public void setFeeName(String feeName) {
        this.feeName = feeName;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getDisplayClassification() {
        return displayClassification;
    }

    public void setDisplayClassification(String displayClassification) {
        this.displayClassification = displayClassification;
    }

    public Integer getClassificationSort() {
        return classificationSort;
    }

    public void setClassificationSort(Integer classificationSort) {
        this.classificationSort = classificationSort;
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
        sb.append(ChargeItemFee.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("chargeItemId");
        sb.append('=');
        sb.append(((this.chargeItemId == null)?"<null>":this.chargeItemId));
        sb.append(',');
        sb.append("chargeItemAbbreviation");
        sb.append('=');
        sb.append(((this.chargeItemAbbreviation == null)?"<null>":this.chargeItemAbbreviation));
        sb.append(',');
        sb.append("paramOutputOrder");
        sb.append('=');
        sb.append(((this.paramOutputOrder == null)?"<null>":this.paramOutputOrder));
        sb.append(',');
        sb.append("amount");
        sb.append('=');
        sb.append(((this.amount == null)?"<null>":this.amount));
        sb.append(',');
        sb.append("transType");
        sb.append('=');
        sb.append(((this.transType == null)?"<null>":this.transType));
        sb.append(',');
        sb.append("childrenResponse");
        sb.append('=');
        sb.append(((this.childrenResponse == null)?"<null>":this.childrenResponse));
        sb.append(',');
        sb.append("getQuoteFlag");
        sb.append('=');
        sb.append(((this.getQuoteFlag == null)?"<null>":this.getQuoteFlag));
        sb.append(',');
        sb.append("feeName");
        sb.append('=');
        sb.append(((this.feeName == null)?"<null>":this.feeName));
        sb.append(',');
        sb.append("billType");
        sb.append('=');
        sb.append(((this.billType == null)?"<null>":this.billType));
        sb.append(',');
        sb.append("displayClassification");
        sb.append('=');
        sb.append(((this.displayClassification == null)?"<null>":this.displayClassification));
        sb.append(',');
        sb.append("classificationSort");
        sb.append('=');
        sb.append(((this.classificationSort == null)?"<null>":this.classificationSort));
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
        result = ((result* 31)+((this.amount == null)? 0 :this.amount.hashCode()));
        result = ((result* 31)+((this.paramOutputOrder == null)? 0 :this.paramOutputOrder.hashCode()));
        result = ((result* 31)+((this.billType == null)? 0 :this.billType.hashCode()));
        result = ((result* 31)+((this.classificationSort == null)? 0 :this.classificationSort.hashCode()));
        result = ((result* 31)+((this.getQuoteFlag == null)? 0 :this.getQuoteFlag.hashCode()));
        result = ((result* 31)+((this.transType == null)? 0 :this.transType.hashCode()));
        result = ((result* 31)+((this.chargeItemAbbreviation == null)? 0 :this.chargeItemAbbreviation.hashCode()));
        result = ((result* 31)+((this.feeName == null)? 0 :this.feeName.hashCode()));
        result = ((result* 31)+((this.chargeItemId == null)? 0 :this.chargeItemId.hashCode()));
        result = ((result* 31)+((this.childrenResponse == null)? 0 :this.childrenResponse.hashCode()));
        result = ((result* 31)+((this.displayClassification == null)? 0 :this.displayClassification.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ChargeItemFee) == false) {
            return false;
        }
        ChargeItemFee rhs = ((ChargeItemFee) other);
        return (((((((((((((this.amount == rhs.amount)||((this.amount!= null)&&this.amount.equals(rhs.amount)))&&((this.paramOutputOrder == rhs.paramOutputOrder)||((this.paramOutputOrder!= null)&&this.paramOutputOrder.equals(rhs.paramOutputOrder))))&&((this.billType == rhs.billType)||((this.billType!= null)&&this.billType.equals(rhs.billType))))&&((this.classificationSort == rhs.classificationSort)||((this.classificationSort!= null)&&this.classificationSort.equals(rhs.classificationSort))))&&((this.getQuoteFlag == rhs.getQuoteFlag)||((this.getQuoteFlag!= null)&&this.getQuoteFlag.equals(rhs.getQuoteFlag))))&&((this.transType == rhs.transType)||((this.transType!= null)&&this.transType.equals(rhs.transType))))&&((this.chargeItemAbbreviation == rhs.chargeItemAbbreviation)||((this.chargeItemAbbreviation!= null)&&this.chargeItemAbbreviation.equals(rhs.chargeItemAbbreviation))))&&((this.feeName == rhs.feeName)||((this.feeName!= null)&&this.feeName.equals(rhs.feeName))))&&((this.chargeItemId == rhs.chargeItemId)||((this.chargeItemId!= null)&&this.chargeItemId.equals(rhs.chargeItemId))))&&((this.childrenResponse == rhs.childrenResponse)||((this.childrenResponse!= null)&&this.childrenResponse.equals(rhs.childrenResponse))))&&((this.displayClassification == rhs.displayClassification)||((this.displayClassification!= null)&&this.displayClassification.equals(rhs.displayClassification))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
