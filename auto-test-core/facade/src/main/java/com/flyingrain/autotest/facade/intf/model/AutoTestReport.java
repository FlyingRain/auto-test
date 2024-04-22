package com.flyingrain.autotest.facade.intf.model;

import java.util.Date;
import java.util.List;

public class AutoTestReport {

    private int id;

    private String batchNum;

    private int caseNumber;

    private String env;

    private int successNumber;

    private int runNumber;

    private String title;

    private String desc;

    private String operator;

    private Date createTime;

    private Date updateTime;

    private Date executeTime;

    private long consumeTime;

    private String result;

    private List<AutoTestRunLog> runLogs;


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

    public int getRunNumber() {
        return runNumber;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public void setRunNumber(int runNumber) {
        this.runNumber = runNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public Date getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Date executeTime) {
        this.executeTime = executeTime;
    }

    public long getConsumeTime() {
        return consumeTime;
    }

    public void setConsumeTime(long consumeTime) {
        this.consumeTime = consumeTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<AutoTestRunLog> getRunLogs() {
        return runLogs;
    }

    public void setRunLogs(List<AutoTestRunLog> runLogs) {
        this.runLogs = runLogs;
    }

    @Override
    public String toString() {
        return "AutoTestReport{" +
                "id=" + id +
                ", batchNum='" + batchNum + '\'' +
                ", case_number=" + caseNumber +
                ", env='" + env + '\'' +
                ", success_number=" + successNumber +
                ", run_number=" + runNumber +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", operator='" + operator + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", executeTime=" + executeTime +
                ", consumeTime=" + consumeTime +
                ", result='" + result + '\'' +
                '}';
    }
}
