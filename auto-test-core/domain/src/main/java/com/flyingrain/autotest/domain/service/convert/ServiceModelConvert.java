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
        service.setModuleId(autoTestServiceModel.getModuleId());
        service.setName(autoTestServiceModel.getName());
        service.setProtocolType(autoTestServiceModel.getProtocolType());
        service.setRequestDataModule(autoTestServiceModel.getRequestDataModule());
        service.setRequestDataType(autoTestServiceModel.getRequestDataType());
        service.setResponseDataType(autoTestServiceModel.getResponseDataType());
        service.setRequestUrl(autoTestServiceModel.getRequestUrl());
        service.setRequestType(autoTestServiceModel.getRequestType());
        return service;
    }
}
