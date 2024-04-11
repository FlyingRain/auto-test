package com.flyingrain.autotest.service.impl;

import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.common.util.PageableModel;
import com.flyingrain.autotest.domain.model.RunLog;
import com.flyingrain.autotest.domain.service.RunLogService;
import com.flyingrain.autotest.facade.intf.model.AutoTestRunLog;
import com.flyingrain.autotest.facade.intf.runlog.RunLogFacade;
import com.flyingrain.autotest.mvc.jersey.Resource;
import com.flyingrain.autotest.service.convert.RunLogViewConvert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;


@Component
public class RunLogFacadeImpl implements RunLogFacade, Resource {

    private final Logger logger = LoggerFactory.getLogger(RunLogFacadeImpl.class);

    @Autowired
    private RunLogService runLogService;

    @Override
    public CommonResult<PageableModel<AutoTestRunLog>> queryByPage(PageQuery<AutoTestRunLog> autoTestRunLogPageQuery) {
        logger.info("start to query run log :[{}]", autoTestRunLogPageQuery);
        PageableModel<RunLog> pageableModel = runLogService.queryByPage(new PageQuery<>(autoTestRunLogPageQuery.getCurrentPage(), autoTestRunLogPageQuery.getPageSize(), RunLogViewConvert.convertToDomain(autoTestRunLogPageQuery.getConditions())));
        PageableModel<AutoTestRunLog> result = PageableModel.copy(pageableModel);
        result.setData(pageableModel.getData().stream().map(RunLogViewConvert::convertToView).collect(Collectors.toList()));
        return CommonResult.success(result);
    }

    @Override
    public CommonResult<AutoTestRunLog> queryDetail(Integer id) {
        RunLog runLog = runLogService.detail(id);
        return CommonResult.success(RunLogViewConvert.convertToView(runLog));
    }
}
