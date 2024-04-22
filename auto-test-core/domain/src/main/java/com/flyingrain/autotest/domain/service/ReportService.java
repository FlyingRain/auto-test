package com.flyingrain.autotest.domain.service;

import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.common.util.PageableModel;
import com.flyingrain.autotest.domain.model.ExecuteReport;
import com.flyingrain.autotest.domain.model.RunLog;
import com.flyingrain.autotest.domain.service.convert.ReportModelConvert;
import com.flyingrain.autotest.infrastructure.datasource.mapper.AutoTestReportMapper;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestReportModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReportService {

    private final  Logger logger = LoggerFactory.getLogger(ReportService.class);

    @Autowired
    private AutoTestReportMapper autoTestReportMapper;

    @Autowired
    private RunLogService runLogService;


    public int insertReport(ExecuteReport executeReport) {
        logger.info("start to insert report:[{}],runNum:[{}]", executeReport.getBatchNum(), executeReport.getRunNumber());
        AutoTestReportModel autoTestReportModel = ReportModelConvert.convertToModel(executeReport);
        int count =  autoTestReportMapper.insert(autoTestReportModel);
        executeReport.setId(autoTestReportModel.getId());
        return count;
    }

    public int updateReport(ExecuteReport report) {
        logger.info("start to update report :[{}]", report);
        return autoTestReportMapper.updateReport(ReportModelConvert.convertToModel(report));
    }


    public PageableModel<ExecuteReport> pageQuery(PageQuery<ExecuteReport> executeReportPageQuery) {
        logger.info("query report by page:[{}]", executeReportPageQuery);
        PageQuery<AutoTestReportModel> pageQuery = new PageQuery<>(executeReportPageQuery.getCurrentPage(), executeReportPageQuery.getPageSize(), ReportModelConvert.convertToModel(executeReportPageQuery.getConditions()));
        List<AutoTestReportModel> autoTestReportModelList = autoTestReportMapper.queryByPage(pageQuery);
        int count = autoTestReportMapper.queryByPageCount(pageQuery);
        PageableModel<ExecuteReport> pageableModel = new PageableModel<>();
        pageableModel.copyOf(executeReportPageQuery);
        pageableModel.setData(autoTestReportModelList.stream().map(ReportModelConvert::convertToDomain).collect(Collectors.toList()));
        pageableModel.setTotal(count);
        return pageableModel;
    }

    public ExecuteReport detail(Integer id) {
        logger.info("start to query report detail:[{}]", id);
        ExecuteReport executeReport = ReportModelConvert.convertToDomain(autoTestReportMapper.detail(id));
        List<RunLog> runLogs = runLogService.queryByBatchNum(executeReport.getBatchNum());
        logger.info("query report log size:[{}],batchNum:[{}]", runLogs.size(), executeReport.getBatchNum());
        executeReport.setRunLogs(runLogs);
        return executeReport;
    }
}
