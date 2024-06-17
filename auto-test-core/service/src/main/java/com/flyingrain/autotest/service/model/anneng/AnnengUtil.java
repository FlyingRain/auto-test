package com.flyingrain.autotest.service.model.anneng;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.flyingrain.autotest.common.util.HttpUtil;
import com.flyingrain.autotest.common.util.RunTimeContext;
import com.flyingrain.autotest.facade.intf.model.oder.Address;
import com.flyingrain.autotest.facade.intf.model.oder.ChannelCompare;
import com.flyingrain.autotest.facade.intf.model.oder.ChannelPrice;
import com.flyingrain.autotest.facade.intf.model.oder.SendOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

public class AnnengUtil {

    private static final Logger logger = LoggerFactory.getLogger(AnnengUtil.class);

    private static final String pythonScriptPath = "D:\\workspace\\wl\\pythonProject\\compress.py";
    private static final String pythonDecompressPath = "D:\\workspace\\wl\\pythonProject\\decompress.py";
    private static final String pythonDigestPath = "D:\\workspace\\wl\\pythonProject\\digest.py";

    double[] transWeight = {142.85, 285.7};

    public static ChannelCompare compare(SendOrder sendOrder) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ChannelCompare channelCompare = new ChannelCompare();
        try {
            String matchPositionUrl = "http://zltservice.ane56.com:9004/api/match/addressMatch";
            Map<String, String> annengCache = (Map<String, String>) RunTimeContext.globalCache.get("anneng");
            Address receiveAddress = sendOrder.getReceiverInfo().getAddress();
            String receiveAddr = receiveAddress.getProvince() + receiveAddress.getCity() + receiveAddress.getArea() + receiveAddress.getDetailAddr();
            AnnengAddrMatchRequest annengAddrMatchRequest = new AnnengAddrMatchRequest();
            annengAddrMatchRequest.setAddressInfo(receiveAddr);
            String result = HttpUtil.postJson(matchPositionUrl, new HashMap<>(), JSON.toJSONString(annengAddrMatchRequest));
            String destSiteNo = JSON.parseObject(result).getJSONObject("data").getString("siteId");
            String weightUrl = "https://zltservice.ane56.com/ewbservice/querycalcweightandgoodsprop";
            long time = System.currentTimeMillis();
            AnnengWeightRequest annengWeightRequest = new AnnengWeightRequest();
            annengWeightRequest.setEwbNo("");
            annengWeightRequest.setGoodsName(sendOrder.getGoodsInfo().getGoodName());
            annengWeightRequest.setWeight(sendOrder.getGoodsInfo().getWeight());
            annengWeightRequest.setVol(sendOrder.getGoodsInfo().getVolume());
            annengWeightRequest.setSendTime(simpleDateFormat.format(new Date()));
            annengWeightRequest.setSendSiteId(Integer.parseInt(annengCache.get("loginSiteId")));
            annengWeightRequest.setDispatchSiteId(Integer.parseInt(annengCache.get("deliverCenterId")));
            annengWeightRequest.setProductType(24);
            String argStr = JSONObject.toJSONString(annengWeightRequest);
            String md5Origin = argStr+time+"360fin"+"xywhgxwlg9whgl523";
            String md5 = digestStr(md5Origin.replace("\"","\\\""));
            Map<String,String> weightParams = new HashMap<>();
            weightParams.put("appId","360");
            weightParams.put("timestamp",String.valueOf(time));
            weightParams.put("appkey","360fin");
            weightParams.put("token",annengCache.get("token"));
            weightParams.put("arg",argStr);
            weightParams.put("md5",md5);
            String weightResult = HttpUtil.postJson(weightUrl,new HashMap<>(),JSON.toJSONString(weightParams));
            Double transWeight = JSON.parseObject(weightResult).getJSONObject("Result").getDouble("transCalcWeight");

            double weight = sendOrder.getGoodsInfo().getVolume() * 200;
            weight = weight > sendOrder.getGoodsInfo().getWeight() ? weight : sendOrder.getGoodsInfo().getWeight();
            AnnengPrice annengPrice = new AnnengPrice();
            annengPrice.setDispatchSiteId(Integer.parseInt(destSiteNo));
            annengPrice.setSendSiteId(Integer.parseInt(annengCache.get("loginSiteId")));
            annengPrice.setPickGoodsModeId(111);
            annengPrice.setProductType(24);
            annengPrice.setGoodsCategory(0);
            annengPrice.setPiece(sendOrder.getGoodsInfo().getCount());
            annengPrice.setVol(sendOrder.getGoodsInfo().getVolume());
            annengPrice.setCalcWeight(weight);
            annengPrice.setWeight(sendOrder.getGoodsInfo().getWeight());
            annengPrice.setServiceid(0);
            annengPrice.setJzpickgoodsmode(0);
            annengPrice.setInstallcharge(0);
            annengPrice.setEwbType(1);
            annengPrice.setJzservicetype(0);
            annengPrice.setCodCharge(0.0);
            annengPrice.setInsuredAmount(sendOrder.getAddedValue().getInsureAmount() == null ? 0.0 : sendOrder.getAddedValue().getInsureAmount());
            annengPrice.setFreightCharge(0.0);
            annengPrice.setPayModeId(102);
            annengPrice.setTotalAmount(0.0);
            annengPrice.setMaxEdgeLength(0.0);
            annengPrice.setGoodsWide(0.0);
            annengPrice.setSingleWeight(0.0);
            annengPrice.setIsFold(10);
            annengPrice.setStairsTypeId(0);
            annengPrice.setCargoTypeId(0);
            annengPrice.setSpecialPiece(0);
            annengPrice.setReturnAmountTime("T+3");
            annengPrice.setVolWeight(weight);
            annengPrice.setEwbNo(sendOrder.getOrderNo());
            annengPrice.setAllAmount(0.0);
            annengPrice.setFee1DiscountFlag(1);
            annengPrice.setFeeSite12DiscountFlag(0);
            annengPrice.setDecentralizationPolicy(1);
            annengPrice.setCountMode(0);
            annengPrice.setTransCalcWeight(transWeight);
            annengPrice.setGoodsProperty(0);
            annengPrice.setIsHighPrice(0);
            annengPrice.setIsNoPress(0);
            annengPrice.setIsDirectCar(0);
            annengPrice.setTownName(sendOrder.getReceiverInfo().getAddress().getCounty());
            annengPrice.setOutCatType(0);
            annengPrice.setDeliverCenterCode(annengCache.get("deliverCenterCode"));
            annengPrice.setDeliverCenterId(Integer.parseInt(annengCache.get("deliverCenterId")));
            annengPrice.setIsPutStation(0);
            annengPrice.setCustomerId(0);
            annengPrice.setDispatchInRange(0);
            annengPrice.setGoodsName(sendOrder.getGoodsInfo().getGoodName());

            String priceStr = JSON.toJSONString(annengPrice);
            String calPriceStir = "<CaclChargeByConditon xmlns=\"http://www.hspoxi.com/\"><para>" + priceStr + "</para></CaclChargeByConditon>";
            calPriceStir = calPriceStir.replace("\"", "\\\"");
            String compressedPrice = compressData(calPriceStir);
            String calPrice = "<s:Envelope xmlns:s=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:a=\"http://www.w3.org/2005/08/addressing\"><s:Header><a:Action s:mustUnderstand=\"1\">http://www.hspoxi.com/IANE_FollowManagerService/CaclChargeByConditon</a:Action><Compression xmlns=\"http://www.hspoxi.com/compression/\">algorithm = \"GZip\"</Compression><a:MessageID>urn:uuid:" + UUID.randomUUID() + "</a:MessageID><a:ReplyTo><a:Address>http://www.w3.org/2005/08/addressing/anonymous</a:Address></a:ReplyTo><a:To s:mustUnderstand=\"1\">http://zltservice.ane56.com:9001/ANE.SerApplication.Server.WCFService/ANE_FollowManagerSer/ANE_FollowManagerService.svc</a:To></s:Header><s:Body><CompressedBody xmlns=\"http://www.hspoxi.com/compression/\">" + compressedPrice + "</CompressedBody></s:Body></s:Envelope>";
            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/soap+xml; charset=utf-8");
            String priceUrl = "http://zltservice.ane56.com:9001/ANE.SerApplication.Server.WCFService/ANE_FollowManagerSer/ANE_FollowManagerService.svc";
            String priceResult = HttpUtil.commonPost(priceUrl, headers, calPrice);
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
            Document document = builder.parse(new ByteArrayInputStream(priceResult.getBytes()));
            String priceResultStr = document.getDocumentElement().getElementsByTagName("CompressedBody").item(0).getFirstChild().getNodeValue();
            String plainData = decompressData(priceResultStr);
            Document priceDocument = builder.parse(new ByteArrayInputStream(plainData.getBytes()));
            String price = priceDocument.getElementsByTagName("a:Result").item(0).getFirstChild().getNodeValue();
            AnnengPriceResult annengPriceResult = JSONObject.parseObject(price, AnnengPriceResult.class);

            String siteInfoUrl = "https://www.ane56.com/gw/api/selfNetWork/queryNetWorkBySiteId";
            Map<String, String> params = new HashMap<>();
            params.put("siteId", destSiteNo);
            String siteInfoStr = HttpUtil.postFormUrlEncoded(siteInfoUrl, new HashMap<>(), params);
            SiteInfo siteInfo = JSON.parseObject(siteInfoStr).getJSONObject("data").toJavaObject(SiteInfo.class);
            channelCompare = buildResult(annengPriceResult, siteInfo);
            return channelCompare;
        } catch (Exception e) {
            logger.error("anneng price query failed!", e);
        }
        return null;
    }

    private static ChannelCompare buildResult(AnnengPriceResult annengPriceResult, SiteInfo siteInfo) {
        ChannelCompare channelCompare = new ChannelCompare();
        channelCompare.setChannelName("安能");
        channelCompare.setChannelCode("anneng");
        ChannelPrice channelPrice = new ChannelPrice();
        channelPrice.setTotal(annengPriceResult.getResultInfo().getTotalFee());
        StringBuilder priceDetail = new StringBuilder();
        if (!CollectionUtils.isEmpty(annengPriceResult.getResultInfo().getAmountInfos())) {
            annengPriceResult.getResultInfo().getAmountInfos().forEach(amountInfo -> {
                priceDetail.append(amountInfo.getName()).append(": ").append(amountInfo.getAmount()).append(";");
            });
        }
        channelPrice.setOtherDetail(priceDetail.toString());
        channelCompare.setChannelPrice(channelPrice);
        channelCompare.setSpecialInfo(siteInfo.getSpecialRange());
        channelCompare.setSiteAddress(siteInfo.getAddress());
        channelCompare.setSitePhone(siteInfo.getLinkPhone());
        channelCompare.setSiteManagerName(siteInfo.getLinkMan());
        channelCompare.setSiteDes(siteInfo.getSiteName());
        channelCompare.setTargetSite(siteInfo.getRanges());
        return channelCompare;
    }


    public static void annengLogin() throws ParserConfigurationException, IOException, SAXException {


        String userName = "57270013500004";
        String password = "dhl12345678.";
        byte[] encodedByte = Base64.getEncoder().encode(password.getBytes(StandardCharsets.UTF_8));
        String encodedPass = new String(encodedByte, StandardCharsets.UTF_8);
        String loginOriginStr = "<Login xmlns=\\\"http://www.hspoxi.com/\\\"><user xmlns:a=\\\"http://schemas.datacontract.org/2004/07/ANE.SerApplication.Server.DataContracts\\\" xmlns:i=\\\"http://www.w3.org/2001/XMLSchema-instance\\\"><a:BalanceMode i:nil=\\\"true\\\"/><a:CIsLogoin>否</a:CIsLogoin><a:ClientMustCloseSeconds>7200</a:ClientMustCloseSeconds><a:CompanyId i:nil=\\\"true\\\"/><a:CompanyName i:nil=\\\"true\\\"/><a:Confirmpw i:nil=\\\"true\\\"/><a:Cpu>Intel(R) Core(TM) i7-6700K CPU @ 4.00GHz</a:Cpu><a:EndpointCount>0</a:EndpointCount><a:Funcs/><a:GatewayAppkey>aneTestCust</a:GatewayAppkey><a:GatewaySecret>bjHbdMow8UI2398hwb23b2hd</a:GatewaySecret><a:HostName>WIN-20240509REY</a:HostName><a:IeVersion>11</a:IeVersion><a:IsLogoin>false</a:IsLogoin><a:IsMulitEndpoint>false</a:IsMulitEndpoint><a:LuBan_ProblemTypeList xmlns:b=\\\"http://schemas.datacontract.org/2004/07/ANE.SerApplication.Server.DataContracts.LuBan_ProblemTypeManage\\\"/><a:LubanAccount i:nil=\\\"true\\\"/><a:LubanAccountPw i:nil=\\\"true\\\"/><a:LubanServerAddress i:nil=\\\"true\\\"/><a:LubanServerCode i:nil=\\\"true\\\"/><a:Memory>16332MB</a:Memory><a:Menus/><a:Newpw i:nil=\\\"true\\\"/><a:OSVersionMajor>10</a:OSVersionMajor><a:OsName/><a:PassWordUpdateTime i:nil=\\\"true\\\"/><a:RechargeFee>0</a:RechargeFee><a:Resolution>2560*1440*1*1</a:Resolution><a:RoleTemplet i:nil=\\\"true\\\"/><a:RoleType i:nil=\\\"true\\\"/><a:Roles/><a:SMSMaxLen>0</a:SMSMaxLen><a:SiteCode i:nil=\\\"true\\\"/><a:SiteInfo i:nil=\\\"true\\\" xmlns:b=\\\"http://schemas.datacontract.org/2004/07/ANE.SerApplication.Server.DataContracts.LuBan_CellNetManage\\\"/><a:Status i:nil=\\\"true\\\"/><a:SysInterfaceList xmlns:b=\\\"http://schemas.datacontract.org/2004/07/ANE.SerApplication.Server.DataContracts.SysInterfaceManage\\\"/><a:UserHeadPortrait i:nil=\\\"true\\\" xmlns:b=\\\"http://schemas.datacontract.org/2004/07/ANE.SerApplication.Server.DataContracts.UserHeadPortraitManage\\\"/><a:UserId>0</a:UserId><a:UserName>" + userName + "</a:UserName><a:UserPassWord>" + encodedPass + "</a:UserPassWord><a:UserTemplateMiniServer>false</a:UserTemplateMiniServer><a:Version>4.254</a:Version><a:WebChatRechargeAmount>0</a:WebChatRechargeAmount><a:bQueryPhone>false</a:bQueryPhone><a:balance>0</a:balance><a:isOffLine>false</a:isOffLine><a:isWriteDebug>false</a:isWriteDebug><a:lockBalance>0</a:lockBalance><a:loginToken i:nil=\\\"true\\\"/><a:lubanEmployeeId i:nil=\\\"true\\\"/><a:lubanFalseReason i:nil=\\\"true\\\"/><a:lubanUserId i:nil=\\\"true\\\"/><a:netVersion>4.0.30319</a:netVersion><a:tgt i:nil=\\\"true\\\"/><a:tscToken i:nil=\\\"true\\\"/><a:userType i:nil=\\\"true\\\"/></user></Login>";
        String compressedData = compressData(loginOriginStr);
        String loginMessage = "<s:Envelope xmlns:s=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:a=\"http://www.w3.org/2005/08/addressing\"><s:Header><a:Action s:mustUnderstand=\"1\">http://www.hspoxi.com/IUserManageService/Login</a:Action><Compression xmlns=\"http://www.hspoxi.com/compression/\">algorithm = \"GZip\"</Compression><a:MessageID>urn:uuid:" + UUID.randomUUID() + "</a:MessageID><a:ReplyTo><a:Address>http://www.w3.org/2005/08/addressing/anonymous</a:Address></a:ReplyTo><a:To s:mustUnderstand=\"1\">http://zltservice.ane56.com:9001/ANE.SerApplication.Server.WCFService/UserManageSer/UserManageService.svc</a:To></s:Header><s:Body><CompressedBody xmlns=\"http://www.hspoxi.com/compression/\">" + compressedData + "</CompressedBody></s:Body></s:Envelope>";
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/soap+xml; charset=utf-8");
        String loginUrl = "http://zltservice.ane56.com:9001/ANE.SerApplication.Server.WCFService/UserManageSer/UserManageService.svc";
        String loginResultStr = HttpUtil.commonPost(loginUrl, headers, loginMessage);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        Document document = builder.parse(new ByteArrayInputStream(loginResultStr.getBytes()));
        String result = document.getDocumentElement().getElementsByTagName("CompressedBody").item(0).getFirstChild().getNodeValue();
        String plainData = decompressData(result);
        Document resultDocument = builder.parse(new ByteArrayInputStream(plainData.getBytes()));
        String loginSiteId = resultDocument.getElementsByTagName("b:SiteId").item(0).getFirstChild().getNodeValue();
        String token = resultDocument.getElementsByTagName("a:tscToken").item(0).getFirstChild().getNodeValue();

        Map<String, Object> globalCache = RunTimeContext.globalCache;
        Map<String, String> annegCache = (Map<String, String>) globalCache.get("anneng");
        if (CollectionUtils.isEmpty(annegCache)) {
            annegCache = new HashMap<>();
            globalCache.put("anneng", annegCache);
        }
        annegCache.put("loginSiteId", loginSiteId);
        annegCache.put("token", token);
        annegCache.put("deliverCenterId", "3855");
        annegCache.put("deliverCenterCode", "5732000");
    }


    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        String loginResponseStr = "<s:Envelope xmlns:s=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:a=\"http://www.w3.org/2005/08/addressing\">\n" +
                "    <s:Header>\n" +
                "        <a:Action s:mustUnderstand=\"1\">http://www.hspoxi.com/IUserManageService/LoginResponse</a:Action>\n" +
                "        <Compression xmlns=\"http://www.hspoxi.com/compression/\">algorithm = \"GZip\"</Compression>\n" +
                "        <a:RelatesTo>urn:uuid:15d59f71-c3c1-473d-bf3f-80b5fb281ba1</a:RelatesTo>\n" +
                "    </s:Header>\n" +
                "    <s:Body>\n" +
                "        <CompressedBody xmlns=\"http://www.hspoxi.com/compression/\">7V3rd9PGtv9Xzupa3A/33tiSLMlWbuMu27FDQuwEP0m+sPQY24plSUhyHLPuB2hLeRQKveVZKC20vbTnHAI9l/JKgX8mspP/4s6MZMcmTuIkSksCbViW9ux57fnNnj17Hvp4UivJahqYuqaa4G8LVUU1Rz4qW5Y+7PfX63VfGYYsyD5Rq/o/Cn/c5q4plsM7zHe4TbEMqrzpk3iLFzXVMnjR8mlGyU8RBO0ngv5IKu7LACOi64os8pasqeh1Hhi+URgl5kYxP3JTlnvKUQ+00yL9x5KTGZzZkKyaFq+KABaNHx43MzVRBKYZtowa+NjfTYHBSfjLl0C4dWvJfnWtee6KfeF7H+JqB0CeNDhRA6Y1rmblKggTMLMh/JcliGH8h/h7mdZiTdUsTKEIih4i2CGCy5L0MEUPk7SPCHIkEQj8BxHqTaQdB6YS02qqZYZxqPuM00bCRk9RXkFVTWoS+Js8rMrKyEeonh/5ceRxE7aNJqvh5s1HOIUOAYUqMlCtZM20YopmggyA7SOZ4RBLO4XZIBwXqqrzamNcCjNBKgjlEWCc8rXJazwpHtaj+eK6/eyufeWJfeZJa+ns6tmLyy+v2hdfdkXCfDiaWpSNql7vUxu9tp4YVyUd1sfCsoFCRkn20iBToqaKJmYf4y1Q5xsQbRXQCPMqCLA4Si99jRFW2gBWuFwLlqUKFS1EwUSIkoXCGJA5iVC6orqcMOphzbRQddYXdhzkgWFCiDvtufaKwvQ+/O3WWoPuWvONm8maIlvtyoaLvGK6TL0BkHeyFuXV49OGJiigmm3oYFI2231V8Lyv+tZll+RV2JecSk3WBF6NiCJqnHWE6foayUk6IkkG7IrrhdPFE4Pox7QkL27InwRVzWj0o6s1BxwpUO+Hu6mM20xJfk4z+oSb/Vt7mjfNgmZIOR0KFHQpAXqIZJASYMjhAOELMUHUan24cUcXy7xRAgkAwq6GWCM4ikBTaqgl1uef1hSQBVVdAdYGgbBl+oeY7Ye4aslWY9A+PwpM0ZB1VJzw6r9Oty4/bF39pXnuWfO7z1ZvXUHs3RxO70U1XV8I1GMRkzkuOT1BCpMkSQcCGOBSu93cUFRSrEDcTBfvta58YX99EwusHdYrkTDFsYACgjBEgKA0RNMsM8RTRWGIhQpZYtmAUGSEdvx2nC65hTOyBSJSVVY7TIgKOTKaYaW0MEmE6BAurktAQRZvWP0q7O+Vtr+rFTLJTJJfmARqmMU4WXtHgbAQCPy9bdKhuhzjalHb684eA4qSApbb0cMfC8NuRww3f7/V/O371p3T7ijw/FNnIID63xkLVq+dbd5abD653bz+qHX+1+bvp+3bDz/2r6WAEjMAj6tkX/rKvnQDh7ZJMDgKFE0tZbVRqNYMWcAdImzfPI+yOfdF88tflp8/tN98hqL1Ze1KIiEbUH0DC1Vok4FrgwgwIVcSCVlFA3MMDqHACLduP1m58vPKk/v2hXtrZenLupYExDnF0lyI7OJF2O+8bDG49vKhaBBdWGQkG2RxeJvgBsLUA0SICLXD3Nzaffxt2Ao9o/fy8wvN35/Zi+dXPnu1cvpb+9zt5de37ZdXV7957fTI5p3zUA3YZ/5pX36Oc+ge+tdetX7ZwLHBKSlBcEHCid2hdThQ+UkmEFoLd2oAdb8AjITCl9rDZA8NckzzBhQ/7i1SmAtSOIseImIytHkZtRQuCE1jnm5aFw8W5Vs8Tir9Om0X1eWAvCGCpEiiHbgWeRoYVdlEI5IZpgL/Df//d4rGPxzjvAUJ/Mu4ZIZm8W87qe4E2mnKagPaFYdnC8dmJwtHO5wO2WVC/V+GljNWdWSbp4fa5rR4q2Z28TjvbijiRBqd7lTOpaBwR1tyXIjCEG1rT/+aLnNVKUqwbRi104dPDXMc9aMiL+6xldOdU5fe6ya3FfqmfQiOiYHxfH/6EbDOYhHwYMhh0Toi62TXVpiopias6knFMp3G8UFTl2HxhG3eMWb8JWAVZQV3hXUJdCc6juqrAsvMGYq/JwR3XGhAN6+fXV56uvz8y5VXr3qSa/fsFABSpqGKa52vQ4Ghcid3XT/SscqPS1pdbRfwbZa3Yrm2N4xIUgGaYd+O0rbNu6jIEMG1UTVLLjaO1wxlvaBhpJqh9gvzb9TOf0rrU0Rgp60P/1Vh40O4Kg1TNnknzm5BYN95bH93qnnrJVL9D35s3r3iDQ7qyNq1BkcATY9SgQBJRgkqPiAI1gt4XyKConeKCEOrWcB/ogaMRkIzgMib1jRvlT3QC6v3P19ZvGefe7zy+nXzxtPVG088QAVMF5d4cFCU9HqZlVW6XILj4sHXDQwzABIqDdFcw8AwFQpwnN+C1a7yC0NwFgqMoTrfEGRF8fO67LcWphCt4JJMoADRwqSMVjOQYRNtuIEpbVvICbujMhmkfGTQxwV9AXKYDHEEtSfF6cl6HWab3/+88uj+yuJ9+9K15nc/N196oMbWN9J69G3Cc4BUFBPaApg9MAhRwxwyyFB76zWz7C+Z/KTm2GO71U0rTx7ACZK9+O3yq0vNr35ZPXW6+dXP9uUfPVBPELDHYUkH105GuTBVz8+fmJ2qH3u/hixyEBO20tB0oPaqKoLAuqEkm0NV3hLLGCPukxM9iV681EPbymsLJXP98dh4xr74YvXMJc9g1/ZkD4q6jR3a7xUCqV0j0MWD7pfkeRnNq6KNyA5s6q3hN2BGg2DPGeZad04jX9zFl8j/9gGHfykO2a1Hxn62+9oIuUvtt9G8/m1NRXpjwEM4b2NOx7A0EQjQUlGql0vvGTAGs+W3VFCm3J7iRRVerCiyaUUbbY/jXiiqwTMcRGG1Xn3d+vTF6tLX9pVLyDT/4d7q3y9+0FZ/FSiDu9dWux0vN1NYGw1vH5TXn4wTbrc48U5tbYaXvtrlA1j+VLAwm1ji/g1bdf1gxJLDISJE+CEHBo8LLhNDyVnFSQPTckA1CkSFN/Da07aMaKxf7J8+b736tnnzq9bSF85z67cl++6XXprSg0NnW+seA9egN9Y+hRbFbDVebegaB3XBJTqA6XIxeqF99sDbiNLF/lKzU8rBABQMBjVLrWuivC7SO6p4dgyI4AB+SAiHRr0LCWjVF6iWf7zKl6A2iajAp6ulbYGgT1l6nZKfvbIf/q/9w6fLLy+2lp60fjht337dOn/WWVvbPTQ28D2vdzeHm5evLL++vVYevLDbKdU7oBh23PShHa+a1yCJx1vSsDcabR7wtPXdjXLfXFp+dcdjl/QeDiRbWnEbiG3f4mfH6+7TNUGRxaRZ8o8BC/5sb7qzFXrQnqqvLzSfnmuefnQgcNNXXPsWNTtem+8RQwQfWtAMGewdeFZvfb689PTgQegt2e1bJA3iD9wCSRl+HnTe0oCX0kCEJuNeYGr15pmVR0vLb76zH948YJjaTIr7Fl0DLEMojS5QwachA86yY3hTmbsPNOOTdrsFhKTZAdPefKa+8uxR6+pvXiIPOZ9KMDLpLF4PBsKTC+K8oFb5Ij9XUYqSyVPOVtxBIPl2Fd4dbIVL5TpvCgpuEJe0BrBwJMBxoRhBxSLxGJ0I0hzBxOORaLTN7YoL7bbeaj6GlJolVHzzQCzLKu+D7e0vACFW5q2MyLex4TPnRXcrkHASz4FltagpgtCA03hVQ2sksuS6+3czc7dfLy6/uWe/ugan7fa5L1bv/e5M5D2DWTQWHY2RBE0wMYIOUolQKJBgR6Ea4wiWiJHrNjZuDLwIGQxSESJIsFyEjlFEJE4EIizDsBRDk1Ro0C2S7Q7qbRscRCRv5fHeBpJ5SeoRYVEzQFX3GL/LbxabV1+svLmCn+95OXvY7yjeVP7vDna3eWyA2MoBMpDv68hM1HP3l/3mHwiHi9/95e6vrUuyf5t/qw1PAzb/bGav2v/Cr83zX74rENi8MPsXBZv4I/ZssQ1ZzqM1Y/3+3c1NeOf4pn36TuvaLXSG4Nobj62tvZtO7tsFEpIYYCLYsLp0RFGq+g3U1IqAzpUlDCCXyhY6oRttpNunNXYxIWSYbWaxBahOfWv/9KuzC7z1x3XYtz2D02R0cDQ1xPHohB4bNWeIyEQtOWZyM7pViFnZtFGJTh85DEDwaDRLKdKMOTKokbNZ1favwhrEri7JXSda0JtzJhNvNoL/sto0ug3DV7aqiqcDV2eLJBoZbr9uPvzR/uPynz5k7dudH1Rgs+m/f7eeJCo0HCSIwNrYlIqHXDP/k7opKdvQGuiWIcKDfUEenAgK23+cQrsG3pWu7Q0USHrHy2uSjBcZeaPhWBue9vDmDy+alxadzTGOTl356pl9+Xrz2mNItx/esM88f6ctka0d2/3kd0AwteMlE+dgLLQ1jG1bMP03/Hjvjt4jvOzbwYSkt7JcN9Yg7nUD/rhhaPhGKd/CNi2FfrPanx54fDvCuuIN1v6bRjtwE5hNbYpNYaAbUARwAltSPd/is/qPm8tLz+xTf3Q8Co7LtfXwtX3l0jutELYeQNbL7WAMH+wgSNrgBI5Yg9NVOHZg5wjaz95+rsqmxVfw2BIRVM2o8koGSg5tRN6lvRsghwOhEMftPu/NbeG3Yo+vj79jCFeKg4O4L/tBG9QoapBjqgNtYBZ5RaxjxwmvSiVNk0zd0HQPTBv3zM3SN63FG6tnL62evWz/z8WVJw9a53+1f7vbPPXAA2zAbIqyOjg4Fhr1cmmhrpQ4+KswVMAzZTe4WA+EEqToQTaw1YEA9YyPr/I6xh78NT+ZHyF9tI9k/o2v6v9VAY0RkmJCfIABRUokGE6gaIEleTrA8RIIEUKRw4y6UivJ6kgkCZOK1CwNJofuX/Rk0/2tl63Tv6+e+tbx0Kycvtr87P/+nDl9mGMDbECgWIIv8gEWMBIQYPW5EEuKDMUNfDXNX22WeQUqj478rLsvxjFF8L0h+EmCYmzonV9no9Y2xjqo21p3vnQWyeFkv7n4O7ThvJrFeeAMOih4GGSijlYAerTMfMDPmyayaWBLy6pesywZ6h1zxDDnA9vTOnOmCOdHI1v1UsyLjFwLmjwjuiZjggilMnIozhwKMYciIfTARQ9FR111xltFaCuNTGTwu6KV3Ev4RigfgUm8rqsQPiNoBnooEDlEJZy/uPsC04vED0WoQ3H2UCh0KBo8FA8eikQPRRDTkRmo2FyuaAKR4yH0wBEOHUoEu72dgpqyNBKlY0wwNBoYIgIMO0QHY9RQiAsEhyIMGY/F2FgkzjpFN6VKu6hIkVNEW6R1tNlxZK8UcmR6/EPX8vAE3GDL/ltbO3M1qQQyQJVgdvhe1GlNimkSHKO9uG/CcWrbi3ebN54uL/3YvPrUPvd4eemmZ+f9YR66JsFePrgRWSrXtRJHBdkKFSgTHFV5rwZpMrhj7+moVlcnNV5Cd6b6Bd6URc8dKrA5Hbea/f3L1r1Tjjt+H7hXt+5yGwvvYEwomEEWevreUQgNPGzkifiybGzl4QkX2giAfBpj7RcvbzZBmW4/w82tSmcJqXuh/sOI5yHAdnzkypkz7ApJG6z+7EGD4ysmUDl5WM7BtVWQC5Tm0Da/shAMsO/ZvJMdTPds404lfMG5DkSZVyJuO+wGKz232OC7SewLP0BjaOXs35uXPbpY+X269mgXy0g7Pi6Ob4qIlYFYmdbqcNgQ0WNe1gM6fs3pChzd0ZbzUa+NIndj/6tvWg8etW4vtr793MEQnFjZV87tm82TW9tI2xbxwTCdCGLruZw+7zO1cs258B2WY87U1E9kMFKzikOh/3SZZH0IeVIQDwr3t+mIWAmGCBzyCa/rI7LuUzSRV9qeCuxRIQjC8a+gNb8RgeEEMQCKLMmRQOCKQTooSTQIBUSOK1I8jTmRD4S3RlBuu9WRzmBq/3Qdgnt8GoL8g8fAW5Tt+M4cPCzCMRLfSFmtKZase/KRic42S2+spuMwvW15ARqWsiCW675SgzrwC470IPttN71CXjdAz43t86S//eqVD6nvfC1EeVuIzedwe+2w+qCP2pbYQIiUTbH7TIKsgI4o8NuQ2TAtUMVYQO8Z57WGLQWouNTSNjXVJvsvPMh9c+zBWULz7tPm3c/b+8suLP/xQ/POJfvCPc/MO7SJZFubMfbJjMCrvUE7HiTdT2P6p2qO8nFfE7Iq9ZKmNdNKA13Z3obmDVZarj+2F+8jiDx6AS2n1RuLq/dvotteDs6cYGdyPRATAzI4iF9jdypS8OazCjvTkOsz35aCbJ5/sXr28r5Sk7gK975AtcCF79b0Bwi3O96y7X7LzHA+mo0qLwJ0WN8LXelcwYfvxFp+vmRf+OUAacnN5HZAMLXjkdmVjaNzFK3k1ScSb/xsv7nhap8DhKF1cjoY+Nn5PY+gqjuLAuiT0VoD7Bo8ziet7a9v2s9+dnSQNw6QbYEH8evy+3GGiGJ37PXvv3aYMLSqB/f2OI2PFhL3ZglRdJc5B0PEiZJSrrPc5JFsiBvUIXYwpn0UO4AHfotLVGCAb07f3gUq/dZ68Le23Qudzvxz+Y8b9uVne3R5ygdfVMc7OsiRIHScEA2NvqosGpqpFa3OKUM8m+H8jD/i55gIx5JsdCgYCQSH6EiCHYrGAuzQKBuHAbHQaCQSh3HQ5+UTCzRxPFFTlOMLIfb4Akv7wMKuBxecrn3pbOule0zxA0481BODfV1uAy/6iao5JPCmc3gLP4i8UdJQmzgGRqz9Gl+Aaav8rs+qujsOzv9qf3PavnKp9eDxBzR4iIYdXbrUT+k/RAcRVu/fWTn/r9Uzl1qvFt+HZvLzPeRJ2YT2BT+cg0bYYcBL05oBhSb3FvJvC1VFNYeFkY/cUdkUy6DKmz60mVLUkJhFy6cZJT+FpjRE0B9JxX0ZYMA6K7LzqVmfc4+VD20iiLlRTN/b2TpXzaDiO0VCcwiGIikCldsluEG4fZggFSQIMsAQ8D+6zeQ0nfM8zZtmQTOksECTFM+JVBAa36JYJFguyPFSSCoSgBQ4lmtH7kRwE8iiCQhvgaSsyk4d2kjYMBzGzDub/d9uFH7YvSUxjT7IbpRApKrVVCuM69c/CMYRjiI9NV3WVLCWdzcR8fAKr4rASan9AumyOVUsTsrdMddIOLxgoBvFgFArdbN0USGXoomVaHcO3QQcXpLVrFYBahgEmJAg8CQhcYAOhYIcSQogKNAsQSNJB5zYHXYUuSbwatyd5qHbP+lQgHX43gppMydQOdOAN/tJGHO4WOFCBEeEOkmtIQiqhQ2byCqt66OQaIpOgWePKUeSY/mZowVlms/pk/m5RJrPLYxmqmU5TaX0LKUcyeTzbCabmOJzGjNZzTOZucRsIT5xpFBJTaQqJFuAYaCaYrJkOioSSi2rRitpcjY+MzeREeLKCYFSpvJjMFzVoxJB5rLZxAR/TNIL2XGGJ/VsJjs7wVdNEsZPwfD40WPSdD5O0tlcWk0Sii5RylyyWq8XlBzJj00cy+OyLlhSXpeFw0fJFLVgZBNpE4blBDVHzKpRLXVYN6Rj0Zwwpidh/smjhM7O5MsZITE7LhyW+HyOoQoVKc/nOD1zrDyVjif0bDx1JFlINvKqkhNys0RBQfVTSCGXMiYL+WlRJrMpdQLypyYEZZYtKOUjGUUfdctPwPIaEsGN4vD8LDFDSLRUzR/LVxfSyTnFcNM7kc+mYJ9OBSB/AlSYHKxvKh2P1zMFJcAX0nlhzILpcXq2Sp4E+WTdLf9JKM+KODZhpAplOU/mUdtMJHMMbJsUjJ+gs8f0vCu/qaOEcjJTIMckKpXopHdMn5V65Jk3eQK3zzSOX9ATbnilEGfMGWohkyqkDjvyVmB7pCa62jc9QxGMROozmbmo0iPPbCKVT+SxPIWx/DjGViV3MptPq7h82YmpfDyBygfbLI3kl4L4oCE+DBBn4ih+ZjRSm8lPsDko+3x8IpkcS43NQFnn5iQNVIiF9Fw5euykMgmyE1Q6l49LhDUJsZYQRydy6Vx0bnYuV5+hcmRqNFGZOZmuzBRmy1OjierUWJxInRwPpLIT1ZlsPJCqj4ygDtXpELBzoK+ToIPrrpPF+QYLYuoEoJc0MGsKVGj+SdT9173pmmqC8P8D</CompressedBody>\n" +
                "    </s:Body>\n" +
                "</s:Envelope>";

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        Document document = builder.parse(new ByteArrayInputStream(loginResponseStr.getBytes()));
        String result = document.getDocumentElement().getElementsByTagName("CompressedBody").item(0).getFirstChild().getNodeValue();
        String plainData = decompressData(result);
        Document resultDocument = builder.parse(new ByteArrayInputStream(plainData.getBytes()));
        String loginSiteId = resultDocument.getElementsByTagName("b:SiteId").item(0).getFirstChild().getNodeValue();
        String token = resultDocument.getElementsByTagName("a:tscToken").item(0).getFirstChild().getNodeValue();
    }

    private static String compressData(String loginOriginStr) {
        ProcessBuilder processBuilder = new ProcessBuilder("python", pythonScriptPath, loginOriginStr);
        try {
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.length() > 1) {
                    return line;
                }
            }

            int exitCode = process.waitFor();
            if (exitCode != 0) {
                System.out.println("Python script exited with error code: " + exitCode);
            }

            reader.close();
        } catch (IOException | InterruptedException e) {
            logger.error("data:[{}]", loginOriginStr);
            logger.error("compress anneng data failed!", e);
        }
        return null;
    }

    private static String decompressData(String data) {
        ProcessBuilder processBuilder = new ProcessBuilder("python", pythonDecompressPath, data);
        try {
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.length() > 1) {
                    return line;
                }
            }

            int exitCode = process.waitFor();
            if (exitCode != 0) {
                System.out.println("Python script exited with error code: " + exitCode);
            }

            reader.close();
        } catch (Exception e) {
            logger.error("data:[{}]", data);
            logger.error("decompress anneng data failed!", e);
        }
        return null;
    }

    private static String digestStr(String data){
        ProcessBuilder processBuilder = new ProcessBuilder("python", pythonDigestPath, data);
        try {
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.length() > 1) {
                    return line;
                }
            }

            int exitCode = process.waitFor();
            if (exitCode != 0) {
                System.out.println("Python script exited with error code: " + exitCode);
            }

            reader.close();
        } catch (Exception e) {
            logger.error("data:[{}]", data);
            logger.error("decompress anneng data failed!", e);
        }
        return null;
    }
}
