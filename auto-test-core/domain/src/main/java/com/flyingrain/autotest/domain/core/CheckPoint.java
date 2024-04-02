package com.flyingrain.autotest.domain.core;

import com.flyingrain.autotest.domain.core.model.CheckResult;
import com.flyingrain.autotest.domain.core.model.ExecuteResult;

public interface CheckPoint {

    CheckResult check(ExecuteResult executeResult);

}
