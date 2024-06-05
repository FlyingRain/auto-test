
package com.flyingrain.autotest.service.model.yimi;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class YimiPriceQueryRequest {

    private String compCode;
    private Integer businessModel;
    private Integer bizType;
    private String sourceZoneCode;
    private String destZoneCode;
    private Integer serviceType;
    private Double chargeableWeight;
    private String routeCode;
    private String productType;
    private String consignCode;
    private String consignorTime;
    private Integer quantity;
    private String toCompCode;
    private List<Object> serviceFeeList = new ArrayList<Object>();
    private String volume;
    private Integer dataSourceType;
    private String testTime;
    private String consigneeAddressCode;
    private Object dispatchSmallAreaCode;
    private Integer bizSource;
    private String contractAreaCode;
    private Integer paymentType;
    private String totalFreight;
    private String freshFlag;
    private Long nextTime;
    private Double transferWeight;
    private String senderTownsCode;
    private String districtTownsCode;
    private String fusionMode;
    private String custCode;
    @JSONField(serialize = false)
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public String getCompCode() {
        return compCode;
    }

    public void setCompCode(String compCode) {
        this.compCode = compCode;
    }

    public Integer getBusinessModel() {
        return businessModel;
    }

    public void setBusinessModel(Integer businessModel) {
        this.businessModel = businessModel;
    }

    public Integer getBizType() {
        return bizType;
    }

    public void setBizType(Integer bizType) {
        this.bizType = bizType;
    }

    public String getSourceZoneCode() {
        return sourceZoneCode;
    }

    public void setSourceZoneCode(String sourceZoneCode) {
        this.sourceZoneCode = sourceZoneCode;
    }

    public String getDestZoneCode() {
        return destZoneCode;
    }

    public void setDestZoneCode(String destZoneCode) {
        this.destZoneCode = destZoneCode;
    }

    public Integer getServiceType() {
        return serviceType;
    }

    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }

    public Double getChargeableWeight() {
        return chargeableWeight;
    }

    public void setChargeableWeight(Double chargeableWeight) {
        this.chargeableWeight = chargeableWeight;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getConsignCode() {
        return consignCode;
    }

    public void setConsignCode(String consignCode) {
        this.consignCode = consignCode;
    }

    public String getConsignorTime() {
        return consignorTime;
    }

    public void setConsignorTime(String consignorTime) {
        this.consignorTime = consignorTime;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getToCompCode() {
        return toCompCode;
    }

    public void setToCompCode(String toCompCode) {
        this.toCompCode = toCompCode;
    }

    public List<Object> getServiceFeeList() {
        return serviceFeeList;
    }

    public void setServiceFeeList(List<Object> serviceFeeList) {
        this.serviceFeeList = serviceFeeList;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public Integer getDataSourceType() {
        return dataSourceType;
    }

    public void setDataSourceType(Integer dataSourceType) {
        this.dataSourceType = dataSourceType;
    }

    public String getTestTime() {
        return testTime;
    }

    public void setTestTime(String testTime) {
        this.testTime = testTime;
    }

    public String getConsigneeAddressCode() {
        return consigneeAddressCode;
    }

    public void setConsigneeAddressCode(String consigneeAddressCode) {
        this.consigneeAddressCode = consigneeAddressCode;
    }

    public Object getDispatchSmallAreaCode() {
        return dispatchSmallAreaCode;
    }

    public void setDispatchSmallAreaCode(Object dispatchSmallAreaCode) {
        this.dispatchSmallAreaCode = dispatchSmallAreaCode;
    }

    public Integer getBizSource() {
        return bizSource;
    }

    public void setBizSource(Integer bizSource) {
        this.bizSource = bizSource;
    }

    public String getContractAreaCode() {
        return contractAreaCode;
    }

    public void setContractAreaCode(String contractAreaCode) {
        this.contractAreaCode = contractAreaCode;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public String getTotalFreight() {
        return totalFreight;
    }

    public void setTotalFreight(String totalFreight) {
        this.totalFreight = totalFreight;
    }

    public String getFreshFlag() {
        return freshFlag;
    }

    public void setFreshFlag(String freshFlag) {
        this.freshFlag = freshFlag;
    }

    public Long getNextTime() {
        return nextTime;
    }

    public void setNextTime(Long nextTime) {
        this.nextTime = nextTime;
    }

    public Double getTransferWeight() {
        return transferWeight;
    }

    public void setTransferWeight(Double transferWeight) {
        this.transferWeight = transferWeight;
    }

    public String getSenderTownsCode() {
        return senderTownsCode;
    }

    public void setSenderTownsCode(String senderTownsCode) {
        this.senderTownsCode = senderTownsCode;
    }

    public String getDistrictTownsCode() {
        return districtTownsCode;
    }

    public void setDistrictTownsCode(String districtTownsCode) {
        this.districtTownsCode = districtTownsCode;
    }

    public String getFusionMode() {
        return fusionMode;
    }

    public void setFusionMode(String fusionMode) {
        this.fusionMode = fusionMode;
    }

    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode;
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
        sb.append(YimiPriceQueryRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("compCode");
        sb.append('=');
        sb.append(((this.compCode == null)?"<null>":this.compCode));
        sb.append(',');
        sb.append("businessModel");
        sb.append('=');
        sb.append(((this.businessModel == null)?"<null>":this.businessModel));
        sb.append(',');
        sb.append("bizType");
        sb.append('=');
        sb.append(((this.bizType == null)?"<null>":this.bizType));
        sb.append(',');
        sb.append("sourceZoneCode");
        sb.append('=');
        sb.append(((this.sourceZoneCode == null)?"<null>":this.sourceZoneCode));
        sb.append(',');
        sb.append("destZoneCode");
        sb.append('=');
        sb.append(((this.destZoneCode == null)?"<null>":this.destZoneCode));
        sb.append(',');
        sb.append("serviceType");
        sb.append('=');
        sb.append(((this.serviceType == null)?"<null>":this.serviceType));
        sb.append(',');
        sb.append("chargeableWeight");
        sb.append('=');
        sb.append(((this.chargeableWeight == null)?"<null>":this.chargeableWeight));
        sb.append(',');
        sb.append("routeCode");
        sb.append('=');
        sb.append(((this.routeCode == null)?"<null>":this.routeCode));
        sb.append(',');
        sb.append("productType");
        sb.append('=');
        sb.append(((this.productType == null)?"<null>":this.productType));
        sb.append(',');
        sb.append("consignCode");
        sb.append('=');
        sb.append(((this.consignCode == null)?"<null>":this.consignCode));
        sb.append(',');
        sb.append("consignorTime");
        sb.append('=');
        sb.append(((this.consignorTime == null)?"<null>":this.consignorTime));
        sb.append(',');
        sb.append("quantity");
        sb.append('=');
        sb.append(((this.quantity == null)?"<null>":this.quantity));
        sb.append(',');
        sb.append("toCompCode");
        sb.append('=');
        sb.append(((this.toCompCode == null)?"<null>":this.toCompCode));
        sb.append(',');
        sb.append("serviceFeeList");
        sb.append('=');
        sb.append(((this.serviceFeeList == null)?"<null>":this.serviceFeeList));
        sb.append(',');
        sb.append("volume");
        sb.append('=');
        sb.append(((this.volume == null)?"<null>":this.volume));
        sb.append(',');
        sb.append("dataSourceType");
        sb.append('=');
        sb.append(((this.dataSourceType == null)?"<null>":this.dataSourceType));
        sb.append(',');
        sb.append("testTime");
        sb.append('=');
        sb.append(((this.testTime == null)?"<null>":this.testTime));
        sb.append(',');
        sb.append("consigneeAddressCode");
        sb.append('=');
        sb.append(((this.consigneeAddressCode == null)?"<null>":this.consigneeAddressCode));
        sb.append(',');
        sb.append("dispatchSmallAreaCode");
        sb.append('=');
        sb.append(((this.dispatchSmallAreaCode == null)?"<null>":this.dispatchSmallAreaCode));
        sb.append(',');
        sb.append("bizSource");
        sb.append('=');
        sb.append(((this.bizSource == null)?"<null>":this.bizSource));
        sb.append(',');
        sb.append("contractAreaCode");
        sb.append('=');
        sb.append(((this.contractAreaCode == null)?"<null>":this.contractAreaCode));
        sb.append(',');
        sb.append("paymentType");
        sb.append('=');
        sb.append(((this.paymentType == null)?"<null>":this.paymentType));
        sb.append(',');
        sb.append("totalFreight");
        sb.append('=');
        sb.append(((this.totalFreight == null)?"<null>":this.totalFreight));
        sb.append(',');
        sb.append("freshFlag");
        sb.append('=');
        sb.append(((this.freshFlag == null)?"<null>":this.freshFlag));
        sb.append(',');
        sb.append("nextTime");
        sb.append('=');
        sb.append(((this.nextTime == null)?"<null>":this.nextTime));
        sb.append(',');
        sb.append("transferWeight");
        sb.append('=');
        sb.append(((this.transferWeight == null)?"<null>":this.transferWeight));
        sb.append(',');
        sb.append("senderTownsCode");
        sb.append('=');
        sb.append(((this.senderTownsCode == null)?"<null>":this.senderTownsCode));
        sb.append(',');
        sb.append("districtTownsCode");
        sb.append('=');
        sb.append(((this.districtTownsCode == null)?"<null>":this.districtTownsCode));
        sb.append(',');
        sb.append("fusionMode");
        sb.append('=');
        sb.append(((this.fusionMode == null)?"<null>":this.fusionMode));
        sb.append(',');
        sb.append("custCode");
        sb.append('=');
        sb.append(((this.custCode == null)?"<null>":this.custCode));
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
        result = ((result* 31)+((this.serviceType == null)? 0 :this.serviceType.hashCode()));
        result = ((result* 31)+((this.transferWeight == null)? 0 :this.transferWeight.hashCode()));
        result = ((result* 31)+((this.bizType == null)? 0 :this.bizType.hashCode()));
        result = ((result* 31)+((this.totalFreight == null)? 0 :this.totalFreight.hashCode()));
        result = ((result* 31)+((this.nextTime == null)? 0 :this.nextTime.hashCode()));
        result = ((result* 31)+((this.businessModel == null)? 0 :this.businessModel.hashCode()));
        result = ((result* 31)+((this.serviceFeeList == null)? 0 :this.serviceFeeList.hashCode()));
        result = ((result* 31)+((this.consigneeAddressCode == null)? 0 :this.consigneeAddressCode.hashCode()));
        result = ((result* 31)+((this.freshFlag == null)? 0 :this.freshFlag.hashCode()));
        result = ((result* 31)+((this.senderTownsCode == null)? 0 :this.senderTownsCode.hashCode()));
        result = ((result* 31)+((this.paymentType == null)? 0 :this.paymentType.hashCode()));
        result = ((result* 31)+((this.chargeableWeight == null)? 0 :this.chargeableWeight.hashCode()));
        result = ((result* 31)+((this.testTime == null)? 0 :this.testTime.hashCode()));
        result = ((result* 31)+((this.productType == null)? 0 :this.productType.hashCode()));
        result = ((result* 31)+((this.routeCode == null)? 0 :this.routeCode.hashCode()));
        result = ((result* 31)+((this.quantity == null)? 0 :this.quantity.hashCode()));
        result = ((result* 31)+((this.consignorTime == null)? 0 :this.consignorTime.hashCode()));
        result = ((result* 31)+((this.contractAreaCode == null)? 0 :this.contractAreaCode.hashCode()));
        result = ((result* 31)+((this.dispatchSmallAreaCode == null)? 0 :this.dispatchSmallAreaCode.hashCode()));
        result = ((result* 31)+((this.custCode == null)? 0 :this.custCode.hashCode()));
        result = ((result* 31)+((this.compCode == null)? 0 :this.compCode.hashCode()));
        result = ((result* 31)+((this.volume == null)? 0 :this.volume.hashCode()));
        result = ((result* 31)+((this.districtTownsCode == null)? 0 :this.districtTownsCode.hashCode()));
        result = ((result* 31)+((this.bizSource == null)? 0 :this.bizSource.hashCode()));
        result = ((result* 31)+((this.sourceZoneCode == null)? 0 :this.sourceZoneCode.hashCode()));
        result = ((result* 31)+((this.toCompCode == null)? 0 :this.toCompCode.hashCode()));
        result = ((result* 31)+((this.destZoneCode == null)? 0 :this.destZoneCode.hashCode()));
        result = ((result* 31)+((this.consignCode == null)? 0 :this.consignCode.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.fusionMode == null)? 0 :this.fusionMode.hashCode()));
        result = ((result* 31)+((this.dataSourceType == null)? 0 :this.dataSourceType.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof YimiPriceQueryRequest) == false) {
            return false;
        }
        YimiPriceQueryRequest rhs = ((YimiPriceQueryRequest) other);
        return ((((((((((((((((((((((((((((((((this.serviceType == rhs.serviceType)||((this.serviceType!= null)&&this.serviceType.equals(rhs.serviceType)))&&((this.transferWeight == rhs.transferWeight)||((this.transferWeight!= null)&&this.transferWeight.equals(rhs.transferWeight))))&&((this.bizType == rhs.bizType)||((this.bizType!= null)&&this.bizType.equals(rhs.bizType))))&&((this.totalFreight == rhs.totalFreight)||((this.totalFreight!= null)&&this.totalFreight.equals(rhs.totalFreight))))&&((this.nextTime == rhs.nextTime)||((this.nextTime!= null)&&this.nextTime.equals(rhs.nextTime))))&&((this.businessModel == rhs.businessModel)||((this.businessModel!= null)&&this.businessModel.equals(rhs.businessModel))))&&((this.serviceFeeList == rhs.serviceFeeList)||((this.serviceFeeList!= null)&&this.serviceFeeList.equals(rhs.serviceFeeList))))&&((this.consigneeAddressCode == rhs.consigneeAddressCode)||((this.consigneeAddressCode!= null)&&this.consigneeAddressCode.equals(rhs.consigneeAddressCode))))&&((this.freshFlag == rhs.freshFlag)||((this.freshFlag!= null)&&this.freshFlag.equals(rhs.freshFlag))))&&((this.senderTownsCode == rhs.senderTownsCode)||((this.senderTownsCode!= null)&&this.senderTownsCode.equals(rhs.senderTownsCode))))&&((this.paymentType == rhs.paymentType)||((this.paymentType!= null)&&this.paymentType.equals(rhs.paymentType))))&&((this.chargeableWeight == rhs.chargeableWeight)||((this.chargeableWeight!= null)&&this.chargeableWeight.equals(rhs.chargeableWeight))))&&((this.testTime == rhs.testTime)||((this.testTime!= null)&&this.testTime.equals(rhs.testTime))))&&((this.productType == rhs.productType)||((this.productType!= null)&&this.productType.equals(rhs.productType))))&&((this.routeCode == rhs.routeCode)||((this.routeCode!= null)&&this.routeCode.equals(rhs.routeCode))))&&((this.quantity == rhs.quantity)||((this.quantity!= null)&&this.quantity.equals(rhs.quantity))))&&((this.consignorTime == rhs.consignorTime)||((this.consignorTime!= null)&&this.consignorTime.equals(rhs.consignorTime))))&&((this.contractAreaCode == rhs.contractAreaCode)||((this.contractAreaCode!= null)&&this.contractAreaCode.equals(rhs.contractAreaCode))))&&((this.dispatchSmallAreaCode == rhs.dispatchSmallAreaCode)||((this.dispatchSmallAreaCode!= null)&&this.dispatchSmallAreaCode.equals(rhs.dispatchSmallAreaCode))))&&((this.custCode == rhs.custCode)||((this.custCode!= null)&&this.custCode.equals(rhs.custCode))))&&((this.compCode == rhs.compCode)||((this.compCode!= null)&&this.compCode.equals(rhs.compCode))))&&((this.volume == rhs.volume)||((this.volume!= null)&&this.volume.equals(rhs.volume))))&&((this.districtTownsCode == rhs.districtTownsCode)||((this.districtTownsCode!= null)&&this.districtTownsCode.equals(rhs.districtTownsCode))))&&((this.bizSource == rhs.bizSource)||((this.bizSource!= null)&&this.bizSource.equals(rhs.bizSource))))&&((this.sourceZoneCode == rhs.sourceZoneCode)||((this.sourceZoneCode!= null)&&this.sourceZoneCode.equals(rhs.sourceZoneCode))))&&((this.toCompCode == rhs.toCompCode)||((this.toCompCode!= null)&&this.toCompCode.equals(rhs.toCompCode))))&&((this.destZoneCode == rhs.destZoneCode)||((this.destZoneCode!= null)&&this.destZoneCode.equals(rhs.destZoneCode))))&&((this.consignCode == rhs.consignCode)||((this.consignCode!= null)&&this.consignCode.equals(rhs.consignCode))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.fusionMode == rhs.fusionMode)||((this.fusionMode!= null)&&this.fusionMode.equals(rhs.fusionMode))))&&((this.dataSourceType == rhs.dataSourceType)||((this.dataSourceType!= null)&&this.dataSourceType.equals(rhs.dataSourceType))));
    }

}
