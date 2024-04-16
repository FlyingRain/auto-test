package com.flyingrain.autotest.domain.model;

import java.util.Date;
import java.util.List;

public class Scene {
    private int id;

    private String sceneName;

    private String sceneCode;

    private String config;

    private String desc;


    private String operator;
    private List<SceneCase> sceneCases;

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

    public List<SceneCase> getSceneCases() {
        return sceneCases;
    }

    public void setSceneCases(List<SceneCase> sceneCases) {
        this.sceneCases = sceneCases;
    }

    public String getOperator() {

        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
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

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Scene{" +
                "id=" + id +
                ", sceneName='" + sceneName + '\'' +
                ", sceneCode='" + sceneCode + '\'' +
                ", config='" + config + '\'' +
                ", desc='" + desc + '\'' +
                ", operator='" + operator + '\'' +
                ", sceneCases=" + sceneCases +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
