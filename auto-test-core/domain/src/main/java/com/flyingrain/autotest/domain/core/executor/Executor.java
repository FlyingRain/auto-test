package com.flyingrain.autotest.domain.core.executor;

import com.flyingrain.autotest.domain.core.model.ExecuteParam;
import com.flyingrain.autotest.domain.core.model.ExecuteResult;

public interface Executor<T> {

    /**
     * 执行器，这里捕捉所有异常
     * @param executeParam
     * @return
     */
    ExecuteResult execute(ExecuteParam<T> executeParam);

}
