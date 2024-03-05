package com.flyingrain.autotest.domain.service.convert;

import com.flyingrain.autotest.domain.model.Project;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestApplicationModel;

/**
 * @author wally
 * @date 2021-12-09
 */
public class ProjectModelConvert {

    public static Project convertModel(AutoTestApplicationModel autoTestProjectModel) {
        if (autoTestProjectModel == null) {
            return null;
        }
        Project project = new Project();
        project.setProjectCode(autoTestProjectModel.getAppCode());
        project.setProjectName(autoTestProjectModel.getAppName());
        project.setProjectUrl(autoTestProjectModel.getDesc());
        project.setCreateTime(autoTestProjectModel.getCreateTime());
        project.setId(autoTestProjectModel.getId());
        project.setOwner(autoTestProjectModel.getOwner());
        project.setStatus(autoTestProjectModel.getDomain());
        project.setUpdateTime(autoTestProjectModel.getUpdateTime());
        return project;
    }
}
