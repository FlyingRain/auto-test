package com.flyingrain.autotest.service.model;

import com.flyingrain.autotest.facade.intf.model.oder.SendOrder;

import java.text.SimpleDateFormat;
import java.util.Date;

public class YunDaWeightCalcu {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String current_time;
    private String vol;
    private String CrmCustomerId;
    private String CreatedDotCode;
    private String BuyerDestinationDotCode;
    private String ProductType;
    private String InGoodsType;
    private String GrossWeight;

    public static YunDaWeightCalcu fromSendOrder(SendOrder sendOrder){
        YunDaWeightCalcu yunDaWeightCalcu = new YunDaWeightCalcu();
        yunDaWeightCalcu.setVol(sendOrder.getGoodsInfo().getVolume()+"");
        yunDaWeightCalcu.setGrossWeight(sendOrder.getGoodsInfo().getWeight()+"");
        yunDaWeightCalcu.setCreatedDotCode("56572779");
        yunDaWeightCalcu.setProductType("24");
        yunDaWeightCalcu.setCurrent_time(simpleDateFormat.format(new Date()));
        return yunDaWeightCalcu;
    }

    public String getCurrent_time() {
        return current_time;
    }

    public void setCurrent_time(String current_time) {
        this.current_time = current_time;
    }

    public String getVol() {
        return vol;
    }

    public void setVol(String vol) {
        this.vol = vol;
    }

    public String getCrmCustomerId() {
        return CrmCustomerId;
    }

    public void setCrmCustomerId(String crmCustomerId) {
        CrmCustomerId = crmCustomerId;
    }

    public String getCreatedDotCode() {
        return CreatedDotCode;
    }

    public void setCreatedDotCode(String createdDotCode) {
        CreatedDotCode = createdDotCode;
    }

    public String getBuyerDestinationDotCode() {
        return BuyerDestinationDotCode;
    }

    public void setBuyerDestinationDotCode(String buyerDestinationDotCode) {
        BuyerDestinationDotCode = buyerDestinationDotCode;
    }

    public String getProductType() {
        return ProductType;
    }

    public void setProductType(String productType) {
        ProductType = productType;
    }

    public String getInGoodsType() {
        return InGoodsType;
    }

    public void setInGoodsType(String inGoodsType) {
        InGoodsType = inGoodsType;
    }

    public String getGrossWeight() {
        return GrossWeight;
    }

    public void setGrossWeight(String grossWeight) {
        GrossWeight = grossWeight;
    }

    @Override
    public String toString() {
        return "YunDaWeightCalcu{" +
                "current_time='" + current_time + '\'' +
                ", vol='" + vol + '\'' +
                ", CrmCustomerId='" + CrmCustomerId + '\'' +
                ", CreatedDotCode='" + CreatedDotCode + '\'' +
                ", BuyerDestinationDotCode='" + BuyerDestinationDotCode + '\'' +
                ", ProductType='" + ProductType + '\'' +
                ", InGoodsType='" + InGoodsType + '\'' +
                ", GrossWeight='" + GrossWeight + '\'' +
                '}';
    }
}
