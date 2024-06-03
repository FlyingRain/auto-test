
package com.flyingrain.autotest.service.model.baishi;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class CbSiteRouteVo {

    private Integer lockVersion;
    private Integer sendSiteId;
    private String sendSiteName;
    private String sendSiteCode;
    private Integer dispSiteId;
    private String dispSiteCode;
    private String dispSiteName;
    private Integer inletCenterId;
    private String inletCenterCode;
    private String inletCenterName;
    private Integer outletCenterId;
    private String outletCenterCode;
    private String outletCenterName;
    private Integer sendFirstSiteId;
    private String sendFirstSiteName;
    private String sendFirstSiteCode;
    private Integer dispFirstSiteId;
    private String dispFirstSiteName;
    private String dispFirstSiteCode;
    private String path;
    private String pathCode;
    private String centerRoute;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Integer getLockVersion() {
        return lockVersion;
    }

    public void setLockVersion(Integer lockVersion) {
        this.lockVersion = lockVersion;
    }

    public Integer getSendSiteId() {
        return sendSiteId;
    }

    public void setSendSiteId(Integer sendSiteId) {
        this.sendSiteId = sendSiteId;
    }

    public String getSendSiteName() {
        return sendSiteName;
    }

    public void setSendSiteName(String sendSiteName) {
        this.sendSiteName = sendSiteName;
    }

    public String getSendSiteCode() {
        return sendSiteCode;
    }

    public void setSendSiteCode(String sendSiteCode) {
        this.sendSiteCode = sendSiteCode;
    }

    public Integer getDispSiteId() {
        return dispSiteId;
    }

    public void setDispSiteId(Integer dispSiteId) {
        this.dispSiteId = dispSiteId;
    }

    public String getDispSiteCode() {
        return dispSiteCode;
    }

    public void setDispSiteCode(String dispSiteCode) {
        this.dispSiteCode = dispSiteCode;
    }

    public String getDispSiteName() {
        return dispSiteName;
    }

    public void setDispSiteName(String dispSiteName) {
        this.dispSiteName = dispSiteName;
    }

    public Integer getInletCenterId() {
        return inletCenterId;
    }

    public void setInletCenterId(Integer inletCenterId) {
        this.inletCenterId = inletCenterId;
    }

    public String getInletCenterCode() {
        return inletCenterCode;
    }

    public void setInletCenterCode(String inletCenterCode) {
        this.inletCenterCode = inletCenterCode;
    }

    public String getInletCenterName() {
        return inletCenterName;
    }

    public void setInletCenterName(String inletCenterName) {
        this.inletCenterName = inletCenterName;
    }

    public Integer getOutletCenterId() {
        return outletCenterId;
    }

    public void setOutletCenterId(Integer outletCenterId) {
        this.outletCenterId = outletCenterId;
    }

    public String getOutletCenterCode() {
        return outletCenterCode;
    }

    public void setOutletCenterCode(String outletCenterCode) {
        this.outletCenterCode = outletCenterCode;
    }

    public String getOutletCenterName() {
        return outletCenterName;
    }

    public void setOutletCenterName(String outletCenterName) {
        this.outletCenterName = outletCenterName;
    }

    public Integer getSendFirstSiteId() {
        return sendFirstSiteId;
    }

    public void setSendFirstSiteId(Integer sendFirstSiteId) {
        this.sendFirstSiteId = sendFirstSiteId;
    }

    public String getSendFirstSiteName() {
        return sendFirstSiteName;
    }

    public void setSendFirstSiteName(String sendFirstSiteName) {
        this.sendFirstSiteName = sendFirstSiteName;
    }

    public String getSendFirstSiteCode() {
        return sendFirstSiteCode;
    }

    public void setSendFirstSiteCode(String sendFirstSiteCode) {
        this.sendFirstSiteCode = sendFirstSiteCode;
    }

    public Integer getDispFirstSiteId() {
        return dispFirstSiteId;
    }

    public void setDispFirstSiteId(Integer dispFirstSiteId) {
        this.dispFirstSiteId = dispFirstSiteId;
    }

    public String getDispFirstSiteName() {
        return dispFirstSiteName;
    }

    public void setDispFirstSiteName(String dispFirstSiteName) {
        this.dispFirstSiteName = dispFirstSiteName;
    }

    public String getDispFirstSiteCode() {
        return dispFirstSiteCode;
    }

    public void setDispFirstSiteCode(String dispFirstSiteCode) {
        this.dispFirstSiteCode = dispFirstSiteCode;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPathCode() {
        return pathCode;
    }

    public void setPathCode(String pathCode) {
        this.pathCode = pathCode;
    }

    public String getCenterRoute() {
        return centerRoute;
    }

    public void setCenterRoute(String centerRoute) {
        this.centerRoute = centerRoute;
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
        sb.append(CbSiteRouteVo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("lockVersion");
        sb.append('=');
        sb.append(((this.lockVersion == null)?"<null>":this.lockVersion));
        sb.append(',');
        sb.append("sendSiteId");
        sb.append('=');
        sb.append(((this.sendSiteId == null)?"<null>":this.sendSiteId));
        sb.append(',');
        sb.append("sendSiteName");
        sb.append('=');
        sb.append(((this.sendSiteName == null)?"<null>":this.sendSiteName));
        sb.append(',');
        sb.append("sendSiteCode");
        sb.append('=');
        sb.append(((this.sendSiteCode == null)?"<null>":this.sendSiteCode));
        sb.append(',');
        sb.append("dispSiteId");
        sb.append('=');
        sb.append(((this.dispSiteId == null)?"<null>":this.dispSiteId));
        sb.append(',');
        sb.append("dispSiteCode");
        sb.append('=');
        sb.append(((this.dispSiteCode == null)?"<null>":this.dispSiteCode));
        sb.append(',');
        sb.append("dispSiteName");
        sb.append('=');
        sb.append(((this.dispSiteName == null)?"<null>":this.dispSiteName));
        sb.append(',');
        sb.append("inletCenterId");
        sb.append('=');
        sb.append(((this.inletCenterId == null)?"<null>":this.inletCenterId));
        sb.append(',');
        sb.append("inletCenterCode");
        sb.append('=');
        sb.append(((this.inletCenterCode == null)?"<null>":this.inletCenterCode));
        sb.append(',');
        sb.append("inletCenterName");
        sb.append('=');
        sb.append(((this.inletCenterName == null)?"<null>":this.inletCenterName));
        sb.append(',');
        sb.append("outletCenterId");
        sb.append('=');
        sb.append(((this.outletCenterId == null)?"<null>":this.outletCenterId));
        sb.append(',');
        sb.append("outletCenterCode");
        sb.append('=');
        sb.append(((this.outletCenterCode == null)?"<null>":this.outletCenterCode));
        sb.append(',');
        sb.append("outletCenterName");
        sb.append('=');
        sb.append(((this.outletCenterName == null)?"<null>":this.outletCenterName));
        sb.append(',');
        sb.append("sendFirstSiteId");
        sb.append('=');
        sb.append(((this.sendFirstSiteId == null)?"<null>":this.sendFirstSiteId));
        sb.append(',');
        sb.append("sendFirstSiteName");
        sb.append('=');
        sb.append(((this.sendFirstSiteName == null)?"<null>":this.sendFirstSiteName));
        sb.append(',');
        sb.append("sendFirstSiteCode");
        sb.append('=');
        sb.append(((this.sendFirstSiteCode == null)?"<null>":this.sendFirstSiteCode));
        sb.append(',');
        sb.append("dispFirstSiteId");
        sb.append('=');
        sb.append(((this.dispFirstSiteId == null)?"<null>":this.dispFirstSiteId));
        sb.append(',');
        sb.append("dispFirstSiteName");
        sb.append('=');
        sb.append(((this.dispFirstSiteName == null)?"<null>":this.dispFirstSiteName));
        sb.append(',');
        sb.append("dispFirstSiteCode");
        sb.append('=');
        sb.append(((this.dispFirstSiteCode == null)?"<null>":this.dispFirstSiteCode));
        sb.append(',');
        sb.append("path");
        sb.append('=');
        sb.append(((this.path == null)?"<null>":this.path));
        sb.append(',');
        sb.append("pathCode");
        sb.append('=');
        sb.append(((this.pathCode == null)?"<null>":this.pathCode));
        sb.append(',');
        sb.append("centerRoute");
        sb.append('=');
        sb.append(((this.centerRoute == null)?"<null>":this.centerRoute));
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
        result = ((result* 31)+((this.dispSiteName == null)? 0 :this.dispSiteName.hashCode()));
        result = ((result* 31)+((this.sendFirstSiteCode == null)? 0 :this.sendFirstSiteCode.hashCode()));
        result = ((result* 31)+((this.dispFirstSiteCode == null)? 0 :this.dispFirstSiteCode.hashCode()));
        result = ((result* 31)+((this.sendSiteId == null)? 0 :this.sendSiteId.hashCode()));
        result = ((result* 31)+((this.centerRoute == null)? 0 :this.centerRoute.hashCode()));
        result = ((result* 31)+((this.dispSiteId == null)? 0 :this.dispSiteId.hashCode()));
        result = ((result* 31)+((this.dispFirstSiteName == null)? 0 :this.dispFirstSiteName.hashCode()));
        result = ((result* 31)+((this.dispSiteCode == null)? 0 :this.dispSiteCode.hashCode()));
        result = ((result* 31)+((this.inletCenterName == null)? 0 :this.inletCenterName.hashCode()));
        result = ((result* 31)+((this.inletCenterCode == null)? 0 :this.inletCenterCode.hashCode()));
        result = ((result* 31)+((this.dispFirstSiteId == null)? 0 :this.dispFirstSiteId.hashCode()));
        result = ((result* 31)+((this.path == null)? 0 :this.path.hashCode()));
        result = ((result* 31)+((this.inletCenterId == null)? 0 :this.inletCenterId.hashCode()));
        result = ((result* 31)+((this.outletCenterId == null)? 0 :this.outletCenterId.hashCode()));
        result = ((result* 31)+((this.sendFirstSiteId == null)? 0 :this.sendFirstSiteId.hashCode()));
        result = ((result* 31)+((this.lockVersion == null)? 0 :this.lockVersion.hashCode()));
        result = ((result* 31)+((this.outletCenterName == null)? 0 :this.outletCenterName.hashCode()));
        result = ((result* 31)+((this.pathCode == null)? 0 :this.pathCode.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.sendSiteName == null)? 0 :this.sendSiteName.hashCode()));
        result = ((result* 31)+((this.sendFirstSiteName == null)? 0 :this.sendFirstSiteName.hashCode()));
        result = ((result* 31)+((this.sendSiteCode == null)? 0 :this.sendSiteCode.hashCode()));
        result = ((result* 31)+((this.outletCenterCode == null)? 0 :this.outletCenterCode.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CbSiteRouteVo) == false) {
            return false;
        }
        CbSiteRouteVo rhs = ((CbSiteRouteVo) other);
        return ((((((((((((((((((((((((this.dispSiteName == rhs.dispSiteName)||((this.dispSiteName!= null)&&this.dispSiteName.equals(rhs.dispSiteName)))&&((this.sendFirstSiteCode == rhs.sendFirstSiteCode)||((this.sendFirstSiteCode!= null)&&this.sendFirstSiteCode.equals(rhs.sendFirstSiteCode))))&&((this.dispFirstSiteCode == rhs.dispFirstSiteCode)||((this.dispFirstSiteCode!= null)&&this.dispFirstSiteCode.equals(rhs.dispFirstSiteCode))))&&((this.sendSiteId == rhs.sendSiteId)||((this.sendSiteId!= null)&&this.sendSiteId.equals(rhs.sendSiteId))))&&((this.centerRoute == rhs.centerRoute)||((this.centerRoute!= null)&&this.centerRoute.equals(rhs.centerRoute))))&&((this.dispSiteId == rhs.dispSiteId)||((this.dispSiteId!= null)&&this.dispSiteId.equals(rhs.dispSiteId))))&&((this.dispFirstSiteName == rhs.dispFirstSiteName)||((this.dispFirstSiteName!= null)&&this.dispFirstSiteName.equals(rhs.dispFirstSiteName))))&&((this.dispSiteCode == rhs.dispSiteCode)||((this.dispSiteCode!= null)&&this.dispSiteCode.equals(rhs.dispSiteCode))))&&((this.inletCenterName == rhs.inletCenterName)||((this.inletCenterName!= null)&&this.inletCenterName.equals(rhs.inletCenterName))))&&((this.inletCenterCode == rhs.inletCenterCode)||((this.inletCenterCode!= null)&&this.inletCenterCode.equals(rhs.inletCenterCode))))&&((this.dispFirstSiteId == rhs.dispFirstSiteId)||((this.dispFirstSiteId!= null)&&this.dispFirstSiteId.equals(rhs.dispFirstSiteId))))&&((this.path == rhs.path)||((this.path!= null)&&this.path.equals(rhs.path))))&&((this.inletCenterId == rhs.inletCenterId)||((this.inletCenterId!= null)&&this.inletCenterId.equals(rhs.inletCenterId))))&&((this.outletCenterId == rhs.outletCenterId)||((this.outletCenterId!= null)&&this.outletCenterId.equals(rhs.outletCenterId))))&&((this.sendFirstSiteId == rhs.sendFirstSiteId)||((this.sendFirstSiteId!= null)&&this.sendFirstSiteId.equals(rhs.sendFirstSiteId))))&&((this.lockVersion == rhs.lockVersion)||((this.lockVersion!= null)&&this.lockVersion.equals(rhs.lockVersion))))&&((this.outletCenterName == rhs.outletCenterName)||((this.outletCenterName!= null)&&this.outletCenterName.equals(rhs.outletCenterName))))&&((this.pathCode == rhs.pathCode)||((this.pathCode!= null)&&this.pathCode.equals(rhs.pathCode))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.sendSiteName == rhs.sendSiteName)||((this.sendSiteName!= null)&&this.sendSiteName.equals(rhs.sendSiteName))))&&((this.sendFirstSiteName == rhs.sendFirstSiteName)||((this.sendFirstSiteName!= null)&&this.sendFirstSiteName.equals(rhs.sendFirstSiteName))))&&((this.sendSiteCode == rhs.sendSiteCode)||((this.sendSiteCode!= null)&&this.sendSiteCode.equals(rhs.sendSiteCode))))&&((this.outletCenterCode == rhs.outletCenterCode)||((this.outletCenterCode!= null)&&this.outletCenterCode.equals(rhs.outletCenterCode))));
    }

}
