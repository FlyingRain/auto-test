package com.flyingrain.autotest.domain.core;

import com.flyingrain.autotest.common.util.AutoTestResultCodeEnum;
import com.flyingrain.autotest.common.util.CompareRuleEnum;
import com.flyingrain.autotest.common.util.RunLogStatusEnum;
import com.flyingrain.autotest.common.util.exception.AutoTestException;
import com.flyingrain.autotest.domain.core.checkpoints.CheckPoint;
import com.flyingrain.autotest.domain.core.executor.Executor;
import com.flyingrain.autotest.domain.core.model.CheckResult;
import com.flyingrain.autotest.domain.core.model.ExecuteParam;
import com.flyingrain.autotest.domain.core.model.ExecuteResult;
import com.flyingrain.autotest.domain.core.request.RequestAssemble;
import com.flyingrain.autotest.domain.model.Case;
import com.flyingrain.autotest.domain.model.RunLog;
import com.flyingrain.autotest.domain.service.RunLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 执行单元
 */
public class ExecuteUnit<R> {

    private final Logger logger = LoggerFactory.getLogger(ExecuteUnit.class);

    private RequestAssemble requestAssemble;

    private Executor<R> executor;

    private ResultExtract resultExtract;

    private List<CheckPoint> checkPoints;

    private RunLogService runLogService;

    private Case aCase;


    /**
     * 执行
     *
     * @return
     */
    public void run(ExecuteContext executeContext) {
        if (StringUtils.hasText(executeContext.getExecuteCode())) {
            String runId = UUID.randomUUID().toString().replace("-", "");
            executeContext.setExecuteCode(runId);
            logger.info("runCase log id :[{}]", runId);
        }
        ExecuteParam executeParam = requestAssemble.assembleRequest(executeContext);

        ExecuteResult executeResult = executor.execute(executeParam);

        resultExtract.extractResult(executeResult, executeContext);

        CheckResult checkResult = runCheckPoints(executeResult);

        recordRunLog(executeResult, checkResult, executeContext);
    }

    private void recordRunLog(ExecuteResult executeResult, CheckResult checkResult, ExecuteContext executeContext) {
        Date executeTime = new Date();
        RunLog runLog = new RunLog();
        runLog.setBatchNum(executeContext.getExecuteCode());
        runLog.setRunStatus(checkResult.getValid() ? RunLogStatusEnum.SUCCESS.getCode() : RunLogStatusEnum.FAIL.getCode());
        runLog.setExecuteTime(executeTime);
        runLog.setCaseSpendTime(executeResult.getSpendTime());
        runLog.setCaseId(aCase.getId());
        runLog.setMessage(checkResult.getMessage());
        runLog.setExecutor(executeContext.getExecutor());
        runLogService.insertRunLog(runLog);
    }

    private CheckResult runCheckPoints(ExecuteResult executeResult) {
        CheckResult checkResult = new CheckResult();
        if (CollectionUtils.isEmpty(checkPoints)) {
            checkResult.setValid(true);
            return checkResult;
        }
        Boolean temp = null;
        for (CheckPoint check : checkPoints) {
            CheckResult result = check.check(executeResult);
            CompareRuleEnum compareRuleEnum = check.joinRule();
            switch (compareRuleEnum) {
                case OR:
                    temp = temp == null ? result.getValid() : result.getValid() || temp;
                    break;
                case AND:
                    temp = temp == null ? result.getValid() : result.getValid() && temp;
                    break;
                default:
                    throw new AutoTestException(AutoTestResultCodeEnum.FAIL.getCode(), "不支持的运算类型");
            }
            if (!temp) {
                logger.error("check point failed![{}]", result.getMessage());
                checkResult.setMessage(result.getMessage());
            }
        }
        checkResult.setValid(temp);
        return checkResult;
    }

    public RequestAssemble getRequestAssemble() {
        return requestAssemble;
    }

    public void setRequestAssemble(RequestAssemble requestAssemble) {
        this.requestAssemble = requestAssemble;
    }


    public void setExecutor(Executor<R> executor) {
        this.executor = executor;
    }

    public void setRunLogService(RunLogService runLogService) {
        this.runLogService = runLogService;
    }

    public void setResultExtract(ResultExtract resultExtract) {
        this.resultExtract = resultExtract;
    }

    public void setCheckPoints(List<CheckPoint> checkPoints) {
        this.checkPoints = checkPoints;
    }

    public void setaCase(Case aCase) {
        this.aCase = aCase;
    }
}
