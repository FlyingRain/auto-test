
package com.flyingrain.autotest.service.model.anneng;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class SiteInfo {

    private String siteId;
    private String siteName;
    private String parentSiteName;
    private String countryName;
    private String provinceName;
    private String cityName;
    private String areaName;
    private String address;
    private Integer siteStatus;
    private String linkMan;
    private String linkPhone;
    private String ranges;
    private String specialRange;
    private String outRange;
    private String siteCode;
    private String provinceId;
    private String cityId;
    private String rdStatus;
    private String blWeb;
    private String siteType;
    private Object provinceCount;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getParentSiteName() {
        return parentSiteName;
    }

    public void setParentSiteName(String parentSiteName) {
        this.parentSiteName = parentSiteName;
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

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSiteStatus() {
        return siteStatus;
    }

    public void setSiteStatus(Integer siteStatus) {
        this.siteStatus = siteStatus;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    public String getRanges() {
        return ranges;
    }

    public void setRanges(String ranges) {
        this.ranges = ranges;
    }

    public String getSpecialRange() {
        return specialRange;
    }

    public void setSpecialRange(String specialRange) {
        this.specialRange = specialRange;
    }

    public String getOutRange() {
        return outRange;
    }

    public void setOutRange(String outRange) {
        this.outRange = outRange;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getRdStatus() {
        return rdStatus;
    }

    public void setRdStatus(String rdStatus) {
        this.rdStatus = rdStatus;
    }

    public String getBlWeb() {
        return blWeb;
    }

    public void setBlWeb(String blWeb) {
        this.blWeb = blWeb;
    }

    public String getSiteType() {
        return siteType;
    }

    public void setSiteType(String siteType) {
        this.siteType = siteType;
    }

    public Object getProvinceCount() {
        return provinceCount;
    }

    public void setProvinceCount(Object provinceCount) {
        this.provinceCount = provinceCount;
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
        sb.append(SiteInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("siteId");
        sb.append('=');
        sb.append(((this.siteId == null)?"<null>":this.siteId));
        sb.append(',');
        sb.append("siteName");
        sb.append('=');
        sb.append(((this.siteName == null)?"<null>":this.siteName));
        sb.append(',');
        sb.append("parentSiteName");
        sb.append('=');
        sb.append(((this.parentSiteName == null)?"<null>":this.parentSiteName));
        sb.append(',');
        sb.append("countryName");
        sb.append('=');
        sb.append(((this.countryName == null)?"<null>":this.countryName));
        sb.append(',');
        sb.append("provinceName");
        sb.append('=');
        sb.append(((this.provinceName == null)?"<null>":this.provinceName));
        sb.append(',');
        sb.append("cityName");
        sb.append('=');
        sb.append(((this.cityName == null)?"<null>":this.cityName));
        sb.append(',');
        sb.append("areaName");
        sb.append('=');
        sb.append(((this.areaName == null)?"<null>":this.areaName));
        sb.append(',');
        sb.append("address");
        sb.append('=');
        sb.append(((this.address == null)?"<null>":this.address));
        sb.append(',');
        sb.append("siteStatus");
        sb.append('=');
        sb.append(((this.siteStatus == null)?"<null>":this.siteStatus));
        sb.append(',');
        sb.append("linkMan");
        sb.append('=');
        sb.append(((this.linkMan == null)?"<null>":this.linkMan));
        sb.append(',');
        sb.append("linkPhone");
        sb.append('=');
        sb.append(((this.linkPhone == null)?"<null>":this.linkPhone));
        sb.append(',');
        sb.append("ranges");
        sb.append('=');
        sb.append(((this.ranges == null)?"<null>":this.ranges));
        sb.append(',');
        sb.append("specialRange");
        sb.append('=');
        sb.append(((this.specialRange == null)?"<null>":this.specialRange));
        sb.append(',');
        sb.append("outRange");
        sb.append('=');
        sb.append(((this.outRange == null)?"<null>":this.outRange));
        sb.append(',');
        sb.append("siteCode");
        sb.append('=');
        sb.append(((this.siteCode == null)?"<null>":this.siteCode));
        sb.append(',');
        sb.append("provinceId");
        sb.append('=');
        sb.append(((this.provinceId == null)?"<null>":this.provinceId));
        sb.append(',');
        sb.append("cityId");
        sb.append('=');
        sb.append(((this.cityId == null)?"<null>":this.cityId));
        sb.append(',');
        sb.append("rdStatus");
        sb.append('=');
        sb.append(((this.rdStatus == null)?"<null>":this.rdStatus));
        sb.append(',');
        sb.append("blWeb");
        sb.append('=');
        sb.append(((this.blWeb == null)?"<null>":this.blWeb));
        sb.append(',');
        sb.append("siteType");
        sb.append('=');
        sb.append(((this.siteType == null)?"<null>":this.siteType));
        sb.append(',');
        sb.append("provinceCount");
        sb.append('=');
        sb.append(((this.provinceCount == null)?"<null>":this.provinceCount));
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
        result = ((result* 31)+((this.linkPhone == null)? 0 :this.linkPhone.hashCode()));
        result = ((result* 31)+((this.address == null)? 0 :this.address.hashCode()));
        result = ((result* 31)+((this.siteCode == null)? 0 :this.siteCode.hashCode()));
        result = ((result* 31)+((this.rdStatus == null)? 0 :this.rdStatus.hashCode()));
        result = ((result* 31)+((this.ranges == null)? 0 :this.ranges.hashCode()));
        result = ((result* 31)+((this.specialRange == null)? 0 :this.specialRange.hashCode()));
        result = ((result* 31)+((this.siteStatus == null)? 0 :this.siteStatus.hashCode()));
        result = ((result* 31)+((this.siteName == null)? 0 :this.siteName.hashCode()));
        result = ((result* 31)+((this.cityId == null)? 0 :this.cityId.hashCode()));
        result = ((result* 31)+((this.linkMan == null)? 0 :this.linkMan.hashCode()));
        result = ((result* 31)+((this.provinceId == null)? 0 :this.provinceId.hashCode()));
        result = ((result* 31)+((this.outRange == null)? 0 :this.outRange.hashCode()));
        result = ((result* 31)+((this.cityName == null)? 0 :this.cityName.hashCode()));
        result = ((result* 31)+((this.provinceCount == null)? 0 :this.provinceCount.hashCode()));
        result = ((result* 31)+((this.areaName == null)? 0 :this.areaName.hashCode()));
        result = ((result* 31)+((this.parentSiteName == null)? 0 :this.parentSiteName.hashCode()));
        result = ((result* 31)+((this.siteId == null)? 0 :this.siteId.hashCode()));
        result = ((result* 31)+((this.countryName == null)? 0 :this.countryName.hashCode()));
        result = ((result* 31)+((this.provinceName == null)? 0 :this.provinceName.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.blWeb == null)? 0 :this.blWeb.hashCode()));
        result = ((result* 31)+((this.siteType == null)? 0 :this.siteType.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SiteInfo) == false) {
            return false;
        }
        SiteInfo rhs = ((SiteInfo) other);
        return (((((((((((((((((((((((this.linkPhone == rhs.linkPhone)||((this.linkPhone!= null)&&this.linkPhone.equals(rhs.linkPhone)))&&((this.address == rhs.address)||((this.address!= null)&&this.address.equals(rhs.address))))&&((this.siteCode == rhs.siteCode)||((this.siteCode!= null)&&this.siteCode.equals(rhs.siteCode))))&&((this.rdStatus == rhs.rdStatus)||((this.rdStatus!= null)&&this.rdStatus.equals(rhs.rdStatus))))&&((this.ranges == rhs.ranges)||((this.ranges!= null)&&this.ranges.equals(rhs.ranges))))&&((this.specialRange == rhs.specialRange)||((this.specialRange!= null)&&this.specialRange.equals(rhs.specialRange))))&&((this.siteStatus == rhs.siteStatus)||((this.siteStatus!= null)&&this.siteStatus.equals(rhs.siteStatus))))&&((this.siteName == rhs.siteName)||((this.siteName!= null)&&this.siteName.equals(rhs.siteName))))&&((this.cityId == rhs.cityId)||((this.cityId!= null)&&this.cityId.equals(rhs.cityId))))&&((this.linkMan == rhs.linkMan)||((this.linkMan!= null)&&this.linkMan.equals(rhs.linkMan))))&&((this.provinceId == rhs.provinceId)||((this.provinceId!= null)&&this.provinceId.equals(rhs.provinceId))))&&((this.outRange == rhs.outRange)||((this.outRange!= null)&&this.outRange.equals(rhs.outRange))))&&((this.cityName == rhs.cityName)||((this.cityName!= null)&&this.cityName.equals(rhs.cityName))))&&((this.provinceCount == rhs.provinceCount)||((this.provinceCount!= null)&&this.provinceCount.equals(rhs.provinceCount))))&&((this.areaName == rhs.areaName)||((this.areaName!= null)&&this.areaName.equals(rhs.areaName))))&&((this.parentSiteName == rhs.parentSiteName)||((this.parentSiteName!= null)&&this.parentSiteName.equals(rhs.parentSiteName))))&&((this.siteId == rhs.siteId)||((this.siteId!= null)&&this.siteId.equals(rhs.siteId))))&&((this.countryName == rhs.countryName)||((this.countryName!= null)&&this.countryName.equals(rhs.countryName))))&&((this.provinceName == rhs.provinceName)||((this.provinceName!= null)&&this.provinceName.equals(rhs.provinceName))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.blWeb == rhs.blWeb)||((this.blWeb!= null)&&this.blWeb.equals(rhs.blWeb))))&&((this.siteType == rhs.siteType)||((this.siteType!= null)&&this.siteType.equals(rhs.siteType))));
    }

}
