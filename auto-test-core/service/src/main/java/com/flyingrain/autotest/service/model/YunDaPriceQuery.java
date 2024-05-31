package com.flyingrain.autotest.service.model;


import com.alibaba.fastjson.JSONObject;
import com.flyingrain.autotest.common.util.HttpUtil;
import com.flyingrain.autotest.common.util.ObjectToMapUtil;
import com.flyingrain.autotest.common.util.RunTimeContext;
import com.flyingrain.autotest.facade.intf.model.oder.SendOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class YunDaPriceQuery {

    private static final Logger logger = LoggerFactory.getLogger(YunDaPriceQuery.class);

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private String GoodsType;
    private String ServiceType;
    private String ProductType;
    private String PaymentType;
    private String LogisticsId;
    private String CreatedDotCode;
    private String BuyerDestinationDotCode;
    private String SenderDistributionCode;
    private String SettlementTotalNumber;
    private String current_time;
    private String ItemTotalNumber;
    private String Freight;
    private String ShippingMethods;
    private String ShippingType;
    private String NoElevator;
    private String ShippingFloor;
    private String InsuredAmount;
    private String DeliversReturn;
    private String VipService;
    private String IsCod;
    private String CollectionMoney;
    private String ReturnClass;
    private String WarehouseCode;
    private String BuyerTown;
    private String BuyerArea;
    private String ExtendField6;
    private String CreatedByCode;
    private String IsPreferential;
    private String IsDiscount;
    private String IsFbzp;
    private String BuyerProvince;
    private String BuyerCity;
    private String BuyerAddress;
    private String DestinationDotScope;
    private String PageType;
    private String Distance;
    private String Volume;
    private String GrossWeight;
    private String CrmCustomerId;
    private String InGoodsType;
    private String CheckHeavyWeight;
    private String CheckFixedCost;
    private String CheckSafeArrive;
    private String LongestSideLength;
    private String OrderSource;
    private String ReplaceId;

    public static YunDaPriceQuery fromSendOrder(SendOrder sendOrder) {
        YunDaPriceQuery yunDaPriceQuery = new YunDaPriceQuery();

        YunDaAddressQuery yunDaDesAddressQuery = YunDaAddressQuery.fromAddress(sendOrder.getReceiverInfo().getAddress());
        YunDaAddressQuery yunDaFromAddressQuery = YunDaAddressQuery.fromAddress(sendOrder.getSendInfo().getAddress());
        String queryUrl = "http://inms.yunda56.com:3351/ky_inms/public/index.php/joinlgs/MakeLogisticsApi/getAchieveSiteByAddress.html";
        Map<String, String> headers = new HashMap<>();
        headers.putIfAbsent("Cookie", "PHPSESSID=" + RunTimeContext.yundaCookie);
        YunDaAddressInfo yunDaDesAddressInfo = getYunDaAddressInfo(queryUrl, headers, yunDaDesAddressQuery);
        YunDaAddressInfo yunDaFromAddressInfo = getYunDaAddressInfo(queryUrl, headers, yunDaFromAddressQuery);
        logger.info("query yunda info:[{}]", yunDaDesAddressInfo);

        String weightQueryUrl = "http://inms.yunda56.com:3351/ky_inms/public/index.php/weight.html";
        YunDaWeightCalcu yunDaWeightCalcu = YunDaWeightCalcu.fromSendOrder(sendOrder);
        yunDaWeightCalcu.setBuyerDestinationDotCode(yunDaDesAddressInfo.getTarget_center_code());
        String weight = HttpUtil.postFormUrlEncoded(weightQueryUrl, headers, ObjectToMapUtil.ObjToMap(yunDaWeightCalcu));
        logger.info("query yunda weight :[{}]", weight);
        YunDaWeight yunDaWeight = JSONObject.parseObject(weight,YunDaWeight.class);


        yunDaPriceQuery.setCreatedDotCode("56572779");
        yunDaPriceQuery.setGoodsType("184");
        yunDaPriceQuery.setServiceType("111");
        yunDaPriceQuery.setProductType("24");
        yunDaPriceQuery.setPaymentType("102");
        yunDaPriceQuery.setLogisticsId("0");
        yunDaPriceQuery.setBuyerDestinationDotCode(yunDaDesAddressInfo.getTarget_center_code());
        yunDaPriceQuery.setSenderDistributionCode(yunDaFromAddressInfo.getBusiness_center_code());
        yunDaPriceQuery.setSettlementTotalNumber(yunDaWeight.getTfr());
        yunDaPriceQuery.setCurrent_time(simpleDateFormat.format(new Date()));
        yunDaPriceQuery.setItemTotalNumber(sendOrder.getGoodsInfo().getCount() + "");
        yunDaPriceQuery.setFreight("0.00");
        yunDaPriceQuery.setShippingMethods("180");
        yunDaPriceQuery.setInsuredAmount(sendOrder.getAddedValue().getInsureAmount() + "");
        yunDaPriceQuery.setDeliversReturn("0");
        yunDaPriceQuery.setVipService("0");
        yunDaPriceQuery.setIsCod("0");
        yunDaPriceQuery.setBuyerTown(yunDaDesAddressInfo.getBuyerTownCode());
        yunDaPriceQuery.setBuyerArea(yunDaDesAddressInfo.getBuyerAreaCode());
        yunDaPriceQuery.setExtendField6("0");
        yunDaPriceQuery.setCreatedByCode("56572779002");
        yunDaPriceQuery.setIsPreferential("0");
        yunDaPriceQuery.setIsDiscount("2");
        yunDaPriceQuery.setIsFbzp("0");
        yunDaPriceQuery.setBuyerProvince(yunDaDesAddressInfo.getBuyerProvinceCode());
        yunDaPriceQuery.setBuyerCity(yunDaDesAddressInfo.getBuyerCityCode());
        yunDaPriceQuery.setBuyerAddress(sendOrder.getReceiverInfo().getAddress().getDetailAddr());
        yunDaPriceQuery.setDestinationDotScope(yunDaDesAddressInfo.getBusiness_center_code());
        yunDaPriceQuery.setPageType("3");
        yunDaPriceQuery.setVolume(sendOrder.getGoodsInfo().getVolume() + "");
        yunDaPriceQuery.setGrossWeight(sendOrder.getGoodsInfo().getWeight() + "");
        yunDaPriceQuery.setCheckHeavyWeight("0");
        yunDaPriceQuery.setCheckFixedCost("0");
        yunDaPriceQuery.setCheckSafeArrive("0");
        return yunDaPriceQuery;
    }

    private static YunDaAddressInfo getYunDaAddressInfo(String queryUrl, Map<String, String> headers, YunDaAddressQuery yunDaAddressQuery) {
        String result = HttpUtil.postFormUrlEncoded(queryUrl, headers, ObjectToMapUtil.ObjToMap(yunDaAddressQuery));
        JSONObject jsonObject = JSONObject.parseObject(result);
        JSONObject data = jsonObject.getJSONObject("data");
        Set<String> keySet = data.keySet();
        YunDaAddressInfo yunDaDesAddressInfo = null;
        if (keySet.size() == 1) {
            for (String key : keySet) {
                yunDaDesAddressInfo = data.getObject(key, YunDaAddressInfo.class);
            }
        }
        return yunDaDesAddressInfo;
    }

    public String getGoodsType() {
        return GoodsType;
    }

    public void setGoodsType(String goodsType) {
        GoodsType = goodsType;
    }

    public String getServiceType() {
        return ServiceType;
    }

    public void setServiceType(String serviceType) {
        ServiceType = serviceType;
    }

    public String getProductType() {
        return ProductType;
    }

    public void setProductType(String productType) {
        ProductType = productType;
    }

    public String getPaymentType() {
        return PaymentType;
    }

    public void setPaymentType(String paymentType) {
        PaymentType = paymentType;
    }

    public String getLogisticsId() {
        return LogisticsId;
    }

    public void setLogisticsId(String logisticsId) {
        LogisticsId = logisticsId;
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

    public String getSenderDistributionCode() {
        return SenderDistributionCode;
    }

    public void setSenderDistributionCode(String senderDistributionCode) {
        SenderDistributionCode = senderDistributionCode;
    }

    public String getSettlementTotalNumber() {
        return SettlementTotalNumber;
    }

    public void setSettlementTotalNumber(String settlementTotalNumber) {
        SettlementTotalNumber = settlementTotalNumber;
    }

    public String getCurrent_time() {
        return current_time;
    }

    public void setCurrent_time(String current_time) {
        this.current_time = current_time;
    }

    public String getItemTotalNumber() {
        return ItemTotalNumber;
    }

    public void setItemTotalNumber(String itemTotalNumber) {
        ItemTotalNumber = itemTotalNumber;
    }

    public String getFreight() {
        return Freight;
    }

    public void setFreight(String freight) {
        Freight = freight;
    }

    public String getShippingMethods() {
        return ShippingMethods;
    }

    public void setShippingMethods(String shippingMethods) {
        ShippingMethods = shippingMethods;
    }

    public String getShippingType() {
        return ShippingType;
    }

    public void setShippingType(String shippingType) {
        ShippingType = shippingType;
    }

    public String getNoElevator() {
        return NoElevator;
    }

    public void setNoElevator(String noElevator) {
        NoElevator = noElevator;
    }

    public String getShippingFloor() {
        return ShippingFloor;
    }

    public void setShippingFloor(String shippingFloor) {
        ShippingFloor = shippingFloor;
    }

    public String getInsuredAmount() {
        return InsuredAmount;
    }

    public void setInsuredAmount(String insuredAmount) {
        InsuredAmount = insuredAmount;
    }

    public String getDeliversReturn() {
        return DeliversReturn;
    }

    public void setDeliversReturn(String deliversReturn) {
        DeliversReturn = deliversReturn;
    }

    public String getVipService() {
        return VipService;
    }

    public void setVipService(String vipService) {
        VipService = vipService;
    }

    public String getIsCod() {
        return IsCod;
    }

    public void setIsCod(String isCod) {
        IsCod = isCod;
    }

    public String getCollectionMoney() {
        return CollectionMoney;
    }

    public void setCollectionMoney(String collectionMoney) {
        CollectionMoney = collectionMoney;
    }

    public String getReturnClass() {
        return ReturnClass;
    }

    public void setReturnClass(String returnClass) {
        ReturnClass = returnClass;
    }

    public String getWarehouseCode() {
        return WarehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        WarehouseCode = warehouseCode;
    }

    public String getBuyerTown() {
        return BuyerTown;
    }

    public void setBuyerTown(String buyerTown) {
        BuyerTown = buyerTown;
    }

    public String getBuyerArea() {
        return BuyerArea;
    }

    public void setBuyerArea(String buyerArea) {
        BuyerArea = buyerArea;
    }

    public String getExtendField6() {
        return ExtendField6;
    }

    public void setExtendField6(String extendField6) {
        ExtendField6 = extendField6;
    }

    public String getCreatedByCode() {
        return CreatedByCode;
    }

    public void setCreatedByCode(String createdByCode) {
        CreatedByCode = createdByCode;
    }

    public String getIsPreferential() {
        return IsPreferential;
    }

    public void setIsPreferential(String isPreferential) {
        IsPreferential = isPreferential;
    }

    public String getIsDiscount() {
        return IsDiscount;
    }

    public void setIsDiscount(String isDiscount) {
        IsDiscount = isDiscount;
    }

    public String getIsFbzp() {
        return IsFbzp;
    }

    public void setIsFbzp(String isFbzp) {
        IsFbzp = isFbzp;
    }

    public String getBuyerProvince() {
        return BuyerProvince;
    }

    public void setBuyerProvince(String buyerProvince) {
        BuyerProvince = buyerProvince;
    }

    public String getBuyerCity() {
        return BuyerCity;
    }

    public void setBuyerCity(String buyerCity) {
        BuyerCity = buyerCity;
    }

    public String getBuyerAddress() {
        return BuyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        BuyerAddress = buyerAddress;
    }

    public String getDestinationDotScope() {
        return DestinationDotScope;
    }

    public void setDestinationDotScope(String destinationDotScope) {
        DestinationDotScope = destinationDotScope;
    }

    public String getPageType() {
        return PageType;
    }

    public void setPageType(String pageType) {
        PageType = pageType;
    }

    public String getDistance() {
        return Distance;
    }

    public void setDistance(String distance) {
        Distance = distance;
    }

    public String getVolume() {
        return Volume;
    }

    public void setVolume(String volume) {
        Volume = volume;
    }

    public String getGrossWeight() {
        return GrossWeight;
    }

    public void setGrossWeight(String grossWeight) {
        GrossWeight = grossWeight;
    }

    public String getCrmCustomerId() {
        return CrmCustomerId;
    }

    public void setCrmCustomerId(String crmCustomerId) {
        CrmCustomerId = crmCustomerId;
    }

    public String getInGoodsType() {
        return InGoodsType;
    }

    public void setInGoodsType(String inGoodsType) {
        InGoodsType = inGoodsType;
    }

    public String getCheckHeavyWeight() {
        return CheckHeavyWeight;
    }

    public void setCheckHeavyWeight(String checkHeavyWeight) {
        CheckHeavyWeight = checkHeavyWeight;
    }

    public String getCheckFixedCost() {
        return CheckFixedCost;
    }

    public void setCheckFixedCost(String checkFixedCost) {
        CheckFixedCost = checkFixedCost;
    }

    public String getCheckSafeArrive() {
        return CheckSafeArrive;
    }

    public void setCheckSafeArrive(String checkSafeArrive) {
        CheckSafeArrive = checkSafeArrive;
    }

    public String getLongestSideLength() {
        return LongestSideLength;
    }

    public void setLongestSideLength(String longestSideLength) {
        LongestSideLength = longestSideLength;
    }

    public String getOrderSource() {
        return OrderSource;
    }

    public void setOrderSource(String orderSource) {
        OrderSource = orderSource;
    }

    public String getReplaceId() {
        return ReplaceId;
    }

    public void setReplaceId(String replaceId) {
        ReplaceId = replaceId;
    }

    @Override
    public String toString() {
        return "YunDaPriceQuery{" +
                "GoodsType='" + GoodsType + '\'' +
                ", ServiceType='" + ServiceType + '\'' +
                ", ProductType='" + ProductType + '\'' +
                ", PaymentType='" + PaymentType + '\'' +
                ", LogisticsId='" + LogisticsId + '\'' +
                ", CreatedDotCode='" + CreatedDotCode + '\'' +
                ", BuyerDestinationDotCode='" + BuyerDestinationDotCode + '\'' +
                ", SenderDistributionCode='" + SenderDistributionCode + '\'' +
                ", SettlementTotalNumber='" + SettlementTotalNumber + '\'' +
                ", current_time='" + current_time + '\'' +
                ", ItemTotalNumber='" + ItemTotalNumber + '\'' +
                ", Freight='" + Freight + '\'' +
                ", ShippingMethods='" + ShippingMethods + '\'' +
                ", ShippingType='" + ShippingType + '\'' +
                ", NoElevator='" + NoElevator + '\'' +
                ", ShippingFloor='" + ShippingFloor + '\'' +
                ", InsuredAmount='" + InsuredAmount + '\'' +
                ", DeliversReturn='" + DeliversReturn + '\'' +
                ", VipService='" + VipService + '\'' +
                ", IsCod='" + IsCod + '\'' +
                ", CollectionMoney='" + CollectionMoney + '\'' +
                ", ReturnClass='" + ReturnClass + '\'' +
                ", WarehouseCode='" + WarehouseCode + '\'' +
                ", BuyerTown='" + BuyerTown + '\'' +
                ", BuyerArea='" + BuyerArea + '\'' +
                ", ExtendField6='" + ExtendField6 + '\'' +
                ", CreatedByCode='" + CreatedByCode + '\'' +
                ", IsPreferential='" + IsPreferential + '\'' +
                ", IsDiscount='" + IsDiscount + '\'' +
                ", IsFbzp='" + IsFbzp + '\'' +
                ", BuyerProvince='" + BuyerProvince + '\'' +
                ", BuyerCity='" + BuyerCity + '\'' +
                ", BuyerAddress='" + BuyerAddress + '\'' +
                ", DestinationDotScope='" + DestinationDotScope + '\'' +
                ", PageType='" + PageType + '\'' +
                ", Distance='" + Distance + '\'' +
                ", Volume='" + Volume + '\'' +
                ", GrossWeight='" + GrossWeight + '\'' +
                ", CrmCustomerId='" + CrmCustomerId + '\'' +
                ", InGoodsType='" + InGoodsType + '\'' +
                ", CheckHeavyWeight='" + CheckHeavyWeight + '\'' +
                ", CheckFixedCost='" + CheckFixedCost + '\'' +
                ", CheckSafeArrive='" + CheckSafeArrive + '\'' +
                ", LongestSideLength='" + LongestSideLength + '\'' +
                ", OrderSource='" + OrderSource + '\'' +
                ", ReplaceId='" + ReplaceId + '\'' +
                '}';
    }
}
