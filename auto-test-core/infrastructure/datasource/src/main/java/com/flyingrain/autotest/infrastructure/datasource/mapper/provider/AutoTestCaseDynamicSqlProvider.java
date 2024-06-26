package com.flyingrain.autotest.infrastructure.datasource.mapper.provider;

import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.infrastructure.datasource.AutoTestCaseQuery;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestCaseModel;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.Map;

public class AutoTestCaseDynamicSqlProvider {

    private final Logger logger = LoggerFactory.getLogger(AutoTestCaseDynamicSqlProvider.class);

    public String queryByPage(Map<String, Object> queryParams) {
        PageQuery<AutoTestCaseQuery> pageQuery = (PageQuery<AutoTestCaseQuery>) queryParams.get("queryCondition");
        SQL sql = new SQL();
        sql.SELECT("c.id as id ,c.name as name,c.code as code,c.service_id as service_id,c.desc as `desc`,c.case_status as case_status,c.creator as creator,c.modifier as modifier,c.create_time as create_time").FROM("auto_test_case as c");
        AutoTestCaseQuery autoTestCaseQuery = pageQuery.getConditions();
        buildQuerySql(autoTestCaseQuery, sql);
        int currentPage = Math.max(pageQuery.getCurrentPage(), 1);
        int pageSize = pageQuery.getPageSize() < 1 ? 10 : pageQuery.getPageSize();
        int offset = (currentPage - 1) * pageSize;

        sql.LIMIT(pageSize);
        sql.OFFSET(offset);
        sql.ORDER_BY("id desc");

        logger.info("build case query sql:[{}]", sql);
        return sql.toString();
    }

    public String pageCount(Map<String, Object> queryParams) {
        PageQuery<AutoTestCaseQuery> autoTestCaseQuery = (PageQuery<AutoTestCaseQuery>) queryParams.get("queryCondition");
        SQL sql = new SQL();
        sql.SELECT("count(1)").FROM("auto_test_case as c");
        buildQuerySql(autoTestCaseQuery.getConditions(), sql);
        logger.info("build case query count sql:[{}]", sql);
        return sql.toString();
    }

    private void buildQuerySql(AutoTestCaseQuery autoTestCaseQuery, SQL sql) {
        if (autoTestCaseQuery.getSceneId() != 0) {
            sql.LEFT_OUTER_JOIN("auto_test_case_scene as s on c.id = s.case_id");
            sql.WHERE("s.scene_id = #{queryCondition.conditions.sceneId}");
        }
        if(autoTestCaseQuery.getAppId()!=0){
            sql.LEFT_OUTER_JOIN("auto_test_service ser on ser.id=c.service_id").LEFT_OUTER_JOIN("auto_test_application a on a.id=ser.app_id");
            sql.WHERE("ser.app_id=#{queryCondition.conditions.appId}");
        }
        if (autoTestCaseQuery.getId() != 0) {
            sql.WHERE("c.id = #{queryCondition.conditions.id}");
        }
        if (StringUtils.hasText(autoTestCaseQuery.getCreator())) {
            sql.WHERE("c.creator = #{queryCondition.conditions.creator}");
        }
        if (autoTestCaseQuery.getServiceId() != 0) {
            sql.WHERE("c.service_id = #{queryCondition.conditions.serviceId}");
        }
        if (StringUtils.hasText(autoTestCaseQuery.getName())) {
            sql.WHERE("c.name like '${queryCondition.conditions.name}%'");
        }
        if (StringUtils.hasText(autoTestCaseQuery.getCode())) {
            sql.WHERE("c.code = #{queryCondition.conditions.code}");
        }
    }

    public String updateCase(Map<String, Object> params) {
        AutoTestCaseModel autoTestCaseModel = (AutoTestCaseModel) params.get("caseModel");
        SQL sql = new SQL();
        sql.UPDATE("auto_test_case");
        if (StringUtils.hasText(autoTestCaseModel.getCaseStatus())) {
            sql.SET("case_status=#{caseModel.caseStatus}");
        }
        if (StringUtils.hasText(autoTestCaseModel.getCheckPointConfig())) {
            sql.SET("check_point_config=#{caseModel.checkPointConfig}");
        }
        if (StringUtils.hasText(autoTestCaseModel.getParamValue())) {
            sql.SET("param_value=#{caseModel.paramValue}");
        }
        if (StringUtils.hasText(autoTestCaseModel.getResultCollectConfig())) {
            sql.SET("result_collect_config = #{caseModel.resultCollectConfig}");
        }
        if (StringUtils.hasText(autoTestCaseModel.getModifier())) {
            sql.SET("modifier = #{caseModel.modifier}");
        }
        if (StringUtils.hasText(autoTestCaseModel.getDesc())) {
            sql.SET("`desc`=#{caseModel.desc}");
        }
        if (autoTestCaseModel.getServiceId() != 0) {
            sql.SET("service_id = #{caseModel.serviceId}");
        }
        if (StringUtils.hasText(autoTestCaseModel.getName())) {
            sql.SET("name=#{caseModel.name}");
        }
        sql.WHERE("id=#{caseModel.id}");
        logger.info("update case sql:[{}]", sql);
        return sql.toString();
    }


}
