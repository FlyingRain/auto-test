package com.flyingrain.autotest.service.impl;

import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.common.util.PageableModel;
import com.flyingrain.autotest.domain.service.ReportService;
import com.flyingrain.autotest.facade.intf.model.AutoTestReport;
import com.flyingrain.autotest.facade.intf.report.ReportFacade;
import com.flyingrain.autotest.mvc.jersey.Resource;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReportFacadeImpl implements ReportFacade, Resource {

    private final Logger logger = LoggerFactory.getLogger(ReportFacade.class);

    @Autowired
    private ReportService reportService;

    @Override
    public CommonResult<AutoTestReport> queryDetail(Integer id) {
        return reportService.detail(id);
    }

    @Override
    public CommonResult<PageableModel<AutoTestReport>> queryReportByPage(PageQuery<AutoTestReport> autoTestReportPageQuery) {
        return null;
    }

    @Override
    public CommonResult<Boolean> updateReport(AutoTestReport autoTestReport) {
        return null;
    }

    @Override
    public Response generateReportFile(Integer id) {
        return null;
    }
}
