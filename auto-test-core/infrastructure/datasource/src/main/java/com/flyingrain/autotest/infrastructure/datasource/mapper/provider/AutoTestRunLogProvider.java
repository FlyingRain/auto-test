package com.flyingrain.autotest.infrastructure.datasource.mapper.provider;

import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestRunLogModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * @author wally
 * @date 2021-12-13
 */
public class AutoTestRunLogProvider {

    private static final Logger logger = LoggerFactory.getLogger(AutoTestRunLogProvider.class);

    public String insertBatchRunLog(Map<String, Object> params) {
        List<AutoTestRunLogModel> runLogModels = (List<AutoTestRunLogModel>) params.get("runLogs");
        if (CollectionUtils.isEmpty(runLogModels)) {
            logger.error("runLog collection is empty!");
            return null;
        }
        StringBuilder sqlBuilder = new StringBuilder("insert into auto_test_run_log (case_id,run_status,executor,execute_time,case_spend_time,message) values ");
        for (AutoTestRunLogModel autoTestRunLogModel : runLogModels) {
            sqlBuilder.append("(");
            sqlBuilder.append("#{").append(autoTestRunLogModel.getCaseId()).append("},");
            sqlBuilder.append("#{").append(autoTestRunLogModel.getRunStatus()).append("},");
            sqlBuilder.append("#{").append(autoTestRunLogModel.getExecutor()).append("},");
            sqlBuilder.append("#{").append(autoTestRunLogModel.getExecuteTime()).append("},");
            sqlBuilder.append("#{").append(autoTestRunLogModel.getCaseSpendTime()).append("},");
            sqlBuilder.append("#{").append(autoTestRunLogModel.getMessage()).append("}");
            sqlBuilder.append(")");
        }
        return sqlBuilder.toString();
    }
}
