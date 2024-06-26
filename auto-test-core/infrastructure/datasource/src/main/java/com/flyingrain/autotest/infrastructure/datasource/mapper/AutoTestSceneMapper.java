package com.flyingrain.autotest.infrastructure.datasource.mapper;

import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.infrastructure.datasource.mapper.provider.AutoTestSceneProvider;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestSceneCaseModel;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestSceneModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AutoTestSceneMapper {


    @Insert("insert into auto_test_scene (scene_name,config,scene_code,`desc`,operator) values(#{sceneName},#{config},#{sceneCode},#{desc},#{operator})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insert(AutoTestSceneModel autoTestSceneModel);

    @Select("select * from auto_test_scene where id =#{id}")
    @Results(id = "sceneMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "sceneName", column = "scene_name"),
            @Result(property = "sceneCode", column = "scene_code"),
            @Result(property = "desc", column = "desc"),
            @Result(property = "config", column = "config"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time")
    })
    AutoTestSceneModel detail(@Param("id") Integer id);


    @SelectProvider(value = AutoTestSceneProvider.class, method = "pageQuery")
    @ResultMap("sceneMap")
    List<AutoTestSceneModel> queryByPage(@Param("pageQueryModel") PageQuery<AutoTestSceneModel> pageQuery);

    @SelectProvider(value = AutoTestSceneProvider.class, method = "pageQueryCount")
    int queryByPageCount(@Param("pageQueryModel") PageQuery<AutoTestSceneModel> pageQuery);

    @UpdateProvider(value = AutoTestSceneProvider.class, method = "updateById")
    int updateById(@Param("sceneModel") AutoTestSceneModel autoTestSceneModel);

    @Delete("<script>delete from auto_test_scene where id in <foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>#{item}</foreach></script>")
    int batchDel(@Param("ids") List<Integer> ids);

    @Select("<script>select s.id as id,s.scene_code as scene_code,s.scene_name as scene_name,s.operator as operator,s.create_time as create_time,s.update_time as update_time from auto_test_scene s join auto_test_case_scene cs on s.id=cs.scene_id where " +
            "cs.case_id in <foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>#{item}</foreach></script>")
    @ResultMap("sceneMap")
    List<AutoTestSceneModel> queryByCaseId(@Param("ids") List<Integer> caseId);


}
