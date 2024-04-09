package com.flyingrain.autotest.domain.core.request;

import com.flyingrain.autotest.domain.core.ExecuteContext;
import com.flyingrain.autotest.domain.core.model.ExecuteParam;

public interface RequestAssemble {

    ExecuteParam assembleRequest(ExecuteContext executeContext);

}
