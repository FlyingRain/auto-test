
package com.flyingrain.autotest.service.model.zhongtong;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class AddressLimitInfo {

    private String remark;
    private LimitThreshold limitThreshold;
    private String limitAreaId;
    private String limitAreaName;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public LimitThreshold getLimitThreshold() {
        return limitThreshold;
    }

    public void setLimitThreshold(LimitThreshold limitThreshold) {
        this.limitThreshold = limitThreshold;
    }

    public String getLimitAreaId() {
        return limitAreaId;
    }

    public void setLimitAreaId(String limitAreaId) {
        this.limitAreaId = limitAreaId;
    }

    public String getLimitAreaName() {
        return limitAreaName;
    }

    public void setLimitAreaName(String limitAreaName) {
        this.limitAreaName = limitAreaName;
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
        sb.append(AddressLimitInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("remark");
        sb.append('=');
        sb.append(((this.remark == null)?"<null>":this.remark));
        sb.append(',');
        sb.append("limitThreshold");
        sb.append('=');
        sb.append(((this.limitThreshold == null)?"<null>":this.limitThreshold));
        sb.append(',');
        sb.append("limitAreaId");
        sb.append('=');
        sb.append(((this.limitAreaId == null)?"<null>":this.limitAreaId));
        sb.append(',');
        sb.append("limitAreaName");
        sb.append('=');
        sb.append(((this.limitAreaName == null)?"<null>":this.limitAreaName));
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
        result = ((result* 31)+((this.remark == null)? 0 :this.remark.hashCode()));
        result = ((result* 31)+((this.limitThreshold == null)? 0 :this.limitThreshold.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.limitAreaId == null)? 0 :this.limitAreaId.hashCode()));
        result = ((result* 31)+((this.limitAreaName == null)? 0 :this.limitAreaName.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AddressLimitInfo) == false) {
            return false;
        }
        AddressLimitInfo rhs = ((AddressLimitInfo) other);
        return ((((((this.remark == rhs.remark)||((this.remark!= null)&&this.remark.equals(rhs.remark)))&&((this.limitThreshold == rhs.limitThreshold)||((this.limitThreshold!= null)&&this.limitThreshold.equals(rhs.limitThreshold))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.limitAreaId == rhs.limitAreaId)||((this.limitAreaId!= null)&&this.limitAreaId.equals(rhs.limitAreaId))))&&((this.limitAreaName == rhs.limitAreaName)||((this.limitAreaName!= null)&&this.limitAreaName.equals(rhs.limitAreaName))));
    }

}
