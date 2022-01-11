package com.flyingrain.autotest.domain.core.loader;

import com.flyingrain.autotest.domain.constant.AutoTestResultCodeEnum;
import com.flyingrain.autotest.domain.core.ModelHolder;
import com.flyingrain.autotest.domain.exception.AutoTestException;
import com.flyingrain.autotest.domain.model.Case;
import com.flyingrain.autotest.domain.model.Service;
import com.flyingrain.autotest.facade.intf.requests.ModelTypeEnum;
import com.flyingrain.autotest.infrastructure.datasource.mapper.AutoTestCaseMapper;
import com.flyingrain.autotest.infrastructure.datasource.mapper.AutoTestCaseRelationMapper;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestCaseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import com.flyingrain.autotest.domain.service.convert.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wally
 * @date 2021-12-09
 */
@Component
public class CaseModelLoader implements ModelLoader<Case> {

    private static final Logger logger = LoggerFactory.getLogger(CaseModelLoader.class);

    @Autowired
    private AutoTestCaseRelationMapper autoTestCaseRelationMapper;

    @Autowired
    private AutoTestCaseMapper autoTestCaseMapper;

    @Autowired
    private ModelHolder modelHolder;

    @Override
    public Case loadModel(long modelId) {
        AutoTestCaseModel autoTestCaseModel = autoTestCaseMapper.queryCaseById(modelId);
        Case runCase = CaseModelConvert.convertCaseModel(autoTestCaseModel);
        if (runCase == null) {
            logger.error("case not exist!caseId:[{}]", modelId);
            return null;
        }
        loadModel(runCase);

        return runCase;
    }

    @Override
    public void unloadModel(long modelId) {

    }

    @Override
    public void loadModel(Case model) {

        Service service = modelHolder.getServiceById(model.getServiceId());

        if (service == null) {
            logger.error("service haven't been loaded!pls load service first!serviceId : [{}] ", model.getServiceId());
            throw new AutoTestException(AutoTestResultCodeEnum.MODEL_NOT_LOADED);
        }
        model.setService(service);

        loadCase(model, new ArrayList<>());
    }

    @Override
    public List<Case> loadAllCases(Case model) {
        List<Case> cases = new ArrayList<>();
        cases.add(model);
        return cases;
    }


    private void loadCase(Case runCase, List<Long> loadedCaseId) {
        List<AutoTestCaseModel> autoTestCaseModels = autoTestCaseMapper.queryDepCases(runCase.getId());
        if (CollectionUtils.isEmpty(autoTestCaseModels)) {
            return;
        }
        List<Case> depCases = new ArrayList<>();
        for (AutoTestCaseModel autoTestCaseModel : autoTestCaseModels) {
            Case depRunCase = CaseModelConvert.convertCaseModel(autoTestCaseModel);
            if (loadedCaseId.contains(depRunCase.getId())) {
                logger.info("case cannot dep each other!dep trace is:[{}],and [{}]", loadedCaseId, depRunCase.getId());
                throw new AutoTestException(AutoTestResultCodeEnum.CASE_DEP_CYCLE);
            }
            Service service = modelHolder.getServiceById(depRunCase.getServiceId());
            if (service == null) {
                logger.error("service haven't been loaded!pls load service first!serviceId : [{}] ", depRunCase.getServiceId());
                throw new AutoTestException(AutoTestResultCodeEnum.MODEL_NOT_LOADED);
            }
            depRunCase.setService(service);
            List<Long> depLoadedCaseIds = new ArrayList<>(loadedCaseId);
            depLoadedCaseIds.add(depRunCase.getId());
            loadCase(depRunCase, depLoadedCaseIds);
            depCases.add(depRunCase);
        }
        runCase.setDepCases(depCases);
    }

    @Override
    public ModelTypeEnum loadType() {
        return ModelTypeEnum.CASE;
    }
}
