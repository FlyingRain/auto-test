
package com.flyingrain.autotest.service.model.zhongtong;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class AddressSite {

    private String address;
    private String addressDeliveryRemark;
    private String addressDeliveryType;
    private String addressLocation;
    private String cityName;
    private String distance;
    private String districtName;
    private String provinceName;
    private String showMapType;
    private List<Site> siteList = new ArrayList<Site>();
    private String sourceType;
    private List<Object> townDeliveryArea = new ArrayList<Object>();
    private String townDeliveryDistance;
    private String townDeliveryType;
    private String townLocation;
    private String townName;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressDeliveryRemark() {
        return addressDeliveryRemark;
    }

    public void setAddressDeliveryRemark(String addressDeliveryRemark) {
        this.addressDeliveryRemark = addressDeliveryRemark;
    }

    public String getAddressDeliveryType() {
        return addressDeliveryType;
    }

    public void setAddressDeliveryType(String addressDeliveryType) {
        this.addressDeliveryType = addressDeliveryType;
    }

    public String getAddressLocation() {
        return addressLocation;
    }

    public void setAddressLocation(String addressLocation) {
        this.addressLocation = addressLocation;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getShowMapType() {
        return showMapType;
    }

    public void setShowMapType(String showMapType) {
        this.showMapType = showMapType;
    }

    public List<Site> getSiteList() {
        return siteList;
    }

    public void setSiteList(List<Site> siteList) {
        this.siteList = siteList;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public List<Object> getTownDeliveryArea() {
        return townDeliveryArea;
    }

    public void setTownDeliveryArea(List<Object> townDeliveryArea) {
        this.townDeliveryArea = townDeliveryArea;
    }

    public String getTownDeliveryDistance() {
        return townDeliveryDistance;
    }

    public void setTownDeliveryDistance(String townDeliveryDistance) {
        this.townDeliveryDistance = townDeliveryDistance;
    }

    public String getTownDeliveryType() {
        return townDeliveryType;
    }

    public void setTownDeliveryType(String townDeliveryType) {
        this.townDeliveryType = townDeliveryType;
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

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AddressSite.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("address");
        sb.append('=');
        sb.append(((this.address == null)?"<null>":this.address));
        sb.append(',');
        sb.append("addressDeliveryRemark");
        sb.append('=');
        sb.append(((this.addressDeliveryRemark == null)?"<null>":this.addressDeliveryRemark));
        sb.append(',');
        sb.append("addressDeliveryType");
        sb.append('=');
        sb.append(((this.addressDeliveryType == null)?"<null>":this.addressDeliveryType));
        sb.append(',');
        sb.append("addressLocation");
        sb.append('=');
        sb.append(((this.addressLocation == null)?"<null>":this.addressLocation));
        sb.append(',');
        sb.append("cityName");
        sb.append('=');
        sb.append(((this.cityName == null)?"<null>":this.cityName));
        sb.append(',');
        sb.append("distance");
        sb.append('=');
        sb.append(((this.distance == null)?"<null>":this.distance));
        sb.append(',');
        sb.append("districtName");
        sb.append('=');
        sb.append(((this.districtName == null)?"<null>":this.districtName));
        sb.append(',');
        sb.append("provinceName");
        sb.append('=');
        sb.append(((this.provinceName == null)?"<null>":this.provinceName));
        sb.append(',');
        sb.append("showMapType");
        sb.append('=');
        sb.append(((this.showMapType == null)?"<null>":this.showMapType));
        sb.append(',');
        sb.append("siteList");
        sb.append('=');
        sb.append(((this.siteList == null)?"<null>":this.siteList));
        sb.append(',');
        sb.append("sourceType");
        sb.append('=');
        sb.append(((this.sourceType == null)?"<null>":this.sourceType));
        sb.append(',');
        sb.append("townDeliveryArea");
        sb.append('=');
        sb.append(((this.townDeliveryArea == null)?"<null>":this.townDeliveryArea));
        sb.append(',');
        sb.append("townDeliveryDistance");
        sb.append('=');
        sb.append(((this.townDeliveryDistance == null)?"<null>":this.townDeliveryDistance));
        sb.append(',');
        sb.append("townDeliveryType");
        sb.append('=');
        sb.append(((this.townDeliveryType == null)?"<null>":this.townDeliveryType));
        sb.append(',');
        sb.append("townLocation");
        sb.append('=');
        sb.append(((this.townLocation == null)?"<null>":this.townLocation));
        sb.append(',');
        sb.append("townName");
        sb.append('=');
        sb.append(((this.townName == null)?"<null>":this.townName));
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
        result = ((result* 31)+((this.addressDeliveryRemark == null)? 0 :this.addressDeliveryRemark.hashCode()));
        result = ((result* 31)+((this.townName == null)? 0 :this.townName.hashCode()));
        result = ((result* 31)+((this.address == null)? 0 :this.address.hashCode()));
        result = ((result* 31)+((this.distance == null)? 0 :this.distance.hashCode()));
        result = ((result* 31)+((this.districtName == null)? 0 :this.districtName.hashCode()));
        result = ((result* 31)+((this.townDeliveryDistance == null)? 0 :this.townDeliveryDistance.hashCode()));
        result = ((result* 31)+((this.townDeliveryType == null)? 0 :this.townDeliveryType.hashCode()));
        result = ((result* 31)+((this.cityName == null)? 0 :this.cityName.hashCode()));
        result = ((result* 31)+((this.sourceType == null)? 0 :this.sourceType.hashCode()));
        result = ((result* 31)+((this.addressDeliveryType == null)? 0 :this.addressDeliveryType.hashCode()));
        result = ((result* 31)+((this.addressLocation == null)? 0 :this.addressLocation.hashCode()));
        result = ((result* 31)+((this.townDeliveryArea == null)? 0 :this.townDeliveryArea.hashCode()));
        result = ((result* 31)+((this.townLocation == null)? 0 :this.townLocation.hashCode()));
        result = ((result* 31)+((this.provinceName == null)? 0 :this.provinceName.hashCode()));
        result = ((result* 31)+((this.showMapType == null)? 0 :this.showMapType.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.siteList == null)? 0 :this.siteList.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AddressSite) == false) {
            return false;
        }
        AddressSite rhs = ((AddressSite) other);
        return ((((((((((((((((((this.addressDeliveryRemark == rhs.addressDeliveryRemark)||((this.addressDeliveryRemark!= null)&&this.addressDeliveryRemark.equals(rhs.addressDeliveryRemark)))&&((this.townName == rhs.townName)||((this.townName!= null)&&this.townName.equals(rhs.townName))))&&((this.address == rhs.address)||((this.address!= null)&&this.address.equals(rhs.address))))&&((this.distance == rhs.distance)||((this.distance!= null)&&this.distance.equals(rhs.distance))))&&((this.districtName == rhs.districtName)||((this.districtName!= null)&&this.districtName.equals(rhs.districtName))))&&((this.townDeliveryDistance == rhs.townDeliveryDistance)||((this.townDeliveryDistance!= null)&&this.townDeliveryDistance.equals(rhs.townDeliveryDistance))))&&((this.townDeliveryType == rhs.townDeliveryType)||((this.townDeliveryType!= null)&&this.townDeliveryType.equals(rhs.townDeliveryType))))&&((this.cityName == rhs.cityName)||((this.cityName!= null)&&this.cityName.equals(rhs.cityName))))&&((this.sourceType == rhs.sourceType)||((this.sourceType!= null)&&this.sourceType.equals(rhs.sourceType))))&&((this.addressDeliveryType == rhs.addressDeliveryType)||((this.addressDeliveryType!= null)&&this.addressDeliveryType.equals(rhs.addressDeliveryType))))&&((this.addressLocation == rhs.addressLocation)||((this.addressLocation!= null)&&this.addressLocation.equals(rhs.addressLocation))))&&((this.townDeliveryArea == rhs.townDeliveryArea)||((this.townDeliveryArea!= null)&&this.townDeliveryArea.equals(rhs.townDeliveryArea))))&&((this.townLocation == rhs.townLocation)||((this.townLocation!= null)&&this.townLocation.equals(rhs.townLocation))))&&((this.provinceName == rhs.provinceName)||((this.provinceName!= null)&&this.provinceName.equals(rhs.provinceName))))&&((this.showMapType == rhs.showMapType)||((this.showMapType!= null)&&this.showMapType.equals(rhs.showMapType))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.siteList == rhs.siteList)||((this.siteList!= null)&&this.siteList.equals(rhs.siteList))));
    }

}
