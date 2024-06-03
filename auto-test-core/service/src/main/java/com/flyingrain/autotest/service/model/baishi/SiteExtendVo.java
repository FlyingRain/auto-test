
package com.flyingrain.autotest.service.model.baishi;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class SiteExtendVo {

    private Integer id;
    private String createdTime;
    private String updatedTime;
    private String creatorName;
    private String updatorName;
    private Integer lockVersion;
    private Integer creatorId;
    private Integer updatorId;
    private Integer siteId;
    private String siteName;
    private String siteCode;
    private Boolean sendSiteWeightSwitch;
    private Double sendSiteWeightLimit;
    private Boolean dispSiteWeightSwitch;
    private Double dispSiteWeightLimitMin;
    private Double dispSiteWeightLimit;
    private String siteExtendBit;
    private Boolean supportPickUp;
    private Boolean precharge;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getUpdatorName() {
        return updatorName;
    }

    public void setUpdatorName(String updatorName) {
        this.updatorName = updatorName;
    }

    public Integer getLockVersion() {
        return lockVersion;
    }

    public void setLockVersion(Integer lockVersion) {
        this.lockVersion = lockVersion;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Integer getUpdatorId() {
        return updatorId;
    }

    public void setUpdatorId(Integer updatorId) {
        this.updatorId = updatorId;
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

    public Boolean getSendSiteWeightSwitch() {
        return sendSiteWeightSwitch;
    }

    public void setSendSiteWeightSwitch(Boolean sendSiteWeightSwitch) {
        this.sendSiteWeightSwitch = sendSiteWeightSwitch;
    }

    public Double getSendSiteWeightLimit() {
        return sendSiteWeightLimit;
    }

    public void setSendSiteWeightLimit(Double sendSiteWeightLimit) {
        this.sendSiteWeightLimit = sendSiteWeightLimit;
    }

    public Boolean getDispSiteWeightSwitch() {
        return dispSiteWeightSwitch;
    }

    public void setDispSiteWeightSwitch(Boolean dispSiteWeightSwitch) {
        this.dispSiteWeightSwitch = dispSiteWeightSwitch;
    }

    public Double getDispSiteWeightLimitMin() {
        return dispSiteWeightLimitMin;
    }

    public void setDispSiteWeightLimitMin(Double dispSiteWeightLimitMin) {
        this.dispSiteWeightLimitMin = dispSiteWeightLimitMin;
    }

    public Double getDispSiteWeightLimit() {
        return dispSiteWeightLimit;
    }

    public void setDispSiteWeightLimit(Double dispSiteWeightLimit) {
        this.dispSiteWeightLimit = dispSiteWeightLimit;
    }

    public String getSiteExtendBit() {
        return siteExtendBit;
    }

    public void setSiteExtendBit(String siteExtendBit) {
        this.siteExtendBit = siteExtendBit;
    }

    public Boolean getSupportPickUp() {
        return supportPickUp;
    }

    public void setSupportPickUp(Boolean supportPickUp) {
        this.supportPickUp = supportPickUp;
    }

    public Boolean getPrecharge() {
        return precharge;
    }

    public void setPrecharge(Boolean precharge) {
        this.precharge = precharge;
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
        sb.append(SiteExtendVo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("createdTime");
        sb.append('=');
        sb.append(((this.createdTime == null)?"<null>":this.createdTime));
        sb.append(',');
        sb.append("updatedTime");
        sb.append('=');
        sb.append(((this.updatedTime == null)?"<null>":this.updatedTime));
        sb.append(',');
        sb.append("creatorName");
        sb.append('=');
        sb.append(((this.creatorName == null)?"<null>":this.creatorName));
        sb.append(',');
        sb.append("updatorName");
        sb.append('=');
        sb.append(((this.updatorName == null)?"<null>":this.updatorName));
        sb.append(',');
        sb.append("lockVersion");
        sb.append('=');
        sb.append(((this.lockVersion == null)?"<null>":this.lockVersion));
        sb.append(',');
        sb.append("creatorId");
        sb.append('=');
        sb.append(((this.creatorId == null)?"<null>":this.creatorId));
        sb.append(',');
        sb.append("updatorId");
        sb.append('=');
        sb.append(((this.updatorId == null)?"<null>":this.updatorId));
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
        sb.append("sendSiteWeightSwitch");
        sb.append('=');
        sb.append(((this.sendSiteWeightSwitch == null)?"<null>":this.sendSiteWeightSwitch));
        sb.append(',');
        sb.append("sendSiteWeightLimit");
        sb.append('=');
        sb.append(((this.sendSiteWeightLimit == null)?"<null>":this.sendSiteWeightLimit));
        sb.append(',');
        sb.append("dispSiteWeightSwitch");
        sb.append('=');
        sb.append(((this.dispSiteWeightSwitch == null)?"<null>":this.dispSiteWeightSwitch));
        sb.append(',');
        sb.append("dispSiteWeightLimitMin");
        sb.append('=');
        sb.append(((this.dispSiteWeightLimitMin == null)?"<null>":this.dispSiteWeightLimitMin));
        sb.append(',');
        sb.append("dispSiteWeightLimit");
        sb.append('=');
        sb.append(((this.dispSiteWeightLimit == null)?"<null>":this.dispSiteWeightLimit));
        sb.append(',');
        sb.append("siteExtendBit");
        sb.append('=');
        sb.append(((this.siteExtendBit == null)?"<null>":this.siteExtendBit));
        sb.append(',');
        sb.append("supportPickUp");
        sb.append('=');
        sb.append(((this.supportPickUp == null)?"<null>":this.supportPickUp));
        sb.append(',');
        sb.append("precharge");
        sb.append('=');
        sb.append(((this.precharge == null)?"<null>":this.precharge));
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
        result = ((result* 31)+((this.updatedTime == null)? 0 :this.updatedTime.hashCode()));
        result = ((result* 31)+((this.siteCode == null)? 0 :this.siteCode.hashCode()));
        result = ((result* 31)+((this.sendSiteWeightSwitch == null)? 0 :this.sendSiteWeightSwitch.hashCode()));
        result = ((result* 31)+((this.creatorName == null)? 0 :this.creatorName.hashCode()));
        result = ((result* 31)+((this.creatorId == null)? 0 :this.creatorId.hashCode()));
        result = ((result* 31)+((this.dispSiteWeightSwitch == null)? 0 :this.dispSiteWeightSwitch.hashCode()));
        result = ((result* 31)+((this.siteName == null)? 0 :this.siteName.hashCode()));
        result = ((result* 31)+((this.updatorId == null)? 0 :this.updatorId.hashCode()));
        result = ((result* 31)+((this.sendSiteWeightLimit == null)? 0 :this.sendSiteWeightLimit.hashCode()));
        result = ((result* 31)+((this.dispSiteWeightLimitMin == null)? 0 :this.dispSiteWeightLimitMin.hashCode()));
        result = ((result* 31)+((this.supportPickUp == null)? 0 :this.supportPickUp.hashCode()));
        result = ((result* 31)+((this.dispSiteWeightLimit == null)? 0 :this.dispSiteWeightLimit.hashCode()));
        result = ((result* 31)+((this.precharge == null)? 0 :this.precharge.hashCode()));
        result = ((result* 31)+((this.updatorName == null)? 0 :this.updatorName.hashCode()));
        result = ((result* 31)+((this.siteExtendBit == null)? 0 :this.siteExtendBit.hashCode()));
        result = ((result* 31)+((this.lockVersion == null)? 0 :this.lockVersion.hashCode()));
        result = ((result* 31)+((this.createdTime == null)? 0 :this.createdTime.hashCode()));
        result = ((result* 31)+((this.siteId == null)? 0 :this.siteId.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SiteExtendVo) == false) {
            return false;
        }
        SiteExtendVo rhs = ((SiteExtendVo) other);
        return (((((((((((((((((((((this.updatedTime == rhs.updatedTime)||((this.updatedTime!= null)&&this.updatedTime.equals(rhs.updatedTime)))&&((this.siteCode == rhs.siteCode)||((this.siteCode!= null)&&this.siteCode.equals(rhs.siteCode))))&&((this.sendSiteWeightSwitch == rhs.sendSiteWeightSwitch)||((this.sendSiteWeightSwitch!= null)&&this.sendSiteWeightSwitch.equals(rhs.sendSiteWeightSwitch))))&&((this.creatorName == rhs.creatorName)||((this.creatorName!= null)&&this.creatorName.equals(rhs.creatorName))))&&((this.creatorId == rhs.creatorId)||((this.creatorId!= null)&&this.creatorId.equals(rhs.creatorId))))&&((this.dispSiteWeightSwitch == rhs.dispSiteWeightSwitch)||((this.dispSiteWeightSwitch!= null)&&this.dispSiteWeightSwitch.equals(rhs.dispSiteWeightSwitch))))&&((this.siteName == rhs.siteName)||((this.siteName!= null)&&this.siteName.equals(rhs.siteName))))&&((this.updatorId == rhs.updatorId)||((this.updatorId!= null)&&this.updatorId.equals(rhs.updatorId))))&&((this.sendSiteWeightLimit == rhs.sendSiteWeightLimit)||((this.sendSiteWeightLimit!= null)&&this.sendSiteWeightLimit.equals(rhs.sendSiteWeightLimit))))&&((this.dispSiteWeightLimitMin == rhs.dispSiteWeightLimitMin)||((this.dispSiteWeightLimitMin!= null)&&this.dispSiteWeightLimitMin.equals(rhs.dispSiteWeightLimitMin))))&&((this.supportPickUp == rhs.supportPickUp)||((this.supportPickUp!= null)&&this.supportPickUp.equals(rhs.supportPickUp))))&&((this.dispSiteWeightLimit == rhs.dispSiteWeightLimit)||((this.dispSiteWeightLimit!= null)&&this.dispSiteWeightLimit.equals(rhs.dispSiteWeightLimit))))&&((this.precharge == rhs.precharge)||((this.precharge!= null)&&this.precharge.equals(rhs.precharge))))&&((this.updatorName == rhs.updatorName)||((this.updatorName!= null)&&this.updatorName.equals(rhs.updatorName))))&&((this.siteExtendBit == rhs.siteExtendBit)||((this.siteExtendBit!= null)&&this.siteExtendBit.equals(rhs.siteExtendBit))))&&((this.lockVersion == rhs.lockVersion)||((this.lockVersion!= null)&&this.lockVersion.equals(rhs.lockVersion))))&&((this.createdTime == rhs.createdTime)||((this.createdTime!= null)&&this.createdTime.equals(rhs.createdTime))))&&((this.siteId == rhs.siteId)||((this.siteId!= null)&&this.siteId.equals(rhs.siteId))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
