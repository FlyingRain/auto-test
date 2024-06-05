
package com.flyingrain.autotest.service.model.zhongtong;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class TownDeliveryInfo {

    private String firstTimeliness;
    private String allDeliveryArea;
    private String townName;
    private String districtName;
    private String deliveryDistance;
    private String noDeliveryArea;
    private String deliveryType;
    private String secondTimeliness;
    private String pickUp;
    private String townRemark;
    private String cityName;
    private String pickUpSiteName;
    private String townLocation;
    private String countryName;
    private String provinceName;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public String getFirstTimeliness() {
        return firstTimeliness;
    }

    public void setFirstTimeliness(String firstTimeliness) {
        this.firstTimeliness = firstTimeliness;
    }

    public String getAllDeliveryArea() {
        return allDeliveryArea;
    }

    public void setAllDeliveryArea(String allDeliveryArea) {
        this.allDeliveryArea = allDeliveryArea;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getDeliveryDistance() {
        return deliveryDistance;
    }

    public void setDeliveryDistance(String deliveryDistance) {
        this.deliveryDistance = deliveryDistance;
    }

    public String getNoDeliveryArea() {
        return noDeliveryArea;
    }

    public void setNoDeliveryArea(String noDeliveryArea) {
        this.noDeliveryArea = noDeliveryArea;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getSecondTimeliness() {
        return secondTimeliness;
    }

    public void setSecondTimeliness(String secondTimeliness) {
        this.secondTimeliness = secondTimeliness;
    }

    public String getPickUp() {
        return pickUp;
    }

    public void setPickUp(String pickUp) {
        this.pickUp = pickUp;
    }

    public String getTownRemark() {
        return townRemark;
    }

    public void setTownRemark(String townRemark) {
        this.townRemark = townRemark;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPickUpSiteName() {
        return pickUpSiteName;
    }

    public void setPickUpSiteName(String pickUpSiteName) {
        this.pickUpSiteName = pickUpSiteName;
    }

    public String getTownLocation() {
        return townLocation;
    }

    public void setTownLocation(String townLocation) {
        this.townLocation = townLocation;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
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
        sb.append(TownDeliveryInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("firstTimeliness");
        sb.append('=');
        sb.append(((this.firstTimeliness == null)?"<null>":this.firstTimeliness));
        sb.append(',');
        sb.append("allDeliveryArea");
        sb.append('=');
        sb.append(((this.allDeliveryArea == null)?"<null>":this.allDeliveryArea));
        sb.append(',');
        sb.append("townName");
        sb.append('=');
        sb.append(((this.townName == null)?"<null>":this.townName));
        sb.append(',');
        sb.append("districtName");
        sb.append('=');
        sb.append(((this.districtName == null)?"<null>":this.districtName));
        sb.append(',');
        sb.append("deliveryDistance");
        sb.append('=');
        sb.append(((this.deliveryDistance == null)?"<null>":this.deliveryDistance));
        sb.append(',');
        sb.append("noDeliveryArea");
        sb.append('=');
        sb.append(((this.noDeliveryArea == null)?"<null>":this.noDeliveryArea));
        sb.append(',');
        sb.append("deliveryType");
        sb.append('=');
        sb.append(((this.deliveryType == null)?"<null>":this.deliveryType));
        sb.append(',');
        sb.append("secondTimeliness");
        sb.append('=');
        sb.append(((this.secondTimeliness == null)?"<null>":this.secondTimeliness));
        sb.append(',');
        sb.append("pickUp");
        sb.append('=');
        sb.append(((this.pickUp == null)?"<null>":this.pickUp));
        sb.append(',');
        sb.append("townRemark");
        sb.append('=');
        sb.append(((this.townRemark == null)?"<null>":this.townRemark));
        sb.append(',');
        sb.append("cityName");
        sb.append('=');
        sb.append(((this.cityName == null)?"<null>":this.cityName));
        sb.append(',');
        sb.append("pickUpSiteName");
        sb.append('=');
        sb.append(((this.pickUpSiteName == null)?"<null>":this.pickUpSiteName));
        sb.append(',');
        sb.append("townLocation");
        sb.append('=');
        sb.append(((this.townLocation == null)?"<null>":this.townLocation));
        sb.append(',');
        sb.append("countryName");
        sb.append('=');
        sb.append(((this.countryName == null)?"<null>":this.countryName));
        sb.append(',');
        sb.append("provinceName");
        sb.append('=');
        sb.append(((this.provinceName == null)?"<null>":this.provinceName));
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
        result = ((result* 31)+((this.firstTimeliness == null)? 0 :this.firstTimeliness.hashCode()));
        result = ((result* 31)+((this.allDeliveryArea == null)? 0 :this.allDeliveryArea.hashCode()));
        result = ((result* 31)+((this.townName == null)? 0 :this.townName.hashCode()));
        result = ((result* 31)+((this.districtName == null)? 0 :this.districtName.hashCode()));
        result = ((result* 31)+((this.deliveryDistance == null)? 0 :this.deliveryDistance.hashCode()));
        result = ((result* 31)+((this.noDeliveryArea == null)? 0 :this.noDeliveryArea.hashCode()));
        result = ((result* 31)+((this.deliveryType == null)? 0 :this.deliveryType.hashCode()));
        result = ((result* 31)+((this.secondTimeliness == null)? 0 :this.secondTimeliness.hashCode()));
        result = ((result* 31)+((this.pickUp == null)? 0 :this.pickUp.hashCode()));
        result = ((result* 31)+((this.townRemark == null)? 0 :this.townRemark.hashCode()));
        result = ((result* 31)+((this.cityName == null)? 0 :this.cityName.hashCode()));
        result = ((result* 31)+((this.pickUpSiteName == null)? 0 :this.pickUpSiteName.hashCode()));
        result = ((result* 31)+((this.townLocation == null)? 0 :this.townLocation.hashCode()));
        result = ((result* 31)+((this.countryName == null)? 0 :this.countryName.hashCode()));
        result = ((result* 31)+((this.provinceName == null)? 0 :this.provinceName.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TownDeliveryInfo) == false) {
            return false;
        }
        TownDeliveryInfo rhs = ((TownDeliveryInfo) other);
        return (((((((((((((((((this.firstTimeliness == rhs.firstTimeliness)||((this.firstTimeliness!= null)&&this.firstTimeliness.equals(rhs.firstTimeliness)))&&((this.allDeliveryArea == rhs.allDeliveryArea)||((this.allDeliveryArea!= null)&&this.allDeliveryArea.equals(rhs.allDeliveryArea))))&&((this.townName == rhs.townName)||((this.townName!= null)&&this.townName.equals(rhs.townName))))&&((this.districtName == rhs.districtName)||((this.districtName!= null)&&this.districtName.equals(rhs.districtName))))&&((this.deliveryDistance == rhs.deliveryDistance)||((this.deliveryDistance!= null)&&this.deliveryDistance.equals(rhs.deliveryDistance))))&&((this.noDeliveryArea == rhs.noDeliveryArea)||((this.noDeliveryArea!= null)&&this.noDeliveryArea.equals(rhs.noDeliveryArea))))&&((this.deliveryType == rhs.deliveryType)||((this.deliveryType!= null)&&this.deliveryType.equals(rhs.deliveryType))))&&((this.secondTimeliness == rhs.secondTimeliness)||((this.secondTimeliness!= null)&&this.secondTimeliness.equals(rhs.secondTimeliness))))&&((this.pickUp == rhs.pickUp)||((this.pickUp!= null)&&this.pickUp.equals(rhs.pickUp))))&&((this.townRemark == rhs.townRemark)||((this.townRemark!= null)&&this.townRemark.equals(rhs.townRemark))))&&((this.cityName == rhs.cityName)||((this.cityName!= null)&&this.cityName.equals(rhs.cityName))))&&((this.pickUpSiteName == rhs.pickUpSiteName)||((this.pickUpSiteName!= null)&&this.pickUpSiteName.equals(rhs.pickUpSiteName))))&&((this.townLocation == rhs.townLocation)||((this.townLocation!= null)&&this.townLocation.equals(rhs.townLocation))))&&((this.countryName == rhs.countryName)||((this.countryName!= null)&&this.countryName.equals(rhs.countryName))))&&((this.provinceName == rhs.provinceName)||((this.provinceName!= null)&&this.provinceName.equals(rhs.provinceName))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
