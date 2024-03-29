package com.flyingrain.autotest.facade.intf.testcase;

import com.flyingrain.autotest.facade.intf.model.AutoTestCase;

public class CaseQueryRequest extends AutoTestCase {

    private int sceneId;

    public int getSceneId() {
        return sceneId;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }

    @Override
    public String toString() {
        return "CaseQueryRequest{" +
                "sceneId=" + sceneId +
                '}';
    }
}
