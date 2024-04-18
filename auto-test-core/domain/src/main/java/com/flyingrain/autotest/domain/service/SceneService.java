package com.flyingrain.autotest.domain.service;

import com.flyingrain.autotest.common.util.*;
import com.flyingrain.autotest.common.util.constant.AutoTestConstants;
import com.flyingrain.autotest.common.util.exception.AutoTestException;
import com.flyingrain.autotest.domain.core.ExecuteContext;
import com.flyingrain.autotest.domain.core.ExecuteUnit;
import com.flyingrain.autotest.domain.core.ExecuteUnitBuilder;
import com.flyingrain.autotest.domain.core.model.CheckResult;
import com.flyingrain.autotest.domain.model.*;
import com.flyingrain.autotest.domain.service.convert.SceneCaseModelConvert;
import com.flyingrain.autotest.domain.service.convert.SceneModelConvert;
import com.flyingrain.autotest.infrastructure.datasource.mapper.AutoTestCaseSceneMapper;
import com.flyingrain.autotest.infrastructure.datasource.mapper.AutoTestSceneMapper;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestSceneCaseModel;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestSceneModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Component
public class SceneService {

    private final Logger logger = LoggerFactory.getLogger(SceneService.class);

    @Autowired
    private AutoTestCaseSceneMapper autoTestCaseSceneMapper;

    @Autowired
    private AutoTestSceneMapper autoTestSceneMapper;

    @Autowired
    private CaseService caseService;

    @Autowired
    private ExecuteUnitBuilder executeUnitBuilder;

    private final ThreadPoolExecutor executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 2, Runtime.getRuntime().availableProcessors() * 10, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000));

    @Transactional
    public boolean add(Scene scene) {
        logger.info("start to add scene:[{}]", scene);
        AutoTestSceneModel autoTestSceneModel = SceneModelConvert.convertToModel(scene);
        int count = autoTestSceneMapper.insert(autoTestSceneModel);
        scene.setId(autoTestSceneModel.getId());
        if (!CollectionUtils.isEmpty(scene.getSceneCases())) {
            logger.info("start to add sceneCase :[{}]", scene.getSceneCases().size());
            List<AutoTestSceneCaseModel> autoTestSceneCaseModels = scene.getSceneCases().stream().peek(sceneCase -> sceneCase.setSceneId(scene.getId())).map(SceneCaseModelConvert::convertToModel).collect(Collectors.toList());
            autoTestCaseSceneMapper.batchInsert(autoTestSceneCaseModels);
        }
        return count == 1;
    }

    public PageableModel<Scene> queryByPage(PageQuery<Scene> pageQuery) {
        logger.info("query scene page:[{}]", pageQuery);
        PageQuery<AutoTestSceneModel> queryCondition = new PageQuery<>(pageQuery.getCurrentPage(), pageQuery.getPageSize(), SceneModelConvert.convertToModel(pageQuery.getConditions()));
        List<AutoTestSceneModel> autoTestSceneModelList = autoTestSceneMapper.queryByPage(queryCondition);
        int count = autoTestSceneMapper.queryByPageCount(queryCondition);
        PageableModel<Scene> result = new PageableModel<>();
        result.copyOf(pageQuery);
        result.setData(autoTestSceneModelList.stream().map(SceneModelConvert::convertToDomain).collect(Collectors.toList()));
        result.setTotal(count);
        return result;
    }

    @Transactional
    public boolean update(Scene scene) {
        logger.info("update scene:[{}]", scene);
        autoTestCaseSceneMapper.deleteBySceneId(scene.getId());
        autoTestSceneMapper.updateById(SceneModelConvert.convertToModel(scene));
        if (!CollectionUtils.isEmpty(scene.getSceneCases())) {
            autoTestCaseSceneMapper.batchInsert(scene.getSceneCases().stream().map(SceneCaseModelConvert::convertToModel).collect(Collectors.toList()));
        }
        return true;
    }

    @Transactional
    public boolean delete(Integer sceneId) {
        logger.info("start to del scene:[{}]", sceneId);
        autoTestCaseSceneMapper.deleteBySceneId(sceneId);
        autoTestSceneMapper.batchDel(Collections.singletonList(sceneId));
        return true;
    }

    public Scene detail(Integer sceneId) {
        logger.info("query scene id:[{}]", sceneId);
        AutoTestSceneModel autoTestSceneModel = autoTestSceneMapper.detail(sceneId);
        Scene scene = SceneModelConvert.convertToDomain(autoTestSceneModel);
        fillScene(scene);
        return scene;
    }


    private void fillScene(Scene scene) {
        List<AutoTestSceneCaseModel> autoTestSceneCaseModels = autoTestCaseSceneMapper.queryAllSceneCase(scene.getId());
        if (CollectionUtils.isEmpty(autoTestSceneCaseModels)) {
            return;
        }
        List<Integer> caseIds = autoTestSceneCaseModels.stream().map(AutoTestSceneCaseModel::getCaseId).distinct().toList();
        List<Case> cases = caseService.queryFilledCaseByIds(caseIds);
        List<SceneCase> sceneCases = autoTestSceneCaseModels.stream().map(autoTestSceneCaseModel -> {
            SceneCase sceneCase = SceneCaseModelConvert.convertToDomain(autoTestSceneCaseModel);
            for (Case runCase : cases) {
                if (sceneCase.getCaseId() == runCase.getId()) {
                    sceneCase.setRunCase(runCase);
                }
            }
            if (sceneCase.getRunCase() == null) {
                throw new AutoTestException(AutoTestResultCodeEnum.FAIL.getCode(), "[" + scene.getSceneName() + "]场景下用例不存在，或已被删除，场景编码：" + scene.getSceneCode() + ",用例id：" + sceneCase.getCaseId());
            }
            return sceneCase;
        }).toList();
        scene.setSceneCases(sceneCases);
    }

    /**
     * 执行场景
     * 1.构建执行上下文
     * 2.构建执行单元
     * 3.组装执行链
     * 4.生成执行任务
     * 5.开始执行
     * 6.生成执行报告
     *
     * @param sceneId
     * @return
     */
    public String run(Integer sceneId) {
        User user = RunTimeContext.get(AutoTestConstants.USER);
        if (user == null) {
            throw new AutoTestException(AutoTestResultCodeEnum.NOT_LOGIN);
        }
        Scene scene = detail(sceneId);
        if (scene == null) {
            logger.error("scene not exist:[{}]", sceneId);
            throw new AutoTestException(AutoTestResultCodeEnum.PARAM_NOT_EXIST);
        }
        if (CollectionUtils.isEmpty(scene.getSceneCases())) {
            logger.error("no case to run![{}]", sceneId);
            throw new AutoTestException(AutoTestResultCodeEnum.NO_TEST_CASE);
        }

        ExecuteContext executeContext = buildRunContext(scene, user);

        ExecuteReport executeReport = generateExeReport(scene, user, executeContext);

        List<ExecuteUnit> executeUnits = initUnit(scene);

        executor.execute(() -> {
            int count = 0;
            long startTime = System.currentTimeMillis() / 1000;
            boolean success = true;
            int successCount = 0;
            for (ExecuteUnit unit : executeUnits) {
                try {
                    count++;
                    CheckResult checkResult = unit.run(executeContext);
                    if (!checkResult.getValid()) {
                        success = false;
                    } else {
                        successCount++;
                    }
                } catch (Exception e) {
                    logger.error("execute unit error！", e);
                    logger.error("error unit  info :[{}]", unit);
                    break;
                }
            }
            long endTime = System.currentTimeMillis() / 1000;
            executeReport.setRunNumber(count);
            executeReport.setSuccessNumber(successCount);
            executeReport.setResult(success ? RunStatusEnum.SUCCESS.getCode() : RunStatusEnum.FAIL.getCode());
            executeReport.setConsumeTime(endTime - startTime);
            //TODO 更新报告
        });

        return executeContext.getExecuteCode();
    }

    private ExecuteReport generateExeReport(Scene scene, User user, ExecuteContext executeContext) {
        ExecuteReport executeReport = new ExecuteReport();
        executeReport.setOperator(user.getUserName());
        executeReport.setExecuteTime(new Date());
        executeReport.setResult(RunStatusEnum.EXECUTING.getCode());
        executeReport.setBatchNum(executeContext.getExecuteCode());
        executeReport.setTitle(scene.getSceneCode());
        executeReport.setCaseNumber(scene.getSceneCases().size());
        return executeReport;
    }

    private List<ExecuteUnit> initUnit(Scene scene) {
        List<ExecuteUnit> executeUnits = scene.getSceneCases().stream().sorted(Comparator.comparingInt(SceneCase::getExecuteOrder)).map(SceneCase::getRunCase).map(runCase -> executeUnitBuilder.buildExecuteUnit(runCase)).toList();
        return executeUnits;
    }

    private ExecuteContext buildRunContext(Scene scene, User user) {
        ExecuteContext executeContext = new ExecuteContext();
        String batchNum = scene.getSceneCode() + "_" + UUID.randomUUID().toString().replace("-", "");
        executeContext.setExecutor(user.getUserName());
        executeContext.setExecuteCode(batchNum);
        return executeContext;
    }
}
