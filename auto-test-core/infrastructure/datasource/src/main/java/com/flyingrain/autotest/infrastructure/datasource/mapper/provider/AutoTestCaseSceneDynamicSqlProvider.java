package com.flyingrain.autotest.infrastructure.datasource.mapper.provider;

import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestCaseSceneModel;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestSceneCaseModel;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class AutoTestCaseSceneDynamicSqlProvider {

    private final Logger logger = LoggerFactory.getLogger(AutoTestCaseSceneDynamicSqlProvider.class);

    public String queryByPage(Map<String, Object> params) {
        PageQuery<AutoTestSceneCaseModel> pageQuery = (PageQuery<AutoTestSceneCaseModel>) params.get("pageQueryModel");
        AutoTestSceneCaseModel autoTestSceneCaseModel = pageQuery.getConditions();
        SQL sql = new SQL();
        sql.SELECT(" *").FROM("auto_test_case_scene  ");
        buildSceneCaseSql(autoTestSceneCaseModel, sql);
        int currentPage = Math.max(pageQuery.getCurrentPage(), 1);
        int pageSize = Math.max(pageQuery.getPageSize(), 10);
        int offset = (currentPage - 1) * pageSize;
        sql.OFFSET(offset).LIMIT(pageSize);
        sql.ORDER_BY("executeOrder asc");
        logger.info("query sceneCase sql:[{}]", sql);
        return sql.toString();
    }

    public String queryByPageCount(Map<String, Object> params) {
        PageQuery<AutoTestSceneCaseModel> pageQuery = (PageQuery<AutoTestSceneCaseModel>) params.get("pageQueryModel");
        AutoTestSceneCaseModel autoTestSceneCaseModel = pageQuery.getConditions();
        SQL sql = new SQL();
        sql.SELECT("count(1)").FROM("auto_test_case_scene");
        buildSceneCaseSql(autoTestSceneCaseModel, sql);
        logger.info("query sceneCase count sql:[{}]", sql);
        return sql.toString();
    }

    private void buildSceneCaseSql(AutoTestSceneCaseModel autoTestSceneCaseModel, SQL sql) {
        if (autoTestSceneCaseModel.getCaseId() != 0) {
            sql.WHERE("case_id=#{pageQueryModel.conditions.caseId}");
        }
        if (autoTestSceneCaseModel.getSceneId() != 0) {
            sql.WHERE("scene_id = #{pageQueryModel.conditions.sceneId}");
        }
    }

}
