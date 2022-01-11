package com.flyingrain.autotest.domain.model;

import com.flyingrain.autotest.facade.intf.requests.ModelTypeEnum;

import java.util.Date;
import java.util.List;

/**
 * @author wally
 * @date 2021-12-08
 */
public class Module implements Model{

    private long id;

    private List<Service> services;

    private String moduleName;

    private long projectId;

    private String moduleUrl;

    private String mvnDep;

    private String creator;

    private Date createTime;

    private Date updateTime;

    private Project project;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getModuleUrl() {
        return moduleUrl;
    }

    public void setModuleUrl(String moduleUrl) {
        this.moduleUrl = moduleUrl;
    }

    public String getMvnDep() {
        return mvnDep;
    }

    public void setMvnDep(String mvnDep) {
        this.mvnDep = mvnDep;
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "Module{" +
                "id=" + id +
                ", services=" + services +
                ", moduleName='" + moduleName + '\'' +
                ", projectId=" + projectId +
                ", moduleUrl='" + moduleUrl + '\'' +
                ", mvnDep='" + mvnDep + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    @Override
    public ModelTypeEnum getModelType() {
        return ModelTypeEnum.MODULE;
    }
}
