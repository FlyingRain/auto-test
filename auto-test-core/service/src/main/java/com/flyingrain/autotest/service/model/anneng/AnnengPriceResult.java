
package com.flyingrain.autotest.service.model.anneng;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class AnnengPriceResult {

    private Boolean result;
    private String batchId;
    private Object reson;
    private ResultInfo resultInfo;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public Object getReson() {
        return reson;
    }

    public void setReson(Object reson) {
        this.reson = reson;
    }

    public ResultInfo getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(ResultInfo resultInfo) {
        this.resultInfo = resultInfo;
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
        sb.append(AnnengPriceResult.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("result");
        sb.append('=');
        sb.append(((this.result == null)?"<null>":this.result));
        sb.append(',');
        sb.append("batchId");
        sb.append('=');
        sb.append(((this.batchId == null)?"<null>":this.batchId));
        sb.append(',');
        sb.append("reson");
        sb.append('=');
        sb.append(((this.reson == null)?"<null>":this.reson));
        sb.append(',');
        sb.append("resultInfo");
        sb.append('=');
        sb.append(((this.resultInfo == null)?"<null>":this.resultInfo));
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
        result = ((result* 31)+((this.result == null)? 0 :this.result.hashCode()));
        result = ((result* 31)+((this.reson == null)? 0 :this.reson.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.batchId == null)? 0 :this.batchId.hashCode()));
        result = ((result* 31)+((this.resultInfo == null)? 0 :this.resultInfo.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AnnengPriceResult) == false) {
            return false;
        }
        AnnengPriceResult rhs = ((AnnengPriceResult) other);
        return ((((((this.result == rhs.result)||((this.result!= null)&&this.result.equals(rhs.result)))&&((this.reson == rhs.reson)||((this.reson!= null)&&this.reson.equals(rhs.reson))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.batchId == rhs.batchId)||((this.batchId!= null)&&this.batchId.equals(rhs.batchId))))&&((this.resultInfo == rhs.resultInfo)||((this.resultInfo!= null)&&this.resultInfo.equals(rhs.resultInfo))));
    }

}
