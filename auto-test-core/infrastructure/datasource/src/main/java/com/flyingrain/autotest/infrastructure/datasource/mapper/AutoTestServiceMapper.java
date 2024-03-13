package com.flyingrain.autotest.infrastructure.datasource.mapper;

import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.infrastructure.datasource.mapper.provider.ServiceDynamicSqlProvider;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestServiceModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author wally
 * @date 2021-12-08
 */

public interface AutoTestServiceMapper {


    @Select("select * from auto_test_service where id=#{id}")
    @Results(id = "serviceMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "appId", column = "app_id"),
            @Result(property = "serviceCode", column = "service_code"),
            @Result(property = "serviceName", column = "service_name"),
            @Result(property = "protocolType", column = "protocol_type"),
            @Result(property = "requestPath", column = "request_path"),
            @Result(property = "requestType", column = "request_type"),
            @Result(property = "headers", column = "headers"),
            @Result(property = "requestModel", column = "request_model"),
            @Result(property = "responseDataType", column = "response_data_type"),
            @Result(property = "creator", column = "creator"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
    })
    AutoTestServiceModel queryById(@Param("id") int id);

    @Select("<script>select * from auto_test_service where app_id in <foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>#{item}</foreach></script>")
    @ResultMap("serviceMap")
    List<AutoTestServiceModel> queryByAppIds(@Param("ids") List<Integer> ids);


    @SelectProvider(type = ServiceDynamicSqlProvider.class, method = "queryServiceByPage")
    @ResultMap("serviceMap")
    List<AutoTestServiceModel> queryByPage(@Param("condition") PageQuery<AutoTestServiceModel> pageQuery);


    @SelectProvider(type = ServiceDynamicSqlProvider.class, method = "countServiceByPage")
    int countByPage(@Param("condition") PageQuery<AutoTestServiceModel> pageQuery);


    @Insert("insert into auto_test_service(service_name,service_code,protocol_type,request_path,headers,request_type,response_data_type,app_id,creator) " +
            "values(#{serviceName},#{serviceCode},#{protocolType},#{requestPath},#{headers},#{requestType},#{responseDataType},#{appId},#{creator})")
    int insertServiceModel(AutoTestServiceModel autoTestServiceModel);


    @UpdateProvider(type = ServiceDynamicSqlProvider.class, method = "updateServiceById")
    int updateServiceById(@Param("service") AutoTestServiceModel autoTestServiceModel);


    @Delete({"<script>delete from auto_test_service where id in <foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>#{item}</foreach></script>"})
    int batchDelete(@Param("ids") List<Integer> serviceIds);
}
