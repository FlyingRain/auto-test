package com.flyingrain.autotest.infrastructure.datasource.model;

import java.util.Date;

/**
 * @author wally
 * @date 2021-12-08
 */
public class AutoTestRunLogModel {

    private long id;

    private long  caseId;

    private String runStatus;

    private String batchNum;

    private String executor;

    private Date executeTime;

    private long caseSpendTime;

    private String message;

    private Date createTime;

    private Date updateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCaseId() {
        return caseId;
    }

    public void setCaseId(long caseId) {
        this.caseId = caseId;
    }

    public String getRunStatus() {
        return runStatus;
    }

    public void setRunStatus(String runStatus) {
        this.runStatus = runStatus;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public Date getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Date executeTime) {
        this.executeTime = executeTime;
    }

    public long getCaseSpendTime() {
        return caseSpendTime;
    }

    public void setCaseSpendTime(long caseSpendTime) {
        this.caseSpendTime = caseSpendTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public String getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(String batchNum) {
        this.batchNum = batchNum;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "AutoTestRunLogModel{" +
                "id=" + id +
                ", caseId=" + caseId +
                ", runStatus='" + runStatus + '\'' +
                ", batchNum='" + batchNum + '\'' +
                ", executor='" + executor + '\'' +
                ", executeTime=" + executeTime +
                ", caseSpendTime=" + caseSpendTime +
                ", message='" + message + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
