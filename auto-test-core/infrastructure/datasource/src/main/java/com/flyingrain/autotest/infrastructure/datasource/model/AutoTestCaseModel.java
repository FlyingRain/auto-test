package com.flyingrain.autotest.infrastructure.datasource.model;

import java.util.Date;

/**
 * @author wally
 * @date 2021-12-08
 */
public class AutoTestCaseModel {


    private int id;

    private String name;

    private String code;

    private int serviceId;

    private String caseStatus;

    private String checkPointConfig;

    private String desc;

    private String paramValue;

    private String resultCollectConfig;
    private String creator;

    private String modifier;

    private Date createTime;

    private Date updateTime;

    public int getId() {
        return id;
    }


    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getServiceId() {
        return serviceId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getResultCollectConfig() {
        return resultCollectConfig;
    }

    public void setResultCollectConfig(String resultCollectConfig) {
        this.resultCollectConfig = resultCollectConfig;
    }

    public String getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }


    public String getCheckPointConfig() {
        return checkPointConfig;
    }

    public void setCheckPointConfig(String checkPointConfig) {
        this.checkPointConfig = checkPointConfig;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
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

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    @Override
    public String toString() {
        return "AutoTestCaseModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", serviceId=" + serviceId +
                ", caseStatus='" + caseStatus + '\'' +
                ", checkPointConfig='" + checkPointConfig + '\'' +
                ", desc='" + desc + '\'' +
                ", paramValue='" + paramValue + '\'' +
                ", resultCollectConfig='" + resultCollectConfig + '\'' +
                ", creator='" + creator + '\'' +
                ", modifier='" + modifier + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
