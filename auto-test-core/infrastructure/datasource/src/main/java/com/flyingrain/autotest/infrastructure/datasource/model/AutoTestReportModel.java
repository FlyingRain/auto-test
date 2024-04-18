package com.flyingrain.autotest.infrastructure.datasource.model;

import java.util.Date;

public class AutoTestReportModel {

    private int id;

    private String batchNum;

    private String title;

    private String env;

    private String desc;

    private long consumeTime;

    private String operator;

    private int runNumber;

    private int caseNumber;

    private int successNumber;

    private String result;

    private Date executeTime;

    private Date createTime;

    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(String batchNum) {
        this.batchNum = batchNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public long getConsumeTime() {
        return consumeTime;
    }

    public void setConsumeTime(long consumeTime) {
        this.consumeTime = consumeTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getRunNumber() {
        return runNumber;
    }

    public void setRunNumber(int runNumber) {
        this.runNumber = runNumber;
    }

    public int getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(int caseNumber) {
        this.caseNumber = caseNumber;
    }

    public int getSuccessNumber() {
        return successNumber;
    }

    public void setSuccessNumber(int successNumber) {
        this.successNumber = successNumber;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Date executeTime) {
        this.executeTime = executeTime;
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
        return "AutoTestReportModel{" +
                "id=" + id +
                ", batchNum='" + batchNum + '\'' +
                ", title='" + title + '\'' +
                ", env='" + env + '\'' +
                ", desc='" + desc + '\'' +
                ", consumeTime=" + consumeTime +
                ", operator='" + operator + '\'' +
                ", runNumber=" + runNumber +
                ", caseNumber=" + caseNumber +
                ", successNumber=" + successNumber +
                ", result='" + result + '\'' +
                ", executeTime=" + executeTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
