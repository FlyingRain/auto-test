package com.flyingrain.autotest.service.convert;

import com.flyingrain.autotest.domain.model.Service;
import com.flyingrain.autotest.facade.intf.model.AutoTestService;

public class ServiceViewConvert {

    public static Service convertView(AutoTestService autoTestService) {
        if (autoTestService == null) {
            return null;
        }
        Service service = new Service();
        service.setId(autoTestService.getId());
        service.setCreateTime(autoTestService.getCreateTime());
        service.setServiceCode(autoTestService.getServiceCode());
        service.setName(autoTestService.getServiceName());
        service.setCreator(autoTestService.getCreator());
        service.setProtocolType(autoTestService.getProtocolType());
        service.setRequestDataModule(autoTestService.getRequestModel());
        service.setRequestDataType(autoTestService.getResponseDataType());
        service.setRequestType(autoTestService.getRequestType());
        service.setRequestUrl(autoTestService.getRequestPath());
        service.setResponseDataType(autoTestService.getResponseDataType());
        return service;
    }

    public static AutoTestService convertModel(Service service) {
        if (service == null) {
            return null;
        }
        AutoTestService autoTestService = new AutoTestService();
        autoTestService.setId(service.getId());
        autoTestService.setServiceCode(service.getServiceCode());
        autoTestService.setServiceName(service.getName());
        autoTestService.setRequestType(service.getRequestType());
        autoTestService.setCreator(service.getCreator());
        autoTestService.setAppId(service.getAppId());
        autoTestService.setRequestModel(service.getRequestDataModule());
        autoTestService.setHearders(service.getHeaders());
        autoTestService.setCreateTime(service.getCreateTime());
        autoTestService.setUpdateTime(service.getUpdateTime());
        autoTestService.setProtocolType(service.getProtocolType());
        autoTestService.setRequestPath(service.getRequestUrl());
        autoTestService.setResponseDataType(service.getResponseDataType());
        return autoTestService;
    }

}
