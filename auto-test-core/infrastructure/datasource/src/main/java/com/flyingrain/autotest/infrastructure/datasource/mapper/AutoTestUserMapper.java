package com.flyingrain.autotest.infrastructure.datasource.mapper;

import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestUserModel;
import org.apache.ibatis.annotations.*;

public interface AutoTestUserMapper {


    @Select("select * from auto_test_user where user_name=#{userName} and password = #{password}")
    @Results(id = "userMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "password", column = "password"),
            @Result(property = "department", column = "department"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
    })
    AutoTestUserModel queryByUserNamePassword(@Param("userName") String userName, @Param("password") String password);


    @Insert("insert into auto_test_user (user_name,password,department) values (#{userName},#{password},#{department})")
    int insertUser(AutoTestUserModel autoTestUserModel);


    @Update("update auto_test_user set password=#{password} where user_name=#{userName}")
    int modifyPassword(String userName, String password);

    @Select("select * from auto_test_user where user_id= #{userId}")
    @ResultMap("userMap")
    AutoTestUserModel queryByUserId(@Param("userId") int userId);

}
