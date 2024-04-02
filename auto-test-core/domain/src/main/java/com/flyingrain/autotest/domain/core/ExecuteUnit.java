package com.flyingrain.autotest.domain.core;

import com.flyingrain.autotest.domain.core.executor.Executor;
import com.flyingrain.autotest.domain.core.model.CheckResult;
import com.flyingrain.autotest.domain.core.model.ExecuteParam;
import com.flyingrain.autotest.domain.core.model.ExecuteResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

/**
 * 执行单元
 */
public class ExecuteUnit<R> {

    private final Logger logger = LoggerFactory.getLogger(ExecuteUnit.class);

    private ExecuteParam<R> executeParam;

    private Executor<R> executor;

    private ResultExtract resultExtract;

    private List<CheckPoint> checkPoints;


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
        ExecuteResult executeResult = executor.execute(executeParam);

        resultExtract.extractResult(executeResult, executeContext);

        CheckResult checkResult = runCheckPoints();

        recordRunLog(executeResult, checkResult);
    }

    private void recordRunLog(ExecuteResult executeResult, CheckResult checkResult) {

    }

    private CheckResult runCheckPoints() {


    }


    public void setExecuteParam(ExecuteParam<R> executeParam) {
        this.executeParam = executeParam;
    }

    public void setExecutor(Executor<R> executor) {
        this.executor = executor;
    }

    public void setResultExtract(ResultExtract resultExtract) {
        this.resultExtract = resultExtract;
    }

    public void setCheckPoints(List<CheckPoint> checkPoints) {
        this.checkPoints = checkPoints;
    }
}
