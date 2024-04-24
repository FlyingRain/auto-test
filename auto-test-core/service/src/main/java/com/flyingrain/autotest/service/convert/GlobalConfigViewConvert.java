package com.flyingrain.autotest.service.convert;

import com.flyingrain.autotest.domain.model.GlobalConfig;
import com.flyingrain.autotest.facade.intf.model.AutoTestGlobalConfig;

public class GlobalConfigViewConvert {


    public static GlobalConfig convertToDomain(AutoTestGlobalConfig autoTestGlobalConfig) {
        if (autoTestGlobalConfig == null) {
            return null;
        }
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setId(autoTestGlobalConfig.getId());
        globalConfig.setOperator(autoTestGlobalConfig.getOperator());
        globalConfig.setUpdateTime(autoTestGlobalConfig.getUpdateTime());
        globalConfig.setCreateTime(autoTestGlobalConfig.getCreateTime());
        globalConfig.setParamName(autoTestGlobalConfig.getParamName());
        globalConfig.setParamValue(autoTestGlobalConfig.getParamValue());
        globalConfig.setParamKey(autoTestGlobalConfig.getParamKey());
        return globalConfig;
    }

    public static AutoTestGlobalConfig convertToView(GlobalConfig globalConfig) {
        if (globalConfig == null) {
            return null;
        }
        AutoTestGlobalConfig autoTestGlobalConfig =new AutoTestGlobalConfig();
        autoTestGlobalConfig.setId(globalConfig.getId());
        autoTestGlobalConfig.setOperator(globalConfig.getOperator());
        autoTestGlobalConfig.setUpdateTime(globalConfig.getUpdateTime());
        autoTestGlobalConfig.setCreateTime(globalConfig.getCreateTime());
        autoTestGlobalConfig.setParamName(globalConfig.getParamName());
        autoTestGlobalConfig.setParamValue(globalConfig.getParamValue());
        autoTestGlobalConfig.setParamKey(globalConfig.getParamKey());
        return autoTestGlobalConfig;
    }


}
