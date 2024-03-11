package com.flyingrain.autotest.infrastructure.datasource.mapper;

import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.infrastructure.datasource.mapper.provider.AppDynamicSqlProvider;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestApplicationModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AutoTestAppMapper {

    @Select("select * from auto_test_application where id=#{id}")
    @Results(id = "appMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "appName", column = "app_name"),
            @Result(property = "appCode", column = "app_code"),
            @Result(property = "desc", column = "desc"),
            @Result(property = "owner", column = "owner"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
    })
    AutoTestApplicationModel queryByServiceId(@Param("id") int serviceId);


    @SelectProvider(type = AppDynamicSqlProvider.class,method = "queryByPage")
    @ResultMap("appMap")
    List<AutoTestApplicationModel> queryByPage(@Param("pageCondition")PageQuery<AutoTestApplicationModel> query);

    @SelectProvider(type = AppDynamicSqlProvider.class,method = "pageCount")
    int pageCount(@Param("pageCondition")PageQuery<AutoTestApplicationModel> query);


    @Insert("insert into auto_test_application (app_name,app_code,desc,owner)values (#{appName},#{appCode},#{desc},#{owner})")
    int insertApp(AutoTestApplicationModel autoTestApplicationModel);

    @Delete("delete from auto_test_application where id in #{ids}")
    int batchDel(@Param("ids") List<Integer> ids);

}
