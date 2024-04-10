package com.flyingrain.autotest.service.impl;

import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.domain.model.SourceConfig;
import com.flyingrain.autotest.domain.service.SourceConfigService;
import com.flyingrain.autotest.facade.intf.model.AutoTestSourceConfig;
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
        logger.info("query all source:[{}]",sourceConfigs.size());
        return CommonResult.success(sourceConfigs.stream().map(SourceConfigViewConvert::convertTiView).collect(Collectors.toList()));
    }
}
