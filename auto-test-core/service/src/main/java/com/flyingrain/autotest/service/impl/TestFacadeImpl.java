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
import com.flyingrain.autotest.service.model.anneng.AnnengUtil;
import com.flyingrain.autotest.service.model.baishi.BaishiAddressInfo;
import com.flyingrain.autotest.service.model.baishi.BaishiPriceDetail;
import com.flyingrain.autotest.service.model.baishi.BaishiPriceQuery;
import com.flyingrain.autotest.service.model.baishi.SpecialArea;
import com.flyingrain.autotest.service.model.yimi.YimiAddress;
import com.flyingrain.autotest.service.model.yimi.YimiMessage;
import com.flyingrain.autotest.service.model.yimi.YimiPriceResult;
import com.flyingrain.autotest.service.model.yimi.YimiPriceUtil;
import com.flyingrain.autotest.service.model.zhongtong.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Component
@AutoTestService
public class TestFacadeImpl implements TestFacade, Resource, InitializingBean {

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
        Map<String, Object> globalCache = RunTimeContext.globalCache;
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
            if (cookieUnitList.size() > 1)
                RunTimeContext.globalPut("baishi", cookie.substring(0, cookie.length() - 2));
        } else if ("yimi".equals(myChromeCookie.getChannelCode())) {
            StringBuilder cookie = new StringBuilder();
            Map<String, String> yimiCache = (Map<String, String>) globalCache.get("yimi");
            if (CollectionUtils.isEmpty(yimiCache)) {
                yimiCache = new HashMap<>();
                globalCache.put("yimi", yimiCache);
            }
            for (ChromeCookieUnit chromeCookieUnit : cookieUnitList) {
                yimiCache.put(chromeCookieUnit.getName(), chromeCookieUnit.getValue());
                cookie.append(chromeCookieUnit.getName()).append("=").append(chromeCookieUnit.getValue()).append("; ");
            }
            if (cookieUnitList.size() > 1)
                yimiCache.put("yimiCookie", cookie.substring(0, cookie.length() - 2));
        } else if ("zhongtong".equals(myChromeCookie.getChannelCode())) {
            StringBuilder cookie = new StringBuilder();
            for (ChromeCookieUnit chromeCookieUnit : cookieUnitList) {
                cookie.append(chromeCookieUnit.getName()).append("=").append(chromeCookieUnit.getValue()).append("; ");
            }
            if (cookieUnitList.size() > 1)
                globalCache.put("zhongtong", cookie.substring(0, cookie.length() - 2));
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
        ChannelCompare yimiCompare = yimiCompare(sendOrder);
        ChannelCompare zhongtongCompare = zhongtongCompare(sendOrder);
        ChannelCompare annengCompare = annengCompare(sendOrder);
        if (yundaCompare != null)
            channelCompares.add(yundaCompare);
        if (baishiCompare != null)
            channelCompares.add(baishiCompare);
        if (yimiCompare != null) {
            channelCompares.add(yimiCompare);
        }
        if (zhongtongCompare != null) {
            channelCompares.add(zhongtongCompare);
        }
        if(annengCompare!=null){
            channelCompares.add(annengCompare);
        }
        return CommonResult.success(channelCompares);
    }

    private ChannelCompare annengCompare(SendOrder sendOrder) {
        return AnnengUtil.compare(sendOrder);
    }

    private ChannelCompare zhongtongCompare(SendOrder sendOrder) {
        try {
            ChannelCompare channelCompare = new ChannelCompare();
            ZhongtongMessage zhongtongMessage = ZhongtongUtil.zhongtongQuery(sendOrder);
            ZhongtongPriceResult zhongtongPriceResult = zhongtongMessage.getZhongtongPriceResult();
            ZhongtongAddressInfo zhongtongAddressInfo = zhongtongMessage.getZhongtongAddressInfo();
            AddressSite addressSite = zhongtongAddressInfo.getAddressSiteList().get(0);
            Site site = addressSite.getSiteList().get(0);
            channelCompare.setDistance(addressSite.getDistance());
            channelCompare.setSiteAddress(site.getSiteAddress());
            channelCompare.setSpecialInfo(site.getSiteSpecialRange());
            channelCompare.setSiteManagerName(site.getSiteQryEmployeeName());
            channelCompare.setSitePhone(site.getSiteQryEmployeePhone());
            channelCompare.setTargetSite(addressSite.getTownDeliveryType());
            channelCompare.setChannelName("中通");
            channelCompare.setSiteDes(site.getSiteName());
            ChannelPrice channelPrice = new ChannelPrice();
            channelPrice.setTotal(Double.parseDouble(zhongtongPriceResult.getLblCostTotalCount()));
            String detail = "转运费:" + zhongtongPriceResult.getTransAmount() + ";收派费:" + zhongtongPriceResult.getDispatchAmount() + ";收寄站操作费:" + zhongtongPriceResult.getOptAmount() + ";特殊服务费:" + zhongtongPriceResult.getDobSpecialServiceFee() + ";服务保障费:" + zhongtongPriceResult.getCargoServiceAmount() + ";会务费:" + zhongtongPriceResult.getMeetingAmount() + ";其他:" + zhongtongPriceResult.getDobOtherFee() + ";出港派件管理费:" + zhongtongPriceResult.getOutDipsMgrAmount();
            channelPrice.setOtherDetail(detail);
            channelCompare.setChannelPrice(channelPrice);
            return channelCompare;
        } catch (Exception e) {
            logger.error("query zhongtongfailed!", e);
        }
        return null;
    }

    private ChannelCompare yimiCompare(SendOrder sendOrder) {
        try {
            ChannelCompare channelCompare = new ChannelCompare();
            YimiMessage yimiMessage = YimiPriceUtil.queryYimi(sendOrder);
            YimiPriceResult yimiPriceResult = yimiMessage.getYimiPriceResult();
            YimiAddress yimiAddress = yimiMessage.getYimiAddress();

            ChannelPrice channelPrice = new ChannelPrice();
            channelPrice.setTotal(yimiPriceResult.getSrcDeptPayFeeAmt());
            List<List<String>> priceDetails = yimiPriceResult.getSrcDeptPayFeeDetailConfigs();
            StringBuilder builder = new StringBuilder();
            for (List<String> detail : priceDetails) {
                builder.append(detail.get(3)).append(":").append(detail.get(2)).append(";");
            }
            channelPrice.setOtherDetail(builder.toString());
            channelCompare.setChannelPrice(channelPrice);

            channelCompare.setSpecialInfo(yimiAddress.getSpeOtherDescribe() + ";" + yimiAddress.getSpeSelfDescribe());
            channelCompare.setSitePhone(yimiAddress.getServicePhone());
            channelCompare.setSiteAddress(yimiAddress.getAddress());
            channelCompare.setSiteManagerName(yimiAddress.getContactor());
            channelCompare.setChannelName("壹米");
            channelCompare.setSiteDes(yimiAddress.getDeptName());
            channelCompare.setDistance("目的网点-收件地址：" + yimiAddress.getDistance() / 100);
            return channelCompare;
        } catch (Exception e) {
            logger.error("query yimi errro!", e);
        }
        return null;
    }

    private ChannelCompare baishiCompare(SendOrder sendOrder) {
        try {
            ChannelCompare channelCompare = new ChannelCompare();
            Address address = sendOrder.getReceiverInfo().getAddress();
            String addressInfo = address.getProvince() + address.getCity() + address.getArea() + address.getCounty() + address.getDetailAddr();
            String cookie = RunTimeContext.globalGet("baishi");
            Map<String, String> headers = new HashMap<>();
            headers.put("Cookie", cookie);
            BaishiPriceQuery baishiPriceQuery = BaishiPriceQuery.fromSendOrder(sendOrder);
            String baishiPriceQueryUrl = "https://v5.800best.com/ltlv5-war/web/transOrder/measureCalcFeeForTransOrderNew";
            String priceStr = HttpUtil.postJson(baishiPriceQueryUrl, headers, JSONObject.toJSONString(baishiPriceQuery));
            logger.info("price query reuslt:[{}]", priceStr);
            JSONObject jsonObject = JSON.parseObject(priceStr);
            JSONArray jsonArray = jsonObject.getJSONArray("voList");
            List<BaishiPriceDetail> baishiPriceDetails = jsonArray.toJavaList(BaishiPriceDetail.class);

            String addrQueryUrl = "https://v5.800best.com/ltlv5-war/web/site/parseSiteByAddressIntegrationNew?address=" + addressInfo + "&basicServiceId=1&sendSiteId=9600130";
            String result = HttpUtil.get(addrQueryUrl, headers);
            JSONObject addrJsonObject = JSON.parseObject(result);
            BaishiAddressInfo baishiAddressInfo = addrJsonObject.getObject("vo", BaishiAddressInfo.class);

            Double total = 0.00;
            StringBuilder priceDesc = new StringBuilder();
            for (BaishiPriceDetail baishiPriceDetail : baishiPriceDetails) {
                if (baishiPriceDetail.getMoney() != null) {
                    total = baishiPriceDetail.getMoney() + total;
                    priceDesc.append(baishiPriceDetail.getPriceType()).append(":").append(baishiPriceDetail.getMoney()).append(";");
                }
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
        } catch (Exception e) {
            logger.error("query baishi price failed", e);
        }
        return null;
    }

    private ChannelCompare yundaCompare(SendOrder sendOrder) {
        try {
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
        } catch (Exception e) {
            logger.error("query yunda error", e);
        }
        return null;
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


    @Override
    public void afterPropertiesSet() throws Exception {
        AnnengUtil.annengLogin();
    }
}
