package com.flyingrain.autotest.service.convert;

import com.flyingrain.autotest.domain.model.ServiceParam;
import com.flyingrain.autotest.facade.intf.model.AutoTestServiceParam;

public class ServiceParamViewConvert {

    public static AutoTestServiceParam convertToView(ServiceParam serviceParam) {
        if (serviceParam == null) {
            return null;
        }
        AutoTestServiceParam autoTestServiceParam = new AutoTestServiceParam();
        autoTestServiceParam.setDesc(serviceParam.getDesc());
        autoTestServiceParam.setCreateTime(serviceParam.getCreateTime());
        autoTestServiceParam.setName(serviceParam.getParam());
        autoTestServiceParam.setUpdateTime(serviceParam.getUpdateTime());
        autoTestServiceParam.setId(serviceParam.getId());
        return autoTestServiceParam;
    }

}
