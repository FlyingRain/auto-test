package com.flyingrain.autotest.infrastructure.datasource.mapper;

import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.infrastructure.datasource.mapper.provider.AutoTestSourceConfigDynamicSqlProvider;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestSourceConfigModel;
import jakarta.ws.rs.DELETE;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AutoTestSourceConfigMapper {

    @Insert("insert into auto_test_source_config (`name`,code,config,source_type,operator) values(#{sourceConfig.name},#{sourceConfig.code},#{sourceConfig.config},#{sourceConfig.sourceType},#{sourceConfig.operator})")
    int insertSourceConfig(@Param("sourceConfig") AutoTestSourceConfigModel autoTestSourceConfigModel);

    @Select("select * from auto_test_source_config")
    @Results(id = "sourceMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "code", column = "code"),
            @Result(property = "config", column = "config"),
            @Result(property = "sourceType", column = "source_type"),
            @Result(property = "operator", column = "operator"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
    })
    List<AutoTestSourceConfigModel> queryAll();

    @SelectProvider(value = AutoTestSourceConfigDynamicSqlProvider.class, method = "pageQuery")
    @ResultMap("sourceMap")
    List<AutoTestSourceConfigModel> queryPage(@Param("queryModel") PageQuery<AutoTestSourceConfigModel> pageQuery);


    @SelectProvider(value = AutoTestSourceConfigDynamicSqlProvider.class, method = "pageQueryCount")
    int queryPageCount(@Param("queryModel") PageQuery<AutoTestSourceConfigModel> pageQuery);

    @UpdateProvider(value = AutoTestSourceConfigDynamicSqlProvider.class, method = "updateById")
    int updateById(@Param("updateModel") AutoTestSourceConfigModel autoTestSourceConfigModel);

    @Select("select * from auto_test_source_config where id =#{id}")
    @ResultMap("sourceMap")
    AutoTestSourceConfigModel queryDetail(@Param("id") Integer id);

    @Delete("<script>delete from auto_test_source_config where id in <foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>#{item}</foreach></script>")
    int batchDel(List<Integer> ids);
}
