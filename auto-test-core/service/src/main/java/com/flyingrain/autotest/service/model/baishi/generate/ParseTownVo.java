
package com.flyingrain.autotest.service.model.baishi.generate;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class ParseTownVo {

    private Integer id;
    private Integer lockVersion;
    private String code;
    private String name;
    private String namePath;
    private String treePath;
    private Integer parentId;
    private String parentName;
    private Integer gtypeId;
    private Integer provinceId;
    private String province;
    private Integer cityId;
    private String city;
    private Integer countyId;
    private String county;
    private Integer streetId;
    private String street;
    private String cantonLevel;
    private String status;
    private Boolean detailAddressHasCanton;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLockVersion() {
        return lockVersion;
    }

    public void setLockVersion(Integer lockVersion) {
        this.lockVersion = lockVersion;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamePath() {
        return namePath;
    }

    public void setNamePath(String namePath) {
        this.namePath = namePath;
    }

    public String getTreePath() {
        return treePath;
    }

    public void setTreePath(String treePath) {
        this.treePath = treePath;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Integer getGtypeId() {
        return gtypeId;
    }

    public void setGtypeId(Integer gtypeId) {
        this.gtypeId = gtypeId;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCountyId() {
        return countyId;
    }

    public void setCountyId(Integer countyId) {
        this.countyId = countyId;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public Integer getStreetId() {
        return streetId;
    }

    public void setStreetId(Integer streetId) {
        this.streetId = streetId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCantonLevel() {
        return cantonLevel;
    }

    public void setCantonLevel(String cantonLevel) {
        this.cantonLevel = cantonLevel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getDetailAddressHasCanton() {
        return detailAddressHasCanton;
    }

    public void setDetailAddressHasCanton(Boolean detailAddressHasCanton) {
        this.detailAddressHasCanton = detailAddressHasCanton;
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
        sb.append(ParseTownVo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("lockVersion");
        sb.append('=');
        sb.append(((this.lockVersion == null)?"<null>":this.lockVersion));
        sb.append(',');
        sb.append("code");
        sb.append('=');
        sb.append(((this.code == null)?"<null>":this.code));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("namePath");
        sb.append('=');
        sb.append(((this.namePath == null)?"<null>":this.namePath));
        sb.append(',');
        sb.append("treePath");
        sb.append('=');
        sb.append(((this.treePath == null)?"<null>":this.treePath));
        sb.append(',');
        sb.append("parentId");
        sb.append('=');
        sb.append(((this.parentId == null)?"<null>":this.parentId));
        sb.append(',');
        sb.append("parentName");
        sb.append('=');
        sb.append(((this.parentName == null)?"<null>":this.parentName));
        sb.append(',');
        sb.append("gtypeId");
        sb.append('=');
        sb.append(((this.gtypeId == null)?"<null>":this.gtypeId));
        sb.append(',');
        sb.append("provinceId");
        sb.append('=');
        sb.append(((this.provinceId == null)?"<null>":this.provinceId));
        sb.append(',');
        sb.append("province");
        sb.append('=');
        sb.append(((this.province == null)?"<null>":this.province));
        sb.append(',');
        sb.append("cityId");
        sb.append('=');
        sb.append(((this.cityId == null)?"<null>":this.cityId));
        sb.append(',');
        sb.append("city");
        sb.append('=');
        sb.append(((this.city == null)?"<null>":this.city));
        sb.append(',');
        sb.append("countyId");
        sb.append('=');
        sb.append(((this.countyId == null)?"<null>":this.countyId));
        sb.append(',');
        sb.append("county");
        sb.append('=');
        sb.append(((this.county == null)?"<null>":this.county));
        sb.append(',');
        sb.append("streetId");
        sb.append('=');
        sb.append(((this.streetId == null)?"<null>":this.streetId));
        sb.append(',');
        sb.append("street");
        sb.append('=');
        sb.append(((this.street == null)?"<null>":this.street));
        sb.append(',');
        sb.append("cantonLevel");
        sb.append('=');
        sb.append(((this.cantonLevel == null)?"<null>":this.cantonLevel));
        sb.append(',');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("detailAddressHasCanton");
        sb.append('=');
        sb.append(((this.detailAddressHasCanton == null)?"<null>":this.detailAddressHasCanton));
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
        result = ((result* 31)+((this.code == null)? 0 :this.code.hashCode()));
        result = ((result* 31)+((this.namePath == null)? 0 :this.namePath.hashCode()));
        result = ((result* 31)+((this.city == null)? 0 :this.city.hashCode()));
        result = ((result* 31)+((this.county == null)? 0 :this.county.hashCode()));
        result = ((result* 31)+((this.cityId == null)? 0 :this.cityId.hashCode()));
        result = ((result* 31)+((this.gtypeId == null)? 0 :this.gtypeId.hashCode()));
        result = ((result* 31)+((this.provinceId == null)? 0 :this.provinceId.hashCode()));
        result = ((result* 31)+((this.parentId == null)? 0 :this.parentId.hashCode()));
        result = ((result* 31)+((this.parentName == null)? 0 :this.parentName.hashCode()));
        result = ((result* 31)+((this.province == null)? 0 :this.province.hashCode()));
        result = ((result* 31)+((this.countyId == null)? 0 :this.countyId.hashCode()));
        result = ((result* 31)+((this.street == null)? 0 :this.street.hashCode()));
        result = ((result* 31)+((this.lockVersion == null)? 0 :this.lockVersion.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.detailAddressHasCanton == null)? 0 :this.detailAddressHasCanton.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.cantonLevel == null)? 0 :this.cantonLevel.hashCode()));
        result = ((result* 31)+((this.treePath == null)? 0 :this.treePath.hashCode()));
        result = ((result* 31)+((this.streetId == null)? 0 :this.streetId.hashCode()));
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ParseTownVo) == false) {
            return false;
        }
        ParseTownVo rhs = ((ParseTownVo) other);
        return ((((((((((((((((((((((this.code == rhs.code)||((this.code!= null)&&this.code.equals(rhs.code)))&&((this.namePath == rhs.namePath)||((this.namePath!= null)&&this.namePath.equals(rhs.namePath))))&&((this.city == rhs.city)||((this.city!= null)&&this.city.equals(rhs.city))))&&((this.county == rhs.county)||((this.county!= null)&&this.county.equals(rhs.county))))&&((this.cityId == rhs.cityId)||((this.cityId!= null)&&this.cityId.equals(rhs.cityId))))&&((this.gtypeId == rhs.gtypeId)||((this.gtypeId!= null)&&this.gtypeId.equals(rhs.gtypeId))))&&((this.provinceId == rhs.provinceId)||((this.provinceId!= null)&&this.provinceId.equals(rhs.provinceId))))&&((this.parentId == rhs.parentId)||((this.parentId!= null)&&this.parentId.equals(rhs.parentId))))&&((this.parentName == rhs.parentName)||((this.parentName!= null)&&this.parentName.equals(rhs.parentName))))&&((this.province == rhs.province)||((this.province!= null)&&this.province.equals(rhs.province))))&&((this.countyId == rhs.countyId)||((this.countyId!= null)&&this.countyId.equals(rhs.countyId))))&&((this.street == rhs.street)||((this.street!= null)&&this.street.equals(rhs.street))))&&((this.lockVersion == rhs.lockVersion)||((this.lockVersion!= null)&&this.lockVersion.equals(rhs.lockVersion))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.detailAddressHasCanton == rhs.detailAddressHasCanton)||((this.detailAddressHasCanton!= null)&&this.detailAddressHasCanton.equals(rhs.detailAddressHasCanton))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.cantonLevel == rhs.cantonLevel)||((this.cantonLevel!= null)&&this.cantonLevel.equals(rhs.cantonLevel))))&&((this.treePath == rhs.treePath)||((this.treePath!= null)&&this.treePath.equals(rhs.treePath))))&&((this.streetId == rhs.streetId)||((this.streetId!= null)&&this.streetId.equals(rhs.streetId))))&&((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status))));
    }

}
