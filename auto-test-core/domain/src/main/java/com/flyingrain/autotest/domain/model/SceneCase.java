package com.flyingrain.autotest.domain.model;

import java.util.Date;

public class SceneCase {

    private int id;

    private int caseId;

    private int sceneId;

    private int executeOrder;

    private Case runCase;

    private Date createTime;

    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public int getSceneId() {
        return sceneId;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }

    public int getExecuteOrder() {
        return executeOrder;
    }

    public void setExecuteOrder(int executeOrder) {
        this.executeOrder = executeOrder;
    }

    public Case getRunCase() {
        return runCase;
    }

    public void setRunCase(Case runCase) {
        this.runCase = runCase;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "SceneCase{" +
                "id=" + id +
                ", caseId=" + caseId +
                ", sceneId=" + sceneId +
                ", executeOrder=" + executeOrder +
                ", runCase=" + runCase +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
