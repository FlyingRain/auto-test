package com.flyingrain.autotest.infrastructure.datasource.mapper.provider;

import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestApplicationModel;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestServiceModel;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.Map;

public class AppDynamicSqlProvider {

    private final Logger logger = LoggerFactory.getLogger(AppDynamicSqlProvider.class);

    public String pageCondition(Map<String, Object> params) {
        PageQuery<AutoTestApplicationModel> pageQuery = (PageQuery<AutoTestApplicationModel>) params.get("pageCondition");
        SQL sql = new SQL();
        sql.SELECT("*").FROM("auto_test_application");
        AutoTestApplicationModel autoTestApplicationModel = pageQuery.getConditions();
        buildQueryCondition(autoTestApplicationModel, sql);
        int currentPage = Math.max(pageQuery.getCurrentPage(), 1);
        int pageSize = Math.max(pageQuery.getPageSize(), 10);
        int offset = (currentPage - 1) * pageSize;
        sql.OFFSET(offset).LIMIT(pageSize);
        sql.ORDER_BY("id desc");
        return sql.toString();
    }


    public String pageCount(Map<String,Object> params){
        PageQuery<AutoTestApplicationModel> pageQuery = (PageQuery<AutoTestApplicationModel>) params.get("pageCondition");
        SQL sql = new SQL();
        sql.SELECT("count(1)").FROM("auto_test_application");
        AutoTestApplicationModel autoTestApplicationModel = pageQuery.getConditions();
        buildQueryCondition(autoTestApplicationModel, sql);
        return sql.toString();
    }

    private void buildQueryCondition(AutoTestApplicationModel autoTestApplicationModel, SQL sql) {
        if (autoTestApplicationModel == null) {
            logger.warn("query condition is empty!");
            return;
        }
        if (StringUtils.hasText(autoTestApplicationModel.getAppCode())) {
            sql.WHERE("app_code=#{pageCondition.appCode}");
        }
        if (StringUtils.hasText(autoTestApplicationModel.getAppName())) {
            sql.WHERE("app_name = #{pageCondition.appName}");
        }
        if (StringUtils.hasText(autoTestApplicationModel.getOwner())) {
            sql.WHERE("owner=#{pageCondition.owner}");
        }
    }
}
