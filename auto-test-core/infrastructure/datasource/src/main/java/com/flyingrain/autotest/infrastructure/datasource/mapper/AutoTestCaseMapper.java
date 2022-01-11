package com.flyingrain.autotest.infrastructure.datasource.mapper;

import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestCaseModel;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

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
            @Result(property = "data", column = "data"),
            @Result(property = "caseStatus", column = "case_status"),
            @Result(property = "depCaseId", column = "dep_case_id"),
            @Result(property = "result", column = "result"),
            @Result(property = "checkPoint", column = "check_point"),
            @Result(property = "creator", column = "creator"),
            @Result(property = "priority", column = "priority"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
    })
    List<AutoTestCaseModel> queryByServiceId(long serviceId);

    @Select("select * from auto_test_case where id=#{caseId}")
    @ResultMap(value = "caseMap")
    AutoTestCaseModel queryCaseById(long caseId);


    @Select("select atc.id as id,atc.name as name,atc.service_id as service_id,atc.data as data,atc.case_status as case_status" +
            ",atc.dep_case_id as dep_case_id,atc.result as result,atc.check_point as check_point,atc.creator as creator from auto_test_case atc left join auto_test_case_relation atcr on atc.id=atcr.case_id where atc.id=#{caseId}")
    @ResultMap(value = "caseMap")
    List<AutoTestCaseModel> queryDepCases(long caseId);
}
