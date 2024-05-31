package com.flyingrain.autotest.facade.intf.model.oder;

public class ChannelCompare {

    private String channelCode;

    private String channelName;

    private String siteAddress;

    private String siteDes;

    private String sitePhone;

    private String queryGoodPhone;

    private String distance;

    private String siteManagerName;

    private String specialInfo;

    private String targetSite;

    private ChannelPrice channelPrice = new ChannelPrice();

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getSiteAddress() {
        return siteAddress;
    }

    public void setSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress;
    }

    public String getSitePhone() {
        return sitePhone;
    }

    public void setSitePhone(String sitePhone) {
        this.sitePhone = sitePhone;
    }

    public String getQueryGoodPhone() {
        return queryGoodPhone;
    }

    public String getSiteDes() {
        return siteDes;
    }

    public void setSiteDes(String siteDes) {
        this.siteDes = siteDes;
    }

    public void setQueryGoodPhone(String queryGoodPhone) {
        this.queryGoodPhone = queryGoodPhone;
    }

    public String getSiteManagerName() {
        return siteManagerName;
    }

    public void setSiteManagerName(String siteManagerName) {
        this.siteManagerName = siteManagerName;
    }

    public String getSpecialInfo() {
        return specialInfo;
    }

    public void setSpecialInfo(String specialInfo) {
        this.specialInfo = specialInfo;
    }

    public String getTargetSite() {
        return targetSite;
    }

    public void setTargetSite(String targetSite) {
        this.targetSite = targetSite;
    }

    public ChannelPrice getChannelPrice() {
        return channelPrice;
    }

    public void setChannelPrice(ChannelPrice channelPrice) {
        this.channelPrice = channelPrice;
    }

    @Override
    public String toString() {
        return "ChannelCompare{" +
                "channelCode='" + channelCode + '\'' +
                ", channelName='" + channelName + '\'' +
                ", siteAddress='" + siteAddress + '\'' +
                ", sitePhone='" + sitePhone + '\'' +
                ", siteManagerName='" + siteManagerName + '\'' +
                ", specialInfo='" + specialInfo + '\'' +
                ", targetSite='" + targetSite + '\'' +
                ", channelPrice=" + channelPrice +
                '}';
    }
}
