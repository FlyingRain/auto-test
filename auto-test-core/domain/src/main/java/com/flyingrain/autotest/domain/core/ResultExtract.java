package com.flyingrain.autotest.domain.core;

import com.flyingrain.autotest.domain.core.model.ExecuteResult;

public interface ResultExtract {

    void extractResult(ExecuteResult executeResult, ExecuteContext executeContext);

}
