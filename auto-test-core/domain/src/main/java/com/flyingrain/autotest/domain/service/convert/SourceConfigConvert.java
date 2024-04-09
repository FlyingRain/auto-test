package com.flyingrain.autotest.domain.service.convert;

import com.flyingrain.autotest.domain.model.SourceConfig;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestSourceConfigModel;

public class SourceConfigConvert {

    public static AutoTestSourceConfigModel convertToModel(SourceConfig sourceConfig) {
        if (sourceConfig == null) {
            return null;
        }
        AutoTestSourceConfigModel autoTestSourceConfigModel = new AutoTestSourceConfigModel();
        autoTestSourceConfigModel.setConfig(sourceConfig.getConfig());
        autoTestSourceConfigModel.setCode(sourceConfig.getCode());
        autoTestSourceConfigModel.setId(sourceConfig.getId());
        autoTestSourceConfigModel.setOperator(sourceConfig.getOperator());
        autoTestSourceConfigModel.setName(sourceConfig.getName());
        autoTestSourceConfigModel.setCreateTime(sourceConfig.getCreateTime());
        autoTestSourceConfigModel.setUpdateTime(sourceConfig.getUpdateTime());
        return autoTestSourceConfigModel;
    }

    public static SourceConfig convertToDomain(AutoTestSourceConfigModel autoTestSourceConfigModel) {
        if (autoTestSourceConfigModel == null) {
            return null;
        }
        SourceConfig sourceConfig = new SourceConfig();
        sourceConfig.setCode(autoTestSourceConfigModel.getCode());
        sourceConfig.setName(autoTestSourceConfigModel.getName());
        sourceConfig.setConfig(autoTestSourceConfigModel.getConfig());
        sourceConfig.setOperator(autoTestSourceConfigModel.getOperator());
        sourceConfig.setId(autoTestSourceConfigModel.getId());
        sourceConfig.setCreateTime(autoTestSourceConfigModel.getCreateTime());
        sourceConfig.setUpdateTime(autoTestSourceConfigModel.getUpdateTime());
        return sourceConfig;
    }
}
