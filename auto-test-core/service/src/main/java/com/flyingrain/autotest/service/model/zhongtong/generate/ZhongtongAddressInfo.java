
package com.flyingrain.autotest.service.model.zhongtong.generate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class ZhongtongAddressInfo {

    private List<AddressSite> addressSiteList = new ArrayList<AddressSite>();
    private String matchType;
    private String cityLimitBasicInfo;
    private String cityLimitWeight;
    private List<String> cityLimitArea = new ArrayList<String>();
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public List<AddressSite> getAddressSiteList() {
        return addressSiteList;
    }

    public void setAddressSiteList(List<AddressSite> addressSiteList) {
        this.addressSiteList = addressSiteList;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public String getCityLimitBasicInfo() {
        return cityLimitBasicInfo;
    }

    public void setCityLimitBasicInfo(String cityLimitBasicInfo) {
        this.cityLimitBasicInfo = cityLimitBasicInfo;
    }

    public String getCityLimitWeight() {
        return cityLimitWeight;
    }

    public void setCityLimitWeight(String cityLimitWeight) {
        this.cityLimitWeight = cityLimitWeight;
    }

    public List<String> getCityLimitArea() {
        return cityLimitArea;
    }

    public void setCityLimitArea(List<String> cityLimitArea) {
        this.cityLimitArea = cityLimitArea;
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
        sb.append(ZhongtongAddressInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("addressSiteList");
        sb.append('=');
        sb.append(((this.addressSiteList == null)?"<null>":this.addressSiteList));
        sb.append(',');
        sb.append("matchType");
        sb.append('=');
        sb.append(((this.matchType == null)?"<null>":this.matchType));
        sb.append(',');
        sb.append("cityLimitBasicInfo");
        sb.append('=');
        sb.append(((this.cityLimitBasicInfo == null)?"<null>":this.cityLimitBasicInfo));
        sb.append(',');
        sb.append("cityLimitWeight");
        sb.append('=');
        sb.append(((this.cityLimitWeight == null)?"<null>":this.cityLimitWeight));
        sb.append(',');
        sb.append("cityLimitArea");
        sb.append('=');
        sb.append(((this.cityLimitArea == null)?"<null>":this.cityLimitArea));
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
        result = ((result* 31)+((this.addressSiteList == null)? 0 :this.addressSiteList.hashCode()));
        result = ((result* 31)+((this.matchType == null)? 0 :this.matchType.hashCode()));
        result = ((result* 31)+((this.cityLimitBasicInfo == null)? 0 :this.cityLimitBasicInfo.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.cityLimitWeight == null)? 0 :this.cityLimitWeight.hashCode()));
        result = ((result* 31)+((this.cityLimitArea == null)? 0 :this.cityLimitArea.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ZhongtongAddressInfo) == false) {
            return false;
        }
        ZhongtongAddressInfo rhs = ((ZhongtongAddressInfo) other);
        return (((((((this.addressSiteList == rhs.addressSiteList)||((this.addressSiteList!= null)&&this.addressSiteList.equals(rhs.addressSiteList)))&&((this.matchType == rhs.matchType)||((this.matchType!= null)&&this.matchType.equals(rhs.matchType))))&&((this.cityLimitBasicInfo == rhs.cityLimitBasicInfo)||((this.cityLimitBasicInfo!= null)&&this.cityLimitBasicInfo.equals(rhs.cityLimitBasicInfo))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.cityLimitWeight == rhs.cityLimitWeight)||((this.cityLimitWeight!= null)&&this.cityLimitWeight.equals(rhs.cityLimitWeight))))&&((this.cityLimitArea == rhs.cityLimitArea)||((this.cityLimitArea!= null)&&this.cityLimitArea.equals(rhs.cityLimitArea))));
    }

}
