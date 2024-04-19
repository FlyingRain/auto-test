package com.flyingrain.autotest.domain.service.convert;

import com.flyingrain.autotest.domain.model.ExecuteReport;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestReportModel;

public class ReportModelConvert {

    public static ExecuteReport convertToDomain(AutoTestReportModel autoTestReportModel) {
        if (autoTestReportModel == null) {
            return null;
        }
        ExecuteReport executeReport = new ExecuteReport();
        executeReport.setId(autoTestReportModel.getId());
        executeReport.setTitle(autoTestReportModel.getTitle());
        executeReport.setConsumeTime(autoTestReportModel.getConsumeTime());
        executeReport.setExecuteTime(autoTestReportModel.getExecuteTime());
        executeReport.setOperator(autoTestReportModel.getOperator());
        executeReport.setBatchNum(autoTestReportModel.getBatchNum());
        executeReport.setCaseNumber(autoTestReportModel.getCaseNumber());
        executeReport.setSuccessNumber(autoTestReportModel.getSuccessNumber());
        executeReport.setResult(autoTestReportModel.getResult());
        executeReport.setCreateTime(autoTestReportModel.getCreateTime());
        executeReport.setUpdateTime(autoTestReportModel.getUpdateTime());
        executeReport.setEnv(autoTestReportModel.getEnv());
        executeReport.setDesc(autoTestReportModel.getDesc());
        return executeReport;
    }

    public static AutoTestReportModel convertToModel(ExecuteReport executeReport) {
        if (executeReport == null) {
            return null;
        }
        AutoTestReportModel autoTestReportModel = new AutoTestReportModel();
        autoTestReportModel.setId(executeReport.getId());
        autoTestReportModel.setTitle(executeReport.getTitle());
        autoTestReportModel.setConsumeTime(executeReport.getConsumeTime());
        autoTestReportModel.setExecuteTime(executeReport.getExecuteTime());
        autoTestReportModel.setOperator(executeReport.getOperator());
        autoTestReportModel.setBatchNum(executeReport.getBatchNum());
        autoTestReportModel.setCaseNumber(executeReport.getCaseNumber());
        autoTestReportModel.setSuccessNumber(executeReport.getSuccessNumber());
        autoTestReportModel.setResult(executeReport.getResult());
        autoTestReportModel.setCreateTime(executeReport.getCreateTime());
        autoTestReportModel.setUpdateTime(executeReport.getUpdateTime());
        autoTestReportModel.setEnv(executeReport.getEnv());
        autoTestReportModel.setDesc(executeReport.getDesc());
        return autoTestReportModel;
    }
}
