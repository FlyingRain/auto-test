package com.flyingrain.autotest.service.model.yimi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.flyingrain.autotest.common.util.HttpUtil;
import com.flyingrain.autotest.common.util.RunTimeContext;
import com.flyingrain.autotest.facade.intf.model.oder.Address;
import com.flyingrain.autotest.facade.intf.model.oder.SendOrder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YimiPriceUtil {

    public static YimiMessage queryYimi(SendOrder sendOrder) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        YimiMessage yimiMessage = new YimiMessage();
        Address address = sendOrder.getReceiverInfo().getAddress();
        Address sendAddress = sendOrder.getSendInfo().getAddress();
        ;
        String addrDetail = address.getProvince() + address.getCity() + address.getArea() + address.getDetailAddr();
        String sendAddrDetail = sendAddress.getProvince() + sendAddress.getCity() + sendAddress.getArea() + sendAddress.getDetailAddr();
        String addrQueryUrl = "https://yh.yimidida.com/galaxy-gis-business/map/getTownByAddress?address=" + addrDetail + "&bizSystem=ludan&method=getTownByGis";
        String sendAddrQueryUrl = "https://yh.yimidida.com/galaxy-gis-business/map/getTownByAddress?address=" + sendAddrDetail + "&bizSystem=ludan&method=getTownByGis";
        Map<String, String> headers = new HashMap<>();
        Map<String, String> yimiCache = (Map<String, String>) RunTimeContext.globalCache.get("yimi");
        headers.put("Cookie", yimiCache.get("yimiCookie"));
        String result = HttpUtil.get(addrQueryUrl, headers);
        String comCode = yimiCache.get("CompCode");
        String deptCode = yimiCache.get("DeptCode");
        JSONObject yimiCommonAddr = JSON.parseObject(result);
        YimiAddressCommon yimiAddressCommon = yimiCommonAddr.getObject("data", YimiAddressCommon.class);

        String sendResult = HttpUtil.get(sendAddrQueryUrl, headers);
        JSONObject sendYimiCommonAddr = JSON.parseObject(sendResult);
        YimiAddressCommon sendYimiAddressCommon = sendYimiCommonAddr.getObject("data", YimiAddressCommon.class);


        String locAddrUrl = "https://yh.yimidida.com/galaxy-gis-business/gisService/getLocationByThreeMapNew?address=" + addrDetail + "&bizSystem=YH-GIS-PC";
        String locResult = HttpUtil.get(locAddrUrl, headers);
        JSONObject locJsonObject = JSON.parseObject(locResult);
        JSONObject loc = locJsonObject.getJSONObject("data").getJSONObject("optimalPoint");
        Double lat = loc.getDouble("lat");
        Double bdLat = loc.getDouble("lng");


        String decideAddrUrl = "https://yh.yimidida.com/galaxy-addressdb-business/addlib/http/queryDeptCodeB?receiveDiscrictCode=" + sendYimiAddressCommon.getProvinceCode() + "," + sendYimiAddressCommon.getCityCode() + "&detailAddress=" + sendAddress.getDetailAddr() + "&sourceComp=" + comCode + "&deptAttr=1&otherAttr=2&areaCode=" + yimiAddressCommon.getStreetCode() + "&coordinate=" + bdLat + "," + lat + "&sourceDeptCode=" + deptCode + "&bizSystem=YH-GIS-PC&useServerPointA=1&gaoProvince=" + address.getProvince() + "&gaoCity=" + address.getCity() + "&receiveName=&receivePhone=&dataSourceType=1&customerName=&provinceCode=" + yimiAddressCommon.getProvinceCode();
        String decideAddrResult = HttpUtil.get(decideAddrUrl, headers);
        JSONObject jsonObject = JSON.parseObject(decideAddrResult);
        String targetDeptCode = jsonObject.getJSONObject("data").getString("targetDeptCode");

        String addressChooseUrl = "https://yh.yimidida.com/galaxy-gis-business/map/getNetworkMapList2?provinceCode=" + yimiAddressCommon.getProvinceCode() + "&cityCode=" + yimiAddressCommon.getCityCode() + "&dictCode=&bizType=2&compCode=" + comCode + "&sreType=1&lng=" + bdLat + "&lat=" + lat + "&deptCode=" + deptCode + "&mapType=2&num=10";
        String addressChooseResultStr = HttpUtil.get(addressChooseUrl, headers);
        JSONObject addrChooseJson = JSON.parseObject(addressChooseResultStr);
        List<YimiAddress> yimiAddressList = addrChooseJson.getJSONObject("data").getJSONArray("deptList").toJavaList(YimiAddress.class);
        YimiAddress yimiAddress = chooseAddr(yimiAddressList,targetDeptCode);
        yimiMessage.setYimiAddress(yimiAddress);

        String lineQueryUrl = "https://yh.yimidida.com/galaxy-route-business/lineHttp/lineOnlyFusionNew?sourceZoneCode=" + deptCode + "&destZoneCode=" + yimiAddress.getDeptCode() + "&productType=CP02&productCategories=1";
        String lineResultStr = HttpUtil.get(lineQueryUrl, headers);
        JSONObject lineObj = JSON.parseObject(lineResultStr);
        String rout = lineObj.getJSONObject("data").getString("route");

        String weightQueryUrl = "https://yh.yimidida.com/galaxy-base-business/api/heavyBubbleRatio/calculateWeightRatio?compCode=" + comCode + "&endCompCode=" + yimiAddress.getBelongComp() + "&sourceZoneCode=" + deptCode + "&destZoneCode=" + yimiAddress.getDeptCode() + "&ratioValue=" + sendOrder.getGoodsInfo().getVolume() + "&waybillTime=&weight=" + sendOrder.getGoodsInfo().getWeight() + "&dataSourceType=1&bizSource=1&calculationType=1&businessType=2";
        String weightStr = HttpUtil.get(weightQueryUrl, headers);
        Double weight = JSON.parseObject(weightStr).getJSONObject("data").getDouble("general");
        double num = Math.ceil(weight);
        weight = num > sendOrder.getGoodsInfo().getWeight() ? num : sendOrder.getGoodsInfo().getWeight();

        YimiPriceQueryRequest yimiPriceQueryRequest = new YimiPriceQueryRequest();
        yimiPriceQueryRequest.setCompCode(comCode);
        yimiPriceQueryRequest.setBusinessModel(1);
        yimiPriceQueryRequest.setBizType(1);
        yimiPriceQueryRequest.setSourceZoneCode(deptCode);
        yimiPriceQueryRequest.setDestZoneCode(yimiAddress.getDeptCode());
        yimiPriceQueryRequest.setServiceType(1);
        yimiPriceQueryRequest.setChargeableWeight(weight);
        yimiPriceQueryRequest.setRouteCode(rout);
        yimiPriceQueryRequest.setProductType("CP24");
        yimiPriceQueryRequest.setConsignCode("2");
        yimiPriceQueryRequest.setConsignorTime(simpleDateFormat.format(new Date()));
        yimiPriceQueryRequest.setQuantity(sendOrder.getGoodsInfo().getCount());
        yimiPriceQueryRequest.setToCompCode(yimiAddress.getBelongComp());
        yimiPriceQueryRequest.setVolume(sendOrder.getGoodsInfo().getVolume() + "");
        yimiPriceQueryRequest.setDataSourceType(1);
        yimiPriceQueryRequest.setTestTime(simpleDateFormat.format(new Date()));
        yimiPriceQueryRequest.setConsigneeAddressCode(yimiAddressCommon.getStreetCode());
        yimiPriceQueryRequest.setBizSource(1);
        yimiPriceQueryRequest.setPaymentType(1);
        yimiPriceQueryRequest.setTransferWeight(weight);
        yimiPriceQueryRequest.setFusionMode("1-1");


        String yimiPriceQueryUrl = "https://yh.yimidida.com/galaxy-stl-business/api/stl/cost/calcWayCostFeeAndSendFee";
        String priceResultStr = HttpUtil.post(yimiPriceQueryUrl, headers, JSONObject.toJSONString(yimiPriceQueryRequest));

        YimiPriceResult yimiPriceResult = JSON.parseObject(priceResultStr).getJSONObject("data").toJavaObject(YimiPriceResult.class);
        yimiMessage.setYimiPriceResult(yimiPriceResult);
        return yimiMessage;
    }

    private static YimiAddress chooseAddr(List<YimiAddress> yimiAddressList, String targetDeptCode) {
        for (YimiAddress addr : yimiAddressList) {
            if(targetDeptCode.equals(addr.getDeptCode())){
                return addr;
            }
        }
        return null;
    }

}
