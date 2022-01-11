package com.flyingrain.autotest.domain.core.loader;

import com.flyingrain.autotest.domain.constant.AutoTestResultCodeEnum;
import com.flyingrain.autotest.domain.core.ModelHolder;
import com.flyingrain.autotest.domain.exception.AutoTestException;
import com.flyingrain.autotest.domain.model.Case;
import com.flyingrain.autotest.domain.model.Service;
import com.flyingrain.autotest.facade.intf.requests.ModelTypeEnum;
import com.flyingrain.autotest.infrastructure.datasource.mapper.AutoTestCaseMapper;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestCaseModel;
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
 * @date 2021-12-09
 */
@Component
public class ServiceModelLoader implements ModelLoader<Service> {

    private static final Logger logger = LoggerFactory.getLogger(ServiceModelLoader.class);

    @Autowired
    private ModelHolder modelHolder;

    @Autowired
    private WholeModelLoader wholeModelLoader;

    @Autowired
    private AutoTestCaseMapper autoTestCaseMapper;

    @Autowired
    private CaseModelLoader caseModelLoader;


    @Override
    public Service loadModel(long modelId) {
        Service service = modelHolder.getServiceById(modelId);
        if (service == null) {
            wholeModelLoader.loadAllModel();
        }
        service = modelHolder.getServiceById(modelId);
        if (service == null) {
            logger.error("service not exist! pls check database!serviceId:[{}]", modelId);
            throw new AutoTestException(AutoTestResultCodeEnum.MODEL_NOT_EXIST);
        }
        return service;
    }

    @Override
    public void unloadModel(long modelId) {

    }

    @Override
    public void loadModel(Service model) {

    }

    @Override
    public List<Case> loadAllCases(Service model) {
        List<AutoTestCaseModel> autoTestCaseModels = autoTestCaseMapper.queryByServiceId(model.getId());
        if (CollectionUtils.isEmpty(autoTestCaseModels)) {
            logger.error("service has no cases!service:[{}]", model);
            return new ArrayList<>();
        }
        return autoTestCaseModels.stream().map(CaseModelConvert::convertCaseModel).peek(runCase->caseModelLoader.loadModel(runCase)).collect(Collectors.toList());
    }

    @Override
    public ModelTypeEnum loadType() {
        return ModelTypeEnum.SERVICE;
    }
}
