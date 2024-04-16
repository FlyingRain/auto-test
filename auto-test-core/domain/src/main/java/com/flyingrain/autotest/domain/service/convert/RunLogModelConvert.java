package com.flyingrain.autotest.domain.service.convert;

import com.flyingrain.autotest.domain.model.RunLog;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestRunLogModel;

/**
 * @author wally
 * @date 2021-12-13
 */
public class RunLogModelConvert {

    public static RunLog convertRunLogModel(AutoTestRunLogModel autoTestRunLogModel) {
        if (autoTestRunLogModel == null) {
            return null;
        }
        RunLog runLog = new RunLog();
        runLog.setCreateTime(autoTestRunLogModel.getCreateTime());
        runLog.setId(autoTestRunLogModel.getId());
        runLog.setBatchNum(autoTestRunLogModel.getBatchNum());
        runLog.setUpdateTime(autoTestRunLogModel.getUpdateTime());
        runLog.setCaseCode(autoTestRunLogModel.getCaseCode());
        runLog.setCaseSpendTime(autoTestRunLogModel.getCaseSpendTime());
        runLog.setExecuteTime(autoTestRunLogModel.getExecuteTime());
        runLog.setRunResult(autoTestRunLogModel.getRunResult());
        runLog.setExecutor(autoTestRunLogModel.getExecutor());
        runLog.setMessage(autoTestRunLogModel.getMessage());
        runLog.setRunStatus(autoTestRunLogModel.getRunStatus());
        return runLog;
    }

    public static AutoTestRunLogModel convertRunLog(RunLog runLog) {
        if (runLog == null) {
            return null;
        }
        AutoTestRunLogModel autoTestRunLogModel = new AutoTestRunLogModel();
        autoTestRunLogModel.setCaseCode(runLog.getCaseCode());
        autoTestRunLogModel.setId(runLog.getId());
        autoTestRunLogModel.setBatchNum(runLog.getBatchNum());
        autoTestRunLogModel.setRunResult(runLog.getRunResult());
        autoTestRunLogModel.setCreateTime(runLog.getCreateTime());
        autoTestRunLogModel.setRunStatus(runLog.getRunStatus());
        autoTestRunLogModel.setUpdateTime(runLog.getUpdateTime());
        autoTestRunLogModel.setExecutor(runLog.getExecutor());
        autoTestRunLogModel.setExecuteTime(runLog.getExecuteTime());
        autoTestRunLogModel.setCaseSpendTime(runLog.getCaseSpendTime());
        autoTestRunLogModel.setMessage(runLog.getMessage());
        return autoTestRunLogModel;
    }
}
