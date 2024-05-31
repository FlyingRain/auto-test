package com.flyingrain.autotest.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.flyingrain.autotest.common.util.*;
import com.flyingrain.autotest.domain.AutoTestModuleManager;
import com.flyingrain.autotest.domain.service.CityService;
import com.flyingrain.autotest.facade.intf.TestFacade;
import com.flyingrain.autotest.facade.intf.model.AutoTestIn;
import com.flyingrain.autotest.facade.intf.model.oder.*;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestModuleModel;
import com.flyingrain.autotest.infrastructure.datasource.model.CityModel;
import com.flyingrain.autotest.mvc.jersey.AutoTestService;
import com.flyingrain.autotest.mvc.jersey.Resource;
import com.flyingrain.autotest.service.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Component
@AutoTestService
public class TestFacadeImpl implements TestFacade, Resource {

    private final Logger logger = LoggerFactory.getLogger(TestFacadeImpl.class);

    @Autowired
    private AutoTestModuleManager autoTestModuleManager;

    @Autowired
    private CityService cityService;

    @Override
    public String test() {
        logger.info("test log");
        List<AutoTestModuleModel> autoTestModuleModels = autoTestModuleManager.queryAllModule();
        return autoTestModuleModels + "";
    }

    @Override
    public String receiveParam(AutoTestIn param) {
        logger.info("token:[{}]", param);
        String cookieStr = param.getIn();
        MyChromeCookie myChromeCookie = JSONObject.parseObject(cookieStr, MyChromeCookie.class);
        List<ChromeCookieUnit> cookieUnitList = myChromeCookie.getData();
        for (ChromeCookieUnit chromeCookieUnit : cookieUnitList) {
            if ("PHPSESSID".equals(chromeCookieUnit.getName())) {
                RunTimeContext.yundaCookie = chromeCookieUnit.getValue();
                RunTimeContext.put("PHPSESSID", chromeCookieUnit.getValue());
            }
        }
        return param.getIn();
    }


    @Override
    public CommonResult<List<ChannelCompare>> compare(SendOrder sendOrder) {
        logger.info("send order:[{}]", sendOrder);
        List<ChannelCompare> channelCompares = new ArrayList<>();
        ChannelCompare channelCompare = new ChannelCompare();
        if (sendOrder.getSendInfo() == null || !addressCheck(sendOrder.getSendInfo().getAddress())) {
            return CommonResult.fail("500", "请检查地址，确保省市区不为空");
        }
        prehandle(sendOrder);
        YunDaAddressQuery yunDaDesAddressQuery = YunDaAddressQuery.fromAddress(sendOrder.getReceiverInfo().getAddress());
        String queryUrl = "http://inms.yunda56.com:3351/ky_inms/public/index.php/joinlgs/MakeLogisticsApi/getAchieveSiteByAddress.html";
        Map<String, String> headers = new HashMap<>();
        headers.putIfAbsent("Cookie", "PHPSESSID=" + RunTimeContext.yundaCookie);
        String result = HttpUtil.postFormUrlEncoded(queryUrl, headers, ObjectToMapUtil.ObjToMap(yunDaDesAddressQuery));
        JSONObject addr = JSONObject.parseObject(result).getJSONObject("data");
        YunDaAddressInfo yunDaDesAddressInfo = null;
        Set<String> keySet = addr.keySet();
        JSONObject addrJSON = null;
        if (keySet.size() == 1) {
            for (String key : keySet) {
                addrJSON = addr.getJSONObject(key);
                yunDaDesAddressInfo = addr.getObject(key, YunDaAddressInfo.class);
            }
        }
        if (yunDaDesAddressInfo == null) {
            return CommonResult.fail("500", "不支持的地址");
        }
        YunDaPriceQuery yunDaPriceQuery = YunDaPriceQuery.fromSendOrder(sendOrder);
        String priceUrl = "http://inms.yunda56.com:3351/ky_inms/public/index.php/price.html";
        String yunDaPriceStr = HttpUtil.postFormUrlEncoded(priceUrl, headers, ObjectToMapUtil.ObjToMap(yunDaPriceQuery));
        logger.info("query yunda info:[{}]", yunDaPriceStr);
        JSONObject jsonObject = JSONObject.parseObject(yunDaPriceStr);
        JSONObject priceDetailList = jsonObject.getJSONObject("showCost");
        JSONArray jsonArray = priceDetailList.getJSONArray("classifyCost");
        List<YunDaPriceDetail> yunDaPriceDetails = jsonArray.toJavaList(YunDaPriceDetail.class);
        Map<String, String> prices = new HashMap<>();
        for (YunDaPriceDetail detail : yunDaPriceDetails) {
            if ("TotalMoney".equals(detail.getParentCode())) {
                channelCompare.getChannelPrice().setTotal(Double.parseDouble(detail.getTwoTotal()) + 0.05);
            } else {
                prices.put(detail.getName(), detail.getTwoTotal());
            }
        }
        channelCompare.getChannelPrice().setOtherDetail(MapToStrUtil.mapToStr(prices));
        channelCompare.setChannelName("韵达");
        channelCompare.setDistance(buildDistanceDescription(yunDaDesAddressInfo));
        channelCompare.setQueryGoodPhone(yunDaDesAddressInfo.getQry_phone());
        channelCompare.setSiteDes(yunDaDesAddressInfo.getTownMsg());
        channelCompare.setSiteAddress(yunDaDesAddressInfo.getSiteAddress());
        channelCompare.setSitePhone(yunDaDesAddressInfo.getSite_manager_phone());
        channelCompare.setSiteManagerName(yunDaDesAddressInfo.getSite_manager_name() + "(" + yunDaDesAddressInfo.getSite_manager_phone() + ")");
        JSONObject special = addrJSON.getJSONObject("SpecialArea");
        StringBuilder specialInfo = new StringBuilder();
        if (special != null) {
            special.forEach((k, v) -> {
                specialInfo.append(k).append(":").append(special.getJSONObject(k).get("remark")).append(",");
            });
        }
        channelCompare.setSpecialInfo(specialInfo.toString());
        channelCompares.add(channelCompare);

        return CommonResult.success(channelCompares);
    }

    private String buildDistanceDescription(YunDaAddressInfo yunDaDesAddressInfo) {
        return "目的网点-收件地址：" + yunDaDesAddressInfo.getSiteDist() + ",目的网点-目的分拨" + yunDaDesAddressInfo.getToDaddyDist();
    }

    private void prehandle(SendOrder sendOrder) {
//        Address sendAddress = sendOrder.getSendInfo().getAddress();
//        transferAddress(sendAddress);
//        transferAddress(sendOrder.getReceiverInfo().getAddress());
    }

    private void transferAddress(Address sendAddress) {
        sendAddress.setProvince(cityService.queryById(Integer.parseInt(sendAddress.getProvince())).getName());
        sendAddress.setCity(cityService.queryById(Integer.parseInt(sendAddress.getCity())).getName());
        sendAddress.setArea(cityService.queryById(Integer.parseInt(sendAddress.getArea())).getName());
    }

    private boolean addressCheck(Address address) {
        return StringUtils.hasText(address.getProvince()) && StringUtils.hasText(address.getCity()) && StringUtils.hasText(address.getArea());
    }


    @Override
    public CommonResult<List<City>> getRelativeCities(Integer relativeId) {
        logger.info("start query city info:[{}]", relativeId);
        List<CityModel> cityModels = cityService.queryCityByRelativeId(relativeId);

        return CommonResult.success(cityModels.stream().map(TestFacadeImpl::getCity).collect(Collectors.toList()));
    }

    private static City getCity(CityModel cityModel) {
        City city = new City();
        city.setId(cityModel.getId());
        city.setName(cityModel.getName());
        city.setRelativeId(cityModel.getRelativeId());
        return city;
    }

    @Override
    public CommonResult<City> queryCityByName(String name) {
        CityModel cityModel = cityService.queryCityByName(name);
        return CommonResult.success(getCity(cityModel));
    }

    @Override
    public CommonResult<UserContactInfo> analysisAddr(String address) {
        logger.info("query addr:[{}]", address);
        String addrUrl = "http://inms.yunda56.com:3351/ky_inms/public/index.php/joinlgs/MakeLogisticsApi/getAddressAnalysis.html";
        Map<String, String> addrQuery = new HashMap<>();
        addrQuery.put("isSend", "1");
        addrQuery.put("AddressInfo", address);
        Map<String, String> headers = new HashMap<>();
        headers.put("Cookie", "PHPSESSID=" + RunTimeContext.yundaCookie);
        logger.info("header:[{}]", headers);
        try {
            String result = HttpUtil.postFormUrlEncoded(addrUrl, headers, addrQuery);
            logger.info("analysis addr result:[{}]", result);
            JSONObject jsonObject = JSONObject.parseObject(result);

            YunDaAddrAnalysis yunDaAddrAnalysis = jsonObject.getObject("data", YunDaAddrAnalysis.class);
            if (yunDaAddrAnalysis != null) {
                UserContactInfo userContactInfo = new UserContactInfo();
                String phone = StringUtils.hasText(yunDaAddrAnalysis.getSender_Mobile()) ? yunDaAddrAnalysis.getSender_Mobile() : yunDaAddrAnalysis.getSender_Phone();
                userContactInfo.setTelNo(phone);
                userContactInfo.setSendName(yunDaAddrAnalysis.getSender_Name());
                Address addr = new Address();
                addr.setDetailAddr(yunDaAddrAnalysis.getSender_Address());
                addr.setProvince(yunDaAddrAnalysis.getSend_Province_Name());
                addr.setCity(yunDaAddrAnalysis.getSend_City_Name());
                addr.setArea(yunDaAddrAnalysis.getSend_Area_Name());
                userContactInfo.setAddress(addr);
                return CommonResult.success(userContactInfo);
            }
        } catch (Exception e) {
            logger.error("address error![{}]", address);
            logger.error("parse data failed!", e);
        }
        return CommonResult.fail("500", "请输入规范地址");
    }


}
