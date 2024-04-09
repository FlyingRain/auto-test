package com.flyingrain.autotest.domain.core.checkpoints;

import com.flyingrain.autotest.common.util.CompareRuleEnum;
import com.flyingrain.autotest.domain.core.model.CheckResult;
import com.flyingrain.autotest.domain.core.model.ExecuteResult;

public interface CheckPoint {

    CheckResult check(ExecuteResult executeResult);

    CompareRuleEnum joinRule();
}
