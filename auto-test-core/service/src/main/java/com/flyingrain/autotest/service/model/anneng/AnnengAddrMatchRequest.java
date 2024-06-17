package com.flyingrain.autotest.service.model.anneng;

public class AnnengAddrMatchRequest {

    private String addressInfo;

    private Integer isPostStation = 1;

    private String identific = "360";

    public String getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(String addressInfo) {
        this.addressInfo = addressInfo;
    }

    public Integer getIsPostStation() {
        return isPostStation;
    }

    public void setIsPostStation(Integer isPostStation) {
        this.isPostStation = isPostStation;
    }

    public String getIdentific() {
        return identific;
    }

    public void setIdentific(String identific) {
        this.identific = identific;
    }
}
