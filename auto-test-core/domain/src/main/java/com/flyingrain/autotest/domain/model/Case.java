package com.flyingrain.autotest.domain.model;


import java.util.Date;

/**
 * @author wally
 * @date 2021-12-08
 */
public class Case {

    private int id;

    private String name;

    private int serviceId;


    private String caseStatus;


    private String resultCollectConfig;

    private String checkPoints;

    private String paramValue;

    private Service service;

    private String creator;

    private String modifier;

    private Date createTime;

    private Date updateTime;

    public int getId() {
        return id;
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

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }

    public String getResultCollectConfig() {
        return resultCollectConfig;
    }

    public void setResultCollectConfig(String resultCollectConfig) {
        this.resultCollectConfig = resultCollectConfig;
    }

    public String getCheckPoints() {
        return checkPoints;
    }

    public void setCheckPoints(String checkPoints) {
        this.checkPoints = checkPoints;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
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
        return "Case{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", serviceId=" + serviceId +
                ", caseStatus='" + caseStatus + '\'' +
                ", resultCollectConfig='" + resultCollectConfig + '\'' +
                ", checkPoints='" + checkPoints + '\'' +
                ", paramValue='" + paramValue + '\'' +
                ", service=" + service +
                ", creator='" + creator + '\'' +
                ", modifier='" + modifier + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
