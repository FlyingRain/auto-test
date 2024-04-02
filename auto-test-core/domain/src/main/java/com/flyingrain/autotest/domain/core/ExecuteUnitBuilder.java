package com.flyingrain.autotest.domain.core;

import com.flyingrain.autotest.common.util.AutoTestResultCodeEnum;
import com.flyingrain.autotest.common.util.exception.AutoTestException;
import com.flyingrain.autotest.domain.core.executor.Executor;
import com.flyingrain.autotest.domain.core.model.ExecuteParam;
import com.flyingrain.autotest.domain.model.Case;
import com.flyingrain.autotest.domain.model.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ExecuteUnitBuilder {

    private final Logger logger = LoggerFactory.getLogger(ExecuteUnitBuilder.class);

    @Autowired
    private ParamExtractor paramExtractor;

    @Autowired
    private Map<String, Executor> executorMap;

    public ExecuteUnit buildExecuteUnit(Case runCase, ExecuteContext executeContext) {
        ExecuteUnit executeUnit = new ExecuteUnit();
        Service service = runCase.getService();
        ExecuteParam executeParam = paramExtractor.extract(runCase, executeContext);
        executeUnit.setExecuteParam(executeParam);
        Executor executor = executorMap.get(service.getProtocolType());
        if (executor == null) {
            logger.error("can't get execute:[{}]", service);
            throw new AutoTestException(AutoTestResultCodeEnum.ERROR_TYPE_FORMAT);
        }
        executeUnit.setExecutor(executor);

        return executeUnit;
    }

}
