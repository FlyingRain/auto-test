package com.flyingrain.autotest.infrastructure.datasource.mapper;

import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestServiceModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author wally
 * @date 2021-12-08
 */

public interface AutoTestServiceMapper {


    @Select("select * from auto_test_service where module_id=#{moduleId}")
    @Results(id = "serviceMap",value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "moduleId",column = "module_id"),
            @Result(property = "serviceCode",column = "service_code"),
            @Result(property = "name",column = "name"),
            @Result(property = "protocolType",column = "protocol_type"),
            @Result(property = "requestUrl",column = "request_url"),
            @Result(property = "requestType",column = "request_type"),
            @Result(property = "requestDataType",column = "request_data_type"),
            @Result(property = "requestDataModule",column = "request_data_module"),
            @Result(property = "responseDataType",column = "response_data_type"),
            @Result(property = "creator",column = "creator"),
            @Result(property = "createTime",column = "create_time"),
            @Result(property = "updateTime",column = "update_time"),
    })
    List<AutoTestServiceModel> queryServiceByModuleId(@Param("moduleId") long moduleId);




}
