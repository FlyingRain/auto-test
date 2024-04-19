package com.flyingrain.autotest.facade.intf.model;

import java.util.Date;

public class AutoTestReport {

    private int id;

    private String batchNum;

    private int case_number;

    private String env;

    private int success_number;

    private int run_number;

    private String title;

    private String desc;

    private String operator;

    private Date createTime;

    private Date updateTime;

    private Date executeTime;

    private long consumeTime;

    private String result;


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

    public int getCase_number() {
        return case_number;
    }

    public void setCase_number(int case_number) {
        this.case_number = case_number;
    }

    public int getSuccess_number() {
        return success_number;
    }

    public void setSuccess_number(int success_number) {
        this.success_number = success_number;
    }

    public int getRun_number() {
        return run_number;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public void setRun_number(int run_number) {
        this.run_number = run_number;
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

    @Override
    public String toString() {
        return "AutoTestReport{" +
                "id=" + id +
                ", batchNum='" + batchNum + '\'' +
                ", case_number=" + case_number +
                ", env='" + env + '\'' +
                ", success_number=" + success_number +
                ", run_number=" + run_number +
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
