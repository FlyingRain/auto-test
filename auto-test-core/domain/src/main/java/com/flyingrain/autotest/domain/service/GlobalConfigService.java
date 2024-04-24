package com.flyingrain.autotest.domain.service;

import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.common.util.PageableModel;
import com.flyingrain.autotest.domain.model.GlobalConfig;
import com.flyingrain.autotest.domain.service.convert.GlobalConfigModelConvert;
import com.flyingrain.autotest.infrastructure.datasource.mapper.AutoTestGlobalConfigMapper;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestGlobalConfigModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GlobalConfigService {

    @Autowired
    private AutoTestGlobalConfigMapper globalConfigMapper;


    public PageableModel<GlobalConfig> queryByPage(PageQuery<GlobalConfig> pageQuery) {
        PageQuery<AutoTestGlobalConfigModel> queryModel = new PageQuery<>(pageQuery.getCurrentPage(), pageQuery.getPageSize(), GlobalConfigModelConvert.convertToModel(pageQuery.getConditions()));
        List<AutoTestGlobalConfigModel> autoTestGlobalConfigModels = globalConfigMapper.queryByPage(queryModel);
        int count = globalConfigMapper.queryByPageCount(queryModel);
        PageableModel<GlobalConfig> pageableModel = new PageableModel<>();
        pageableModel.copyOf(pageQuery);
        pageableModel.setTotal(count);
        pageableModel.setData(autoTestGlobalConfigModels.stream().map(GlobalConfigModelConvert::convertToDomain).collect(Collectors.toList()));
        return pageableModel;
    }





}
