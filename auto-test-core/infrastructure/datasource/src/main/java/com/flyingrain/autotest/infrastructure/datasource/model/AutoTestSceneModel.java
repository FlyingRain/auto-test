package com.flyingrain.autotest.infrastructure.datasource.model;

import java.util.Date;

public class AutoTestSceneModel {

    private int id;

    private String sceneName;

    private String sceneCode;

    private String desc;

    private String config;

    private Date createTime;

    private Date updateTime;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSceneName() {
        return sceneName;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }

    public String getSceneCode() {
        return sceneCode;
    }

    public void setSceneCode(String sceneCode) {
        this.sceneCode = sceneCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    @Override
    public String toString() {
        return "AutoTestSceneModel{" +
                "id=" + id +
                ", sceneName='" + sceneName + '\'' +
                ", sceneCode='" + sceneCode + '\'' +
                ", desc='" + desc + '\'' +
                ", config='" + config + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
