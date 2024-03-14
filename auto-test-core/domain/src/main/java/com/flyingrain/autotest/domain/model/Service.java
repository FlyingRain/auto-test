package com.flyingrain.autotest.domain.model;


import java.util.Date;
import java.util.List;

/**
 * @author wally
 * @date 2021-12-08
 */
public class Service {

    private int id;

    private List<Case> cases;

    private String serviceCode;

    private String name;

    private String headers;

    private int appId;
    private String protocolType;

    private String requestUrl;

    private String requestType;

    private String requestDataType;

    private String requestDataModule;

    private String responseDataType;

    private String creator;

    private Date createTime;

    private Date updateTime;

    private List<ServiceParam> params;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Case> getCases() {
        return cases;
    }

    public void setCases(List<Case> cases) {
        this.cases = cases;
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

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
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

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public String getResponseDataType() {
        return responseDataType;
    }

    public void setResponseDataType(String responseDataType) {
        this.responseDataType = responseDataType;
    }

    public List<ServiceParam> getParams() {
        return params;
    }

    public void setParams(List<ServiceParam> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", cases=" + cases +
                ", serviceCode='" + serviceCode + '\'' +
                ", name='" + name + '\'' +
                ", headers='" + headers + '\'' +
                ", appId=" + appId +
                ", protocolType='" + protocolType + '\'' +
                ", requestUrl='" + requestUrl + '\'' +
                ", requestType='" + requestType + '\'' +
                ", requestDataType='" + requestDataType + '\'' +
                ", requestDataModule='" + requestDataModule + '\'' +
                ", responseDataType='" + responseDataType + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }


}
