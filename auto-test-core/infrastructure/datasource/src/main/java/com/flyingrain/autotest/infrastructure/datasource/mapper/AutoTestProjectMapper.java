package com.flyingrain.autotest.infrastructure.datasource.mapper;

import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestProjectModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author wally
 * @date 2021-12-08
 */
public interface AutoTestProjectMapper {

    @Select("select * from auto_test_project")
    @Results(id = "projectMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "projectCode", column = "project_code"),
            @Result(property = "projectName", column = "project_name"),
            @Result(property = "status", column = "status"),
            @Result(property = "owner", column = "owner"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
    })
    List<AutoTestProjectModel> queryAllProject();


    @Select("select * from auto_test_project where project_code=#{projectCode}")
    @ResultMap(value = "projectMap")
    AutoTestProjectModel queryByProjectCode(@Param("projectCode") String projectCode);

    @Select("select * from auto_test_project where project_id=#{projectId}")
    @ResultMap(value = "projectMap")
    AutoTestProjectModel queryProjectById(@Param("projectId")long projectId);
}
