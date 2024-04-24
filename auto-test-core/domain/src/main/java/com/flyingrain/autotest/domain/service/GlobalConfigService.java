package com.flyingrain.autotest.domain.service;

import com.flyingrain.autotest.common.util.AutoTestResultCodeEnum;
import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.common.util.PageableModel;
import com.flyingrain.autotest.common.util.RunTimeContext;
import com.flyingrain.autotest.common.util.constant.AutoTestConstants;
import com.flyingrain.autotest.common.util.exception.AutoTestException;
import com.flyingrain.autotest.domain.model.GlobalConfig;
import com.flyingrain.autotest.domain.model.User;
import com.flyingrain.autotest.domain.service.convert.GlobalConfigModelConvert;
import com.flyingrain.autotest.infrastructure.datasource.mapper.AutoTestGlobalConfigMapper;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestGlobalConfigModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GlobalConfigService {
    private final Logger logger = LoggerFactory.getLogger(GlobalConfig.class);

    @Autowired
    private AutoTestGlobalConfigMapper globalConfigMapper;


    public PageableModel<GlobalConfig> queryByPage(PageQuery<GlobalConfig> pageQuery) {
        logger.info("query globalConfig:[{}]", pageQuery);
        PageQuery<AutoTestGlobalConfigModel> queryModel = new PageQuery<>(pageQuery.getCurrentPage(), pageQuery.getPageSize(), GlobalConfigModelConvert.convertToModel(pageQuery.getConditions()));
        List<AutoTestGlobalConfigModel> autoTestGlobalConfigModels = globalConfigMapper.queryByPage(queryModel);
        int count = globalConfigMapper.queryByPageCount(queryModel);
        PageableModel<GlobalConfig> pageableModel = new PageableModel<>();
        pageableModel.copyOf(pageQuery);
        pageableModel.setTotal(count);
        pageableModel.setData(autoTestGlobalConfigModels.stream().map(GlobalConfigModelConvert::convertToDomain).collect(Collectors.toList()));
        return pageableModel;
    }

    public int updateById(GlobalConfig globalConfig) {
        logger.info("start to update GlobalConfig:[{}]", globalConfig);
        User user = RunTimeContext.get(AutoTestConstants.USER);
        if (user == null) {
            throw new AutoTestException(AutoTestResultCodeEnum.NOT_LOGIN);
        }
        globalConfig.setOperator(user.getUserName());
        return globalConfigMapper.updateById(GlobalConfigModelConvert.convertToModel(globalConfig));
    }

    public int insert(GlobalConfig globalConfig) {
        logger.info("start to add GlobalConfig:[{}]", globalConfig);
        User user = RunTimeContext.get(AutoTestConstants.USER);
        if (user == null) {
            throw new AutoTestException(AutoTestResultCodeEnum.NOT_LOGIN);
        }
        globalConfig.setOperator(user.getUserName());
        return globalConfigMapper.insert(GlobalConfigModelConvert.convertToModel(globalConfig));
    }

    public int batchDel(List<Integer> ids) {
        User user = RunTimeContext.get(AutoTestConstants.USER);
        if (user == null) {
            throw new AutoTestException(AutoTestResultCodeEnum.NOT_LOGIN);
        }
        logger.info("start to del GlobalConfig:[{}],user:[{}]", ids, user.getUserName());
        return globalConfigMapper.batchDel(ids);
    }

    public List<GlobalConfig> queryAll() {
        List<AutoTestGlobalConfigModel> allConfigs = globalConfigMapper.queryAll();
        logger.info("all config size:[{}]", allConfigs.size());
        return allConfigs.stream().map(GlobalConfigModelConvert::convertToDomain).collect(Collectors.toList());
    }
}
