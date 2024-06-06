
package com.flyingrain.autotest.service.model.zhongtong.generate;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class TownEntity {

    private Integer countyId;
    private Integer createdBy;
    private Object createdTime;
    private Integer deliveryDistance;
    private Integer modifiedBy;
    private Object modifiedTime;
    private String overallFlag;
    private String pickUp;
    private String postcode;
    private Integer rdStatus;
    private Integer reach;
    private String remark;
    private Integer siteId;
    private String townCode;
    private Integer townId;
    private String townLocation;
    private String townName;
    private Integer townOrder;
    private String townPinyin;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Integer getCountyId() {
        return countyId;
    }

    public void setCountyId(Integer countyId) {
        this.countyId = countyId;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Object getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Object createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getDeliveryDistance() {
        return deliveryDistance;
    }

    public void setDeliveryDistance(Integer deliveryDistance) {
        this.deliveryDistance = deliveryDistance;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Object getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Object modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getOverallFlag() {
        return overallFlag;
    }

    public void setOverallFlag(String overallFlag) {
        this.overallFlag = overallFlag;
    }

    public String getPickUp() {
        return pickUp;
    }

    public void setPickUp(String pickUp) {
        this.pickUp = pickUp;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Integer getRdStatus() {
        return rdStatus;
    }

    public void setRdStatus(Integer rdStatus) {
        this.rdStatus = rdStatus;
    }

    public Integer getReach() {
        return reach;
    }

    public void setReach(Integer reach) {
        this.reach = reach;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getTownCode() {
        return townCode;
    }

    public void setTownCode(String townCode) {
        this.townCode = townCode;
    }

    public Integer getTownId() {
        return townId;
    }

    public void setTownId(Integer townId) {
        this.townId = townId;
    }

    public String getTownLocation() {
        return townLocation;
    }

    public void setTownLocation(String townLocation) {
        this.townLocation = townLocation;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public Integer getTownOrder() {
        return townOrder;
    }

    public void setTownOrder(Integer townOrder) {
        this.townOrder = townOrder;
    }

    public String getTownPinyin() {
        return townPinyin;
    }

    public void setTownPinyin(String townPinyin) {
        this.townPinyin = townPinyin;
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
        sb.append(TownEntity.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("countyId");
        sb.append('=');
        sb.append(((this.countyId == null)?"<null>":this.countyId));
        sb.append(',');
        sb.append("createdBy");
        sb.append('=');
        sb.append(((this.createdBy == null)?"<null>":this.createdBy));
        sb.append(',');
        sb.append("createdTime");
        sb.append('=');
        sb.append(((this.createdTime == null)?"<null>":this.createdTime));
        sb.append(',');
        sb.append("deliveryDistance");
        sb.append('=');
        sb.append(((this.deliveryDistance == null)?"<null>":this.deliveryDistance));
        sb.append(',');
        sb.append("modifiedBy");
        sb.append('=');
        sb.append(((this.modifiedBy == null)?"<null>":this.modifiedBy));
        sb.append(',');
        sb.append("modifiedTime");
        sb.append('=');
        sb.append(((this.modifiedTime == null)?"<null>":this.modifiedTime));
        sb.append(',');
        sb.append("overallFlag");
        sb.append('=');
        sb.append(((this.overallFlag == null)?"<null>":this.overallFlag));
        sb.append(',');
        sb.append("pickUp");
        sb.append('=');
        sb.append(((this.pickUp == null)?"<null>":this.pickUp));
        sb.append(',');
        sb.append("postcode");
        sb.append('=');
        sb.append(((this.postcode == null)?"<null>":this.postcode));
        sb.append(',');
        sb.append("rdStatus");
        sb.append('=');
        sb.append(((this.rdStatus == null)?"<null>":this.rdStatus));
        sb.append(',');
        sb.append("reach");
        sb.append('=');
        sb.append(((this.reach == null)?"<null>":this.reach));
        sb.append(',');
        sb.append("remark");
        sb.append('=');
        sb.append(((this.remark == null)?"<null>":this.remark));
        sb.append(',');
        sb.append("siteId");
        sb.append('=');
        sb.append(((this.siteId == null)?"<null>":this.siteId));
        sb.append(',');
        sb.append("townCode");
        sb.append('=');
        sb.append(((this.townCode == null)?"<null>":this.townCode));
        sb.append(',');
        sb.append("townId");
        sb.append('=');
        sb.append(((this.townId == null)?"<null>":this.townId));
        sb.append(',');
        sb.append("townLocation");
        sb.append('=');
        sb.append(((this.townLocation == null)?"<null>":this.townLocation));
        sb.append(',');
        sb.append("townName");
        sb.append('=');
        sb.append(((this.townName == null)?"<null>":this.townName));
        sb.append(',');
        sb.append("townOrder");
        sb.append('=');
        sb.append(((this.townOrder == null)?"<null>":this.townOrder));
        sb.append(',');
        sb.append("townPinyin");
        sb.append('=');
        sb.append(((this.townPinyin == null)?"<null>":this.townPinyin));
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
        result = ((result* 31)+((this.modifiedTime == null)? 0 :this.modifiedTime.hashCode()));
        result = ((result* 31)+((this.townName == null)? 0 :this.townName.hashCode()));
        result = ((result* 31)+((this.rdStatus == null)? 0 :this.rdStatus.hashCode()));
        result = ((result* 31)+((this.townCode == null)? 0 :this.townCode.hashCode()));
        result = ((result* 31)+((this.deliveryDistance == null)? 0 :this.deliveryDistance.hashCode()));
        result = ((result* 31)+((this.reach == null)? 0 :this.reach.hashCode()));
        result = ((result* 31)+((this.postcode == null)? 0 :this.postcode.hashCode()));
        result = ((result* 31)+((this.pickUp == null)? 0 :this.pickUp.hashCode()));
        result = ((result* 31)+((this.remark == null)? 0 :this.remark.hashCode()));
        result = ((result* 31)+((this.townId == null)? 0 :this.townId.hashCode()));
        result = ((result* 31)+((this.townPinyin == null)? 0 :this.townPinyin.hashCode()));
        result = ((result* 31)+((this.townOrder == null)? 0 :this.townOrder.hashCode()));
        result = ((result* 31)+((this.createdBy == null)? 0 :this.createdBy.hashCode()));
        result = ((result* 31)+((this.countyId == null)? 0 :this.countyId.hashCode()));
        result = ((result* 31)+((this.createdTime == null)? 0 :this.createdTime.hashCode()));
        result = ((result* 31)+((this.siteId == null)? 0 :this.siteId.hashCode()));
        result = ((result* 31)+((this.modifiedBy == null)? 0 :this.modifiedBy.hashCode()));
        result = ((result* 31)+((this.townLocation == null)? 0 :this.townLocation.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.overallFlag == null)? 0 :this.overallFlag.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TownEntity) == false) {
            return false;
        }
        TownEntity rhs = ((TownEntity) other);
        return (((((((((((((((((((((this.modifiedTime == rhs.modifiedTime)||((this.modifiedTime!= null)&&this.modifiedTime.equals(rhs.modifiedTime)))&&((this.townName == rhs.townName)||((this.townName!= null)&&this.townName.equals(rhs.townName))))&&((this.rdStatus == rhs.rdStatus)||((this.rdStatus!= null)&&this.rdStatus.equals(rhs.rdStatus))))&&((this.townCode == rhs.townCode)||((this.townCode!= null)&&this.townCode.equals(rhs.townCode))))&&((this.deliveryDistance == rhs.deliveryDistance)||((this.deliveryDistance!= null)&&this.deliveryDistance.equals(rhs.deliveryDistance))))&&((this.reach == rhs.reach)||((this.reach!= null)&&this.reach.equals(rhs.reach))))&&((this.postcode == rhs.postcode)||((this.postcode!= null)&&this.postcode.equals(rhs.postcode))))&&((this.pickUp == rhs.pickUp)||((this.pickUp!= null)&&this.pickUp.equals(rhs.pickUp))))&&((this.remark == rhs.remark)||((this.remark!= null)&&this.remark.equals(rhs.remark))))&&((this.townId == rhs.townId)||((this.townId!= null)&&this.townId.equals(rhs.townId))))&&((this.townPinyin == rhs.townPinyin)||((this.townPinyin!= null)&&this.townPinyin.equals(rhs.townPinyin))))&&((this.townOrder == rhs.townOrder)||((this.townOrder!= null)&&this.townOrder.equals(rhs.townOrder))))&&((this.createdBy == rhs.createdBy)||((this.createdBy!= null)&&this.createdBy.equals(rhs.createdBy))))&&((this.countyId == rhs.countyId)||((this.countyId!= null)&&this.countyId.equals(rhs.countyId))))&&((this.createdTime == rhs.createdTime)||((this.createdTime!= null)&&this.createdTime.equals(rhs.createdTime))))&&((this.siteId == rhs.siteId)||((this.siteId!= null)&&this.siteId.equals(rhs.siteId))))&&((this.modifiedBy == rhs.modifiedBy)||((this.modifiedBy!= null)&&this.modifiedBy.equals(rhs.modifiedBy))))&&((this.townLocation == rhs.townLocation)||((this.townLocation!= null)&&this.townLocation.equals(rhs.townLocation))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.overallFlag == rhs.overallFlag)||((this.overallFlag!= null)&&this.overallFlag.equals(rhs.overallFlag))));
    }

}
