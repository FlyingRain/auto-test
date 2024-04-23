package com.flyingrain.autotest.service.impl;

import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.common.util.PageableModel;
import com.flyingrain.autotest.domain.model.SourceConfig;
import com.flyingrain.autotest.domain.service.SourceConfigService;
import com.flyingrain.autotest.facade.intf.model.AutoTestSourceConfig;
import com.flyingrain.autotest.facade.intf.requests.BatchDelRequest;
import com.flyingrain.autotest.facade.intf.source.SourceConfigFacade;
import com.flyingrain.autotest.mvc.jersey.Resource;
import com.flyingrain.autotest.service.convert.SourceConfigViewConvert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SourceConfigFacadeImpl implements SourceConfigFacade, Resource {

    private final Logger logger = LoggerFactory.getLogger(SourceConfigFacadeImpl.class);

    @Autowired
    private SourceConfigService sourceConfigService;

    @Override
    public CommonResult<List<AutoTestSourceConfig>> allSource() {
        List<SourceConfig> sourceConfigs = sourceConfigService.queryAll();
        logger.info("query all source:[{}]", sourceConfigs.size());
        return CommonResult.success(sourceConfigs.stream().map(SourceConfigViewConvert::convertToView).collect(Collectors.toList()));
    }

    @Override
    public CommonResult<PageableModel<AutoTestSourceConfig>> querySourceByPage(PageQuery<AutoTestSourceConfig> pageQuery) {
        logger.info("page query:[{}]", pageQuery);
        PageableModel<SourceConfig> sourceConfigPageableModel = sourceConfigService.queryByPage(new PageQuery<>(pageQuery.getCurrentPage(), pageQuery.getPageSize(), SourceConfigViewConvert.convertToDomain(pageQuery.getConditions())));
        PageableModel<AutoTestSourceConfig> result = PageableModel.copy(sourceConfigPageableModel);
        result.setData(sourceConfigPageableModel.getData().stream().map(SourceConfigViewConvert::convertToView).collect(Collectors.toList()));
        return CommonResult.success(result);
    }

    @Override
    public CommonResult<AutoTestSourceConfig> queryDetail(int id) {
        return CommonResult.success(SourceConfigViewConvert.convertToView(sourceConfigService.queryDetail(id)));
    }

    @Override
    public CommonResult<Boolean> addSource(AutoTestSourceConfig autoTestSourceConfig) {
        logger.info("start to insert sourceConfig:[{}]", autoTestSourceConfig);
        return CommonResult.success(sourceConfigService.insert(SourceConfigViewConvert.convertToDomain(autoTestSourceConfig)));
    }

    @Override
    public CommonResult<Boolean> testConnection(AutoTestSourceConfig autoTestSourceConfig) {
        logger.info("start to test connection:[{}]", autoTestSourceConfig);
        sourceConfigService.testConnection(SourceConfigViewConvert.convertToDomain(autoTestSourceConfig));
        return CommonResult.success(true);
    }

    @Override
    public CommonResult<Boolean> updateSource(AutoTestSourceConfig autoTestSourceConfig) {
        logger.info("start to update sourceConfig:[{}]", autoTestSourceConfig);
        return CommonResult.success(sourceConfigService.updateById(SourceConfigViewConvert.convertToDomain(autoTestSourceConfig)));
    }

    @Override
    public CommonResult<Integer> batchDel(BatchDelRequest batchDelRequest) {
        return CommonResult.success(sourceConfigService.batchDel(batchDelRequest.getIds()));
    }
}
