package com.flyingrain.autotest.domain.core.loader;

import com.flyingrain.autotest.domain.constant.AutoTestResultCodeEnum;
import com.flyingrain.autotest.domain.core.ModelHolder;

import com.flyingrain.autotest.domain.exception.AutoTestException;
import com.flyingrain.autotest.domain.model.Case;
import com.flyingrain.autotest.domain.model.Module;
import com.flyingrain.autotest.domain.model.Service;
import com.flyingrain.autotest.facade.intf.requests.ModelTypeEnum;
import com.flyingrain.autotest.infrastructure.datasource.mapper.AutoTestServiceMapper;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestServiceModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import com.flyingrain.autotest.domain.service.convert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wally
 * @date 2021-12-08
 */
@Component
public class ModuleModelLoader implements ModelLoader<Module> {

    private final Logger logger = LoggerFactory.getLogger(ModuleModelLoader.class);
    @Autowired
    private ModelHolder modelHolder;

    @Autowired
    private WholeModelLoader wholeModelLoader;

    @Autowired
    private ServiceModelLoader serviceModelLoader;

    @Autowired
    private AutoTestServiceMapper autoTestServiceMapper;

    @Override
    public Module loadModel(long modelId) {
        Module module = modelHolder.getModuleById(modelId);
        if (module == null) {
            logger.info("module not load!start to load whole project!moduleId:[{}]", modelId);
        }
        wholeModelLoader.loadAllModel();

        module = modelHolder.getModuleById(modelId);

        if (module == null) {
            logger.error("module not exist!pls check database!moduleId:[{}]", modelId);
            throw new AutoTestException(AutoTestResultCodeEnum.MODEL_NOT_EXIST);
        }
        return module;
    }

    @Override
    public void unloadModel(long modelId) {

    }

    @Override
    public void loadModel(Module model) {

        List<Service> services = queryModuleServices(model);

        services.forEach(service -> {
            serviceModelLoader.loadModel(service);
            service.setModule(model);
        });

        model.setServices(services);

        modelHolder.swapIfExistModule(model);
    }

    @Override
    public List<Case> loadAllCases(Module model) {
        List<Service> services = modelHolder.getModuleServices(model.getId());
        if (CollectionUtils.isEmpty(services)) {
            logger.error("module no services!module:[{}]", model);
            return new ArrayList<>();
        }
        return services.stream().flatMap(service-> serviceModelLoader.loadAllCases(service).stream()).collect(Collectors.toList());
    }


    private List<Service> queryModuleServices(Module model) {
        List<AutoTestServiceModel> autoTestServiceModels = autoTestServiceMapper.queryServiceByModuleId(model.getId());
        return CollectionUtils.isEmpty(autoTestServiceModels) ? new ArrayList<>() : autoTestServiceModels.stream().map(ServiceModelConvert::convertServiceModel).collect(Collectors.toList());
    }

    @Override
    public ModelTypeEnum loadType() {
        return ModelTypeEnum.MODULE;
    }
}
