package com.flyingrain.autotest.service.convert;

import com.flyingrain.autotest.domain.model.RunLog;
import com.flyingrain.autotest.facade.intf.model.AutoTestRunLog;

public class RunLogViewConvert {

    public static AutoTestRunLog convertToView(RunLog runLog) {
        if (runLog == null) {
            return null;
        }
        AutoTestRunLog autoTestRunLog = new AutoTestRunLog();
        autoTestRunLog.setRunStatus(runLog.getRunStatus());
        autoTestRunLog.setBatchNum(runLog.getBatchNum());
        autoTestRunLog.setId(runLog.getId());
        autoTestRunLog.setExecutor(runLog.getExecutor());
        autoTestRunLog.setCaseId(runLog.getCaseId());
        autoTestRunLog.setRunResult(runLog.getRunResult());
        autoTestRunLog.setCreateTime(runLog.getCreateTime());
        autoTestRunLog.setMessage(runLog.getMessage());
        autoTestRunLog.setExecuteTime(runLog.getExecuteTime());
        autoTestRunLog.setUpdateTime(runLog.getUpdateTime());
        autoTestRunLog.setSpendTime(runLog.getCaseSpendTime());
        return autoTestRunLog;
    }

    public static RunLog convertToDomain(AutoTestRunLog autoTestRunLog) {
        if (autoTestRunLog == null) {
            return null;
        }
        RunLog runLog = new RunLog();
        runLog.setExecutor(autoTestRunLog.getExecutor());
        runLog.setCaseId(autoTestRunLog.getCaseId());
        runLog.setCaseSpendTime(autoTestRunLog.getSpendTime());
        runLog.setCreateTime(autoTestRunLog.getCreateTime());
        runLog.setUpdateTime(autoTestRunLog.getUpdateTime());
        runLog.setMessage(autoTestRunLog.getMessage());
        runLog.setRunResult(autoTestRunLog.getRunResult());
        runLog.setExecuteTime(autoTestRunLog.getExecuteTime());
        runLog.setBatchNum(autoTestRunLog.getBatchNum());
        runLog.setRunStatus(autoTestRunLog.getRunStatus());
        runLog.setId(autoTestRunLog.getId());
        return runLog;

    }
}
