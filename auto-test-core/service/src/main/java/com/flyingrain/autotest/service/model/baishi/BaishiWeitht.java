
package com.flyingrain.autotest.service.model.baishi;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class BaishiWeitht {

    private Double grossWeight;
    private Double feeWeight;
    private Integer productId;
    private String productName;
    private Double upstairsWeight;
    private Double siteFeeWeight;
    private Double standardFeeWeight;
    private Double standardGrossWeight;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Double getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(Double grossWeight) {
        this.grossWeight = grossWeight;
    }

    public Double getFeeWeight() {
        return feeWeight;
    }

    public void setFeeWeight(Double feeWeight) {
        this.feeWeight = feeWeight;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getUpstairsWeight() {
        return upstairsWeight;
    }

    public void setUpstairsWeight(Double upstairsWeight) {
        this.upstairsWeight = upstairsWeight;
    }

    public Double getSiteFeeWeight() {
        return siteFeeWeight;
    }

    public void setSiteFeeWeight(Double siteFeeWeight) {
        this.siteFeeWeight = siteFeeWeight;
    }

    public Double getStandardFeeWeight() {
        return standardFeeWeight;
    }

    public void setStandardFeeWeight(Double standardFeeWeight) {
        this.standardFeeWeight = standardFeeWeight;
    }

    public Double getStandardGrossWeight() {
        return standardGrossWeight;
    }

    public void setStandardGrossWeight(Double standardGrossWeight) {
        this.standardGrossWeight = standardGrossWeight;
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
        sb.append(BaishiWeitht.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("grossWeight");
        sb.append('=');
        sb.append(((this.grossWeight == null)?"<null>":this.grossWeight));
        sb.append(',');
        sb.append("feeWeight");
        sb.append('=');
        sb.append(((this.feeWeight == null)?"<null>":this.feeWeight));
        sb.append(',');
        sb.append("productId");
        sb.append('=');
        sb.append(((this.productId == null)?"<null>":this.productId));
        sb.append(',');
        sb.append("productName");
        sb.append('=');
        sb.append(((this.productName == null)?"<null>":this.productName));
        sb.append(',');
        sb.append("upstairsWeight");
        sb.append('=');
        sb.append(((this.upstairsWeight == null)?"<null>":this.upstairsWeight));
        sb.append(',');
        sb.append("siteFeeWeight");
        sb.append('=');
        sb.append(((this.siteFeeWeight == null)?"<null>":this.siteFeeWeight));
        sb.append(',');
        sb.append("standardFeeWeight");
        sb.append('=');
        sb.append(((this.standardFeeWeight == null)?"<null>":this.standardFeeWeight));
        sb.append(',');
        sb.append("standardGrossWeight");
        sb.append('=');
        sb.append(((this.standardGrossWeight == null)?"<null>":this.standardGrossWeight));
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
        result = ((result* 31)+((this.upstairsWeight == null)? 0 :this.upstairsWeight.hashCode()));
        result = ((result* 31)+((this.grossWeight == null)? 0 :this.grossWeight.hashCode()));
        result = ((result* 31)+((this.productId == null)? 0 :this.productId.hashCode()));
        result = ((result* 31)+((this.standardFeeWeight == null)? 0 :this.standardFeeWeight.hashCode()));
        result = ((result* 31)+((this.feeWeight == null)? 0 :this.feeWeight.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.siteFeeWeight == null)? 0 :this.siteFeeWeight.hashCode()));
        result = ((result* 31)+((this.standardGrossWeight == null)? 0 :this.standardGrossWeight.hashCode()));
        result = ((result* 31)+((this.productName == null)? 0 :this.productName.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BaishiWeitht) == false) {
            return false;
        }
        BaishiWeitht rhs = ((BaishiWeitht) other);
        return ((((((((((this.upstairsWeight == rhs.upstairsWeight)||((this.upstairsWeight!= null)&&this.upstairsWeight.equals(rhs.upstairsWeight)))&&((this.grossWeight == rhs.grossWeight)||((this.grossWeight!= null)&&this.grossWeight.equals(rhs.grossWeight))))&&((this.productId == rhs.productId)||((this.productId!= null)&&this.productId.equals(rhs.productId))))&&((this.standardFeeWeight == rhs.standardFeeWeight)||((this.standardFeeWeight!= null)&&this.standardFeeWeight.equals(rhs.standardFeeWeight))))&&((this.feeWeight == rhs.feeWeight)||((this.feeWeight!= null)&&this.feeWeight.equals(rhs.feeWeight))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.siteFeeWeight == rhs.siteFeeWeight)||((this.siteFeeWeight!= null)&&this.siteFeeWeight.equals(rhs.siteFeeWeight))))&&((this.standardGrossWeight == rhs.standardGrossWeight)||((this.standardGrossWeight!= null)&&this.standardGrossWeight.equals(rhs.standardGrossWeight))))&&((this.productName == rhs.productName)||((this.productName!= null)&&this.productName.equals(rhs.productName))));
    }

}
