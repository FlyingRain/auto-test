
package com.flyingrain.autotest.service.model.baishi.generate;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class SpecialArea {

    private Integer areaAddressId;
    private Integer specialAreaId;
    private String specialAreaName;
    private String standardAddress;
    private Boolean isSelfPickUp;
    private String chargesStandard;
    private Integer siteId;
    private String siteName;
    private String siteCode;
    private String remark;
    private String effectDate;
    private String expireDate;
    private Boolean isMatchUp;
    private String chargesMode;
    private Boolean ifRemind;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Integer getAreaAddressId() {
        return areaAddressId;
    }

    public void setAreaAddressId(Integer areaAddressId) {
        this.areaAddressId = areaAddressId;
    }

    public Integer getSpecialAreaId() {
        return specialAreaId;
    }

    public void setSpecialAreaId(Integer specialAreaId) {
        this.specialAreaId = specialAreaId;
    }

    public String getSpecialAreaName() {
        return specialAreaName;
    }

    public void setSpecialAreaName(String specialAreaName) {
        this.specialAreaName = specialAreaName;
    }

    public String getStandardAddress() {
        return standardAddress;
    }

    public void setStandardAddress(String standardAddress) {
        this.standardAddress = standardAddress;
    }

    public Boolean getIsSelfPickUp() {
        return isSelfPickUp;
    }

    public void setIsSelfPickUp(Boolean isSelfPickUp) {
        this.isSelfPickUp = isSelfPickUp;
    }

    public String getChargesStandard() {
        return chargesStandard;
    }

    public void setChargesStandard(String chargesStandard) {
        this.chargesStandard = chargesStandard;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(String effectDate) {
        this.effectDate = effectDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public Boolean getIsMatchUp() {
        return isMatchUp;
    }

    public void setIsMatchUp(Boolean isMatchUp) {
        this.isMatchUp = isMatchUp;
    }

    public String getChargesMode() {
        return chargesMode;
    }

    public void setChargesMode(String chargesMode) {
        this.chargesMode = chargesMode;
    }

    public Boolean getIfRemind() {
        return ifRemind;
    }

    public void setIfRemind(Boolean ifRemind) {
        this.ifRemind = ifRemind;
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
        sb.append(SpecialArea.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("areaAddressId");
        sb.append('=');
        sb.append(((this.areaAddressId == null)?"<null>":this.areaAddressId));
        sb.append(',');
        sb.append("specialAreaId");
        sb.append('=');
        sb.append(((this.specialAreaId == null)?"<null>":this.specialAreaId));
        sb.append(',');
        sb.append("specialAreaName");
        sb.append('=');
        sb.append(((this.specialAreaName == null)?"<null>":this.specialAreaName));
        sb.append(',');
        sb.append("standardAddress");
        sb.append('=');
        sb.append(((this.standardAddress == null)?"<null>":this.standardAddress));
        sb.append(',');
        sb.append("isSelfPickUp");
        sb.append('=');
        sb.append(((this.isSelfPickUp == null)?"<null>":this.isSelfPickUp));
        sb.append(',');
        sb.append("chargesStandard");
        sb.append('=');
        sb.append(((this.chargesStandard == null)?"<null>":this.chargesStandard));
        sb.append(',');
        sb.append("siteId");
        sb.append('=');
        sb.append(((this.siteId == null)?"<null>":this.siteId));
        sb.append(',');
        sb.append("siteName");
        sb.append('=');
        sb.append(((this.siteName == null)?"<null>":this.siteName));
        sb.append(',');
        sb.append("siteCode");
        sb.append('=');
        sb.append(((this.siteCode == null)?"<null>":this.siteCode));
        sb.append(',');
        sb.append("remark");
        sb.append('=');
        sb.append(((this.remark == null)?"<null>":this.remark));
        sb.append(',');
        sb.append("effectDate");
        sb.append('=');
        sb.append(((this.effectDate == null)?"<null>":this.effectDate));
        sb.append(',');
        sb.append("expireDate");
        sb.append('=');
        sb.append(((this.expireDate == null)?"<null>":this.expireDate));
        sb.append(',');
        sb.append("isMatchUp");
        sb.append('=');
        sb.append(((this.isMatchUp == null)?"<null>":this.isMatchUp));
        sb.append(',');
        sb.append("chargesMode");
        sb.append('=');
        sb.append(((this.chargesMode == null)?"<null>":this.chargesMode));
        sb.append(',');
        sb.append("ifRemind");
        sb.append('=');
        sb.append(((this.ifRemind == null)?"<null>":this.ifRemind));
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
        result = ((result* 31)+((this.areaAddressId == null)? 0 :this.areaAddressId.hashCode()));
        result = ((result* 31)+((this.effectDate == null)? 0 :this.effectDate.hashCode()));
        result = ((result* 31)+((this.siteCode == null)? 0 :this.siteCode.hashCode()));
        result = ((result* 31)+((this.standardAddress == null)? 0 :this.standardAddress.hashCode()));
        result = ((result* 31)+((this.ifRemind == null)? 0 :this.ifRemind.hashCode()));
        result = ((result* 31)+((this.siteName == null)? 0 :this.siteName.hashCode()));
        result = ((result* 31)+((this.remark == null)? 0 :this.remark.hashCode()));
        result = ((result* 31)+((this.chargesMode == null)? 0 :this.chargesMode.hashCode()));
        result = ((result* 31)+((this.isSelfPickUp == null)? 0 :this.isSelfPickUp.hashCode()));
        result = ((result* 31)+((this.specialAreaName == null)? 0 :this.specialAreaName.hashCode()));
        result = ((result* 31)+((this.chargesStandard == null)? 0 :this.chargesStandard.hashCode()));
        result = ((result* 31)+((this.siteId == null)? 0 :this.siteId.hashCode()));
        result = ((result* 31)+((this.isMatchUp == null)? 0 :this.isMatchUp.hashCode()));
        result = ((result* 31)+((this.expireDate == null)? 0 :this.expireDate.hashCode()));
        result = ((result* 31)+((this.specialAreaId == null)? 0 :this.specialAreaId.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SpecialArea) == false) {
            return false;
        }
        SpecialArea rhs = ((SpecialArea) other);
        return (((((((((((((((((this.areaAddressId == rhs.areaAddressId)||((this.areaAddressId!= null)&&this.areaAddressId.equals(rhs.areaAddressId)))&&((this.effectDate == rhs.effectDate)||((this.effectDate!= null)&&this.effectDate.equals(rhs.effectDate))))&&((this.siteCode == rhs.siteCode)||((this.siteCode!= null)&&this.siteCode.equals(rhs.siteCode))))&&((this.standardAddress == rhs.standardAddress)||((this.standardAddress!= null)&&this.standardAddress.equals(rhs.standardAddress))))&&((this.ifRemind == rhs.ifRemind)||((this.ifRemind!= null)&&this.ifRemind.equals(rhs.ifRemind))))&&((this.siteName == rhs.siteName)||((this.siteName!= null)&&this.siteName.equals(rhs.siteName))))&&((this.remark == rhs.remark)||((this.remark!= null)&&this.remark.equals(rhs.remark))))&&((this.chargesMode == rhs.chargesMode)||((this.chargesMode!= null)&&this.chargesMode.equals(rhs.chargesMode))))&&((this.isSelfPickUp == rhs.isSelfPickUp)||((this.isSelfPickUp!= null)&&this.isSelfPickUp.equals(rhs.isSelfPickUp))))&&((this.specialAreaName == rhs.specialAreaName)||((this.specialAreaName!= null)&&this.specialAreaName.equals(rhs.specialAreaName))))&&((this.chargesStandard == rhs.chargesStandard)||((this.chargesStandard!= null)&&this.chargesStandard.equals(rhs.chargesStandard))))&&((this.siteId == rhs.siteId)||((this.siteId!= null)&&this.siteId.equals(rhs.siteId))))&&((this.isMatchUp == rhs.isMatchUp)||((this.isMatchUp!= null)&&this.isMatchUp.equals(rhs.isMatchUp))))&&((this.expireDate == rhs.expireDate)||((this.expireDate!= null)&&this.expireDate.equals(rhs.expireDate))))&&((this.specialAreaId == rhs.specialAreaId)||((this.specialAreaId!= null)&&this.specialAreaId.equals(rhs.specialAreaId))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
