package com.flyingrain.autotest.infrastructure.datasource.mapper;

import com.flyingrain.autotest.infrastructure.datasource.model.CityModel;
import jakarta.ws.rs.QueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CityMapper {

    @Select("select * from city_data where relative_id=#{relativeId}")
    @Results(id = "cityMap",value = {
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "relativeId",column = "relative_id"),
    })
    List<CityModel> queryRelativeCity(@Param("relativeId") Integer relativeId);

    @Select("select * from city_data where `name`=#{cityName}")
    @ResultMap("cityMap")
    CityModel queryCityByName(@QueryParam("cityName") String cityName);


    @Select("select * from city_data where id=#{id}")
    @ResultMap("cityMap")
    CityModel queryCityById(@QueryParam("id") Integer Id);
}
