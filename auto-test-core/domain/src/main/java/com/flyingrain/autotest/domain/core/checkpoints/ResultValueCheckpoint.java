package com.flyingrain.autotest.domain.core.checkpoints;

import com.flyingrain.autotest.common.util.CompareRuleEnum;
import com.flyingrain.autotest.domain.core.model.CheckResult;
import com.flyingrain.autotest.domain.core.model.CheckRule;
import com.flyingrain.autotest.domain.core.model.ExecuteResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResultValueCheckpoint implements CheckPoint {

    private final Logger logger = LoggerFactory.getLogger(ResultValueCheckpoint.class);
    private CheckRule checkRule;

    private CompareRuleEnum compareRuleEnum;

    @Override
    public CheckResult check(ExecuteResult executeResult) {
        CheckResult checkResult = new CheckResult();
        try {
            checkResult = checkRule.check(executeResult);
        } catch (Exception e) {
            logger.error("check resultValue failed!:",e);
            checkResult.setValid(false);
            checkResult.setMessage(e.getMessage());
        }
        return checkResult;
    }

    public CheckRule getCheckRule() {
        return checkRule;
    }

    public void setCheckRule(CheckRule checkRule) {
        this.checkRule = checkRule;
    }

    public CompareRuleEnum joinRule() {
        return compareRuleEnum;
    }

    public void setCompareRuleEnum(CompareRuleEnum compareRuleEnum) {
        this.compareRuleEnum = compareRuleEnum;
    }

    @Override
    public String toString() {
        return "ResultValueCheckpoint{" +
                "checkRule=" + checkRule +
                ", compareRuleEnum=" + compareRuleEnum +
                '}';
    }
}
