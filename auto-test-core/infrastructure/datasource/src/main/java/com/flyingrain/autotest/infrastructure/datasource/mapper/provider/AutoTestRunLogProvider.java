package com.flyingrain.autotest.infrastructure.datasource.mapper.provider;

import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestRunLogModel;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author wally
 * @date 2021-12-13
 */
public class AutoTestRunLogProvider {

    private static final Logger logger = LoggerFactory.getLogger(AutoTestRunLogProvider.class);

    public String pageQuery(Map<String, Object> params) {
        PageQuery<AutoTestRunLogModel> runLogModels = (PageQuery<AutoTestRunLogModel>) params.get("pageQuery");
        SQL sql = new SQL();
        sql.SELECT("*").FROM("auto_test_run_log");
        AutoTestRunLogModel autoTestRunLogModel = runLogModels.getConditions();
        buildQueryConditions(autoTestRunLogModel, sql);
        int currentPage = Math.max(runLogModels.getCurrentPage(), 1);
        int pageSize = Math.max(runLogModels.getPageSize(), 10);
        int offset = (currentPage - 1) * pageSize;
        sql.OFFSET(offset).LIMIT(pageSize);
        sql.ORDER_BY("id desc");
        logger.info("query run log sql:[{}]", sql);
        return sql.toString();
    }


    public String pageQueryCount(Map<String, Object> params) {
        PageQuery<AutoTestRunLogModel> runLogModels = (PageQuery<AutoTestRunLogModel>) params.get("pageQuery");
        AutoTestRunLogModel autoTestRunLogModel = runLogModels.getConditions();
        SQL sql = new SQL();
        sql.SELECT("count(1)").FROM("auto_test_run_log");
        buildQueryConditions(autoTestRunLogModel, sql);
        logger.info("query run log count:[{}]", sql);
        return sql.toString();

    }

    private void buildQueryConditions(AutoTestRunLogModel autoTestRunLogModel, SQL sql) {
        if (StringUtils.hasText(autoTestRunLogModel.getRunStatus())) {
            sql.WHERE("run_status=#{pageQuery.conditions.runStatus}");
        }
        if (StringUtils.hasText(autoTestRunLogModel.getBatchNum())) {
            sql.WHERE("batch_num =#{pageQuery.conditions.batchNum}");
        }
        if (StringUtils.hasText(autoTestRunLogModel.getCaseCode())) {
            sql.WHERE("case_code = #{pageQuery.conditions.caseCode}");
        }
    }
}
