package com.flyingrain.autotest.infrastructure.datasource.mapper;

import com.flyingrain.autotest.infrastructure.datasource.model.CityModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CityMapper {

    @Select("select * from city_data where relative_id=#{relativeId}")
    @Results(id = "cityMap",value = {
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "relativeId",column = "relative_id"),
    })
    List<CityModel> queryRelativeCity(@Param("relativeId") Integer relativeId);

}
