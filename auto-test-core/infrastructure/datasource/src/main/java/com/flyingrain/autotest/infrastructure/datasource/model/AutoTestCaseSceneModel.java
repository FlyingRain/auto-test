package com.flyingrain.autotest.infrastructure.datasource.model;

import java.util.Date;

public class AutoTestCaseSceneModel {

    private int id;

    private int sceneId;

    private int caseId;

    private int executeOrder ;

    private String operator;

    private Date createTime;

    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSceneId() {
        return sceneId;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public int getExecuteOrder() {
        return executeOrder;
    }

    public void setExecuteOrder(int executeOrder) {
        this.executeOrder = executeOrder;
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

    @Override
    public String toString() {
        return "AutoTestCaseSceneModel{" +
                "id=" + id +
                ", sceneId=" + sceneId +
                ", caseId=" + caseId +
                ", executeOrder=" + executeOrder +
                ", operator='" + operator + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
