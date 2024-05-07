package com.flyingrain.autotest.infrastructure.datasource;

public class AutoTestCaseQuery {

    private int id;

    private String name;

    private String code;

    private String creator;

    private int serviceId;

    private int sceneId;

    private int appId;

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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getSceneId() {
        return sceneId;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    @Override
    public String toString() {
        return "AutoTestCaseQuery{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", creator='" + creator + '\'' +
                ", serviceId=" + serviceId +
                ", sceneId=" + sceneId +
                ", appId=" + appId +
                '}';
    }
}
