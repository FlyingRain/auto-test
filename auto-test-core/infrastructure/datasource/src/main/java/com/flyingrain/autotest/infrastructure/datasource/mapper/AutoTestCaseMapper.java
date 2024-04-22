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
            @Result(property = "code", column = "code"),
            @Result(property = "serviceId", column = "service_id"),
            @Result(property = "caseStatus", column = "case_status"),
            @Result(property = "desc", column = "desc"),
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
    int queryByPageCount(@Param("queryCondition") PageQuery<AutoTestCaseQuery> autoTestCaseQuery);

    @UpdateProvider(type = AutoTestCaseDynamicSqlProvider.class,method = "updateCase")
    int updateCaseById(@Param("caseModel") AutoTestCaseModel autoTestCaseModel);

    @Insert("insert into auto_test_case (name,code,service_id,case_status,`desc`,check_point_config,result_collect_config,param_value,modifier,creator) values " +
            "(#{caseModel.name},#{caseModel.code},#{caseModel.serviceId},#{caseModel.caseStatus},#{caseModel.desc},#{caseModel.checkPointConfig},#{caseModel.resultCollectConfig},#{caseModel.paramValue},#{caseModel.modifier},#{caseModel.creator})")
    int insertCase(@Param("caseModel") AutoTestCaseModel autoTestCaseModel);


    @Delete("<script>delete from auto_test_case where id in <foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>#{item}</foreach></script>")
    int batchDel(@Param("ids") List<Integer> ids);

    @Select("<script>select *  from auto_test_case where id in <foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>#{item}</foreach></script>")
    @ResultMap("caseMap")
    List<AutoTestCaseModel> queryCaseByIds(@Param("ids") List<Integer> caseIds);


    @Select("<script>select *  from auto_test_case where service_id in <foreach item='item' index='index' collection='serviceIds' open='(' separator=',' close=')'>#{item}</foreach></script>")
    @ResultMap("caseMap")
    List<AutoTestCaseModel> queryByServiceIds(@Param("serviceIds")List<Integer> serviceIds);
}
