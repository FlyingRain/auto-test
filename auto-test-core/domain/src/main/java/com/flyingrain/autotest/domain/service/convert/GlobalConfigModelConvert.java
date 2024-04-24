package com.flyingrain.autotest.domain.service.convert;

import com.flyingrain.autotest.domain.model.GlobalConfig;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestGlobalConfigModel;

public class GlobalConfigModelConvert {

    public static GlobalConfig convertToDomain(AutoTestGlobalConfigModel autoTestGlobalConfigModel) {
        if (autoTestGlobalConfigModel == null) {
            return null;
        }

        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setId(autoTestGlobalConfigModel.getId());
        globalConfig.setOperator(autoTestGlobalConfigModel.getOperator());
        globalConfig.setParamKey(autoTestGlobalConfigModel.getParamKey());
        globalConfig.setParamValue(autoTestGlobalConfigModel.getParamValue());
        globalConfig.setParamName(autoTestGlobalConfigModel.getParamName());
        globalConfig.setCreateTime(autoTestGlobalConfigModel.getCreateTime());
        globalConfig.setUpdateTime(autoTestGlobalConfigModel.getUpdateTime());
        return globalConfig;
    }

    public static AutoTestGlobalConfigModel convertToModel(GlobalConfig globalConfig) {
        if (globalConfig == null) {
            return null;
        }
        AutoTestGlobalConfigModel autoTestGlobalConfigModel = new AutoTestGlobalConfigModel();
        autoTestGlobalConfigModel.setId(globalConfig.getId());
        autoTestGlobalConfigModel.setParamKey(globalConfig.getParamKey());
        autoTestGlobalConfigModel.setParamName(globalConfig.getParamName());
        autoTestGlobalConfigModel.setParamValue(globalConfig.getParamValue());
        autoTestGlobalConfigModel.setCreateTime(globalConfig.getCreateTime());
        autoTestGlobalConfigModel.setUpdateTime(globalConfig.getUpdateTime());
        return autoTestGlobalConfigModel;
    }
}
