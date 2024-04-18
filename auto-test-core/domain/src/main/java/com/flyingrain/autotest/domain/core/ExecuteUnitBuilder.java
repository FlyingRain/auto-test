package com.flyingrain.autotest.domain.core;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.flyingrain.autotest.common.util.*;
import com.flyingrain.autotest.common.util.constant.ProtocolTypeEnum;
import com.flyingrain.autotest.common.util.exception.AutoTestException;
import com.flyingrain.autotest.domain.core.checkpoints.CheckPoint;
import com.flyingrain.autotest.domain.core.checkpoints.MessageCheckPoint;
import com.flyingrain.autotest.domain.core.checkpoints.MysqlCheckPoint;
import com.flyingrain.autotest.domain.core.checkpoints.ResultValueCheckpoint;
import com.flyingrain.autotest.domain.core.executor.Executor;
import com.flyingrain.autotest.domain.core.model.*;
import com.flyingrain.autotest.domain.core.request.HttpRequestAssemble;
import com.flyingrain.autotest.domain.core.request.RequestAssemble;
import com.flyingrain.autotest.domain.model.*;
import com.flyingrain.autotest.domain.service.RunLogService;
import com.flyingrain.autotest.domain.service.SourceConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ExecuteUnitBuilder implements InitializingBean {

    private final Logger logger = LoggerFactory.getLogger(ExecuteUnitBuilder.class);


    @Autowired
    private Map<String, Executor> executorMap;

    @Autowired
    private SourceConfigService sourceConfigService;

    @Autowired
    private RunLogService runLogService;

    private Map<String, DataSourceConf> sourceConfigMap = new HashMap<>(8);


    public ExecuteUnit buildExecuteUnit(Case runCase) {
        ExecuteUnit executeUnit = new ExecuteUnit();
        Service service = runCase.getService();
        String protocolType = service.getProtocolType();

        executeUnit.setRequestAssemble(buildAssemble(runCase));

        executeUnit.setaCase(runCase);

        executeUnit.setRunLogService(runLogService);

        Executor executor = executorMap.get(protocolType);
        if (executor == null) {
            logger.error("can't get execute:[{}]", service);
            throw new AutoTestException(AutoTestResultCodeEnum.NOT_SUPPORT_PROTOCOL);
        }
        executeUnit.setExecutor(executor);

        ResultExtract resultExtract = buildResultExtractor(runCase.getResultCollectConfig());

        executeUnit.setResultExtract(resultExtract);

        List<CheckPoint> checkPoints = buildCheckPoints(runCase.getCheckPoints());

        executeUnit.setCheckPoints(checkPoints);

        return executeUnit;
    }

    private RequestAssemble buildAssemble(Case runCase) {
        Service service = runCase.getService();
        String protocolType = service.getProtocolType();
        ProtocolTypeEnum protocolTypeEnum = ProtocolTypeEnum.valueOf(protocolType);
        switch (protocolTypeEnum) {
            case HTTP:
                List<ParamValue> paramValueList = StringUtils.hasText(runCase.getParamValue()) ? JSONArray.parseArray(runCase.getParamValue()).toJavaList(ParamValue.class) : new ArrayList<>();
                return new HttpRequestAssemble(paramValueList, service);
            default:
                throw new AutoTestException(AutoTestResultCodeEnum.NOT_SUPPORT_PROTOCOL);
        }
    }

    private List<CheckPoint> buildCheckPoints(String checkPoints) {
        List<CheckPoint> checkPointList = new ArrayList<>();
        List<CheckPointConfig> checkPointConfigs = JSONArray.parseArray(checkPoints).toJavaList(CheckPointConfig.class);
        for (CheckPointConfig checkPointConfig : checkPointConfigs) {
            CheckPoint checkPoint = buildCheckPointByConfig(checkPointConfig);
            checkPointList.add(checkPoint);
        }

        return checkPointList;
    }

    private CheckPoint buildCheckPointByConfig(CheckPointConfig checkPointConfig) {
        String checkPointType = checkPointConfig.getCheckPointType();
        CheckTypeEnum checkTypeEnum = CheckTypeEnum.valueOf(checkPointType);
        switch (checkTypeEnum) {
            case MYSQL:
                MysqlCheckPoint mysqlCheckPoint = new MysqlCheckPoint();
                MysqlSourceConfig mysqlSourceConfig = (MysqlSourceConfig) sourceConfigMap.get(checkPointConfig.getSourceCode());
                mysqlCheckPoint.setDataSourceConfig(mysqlSourceConfig);
                mysqlCheckPoint.setScript(checkPointConfig.getScript());
                mysqlCheckPoint.setCompareRuleEnum(StringUtils.hasText(checkPointConfig.getRef()) ? CompareRuleEnum.valueOf(checkPointConfig.getRef()) : null);
                mysqlCheckPoint.setCheckRule(buildRule(checkPointConfig.getJudges()));
                return mysqlCheckPoint;
            case VALUE:
                ResultValueCheckpoint resultValueCheckpoint = new ResultValueCheckpoint();
                resultValueCheckpoint.setCheckRule(buildRule(checkPointConfig.getJudges()));
                resultValueCheckpoint.setCompareRuleEnum(StringUtils.hasText(checkPointConfig.getRef()) ? CompareRuleEnum.valueOf(checkPointConfig.getRef()) : null);
                return resultValueCheckpoint;
            case MESSAGE:
                MessageCheckPoint messageCheckPoint = new MessageCheckPoint(checkPointConfig.getMessage());
                messageCheckPoint.setCompareRuleEnum(StringUtils.hasText(checkPointConfig.getRef()) ? CompareRuleEnum.valueOf(checkPointConfig.getRef()) : null);
                return messageCheckPoint;
            default:
                throw new AutoTestException(AutoTestResultCodeEnum.NOT_SUPPORT_DATA_TYPE);
        }
    }

    private CheckRule buildRule(List<JudgeConfig> judges) {
        if (CollectionUtils.isEmpty(judges)) {
            return new CheckRule();
        }
        CheckRule checkRule = new CheckRule();
        List<CheckParam> checkParams = judges.stream().map(judgeConfig -> {
            CheckParam checkParam = new CheckParam();
            checkParam.setCheckKey(judgeConfig.getParam());
            checkParam.setOperateRuleEnum(OperateRuleEnum.codeOf(judgeConfig.getLogic()));
            if (judgeConfig.getRef() != null) {
                checkParam.setCompareRuleEnum(CompareRuleEnum.valueOf(judgeConfig.getRef()));
            }
            checkParam.setCheckValue(judgeConfig.getExpect());
            return checkParam;
        }).toList();
        checkRule.setCheckParams(checkParams);
        return checkRule;
    }

    private ResultExtract buildResultExtractor(String resultCollectConfig) {
        ResultConfig resultConfig = JSONObject.parseObject(resultCollectConfig, ResultConfig.class);
        DataTypeEnum dataTypeEnum = DataTypeEnum.valueOf(resultConfig.getResponseDataType());
        return switch (dataTypeEnum) {
            case JSON -> new JSONResultExtract(resultConfig.getResponseParam());
            default -> throw new AutoTestException(AutoTestResultCodeEnum.NOT_SUPPORT_REQUEST_TYPE);
        };
    }


    private void loadDataSourceConf() {
        List<SourceConfig> sourceConfigs = sourceConfigService.queryAll();
        if (CollectionUtils.isEmpty(sourceConfigs)) {
            logger.info("source config is empty！");
            return;
        }
        sourceConfigs.forEach(sourceConfig -> {
            DataSourceTypeEnum dataSourceTypeEnum = DataSourceTypeEnum.valueOf(sourceConfig.getSourceType());
            String config = sourceConfig.getConfig();
            switch (dataSourceTypeEnum) {
                case MYSQL:
                    MysqlSourceConfig mysqlSourceConfig = JSONObject.parseObject(config, MysqlSourceConfig.class);
                    sourceConfigMap.put(sourceConfig.getCode(), mysqlSourceConfig);
                    break;
                case REDIS:
                    RedisSourceConfig redisSourceConfig = JSONObject.parseObject(config, RedisSourceConfig.class);
                    sourceConfigMap.put(sourceConfig.getCode(), redisSourceConfig);
                    break;
                default:
                    logger.error("not support dataSource:[{}]", sourceConfig.getName());
                    throw new AutoTestException(AutoTestResultCodeEnum.NOT_SUPPORT_DATA_SOURCE);
            }
        });
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        loadDataSourceConf();
    }
}
