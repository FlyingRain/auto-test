package com.flyingrain.autotest.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.domain.core.model.MysqlSourceConfig;
import com.flyingrain.autotest.domain.model.SourceConfig;
import com.flyingrain.autotest.domain.service.SourceConfigService;
import com.flyingrain.autotest.domain.utils.SQLExecutorHelper;
import com.flyingrain.autotest.facade.intf.model.AutoTestMysqlOpt;
import com.flyingrain.autotest.facade.intf.mysql.MysqlOptFacade;
import com.flyingrain.autotest.mvc.jersey.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MysqlOptFacadeImpl implements MysqlOptFacade, Resource {

    @Autowired
    private SourceConfigService sourceConfigService;

    @Override
    public CommonResult<Object> executeSql(AutoTestMysqlOpt autoTestMysqlOpt) {
        List<SourceConfig> sourceConfigs = sourceConfigService.queryAll();
        for (SourceConfig sourceConfig : sourceConfigs) {
            MysqlSourceConfig mysqlSourceConfig = JSONObject.parseObject(sourceConfig.getConfig(), MysqlSourceConfig.class);
            if (sourceConfig.getCode().equals(autoTestMysqlOpt.getDataSourceCode())) {
                return CommonResult.success(SQLExecutorHelper.exeCommonSql(mysqlSourceConfig, autoTestMysqlOpt.getScript()));
            }
        }
        return CommonResult.fail("500", "未找到数据源：" + autoTestMysqlOpt.getDataSourceCode());
    }
}
