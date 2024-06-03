
package com.flyingrain.autotest.service.model.baishi.generate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class BaishiAddressInfo {

    private Integer lockVersion;
    private CbSiteRouteVo cbSiteRouteVo;
    private String specialServiceName;
    private SpecialServiceVo specialServiceVo;
    private ParseTownVo parseTownVo;
    private ParseSiteVo parseSiteVo;
    private String addressThreeCanton;
    private String siteParseType;
    private List<SpecialArea> specialAreaList = new ArrayList<SpecialArea>();
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Integer getLockVersion() {
        return lockVersion;
    }

    public void setLockVersion(Integer lockVersion) {
        this.lockVersion = lockVersion;
    }

    public CbSiteRouteVo getCbSiteRouteVo() {
        return cbSiteRouteVo;
    }

    public void setCbSiteRouteVo(CbSiteRouteVo cbSiteRouteVo) {
        this.cbSiteRouteVo = cbSiteRouteVo;
    }

    public String getSpecialServiceName() {
        return specialServiceName;
    }

    public void setSpecialServiceName(String specialServiceName) {
        this.specialServiceName = specialServiceName;
    }

    public SpecialServiceVo getSpecialServiceVo() {
        return specialServiceVo;
    }

    public void setSpecialServiceVo(SpecialServiceVo specialServiceVo) {
        this.specialServiceVo = specialServiceVo;
    }

    public ParseTownVo getParseTownVo() {
        return parseTownVo;
    }

    public void setParseTownVo(ParseTownVo parseTownVo) {
        this.parseTownVo = parseTownVo;
    }

    public ParseSiteVo getParseSiteVo() {
        return parseSiteVo;
    }

    public void setParseSiteVo(ParseSiteVo parseSiteVo) {
        this.parseSiteVo = parseSiteVo;
    }

    public String getAddressThreeCanton() {
        return addressThreeCanton;
    }

    public void setAddressThreeCanton(String addressThreeCanton) {
        this.addressThreeCanton = addressThreeCanton;
    }

    public String getSiteParseType() {
        return siteParseType;
    }

    public void setSiteParseType(String siteParseType) {
        this.siteParseType = siteParseType;
    }

    public List<SpecialArea> getSpecialAreaList() {
        return specialAreaList;
    }

    public void setSpecialAreaList(List<SpecialArea> specialAreaList) {
        this.specialAreaList = specialAreaList;
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
        sb.append(BaishiAddressInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("lockVersion");
        sb.append('=');
        sb.append(((this.lockVersion == null)?"<null>":this.lockVersion));
        sb.append(',');
        sb.append("cbSiteRouteVo");
        sb.append('=');
        sb.append(((this.cbSiteRouteVo == null)?"<null>":this.cbSiteRouteVo));
        sb.append(',');
        sb.append("specialServiceName");
        sb.append('=');
        sb.append(((this.specialServiceName == null)?"<null>":this.specialServiceName));
        sb.append(',');
        sb.append("specialServiceVo");
        sb.append('=');
        sb.append(((this.specialServiceVo == null)?"<null>":this.specialServiceVo));
        sb.append(',');
        sb.append("parseTownVo");
        sb.append('=');
        sb.append(((this.parseTownVo == null)?"<null>":this.parseTownVo));
        sb.append(',');
        sb.append("parseSiteVo");
        sb.append('=');
        sb.append(((this.parseSiteVo == null)?"<null>":this.parseSiteVo));
        sb.append(',');
        sb.append("addressThreeCanton");
        sb.append('=');
        sb.append(((this.addressThreeCanton == null)?"<null>":this.addressThreeCanton));
        sb.append(',');
        sb.append("siteParseType");
        sb.append('=');
        sb.append(((this.siteParseType == null)?"<null>":this.siteParseType));
        sb.append(',');
        sb.append("specialAreaList");
        sb.append('=');
        sb.append(((this.specialAreaList == null)?"<null>":this.specialAreaList));
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
        result = ((result* 31)+((this.specialAreaList == null)? 0 :this.specialAreaList.hashCode()));
        result = ((result* 31)+((this.specialServiceName == null)? 0 :this.specialServiceName.hashCode()));
        result = ((result* 31)+((this.specialServiceVo == null)? 0 :this.specialServiceVo.hashCode()));
        result = ((result* 31)+((this.siteParseType == null)? 0 :this.siteParseType.hashCode()));
        result = ((result* 31)+((this.cbSiteRouteVo == null)? 0 :this.cbSiteRouteVo.hashCode()));
        result = ((result* 31)+((this.lockVersion == null)? 0 :this.lockVersion.hashCode()));
        result = ((result* 31)+((this.parseSiteVo == null)? 0 :this.parseSiteVo.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.parseTownVo == null)? 0 :this.parseTownVo.hashCode()));
        result = ((result* 31)+((this.addressThreeCanton == null)? 0 :this.addressThreeCanton.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BaishiAddressInfo) == false) {
            return false;
        }
        BaishiAddressInfo rhs = ((BaishiAddressInfo) other);
        return (((((((((((this.specialAreaList == rhs.specialAreaList)||((this.specialAreaList!= null)&&this.specialAreaList.equals(rhs.specialAreaList)))&&((this.specialServiceName == rhs.specialServiceName)||((this.specialServiceName!= null)&&this.specialServiceName.equals(rhs.specialServiceName))))&&((this.specialServiceVo == rhs.specialServiceVo)||((this.specialServiceVo!= null)&&this.specialServiceVo.equals(rhs.specialServiceVo))))&&((this.siteParseType == rhs.siteParseType)||((this.siteParseType!= null)&&this.siteParseType.equals(rhs.siteParseType))))&&((this.cbSiteRouteVo == rhs.cbSiteRouteVo)||((this.cbSiteRouteVo!= null)&&this.cbSiteRouteVo.equals(rhs.cbSiteRouteVo))))&&((this.lockVersion == rhs.lockVersion)||((this.lockVersion!= null)&&this.lockVersion.equals(rhs.lockVersion))))&&((this.parseSiteVo == rhs.parseSiteVo)||((this.parseSiteVo!= null)&&this.parseSiteVo.equals(rhs.parseSiteVo))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.parseTownVo == rhs.parseTownVo)||((this.parseTownVo!= null)&&this.parseTownVo.equals(rhs.parseTownVo))))&&((this.addressThreeCanton == rhs.addressThreeCanton)||((this.addressThreeCanton!= null)&&this.addressThreeCanton.equals(rhs.addressThreeCanton))));
    }

}
