package com.flyingrain.autotest.facade.intf.model;

import com.flyingrain.autotest.domain.model.Case;

import java.util.Date;

public class AutoTestRunLog {

    private int id;

    private String runStatus;

    private String runResult;

    private String message;

    private String caseCode;

    private String executor;

    private String batchNum;

    private Date executeTime;

    private long spendTime;

    private Date createTime;

    private Date updateTime;

    private Case aCase;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRunStatus() {
        return runStatus;
    }

    public String getRunResult() {
        return runResult;
    }

    public void setRunResult(String runResult) {
        this.runResult = runResult;
    }

    public void setRunStatus(String runStatus) {
        this.runStatus = runStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCaseCode() {
        return caseCode;
    }

    public void setCaseCode(String caseCode) {
        this.caseCode = caseCode;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public String getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(String batchNum) {
        this.batchNum = batchNum;
    }

    public Date getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Date executeTime) {
        this.executeTime = executeTime;
    }

    public long getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(long spendTime) {
        this.spendTime = spendTime;
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
        return "AutoTestRunLog{" +
                "id=" + id +
                ", runStatus='" + runStatus + '\'' +
                ", message='" + message + '\'' +
                ", caseCode='" + caseCode + '\'' +
                ", executor='" + executor + '\'' +
                ", batchNum='" + batchNum + '\'' +
                ", executeTime=" + executeTime +
                ", spendTime=" + spendTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", aCase=" + aCase +
                '}';
    }
}
