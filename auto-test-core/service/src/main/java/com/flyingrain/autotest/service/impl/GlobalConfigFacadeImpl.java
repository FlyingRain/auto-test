package com.flyingrain.autotest.service.impl;

import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.common.util.PageableModel;
import com.flyingrain.autotest.domain.model.GlobalConfig;
import com.flyingrain.autotest.domain.service.GlobalConfigService;
import com.flyingrain.autotest.facade.intf.globalconfig.GlobalConfigFacade;
import com.flyingrain.autotest.facade.intf.model.AutoTestGlobalConfig;
import com.flyingrain.autotest.facade.intf.requests.BatchDelRequest;
import com.flyingrain.autotest.mvc.jersey.Resource;
import com.flyingrain.autotest.service.convert.GlobalConfigViewConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GlobalConfigFacadeImpl implements GlobalConfigFacade, Resource {

    @Autowired
    private GlobalConfigService globalConfigService;

    @Override
    public CommonResult<Boolean> insert(AutoTestGlobalConfig autoTestGlobalConfig) {
        int count = globalConfigService.insert(GlobalConfigViewConvert.convertToDomain(autoTestGlobalConfig));
        return CommonResult.success(count == 1);
    }

    @Override
    public CommonResult<PageableModel<AutoTestGlobalConfig>> pageQuery(PageQuery<AutoTestGlobalConfig> pageQuery) {
        PageableModel<GlobalConfig> pageableModel = globalConfigService.queryByPage(new PageQuery<>(pageQuery.getCurrentPage(), pageQuery.getPageSize(), GlobalConfigViewConvert.convertToDomain(pageQuery.getConditions())));
        PageableModel<AutoTestGlobalConfig> result = PageableModel.copy(pageableModel);
        result.setData(pageableModel.getData().stream().map(GlobalConfigViewConvert::convertToView).collect(Collectors.toList()));
        return CommonResult.success(result);
    }

    @Override
    public CommonResult<Boolean> update(AutoTestGlobalConfig autoTestGlobalConfig) {
        int count = globalConfigService.updateById(GlobalConfigViewConvert.convertToDomain(autoTestGlobalConfig));
        return CommonResult.success(count == 1);
    }

    @Override
    public CommonResult<Integer> batchDel(BatchDelRequest batchDelRequest) {
        return CommonResult.success(globalConfigService.batchDel(batchDelRequest.getIds()));
    }

    @Override
    public CommonResult<List<AutoTestGlobalConfig>> queryAll() {
        List<GlobalConfig> globalConfigList = globalConfigService.queryAll();
        return CommonResult.success(globalConfigList.stream().map(GlobalConfigViewConvert::convertToView).collect(Collectors.toList()));
    }
}
