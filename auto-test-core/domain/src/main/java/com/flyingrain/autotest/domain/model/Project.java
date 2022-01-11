package com.flyingrain.autotest.domain.model;

import com.flyingrain.autotest.facade.intf.requests.ModelTypeEnum;

import java.util.Date;
import java.util.List;

/**
 * @author wally
 * @date 2021-12-08
 */
public class Project implements Model{

    private long id;

    private List<Module> modules;

    private String projectCode;

    private String projectName;

    private String status;

    private String projectUrl;

    private String owner;

    private Date createTime;

    private Date  updateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProjectUrl() {
        return projectUrl;
    }

    public void setProjectUrl(String projectUrl) {
        this.projectUrl = projectUrl;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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
        return "Project{" +
                "id=" + id +
                ", modules=" + modules +
                ", projectCode='" + projectCode + '\'' +
                ", projectName='" + projectName + '\'' +
                ", status='" + status + '\'' +
                ", projectUrl='" + projectUrl + '\'' +
                ", owner='" + owner + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    @Override
    public ModelTypeEnum getModelType() {
        return ModelTypeEnum.PROJECT;
    }
}
