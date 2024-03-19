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
        StringBuilder sql = new StringBuilder("insert into service_param (service_id,param,`desc`) values ");
        for (int i = 0; i < autoTestServiceParamModels.size(); i++) {
            AutoTestServiceParamModel param = autoTestServiceParamModels.get(i);
            sql.append("(").append(param.getServiceId()).append(",\"").append(param.getParam()).append("\",\"").append(param.getDesc()).append("\")");
            if (i != autoTestServiceParamModels.size() - 1) {
                sql.append(",");
            }
        }
        logger.debug("insert sql is :[{}]", sql);
        return sql.toString();
    }
}
