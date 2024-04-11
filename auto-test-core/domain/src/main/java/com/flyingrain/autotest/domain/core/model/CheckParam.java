package com.flyingrain.autotest.domain.core.model;

import com.flyingrain.autotest.common.util.CompareRuleEnum;
import com.flyingrain.autotest.common.util.NumberUtils;
import com.flyingrain.autotest.common.util.OperateRuleEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Objects;

public class CheckParam {

    private final Logger logger = LoggerFactory.getLogger(CheckParam.class);
    private String checkKey;

    private OperateRuleEnum operateRuleEnum;

    private String checkValue;

    private CompareRuleEnum compareRuleEnum;


    public CheckResult check(ExecuteResult executeResult) {
        CheckResult checkResult = new CheckResult();
        Map<String, String> params = executeResult.getResultMap();
        String value = params.get(checkKey);
        logger.info("start to check value:[{}],expect:[{}]", value, checkValue);
        checkResult.setMessage("check key:" + checkKey + ",value:" + value + ",expect:" + checkValue);
        if (NumberUtils.isNumeric(value)) {
            double numberValue = Double.parseDouble(value);
            double checkNumberValue = Double.parseDouble(checkValue);
            checkResult.setValid(compareNumber(numberValue, checkNumberValue));
        } else {
            checkResult.setValid(compareStr(value, checkValue));
        }
        return checkResult;
    }


    public boolean compareStr(String v1, String v2) {
        if ("null".equals(v2)) {
            v2 = null;
        }
        switch (operateRuleEnum) {
            case EQUAL:
                return Objects.equals(v1, v2);
            case NOT_EQUAL:
                return !Objects.equals(v1, v2);
            case OUTWEIGH:
            case LESS_EQUAL:
            case OUTWEIGH_EQUAL:
            case LESS:
                logger.error("str not support opt:[{}]", operateRuleEnum);
                break;

        }
        return false;
    }

    public boolean compareNumber(double v1, double v2) {
        return switch (operateRuleEnum) {
            case OUTWEIGH_EQUAL -> v1 >= v2;
            case OUTWEIGH -> v1 > v2;
            case EQUAL -> v1 == v2;
            case LESS -> v1 < v2;
            case NOT_EQUAL -> v1 != v2;
            case LESS_EQUAL -> v1 <= v2;
        };
    }


    public String getCheckKey() {
        return checkKey;
    }

    public void setCheckKey(String checkKey) {
        this.checkKey = checkKey;
    }

    public OperateRuleEnum getOperateRuleEnum() {
        return operateRuleEnum;
    }

    public void setOperateRuleEnum(OperateRuleEnum operateRuleEnum) {
        this.operateRuleEnum = operateRuleEnum;
    }

    public String getCheckValue() {
        return checkValue;
    }

    public void setCheckValue(String checkValue) {
        this.checkValue = checkValue;
    }

    public CompareRuleEnum getCompareRuleEnum() {
        return compareRuleEnum;
    }

    public void setCompareRuleEnum(CompareRuleEnum compareRuleEnum) {
        this.compareRuleEnum = compareRuleEnum;
    }

    @Override
    public String toString() {
        return "CheckParam{" +
                "checkKey='" + checkKey + '\'' +
                ", operateRuleEnum=" + operateRuleEnum +
                ", checkValue='" + checkValue + '\'' +
                '}';
    }
}
