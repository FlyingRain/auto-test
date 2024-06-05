
package com.flyingrain.autotest.service.model.zhongtong;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class RouteCodeInfo {

    private String thirdCode;
    private String dispatcherCode;
    private String firstCode;
    private String secondCode;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public String getThirdCode() {
        return thirdCode;
    }

    public void setThirdCode(String thirdCode) {
        this.thirdCode = thirdCode;
    }

    public String getDispatcherCode() {
        return dispatcherCode;
    }

    public void setDispatcherCode(String dispatcherCode) {
        this.dispatcherCode = dispatcherCode;
    }

    public String getFirstCode() {
        return firstCode;
    }

    public void setFirstCode(String firstCode) {
        this.firstCode = firstCode;
    }

    public String getSecondCode() {
        return secondCode;
    }

    public void setSecondCode(String secondCode) {
        this.secondCode = secondCode;
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
        sb.append(RouteCodeInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("thirdCode");
        sb.append('=');
        sb.append(((this.thirdCode == null)?"<null>":this.thirdCode));
        sb.append(',');
        sb.append("dispatcherCode");
        sb.append('=');
        sb.append(((this.dispatcherCode == null)?"<null>":this.dispatcherCode));
        sb.append(',');
        sb.append("firstCode");
        sb.append('=');
        sb.append(((this.firstCode == null)?"<null>":this.firstCode));
        sb.append(',');
        sb.append("secondCode");
        sb.append('=');
        sb.append(((this.secondCode == null)?"<null>":this.secondCode));
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
        result = ((result* 31)+((this.thirdCode == null)? 0 :this.thirdCode.hashCode()));
        result = ((result* 31)+((this.dispatcherCode == null)? 0 :this.dispatcherCode.hashCode()));
        result = ((result* 31)+((this.firstCode == null)? 0 :this.firstCode.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.secondCode == null)? 0 :this.secondCode.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RouteCodeInfo) == false) {
            return false;
        }
        RouteCodeInfo rhs = ((RouteCodeInfo) other);
        return ((((((this.thirdCode == rhs.thirdCode)||((this.thirdCode!= null)&&this.thirdCode.equals(rhs.thirdCode)))&&((this.dispatcherCode == rhs.dispatcherCode)||((this.dispatcherCode!= null)&&this.dispatcherCode.equals(rhs.dispatcherCode))))&&((this.firstCode == rhs.firstCode)||((this.firstCode!= null)&&this.firstCode.equals(rhs.firstCode))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.secondCode == rhs.secondCode)||((this.secondCode!= null)&&this.secondCode.equals(rhs.secondCode))));
    }

}
