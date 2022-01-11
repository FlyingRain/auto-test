package com.flyingrain.autotest.domain.core.loader;

import com.flyingrain.autotest.domain.constant.AutoTestResultCodeEnum;
import com.flyingrain.autotest.domain.core.ModelHolder;
import com.flyingrain.autotest.domain.model.Case;
import com.flyingrain.autotest.domain.service.convert.*;
import com.flyingrain.autotest.domain.exception.AutoTestException;
import com.flyingrain.autotest.domain.model.Module;
import com.flyingrain.autotest.domain.model.Project;
import com.flyingrain.autotest.facade.intf.requests.ModelTypeEnum;
import com.flyingrain.autotest.infrastructure.datasource.mapper.AutoTestModuleMapper;
import com.flyingrain.autotest.infrastructure.datasource.mapper.AutoTestProjectMapper;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestModuleModel;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestProjectModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wally
 * @date 2021-12-08
 */
@Component
public class ProjectModelLoader implements ModelLoader<Project> {

    private static final Logger logger = LoggerFactory.getLogger(ProjectModelLoader.class);

    @Autowired
    private ModuleModelLoader moduleModelLoader;

    @Autowired
    private ModelHolder modelHolder;

    @Autowired
    private AutoTestProjectMapper autoTestProjectMapper;

    @Autowired
    private AutoTestModuleMapper autoTestModuleMapper;

    @Override
    public Project loadModel(long modelId) {

        Project project = getProject(modelId);

        loadSubModel(project);

        modelHolder.swapIfExistProject(project);

        return project;
    }


    private Project getProject(long modelId) {
        AutoTestProjectModel autoTestProjectModel = autoTestProjectMapper.queryProjectById(modelId);
        if (autoTestProjectModel == null) {
            logger.error("project is null!projectId:[{}]", modelId);
            throw new AutoTestException(AutoTestResultCodeEnum.FAIL.getCode(), "项目为空");
        }

        return ProjectModelConvert.convertModel(autoTestProjectModel);
    }

    private void loadSubModel(Project project) {

        List<Module> modules = queryProjectModules(project);

        modules.forEach(module -> {
            moduleModelLoader.loadModel(module);
            module.setProject(project);
        });

        project.setModules(modules);
    }


    private List<Module> queryProjectModules(Project project) {

        List<AutoTestModuleModel> autoTestModuleModels = autoTestModuleMapper.queryAllModule(project.getId());

        return CollectionUtils.isEmpty(autoTestModuleModels) ? new ArrayList<>() : autoTestModuleModels.stream().map(ModuleModelConvert::convertModuleModel).collect(Collectors.toList());
    }

    @Override
    public void unloadModel(long modelId) {

    }

    @Override
    public void loadModel(Project model) {
        loadSubModel(model);

        modelHolder.swapIfExistProject(model);
    }

    @Override
    public List<Case> loadAllCases(Project model) {
        List<Module> modules = modelHolder.getProjectModules(model.getId());
        if (CollectionUtils.isEmpty(modules)) {
            logger.error("project has no module!project:[{}]", model);
            return new ArrayList<>();
        }
        return modules.stream().flatMap(module -> moduleModelLoader.loadAllCases(module).stream()).collect(Collectors.toList());
    }


    @Override
    public ModelTypeEnum loadType() {
        return ModelTypeEnum.PROJECT;
    }
}
