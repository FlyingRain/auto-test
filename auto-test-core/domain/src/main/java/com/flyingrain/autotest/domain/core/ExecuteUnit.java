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
        runLog.setCaseCode(aCase.getCode());
        runLog.setMessage(checkResult.getMessage());
        if (StringUtils.hasText(executeResult.getResult())) {
            executeResult.setResult(executeResult.getResult().length() > 1024 ? executeResult.getResult().substring(0, 1024) : executeResult.getResult());
            runLog.setRunResult(executeResult.getResult());
        }
        runLog.setExecutor(executeContext.getExecutor());
        runLogService.insertRunLog(runLog);
    }

    private CheckResult runCheckPoints(ExecuteResult executeResult) {
        CheckResult checkResult = new CheckResult();
        if (!executeResult.isSuccess()) {
            checkResult.setValid(false);
            checkResult.setMessage(executeResult.getExtractResult());
            return checkResult;
        }
        if (CollectionUtils.isEmpty(checkPoints)) {
            checkResult.setValid(true);
            return checkResult;
        }
        Boolean temp = null;
        CompareRuleEnum compareRuleEnum = null;
        for (CheckPoint check : checkPoints) {
            CheckResult result = check.check(executeResult);
            if (compareRuleEnum != null) {
                switch (compareRuleEnum) {
                    case OR:
                        temp = result.getValid() || temp;
                        break;
                    case AND:
                        temp = result.getValid() && temp;
                        break;
                    default:
                        throw new AutoTestException(AutoTestResultCodeEnum.FAIL.getCode(), "不支持的运算类型");
                }
            } else {
                temp = result.getValid();
            }
            if (!temp) {
                logger.error("check point failed![{}]", result.getMessage());
                checkResult.setMessage(result.getMessage());
            }
            compareRuleEnum = check.joinRule();
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
