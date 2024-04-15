package com.flyingrain.autotest.service.convert;

import com.flyingrain.autotest.domain.model.Scene;
import com.flyingrain.autotest.facade.intf.model.AutoTestScene;
import org.springframework.util.CollectionUtils;

import java.util.stream.Collectors;

public class SceneViewConvert {


    public static Scene convertToModel(AutoTestScene autoTestScene) {
        if (autoTestScene == null) {
            return null;
        }
        Scene scene = new Scene();
        scene.setId(autoTestScene.getId());
        scene.setSceneCode(autoTestScene.getSceneCode());
        scene.setSceneName(autoTestScene.getSceneName());
        scene.setConfig(autoTestScene.getConfig());
        if (!CollectionUtils.isEmpty(autoTestScene.getAutoTestSceneCases())) {
            scene.setSceneCases(autoTestScene.getAutoTestSceneCases().stream().map(SceneCaseViewConvert::convertToModel).collect(Collectors.toList()));
        }
        scene.setDesc(autoTestScene.getDesc());
        scene.setCreateTime(autoTestScene.getCreateTime());
        scene.setUpdateTime(autoTestScene.getUpdateTime());
        return scene;

    }

    public static AutoTestScene convertToView(Scene scene) {
        if (scene == null) {
            return null;
        }
        AutoTestScene autoTestScene = new AutoTestScene();
        autoTestScene.setId(scene.getId());
        autoTestScene.setConfig(scene.getConfig());
        autoTestScene.setSceneCode(scene.getSceneCode());
        autoTestScene.setSceneName(scene.getSceneName());
        autoTestScene.setDesc(scene.getDesc());
        autoTestScene.setCreateTime(scene.getCreateTime());
        autoTestScene.setUpdateTime(scene.getUpdateTime());
        if (!CollectionUtils.isEmpty(scene.getSceneCases())) {
            autoTestScene.setAutoTestSceneCases(scene.getSceneCases().stream().map(SceneCaseViewConvert::convertToView).collect(Collectors.toList()));
        }
        return autoTestScene;
    }


}
