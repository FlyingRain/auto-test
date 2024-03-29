package com.flyingrain.autotest.domain.service;

import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.common.util.PageableModel;
import com.flyingrain.autotest.common.util.RunTimeContext;
import com.flyingrain.autotest.common.util.constant.AutoTestConstants;
import com.flyingrain.autotest.domain.model.Case;
import com.flyingrain.autotest.domain.model.User;
import com.flyingrain.autotest.domain.service.convert.CaseModelConvert;
import com.flyingrain.autotest.infrastructure.datasource.AutoTestCaseQuery;
import com.flyingrain.autotest.infrastructure.datasource.mapper.AutoTestCaseMapper;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestCaseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CaseService {

    private final Logger logger = LoggerFactory.getLogger(CaseService.class);

    @Autowired
    private AutoTestCaseMapper autoTestCaseMapper;

    public PageableModel<Case> queryByPage(PageQuery<CaseQuery> caseQueryRequestPageQuery) {
        logger.info("query request:[{}]", caseQueryRequestPageQuery);
        AutoTestCaseQuery caseQuery = buildQuery(caseQueryRequestPageQuery.getConditions());
        PageQuery<AutoTestCaseQuery> caseQueryPageQuery = new PageQuery<>(caseQueryRequestPageQuery.getCurrentPage(), caseQueryRequestPageQuery.getPageSize(), caseQuery);
        List<AutoTestCaseModel> autoTestCaseModels = autoTestCaseMapper.queryByPage(caseQueryPageQuery);
        int count = autoTestCaseMapper.queryByPageCount(caseQueryPageQuery);
        List<Case> runCases = autoTestCaseModels.stream().map(CaseModelConvert::convertCaseModel).toList();
        PageableModel<Case> result = new PageableModel<>();
        result.setData(runCases);
        result.setTotal(count);
        result.setCurrentPage(caseQueryRequestPageQuery.getCurrentPage());
        result.setPageSize(caseQueryRequestPageQuery.getPageSize());
        return result;
    }


    public boolean insert(Case testCase) {
        logger.info("start to insert case:[{}]", testCase);
        return autoTestCaseMapper.insertCase(CaseModelConvert.convertCase(testCase)) == 1;
    }

    public int batchDel(List<Integer> ids) {
        User user = RunTimeContext.get(AutoTestConstants.USER);
        logger.info("user:[{}] del ids:[{}]", user, ids);
        return autoTestCaseMapper.batchDel(ids);
    }

    public int update(Case testCase) {
        logger.info("update case:[{}]", testCase);
        return autoTestCaseMapper.updateCaseById(CaseModelConvert.convertCase(testCase));
    }

    public Case queryDetail(Integer caseId) {
        return CaseModelConvert.convertCaseModel(autoTestCaseMapper.queryCaseById(caseId));
    }


    private AutoTestCaseQuery buildQuery(CaseQuery conditions) {
        AutoTestCaseQuery autoTestCaseQuery = new AutoTestCaseQuery();
        autoTestCaseQuery.setServiceId(conditions.getServiceId());
        autoTestCaseQuery.setId(conditions.getId());
        autoTestCaseQuery.setName(conditions.getName());
        autoTestCaseQuery.setCreator(conditions.getCreator());
        autoTestCaseQuery.setSceneId(conditions.getSceneId());
        return autoTestCaseQuery;
    }
}
