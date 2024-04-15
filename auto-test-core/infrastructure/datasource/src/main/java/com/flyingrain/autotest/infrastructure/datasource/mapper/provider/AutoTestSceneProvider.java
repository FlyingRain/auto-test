package com.flyingrain.autotest.infrastructure.datasource.mapper.provider;

import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestSceneModel;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.Map;

public class AutoTestSceneProvider {

    private final Logger logger = LoggerFactory.getLogger(AutoTestSceneProvider.class);

    public String pageQuery(Map<String, Object> params) {
        PageQuery<AutoTestSceneModel> pageQuery = (PageQuery<AutoTestSceneModel>) params.get("pageQueryModel");
        SQL sql = new SQL();
        sql.SELECT("*").FROM("auto_test_scene");
        AutoTestSceneModel autoTestSceneModel = pageQuery.getConditions();
        buildQueryCondition(autoTestSceneModel, sql);
        int currentPage = Math.max(pageQuery.getCurrentPage(), 1);
        int pageSize = Math.max(pageQuery.getPageSize(), 10);
        int offset = (currentPage - 1) * pageSize;
        sql.OFFSET(offset).LIMIT(pageSize);
        sql.ORDER_BY("id desc");
        logger.info("page query scene sql is :[{}]", sql);
        return sql.toString();
    }

    private void buildQueryCondition(AutoTestSceneModel autoTestSceneModel, SQL sql) {
        if (StringUtils.hasText(autoTestSceneModel.getSceneCode())) {
            sql.WHERE("scene_code=#{pageQueryModel.conditions.sceneCode}");
        }
        if (StringUtils.hasText(autoTestSceneModel.getSceneName())) {
            sql.WHERE("scene_name = #{pageQueryModel.conditions.sceneName}");
        }
    }

    public String pageQueryCount(Map<String, Object> params) {
        PageQuery<AutoTestSceneModel> pageQuery = (PageQuery<AutoTestSceneModel>) params.get("pageQueryModel");
        SQL sql = new SQL();
        sql.SELECT("count(1)").FROM("auto_test_scene");
        AutoTestSceneModel autoTestSceneModel = pageQuery.getConditions();
        buildQueryCondition(autoTestSceneModel, sql);
        logger.info("query scene count:[{}]", sql);
        return sql.toString();
    }

    public String updateById(Map<String, Object> params) {
        AutoTestSceneModel autoTestSceneModel = (AutoTestSceneModel) params.get("sceneModel");
        SQL sql = new SQL();
        sql.UPDATE("auto_test_scene");
        buildUpdateCondition(autoTestSceneModel, sql);
        sql.WHERE("id=#{sceneModel.id}");
        logger.info("update scene sql:[{}]", sql);
        return sql.toString();
    }

    private void buildUpdateCondition(AutoTestSceneModel autoTestSceneModel, SQL sql) {
        if (StringUtils.hasText(autoTestSceneModel.getSceneName())) {
            sql.SET("scene_name=#{sceneModel.sceneName}");
        }
        if(StringUtils.hasText(autoTestSceneModel.getConfig())){
            sql.SET("config = #{sceneModel.config}");
        }
    }

}
