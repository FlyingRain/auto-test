package com.flyingrain.autotest.infrastructure.datasource.mapper;

import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestSceneCaseModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AutoTestCaseSceneMapper {

    @Insert("insert into auto_test_case_scene (scene_id,case_id,execute_order) values(#{sceneId},#{caseId},#{executeOrder})")
    int addCaseScene(AutoTestSceneCaseModel autoTestSceneCaseModel);


    @Insert("<script>insert into auto_test_case_scene (scene_id,case_id,execute_order) values <foreach item='item' index='index' collection='sceneCaseModels' separator=','> " +
            "   (#{item.sceneId},#{item.caseId},#{item.executeOrder})</foreach></script>")
    int batchInsert(@Param("sceneCaseModels") List<AutoTestSceneCaseModel> autoTestSceneCaseModels);

    @SelectProvider()
    @Results(id = "sceneCaseMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(  property = "caseId", column = "case_id"),
            @Result(  property = "sceneId", column = "scene_id"),
            @Result(  property = "executeOrder", column = "execute_order"),
            @Result(  property = "createTime", column = "create_time"),
            @Result(  property = "updateTime", column = "update_time"),
            }
    )
    List<AutoTestSceneCaseModel> queryPage(PageQuery<AutoTestSceneCaseModel> autoTestSceneCaseModelPageQuery);


}
