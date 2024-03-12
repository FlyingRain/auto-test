package com.flyingrain.autotest.domain.service.convert;

import com.flyingrain.autotest.domain.model.Service;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestServiceModel;

/**
 * @author wally
 * @date 2021-12-09
 */
public class ServiceModelConvert {

    public static Service convertServiceModel(AutoTestServiceModel autoTestServiceModel) {
        if (autoTestServiceModel == null) {
            return null;
        }
        Service service = new Service();
        service.setUpdateTime(autoTestServiceModel.getUpdateTime());
        service.setServiceCode(autoTestServiceModel.getServiceCode());
        service.setCreator(autoTestServiceModel.getCreator());
        service.setId(autoTestServiceModel.getId());
        service.setCreateTime(autoTestServiceModel.getCreateTime());
        service.setAppId(autoTestServiceModel.getAppId());
        service.setName(autoTestServiceModel.getServiceName());
        service.setProtocolType(autoTestServiceModel.getProtocolType());
        service.setRequestDataModule(autoTestServiceModel.getRequestModel());
        service.setHeaders(autoTestServiceModel.getHeaders());
        service.setResponseDataType(autoTestServiceModel.getResponseDataType());
        service.setRequestUrl(autoTestServiceModel.getRequestPath());
        service.setRequestType(autoTestServiceModel.getRequestType());
        return service;
    }


    public static AutoTestServiceModel convertService(Service service) {
        if (service == null) {
            return null;
        }
        AutoTestServiceModel autoTestServiceModel = new AutoTestServiceModel();
        autoTestServiceModel.setAppId(service.getAppId());
        autoTestServiceModel.setId(service.getId());
        autoTestServiceModel.setRequestModel(service.getRequestDataModule());
        autoTestServiceModel.setHeaders(service.getHeaders());
        autoTestServiceModel.setServiceName(service.getName());
        autoTestServiceModel.setRequestPath(service.getRequestUrl());
        autoTestServiceModel.setRequestType(service.getRequestType());
        autoTestServiceModel.setCreateTime(service.getCreateTime());
        autoTestServiceModel.setCreator(service.getCreator());
        autoTestServiceModel.setProtocolType(service.getProtocolType());
        autoTestServiceModel.setResponseDataType(service.getResponseDataType());
        autoTestServiceModel.setServiceCode(service.getServiceCode());
        autoTestServiceModel.setUpdateTime(service.getUpdateTime());
        return autoTestServiceModel;
    }
}
