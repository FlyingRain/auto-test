
package com.flyingrain.autotest.service.model.yimi;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class YimiPriceResult {

    private Double costFee;
    private Double serviceFee;
    private Integer compMode;
    private Integer settleMode;
    private Double incomeFee;
    private Double payFee;
    private String routeLine;
    private Double otherFee;
    private Double transferCostFee;
    private List<List<String>> configs = new ArrayList<List<String>>();
    private Double srcDeptPayFeeAmt;
    private List<List<String>> srcDeptPayFeeDetailConfigs = new ArrayList<List<String>>();
    private List<List<String>> sumFeeTypeDetailConfigs = new ArrayList<List<String>>();
    private Double oneDeptAddCostFee;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Double getCostFee() {
        return costFee;
    }

    public void setCostFee(Double costFee) {
        this.costFee = costFee;
    }

    public Double getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(Double serviceFee) {
        this.serviceFee = serviceFee;
    }

    public Integer getCompMode() {
        return compMode;
    }

    public void setCompMode(Integer compMode) {
        this.compMode = compMode;
    }

    public Integer getSettleMode() {
        return settleMode;
    }

    public void setSettleMode(Integer settleMode) {
        this.settleMode = settleMode;
    }

    public Double getIncomeFee() {
        return incomeFee;
    }

    public void setIncomeFee(Double incomeFee) {
        this.incomeFee = incomeFee;
    }

    public Double getPayFee() {
        return payFee;
    }

    public void setPayFee(Double payFee) {
        this.payFee = payFee;
    }

    public String getRouteLine() {
        return routeLine;
    }

    public void setRouteLine(String routeLine) {
        this.routeLine = routeLine;
    }

    public Double getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(Double otherFee) {
        this.otherFee = otherFee;
    }

    public Double getTransferCostFee() {
        return transferCostFee;
    }

    public void setTransferCostFee(Double transferCostFee) {
        this.transferCostFee = transferCostFee;
    }

    public List<List<String>> getConfigs() {
        return configs;
    }

    public void setConfigs(List<List<String>> configs) {
        this.configs = configs;
    }

    public Double getSrcDeptPayFeeAmt() {
        return srcDeptPayFeeAmt;
    }

    public void setSrcDeptPayFeeAmt(Double srcDeptPayFeeAmt) {
        this.srcDeptPayFeeAmt = srcDeptPayFeeAmt;
    }

    public List<List<String>> getSrcDeptPayFeeDetailConfigs() {
        return srcDeptPayFeeDetailConfigs;
    }

    public void setSrcDeptPayFeeDetailConfigs(List<List<String>> srcDeptPayFeeDetailConfigs) {
        this.srcDeptPayFeeDetailConfigs = srcDeptPayFeeDetailConfigs;
    }

    public List<List<String>> getSumFeeTypeDetailConfigs() {
        return sumFeeTypeDetailConfigs;
    }

    public void setSumFeeTypeDetailConfigs(List<List<String>> sumFeeTypeDetailConfigs) {
        this.sumFeeTypeDetailConfigs = sumFeeTypeDetailConfigs;
    }

    public Double getOneDeptAddCostFee() {
        return oneDeptAddCostFee;
    }

    public void setOneDeptAddCostFee(Double oneDeptAddCostFee) {
        this.oneDeptAddCostFee = oneDeptAddCostFee;
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
        sb.append(YimiPriceResult.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("costFee");
        sb.append('=');
        sb.append(((this.costFee == null)?"<null>":this.costFee));
        sb.append(',');
        sb.append("serviceFee");
        sb.append('=');
        sb.append(((this.serviceFee == null)?"<null>":this.serviceFee));
        sb.append(',');
        sb.append("compMode");
        sb.append('=');
        sb.append(((this.compMode == null)?"<null>":this.compMode));
        sb.append(',');
        sb.append("settleMode");
        sb.append('=');
        sb.append(((this.settleMode == null)?"<null>":this.settleMode));
        sb.append(',');
        sb.append("incomeFee");
        sb.append('=');
        sb.append(((this.incomeFee == null)?"<null>":this.incomeFee));
        sb.append(',');
        sb.append("payFee");
        sb.append('=');
        sb.append(((this.payFee == null)?"<null>":this.payFee));
        sb.append(',');
        sb.append("routeLine");
        sb.append('=');
        sb.append(((this.routeLine == null)?"<null>":this.routeLine));
        sb.append(',');
        sb.append("otherFee");
        sb.append('=');
        sb.append(((this.otherFee == null)?"<null>":this.otherFee));
        sb.append(',');
        sb.append("transferCostFee");
        sb.append('=');
        sb.append(((this.transferCostFee == null)?"<null>":this.transferCostFee));
        sb.append(',');
        sb.append("configs");
        sb.append('=');
        sb.append(((this.configs == null)?"<null>":this.configs));
        sb.append(',');
        sb.append("srcDeptPayFeeAmt");
        sb.append('=');
        sb.append(((this.srcDeptPayFeeAmt == null)?"<null>":this.srcDeptPayFeeAmt));
        sb.append(',');
        sb.append("srcDeptPayFeeDetailConfigs");
        sb.append('=');
        sb.append(((this.srcDeptPayFeeDetailConfigs == null)?"<null>":this.srcDeptPayFeeDetailConfigs));
        sb.append(',');
        sb.append("sumFeeTypeDetailConfigs");
        sb.append('=');
        sb.append(((this.sumFeeTypeDetailConfigs == null)?"<null>":this.sumFeeTypeDetailConfigs));
        sb.append(',');
        sb.append("oneDeptAddCostFee");
        sb.append('=');
        sb.append(((this.oneDeptAddCostFee == null)?"<null>":this.oneDeptAddCostFee));
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
        result = ((result* 31)+((this.serviceFee == null)? 0 :this.serviceFee.hashCode()));
        result = ((result* 31)+((this.configs == null)? 0 :this.configs.hashCode()));
        result = ((result* 31)+((this.costFee == null)? 0 :this.costFee.hashCode()));
        result = ((result* 31)+((this.compMode == null)? 0 :this.compMode.hashCode()));
        result = ((result* 31)+((this.sumFeeTypeDetailConfigs == null)? 0 :this.sumFeeTypeDetailConfigs.hashCode()));
        result = ((result* 31)+((this.oneDeptAddCostFee == null)? 0 :this.oneDeptAddCostFee.hashCode()));
        result = ((result* 31)+((this.routeLine == null)? 0 :this.routeLine.hashCode()));
        result = ((result* 31)+((this.otherFee == null)? 0 :this.otherFee.hashCode()));
        result = ((result* 31)+((this.incomeFee == null)? 0 :this.incomeFee.hashCode()));
        result = ((result* 31)+((this.transferCostFee == null)? 0 :this.transferCostFee.hashCode()));
        result = ((result* 31)+((this.payFee == null)? 0 :this.payFee.hashCode()));
        result = ((result* 31)+((this.srcDeptPayFeeAmt == null)? 0 :this.srcDeptPayFeeAmt.hashCode()));
        result = ((result* 31)+((this.settleMode == null)? 0 :this.settleMode.hashCode()));
        result = ((result* 31)+((this.srcDeptPayFeeDetailConfigs == null)? 0 :this.srcDeptPayFeeDetailConfigs.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof YimiPriceResult) == false) {
            return false;
        }
        YimiPriceResult rhs = ((YimiPriceResult) other);
        return ((((((((((((((((this.serviceFee == rhs.serviceFee)||((this.serviceFee!= null)&&this.serviceFee.equals(rhs.serviceFee)))&&((this.configs == rhs.configs)||((this.configs!= null)&&this.configs.equals(rhs.configs))))&&((this.costFee == rhs.costFee)||((this.costFee!= null)&&this.costFee.equals(rhs.costFee))))&&((this.compMode == rhs.compMode)||((this.compMode!= null)&&this.compMode.equals(rhs.compMode))))&&((this.sumFeeTypeDetailConfigs == rhs.sumFeeTypeDetailConfigs)||((this.sumFeeTypeDetailConfigs!= null)&&this.sumFeeTypeDetailConfigs.equals(rhs.sumFeeTypeDetailConfigs))))&&((this.oneDeptAddCostFee == rhs.oneDeptAddCostFee)||((this.oneDeptAddCostFee!= null)&&this.oneDeptAddCostFee.equals(rhs.oneDeptAddCostFee))))&&((this.routeLine == rhs.routeLine)||((this.routeLine!= null)&&this.routeLine.equals(rhs.routeLine))))&&((this.otherFee == rhs.otherFee)||((this.otherFee!= null)&&this.otherFee.equals(rhs.otherFee))))&&((this.incomeFee == rhs.incomeFee)||((this.incomeFee!= null)&&this.incomeFee.equals(rhs.incomeFee))))&&((this.transferCostFee == rhs.transferCostFee)||((this.transferCostFee!= null)&&this.transferCostFee.equals(rhs.transferCostFee))))&&((this.payFee == rhs.payFee)||((this.payFee!= null)&&this.payFee.equals(rhs.payFee))))&&((this.srcDeptPayFeeAmt == rhs.srcDeptPayFeeAmt)||((this.srcDeptPayFeeAmt!= null)&&this.srcDeptPayFeeAmt.equals(rhs.srcDeptPayFeeAmt))))&&((this.settleMode == rhs.settleMode)||((this.settleMode!= null)&&this.settleMode.equals(rhs.settleMode))))&&((this.srcDeptPayFeeDetailConfigs == rhs.srcDeptPayFeeDetailConfigs)||((this.srcDeptPayFeeDetailConfigs!= null)&&this.srcDeptPayFeeDetailConfigs.equals(rhs.srcDeptPayFeeDetailConfigs))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
