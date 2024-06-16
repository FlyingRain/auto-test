
package com.flyingrain.autotest.service.model.anneng;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class AnnengPrice {

    @JSONField(name = "DISPATCH_SITE_ID")
    private Integer dispatchSiteId;
    @JSONField(name = "SEND_SITE_ID")

    private Integer sendSiteId;
    @JSONField(name = "CUSTOMER_ID")

    private Integer customerId;
    @JSONField(name = "PICK_GOODS_MODE_ID")
    private Integer pickGoodsModeId;
    @JSONField(name = "PRODUCT_TYPE")
    private Integer productType;
    @JSONField(name = "GOODS_CATEGORY")
    private Integer goodsCategory;
    @JSONField(name = "PIECE")
    private Integer piece;
    @JSONField(name = "VOL")
    private Double vol;
    @JSONField(name = "CALC_WEIGHT")
    private Double calcWeight;
    @JSONField(name = "WEIGHT")
    private Double weight;
    @JSONField(name = "SERVICEID")
    private Integer serviceid;
    @JSONField(name = "JZPICKGOODSMODE")
    private Integer jzpickgoodsmode;
    @JSONField(name = "INSTALLCHARGE")
    private Integer installcharge;
    @JSONField(name = "EWB_TYPE")
    private Integer ewbType;
    @JSONField(name = "JZSERVICETYPE")
    private Integer jzservicetype;
    @JSONField(name = "COD_CHARGE")
    private Double codCharge;
    @JSONField(name = "INSURED_AMOUNT")
    private Double insuredAmount;
    @JSONField(name = "FREIGHT_CHARGE")
    private Double freightCharge;
    @JSONField(name = "PAY_MODE_ID")
    private Integer payModeId;
    @JSONField(name = "TOTAL_AMOUNT")
    private Double totalAmount;
    @JSONField(name = "MAX_EDGE_LENGTH")
    private Double maxEdgeLength;
    @JSONField(name = "GOODS_WIDE")
    private Double goodsWide;
    @JSONField(name = "SINGLE_WEIGHT")
    private Double singleWeight;
    @JSONField(name = "IS_FOLD")
    private Integer isFold;
    @JSONField(name = "STAIRS_TYPE_ID")
    private Integer stairsTypeId;
    @JSONField(name = "CARGO_TYPE_ID")
    private Integer cargoTypeId;
    @JSONField(name = "SPECIAL_PIECE")
    private Integer specialPiece;
    @JSONField(name = "RETURN_AMOUNT_TIME")
    private String returnAmountTime;
    @JSONField(name = "VOL_WEIGHT")
    private Double volWeight;
    @JSONField(name = "EWB_NO")
    private String ewbNo;
    @JSONField(name = "ALL_AMOUNT")
    private Double allAmount;
    @JSONField(name = "FEE_1_DISCOUNT_FLAG")
    private Integer fee1DiscountFlag;
    @JSONField(name = "FEE_SITE_1_2_DISCOUNT_FLAG")
    private Integer feeSite12DiscountFlag;
    @JSONField(name = "DECENTRALIZATION_POLICY")
    private Integer decentralizationPolicy;
    @JSONField(name = "COUNT_MODE")
    private Integer countMode;
    @JSONField(name = "TRANS_CALC_WEIGHT")
    private Double transCalcWeight;
    @JSONField(name = "GOODS_PROPERTY")
    private Integer goodsProperty;
    @JSONField(name = "IS_HIGH_PRICE")
    private Integer isHighPrice;
    @JSONField(name = "IS_NO_PRESS")
    private Integer isNoPress;
    @JSONField(name = "IS_DIRECT_CAR")
    private Integer isDirectCar;
    @JSONField(name = "TOWN_NAME")
    private String townName;
    @JSONField(name = "REWB_TYPE")
    private Object rewbType;
    @JSONField(name = "REWB_NO")
    private Object rewbNo;
    @JSONField(name = "OUT_CAT_TYPE")
    private Integer outCatType;
    @JSONField(name = "DELIVER_CENTER_CODE")
    private String deliverCenterCode;
    @JSONField(name = "DELIVER_CENTER_ID")
    private Integer deliverCenterId;
    @JSONField(name = "KILO_METRES")
    private Object kiloMetres;
    @JSONField(name = "DIS_CHARGE_CARGO")
    private Object disChargeCargo;
    @JSONField(name = "IS_PUT_STATION")
    private Integer isPutStation;
    @JSONField(name = "DISPATCH_IN_RANGE")
    private Integer dispatchInRange;
    @JSONField(name = "SELF_PICK")
    private Object selfPick;
    @JSONField(name = "SPECIAL_AREA_ID")
    private Object specialAreaId;
    @JSONField(name = "GOODS_NAME")
    private String goodsName;
    @JSONField(serialize = false)
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Integer getDispatchSiteId() {
        return dispatchSiteId;
    }

    public void setDispatchSiteId(Integer dispatchSiteId) {
        this.dispatchSiteId = dispatchSiteId;
    }

    public Integer getSendSiteId() {
        return sendSiteId;
    }

    public void setSendSiteId(Integer sendSiteId) {
        this.sendSiteId = sendSiteId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getPickGoodsModeId() {
        return pickGoodsModeId;
    }

    public void setPickGoodsModeId(Integer pickGoodsModeId) {
        this.pickGoodsModeId = pickGoodsModeId;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Integer getGoodsCategory() {
        return goodsCategory;
    }

    public void setGoodsCategory(Integer goodsCategory) {
        this.goodsCategory = goodsCategory;
    }

    public Integer getPiece() {
        return piece;
    }

    public void setPiece(Integer piece) {
        this.piece = piece;
    }

    public Double getVol() {
        return vol;
    }

    public void setVol(Double vol) {
        this.vol = vol;
    }

    public Double getCalcWeight() {
        return calcWeight;
    }

    public void setCalcWeight(Double calcWeight) {
        this.calcWeight = calcWeight;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getServiceid() {
        return serviceid;
    }

    public void setServiceid(Integer serviceid) {
        this.serviceid = serviceid;
    }

    public Integer getJzpickgoodsmode() {
        return jzpickgoodsmode;
    }

    public void setJzpickgoodsmode(Integer jzpickgoodsmode) {
        this.jzpickgoodsmode = jzpickgoodsmode;
    }

    public Integer getInstallcharge() {
        return installcharge;
    }

    public void setInstallcharge(Integer installcharge) {
        this.installcharge = installcharge;
    }

    public Integer getEwbType() {
        return ewbType;
    }

    public void setEwbType(Integer ewbType) {
        this.ewbType = ewbType;
    }

    public Integer getJzservicetype() {
        return jzservicetype;
    }

    public void setJzservicetype(Integer jzservicetype) {
        this.jzservicetype = jzservicetype;
    }

    public Double getCodCharge() {
        return codCharge;
    }

    public void setCodCharge(Double codCharge) {
        this.codCharge = codCharge;
    }

    public Double getInsuredAmount() {
        return insuredAmount;
    }

    public void setInsuredAmount(Double insuredAmount) {
        this.insuredAmount = insuredAmount;
    }

    public Double getFreightCharge() {
        return freightCharge;
    }

    public void setFreightCharge(Double freightCharge) {
        this.freightCharge = freightCharge;
    }

    public Integer getPayModeId() {
        return payModeId;
    }

    public void setPayModeId(Integer payModeId) {
        this.payModeId = payModeId;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getMaxEdgeLength() {
        return maxEdgeLength;
    }

    public void setMaxEdgeLength(Double maxEdgeLength) {
        this.maxEdgeLength = maxEdgeLength;
    }

    public Double getGoodsWide() {
        return goodsWide;
    }

    public void setGoodsWide(Double goodsWide) {
        this.goodsWide = goodsWide;
    }

    public Double getSingleWeight() {
        return singleWeight;
    }

    public void setSingleWeight(Double singleWeight) {
        this.singleWeight = singleWeight;
    }

    public Integer getIsFold() {
        return isFold;
    }

    public void setIsFold(Integer isFold) {
        this.isFold = isFold;
    }

    public Integer getStairsTypeId() {
        return stairsTypeId;
    }

    public void setStairsTypeId(Integer stairsTypeId) {
        this.stairsTypeId = stairsTypeId;
    }

    public Integer getCargoTypeId() {
        return cargoTypeId;
    }

    public void setCargoTypeId(Integer cargoTypeId) {
        this.cargoTypeId = cargoTypeId;
    }

    public Integer getSpecialPiece() {
        return specialPiece;
    }

    public void setSpecialPiece(Integer specialPiece) {
        this.specialPiece = specialPiece;
    }

    public String getReturnAmountTime() {
        return returnAmountTime;
    }

    public void setReturnAmountTime(String returnAmountTime) {
        this.returnAmountTime = returnAmountTime;
    }

    public Double getVolWeight() {
        return volWeight;
    }

    public void setVolWeight(Double volWeight) {
        this.volWeight = volWeight;
    }

    public String getEwbNo() {
        return ewbNo;
    }

    public void setEwbNo(String ewbNo) {
        this.ewbNo = ewbNo;
    }

    public Double getAllAmount() {
        return allAmount;
    }

    public void setAllAmount(Double allAmount) {
        this.allAmount = allAmount;
    }

    public Integer getFee1DiscountFlag() {
        return fee1DiscountFlag;
    }

    public void setFee1DiscountFlag(Integer fee1DiscountFlag) {
        this.fee1DiscountFlag = fee1DiscountFlag;
    }

    public Integer getFeeSite12DiscountFlag() {
        return feeSite12DiscountFlag;
    }

    public void setFeeSite12DiscountFlag(Integer feeSite12DiscountFlag) {
        this.feeSite12DiscountFlag = feeSite12DiscountFlag;
    }

    public Integer getDecentralizationPolicy() {
        return decentralizationPolicy;
    }

    public void setDecentralizationPolicy(Integer decentralizationPolicy) {
        this.decentralizationPolicy = decentralizationPolicy;
    }

    public Integer getCountMode() {
        return countMode;
    }

    public void setCountMode(Integer countMode) {
        this.countMode = countMode;
    }

    public Double getTransCalcWeight() {
        return transCalcWeight;
    }

    public void setTransCalcWeight(Double transCalcWeight) {
        this.transCalcWeight = transCalcWeight;
    }

    public Integer getGoodsProperty() {
        return goodsProperty;
    }

    public void setGoodsProperty(Integer goodsProperty) {
        this.goodsProperty = goodsProperty;
    }

    public Integer getIsHighPrice() {
        return isHighPrice;
    }

    public void setIsHighPrice(Integer isHighPrice) {
        this.isHighPrice = isHighPrice;
    }

    public Integer getIsNoPress() {
        return isNoPress;
    }

    public void setIsNoPress(Integer isNoPress) {
        this.isNoPress = isNoPress;
    }

    public Integer getIsDirectCar() {
        return isDirectCar;
    }

    public void setIsDirectCar(Integer isDirectCar) {
        this.isDirectCar = isDirectCar;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public Object getRewbType() {
        return rewbType;
    }

    public void setRewbType(Object rewbType) {
        this.rewbType = rewbType;
    }

    public Object getRewbNo() {
        return rewbNo;
    }

    public void setRewbNo(Object rewbNo) {
        this.rewbNo = rewbNo;
    }

    public Integer getOutCatType() {
        return outCatType;
    }

    public void setOutCatType(Integer outCatType) {
        this.outCatType = outCatType;
    }

    public String getDeliverCenterCode() {
        return deliverCenterCode;
    }

    public void setDeliverCenterCode(String deliverCenterCode) {
        this.deliverCenterCode = deliverCenterCode;
    }

    public Integer getDeliverCenterId() {
        return deliverCenterId;
    }

    public void setDeliverCenterId(Integer deliverCenterId) {
        this.deliverCenterId = deliverCenterId;
    }

    public Object getKiloMetres() {
        return kiloMetres;
    }

    public void setKiloMetres(Object kiloMetres) {
        this.kiloMetres = kiloMetres;
    }

    public Object getDisChargeCargo() {
        return disChargeCargo;
    }

    public void setDisChargeCargo(Object disChargeCargo) {
        this.disChargeCargo = disChargeCargo;
    }

    public Integer getIsPutStation() {
        return isPutStation;
    }

    public void setIsPutStation(Integer isPutStation) {
        this.isPutStation = isPutStation;
    }

    public Integer getDispatchInRange() {
        return dispatchInRange;
    }

    public void setDispatchInRange(Integer dispatchInRange) {
        this.dispatchInRange = dispatchInRange;
    }

    public Object getSelfPick() {
        return selfPick;
    }

    public void setSelfPick(Object selfPick) {
        this.selfPick = selfPick;
    }

    public Object getSpecialAreaId() {
        return specialAreaId;
    }

    public void setSpecialAreaId(Object specialAreaId) {
        this.specialAreaId = specialAreaId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
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
        sb.append(AnnengPrice.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("dispatchSiteId");
        sb.append('=');
        sb.append(((this.dispatchSiteId == null)?"<null>":this.dispatchSiteId));
        sb.append(',');
        sb.append("sendSiteId");
        sb.append('=');
        sb.append(((this.sendSiteId == null)?"<null>":this.sendSiteId));
        sb.append(',');
        sb.append("customerId");
        sb.append('=');
        sb.append(((this.customerId == null)?"<null>":this.customerId));
        sb.append(',');
        sb.append("pickGoodsModeId");
        sb.append('=');
        sb.append(((this.pickGoodsModeId == null)?"<null>":this.pickGoodsModeId));
        sb.append(',');
        sb.append("productType");
        sb.append('=');
        sb.append(((this.productType == null)?"<null>":this.productType));
        sb.append(',');
        sb.append("goodsCategory");
        sb.append('=');
        sb.append(((this.goodsCategory == null)?"<null>":this.goodsCategory));
        sb.append(',');
        sb.append("piece");
        sb.append('=');
        sb.append(((this.piece == null)?"<null>":this.piece));
        sb.append(',');
        sb.append("vol");
        sb.append('=');
        sb.append(((this.vol == null)?"<null>":this.vol));
        sb.append(',');
        sb.append("calcWeight");
        sb.append('=');
        sb.append(((this.calcWeight == null)?"<null>":this.calcWeight));
        sb.append(',');
        sb.append("weight");
        sb.append('=');
        sb.append(((this.weight == null)?"<null>":this.weight));
        sb.append(',');
        sb.append("serviceid");
        sb.append('=');
        sb.append(((this.serviceid == null)?"<null>":this.serviceid));
        sb.append(',');
        sb.append("jzpickgoodsmode");
        sb.append('=');
        sb.append(((this.jzpickgoodsmode == null)?"<null>":this.jzpickgoodsmode));
        sb.append(',');
        sb.append("installcharge");
        sb.append('=');
        sb.append(((this.installcharge == null)?"<null>":this.installcharge));
        sb.append(',');
        sb.append("ewbType");
        sb.append('=');
        sb.append(((this.ewbType == null)?"<null>":this.ewbType));
        sb.append(',');
        sb.append("jzservicetype");
        sb.append('=');
        sb.append(((this.jzservicetype == null)?"<null>":this.jzservicetype));
        sb.append(',');
        sb.append("codCharge");
        sb.append('=');
        sb.append(((this.codCharge == null)?"<null>":this.codCharge));
        sb.append(',');
        sb.append("insuredAmount");
        sb.append('=');
        sb.append(((this.insuredAmount == null)?"<null>":this.insuredAmount));
        sb.append(',');
        sb.append("freightCharge");
        sb.append('=');
        sb.append(((this.freightCharge == null)?"<null>":this.freightCharge));
        sb.append(',');
        sb.append("payModeId");
        sb.append('=');
        sb.append(((this.payModeId == null)?"<null>":this.payModeId));
        sb.append(',');
        sb.append("totalAmount");
        sb.append('=');
        sb.append(((this.totalAmount == null)?"<null>":this.totalAmount));
        sb.append(',');
        sb.append("maxEdgeLength");
        sb.append('=');
        sb.append(((this.maxEdgeLength == null)?"<null>":this.maxEdgeLength));
        sb.append(',');
        sb.append("goodsWide");
        sb.append('=');
        sb.append(((this.goodsWide == null)?"<null>":this.goodsWide));
        sb.append(',');
        sb.append("singleWeight");
        sb.append('=');
        sb.append(((this.singleWeight == null)?"<null>":this.singleWeight));
        sb.append(',');
        sb.append("isFold");
        sb.append('=');
        sb.append(((this.isFold == null)?"<null>":this.isFold));
        sb.append(',');
        sb.append("stairsTypeId");
        sb.append('=');
        sb.append(((this.stairsTypeId == null)?"<null>":this.stairsTypeId));
        sb.append(',');
        sb.append("cargoTypeId");
        sb.append('=');
        sb.append(((this.cargoTypeId == null)?"<null>":this.cargoTypeId));
        sb.append(',');
        sb.append("specialPiece");
        sb.append('=');
        sb.append(((this.specialPiece == null)?"<null>":this.specialPiece));
        sb.append(',');
        sb.append("returnAmountTime");
        sb.append('=');
        sb.append(((this.returnAmountTime == null)?"<null>":this.returnAmountTime));
        sb.append(',');
        sb.append("volWeight");
        sb.append('=');
        sb.append(((this.volWeight == null)?"<null>":this.volWeight));
        sb.append(',');
        sb.append("ewbNo");
        sb.append('=');
        sb.append(((this.ewbNo == null)?"<null>":this.ewbNo));
        sb.append(',');
        sb.append("allAmount");
        sb.append('=');
        sb.append(((this.allAmount == null)?"<null>":this.allAmount));
        sb.append(',');
        sb.append("fee1DiscountFlag");
        sb.append('=');
        sb.append(((this.fee1DiscountFlag == null)?"<null>":this.fee1DiscountFlag));
        sb.append(',');
        sb.append("feeSite12DiscountFlag");
        sb.append('=');
        sb.append(((this.feeSite12DiscountFlag == null)?"<null>":this.feeSite12DiscountFlag));
        sb.append(',');
        sb.append("decentralizationPolicy");
        sb.append('=');
        sb.append(((this.decentralizationPolicy == null)?"<null>":this.decentralizationPolicy));
        sb.append(',');
        sb.append("countMode");
        sb.append('=');
        sb.append(((this.countMode == null)?"<null>":this.countMode));
        sb.append(',');
        sb.append("transCalcWeight");
        sb.append('=');
        sb.append(((this.transCalcWeight == null)?"<null>":this.transCalcWeight));
        sb.append(',');
        sb.append("goodsProperty");
        sb.append('=');
        sb.append(((this.goodsProperty == null)?"<null>":this.goodsProperty));
        sb.append(',');
        sb.append("isHighPrice");
        sb.append('=');
        sb.append(((this.isHighPrice == null)?"<null>":this.isHighPrice));
        sb.append(',');
        sb.append("isNoPress");
        sb.append('=');
        sb.append(((this.isNoPress == null)?"<null>":this.isNoPress));
        sb.append(',');
        sb.append("isDirectCar");
        sb.append('=');
        sb.append(((this.isDirectCar == null)?"<null>":this.isDirectCar));
        sb.append(',');
        sb.append("townName");
        sb.append('=');
        sb.append(((this.townName == null)?"<null>":this.townName));
        sb.append(',');
        sb.append("rewbType");
        sb.append('=');
        sb.append(((this.rewbType == null)?"<null>":this.rewbType));
        sb.append(',');
        sb.append("rewbNo");
        sb.append('=');
        sb.append(((this.rewbNo == null)?"<null>":this.rewbNo));
        sb.append(',');
        sb.append("outCatType");
        sb.append('=');
        sb.append(((this.outCatType == null)?"<null>":this.outCatType));
        sb.append(',');
        sb.append("deliverCenterCode");
        sb.append('=');
        sb.append(((this.deliverCenterCode == null)?"<null>":this.deliverCenterCode));
        sb.append(',');
        sb.append("deliverCenterId");
        sb.append('=');
        sb.append(((this.deliverCenterId == null)?"<null>":this.deliverCenterId));
        sb.append(',');
        sb.append("kiloMetres");
        sb.append('=');
        sb.append(((this.kiloMetres == null)?"<null>":this.kiloMetres));
        sb.append(',');
        sb.append("disChargeCargo");
        sb.append('=');
        sb.append(((this.disChargeCargo == null)?"<null>":this.disChargeCargo));
        sb.append(',');
        sb.append("isPutStation");
        sb.append('=');
        sb.append(((this.isPutStation == null)?"<null>":this.isPutStation));
        sb.append(',');
        sb.append("dispatchInRange");
        sb.append('=');
        sb.append(((this.dispatchInRange == null)?"<null>":this.dispatchInRange));
        sb.append(',');
        sb.append("selfPick");
        sb.append('=');
        sb.append(((this.selfPick == null)?"<null>":this.selfPick));
        sb.append(',');
        sb.append("specialAreaId");
        sb.append('=');
        sb.append(((this.specialAreaId == null)?"<null>":this.specialAreaId));
        sb.append(',');
        sb.append("goodsName");
        sb.append('=');
        sb.append(((this.goodsName == null)?"<null>":this.goodsName));
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
        result = ((result* 31)+((this.selfPick == null)? 0 :this.selfPick.hashCode()));
        result = ((result* 31)+((this.codCharge == null)? 0 :this.codCharge.hashCode()));
        result = ((result* 31)+((this.feeSite12DiscountFlag == null)? 0 :this.feeSite12DiscountFlag.hashCode()));
        result = ((result* 31)+((this.cargoTypeId == null)? 0 :this.cargoTypeId.hashCode()));
        result = ((result* 31)+((this.dispatchInRange == null)? 0 :this.dispatchInRange.hashCode()));
        result = ((result* 31)+((this.disChargeCargo == null)? 0 :this.disChargeCargo.hashCode()));
        result = ((result* 31)+((this.dispatchSiteId == null)? 0 :this.dispatchSiteId.hashCode()));
        result = ((result* 31)+((this.fee1DiscountFlag == null)? 0 :this.fee1DiscountFlag.hashCode()));
        result = ((result* 31)+((this.ewbNo == null)? 0 :this.ewbNo.hashCode()));
        result = ((result* 31)+((this.jzservicetype == null)? 0 :this.jzservicetype.hashCode()));
        result = ((result* 31)+((this.decentralizationPolicy == null)? 0 :this.decentralizationPolicy.hashCode()));
        result = ((result* 31)+((this.isNoPress == null)? 0 :this.isNoPress.hashCode()));
        result = ((result* 31)+((this.goodsName == null)? 0 :this.goodsName.hashCode()));
        result = ((result* 31)+((this.isHighPrice == null)? 0 :this.isHighPrice.hashCode()));
        result = ((result* 31)+((this.rewbType == null)? 0 :this.rewbType.hashCode()));
        result = ((result* 31)+((this.jzpickgoodsmode == null)? 0 :this.jzpickgoodsmode.hashCode()));
        result = ((result* 31)+((this.payModeId == null)? 0 :this.payModeId.hashCode()));
        result = ((result* 31)+((this.townName == null)? 0 :this.townName.hashCode()));
        result = ((result* 31)+((this.sendSiteId == null)? 0 :this.sendSiteId.hashCode()));
        result = ((result* 31)+((this.deliverCenterCode == null)? 0 :this.deliverCenterCode.hashCode()));
        result = ((result* 31)+((this.weight == null)? 0 :this.weight.hashCode()));
        result = ((result* 31)+((this.volWeight == null)? 0 :this.volWeight.hashCode()));
        result = ((result* 31)+((this.totalAmount == null)? 0 :this.totalAmount.hashCode()));
        result = ((result* 31)+((this.maxEdgeLength == null)? 0 :this.maxEdgeLength.hashCode()));
        result = ((result* 31)+((this.piece == null)? 0 :this.piece.hashCode()));
        result = ((result* 31)+((this.goodsProperty == null)? 0 :this.goodsProperty.hashCode()));
        result = ((result* 31)+((this.ewbType == null)? 0 :this.ewbType.hashCode()));
        result = ((result* 31)+((this.specialAreaId == null)? 0 :this.specialAreaId.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.returnAmountTime == null)? 0 :this.returnAmountTime.hashCode()));
        result = ((result* 31)+((this.transCalcWeight == null)? 0 :this.transCalcWeight.hashCode()));
        result = ((result* 31)+((this.calcWeight == null)? 0 :this.calcWeight.hashCode()));
        result = ((result* 31)+((this.kiloMetres == null)? 0 :this.kiloMetres.hashCode()));
        result = ((result* 31)+((this.goodsCategory == null)? 0 :this.goodsCategory.hashCode()));
        result = ((result* 31)+((this.rewbNo == null)? 0 :this.rewbNo.hashCode()));
        result = ((result* 31)+((this.vol == null)? 0 :this.vol.hashCode()));
        result = ((result* 31)+((this.pickGoodsModeId == null)? 0 :this.pickGoodsModeId.hashCode()));
        result = ((result* 31)+((this.deliverCenterId == null)? 0 :this.deliverCenterId.hashCode()));
        result = ((result* 31)+((this.customerId == null)? 0 :this.customerId.hashCode()));
        result = ((result* 31)+((this.insuredAmount == null)? 0 :this.insuredAmount.hashCode()));
        result = ((result* 31)+((this.singleWeight == null)? 0 :this.singleWeight.hashCode()));
        result = ((result* 31)+((this.countMode == null)? 0 :this.countMode.hashCode()));
        result = ((result* 31)+((this.productType == null)? 0 :this.productType.hashCode()));
        result = ((result* 31)+((this.stairsTypeId == null)? 0 :this.stairsTypeId.hashCode()));
        result = ((result* 31)+((this.goodsWide == null)? 0 :this.goodsWide.hashCode()));
        result = ((result* 31)+((this.isFold == null)? 0 :this.isFold.hashCode()));
        result = ((result* 31)+((this.freightCharge == null)? 0 :this.freightCharge.hashCode()));
        result = ((result* 31)+((this.isPutStation == null)? 0 :this.isPutStation.hashCode()));
        result = ((result* 31)+((this.specialPiece == null)? 0 :this.specialPiece.hashCode()));
        result = ((result* 31)+((this.installcharge == null)? 0 :this.installcharge.hashCode()));
        result = ((result* 31)+((this.allAmount == null)? 0 :this.allAmount.hashCode()));
        result = ((result* 31)+((this.outCatType == null)? 0 :this.outCatType.hashCode()));
        result = ((result* 31)+((this.serviceid == null)? 0 :this.serviceid.hashCode()));
        result = ((result* 31)+((this.isDirectCar == null)? 0 :this.isDirectCar.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AnnengPrice) == false) {
            return false;
        }
        AnnengPrice rhs = ((AnnengPrice) other);
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((this.selfPick == rhs.selfPick)||((this.selfPick!= null)&&this.selfPick.equals(rhs.selfPick)))&&((this.codCharge == rhs.codCharge)||((this.codCharge!= null)&&this.codCharge.equals(rhs.codCharge))))&&((this.feeSite12DiscountFlag == rhs.feeSite12DiscountFlag)||((this.feeSite12DiscountFlag!= null)&&this.feeSite12DiscountFlag.equals(rhs.feeSite12DiscountFlag))))&&((this.cargoTypeId == rhs.cargoTypeId)||((this.cargoTypeId!= null)&&this.cargoTypeId.equals(rhs.cargoTypeId))))&&((this.dispatchInRange == rhs.dispatchInRange)||((this.dispatchInRange!= null)&&this.dispatchInRange.equals(rhs.dispatchInRange))))&&((this.disChargeCargo == rhs.disChargeCargo)||((this.disChargeCargo!= null)&&this.disChargeCargo.equals(rhs.disChargeCargo))))&&((this.dispatchSiteId == rhs.dispatchSiteId)||((this.dispatchSiteId!= null)&&this.dispatchSiteId.equals(rhs.dispatchSiteId))))&&((this.fee1DiscountFlag == rhs.fee1DiscountFlag)||((this.fee1DiscountFlag!= null)&&this.fee1DiscountFlag.equals(rhs.fee1DiscountFlag))))&&((this.ewbNo == rhs.ewbNo)||((this.ewbNo!= null)&&this.ewbNo.equals(rhs.ewbNo))))&&((this.jzservicetype == rhs.jzservicetype)||((this.jzservicetype!= null)&&this.jzservicetype.equals(rhs.jzservicetype))))&&((this.decentralizationPolicy == rhs.decentralizationPolicy)||((this.decentralizationPolicy!= null)&&this.decentralizationPolicy.equals(rhs.decentralizationPolicy))))&&((this.isNoPress == rhs.isNoPress)||((this.isNoPress!= null)&&this.isNoPress.equals(rhs.isNoPress))))&&((this.goodsName == rhs.goodsName)||((this.goodsName!= null)&&this.goodsName.equals(rhs.goodsName))))&&((this.isHighPrice == rhs.isHighPrice)||((this.isHighPrice!= null)&&this.isHighPrice.equals(rhs.isHighPrice))))&&((this.rewbType == rhs.rewbType)||((this.rewbType!= null)&&this.rewbType.equals(rhs.rewbType))))&&((this.jzpickgoodsmode == rhs.jzpickgoodsmode)||((this.jzpickgoodsmode!= null)&&this.jzpickgoodsmode.equals(rhs.jzpickgoodsmode))))&&((this.payModeId == rhs.payModeId)||((this.payModeId!= null)&&this.payModeId.equals(rhs.payModeId))))&&((this.townName == rhs.townName)||((this.townName!= null)&&this.townName.equals(rhs.townName))))&&((this.sendSiteId == rhs.sendSiteId)||((this.sendSiteId!= null)&&this.sendSiteId.equals(rhs.sendSiteId))))&&((this.deliverCenterCode == rhs.deliverCenterCode)||((this.deliverCenterCode!= null)&&this.deliverCenterCode.equals(rhs.deliverCenterCode))))&&((this.weight == rhs.weight)||((this.weight!= null)&&this.weight.equals(rhs.weight))))&&((this.volWeight == rhs.volWeight)||((this.volWeight!= null)&&this.volWeight.equals(rhs.volWeight))))&&((this.totalAmount == rhs.totalAmount)||((this.totalAmount!= null)&&this.totalAmount.equals(rhs.totalAmount))))&&((this.maxEdgeLength == rhs.maxEdgeLength)||((this.maxEdgeLength!= null)&&this.maxEdgeLength.equals(rhs.maxEdgeLength))))&&((this.piece == rhs.piece)||((this.piece!= null)&&this.piece.equals(rhs.piece))))&&((this.goodsProperty == rhs.goodsProperty)||((this.goodsProperty!= null)&&this.goodsProperty.equals(rhs.goodsProperty))))&&((this.ewbType == rhs.ewbType)||((this.ewbType!= null)&&this.ewbType.equals(rhs.ewbType))))&&((this.specialAreaId == rhs.specialAreaId)||((this.specialAreaId!= null)&&this.specialAreaId.equals(rhs.specialAreaId))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.returnAmountTime == rhs.returnAmountTime)||((this.returnAmountTime!= null)&&this.returnAmountTime.equals(rhs.returnAmountTime))))&&((this.transCalcWeight == rhs.transCalcWeight)||((this.transCalcWeight!= null)&&this.transCalcWeight.equals(rhs.transCalcWeight))))&&((this.calcWeight == rhs.calcWeight)||((this.calcWeight!= null)&&this.calcWeight.equals(rhs.calcWeight))))&&((this.kiloMetres == rhs.kiloMetres)||((this.kiloMetres!= null)&&this.kiloMetres.equals(rhs.kiloMetres))))&&((this.goodsCategory == rhs.goodsCategory)||((this.goodsCategory!= null)&&this.goodsCategory.equals(rhs.goodsCategory))))&&((this.rewbNo == rhs.rewbNo)||((this.rewbNo!= null)&&this.rewbNo.equals(rhs.rewbNo))))&&((this.vol == rhs.vol)||((this.vol!= null)&&this.vol.equals(rhs.vol))))&&((this.pickGoodsModeId == rhs.pickGoodsModeId)||((this.pickGoodsModeId!= null)&&this.pickGoodsModeId.equals(rhs.pickGoodsModeId))))&&((this.deliverCenterId == rhs.deliverCenterId)||((this.deliverCenterId!= null)&&this.deliverCenterId.equals(rhs.deliverCenterId))))&&((this.customerId == rhs.customerId)||((this.customerId!= null)&&this.customerId.equals(rhs.customerId))))&&((this.insuredAmount == rhs.insuredAmount)||((this.insuredAmount!= null)&&this.insuredAmount.equals(rhs.insuredAmount))))&&((this.singleWeight == rhs.singleWeight)||((this.singleWeight!= null)&&this.singleWeight.equals(rhs.singleWeight))))&&((this.countMode == rhs.countMode)||((this.countMode!= null)&&this.countMode.equals(rhs.countMode))))&&((this.productType == rhs.productType)||((this.productType!= null)&&this.productType.equals(rhs.productType))))&&((this.stairsTypeId == rhs.stairsTypeId)||((this.stairsTypeId!= null)&&this.stairsTypeId.equals(rhs.stairsTypeId))))&&((this.goodsWide == rhs.goodsWide)||((this.goodsWide!= null)&&this.goodsWide.equals(rhs.goodsWide))))&&((this.isFold == rhs.isFold)||((this.isFold!= null)&&this.isFold.equals(rhs.isFold))))&&((this.freightCharge == rhs.freightCharge)||((this.freightCharge!= null)&&this.freightCharge.equals(rhs.freightCharge))))&&((this.isPutStation == rhs.isPutStation)||((this.isPutStation!= null)&&this.isPutStation.equals(rhs.isPutStation))))&&((this.specialPiece == rhs.specialPiece)||((this.specialPiece!= null)&&this.specialPiece.equals(rhs.specialPiece))))&&((this.installcharge == rhs.installcharge)||((this.installcharge!= null)&&this.installcharge.equals(rhs.installcharge))))&&((this.allAmount == rhs.allAmount)||((this.allAmount!= null)&&this.allAmount.equals(rhs.allAmount))))&&((this.outCatType == rhs.outCatType)||((this.outCatType!= null)&&this.outCatType.equals(rhs.outCatType))))&&((this.serviceid == rhs.serviceid)||((this.serviceid!= null)&&this.serviceid.equals(rhs.serviceid))))&&((this.isDirectCar == rhs.isDirectCar)||((this.isDirectCar!= null)&&this.isDirectCar.equals(rhs.isDirectCar))));
    }

}
