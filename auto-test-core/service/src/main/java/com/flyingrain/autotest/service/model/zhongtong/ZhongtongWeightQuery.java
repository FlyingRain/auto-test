package com.flyingrain.autotest.service.model.zhongtong;

public class ZhongtongWeightQuery {

    private Integer receiveDest;

    private Integer productType;

    private String actualWeight;

    private Integer goodsType;

    private String goodsName;

    private String sendDate;

    private String volume;

    private String releaseSiteId;

    private String ewbNo;


    public Integer getReceiveDest() {
        return receiveDest;
    }

    public void setReceiveDest(Integer receiveDest) {
        this.receiveDest = receiveDest;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public String getActualWeight() {
        return actualWeight;
    }

    public void setActualWeight(String actualWeight) {
        this.actualWeight = actualWeight;
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getReleaseSiteId() {
        return releaseSiteId;
    }

    public void setReleaseSiteId(String releaseSiteId) {
        this.releaseSiteId = releaseSiteId;
    }

    public String getEwbNo() {
        return ewbNo;
    }

    public void setEwbNo(String ewbNo) {
        this.ewbNo = ewbNo;
    }

    @Override
    public String toString() {
        return "ZhongtongWeightQuery{" +
                "receiveDest=" + receiveDest +
                ", productType=" + productType +
                ", actualWeight='" + actualWeight + '\'' +
                ", goodsType=" + goodsType +
                ", goodsName='" + goodsName + '\'' +
                ", sendDate='" + sendDate + '\'' +
                ", volume='" + volume + '\'' +
                ", releaseSiteId='" + releaseSiteId + '\'' +
                ", ewbNo='" + ewbNo + '\'' +
                '}';
    }
}
