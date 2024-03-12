package com.flyingrain.autotest.infrastructure.datasource.mapper.provider;

import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestServiceModel;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class ServiceDynamicSqlProvider {

    private final Logger logger = LoggerFactory.getLogger(ServiceDynamicSqlProvider.class);

    public String queryServiceByPage(Map<String, Object> params) {
        PageQuery<AutoTestServiceModel> pageQuery = (PageQuery<AutoTestServiceModel>) params.get("condition");
        SQL sql = new SQL();
        sql.SELECT("*").FROM("auto_test_service");
        AutoTestServiceModel autoTestServiceModel = pageQuery.getConditions();
        buildQueryCondition(autoTestServiceModel, sql);
        int currentPage = Math.max(pageQuery.getCurrentPage(), 1);
        int pageSize = Math.max(pageQuery.getPageSize(), 10);
        int offset = (currentPage - 1) * pageSize;
        sql.OFFSET(offset).LIMIT(pageSize);
        sql.ORDER_BY("id desc");
        return sql.toString();

    }

    private void buildQueryCondition(AutoTestServiceModel autoTestServiceModel, SQL sql) {
        if (autoTestServiceModel == null) {
            logger.warn("query condition is empty！");
        } else {
            if (StringUtils.isNotBlank(autoTestServiceModel.getServiceCode())) {
                sql.WHERE("service_code=#{condition.conditions.serviceCode}");
            }
            if (StringUtils.isNotBlank(autoTestServiceModel.getServiceName())) {
                sql.WHERE("service_name = #{condition.conditions.serviceName}");
            }
            if (autoTestServiceModel.getAppId() != 0) {
                sql.WHERE("app_id = #{condition.conditions.appId}");
            }

        }
    }

    public String countServiceByPage(Map<String, Object> params) {
        PageQuery<AutoTestServiceModel> pageQuery = (PageQuery<AutoTestServiceModel>) params.get("condition");
        SQL sql = new SQL();
        sql.SELECT("count(1)").FROM("auto_test_service");
        AutoTestServiceModel autoTestServiceModel = pageQuery.getConditions();
        buildQueryCondition(autoTestServiceModel, sql);
        return sql.toString();

    }


    public String updateServiceById(Map<String, Object> params) {
        AutoTestServiceModel autoTestServiceModel = (AutoTestServiceModel) params.get("service");
        SQL sql = new SQL();
        sql.UPDATE("auto_test_service");
        if (StringUtils.isNotBlank(autoTestServiceModel.getServiceName())) {
            sql.SET("service_name=#{service.serviceName}");
        }
        if (StringUtils.isNotBlank(autoTestServiceModel.getHeaders())) {
            sql.SET("headers = #{service.headers}");
        }
        if (StringUtils.isNotBlank(autoTestServiceModel.getRequestPath())) {
            sql.SET("request_path = #{service.requestPath}");
        }
        if (StringUtils.isNotBlank(autoTestServiceModel.getCreator())) {
            sql.SET("creator = #{service.creator}");
        }
        if (StringUtils.isNotBlank(autoTestServiceModel.getRequestType())) {
            sql.SET("request_type=#{service.requestType}");
        }
        if (StringUtils.isNotBlank(autoTestServiceModel.getProtocolType())) {
            sql.SET("protocol_type=#{service.protocolType}");
        }
        if (StringUtils.isNotBlank(autoTestServiceModel.getRequestModel())) {
            sql.SET("request_model = #{service.requestModel}");
        }
        if (StringUtils.isNotBlank(autoTestServiceModel.getResponseDataType())) {
            sql.SET("response_data_type=#{service.responseDataType}");
        }
        if (autoTestServiceModel.getAppId()!=0) {
            sql.SET("app_id=#{service.appId}");
        }
        sql.WHERE("id = #{service.id}");
        logger.info("update service sql:[{}]", sql);
        return sql.toString();
    }
}
