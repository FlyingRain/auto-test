package com.flyingrain.autotest.domain.core.executor;

import com.flyingrain.autotest.domain.core.model.ExecuteParam;
import com.flyingrain.autotest.domain.core.model.ExecuteResult;

public interface Executor<T> {

    ExecuteResult execute(ExecuteParam<T> executeParam);

}
