package com.flyingrain.autotest.infrastructure.datasource.mapper;

import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.infrastructure.datasource.mapper.provider.AutoTestRunLogProvider;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestRunLogModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author wally
 * @date 2021-12-13
 */
public interface AutoTestRunLogMapper {

    @Insert("insert into auto_test_run_log (case_id,run_status,batch_num,executor,execute_time,run_result,case_spend_time,message) values (#{caseId},#{runStatus},#{batchNum},#{executor},#{executeTime},#{runResult},#{caseSpendTime},#{message})")
    int insertRunLog(AutoTestRunLogModel autoTestRunLogModel);

    @Insert("<script>insert into auto_test_run_log (case_id,run_status,batch_num,executor,execute_time,run_result,case_spend_time,message) values <foreach item='item' index='index' collection='runLogs' separator=','>" +
            "(#{item.caseId},#{item.runStatus},#{item.batchNum},#{item.executor},#{item.executeTime},#{item.runResult},#{item.caseSpendTime},#{item.message})</foreach></script>")
    int insertRunLogBatch(@Param("runLogs") List<AutoTestRunLogModel> runLogModels);

    @SelectProvider(value = AutoTestRunLogProvider.class,method = "pageQuery")
    @Results(id = "runLogMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "runStatus", column = "run_status"),
            @Result(property = "caseId", column = "case_id"),
            @Result(property = "batchNum", column = "batch_num"),
            @Result(property = "executor", column = "executor"),
            @Result(property = "executeTime", column = "execute_time"),
            @Result(property = "runResult", column = "run_result"),
            @Result(property = "caseSpendTime", column = "case_spend_time"),
            @Result(property = "message", column = "message"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
    })
    List<AutoTestRunLogModel> queryRunLogByPage(@Param("pageQuery") PageQuery<AutoTestRunLogModel> pageQuery);


    @SelectProvider(value = AutoTestRunLogProvider.class,method = "pageQueryCount")
    int queryRunLogByPageCount(@Param("pageQuery") PageQuery<AutoTestRunLogModel> pageQuery);

    @Select("select * from auto_test_run_log where id =#{id}")
    @ResultMap("runLogMap")
    AutoTestRunLogModel queryDetail(@Param("id") Integer id);
}
