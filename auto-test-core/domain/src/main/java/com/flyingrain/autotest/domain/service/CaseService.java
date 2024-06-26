package com.flyingrain.autotest.domain.service;

import com.flyingrain.autotest.common.util.AutoTestResultCodeEnum;
import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.common.util.PageableModel;
import com.flyingrain.autotest.common.util.RunTimeContext;
import com.flyingrain.autotest.common.util.constant.AutoTestConstants;
import com.flyingrain.autotest.common.util.exception.AutoTestException;
import com.flyingrain.autotest.domain.core.CaseExecutorHelper;
import com.flyingrain.autotest.domain.core.ExecuteContext;
import com.flyingrain.autotest.domain.core.ExecuteUnit;
import com.flyingrain.autotest.domain.core.ExecuteUnitBuilder;
import com.flyingrain.autotest.domain.model.*;
import com.flyingrain.autotest.domain.service.convert.CaseModelConvert;
import com.flyingrain.autotest.infrastructure.datasource.AutoTestCaseQuery;
import com.flyingrain.autotest.infrastructure.datasource.mapper.AutoTestCaseMapper;
import com.flyingrain.autotest.infrastructure.datasource.mapper.AutoTestSceneMapper;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestCaseModel;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestSceneModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class CaseService {

    private final Logger logger = LoggerFactory.getLogger(CaseService.class);

    @Autowired
    private AutoTestCaseMapper autoTestCaseMapper;

    @Autowired
    private ExecuteUnitBuilder executeUnitBuilder;

    @Autowired
    private ServiceManager serviceManager;

    @Autowired
    private AutoTestSceneMapper autoTestSceneMapper;

    @Autowired
    private GlobalConfigService globalConfigService;

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
        List<AutoTestSceneModel> scenes = queryCaseScenes(ids);
        if (CollectionUtils.isEmpty(scenes)) {
            return autoTestCaseMapper.batchDel(ids);
        } else {
            throw new AutoTestException(AutoTestResultCodeEnum.FAIL.getCode(), "该用例有场景正在使用，请先移除场景 " + scenes.get(0).getSceneCode() + " 下的用例");
        }
    }

    private List<AutoTestSceneModel> queryCaseScenes(List<Integer> ids) {
        return autoTestSceneMapper.queryByCaseId(ids);
    }

    public int update(Case testCase) {
        logger.info("update case:[{}]", testCase);
        return autoTestCaseMapper.updateCaseById(CaseModelConvert.convertCase(testCase));
    }

    public Case queryDetail(Integer caseId) {
        Case testCase = CaseModelConvert.convertCaseModel(autoTestCaseMapper.queryCaseById(caseId));
        Service service = serviceManager.queryById(testCase.getServiceId());
        testCase.setService(service);
        Map<String,String> params = new HashMap<>();
        fillGlobal(params);
        CaseExecutorHelper.fillDynamicParam(testCase, params);
        return testCase;
    }

    public String run(Integer caseId) {
        Case testCase = queryDetail(caseId);
        logger.info("start to build executeUnit caseId:[{}]", caseId);
        ExecuteUnit executeUnit = executeUnitBuilder.buildExecuteUnit(testCase);
        String runId = UUID.randomUUID().toString().replace("-", "");
        User user = RunTimeContext.get(AutoTestConstants.USER);
        ExecuteContext executeContext = buildExecuteContext(runId, user);
        logger.info("start to run case:[{}]", executeUnit);
        executeUnit.run(executeContext);
        return runId;
    }

    private ExecuteContext buildExecuteContext(String runId, User user) {
        ExecuteContext executeContext = new ExecuteContext();
        executeContext.setExecuteCode(runId);
        executeContext.setExecutor(user == null ? null : user.getUserName());
        Map<String, String> params = executeContext.getParams();
        fillGlobal(params);
        return executeContext;
    }

    private void fillGlobal(Map<String, String> params) {
        List<GlobalConfig> globalConfigList = globalConfigService.queryAll();
        if (!CollectionUtils.isEmpty(globalConfigList)) {
            globalConfigList.forEach(globalConfig -> {
                params.put(globalConfig.getParamKey(), globalConfig.getParamValue());
            });
        }
    }

    /**
     * 这里查询用例的详细信息，并用填充好service，为后续执行做准备
     *
     * @param caseIds
     * @return
     */
    public List<Case> queryFilledCaseByIds(List<Integer> caseIds) {
        List<AutoTestCaseModel> autoTestCaseModels = autoTestCaseMapper.queryCaseByIds(caseIds);
        if (!CollectionUtils.isEmpty(autoTestCaseModels)) {
            List<Integer> serviceIds = autoTestCaseModels.stream().map(AutoTestCaseModel::getServiceId).distinct().toList();
            List<Service> services = serviceManager.queryServiceByIds(serviceIds);
            return autoTestCaseModels.stream().map(autoTestCaseModel -> {
                Case runCase = CaseModelConvert.convertCaseModel(autoTestCaseModel);
                for (Service service : services) {
                    if (service.getId() == runCase.getServiceId()) {
                        runCase.setService(service);
                        break;
                    }
                }
                if (runCase.getService() == null) {
                    throw new AutoTestException(AutoTestResultCodeEnum.FAIL.getCode(), "用例服务不存在，用例编码:" + runCase.getCode() + ",服务id：" + runCase.getServiceId());
                }
                return runCase;
            }).toList();
        }
        return new ArrayList<>();
    }

    public List<Case> queryByServiceIds(List<Integer> serviceIds) {
        List<AutoTestCaseModel> autoTestCaseModels = autoTestCaseMapper.queryByServiceIds(serviceIds);
        return autoTestCaseModels.stream().map(CaseModelConvert::convertCaseModel).collect(Collectors.toList());
    }


    private AutoTestCaseQuery buildQuery(CaseQuery conditions) {
        AutoTestCaseQuery autoTestCaseQuery = new AutoTestCaseQuery();
        autoTestCaseQuery.setServiceId(conditions.getServiceId());
        autoTestCaseQuery.setId(conditions.getId());
        autoTestCaseQuery.setName(conditions.getName());
        autoTestCaseQuery.setCode(conditions.getCode());
        autoTestCaseQuery.setCreator(conditions.getCreator());
        autoTestCaseQuery.setSceneId(conditions.getSceneId());
        autoTestCaseQuery.setAppId(conditions.getAppId());
        return autoTestCaseQuery;
    }
}
