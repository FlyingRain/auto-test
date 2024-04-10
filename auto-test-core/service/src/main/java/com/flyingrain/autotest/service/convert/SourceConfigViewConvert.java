package com.flyingrain.autotest.service.convert;

import com.flyingrain.autotest.domain.model.SourceConfig;
import com.flyingrain.autotest.facade.intf.model.AutoTestSourceConfig;

public class SourceConfigViewConvert {

    public static SourceConfig convertToDomain(AutoTestSourceConfig autoTestSourceConfig) {
        if (autoTestSourceConfig == null) {
            return null;
        }
        SourceConfig sourceConfig = new SourceConfig();
        sourceConfig.setId(autoTestSourceConfig.getId());
        sourceConfig.setConfig(autoTestSourceConfig.getConfig());
        sourceConfig.setUpdateTime(autoTestSourceConfig.getUpdateTime());
        sourceConfig.setSourceType(autoTestSourceConfig.getSourceType());
        sourceConfig.setCode(autoTestSourceConfig.getCode());
        sourceConfig.setOperator(autoTestSourceConfig.getOperator());
        sourceConfig.setCreateTime(autoTestSourceConfig.getCreateTime());
        sourceConfig.setName(autoTestSourceConfig.getName());
        return sourceConfig;
    }


    public static AutoTestSourceConfig convertTiView(SourceConfig sourceConfig) {
        if (sourceConfig == null) {
            return null;
        }
        AutoTestSourceConfig autoTestSourceConfig = new AutoTestSourceConfig();
        autoTestSourceConfig.setCode(sourceConfig.getCode());
        autoTestSourceConfig.setName(sourceConfig.getName());
        autoTestSourceConfig.setConfig(sourceConfig.getConfig());
        autoTestSourceConfig.setOperator(sourceConfig.getOperator());
        autoTestSourceConfig.setId(sourceConfig.getId());
        autoTestSourceConfig.setSourceType(autoTestSourceConfig.getSourceType());
        autoTestSourceConfig.setCreateTime(autoTestSourceConfig.getCreateTime());
        autoTestSourceConfig.setUpdateTime(autoTestSourceConfig.getUpdateTime());
        return autoTestSourceConfig;

    }


}
