package com.flyingrain.autotest.domain.model;

import com.flyingrain.autotest.domain.model.RunLog;

import java.util.Date;
import java.util.List;

public class ExecuteReport {

    private int id;

    private String batchNum;
    private String operator;

    private int caseNumber;

    private String title;

    private String env;

    private long consumeTime;

    private String desc;
    //实际执行数量，有时会因为中间用例异常而中断，所以一定是小于等于caseNumber
    private int runNumber;

    private int successNumber;

    private String result;

    private List<RunLog> runLogs;

    private Date executeTime;

    private Date createTime;

    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<RunLog> getRunLogs() {
        return runLogs;
    }

    public void setRunLogs(List<RunLog> runLogs) {
        this.runLogs = runLogs;
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

    public long getConsumeTime() {
        return consumeTime;
    }

    public void setConsumeTime(long consumeTime) {
        this.consumeTime = consumeTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "ExecuteReport{" +
                "id=" + id +
                ", batchNum='" + batchNum + '\'' +
                ", operator='" + operator + '\'' +
                ", caseNumber=" + caseNumber +
                ", title='" + title + '\'' +
                ", env='" + env + '\'' +
                ", consumeTime=" + consumeTime +
                ", desc='" + desc + '\'' +
                ", runNumber=" + runNumber +
                ", successNumber=" + successNumber +
                ", result='" + result + '\'' +
                ", runLogs=" + runLogs +
                ", executeTime=" + executeTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
