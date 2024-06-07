package com.flyingrain.autotest.service.model.zhongtong;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.flyingrain.autotest.common.util.HttpUtil;
import com.flyingrain.autotest.common.util.RunTimeContext;
import com.flyingrain.autotest.facade.intf.model.oder.Address;
import com.flyingrain.autotest.facade.intf.model.oder.SendOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ZhongtongUtil {

    private static final Logger logger = LoggerFactory.getLogger(ZhongtongUtil.class);

    public static ZhongtongMessage zhongtongQuery(SendOrder sendOrder) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ZhongtongMessage zhongtongMessage = new ZhongtongMessage();
        Map<String, Object> globalCache = RunTimeContext.globalCache;
        Address receiveAddr = sendOrder.getReceiverInfo().getAddress();
        Address sendAddr = sendOrder.getSendInfo().getAddress();
        String receiveAddrDetail = receiveAddr.getProvince() + receiveAddr.getCity() + receiveAddr.getArea() + receiveAddr.getDetailAddr();
        String sendAddrDetail = sendAddr.getProvince() + sendAddr.getCity() + sendAddr.getArea() + sendAddr.getDetailAddr();
        String addrUrl = "https://gis-prod.zto56.com/app/v2/addressSiteInfo?address=" + receiveAddrDetail;
        Map<String, String> headers = new HashMap<>();
        headers.put("Cookie", globalCache.get("zhongtong").toString());
        String addrStr = HttpUtil.get(addrUrl, headers);
        ZhongtongAddressInfo zhongtongAddressInfo = JSON.parseObject(addrStr).getJSONObject("data").toJavaObject(ZhongtongAddressInfo.class);

        String AddressUrl = "https://ws.zto56.com/sinoEwbInputController/getGisAddressAnalysis";
        Map<String, String> params = new HashMap<>();
        params.put("params", receiveAddrDetail);
        headers.putIfAbsent("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        String addressStr = HttpUtil.postFormUrlEncoded(AddressUrl, headers, params);
        ZhongtongAddressResult zhongtongAddressResult = JSON.parseObject(addressStr).getJSONObject("result").getJSONObject("data").toJavaObject(ZhongtongAddressResult.class);

        params.put("param", sendAddrDetail);
        addressStr = HttpUtil.postFormUrlEncoded(AddressUrl, headers, params);
        ZhongtongAddressResult sendAddressResult = JSON.parseObject(addressStr).getJSONObject("result").getJSONObject("data").toJavaObject(ZhongtongAddressResult.class);

        ZhongtongPriceQueryRequest priceQueryRequest = new ZhongtongPriceQueryRequest();
        priceQueryRequest.setReceiveDest(Integer.parseInt(zhongtongAddressResult.getFirstSiteId()));
        priceQueryRequest.setProductType(24);
        priceQueryRequest.setGoodsType(1);
        priceQueryRequest.setSendDate(simpleDateFormat.format(new Date()));
        priceQueryRequest.setActualWeight(String.format("%.2f", sendOrder.getGoodsInfo().getWeight()));
        priceQueryRequest.setVolume(String.format("%.4f", sendOrder.getGoodsInfo().getVolume()));
        priceQueryRequest.setPickUp("111");
        priceQueryRequest.setCustomerVipFlag(0);
        priceQueryRequest.setPiece(sendOrder.getGoodsInfo().getCount() + "");
        priceQueryRequest.setServiceAdd("0");
        priceQueryRequest.setChkReturnFlag(false);
        priceQueryRequest.setChkBackFlag(false);
        priceQueryRequest.setCbxTown(zhongtongAddressResult.getTownshipId());
        String insureAmount = sendOrder.getAddedValue().getInsureAmount() == null ? "0.00" : sendOrder.getAddedValue().getInsureAmount() + "";
        priceQueryRequest.setInsuredAmount(insureAmount);
        priceQueryRequest.setInsuredScheme(2);
        priceQueryRequest.setActualTotalAmount("0.00");
        priceQueryRequest.setFreightCharge("0.00");
        priceQueryRequest.setPayModeId("102");
        priceQueryRequest.setSendCustomerId(0);
        priceQueryRequest.setVipCustomerId(0);
        priceQueryRequest.setExpressTime(simpleDateFormat.format(new Date()));
        priceQueryRequest.setAccurateCheck(false);
        priceQueryRequest.setExclusiveCheck(false);
        priceQueryRequest.setRewbNo("");
        priceQueryRequest.setSendReceiptFlag(0);
        priceQueryRequest.setShippingMethod("180");
        VillagesFeeParameter villagesFeeParameter = buildParameter(sendAddressResult, zhongtongAddressResult);
        priceQueryRequest.setVillagesFeeParamter(JSONObject.toJSONString(villagesFeeParameter));
        priceQueryRequest.setPickStock("951");
        priceQueryRequest.setMedicineService(0);
        priceQueryRequest.setDzMainInput(false);

        Map<String, String> priceParams = new HashMap<>();
        priceParams.put("params", JSONObject.toJSONString(priceQueryRequest));
        String priceQueryUrl = "https://ws.zto56.com/sinoEwbInputController/executeRecountCharge";
        String priceQueryStr = HttpUtil.postFormUrlEncoded(priceQueryUrl, headers, priceParams);
        logger.info("zhongtong price query result:[{}]", priceQueryStr);
        ZhongtongPriceResult zhongtongPriceResult = JSON.parseObject(priceQueryStr).getJSONObject("result").toJavaObject(ZhongtongPriceResult.class);
        zhongtongMessage.setZhongtongAddressInfo(zhongtongAddressInfo);
        zhongtongMessage.setZhongtongPriceResult(zhongtongPriceResult);
        zhongtongMessage.setZhongtongAddressResult(zhongtongAddressResult);
        return zhongtongMessage;
    }

    private static VillagesFeeParameter buildParameter(ZhongtongAddressResult sendAddr, ZhongtongAddressResult receiveAddr) {
        VillagesFeeParameter villagesFeeParameter = new VillagesFeeParameter();
        villagesFeeParameter.setSendCountryId(sendAddr.getCountryId());
        villagesFeeParameter.setSendProvinceId(sendAddr.getProvinceId());
        villagesFeeParameter.setSendCityId(sendAddr.getCityId());
        villagesFeeParameter.setSendCountyId(sendAddr.getDistrictId());
        villagesFeeParameter.setSendTownId(sendAddr.getTownshipId());
        villagesFeeParameter.setSendVillageId(sendAddr.getVillageId());
        villagesFeeParameter.setDispatchCountryId(receiveAddr.getCountryId());
        villagesFeeParameter.setDispatchCityId(receiveAddr.getCityId());
        villagesFeeParameter.setDispatchProvinceId(receiveAddr.getProvinceId());
        villagesFeeParameter.setDispatchCountyId(receiveAddr.getDistrictId());
        villagesFeeParameter.setDispatchTownId(receiveAddr.getTownshipId());
        villagesFeeParameter.setDispatchVillageId(receiveAddr.getVillageId());
        return villagesFeeParameter;
    }

}
