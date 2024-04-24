package com.flyingrain.autotest.infrastructure.datasource.mapper;

import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.infrastructure.datasource.mapper.provider.AutoTestGlobalConfigDynamicSqlProvider;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestGlobalConfigModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AutoTestGlobalConfigMapper {


    @Insert("insert into (param_value,param_key,param_name,operator) values(#{paramValue},#{paramKey},#{paramName},#{operator})")
    int insert(AutoTestGlobalConfigModel autoTestGlobalConfigModel);

    @SelectProvider(value = AutoTestGlobalConfigDynamicSqlProvider.class,method = "queryByPage")
    @Results(id = "globalMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "paramValue", column = "param_value"),
            @Result(property = "paramKey", column = "param_key"),
            @Result(property = "paramName", column = "param_name"),
            @Result(property = "operator", column = "operator"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
    })
    List<AutoTestGlobalConfigModel> queryByPage(@Param("pageQuery") PageQuery<AutoTestGlobalConfigModel> pageQuery);

    @SelectProvider(value = AutoTestGlobalConfigDynamicSqlProvider.class,method = "queryByPageCount")
    int queryByPageCount(@Param("pageQuery") PageQuery<AutoTestGlobalConfigModel> pageQuery);


    @UpdateProvider(value = AutoTestGlobalConfigDynamicSqlProvider.class,method = "updateById")
    int updateById(@Param("globalModel") AutoTestGlobalConfigModel autoTestGlobalConfigModel);

    @Delete("<script>delete from auto_test_global_config where id in <foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>#{item}</foreach></script>")
    int batchDel(@Param("ids") List<Integer> ids);

}
