package com.flyingrain.autotest.domain.core.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CheckRule {

    private final Logger logger = LoggerFactory.getLogger(CheckRule.class);
    private List<CheckParam> checkParams = new ArrayList<>();


    public CheckResult check(ExecuteResult executeResult) {
        Boolean result = null;
        CheckResult ruleResult = new CheckResult();
        ruleResult.setValid(true);
        for (CheckParam checkParam : checkParams) {
            CheckResult checkResult = checkParam.check(executeResult);
            result = switch (checkParam.getCompareRuleEnum()) {
                case AND -> result == null ? checkResult.getValid() : result && checkResult.getValid();
                case OR -> result == null ? checkResult.getValid() : result || checkResult.getValid();
            };
            if (!checkResult.getValid()) {
                logger.warn("rule check failed![{}]", checkParam);
                ruleResult.setMessage("rule " + checkParam.getCheckKey() + " failed! " + checkResult.getMessage());
            }
        }
        if (result == null || !result) {
            ruleResult.setValid(result);
        }
        return ruleResult;
    }


    public List<CheckParam> getCheckParams() {
        return checkParams;
    }

    public void setCheckParams(List<CheckParam> checkParams) {
        this.checkParams = checkParams;
    }


}
