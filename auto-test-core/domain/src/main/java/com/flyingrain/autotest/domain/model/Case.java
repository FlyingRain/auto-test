package com.flyingrain.autotest.domain.model;

import com.flyingrain.autotest.facade.intf.requests.ModelTypeEnum;

import java.util.Date;
import java.util.List;

/**
 * @author wally
 * @date 2021-12-08
 */
public class Case implements Model{

    private long id;

    private String name;

    private long serviceId;

    private String data;

    private String caseStatus;

    private Long depCaseId;

    private String result;

    private String checkPoint;

    private String creator;

    private int priority;

    private Date createTime;

    private Date updateTime;

    private List<Case> depCases;

    private Service service;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getServiceId() {
        return serviceId;
    }

    public void setServiceId(long serviceId) {
        this.serviceId = serviceId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }

    public Long getDepCaseId() {
        return depCaseId;
    }

    public void setDepCaseId(Long depCaseId) {
        this.depCaseId = depCaseId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getCheckPoint() {
        return checkPoint;
    }

    public void setCheckPoint(String checkPoint) {
        this.checkPoint = checkPoint;
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

    public List<Case> getDepCases() {
        return depCases;
    }

    public void setDepCases(List<Case> depCases) {
        this.depCases = depCases;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Case{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", serviceId=" + serviceId +
                ", data='" + data + '\'' +
                ", caseStatus='" + caseStatus + '\'' +
                ", result='" + result + '\'' +
                ", checkPoint='" + checkPoint + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    @Override
    public ModelTypeEnum getModelType() {
        return ModelTypeEnum.CASE;
    }
}
