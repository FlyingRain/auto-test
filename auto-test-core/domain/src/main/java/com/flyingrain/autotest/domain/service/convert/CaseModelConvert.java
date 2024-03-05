package com.flyingrain.autotest.domain.service.convert;

import com.flyingrain.autotest.domain.model.Case;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestCaseModel;

/**
 * @author wally
 * @date 2021-12-10
 */
public class CaseModelConvert {

    public static Case convertCaseModel(AutoTestCaseModel autoTestCaseModel){
        if(autoTestCaseModel==null){
            return null;
        }
        Case runCase = new Case();
        runCase.setCaseStatus(autoTestCaseModel.getCaseStatus());
        runCase.setId(autoTestCaseModel.getId());
        runCase.setCreateTime(autoTestCaseModel.getCreateTime());
        runCase.setCheckPoint(autoTestCaseModel.getCheckPoint());
        runCase.setCreator(autoTestCaseModel.getCreator());
        runCase.setName(autoTestCaseModel.getName());
        runCase.setServiceId(autoTestCaseModel.getServiceId());
        runCase.setUpdateTime(autoTestCaseModel.getUpdateTime());
        return runCase;
    }
}
