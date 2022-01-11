package com.flyingrain.autotest.infrastructure.datasource.mapper;

import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestCaseRelationModel;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author wally
 * @date 2021-12-09
 */
public interface AutoTestCaseRelationMapper {


    @Select("select * from auto_test_case_relation where case_id=#{caseId}")
    @Results(id = "caseRelationMap",value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(id = true,property = "caseId",column = "case_id"),
            @Result(id = true,property = "depCaseId",column = "dep_case_id"),
    })
    List<AutoTestCaseRelationModel> queryAllCaseDepByCaseId(long caseId);
}
