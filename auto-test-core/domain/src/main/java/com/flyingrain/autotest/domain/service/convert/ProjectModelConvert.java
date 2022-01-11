package com.flyingrain.autotest.domain.service.convert;

import com.flyingrain.autotest.domain.model.Project;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestProjectModel;

/**
 * @author wally
 * @date 2021-12-09
 */
public class ProjectModelConvert {

    public static Project convertModel(AutoTestProjectModel autoTestProjectModel) {
        if (autoTestProjectModel == null) {
            return null;
        }
        Project project = new Project();
        project.setProjectCode(autoTestProjectModel.getProjectCode());
        project.setProjectName(autoTestProjectModel.getProjectName());
        project.setProjectUrl(autoTestProjectModel.getProjectUrl());
        project.setCreateTime(autoTestProjectModel.getCreateTime());
        project.setId(autoTestProjectModel.getId());
        project.setOwner(autoTestProjectModel.getOwner());
        project.setStatus(autoTestProjectModel.getStatus());
        project.setUpdateTime(autoTestProjectModel.getUpdateTime());
        return project;
    }
}
