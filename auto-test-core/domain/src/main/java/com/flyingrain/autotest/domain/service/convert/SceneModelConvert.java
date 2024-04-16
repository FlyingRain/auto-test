package com.flyingrain.autotest.domain.service.convert;

import com.flyingrain.autotest.domain.model.Scene;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestSceneModel;

public class SceneModelConvert {

    public static Scene convertToDomain(AutoTestSceneModel autoTestSceneModel) {
        if (autoTestSceneModel == null) {
            return null;
        }
        Scene scene = new Scene();
        scene.setId(autoTestSceneModel.getId());
        scene.setOperator(autoTestSceneModel.getOperator());
        scene.setDesc(autoTestSceneModel.getDesc());
        scene.setConfig(autoTestSceneModel.getConfig());
        scene.setSceneName(autoTestSceneModel.getSceneName());
        scene.setSceneCode(autoTestSceneModel.getSceneCode());
        scene.setCreateTime(autoTestSceneModel.getCreateTime());
        scene.setUpdateTime(autoTestSceneModel.getUpdateTime());
        return scene;
    }

    public static AutoTestSceneModel convertToModel(Scene scene) {
        if (scene == null) {
            return null;
        }
        AutoTestSceneModel autoTestSceneModel = new AutoTestSceneModel();
        autoTestSceneModel.setId(scene.getId());
        autoTestSceneModel.setConfig(scene.getConfig());
        autoTestSceneModel.setSceneCode(scene.getSceneCode());
        autoTestSceneModel.setSceneName(scene.getSceneName());
        autoTestSceneModel.setDesc(scene.getDesc());
        autoTestSceneModel.setCreateTime(scene.getCreateTime());
        autoTestSceneModel.setUpdateTime(scene.getUpdateTime());
        autoTestSceneModel.setOperator(scene.getOperator());
        return autoTestSceneModel;
    }


}
