package com.flyingrain.autotest.infrastructure.datasource.mapper.provider;

import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestSourceConfigModel;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.Map;

public class AutoTestSourceConfigDynamicSqlProvider {

    private final Logger logger = LoggerFactory.getLogger(AutoTestSourceConfigDynamicSqlProvider.class);

    public String pageQuery(Map<String, Object> params) {
        PageQuery<AutoTestSourceConfigModel> queryModel = (PageQuery<AutoTestSourceConfigModel>) params.get("queryModel");
        AutoTestSourceConfigModel sourceConfigModel = queryModel.getConditions();
        SQL sql = new SQL();
        sql.SELECT("*").FROM("auto_test_source_config");
        buildQueryCondition(sql, sourceConfigModel);
        int currentPage = Math.max(queryModel.getCurrentPage(), 1);
        int pageSize = Math.max(queryModel.getPageSize(), 10);
        int offset = (currentPage - 1) * pageSize;
        sql.OFFSET(offset).LIMIT(pageSize);
        sql.ORDER_BY("id desc");
        logger.info("build query sourceConfig sql:[{}]", sql);
        return sql.toString();
    }

    public String pageQueryCount(Map<String, Object> params) {
        PageQuery<AutoTestSourceConfigModel> queryModel = (PageQuery<AutoTestSourceConfigModel>) params.get("queryModel");
        AutoTestSourceConfigModel autoTestSourceConfigModel = queryModel.getConditions();
        SQL sql = new SQL();
        sql.SELECT("count(1)").FROM("auto_test_source_config");
        buildQueryCondition(sql, autoTestSourceConfigModel);
        logger.info("build query sourceConfig count sql:[{}]", sql);
        return sql.toString();
    }


    public String updateById(Map<String, Object> params) {
        AutoTestSourceConfigModel autoTestSourceConfigModel = (AutoTestSourceConfigModel) params.get("updateModel");
        SQL sql = new SQL();
        sql.UPDATE("auto_test_source_config");
        buildUpdate(sql, autoTestSourceConfigModel);
        sql.WHERE("id = #{updateModel.id}");
        logger.info("build update sourceConfig:[{}]", sql);
        return sql.toString();
    }

    private void buildUpdate(SQL sql, AutoTestSourceConfigModel autoTestSourceConfigModel) {
        if (StringUtils.hasText(autoTestSourceConfigModel.getConfig())) {
            sql.SET("config = #{updateModel.config}");
        }
        if (StringUtils.hasText(autoTestSourceConfigModel.getName())) {
            sql.SET("name = #{updateModel.name}");
        }
    }


    private void buildQueryCondition(SQL sql, AutoTestSourceConfigModel sourceConfigModel) {
        if (StringUtils.hasText(sourceConfigModel.getCode())) {
            sql.WHERE("code=#{queryModel.conditions.code}");
        }
        if (StringUtils.hasText(sourceConfigModel.getName())) {
            sql.WHERE("name like '#{queryModel.conditions.name}%'");
        }
        if(StringUtils.hasText(sourceConfigModel.getSourceType())){
            sql.WHERE("source_type=#{queryModel.conditions.sourceType}");
        }
    }
}
