package com.flyingrain.autotest.domain.service.convert;

import com.flyingrain.autotest.domain.model.ServiceParam;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestServiceModel;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestServiceParamModel;

public class ServiceParamModelConvert {

    public static ServiceParam convertModel(AutoTestServiceParamModel autoTestServiceParamModel) {
        if (autoTestServiceParamModel == null) {
            return null;
        }
        ServiceParam serviceParam = new ServiceParam();
        serviceParam.setServiceId(autoTestServiceParamModel.getServiceId());
        serviceParam.setParam(autoTestServiceParamModel.getParam());
        serviceParam.setDesc(autoTestServiceParamModel.getDesc());
        serviceParam.setCreateTime(autoTestServiceParamModel.getCreateTime());
        serviceParam.setUpdateTime(autoTestServiceParamModel.getUpdateTime());
        serviceParam.setId(autoTestServiceParamModel.getId());
        return serviceParam;
    }


    public static AutoTestServiceParamModel convertServiceParam(ServiceParam serviceParam) {
        if (serviceParam == null) {
            return null;

        }
        AutoTestServiceParamModel autoTestServiceParamModel = new AutoTestServiceParamModel();
        autoTestServiceParamModel.setId(serviceParam.getId());
        autoTestServiceParamModel.setServiceId(serviceParam.getServiceId());
        autoTestServiceParamModel.setParam(serviceParam.getParam());
        autoTestServiceParamModel.setDesc(serviceParam.getDesc());
        autoTestServiceParamModel.setCreateTime(serviceParam.getCreateTime());
        autoTestServiceParamModel.setUpdateTime(serviceParam.getUpdateTime());
        return autoTestServiceParamModel;
    }
}
