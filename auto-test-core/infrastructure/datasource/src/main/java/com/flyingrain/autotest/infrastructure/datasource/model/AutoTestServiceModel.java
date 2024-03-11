package com.flyingrain.autotest.infrastructure.datasource.model;

import java.util.Date;

/**
 * @author wally
 * @date 2021-12-08
 */
public class AutoTestServiceModel {

    private int id;

    private int appId;

    private String headers;

    private String serviceCode;

    private String serviceName;

    private String protocolType;

    private String requestPath;

    private String requestType;

    private String requestModel;

    private String responseDataType;

    private String creator;

    private Date createTime;

    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(String protocolType) {
        this.protocolType = protocolType;
    }

    public String getRequestPath() {
        return requestPath;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public void setRequestPath(String requestPath) {
        this.requestPath = requestPath;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
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

    public String getResponseDataType() {
        return responseDataType;
    }

    public void setResponseDataType(String responseDataType) {
        this.responseDataType = responseDataType;
    }

    @Override
    public String toString() {
        return "AutoTestServiceModel{" +
                "id=" + id +
                ", appId=" + appId +
                ", headers='" + headers + '\'' +
                ", serviceCode='" + serviceCode + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", protocolType='" + protocolType + '\'' +
                ", requestPath='" + requestPath + '\'' +
                ", requestType='" + requestType + '\'' +
                ", requestModel='" + requestModel + '\'' +
                ", responseDataType='" + responseDataType + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
