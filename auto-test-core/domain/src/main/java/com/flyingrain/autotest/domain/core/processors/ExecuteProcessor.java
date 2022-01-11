package com.flyingrain.autotest.domain.core.processors;

import com.flyingrain.autotest.domain.model.RunContext;

/**
 * @author wally
 * @date 2021-12-13
 */
public interface ExecuteProcessor {

    void beforeExecute(RunContext runContext);


    void postProcess(RunContext runContext);
}
