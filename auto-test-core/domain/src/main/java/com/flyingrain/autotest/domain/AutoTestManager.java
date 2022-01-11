package com.flyingrain.autotest.domain;

import com.flyingrain.autotest.domain.constant.AutoTestResultCodeEnum;
import com.flyingrain.autotest.domain.core.executor.AutoTestExecutor;
import com.flyingrain.autotest.domain.core.loader.CommonModelLoader;
import com.flyingrain.autotest.domain.core.processors.ExecuteProcessor;
import com.flyingrain.autotest.domain.exception.AutoTestException;
import com.flyingrain.autotest.domain.model.Case;
import com.flyingrain.autotest.domain.model.Model;
import com.flyingrain.autotest.domain.model.RunContext;
import com.flyingrain.autotest.domain.model.RunLog;
import com.flyingrain.autotest.domain.model.runresult.RunResult;
import com.flyingrain.autotest.domain.service.RunLogService;
import com.flyingrain.autotest.facade.intf.requests.ModelTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author wally
 * @date 2021-12-10
 */
@Component
public class AutoTestManager {

    private static final Logger logger = LoggerFactory.getLogger(AutoTestManager.class);

    @Autowired
    private CommonModelLoader commonModelLoader;

    @Autowired
    private List<ExecuteProcessor> executeProcessors;

    @Autowired
    private RunLogService runLogService;

    @Autowired
    private AutoTestExecutor autoTestExecutor;

    public RunResult runModel(long moduleId, ModelTypeEnum modelTypeEnum) {

        Model model = loadModel(moduleId, modelTypeEnum);

        RunContext runContext = buildRunContext(model);
        try {
            beforeExecute(runContext);

            execute(runContext);

            updateResult(runContext);

            afterExecute(runContext);
        } catch (AutoTestException e) {
            logger.error("execute model happen exception! model:[{}]", runContext.getModel());
            logger.error("execute exception", e);
        } catch (Exception e) {
            logger.error("execute happen unexpected exception!", e);
        }
        return runContext.getResult();
    }

    private void afterExecute(RunContext runContext) {
        if (CollectionUtils.isEmpty(executeProcessors)) {
            return;
        }
        executeProcessors.forEach(executeProcessor -> executeProcessor.postProcess(runContext));
    }

    private void updateResult(RunContext runContext) {
        List<RunLog> runLogs = runContext.getRunLogs();
        runLogService.saveRunLogs(runLogs);
    }

    private void execute(RunContext runContext) {
        autoTestExecutor.execute(runContext);
    }

    private void beforeExecute(RunContext runContext) {
        if (CollectionUtils.isEmpty(executeProcessors)) {
            return;
        }
        executeProcessors.forEach(executeProcessor -> executeProcessor.beforeExecute(runContext));
    }

    private RunContext buildRunContext(Model model) {
        RunContext runContext = new RunContext();
        runContext.setModel(model);
        List<Case> cases = commonModelLoader.loadModelCases(model);
        if (CollectionUtils.isEmpty(cases)) {
            logger.error("no case to run! model:[{}]", model);
            throw new AutoTestException(AutoTestResultCodeEnum.NO_TEST_CASE);
        }
        runContext.setRunCases(cases);
        return runContext;
    }

    private Model loadModel(long modelId, ModelTypeEnum modelTypeEnum) {
        Model model = commonModelLoader.loadModel(modelId, modelTypeEnum);
        if (model == null) {
            logger.error("load model failed!modelId:[{}]", modelId);
            throw new AutoTestException(AutoTestResultCodeEnum.MODEL_NOT_EXIST);
        }
        return model;
    }


}
