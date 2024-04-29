package com.flyingrain.autotest.service.convert;

import com.flyingrain.autotest.domain.model.ExecuteReport;
import com.flyingrain.autotest.facade.intf.model.AutoTestReport;
import org.springframework.util.CollectionUtils;

import java.util.stream.Collectors;

public class ReportViewConvert {

    public static AutoTestReport convertToView(ExecuteReport executeReport) {
        if (executeReport == null) {
            return null;
        }
        AutoTestReport autoTestReport = new AutoTestReport();
        autoTestReport.setId(executeReport.getId());
        autoTestReport.setBatchNum(executeReport.getBatchNum());
        autoTestReport.setCaseNumber(executeReport.getCaseNumber());
        autoTestReport.setSuccessNumber(executeReport.getSuccessNumber());
        autoTestReport.setResult(executeReport.getResult());
        autoTestReport.setRunNumber(executeReport.getRunNumber());
        autoTestReport.setOperator(executeReport.getOperator());
        autoTestReport.setDesc(executeReport.getDesc());
        autoTestReport.setEnv(executeReport.getEnv());
        autoTestReport.setCreateTime(executeReport.getCreateTime());
        autoTestReport.setUpdateTime(executeReport.getUpdateTime());
        autoTestReport.setExecuteTime(executeReport.getExecuteTime());
        autoTestReport.setConsumeTime(executeReport.getConsumeTime());
        autoTestReport.setTitle(executeReport.getTitle());
        if (!CollectionUtils.isEmpty(executeReport.getRunLogs())) {
            autoTestReport.setRunLogs(executeReport.getRunLogs().stream().map(RunLogViewConvert::convertToView).collect(Collectors.toList()));
        }
        return autoTestReport;
    }

    public static ExecuteReport convertToModel(AutoTestReport autoTestReport) {
        if (autoTestReport == null) {
            return null;
        }
        ExecuteReport executeReport = new ExecuteReport();
        executeReport.setId(autoTestReport.getId());
        executeReport.setBatchNum(autoTestReport.getBatchNum());
        executeReport.setCaseNumber(autoTestReport.getCaseNumber());
        executeReport.setSuccessNumber(autoTestReport.getSuccessNumber());
        executeReport.setResult(autoTestReport.getResult());
        executeReport.setRunNumber(autoTestReport.getRunNumber());
        executeReport.setOperator(autoTestReport.getOperator());
        executeReport.setDesc(autoTestReport.getDesc());
        executeReport.setEnv(autoTestReport.getEnv());
        executeReport.setCreateTime(autoTestReport.getCreateTime());
        executeReport.setUpdateTime(autoTestReport.getUpdateTime());
        executeReport.setExecuteTime(autoTestReport.getExecuteTime());
        executeReport.setConsumeTime(autoTestReport.getConsumeTime());
        executeReport.setTitle(autoTestReport.getTitle());
        if (!CollectionUtils.isEmpty(autoTestReport.getRunLogs())) {
            executeReport.setRunLogs(autoTestReport.getRunLogs().stream().map(RunLogViewConvert::convertToDomain).collect(Collectors.toList()));
        }
        return executeReport;

    }


}
