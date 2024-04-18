package com.flyingrain.autotest.domain.core.checkpoints;

import com.flyingrain.autotest.common.util.CompareRuleEnum;
import com.flyingrain.autotest.domain.core.model.CheckResult;
import com.flyingrain.autotest.domain.core.model.ExecuteResult;

public class MessageCheckPoint implements CheckPoint {

    private String message;

    private CompareRuleEnum compareRuleEnum;

    public MessageCheckPoint(String message) {
        this.message = message;
    }

    @Override
    public CheckResult check(ExecuteResult executeResult) {
        CheckResult checkResult = new CheckResult();
        String result = executeResult.getResult();
        if (result == null) {
            checkResult.setValid(false);
            checkResult.setMessage("返回值为null");
        }else{
            checkResult.setValid(result.equals(message));
        }
        if(!checkResult.getValid()){
            checkResult.setMessage("报文校验失败，返回报文和预测报文不一致！");
        }
        return checkResult;
    }
    public void setCompareRuleEnum(CompareRuleEnum compareRuleEnum) {
        this.compareRuleEnum = compareRuleEnum;
    }

    @Override
    public CompareRuleEnum joinRule() {
        return compareRuleEnum;
    }
}
