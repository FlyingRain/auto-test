package com.flyingrain.autotest.domain.core.executor;

import com.flyingrain.autotest.domain.model.RunContext;
import com.flyingrain.autotest.domain.model.runresult.RunResult;

/**
 * @author wally
 * @date 2021-12-13
 */
public interface AutoTestExecutor {

    RunResult execute(RunContext runContext);

}
