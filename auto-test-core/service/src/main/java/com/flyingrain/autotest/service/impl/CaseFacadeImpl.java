package com.flyingrain.autotest.service.impl;

import com.flyingrain.autotest.common.util.*;
import com.flyingrain.autotest.common.util.constant.AutoTestConstants;
import com.flyingrain.autotest.common.util.exception.AutoTestException;
import com.flyingrain.autotest.domain.core.CaseExecutorHelper;
import com.flyingrain.autotest.domain.core.ExecuteContext;
import com.flyingrain.autotest.domain.core.ExecuteUnit;
import com.flyingrain.autotest.domain.core.ExecuteUnitBuilder;
import com.flyingrain.autotest.domain.model.Case;
import com.flyingrain.autotest.domain.model.Service;
import com.flyingrain.autotest.domain.model.User;
import com.flyingrain.autotest.domain.service.CaseQuery;
import com.flyingrain.autotest.domain.service.CaseService;
import com.flyingrain.autotest.domain.service.ServiceManager;
import com.flyingrain.autotest.facade.intf.model.AutoTestCase;
import com.flyingrain.autotest.facade.intf.requests.BatchDelRequest;
import com.flyingrain.autotest.facade.intf.testcase.CaseFacade;
import com.flyingrain.autotest.facade.intf.testcase.CaseQueryRequest;
import com.flyingrain.autotest.mvc.jersey.Resource;
import com.flyingrain.autotest.service.convert.CaseViewConvert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class CaseFacadeImpl implements CaseFacade, Resource {

    private final Logger logger = LoggerFactory.getLogger(CaseFacadeImpl.class);

    @Autowired
    private CaseService caseService;

    @Autowired
    private ServiceManager serviceManager;


    @Override

    public CommonResult<PageableModel<AutoTestCase>> queryCasesByPage(PageQuery<CaseQueryRequest> caseQueryRequestPageQuery) {
        logger.info("query case param:[{}]", caseQueryRequestPageQuery);
        PageableModel<Case> queryResult = caseService.queryByPage(new PageQuery<>(caseQueryRequestPageQuery.getCurrentPage(), caseQueryRequestPageQuery.getPageSize(), buildCaseQuery(caseQueryRequestPageQuery.getConditions())));
        PageableModel<AutoTestCase> viewResult = PageableModel.copy(queryResult);
        viewResult.setData(queryResult.getData().stream().map(CaseViewConvert::convertCaseModel).collect(Collectors.toList()));
        return CommonResult.success(viewResult);
    }

    private CaseQuery buildCaseQuery(CaseQueryRequest conditions) {
        if (conditions == null) {
            return null;
        }
        CaseQuery caseQuery = new CaseQuery();
        BeanUtils.copyProperties(conditions, caseQuery);
        caseQuery.setResultCollectConfig(conditions.getResponseConfig());
        return caseQuery;
    }

    @Override
    public CommonResult<Integer> batchDel(BatchDelRequest batchDelRequest) {
        logger.info("start to del case:[{}]", batchDelRequest);
        int count = caseService.batchDel(batchDelRequest.getIds());
        return CommonResult.success(count);
    }

    @Override
    public CommonResult<Boolean> update(AutoTestCase autoTestCase) {
        User user = RunTimeContext.get(AutoTestConstants.USER);
        if (user == null) {
            logger.error("user not find! opt terminated!");
            throw new AutoTestException(AutoTestResultCodeEnum.USER_NOT_EXIST);
        }
        if (autoTestCase.getId() == 0) {
            throw new AutoTestException(AutoTestResultCodeEnum.PARAM_ERROR.getCode(), "case id 为空");
        }
        autoTestCase.setModifier(user.getUserName());
        logger.info("user:[{}] update case:[{}]", user, autoTestCase);
        int i = caseService.update(CaseViewConvert.convertCaseView(autoTestCase));
        return CommonResult.success(i == 1);
    }

    @Override
    public CommonResult<Boolean> insert(AutoTestCase autoTestCase) {
        User user = RunTimeContext.get(AutoTestConstants.USER);
        if (user == null) {
            logger.error("user not find! opt terminated!");
            throw new AutoTestException(AutoTestResultCodeEnum.USER_NOT_EXIST);
        }
        autoTestCase.setCreator(user.getUserName());
        boolean r = caseService.insert(CaseViewConvert.convertCaseView(autoTestCase));
        return CommonResult.success(r);
    }

    @Override
    public CommonResult<AutoTestCase> detail(Integer id) {
        Case testCase = caseService.queryDetail(id);

        return CommonResult.success(CaseViewConvert.convertCaseModel(testCase));
    }

    @Override
    public CommonResult<String> start(Integer id) {
        String result = caseService.run(id);
        return CommonResult.success(result);
    }
}
