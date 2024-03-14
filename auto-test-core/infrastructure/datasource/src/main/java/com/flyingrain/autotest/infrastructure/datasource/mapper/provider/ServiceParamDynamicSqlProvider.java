package com.flyingrain.autotest.infrastructure.datasource.mapper.provider;

import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestServiceParamModel;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class ServiceParamDynamicSqlProvider {

    private final Logger logger = LoggerFactory.getLogger(ServiceParamDynamicSqlProvider.class);

    public String batchInsert(Map<String, Object> params) {
        List<AutoTestServiceParamModel> autoTestServiceParamModels = (List<AutoTestServiceParamModel>) params.get("serviceParams");
        SQL sql = new SQL();
        sql.INSERT_INTO("service_param");
        sql.INTO_COLUMNS("service_id", "param", "desc");
        for (AutoTestServiceParamModel param : autoTestServiceParamModels) {
            sql.ADD_ROW().INTO_VALUES(String.valueOf(param.getServiceId()), param.getParam(), param.getDesc());
        }
        logger.debug("insert sql is :[{}]", sql);
        return sql.toString();
    }
}
