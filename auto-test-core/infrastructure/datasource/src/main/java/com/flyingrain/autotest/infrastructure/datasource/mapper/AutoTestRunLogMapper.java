package com.flyingrain.autotest.infrastructure.datasource.mapper;

import com.flyingrain.autotest.infrastructure.datasource.mapper.provider.AutoTestRunLogProvider;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestRunLogModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wally
 * @date 2021-12-13
 */
public interface AutoTestRunLogMapper {

    @Insert("insert into auto_test_run_log (case_id,run_status,executor,execute_time,case_spend_time,message) values (#{caseId},#{runStatus},#{executor},#{executeTime},#{caseSpendTime},#{message})")
    int insertRunLog(AutoTestRunLogModel autoTestRunLogModel);

    @InsertProvider(type = AutoTestRunLogProvider.class, method = "insertBatchRunLog")
    int insertRunLogBatch(@Param("runLogs") List<AutoTestRunLogModel> runLogModels);
}
