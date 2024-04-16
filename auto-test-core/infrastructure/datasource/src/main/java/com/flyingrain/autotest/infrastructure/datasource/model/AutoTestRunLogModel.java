package com.flyingrain.autotest.infrastructure.datasource.model;

import java.util.Date;

/**
 * @author wally
 * @date 2021-12-08
 */
public class AutoTestRunLogModel {

    private int id;

    private String  caseCode;

    private String runStatus;

    private String batchNum;

    private String executor;

    private String runResult;

    private Date executeTime;

    private long caseSpendTime;

    private String message;

    private Date createTime;

    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaseCode() {
        return caseCode;
    }

    public void setCaseCode(String caseCode) {
        this.caseCode = caseCode;
    }

    public String getRunResult() {
        return runResult;
    }

    public void setRunResult(String runResult) {
        this.runResult = runResult;
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
                ", caseCode=" + caseCode +
                ", runStatus='" + runStatus + '\'' +
                ", batchNum='" + batchNum + '\'' +
                ", executor='" + executor + '\'' +
                ", runResult='" + runResult + '\'' +
                ", executeTime=" + executeTime +
                ", caseSpendTime=" + caseSpendTime +
                ", message='" + message + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
