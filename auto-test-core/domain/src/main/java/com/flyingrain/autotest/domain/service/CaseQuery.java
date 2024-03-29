package com.flyingrain.autotest.domain.service;

import com.flyingrain.autotest.domain.model.Case;

public class CaseQuery extends Case {

    private int sceneId;

    public int getSceneId() {
        return sceneId;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }
}
