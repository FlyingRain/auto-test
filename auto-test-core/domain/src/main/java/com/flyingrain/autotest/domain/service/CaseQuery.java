package com.flyingrain.autotest.domain.service;

import com.flyingrain.autotest.domain.model.Case;

public class CaseQuery extends Case {

    private int sceneId;

    private int appId;

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public int getSceneId() {
        return sceneId;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }
}
