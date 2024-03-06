package com.flyingrain.autotest.infrastructure.datasource.mapper;

import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestLoginModel;
import org.apache.ibatis.annotations.*;

public interface AutoTestLoginMapper {

    @Select("select * from auto_test_login where user_id=#{user_id} and status = #{status}")
    @Results(id = "loginMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "token", column = "token"),
            @Result(property = "status", column = "status"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
    })
    AutoTestLoginModel queryUserToken(@Param("userId") int userId, @Param("status") int status);


    @Insert("insert into auto_test_login(user_id,token,status) values (#{userId},#{token},#{status})")
    int insertLogin(AutoTestLoginModel loginModel);


    @Select("select * from auto_test_login where token=#{token} and status=1")
    @ResultMap("loginMap")
    AutoTestLoginModel queryByToken(@Param("token") String token);


    @Update("update auto_test_login set status=0 where user_id = #{userId}")
    void expireToken(@Param("userId") int userId);

}
