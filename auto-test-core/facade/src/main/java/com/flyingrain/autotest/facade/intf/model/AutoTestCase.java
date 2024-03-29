package com.flyingrain.autotest.facade.intf.model;

import java.util.Date;

public class AutoTestCase {

    private int id;

    private int serviceId;

    private String name;

    private String paramValue;

    private String responseConfig;

    private String checkPoints;

    private String caseStatus;

    private AutoTestService autoTestService;

    private String creator;

    private String modifier;

    private Date updateTime;

    private Date createTime;

    public String getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getResponseConfig() {
        return responseConfig;
    }

    public void setResponseConfig(String responseConfig) {
        this.responseConfig = responseConfig;
    }

    public String getCheckPoints() {
        return checkPoints;
    }

    public void setCheckPoints(String checkPoints) {
        this.checkPoints = checkPoints;
    }

    public AutoTestService getAutoTestService() {
        return autoTestService;
    }

    public void setAutoTestService(AutoTestService autoTestService) {
        this.autoTestService = autoTestService;
    }

    @Override
    public String toString() {
        return "AutoTestCase{" +
                "id=" + id +
                ", serviceId=" + serviceId +
                ", name='" + name + '\'' +
                ", paramValue='" + paramValue + '\'' +
                ", responseConfig='" + responseConfig + '\'' +
                ", checkPoints='" + checkPoints + '\'' +
                '}';
    }
}
