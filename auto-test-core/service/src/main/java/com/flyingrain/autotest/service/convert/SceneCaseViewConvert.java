package com.flyingrain.autotest.service.convert;

import com.flyingrain.autotest.domain.model.SceneCase;
import com.flyingrain.autotest.facade.intf.model.AutoTestSceneCase;

public class SceneCaseViewConvert {


    public static AutoTestSceneCase convertToView(SceneCase sceneCase) {
        if (sceneCase == null) {
            return null;
        }
        AutoTestSceneCase autoTestSceneCase = new AutoTestSceneCase();
        autoTestSceneCase.setCaseId(sceneCase.getCaseId());
        autoTestSceneCase.setId(sceneCase.getId());
        autoTestSceneCase.setExecuteOrder(sceneCase.getExecuteOrder());
        autoTestSceneCase.setCreateTime(sceneCase.getCreateTime());
        autoTestSceneCase.setUpdateTime(sceneCase.getUpdateTime());
        autoTestSceneCase.setAutoTestCase(CaseViewConvert.convertCaseModel(sceneCase.getRunCase()));
        return autoTestSceneCase;
    }

    public static SceneCase convertToModel(AutoTestSceneCase autoTestSceneCase) {
        if (autoTestSceneCase == null) {
            return null;
        }
        SceneCase sceneCase = new SceneCase();
        sceneCase.setId(autoTestSceneCase.getId());
        sceneCase.setSceneId(autoTestSceneCase.getSceneId());
        sceneCase.setRunCase(CaseViewConvert.convertCaseView(autoTestSceneCase.getAutoTestCase()));
        sceneCase.setCaseId(autoTestSceneCase.getCaseId());
        sceneCase.setExecuteOrder(autoTestSceneCase.getExecuteOrder());
        sceneCase.setCreateTime(autoTestSceneCase.getCreateTime());
        sceneCase.setUpdateTime(autoTestSceneCase.getUpdateTime());
        return sceneCase;
    }


}
