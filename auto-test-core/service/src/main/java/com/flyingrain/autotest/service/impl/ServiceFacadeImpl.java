package com.flyingrain.autotest.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.flyingrain.autotest.common.util.*;
import com.flyingrain.autotest.common.util.constant.AutoTestConstants;
import com.flyingrain.autotest.common.util.constant.ProtocolTypeEnum;
import com.flyingrain.autotest.common.util.exception.AutoTestException;
import com.flyingrain.autotest.domain.core.CaseExecutorHelper;
import com.flyingrain.autotest.domain.core.executor.HttpEntityModel;
import com.flyingrain.autotest.domain.core.executor.HttpRequestBody;
import com.flyingrain.autotest.domain.model.Service;
import com.flyingrain.autotest.domain.model.User;
import com.flyingrain.autotest.domain.service.ServiceManager;
import com.flyingrain.autotest.facade.intf.model.AutoTestService;
import com.flyingrain.autotest.facade.intf.requests.BatchDelRequest;
import com.flyingrain.autotest.facade.intf.service.ServiceFacade;
import com.flyingrain.autotest.mvc.jersey.Resource;
import com.flyingrain.autotest.service.convert.ServiceViewConvert;
import org.glassfish.jersey.internal.guava.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ServiceFacadeImpl implements ServiceFacade, Resource {

    private final Logger logger = LoggerFactory.getLogger(ServiceFacadeImpl.class);

    @Autowired
    private ServiceManager serviceManager;

    @Override
    public CommonResult<PageableModel<AutoTestService>> queryServicePageable(PageQuery<AutoTestService> pageQuery) {
        PageableModel<Service> result = serviceManager.queryByPage(new PageQuery<>(pageQuery.getCurrentPage(), pageQuery.getPageSize(), ServiceViewConvert.convertView(pageQuery.getConditions())));
        PageableModel<AutoTestService> viewResult = PageableModel.copy(result);
        if (CollectionUtils.isEmpty(result.getData())) {
            logger.warn("query result is empty！[{}]", pageQuery);
            viewResult.setData(new ArrayList<>());
        } else {
            viewResult.setData(result.getData().stream().map(ServiceViewConvert::convertModel).collect(Collectors.toList()));
        }
        return CommonResult.success(viewResult);
    }

    @Override
    public CommonResult<Boolean> addService(AutoTestService autoTestService) {
        checkParam(autoTestService);
        User user = getUserInfo();
        autoTestService.setCreator(user.getUserName());
        int count = serviceManager.addService(ServiceViewConvert.convertView(autoTestService));
        return count > 0 ? CommonResult.success(true) : CommonResult.fail(AutoTestResultCodeEnum.FAIL.getCode(), AutoTestResultCodeEnum.FAIL.getMessage());
    }

    @Override
    public CommonResult<Integer> batchDel(BatchDelRequest serviceBatchDelRequest) {
        if (serviceBatchDelRequest == null || CollectionUtils.isEmpty(serviceBatchDelRequest.getIds())) {
            logger.warn("del request is empty!");
            return CommonResult.success(0);
        }
        User user = getUserInfo();
        int count = serviceManager.batchDelete(serviceBatchDelRequest.getIds(), user.getUserName());
        return CommonResult.success(count);
    }

    private static User getUserInfo() {
        User user = RunTimeContext.get(AutoTestConstants.USER);
        if (user == null) {
            throw new AutoTestException(AutoTestResultCodeEnum.USER_NOT_LOGIN);
        }
        return user;
    }

    @Override
    public CommonResult<Boolean> updateService(AutoTestService autoTestService) {
        if (autoTestService == null || autoTestService.getId() == 0) {
            logger.error("update key is empty!");
            return CommonResult.fail(AutoTestResultCodeEnum.PARAM_ERROR.getCode(), AutoTestResultCodeEnum.PARAM_ERROR.getMessage());
        }
        User user = getUserInfo();
        logger.info("user:[{}],update service:[{}]", user.getUserName(), autoTestService);
        int count = serviceManager.updateServiceById(ServiceViewConvert.convertView(autoTestService));
        return count > 0 ? CommonResult.success(true) : CommonResult.fail(AutoTestResultCodeEnum.FAIL.getCode(), AutoTestResultCodeEnum.FAIL.getMessage());
    }

    @Override
    public CommonResult<AutoTestService> getDetail(Integer id) {
        if (id == null) {
            return CommonResult.fail(AutoTestResultCodeEnum.PARAM_ERROR.getCode(), AutoTestResultCodeEnum.PARAM_ERROR.getMessage());
        }
        Service service = serviceManager.queryById(id);

        return CommonResult.success(ServiceViewConvert.convertModel(service));
    }

    @Override
    public CommonResult<List<AutoTestService>> queryAllService() {
        List<Service> services = serviceManager.queryAllService();
        return CommonResult.success(services.stream().map(ServiceViewConvert::convertModel).collect(Collectors.toList()));
    }

    @Override
    public CommonResult<List<AutoTestService>> queryByAppId(Integer appId) {
        List<Service> services = serviceManager.queryByAppIds(Collections.singletonList(appId));
        List<AutoTestService> autoTestServices = services.stream().peek(serviceManager::fillServiceParam).map(ServiceViewConvert::convertModel).collect(Collectors.toList());
        return CommonResult.success(autoTestServices);
    }

    private void checkParam(AutoTestService autoTestService) {
        if (autoTestService == null) {
            throw new AutoTestException(AutoTestResultCodeEnum.PARAM_ERROR);
        }
        if (!StringUtils.hasText(autoTestService.getServiceName())) {
            throw new AutoTestException(AutoTestResultCodeEnum.PARAM_ERROR.getCode(), "服务名为空");
        }
        if (!StringUtils.hasText(autoTestService.getServiceCode())) {
            throw new AutoTestException(AutoTestResultCodeEnum.PARAM_ERROR.getCode(), "服务编码为空");
        }
        if (!StringUtils.hasText(autoTestService.getRequestPath())) {
            throw new AutoTestException(AutoTestResultCodeEnum.PARAM_ERROR.getCode(), "请求路径为空");
        }
        if (!StringUtils.hasText(autoTestService.getProtocolType())) {
            throw new AutoTestException(AutoTestResultCodeEnum.PARAM_ERROR.getCode(), "协议类型为空");
        }
        String requestModelStr = autoTestService.getRequestModel();
        ProtocolTypeEnum protocolTypeEnum = ProtocolTypeEnum.valueOf(autoTestService.getProtocolType());
        switch (protocolTypeEnum) {
            case HTTP:
                HttpRequestBody httpRequestBody = JSONObject.parseObject(requestModelStr, HttpRequestBody.class);
                if (httpRequestBody.getRequestBodyTypeEnum() == RequestBodyTypeEnum.FORM) {
                    if (!CollectionUtils.isEmpty(httpRequestBody.getEntities())) {
                        for (HttpEntityModel entity : httpRequestBody.getEntities()) {
                            if (!StringUtils.hasText(entity.getKey()) || !StringUtils.hasText(entity.getValue())) {
                                throw new AutoTestException(AutoTestResultCodeEnum.PARAM_ERROR.getCode(), "form表单的key和value不能为空");
                            }
                            if ("FILE".equals(entity.getType()) && CaseExecutorHelper.isDynamicVar(entity.getValue())) {
                                if (!entity.getValue().contains("file_")) {
                                    throw new AutoTestException(AutoTestResultCodeEnum.PARAM_ERROR.getCode(), "文件变量必须以file_开头：" + entity.getKey());
                                }
                            }
                        }
                    }
                }
                break;
            case DUBBO:
                break;
            case ROCKETMQ:
                break;
        }
    }

}
