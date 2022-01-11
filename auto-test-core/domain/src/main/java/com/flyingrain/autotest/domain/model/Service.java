package com.flyingrain.autotest.domain.model;

import com.flyingrain.autotest.facade.intf.requests.ModelTypeEnum;

import java.util.Date;
import java.util.List;

/**
 * @author wally
 * @date 2021-12-08
 */
public class Service implements Model{

    private long id;

    private List<Case> cases;

    private long moduleId;

    private String serviceCode;

    private String name;

    private String protocolType;

    private String requestUrl;

    private String requestType;

    private String requestDataType;

    private String requestDataModule;

    private String responseDataType;

    private String creator;

    private Date createTime;

    private Date updateTime;

    private Module module;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Case> getCases() {
        return cases;
    }

    public void setCases(List<Case> cases) {
        this.cases = cases;
    }

    public long getModuleId() {
        return moduleId;
    }

    public void setModuleId(long moduleId) {
        this.moduleId = moduleId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(String protocolType) {
        this.protocolType = protocolType;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getRequestDataType() {
        return requestDataType;
    }

    public void setRequestDataType(String requestDataType) {
        this.requestDataType = requestDataType;
    }

    public String getRequestDataModule() {
        return requestDataModule;
    }

    public void setRequestDataModule(String requestDataModule) {
        this.requestDataModule = requestDataModule;
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

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }


    public String getResponseDataType() {
        return responseDataType;
    }

    public void setResponseDataType(String responseDataType) {
        this.responseDataType = responseDataType;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", cases=" + cases +
                ", moduleId=" + moduleId +
                ", serviceCode='" + serviceCode + '\'' +
                ", name='" + name + '\'' +
                ", protocolType='" + protocolType + '\'' +
                ", requestUrl='" + requestUrl + '\'' +
                ", requestType='" + requestType + '\'' +
                ", requestDataType='" + requestDataType + '\'' +
                ", requestDataModule='" + requestDataModule + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    @Override
    public ModelTypeEnum getModelType() {
        return ModelTypeEnum.SERVICE;
    }
}
