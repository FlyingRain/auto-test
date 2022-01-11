package com.flyingrain.autotest.infrastructure.datasource.mapper;

import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestModuleModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AutoTestModuleMapper {

    @Select("select * from auto_test_module where project_id=#{projectId}")
    @Results(id = "autoTestModuleModel", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "moduleName", column = "module_name"),
            @Result(property = "moduleUrl", column = "module_url"),
            @Result(property = "mvnDep", column = "mvn_dep"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "projectId", column = "project_id"),
    })
    List<AutoTestModuleModel> queryAllModule(@Param("projectId") long projectId);

}
