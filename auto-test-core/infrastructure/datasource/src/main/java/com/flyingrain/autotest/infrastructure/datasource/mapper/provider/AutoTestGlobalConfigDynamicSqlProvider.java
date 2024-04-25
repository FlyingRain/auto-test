package com.flyingrain.autotest.infrastructure.datasource.mapper.provider;

import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestGlobalConfigModel;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.Map;

public class AutoTestGlobalConfigDynamicSqlProvider {

    private final Logger logger = LoggerFactory.getLogger(AutoTestCaseDynamicSqlProvider.class);

    public String queryByPage(Map<String, Object> params) {
        PageQuery<AutoTestGlobalConfigModel> pageQuery = (PageQuery<AutoTestGlobalConfigModel>) params.get("pageQuery");
        SQL sql = new SQL();
        sql.SELECT("*").FROM("auto_test_global_config");
        AutoTestGlobalConfigModel autoTestGlobalConfigModel = pageQuery.getConditions();
        buildPageQueryConditions(autoTestGlobalConfigModel, sql);
        int currentPage = Math.max(pageQuery.getCurrentPage(), 1);
        int pageSize = pageQuery.getPageSize() < 1 ? 10 : pageQuery.getPageSize();
        int offset = (currentPage - 1) * pageSize;

        sql.LIMIT(pageSize);
        sql.OFFSET(offset);
        sql.ORDER_BY("id desc");

        logger.info("query global config page sql:[{}]", sql);
        return sql.toString();
    }

    private void buildPageQueryConditions(AutoTestGlobalConfigModel autoTestGlobalConfigModel, SQL sql) {
        if (StringUtils.hasText(autoTestGlobalConfigModel.getParamKey())) {
            sql.WHERE("param_key=#{pageQuery.conditions.paramKey}");
        }
        if (StringUtils.hasText(autoTestGlobalConfigModel.getParamValue())) {
            sql.WHERE("param_value=#{pageQuery.conditions.paramValue}");
        }
        if (StringUtils.hasText(autoTestGlobalConfigModel.getParamName())) {
            sql.WHERE("param_name like '${pageQuery.conditions.paramName}%'");
        }
    }

    public String queryByPageCount(Map<String, Object> params) {
        PageQuery<AutoTestGlobalConfigModel> autoTestGlobalConfigModelPageQuery = (PageQuery<AutoTestGlobalConfigModel>) params.get("pageQuery");
        AutoTestGlobalConfigModel autoTestGlobalConfigModel = autoTestGlobalConfigModelPageQuery.getConditions();
        SQL sql = new SQL();
        sql.SELECT("count(1)").FROM("auto_test_global_config");
        buildPageQueryConditions(autoTestGlobalConfigModel, sql);
        logger.info("query global config count:[{}]", sql);
        return sql.toString();
    }

    public String updateById(Map<String, Object> params) {
        AutoTestGlobalConfigModel autoTestGlobalConfigModel = (AutoTestGlobalConfigModel) params.get("globalModel");
        SQL sql = new SQL();
        sql.UPDATE("auto_test_global_config");
        buildUpdateSQL(autoTestGlobalConfigModel, sql);
        sql.WHERE("id=#{globalModel.id}");
        logger.info("update global config sql:[{}]", sql);
        return sql.toString();
    }

    private void buildUpdateSQL(AutoTestGlobalConfigModel autoTestGlobalConfigModel, SQL sql) {
        if (StringUtils.hasText(autoTestGlobalConfigModel.getOperator())) {
            sql.SET("operator=#{globalModel.operator}");
        }
        if (StringUtils.hasText(autoTestGlobalConfigModel.getParamValue())) {
            sql.SET("param_value=#{globalModel.paramValue}");
        }
        if (StringUtils.hasText(autoTestGlobalConfigModel.getParamValue())) {
            sql.SET("param_name=#{globalModel.paramName}");
        }
    }

}
