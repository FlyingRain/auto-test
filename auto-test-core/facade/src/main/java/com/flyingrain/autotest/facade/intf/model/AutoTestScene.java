package com.flyingrain.autotest.facade.intf.model;

import java.util.Date;
import java.util.List;

public class AutoTestScene {

    private int id;

    private String sceneCode;

    private String sceneName;

    private String config;

    private List<AutoTestSceneCase> autoTestSceneCases;

    private String desc;

    private Date createTime;

    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSceneCode() {
        return sceneCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setSceneCode(String sceneCode) {
        this.sceneCode = sceneCode;
    }

    public String getSceneName() {
        return sceneName;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
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

    public List<AutoTestSceneCase> getAutoTestSceneCases() {
        return autoTestSceneCases;
    }

    public void setAutoTestSceneCases(List<AutoTestSceneCase> autoTestSceneCases) {
        this.autoTestSceneCases = autoTestSceneCases;
    }

    @Override
    public String toString() {
        return "AutoTestScene{" +
                "id=" + id +
                ", sceneCode='" + sceneCode + '\'' +
                ", sceneName='" + sceneName + '\'' +
                ", config='" + config + '\'' +
                ", autoTestSceneCases=" + autoTestSceneCases +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
