package com.flyingrain.autotest.domain.model;

import java.util.Date;

/**
 * @author wally
 * @date 2021-12-13
 */
public class RunLog {

    private int id;

    private int  caseId;

    private String runStatus;

    private String executor;

    private String batchNum;

    private Date executeTime;

    private String runResult;

    private long caseSpendTime;

    private String message;

    private Date createTime;

    private Date updateTime;

    private Case aCase;

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

    public String getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(String batchNum) {
        this.batchNum = batchNum;
    }

    public String getRunStatus() {
        return runStatus;
    }

    public void setRunStatus(String runStatus) {
        this.runStatus = runStatus;
    }

    public String getRunResult() {
        return runResult;
    }

    public void setRunResult(String runResult) {
        this.runResult = runResult;
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

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Case getaCase() {
        return aCase;
    }

    public void setaCase(Case aCase) {
        this.aCase = aCase;
    }

    @Override
    public String toString() {
        return "RunLog{" +
                "id=" + id +
                ", caseId=" + caseId +
                ", runStatus='" + runStatus + '\'' +
                ", executor='" + executor + '\'' +
                ", batchNum='" + batchNum + '\'' +
                ", executeTime=" + executeTime +
                ", runResult='" + runResult + '\'' +
                ", caseSpendTime=" + caseSpendTime +
                ", message='" + message + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", aCase=" + aCase +
                '}';
    }
}
