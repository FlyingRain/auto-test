package com.flyingrain.autotest.service.model.anneng;

import com.alibaba.fastjson.annotation.JSONField;

public class AnnengWeightRequest {

    @JSONField(name = "SEND_TIME")
    private String sendTime;

    @JSONField(name="WEIGHT")
    private Double weight;

    @JSONField(name = "VOL")
    private Double vol;

    @JSONField(name = "SEND_SITE_ID")
    private int sendSiteId;

    @JSONField(name = "DISPATCH_SITE_ID")
    private int dispatchSiteId;

    @JSONField(name = "PRODUCT_TYPE")
    private int productType;

    @JSONField(name = "EWB_NO")
    private String ewbNo;

    @JSONField(name = "GOODS_NAME")
    private String goodsName;


    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getVol() {
        return vol;
    }

    public void setVol(Double vol) {
        this.vol = vol;
    }

    public int getSendSiteId() {
        return sendSiteId;
    }

    public void setSendSiteId(int sendSiteId) {
        this.sendSiteId = sendSiteId;
    }

    public int getDispatchSiteId() {
        return dispatchSiteId;
    }

    public void setDispatchSiteId(int dispatchSiteId) {
        this.dispatchSiteId = dispatchSiteId;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public String getEwbNo() {
        return ewbNo;
    }

    public void setEwbNo(String ewbNo) {
        this.ewbNo = ewbNo;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}
