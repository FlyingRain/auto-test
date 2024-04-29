package com.flyingrain.autotest.infrastructure.datasource.mapper.provider;

import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestReportModel;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.Map;

public class AutoTestReportDynamicSqlProvider {

    private final Logger logger = LoggerFactory.getLogger(AutoTestReportDynamicSqlProvider.class);

    public String queryByPage(Map<String, Object> params) {
        PageQuery<AutoTestReportModel> pageQuery = (PageQuery<AutoTestReportModel>) params.get("queryModel");
        SQL sql = new SQL();
        AutoTestReportModel autoTestReportModel = pageQuery.getConditions();
        sql.SELECT("*").FROM("auto_test_report");
        buildPageQuery(autoTestReportModel, sql);
        int currentPage = Math.max(pageQuery.getCurrentPage(), 1);
        int pageSize = Math.max(pageQuery.getPageSize(), 10);
        int offset = (currentPage - 1) * pageSize;
        sql.OFFSET(offset).LIMIT(pageSize);
        sql.ORDER_BY("id desc");
        logger.info("query report sql:[{}]", sql);
        return sql.toString();
    }

    public String queryByPageCount(Map<String, Object> params) {
        PageQuery<AutoTestReportModel> pageQuery = (PageQuery<AutoTestReportModel>) params.get("queryModel");
        SQL sql = new SQL();
        sql.SELECT("count(1)").FROM("auto_test_report");
        AutoTestReportModel autoTestReportModel = pageQuery.getConditions();
        buildPageQuery(autoTestReportModel, sql);
        logger.info("query report page count sql:[{}]", sql);
        return sql.toString();
    }

    private void buildPageQuery(AutoTestReportModel autoTestReportModel, SQL sql) {
        if (StringUtils.hasText(autoTestReportModel.getBatchNum())) {
            sql.WHERE("batch_num like '${queryModel.conditions.batchNum}%'");
        }
        if (StringUtils.hasText(autoTestReportModel.getTitle())) {
            sql.WHERE("title = #{queryModel.conditions.title}");
        }
    }

    public String updateReportById(Map<String, Object> params) {
        AutoTestReportModel autoTestReportModel = (AutoTestReportModel) params.get("reportModel");
        SQL sql = new SQL();
        sql.UPDATE("auto_test_report");
        buildUpdateSql(autoTestReportModel, sql);
        sql.WHERE("id=#{reportModel.id}");
        logger.info("update report sql:[{}]", sql);
        return sql.toString();
    }

    private void buildUpdateSql(AutoTestReportModel autoTestReportModel, SQL sql) {
        if (autoTestReportModel.getCaseNumber() != 0) {
            sql.SET("case_number = #{reportModel.caseNumber}");
        }
        if (autoTestReportModel.getSuccessNumber() != 0) {
            sql.SET("success_number = #{reportModel.successNumber}");
        }
        if (autoTestReportModel.getRunNumber() != 0) {
            sql.SET("run_number = #{reportModel.runNumber}");
        }
        if (autoTestReportModel.getConsumeTime() != 0) {
            sql.SET("consume_time=#{reportModel.consumeTime}");
        }
        if (StringUtils.hasText(autoTestReportModel.getResult())) {
            sql.SET("result = #{reportModel.result}");
        }
        if (StringUtils.hasText(autoTestReportModel.getDesc())) {
            sql.SET("`desc` = #{reportModel.desc}");
        }
        if (StringUtils.hasText(autoTestReportModel.getEnv())) {
            sql.SET("`env` = #{reportModel.env}");
        }

    }


}
