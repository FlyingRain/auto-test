package com.flyingrain.autotest.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.flyingrain.autotest.common.util.*;
import com.flyingrain.autotest.common.util.exception.AutoTestException;
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
import com.flyingrain.autotest.service.model.baishi.BaishiAddressInfo;
import com.flyingrain.autotest.service.model.baishi.BaishiPriceDetail;
import com.flyingrain.autotest.service.model.baishi.BaishiPriceQuery;
import com.flyingrain.autotest.service.model.baishi.SpecialArea;
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
        if ("yunda".equals(myChromeCookie.getChannelCode())) {
            for (ChromeCookieUnit chromeCookieUnit : cookieUnitList) {
                if ("PHPSESSID".equals(chromeCookieUnit.getName())) {
                    RunTimeContext.yundaCookie = chromeCookieUnit.getValue();
                    RunTimeContext.put("PHPSESSID", chromeCookieUnit.getValue());
                }
            }
        } else if ("baishi".equals(myChromeCookie.getChannelCode())) {
            StringBuilder cookie = new StringBuilder();
            for (ChromeCookieUnit chromeCookieUnit : cookieUnitList) {
                cookie.append(chromeCookieUnit.getName()).append("=").append(chromeCookieUnit.getValue()).append("; ");
            }
            RunTimeContext.globalPut("baishi", cookie.substring(0, cookie.length() - 2));
        }
        return param.getIn();
    }


    @Override
    public CommonResult<List<ChannelCompare>> compare(SendOrder sendOrder) {
        logger.info("send order:[{}]", sendOrder);
        if (sendOrder.getSendInfo() == null || !addressCheck(sendOrder.getSendInfo().getAddress())) {
            throw new AutoTestException("500", "请检查地址，确保省市区不为空");
        }
        List<ChannelCompare> channelCompares = new ArrayList<>();

        ChannelCompare yundaCompare = yundaCompare(sendOrder);
        ChannelCompare baishiCompare = baishiCompare(sendOrder);
        channelCompares.add(yundaCompare);
        channelCompares.add(baishiCompare);
        return CommonResult.success(channelCompares);
    }

    private ChannelCompare baishiCompare(SendOrder sendOrder) {
        ChannelCompare channelCompare = new ChannelCompare();
        Address address = sendOrder.getReceiverInfo().getAddress();
        String addressInfo = address.getProvince() + address.getCity() + address.getArea() + address.getCounty() + address.getDetailAddr();
        String cookie = RunTimeContext.globalGet("baishi");
        Map<String, String> headers = new HashMap<>();
        headers.put("Cookie", cookie);
        BaishiPriceQuery baishiPriceQuery = BaishiPriceQuery.fromSendOrder(sendOrder);
        String baishiPriceQueryUrl = "https://v5.800best.com/ltlv5-war/web/transOrder/measureCalcFeeForTransOrderNew";
        String priceStr = HttpUtil.post(baishiPriceQueryUrl, headers, JSONObject.toJSONString(baishiPriceQuery));
        JSONObject jsonObject = JSON.parseObject(priceStr);
        JSONArray jsonArray = jsonObject.getJSONArray("voList");
        List<BaishiPriceDetail> baishiPriceDetails = jsonArray.toJavaList(BaishiPriceDetail.class);

        String addrQueryUrl = "https://v5.800best.com/ltlv5-war/web/site/parseSiteByAddressIntegrationNew?address=江苏省南京市鼓楼区&basicServiceId=1&sendSiteId=9600130";
        String result = HttpUtil.get(addrQueryUrl, headers);
        BaishiAddressInfo baishiAddressInfo = JSONObject.parseObject(result, BaishiAddressInfo.class);

        Double total = 0.00;
        StringBuilder priceDesc = new StringBuilder();
        for (BaishiPriceDetail baishiPriceDetail : baishiPriceDetails) {
            total = baishiPriceDetail.getMoney() + total;
            priceDesc.append(baishiPriceDetail.getPriceType()).append(":").append(baishiPriceDetail.getMoney()).append(";");
        }
        channelCompare.setChannelName("百世");
        ChannelPrice channelPrice = new ChannelPrice();
        channelPrice.setTotal(total);
        channelPrice.setOtherDetail(priceDesc.toString());
        channelCompare.setSiteAddress(baishiAddressInfo.getSpecialServiceVo().getSiteName());
        channelCompare.setSiteDes(baishiAddressInfo.getSpecialServiceVo().getSpecialServiceDisplay() + "," + baishiAddressInfo.getParseSiteVo().getDispatchRange());
        channelCompare.setDistance("目的网点-收件地址：" + baishiAddressInfo.getSpecialServiceVo().getTownToAcceptAddressDistance());
        channelCompare.setSiteManagerName(baishiAddressInfo.getParseSiteVo().getPrincipal());
        channelCompare.setSitePhone(baishiAddressInfo.getParseSiteVo().getSalePhone());
        List<SpecialArea> specialArea = baishiAddressInfo.getSpecialAreaList();
        StringBuilder build = new StringBuilder();
        for (SpecialArea area : specialArea) {
            build.append(area.getStandardAddress()).append(":收费标准").append(area.getChargesStandard()).append("; ");
        }
        channelCompare.setChannelPrice(channelPrice);
        channelCompare.setSpecialInfo(build.toString());
        return channelCompare;
    }

    private ChannelCompare yundaCompare(SendOrder sendOrder) {
        ChannelCompare channelCompare = new ChannelCompare();

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
            throw new AutoTestException("500", "不支持的地址");
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
        return channelCompare;
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
