package com.flyingrain.autotest.infrastructure.datasource.mapper;

import com.flyingrain.autotest.infrastructure.datasource.mapper.provider.ServiceParamDynamicSqlProvider;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestServiceParamModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AutoTestServiceParamMapper {

    @Select("select * from service_param where id =#{id}")
    @Results(id = "paramMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "service_id", column = "serviceId"),
            @Result(property = "param", column = "param"),
            @Result(property = "desc", column = "desc"),
            @Result(property = "create_time", column = "createTime"),
            @Result(property = "update_time", column = "updateTime"),
    })
    AutoTestServiceParamModel queryParamById(@Param("id") Integer id);


    @InsertProvider(type = ServiceParamDynamicSqlProvider.class,method = "batchInsert")
    int batchInsert(@Param("serviceParams") List<AutoTestServiceParamModel> autoTestServiceParamModels);


    @Select("select *from service_param where service_id=#{serviceId}")
    @ResultMap("paramMap")
    List<AutoTestServiceParamModel> queryServiceParams(@Param("serviceId") Integer serviceId);

    @Delete("delete from service_param where service_id = #{serviceId}")
    int deleteServiceParams(@Param("serviceId") Integer serviceId);

}
