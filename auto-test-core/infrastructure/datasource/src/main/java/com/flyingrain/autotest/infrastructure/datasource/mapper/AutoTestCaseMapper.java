package com.flyingrain.autotest.infrastructure.datasource.mapper;

import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.infrastructure.datasource.AutoTestCaseQuery;
import com.flyingrain.autotest.infrastructure.datasource.mapper.provider.AutoTestCaseDynamicSqlProvider;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestCaseModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author wally
 * @date 2021-12-08
 */
public interface AutoTestCaseMapper {


    @Select("select * from auto_test_case where service_id=#{serviceId}")
    @Results(id = "caseMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "serviceId", column = "service_id"),
            @Result(property = "caseStatus", column = "case_status"),
            @Result(property = "checkPointConfig", column = "check_point_config"),
            @Result(property = "paramValue", column = "param_value"),
            @Result(property = "resultCollectConfig", column = "result_collect_config"),
            @Result(property = "modifier", column = "modifier"),
            @Result(property = "creator", column = "creator"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
    })
    List<AutoTestCaseModel> queryByServiceId(long serviceId);

    @Select("select * from auto_test_case where id=#{caseId}")
    @ResultMap(value = "caseMap")
    AutoTestCaseModel queryCaseById(long caseId);


    @SelectProvider(type = AutoTestCaseDynamicSqlProvider.class,method = "queryByPage")
    @ResultMap(value = "caseMap")
    List<AutoTestCaseModel> queryByPage(@Param("queryCondition") PageQuery<AutoTestCaseQuery> queryCondition);


    @SelectProvider(type = AutoTestCaseDynamicSqlProvider.class,method = "pageCount")
    int queryByPageCount(@Param("caseModel") AutoTestCaseQuery autoTestCaseQuery);

    @UpdateProvider(type = AutoTestCaseDynamicSqlProvider.class,method = "updateCase")
    int updateCaseById(@Param("caseModel") AutoTestCaseModel autoTestCaseModel);

}
