
package com.flyingrain.autotest.service.model.baishi;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class SpecialServiceVo {

    private Integer lockVersion;
    private Integer cantonId;
    private String cantonNamePath;
    private Integer siteId;
    private String siteName;
    private String specialServiceName;
    private String specialService;
    private String dispatchTimeLimitName;
    private Boolean whetherChargeTownFee;
    private Double townToAcceptAddressDistance;
    private String specialServiceDisplay;
    private String dispServiceDisplay;
    private Boolean inBusinessArea;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Integer getLockVersion() {
        return lockVersion;
    }

    public void setLockVersion(Integer lockVersion) {
        this.lockVersion = lockVersion;
    }

    public Integer getCantonId() {
        return cantonId;
    }

    public void setCantonId(Integer cantonId) {
        this.cantonId = cantonId;
    }

    public String getCantonNamePath() {
        return cantonNamePath;
    }

    public void setCantonNamePath(String cantonNamePath) {
        this.cantonNamePath = cantonNamePath;
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

    public String getSpecialServiceName() {
        return specialServiceName;
    }

    public void setSpecialServiceName(String specialServiceName) {
        this.specialServiceName = specialServiceName;
    }

    public String getSpecialService() {
        return specialService;
    }

    public void setSpecialService(String specialService) {
        this.specialService = specialService;
    }

    public String getDispatchTimeLimitName() {
        return dispatchTimeLimitName;
    }

    public void setDispatchTimeLimitName(String dispatchTimeLimitName) {
        this.dispatchTimeLimitName = dispatchTimeLimitName;
    }

    public Boolean getWhetherChargeTownFee() {
        return whetherChargeTownFee;
    }

    public void setWhetherChargeTownFee(Boolean whetherChargeTownFee) {
        this.whetherChargeTownFee = whetherChargeTownFee;
    }

    public Double getTownToAcceptAddressDistance() {
        return townToAcceptAddressDistance;
    }

    public void setTownToAcceptAddressDistance(Double townToAcceptAddressDistance) {
        this.townToAcceptAddressDistance = townToAcceptAddressDistance;
    }

    public String getSpecialServiceDisplay() {
        return specialServiceDisplay;
    }

    public void setSpecialServiceDisplay(String specialServiceDisplay) {
        this.specialServiceDisplay = specialServiceDisplay;
    }

    public String getDispServiceDisplay() {
        return dispServiceDisplay;
    }

    public void setDispServiceDisplay(String dispServiceDisplay) {
        this.dispServiceDisplay = dispServiceDisplay;
    }

    public Boolean getInBusinessArea() {
        return inBusinessArea;
    }

    public void setInBusinessArea(Boolean inBusinessArea) {
        this.inBusinessArea = inBusinessArea;
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
        sb.append(SpecialServiceVo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("lockVersion");
        sb.append('=');
        sb.append(((this.lockVersion == null)?"<null>":this.lockVersion));
        sb.append(',');
        sb.append("cantonId");
        sb.append('=');
        sb.append(((this.cantonId == null)?"<null>":this.cantonId));
        sb.append(',');
        sb.append("cantonNamePath");
        sb.append('=');
        sb.append(((this.cantonNamePath == null)?"<null>":this.cantonNamePath));
        sb.append(',');
        sb.append("siteId");
        sb.append('=');
        sb.append(((this.siteId == null)?"<null>":this.siteId));
        sb.append(',');
        sb.append("siteName");
        sb.append('=');
        sb.append(((this.siteName == null)?"<null>":this.siteName));
        sb.append(',');
        sb.append("specialServiceName");
        sb.append('=');
        sb.append(((this.specialServiceName == null)?"<null>":this.specialServiceName));
        sb.append(',');
        sb.append("specialService");
        sb.append('=');
        sb.append(((this.specialService == null)?"<null>":this.specialService));
        sb.append(',');
        sb.append("dispatchTimeLimitName");
        sb.append('=');
        sb.append(((this.dispatchTimeLimitName == null)?"<null>":this.dispatchTimeLimitName));
        sb.append(',');
        sb.append("whetherChargeTownFee");
        sb.append('=');
        sb.append(((this.whetherChargeTownFee == null)?"<null>":this.whetherChargeTownFee));
        sb.append(',');
        sb.append("townToAcceptAddressDistance");
        sb.append('=');
        sb.append(((this.townToAcceptAddressDistance == null)?"<null>":this.townToAcceptAddressDistance));
        sb.append(',');
        sb.append("specialServiceDisplay");
        sb.append('=');
        sb.append(((this.specialServiceDisplay == null)?"<null>":this.specialServiceDisplay));
        sb.append(',');
        sb.append("dispServiceDisplay");
        sb.append('=');
        sb.append(((this.dispServiceDisplay == null)?"<null>":this.dispServiceDisplay));
        sb.append(',');
        sb.append("inBusinessArea");
        sb.append('=');
        sb.append(((this.inBusinessArea == null)?"<null>":this.inBusinessArea));
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
        result = ((result* 31)+((this.cantonId == null)? 0 :this.cantonId.hashCode()));
        result = ((result* 31)+((this.specialServiceName == null)? 0 :this.specialServiceName.hashCode()));
        result = ((result* 31)+((this.siteName == null)? 0 :this.siteName.hashCode()));
        result = ((result* 31)+((this.townToAcceptAddressDistance == null)? 0 :this.townToAcceptAddressDistance.hashCode()));
        result = ((result* 31)+((this.specialServiceDisplay == null)? 0 :this.specialServiceDisplay.hashCode()));
        result = ((result* 31)+((this.dispServiceDisplay == null)? 0 :this.dispServiceDisplay.hashCode()));
        result = ((result* 31)+((this.lockVersion == null)? 0 :this.lockVersion.hashCode()));
        result = ((result* 31)+((this.specialService == null)? 0 :this.specialService.hashCode()));
        result = ((result* 31)+((this.siteId == null)? 0 :this.siteId.hashCode()));
        result = ((result* 31)+((this.dispatchTimeLimitName == null)? 0 :this.dispatchTimeLimitName.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.whetherChargeTownFee == null)? 0 :this.whetherChargeTownFee.hashCode()));
        result = ((result* 31)+((this.cantonNamePath == null)? 0 :this.cantonNamePath.hashCode()));
        result = ((result* 31)+((this.inBusinessArea == null)? 0 :this.inBusinessArea.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SpecialServiceVo) == false) {
            return false;
        }
        SpecialServiceVo rhs = ((SpecialServiceVo) other);
        return (((((((((((((((this.cantonId == rhs.cantonId)||((this.cantonId!= null)&&this.cantonId.equals(rhs.cantonId)))&&((this.specialServiceName == rhs.specialServiceName)||((this.specialServiceName!= null)&&this.specialServiceName.equals(rhs.specialServiceName))))&&((this.siteName == rhs.siteName)||((this.siteName!= null)&&this.siteName.equals(rhs.siteName))))&&((this.townToAcceptAddressDistance == rhs.townToAcceptAddressDistance)||((this.townToAcceptAddressDistance!= null)&&this.townToAcceptAddressDistance.equals(rhs.townToAcceptAddressDistance))))&&((this.specialServiceDisplay == rhs.specialServiceDisplay)||((this.specialServiceDisplay!= null)&&this.specialServiceDisplay.equals(rhs.specialServiceDisplay))))&&((this.dispServiceDisplay == rhs.dispServiceDisplay)||((this.dispServiceDisplay!= null)&&this.dispServiceDisplay.equals(rhs.dispServiceDisplay))))&&((this.lockVersion == rhs.lockVersion)||((this.lockVersion!= null)&&this.lockVersion.equals(rhs.lockVersion))))&&((this.specialService == rhs.specialService)||((this.specialService!= null)&&this.specialService.equals(rhs.specialService))))&&((this.siteId == rhs.siteId)||((this.siteId!= null)&&this.siteId.equals(rhs.siteId))))&&((this.dispatchTimeLimitName == rhs.dispatchTimeLimitName)||((this.dispatchTimeLimitName!= null)&&this.dispatchTimeLimitName.equals(rhs.dispatchTimeLimitName))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.whetherChargeTownFee == rhs.whetherChargeTownFee)||((this.whetherChargeTownFee!= null)&&this.whetherChargeTownFee.equals(rhs.whetherChargeTownFee))))&&((this.cantonNamePath == rhs.cantonNamePath)||((this.cantonNamePath!= null)&&this.cantonNamePath.equals(rhs.cantonNamePath))))&&((this.inBusinessArea == rhs.inBusinessArea)||((this.inBusinessArea!= null)&&this.inBusinessArea.equals(rhs.inBusinessArea))));
    }

}
