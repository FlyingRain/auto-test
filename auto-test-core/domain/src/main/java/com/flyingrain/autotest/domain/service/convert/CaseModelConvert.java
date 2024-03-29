package com.flyingrain.autotest.domain.service.convert;

import com.flyingrain.autotest.domain.model.Case;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestCaseModel;

/**
 * @author wally
 * @date 2021-12-10
 */
public class CaseModelConvert {

    public static Case convertCaseModel(AutoTestCaseModel autoTestCaseModel) {
        if (autoTestCaseModel == null) {
            return null;
        }
        Case runCase = new Case();
        runCase.setCaseStatus(autoTestCaseModel.getCaseStatus());
        runCase.setId(autoTestCaseModel.getId());
        runCase.setCreateTime(autoTestCaseModel.getCreateTime());
        runCase.setCheckPoints(autoTestCaseModel.getCheckPointConfig());
        runCase.setCreator(autoTestCaseModel.getCreator());
        runCase.setModifier(autoTestCaseModel.getModifier());
        runCase.setParamValue(autoTestCaseModel.getParamValue());
        runCase.setName(autoTestCaseModel.getName());
        runCase.setServiceId(autoTestCaseModel.getServiceId());
        runCase.setResultCollectConfig(autoTestCaseModel.getResultCollectConfig());
        runCase.setUpdateTime(autoTestCaseModel.getUpdateTime());
        return runCase;
    }


    public static AutoTestCaseModel convertCase(Case runCase) {
        if (runCase == null) {
            return null;
        }
        AutoTestCaseModel autoTestCaseModel = new AutoTestCaseModel();
        autoTestCaseModel.setCaseStatus(runCase.getCaseStatus());
        autoTestCaseModel.setModifier(runCase.getModifier());
        autoTestCaseModel.setCreator(runCase.getCreator());
        autoTestCaseModel.setUpdateTime(runCase.getUpdateTime());
        autoTestCaseModel.setCreator(runCase.getCreator());
        autoTestCaseModel.setName(runCase.getName());
        autoTestCaseModel.setResultCollectConfig(runCase.getResultCollectConfig());
        autoTestCaseModel.setParamValue(runCase.getParamValue());
        autoTestCaseModel.setCheckPointConfig(runCase.getCheckPoints());
        autoTestCaseModel.setServiceId(runCase.getServiceId());
        autoTestCaseModel.setId(runCase.getId());
        return autoTestCaseModel;
    }
}
