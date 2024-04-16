package com.flyingrain.autotest.domain.service.convert;

import com.flyingrain.autotest.domain.model.SceneCase;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestSceneCaseModel;

public class SceneCaseModelConvert {

    public static SceneCase convertToDomain(AutoTestSceneCaseModel autoTestSceneCaseModel) {
        if (autoTestSceneCaseModel == null) {
            return null;
        }
        SceneCase sceneCase = new SceneCase();
        sceneCase.setSceneId(autoTestSceneCaseModel.getSceneId());
        sceneCase.setCaseId(autoTestSceneCaseModel.getCaseId());
        sceneCase.setExecuteOrder(autoTestSceneCaseModel.getExecuteOrder());
        sceneCase.setId(autoTestSceneCaseModel.getId());
        sceneCase.setCreateTime(autoTestSceneCaseModel.getCreateTime());
        sceneCase.setUpdateTime(autoTestSceneCaseModel.getUpdateTime());
        return sceneCase;
    }


    public static AutoTestSceneCaseModel convertToModel(SceneCase sceneCase) {
        if (sceneCase == null) {
            return null;
        }
        AutoTestSceneCaseModel autoTestSceneCaseModel = new AutoTestSceneCaseModel();
        autoTestSceneCaseModel.setId(sceneCase.getId());
        autoTestSceneCaseModel.setCaseId(sceneCase.getCaseId());
        autoTestSceneCaseModel.setSceneId(sceneCase.getSceneId());
        autoTestSceneCaseModel.setExecuteOrder(sceneCase.getExecuteOrder());
        autoTestSceneCaseModel.setCreateTime(sceneCase.getCreateTime());
        autoTestSceneCaseModel.setUpdateTime(sceneCase.getUpdateTime());
        return autoTestSceneCaseModel;
    }
}
