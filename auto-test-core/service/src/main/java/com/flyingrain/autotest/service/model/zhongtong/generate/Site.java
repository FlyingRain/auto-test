
package com.flyingrain.autotest.service.model.zhongtong.generate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class Site {

    private String coverDrivieDistance;
    private String coverRadius;
    private String limitInfo;
    private String siteAddress;
    private String siteId;
    private String siteLocation;
    private String siteName;
    private List<String> sitePolygon = new ArrayList<String>();
    private String siteProblemPhone;
    private String siteQryEmployeeName;
    private String siteQryEmployeePhone;
    private Integer siteServicesType;
    private String siteSpecialRange;
    private String siteType;
    private List<TownEntity> townEntity = new ArrayList<TownEntity>();
    private String $ref;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public String getCoverDrivieDistance() {
        return coverDrivieDistance;
    }

    public void setCoverDrivieDistance(String coverDrivieDistance) {
        this.coverDrivieDistance = coverDrivieDistance;
    }

    public String getCoverRadius() {
        return coverRadius;
    }

    public void setCoverRadius(String coverRadius) {
        this.coverRadius = coverRadius;
    }

    public String getLimitInfo() {
        return limitInfo;
    }

    public void setLimitInfo(String limitInfo) {
        this.limitInfo = limitInfo;
    }

    public String getSiteAddress() {
        return siteAddress;
    }

    public void setSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSiteLocation() {
        return siteLocation;
    }

    public void setSiteLocation(String siteLocation) {
        this.siteLocation = siteLocation;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public List<String> getSitePolygon() {
        return sitePolygon;
    }

    public void setSitePolygon(List<String> sitePolygon) {
        this.sitePolygon = sitePolygon;
    }

    public String getSiteProblemPhone() {
        return siteProblemPhone;
    }

    public void setSiteProblemPhone(String siteProblemPhone) {
        this.siteProblemPhone = siteProblemPhone;
    }

    public String getSiteQryEmployeeName() {
        return siteQryEmployeeName;
    }

    public void setSiteQryEmployeeName(String siteQryEmployeeName) {
        this.siteQryEmployeeName = siteQryEmployeeName;
    }

    public String getSiteQryEmployeePhone() {
        return siteQryEmployeePhone;
    }

    public void setSiteQryEmployeePhone(String siteQryEmployeePhone) {
        this.siteQryEmployeePhone = siteQryEmployeePhone;
    }

    public Integer getSiteServicesType() {
        return siteServicesType;
    }

    public void setSiteServicesType(Integer siteServicesType) {
        this.siteServicesType = siteServicesType;
    }

    public String getSiteSpecialRange() {
        return siteSpecialRange;
    }

    public void setSiteSpecialRange(String siteSpecialRange) {
        this.siteSpecialRange = siteSpecialRange;
    }

    public String getSiteType() {
        return siteType;
    }

    public void setSiteType(String siteType) {
        this.siteType = siteType;
    }

    public List<TownEntity> getTownEntity() {
        return townEntity;
    }

    public void setTownEntity(List<TownEntity> townEntity) {
        this.townEntity = townEntity;
    }

    public String get$ref() {
        return $ref;
    }

    public void set$ref(String $ref) {
        this.$ref = $ref;
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
        sb.append(Site.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("coverDrivieDistance");
        sb.append('=');
        sb.append(((this.coverDrivieDistance == null)?"<null>":this.coverDrivieDistance));
        sb.append(',');
        sb.append("coverRadius");
        sb.append('=');
        sb.append(((this.coverRadius == null)?"<null>":this.coverRadius));
        sb.append(',');
        sb.append("limitInfo");
        sb.append('=');
        sb.append(((this.limitInfo == null)?"<null>":this.limitInfo));
        sb.append(',');
        sb.append("siteAddress");
        sb.append('=');
        sb.append(((this.siteAddress == null)?"<null>":this.siteAddress));
        sb.append(',');
        sb.append("siteId");
        sb.append('=');
        sb.append(((this.siteId == null)?"<null>":this.siteId));
        sb.append(',');
        sb.append("siteLocation");
        sb.append('=');
        sb.append(((this.siteLocation == null)?"<null>":this.siteLocation));
        sb.append(',');
        sb.append("siteName");
        sb.append('=');
        sb.append(((this.siteName == null)?"<null>":this.siteName));
        sb.append(',');
        sb.append("sitePolygon");
        sb.append('=');
        sb.append(((this.sitePolygon == null)?"<null>":this.sitePolygon));
        sb.append(',');
        sb.append("siteProblemPhone");
        sb.append('=');
        sb.append(((this.siteProblemPhone == null)?"<null>":this.siteProblemPhone));
        sb.append(',');
        sb.append("siteQryEmployeeName");
        sb.append('=');
        sb.append(((this.siteQryEmployeeName == null)?"<null>":this.siteQryEmployeeName));
        sb.append(',');
        sb.append("siteQryEmployeePhone");
        sb.append('=');
        sb.append(((this.siteQryEmployeePhone == null)?"<null>":this.siteQryEmployeePhone));
        sb.append(',');
        sb.append("siteServicesType");
        sb.append('=');
        sb.append(((this.siteServicesType == null)?"<null>":this.siteServicesType));
        sb.append(',');
        sb.append("siteSpecialRange");
        sb.append('=');
        sb.append(((this.siteSpecialRange == null)?"<null>":this.siteSpecialRange));
        sb.append(',');
        sb.append("siteType");
        sb.append('=');
        sb.append(((this.siteType == null)?"<null>":this.siteType));
        sb.append(',');
        sb.append("townEntity");
        sb.append('=');
        sb.append(((this.townEntity == null)?"<null>":this.townEntity));
        sb.append(',');
        sb.append("$ref");
        sb.append('=');
        sb.append(((this.$ref == null)?"<null>":this.$ref));
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
        result = ((result* 31)+((this.coverDrivieDistance == null)? 0 :this.coverDrivieDistance.hashCode()));
        result = ((result* 31)+((this.sitePolygon == null)? 0 :this.sitePolygon.hashCode()));
        result = ((result* 31)+((this.siteAddress == null)? 0 :this.siteAddress.hashCode()));
        result = ((result* 31)+((this.siteName == null)? 0 :this.siteName.hashCode()));
        result = ((result* 31)+((this.siteSpecialRange == null)? 0 :this.siteSpecialRange.hashCode()));
        result = ((result* 31)+((this.siteQryEmployeePhone == null)? 0 :this.siteQryEmployeePhone.hashCode()));
        result = ((result* 31)+((this.coverRadius == null)? 0 :this.coverRadius.hashCode()));
        result = ((result* 31)+((this.siteQryEmployeeName == null)? 0 :this.siteQryEmployeeName.hashCode()));
        result = ((result* 31)+((this.siteLocation == null)? 0 :this.siteLocation.hashCode()));
        result = ((result* 31)+((this.siteId == null)? 0 :this.siteId.hashCode()));
        result = ((result* 31)+((this.limitInfo == null)? 0 :this.limitInfo.hashCode()));
        result = ((result* 31)+((this.townEntity == null)? 0 :this.townEntity.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.siteServicesType == null)? 0 :this.siteServicesType.hashCode()));
        result = ((result* 31)+((this.$ref == null)? 0 :this.$ref.hashCode()));
        result = ((result* 31)+((this.siteProblemPhone == null)? 0 :this.siteProblemPhone.hashCode()));
        result = ((result* 31)+((this.siteType == null)? 0 :this.siteType.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Site) == false) {
            return false;
        }
        Site rhs = ((Site) other);
        return ((((((((((((((((((this.coverDrivieDistance == rhs.coverDrivieDistance)||((this.coverDrivieDistance!= null)&&this.coverDrivieDistance.equals(rhs.coverDrivieDistance)))&&((this.sitePolygon == rhs.sitePolygon)||((this.sitePolygon!= null)&&this.sitePolygon.equals(rhs.sitePolygon))))&&((this.siteAddress == rhs.siteAddress)||((this.siteAddress!= null)&&this.siteAddress.equals(rhs.siteAddress))))&&((this.siteName == rhs.siteName)||((this.siteName!= null)&&this.siteName.equals(rhs.siteName))))&&((this.siteSpecialRange == rhs.siteSpecialRange)||((this.siteSpecialRange!= null)&&this.siteSpecialRange.equals(rhs.siteSpecialRange))))&&((this.siteQryEmployeePhone == rhs.siteQryEmployeePhone)||((this.siteQryEmployeePhone!= null)&&this.siteQryEmployeePhone.equals(rhs.siteQryEmployeePhone))))&&((this.coverRadius == rhs.coverRadius)||((this.coverRadius!= null)&&this.coverRadius.equals(rhs.coverRadius))))&&((this.siteQryEmployeeName == rhs.siteQryEmployeeName)||((this.siteQryEmployeeName!= null)&&this.siteQryEmployeeName.equals(rhs.siteQryEmployeeName))))&&((this.siteLocation == rhs.siteLocation)||((this.siteLocation!= null)&&this.siteLocation.equals(rhs.siteLocation))))&&((this.siteId == rhs.siteId)||((this.siteId!= null)&&this.siteId.equals(rhs.siteId))))&&((this.limitInfo == rhs.limitInfo)||((this.limitInfo!= null)&&this.limitInfo.equals(rhs.limitInfo))))&&((this.townEntity == rhs.townEntity)||((this.townEntity!= null)&&this.townEntity.equals(rhs.townEntity))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.siteServicesType == rhs.siteServicesType)||((this.siteServicesType!= null)&&this.siteServicesType.equals(rhs.siteServicesType))))&&((this.$ref == rhs.$ref)||((this.$ref!= null)&&this.$ref.equals(rhs.$ref))))&&((this.siteProblemPhone == rhs.siteProblemPhone)||((this.siteProblemPhone!= null)&&this.siteProblemPhone.equals(rhs.siteProblemPhone))))&&((this.siteType == rhs.siteType)||((this.siteType!= null)&&this.siteType.equals(rhs.siteType))));
    }

}
