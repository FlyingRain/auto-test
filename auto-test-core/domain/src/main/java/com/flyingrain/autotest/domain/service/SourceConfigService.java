package com.flyingrain.autotest.domain.service;

import com.alibaba.fastjson.JSONObject;
import com.flyingrain.autotest.common.util.*;
import com.flyingrain.autotest.common.util.constant.AutoTestConstants;
import com.flyingrain.autotest.common.util.exception.AutoTestException;
import com.flyingrain.autotest.domain.core.model.MysqlSourceConfig;
import com.flyingrain.autotest.domain.model.SourceConfig;
import com.flyingrain.autotest.domain.model.User;
import com.flyingrain.autotest.domain.service.convert.SourceConfigConvert;
import com.flyingrain.autotest.domain.utils.SQLExecutorHelper;
import com.flyingrain.autotest.infrastructure.datasource.mapper.AutoTestSourceConfigMapper;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestSourceConfigModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SourceConfigService {

    private final Logger logger = LoggerFactory.getLogger(SourceConfigService.class);

    @Autowired
    private AutoTestSourceConfigMapper autoTestSourceConfigMapper;


    public List<SourceConfig> queryAll() {
        List<AutoTestSourceConfigModel> autoTestSourceConfigModels = autoTestSourceConfigMapper.queryAll();
        logger.info("query all source config:[{}]", autoTestSourceConfigModels.size());
        return autoTestSourceConfigModels.stream().map(SourceConfigConvert::convertToDomain).collect(Collectors.toList());
    }

    public PageableModel<SourceConfig> queryByPage(PageQuery<SourceConfig> pageQuery) {
        logger.info("query sourceConfig:[{}]", pageQuery);
        PageQuery<AutoTestSourceConfigModel> autoTestSourceConfigModelPageQuery = new PageQuery<>();
        autoTestSourceConfigModelPageQuery.setCurrentPage(pageQuery.getCurrentPage());
        autoTestSourceConfigModelPageQuery.setPageSize(pageQuery.getPageSize());
        autoTestSourceConfigModelPageQuery.setConditions(SourceConfigConvert.convertToModel(pageQuery.getConditions()));
        List<AutoTestSourceConfigModel> autoTestSourceConfigModels = autoTestSourceConfigMapper.queryPage(autoTestSourceConfigModelPageQuery);
        int count = autoTestSourceConfigMapper.queryPageCount(autoTestSourceConfigModelPageQuery);
        PageableModel<SourceConfig> pageableModel = new PageableModel<>();
        pageableModel.copyOf(pageQuery);
        pageableModel.setTotal(count);
        pageableModel.setData(autoTestSourceConfigModels.stream().map(SourceConfigConvert::convertToDomain).collect(Collectors.toList()));
        return pageableModel;
    }

    public int batchDel(List<Integer> ids) {
        User user = RunTimeContext.get(AutoTestConstants.USER);
        logger.info("user:[{}],batch del ids:[{}]", user, ids);
        return autoTestSourceConfigMapper.batchDel(ids);
    }

    public boolean insert(SourceConfig sourceConfig) {
        logger.info("start to insert config:[{}]", sourceConfig);
        User user = RunTimeContext.get(AutoTestConstants.USER);
        sourceConfig.setOperator(user == null ? null : user.getUserName());
        return autoTestSourceConfigMapper.insertSourceConfig(SourceConfigConvert.convertToModel(sourceConfig)) == 1;

    }

    public SourceConfig queryDetail(int id) {
        logger.info("query sourceConfig detail:[{}]", id);
        return SourceConfigConvert.convertToDomain(autoTestSourceConfigMapper.queryDetail(id));
    }

    public Boolean updateById(SourceConfig sourceConfig) {
        logger.info("start to update config:[{}]", sourceConfig);
        User user = RunTimeContext.get(AutoTestConstants.USER);
        sourceConfig.setOperator(user == null ? null : user.getUserName());
        return autoTestSourceConfigMapper.updateById(SourceConfigConvert.convertToModel(sourceConfig)) == 1;
    }

    public void testConnection(SourceConfig sourceConfig) {
        DataSourceTypeEnum dataSourceTypeEnum = DataSourceTypeEnum.valueOf(sourceConfig.getSourceType());
        try {
            switch (dataSourceTypeEnum) {
                case MYSQL:
                    MysqlSourceConfig mysqlSourceConfig = JSONObject.parseObject(sourceConfig.getConfig(), MysqlSourceConfig.class);
                    Connection connection = SQLExecutorHelper.buildMysqlConnection(mysqlSourceConfig);
                    connection.close();
                    break;
                case REDIS:
                    throw new AutoTestException(AutoTestResultCodeEnum.NOT_SUPPORT_DATA_SOURCE);
            }
        } catch (Exception e) {
            logger.error("build connection failed!", e);
            throw new AutoTestException(AutoTestResultCodeEnum.FAIL.getCode(), "建立连接失败：" + e.getMessage());
        }
    }


}
