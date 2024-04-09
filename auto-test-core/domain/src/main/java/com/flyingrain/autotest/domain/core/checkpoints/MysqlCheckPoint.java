package com.flyingrain.autotest.domain.core.checkpoints;

import com.flyingrain.autotest.common.util.CompareRuleEnum;
import com.flyingrain.autotest.domain.core.model.CheckResult;
import com.flyingrain.autotest.domain.core.model.CheckRule;
import com.flyingrain.autotest.domain.core.model.MysqlSourceConfig;
import com.flyingrain.autotest.domain.core.model.ExecuteResult;
import com.flyingrain.autotest.domain.utils.SQLExecutorHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class MysqlCheckPoint implements CheckPoint {

    private final Logger logger = LoggerFactory.getLogger(MysqlCheckPoint.class);

    private MysqlSourceConfig dataSourceConfig;

    private String script;

    private CheckRule checkRule;
    private CompareRuleEnum compareRuleEnum;



    @Override
    public CheckResult check(ExecuteResult executeResult) {
        CheckResult checkResult = new CheckResult();
        try {
            Map<String, String> sqlResult = SQLExecutorHelper.exeSql(dataSourceConfig, script);
            Map<String, String> params = executeResult.getResultMap();
            params.putAll(sqlResult);
            checkResult = checkRule.check(executeResult);
        } catch (Exception e) {
            logger.error("execute mysql rule error!", e);
            checkResult.setValid(false);
            checkResult.setMessage(e.getMessage());
        }
        return checkResult;
    }

    public MysqlSourceConfig getDataSourceConfig() {
        return dataSourceConfig;
    }

    public void setDataSourceConfig(MysqlSourceConfig dataSourceConfig) {
        this.dataSourceConfig = dataSourceConfig;
    }

    public CheckRule getCheckRule() {
        return checkRule;
    }

    public void setCheckRule(CheckRule checkRule) {
        this.checkRule = checkRule;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public CompareRuleEnum joinRule() {
        return compareRuleEnum;
    }

    public void setCompareRuleEnum(CompareRuleEnum compareRuleEnum) {
        this.compareRuleEnum = compareRuleEnum;
    }

    @Override
    public String toString() {
        return "MysqlCheckPoint{" +
                "dataSourceConfig=" + dataSourceConfig +
                ", checkRule=" + checkRule +
                '}';
    }
}
