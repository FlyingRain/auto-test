package com.flyingrain.autotest.service.impl;

import com.flyingrain.autotest.common.util.*;
import com.flyingrain.autotest.common.util.constant.AutoTestConstants;
import com.flyingrain.autotest.common.util.exception.AutoTestException;
import com.flyingrain.autotest.domain.model.Service;
import com.flyingrain.autotest.domain.model.User;
import com.flyingrain.autotest.domain.service.ServiceManager;
import com.flyingrain.autotest.facade.intf.model.AutoTestService;
import com.flyingrain.autotest.facade.intf.requests.BatchDelRequest;
import com.flyingrain.autotest.facade.intf.service.ServiceFacade;
import com.flyingrain.autotest.mvc.jersey.Resource;
import com.flyingrain.autotest.service.convert.ServiceViewConvert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
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
        if (serviceBatchDelRequest == null || CollectionUtils.isEmpty(serviceBatchDelRequest.getServiceIds())) {
            logger.warn("del request is empty!");
            return CommonResult.success(0);
        }
        User user = getUserInfo();
        int count = serviceManager.batchDelete(serviceBatchDelRequest.getServiceIds(), user.getUserName());
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

    private void checkParam(AutoTestService autoTestService) {
        if (autoTestService == null) {
            throw new AutoTestException(AutoTestResultCodeEnum.PARAM_ERROR);
        }
        if (StringUtils.hasText(autoTestService.getServiceName())) {
            throw new AutoTestException(AutoTestResultCodeEnum.PARAM_ERROR.getCode(), "服务名为空");
        }
        if (StringUtils.hasText(autoTestService.getServiceCode())) {
            throw new AutoTestException(AutoTestResultCodeEnum.PARAM_ERROR.getCode(), "服务编码为空");
        }
        if (StringUtils.hasText(autoTestService.getRequestPath())) {
            throw new AutoTestException(AutoTestResultCodeEnum.PARAM_ERROR.getCode(), "请求路径为空");
        }
        if (StringUtils.hasText(autoTestService.getProtocolType())) {
            throw new AutoTestException(AutoTestResultCodeEnum.PARAM_ERROR.getCode(), "协议类型为空");
        }
    }
}
