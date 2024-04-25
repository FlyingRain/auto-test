package com.flyingrain.autotest.domain.utils;

import com.flyingrain.autotest.common.util.AutoTestResultCodeEnum;
import com.flyingrain.autotest.common.util.exception.AutoTestException;
import com.flyingrain.autotest.domain.core.model.MysqlSourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public static Object exeCommonSql(MysqlSourceConfig mysqlSourceConfig, String sql) {
        try (Connection connection = buildMysqlConnection(mysqlSourceConfig)) {
            Statement statement = connection.createStatement();
            String temp = sql.toLowerCase().trim();
            if (temp.startsWith("select")) {
                List<Map<String, Object>> queryResult = new ArrayList<>();
                ResultSet resultSet = statement.executeQuery(sql);
                ResultSetMetaData metaData = resultSet.getMetaData();
                while (resultSet.next()) {
                    Map<String, Object> record = new HashMap<>();
                    for (int i = 1; i < metaData.getColumnCount() + 1; i++) {
                        String columName = metaData.getColumnName(i);
                        String value = resultSet.getString(columName);
                        record.put(columName, value);
                    }
                    queryResult.add(record);
                }
                return queryResult;
            } else if (temp.startsWith("update")) {
                return statement.executeUpdate(sql);
            } else if (temp.startsWith("delete")) {
                return statement.executeUpdate(sql);
            } else if (temp.startsWith("insert")) {
                return statement.executeUpdate(sql);
            } else {
                throw new AutoTestException(AutoTestResultCodeEnum.NOT_SUPPORT_SQL);
            }
        } catch (Exception e) {
            logger.error("execute sql error!", e);
            logger.info("sql:[{}]", sql);
            throw new AutoTestException(AutoTestResultCodeEnum.FAIL.getCode(), e.getMessage());
        }
    }

    public static Connection buildMysqlConnection(MysqlSourceConfig dataSourceConfig) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(dataSourceConfig.getConnectionInfo() + ":" + dataSourceConfig.getPort() + "/" + dataSourceConfig.getDataBaseName(), dataSourceConfig.getUserName(), dataSourceConfig.getPassword());
    }

}
