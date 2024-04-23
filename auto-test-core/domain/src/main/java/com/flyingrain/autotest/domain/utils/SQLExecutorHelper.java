package com.flyingrain.autotest.domain.utils;

import com.flyingrain.autotest.domain.core.model.MysqlSourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class SQLExecutorHelper {

    private static final Logger logger = LoggerFactory.getLogger(SQLExecutorHelper.class);

    public static Map<String, String> exeSql(MysqlSourceConfig dataSourceConfig, String script) {
        Map<String, String> queryResult = new HashMap<>();
        try {
            Connection connection = buildMysqlConnection(dataSourceConfig);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(script);
            ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i = 1; i < metaData.getColumnCount() + 1; i++) {
                String columName = metaData.getColumnName(i);
                if (resultSet.next()) {
                    String value = resultSet.getString(columName);
                    queryResult.put(columName, value);
                }
            }
        } catch (Exception e) {
            logger.error("execute sql happen exception!", e);
            logger.error("sql config:[{}],sql:[{}]", dataSourceConfig, script);
        }
        return queryResult;
    }

    public static Connection buildMysqlConnection(MysqlSourceConfig dataSourceConfig) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(dataSourceConfig.getConnectionInfo() + ":" + dataSourceConfig.getPort() + "/" + dataSourceConfig.getDataBaseName(), dataSourceConfig.getUserName(), dataSourceConfig.getPassword());
    }

}
