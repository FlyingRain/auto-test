package com.flyingrain.autotest.service.convert;

import com.flyingrain.autotest.domain.model.Case;
import com.flyingrain.autotest.domain.service.convert.ServiceModelConvert;
import com.flyingrain.autotest.facade.intf.model.AutoTestCase;

public class CaseViewConvert {


    public static AutoTestCase convertCaseModel(Case testCase) {
        if (testCase == null) {
            return null;
        }
        AutoTestCase autoTestCase = new AutoTestCase();
        autoTestCase.setCaseStatus(testCase.getCaseStatus());
        autoTestCase.setCreateTime(testCase.getCreateTime());
        autoTestCase.setCreator(testCase.getCreator());
        autoTestCase.setModifier(testCase.getModifier());
        autoTestCase.setId(testCase.getId());
        autoTestCase.setDesc(testCase.getDesc());
        autoTestCase.setCheckPoints(testCase.getCheckPoints());
        autoTestCase.setUpdateTime(testCase.getUpdateTime());
        autoTestCase.setResponseConfig(testCase.getResultCollectConfig());
        autoTestCase.setParamValue(testCase.getParamValue());
        autoTestCase.setName(testCase.getName());
        autoTestCase.setCode(testCase.getCode());
        autoTestCase.setAutoTestService(ServiceViewConvert.convertModel(testCase.getService()));
        autoTestCase.setServiceId(testCase.getServiceId());
        return autoTestCase;
    }


    public static Case convertCaseView(AutoTestCase autoTestCase) {
        if (autoTestCase == null) {
            return null;
        }
        Case testCase = new Case();
        testCase.setCaseStatus(autoTestCase.getCaseStatus());
        testCase.setCreateTime(autoTestCase.getCreateTime());
        testCase.setCreator(autoTestCase.getCreator());
        testCase.setModifier(autoTestCase.getModifier());
        testCase.setId(autoTestCase.getId());
        testCase.setCode(autoTestCase.getCode());
        testCase.setDesc(autoTestCase.getDesc());
        testCase.setCheckPoints(autoTestCase.getCheckPoints());
        testCase.setUpdateTime(autoTestCase.getUpdateTime());
        testCase.setResultCollectConfig(autoTestCase.getResponseConfig());
        testCase.setParamValue(autoTestCase.getParamValue());
        testCase.setName(autoTestCase.getName());
        testCase.setServiceId(autoTestCase.getServiceId());
        return testCase;
    }

}
