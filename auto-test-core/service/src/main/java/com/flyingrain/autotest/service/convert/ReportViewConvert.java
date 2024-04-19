package com.flyingrain.autotest.service.convert;

import com.flyingrain.autotest.domain.model.ExecuteReport;
import com.flyingrain.autotest.facade.intf.model.AutoTestReport;

public class ReportViewConvert {

    public AutoTestReport convertToView(ExecuteReport executeReport) {
        if (executeReport == null) {
            return null;
        }
        AutoTestReport autoTestReport = new AutoTestReport();
        autoTestReport.setId(executeReport.getId());
        autoTestReport.setBatchNum(executeReport.getBatchNum());
        autoTestReport.setCase_number(executeReport.getCaseNumber());
        autoTestReport.setSuccess_number(executeReport.getSuccessNumber());
        autoTestReport.setResult(executeReport.getResult());
        autoTestReport.setRun_number(executeReport.getRunNumber());
        autoTestReport.setOperator(executeReport.getOperator());
        autoTestReport.setDesc(executeReport.getDesc());
        autoTestReport.setEnv(executeReport.getEnv());
        autoTestReport.setCreateTime();
    }


}
