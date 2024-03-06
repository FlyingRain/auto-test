package com.flyingrain.autotest.facade.intf.model;

import java.util.Date;

public class AutoTestService {

    private int id;

    private String serviceName;

    private String serviceCode;

    private String requestPath;

    private String protocolType;

    private String hearders;

    private String requestType;

    private String responseDataType;

    private String appId;

    private String appName;

    private String requestModel;

    private String creator;

    private Date createTime;

    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getRequestPath() {
        return requestPath;
    }

    public void setRequestPath(String requestPath) {
        this.requestPath = requestPath;
    }

    public String getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(String protocolType) {
        this.protocolType = protocolType;
    }

    public String getHearders() {
        return hearders;
    }

    public void setHearders(String hearders) {
        this.hearders = hearders;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getResponseDataType() {
        return responseDataType;
    }

    public void setResponseDataType(String responseDataType) {
        this.responseDataType = responseDataType;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getRequestModel() {
        return requestModel;
    }

    public void setRequestModel(String requestModel) {
        this.requestModel = requestModel;
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

    @Override
    public String toString() {
        return "AutoTestService{" +
                "id=" + id +
                ", serviceName='" + serviceName + '\'' +
                ", serviceCode='" + serviceCode + '\'' +
                ", requestPath='" + requestPath + '\'' +
                ", protocolType='" + protocolType + '\'' +
                ", hearders='" + hearders + '\'' +
                ", requestType='" + requestType + '\'' +
                ", responseDataType='" + responseDataType + '\'' +
                ", appId='" + appId + '\'' +
                ", appName='" + appName + '\'' +
                ", requestModel='" + requestModel + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
