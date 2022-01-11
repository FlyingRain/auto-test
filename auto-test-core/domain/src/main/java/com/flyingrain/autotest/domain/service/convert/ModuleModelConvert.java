package com.flyingrain.autotest.domain.service.convert;

import com.flyingrain.autotest.domain.model.Module;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestModuleModel;

/**
 * @author wally
 * @date 2021-12-09
 */
public class ModuleModelConvert {

    public static Module convertModuleModel(AutoTestModuleModel autoTestModuleModel) {
        if (autoTestModuleModel == null) {
            return null;
        }
        Module module = new Module();
        module.setModuleName(autoTestModuleModel.getModuleName());
        module.setModuleUrl(autoTestModuleModel.getModuleUrl());
        module.setCreateTime(autoTestModuleModel.getCreateTime());
        module.setId(autoTestModuleModel.getId());
        module.setMvnDep(autoTestModuleModel.getMvnDep());
        module.setCreator(autoTestModuleModel.getCreator());
        module.setProjectId(autoTestModuleModel.getProjectId());
        module.setUpdateTime(autoTestModuleModel.getUpdateTime());
        return module;
    }
}
