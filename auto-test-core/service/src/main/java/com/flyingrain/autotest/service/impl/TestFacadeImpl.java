package com.flyingrain.autotest.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.common.util.RunTimeContext;
import com.flyingrain.autotest.domain.AutoTestModuleManager;
import com.flyingrain.autotest.domain.service.CityService;
import com.flyingrain.autotest.facade.intf.TestFacade;
import com.flyingrain.autotest.facade.intf.model.AutoTestIn;
import com.flyingrain.autotest.facade.intf.model.oder.ChannelCompare;
import com.flyingrain.autotest.facade.intf.model.oder.City;
import com.flyingrain.autotest.facade.intf.model.oder.SendOrder;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestModuleModel;
import com.flyingrain.autotest.infrastructure.datasource.model.CityModel;
import com.flyingrain.autotest.mvc.jersey.AutoTestService;
import com.flyingrain.autotest.mvc.jersey.Resource;
import com.flyingrain.autotest.service.model.ChromeCookieUnit;
import com.flyingrain.autotest.service.model.MyChromeCookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
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
                RunTimeContext.put("PHPSESSID", chromeCookieUnit.getValue());
            }
        }
        return param.getIn();
    }


    @Override
    public ChannelCompare compare(SendOrder sendOrder) {
        return null;
    }

    @Override
    public CommonResult<List<City>> getRelativeCities(Integer relativeId) {
        logger.info("start query city info:[{}]", relativeId);
        List<CityModel> cityModels = cityService.queryCityByRelativeId(relativeId);

        return CommonResult.success(cityModels.stream().map(cityModel -> {
            City city = new City();
            city.setId(cityModel.getId());
            city.setName(cityModel.getName());
            city.setRelativeId(cityModel.getRelativeId());
            return city;
        }).collect(Collectors.toList()));
    }


}
