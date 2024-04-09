package com.flyingrain.autotest.domain.service;

import com.flyingrain.autotest.domain.model.SourceConfig;
import com.flyingrain.autotest.domain.service.convert.SourceConfigConvert;
import com.flyingrain.autotest.infrastructure.datasource.mapper.AutoTestSourceConfigMapper;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestSourceConfigModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SourceConfigService {

    private final Logger logger = LoggerFactory.getLogger(SourceConfigService.class);

    @Autowired
    private AutoTestSourceConfigMapper autoTestSourceConfigMapper;


    public List<SourceConfig> queryAll() {
        List<AutoTestSourceConfigModel> autoTestSourceConfigModels = autoTestSourceConfigMapper.queryAll();
        logger.info("query all source config:[{}]", autoTestSourceConfigModels.size());
        return autoTestSourceConfigModels.stream().map(SourceConfigConvert::convertToDomain).collect(Collectors.toList());
    }


}
