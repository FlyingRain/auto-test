package com.flyingrain.autotest.infrastructure.datasource.mapper;

import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.infrastructure.datasource.mapper.provider.AutoTestReportDynamicSqlProvider;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestReportModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AutoTestReportMapper {


    @Select("select * from auto_test_report where id = #{id}")
    @Results(id = "reportMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "batchNum", column = "batch_num"),
            @Result(property = "title", column = "title"),
            @Result(property = "env", column = "env"),
            @Result(property = "desc", column = "desc"),
            @Result(property = "consumeTime", column = "consume_time"),
            @Result(property = "operator", column = "operator"),
            @Result(property = "runNumber", column = "run_number"),
            @Result(property = "caseNumber", column = "case_number"),
            @Result(property = "successNumber", column = "success_number"),
            @Result(property = "result", column = "result"),
            @Result(property = "executeTime", column = "execute_time"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time")
    })
    AutoTestReportModel detail(@Param("id") int id);


    @Insert("insert into auto_test_report(batch_num,title,env,desc,consume_time,operator,run_number,case_number,success_number,result,execute_time,create_time,update_time) values " +
            "(#{batchNum},#{title},#{env},#{desc},#{consumTime},#{operator},#{runNumber},#{caseNumber},#{successNumber},#{result},#{executeTime},#{createTime},#{updateTime})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insert(AutoTestReportModel autoTestReportModel);


    @SelectProvider(value = AutoTestReportDynamicSqlProvider.class, method = "queryByPage")
    @ResultMap("reportMap")
    List<AutoTestReportModel> queryByPage(@Param("queryModel") PageQuery<AutoTestReportModel> pageQuery);


    @SelectProvider(value = AutoTestReportDynamicSqlProvider.class, method = "queryByPageCount")
    int queryByPageCount(@Param("queryModel") PageQuery<AutoTestReportModel> pageQuery);


    @UpdateProvider(value = AutoTestReportDynamicSqlProvider.class, method = "updateReportById")
    int updateReport(@Param("reportModel") AutoTestReportModel autoTestReportModel);

}
