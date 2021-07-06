package com.it.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.yandex.clickhouse.ClickHouseConnection;
import ru.yandex.clickhouse.ClickHouseDataSource;
import ru.yandex.clickhouse.settings.ClickHouseProperties;
import java.sql.*;
import java.util.*;

/**
 * @author LY
 * @PackageName:com.it.config
 * @ClassName:ClickHouseConfig
 * @date 2021/7/5 16:50
 * 类说明: <br>
 */
@Component
public class ClickHouseConfig {
    private static final Logger LOG = LoggerFactory.getLogger(ClickHouseConfig.class);
    private static String clickhouseAddress;

    private static String clickhouseUsername;

    private static String clickhousePassword;

    private static String clickhouseDB;

    private static Integer clickhouseSocketTimeout;

    @Value("${spring.clickhouse.address}")
    public void setClickhouseAddress(String address) {
        ClickHouseConfig.clickhouseAddress = address;
    }
    @Value("${spring.clickhouse.username}")
    public void setClickhouseUsername(String username) {
        ClickHouseConfig.clickhouseUsername = username;
    }
    @Value("${spring.clickhouse.password}")
    public void setClickhousePassword(String password) {
        ClickHouseConfig.clickhousePassword = password;
    }
    @Value("${spring.clickhouse.db}")
    public void setClickhouseDB(String db) {
        ClickHouseConfig.clickhouseDB = db;
    }
    @Value("${spring.clickhouse.socketTimeout}")
    public void setClickhouseSocketTimeout(Integer socketTimeout) {
        ClickHouseConfig.clickhouseSocketTimeout = socketTimeout;
    }
    public static Connection getConn() {
        ClickHouseConnection conn = null;
        ClickHouseProperties properties = new ClickHouseProperties();
        properties.setUser(clickhouseUsername);
        properties.setPassword(clickhousePassword);
        properties.setDatabase(clickhouseDB);
        properties.setSocketTimeout(clickhouseSocketTimeout);
        String[] url=clickhouseAddress.split(",");
        for (int i = 0; i < url.length; i++) {
            ClickHouseDataSource clickHouseDataSource = new ClickHouseDataSource(url[i], properties);
            try {
                conn = clickHouseDataSource.getConnection();
                return conn;
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }
    public static List<Map> exeSql(String sql) {
        Connection connection = getConn();
        try {
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(sql);
            if (results != null){
                ResultSetMetaData rsmd = results.getMetaData();
                List<Map> list = new ArrayList();
                while (results.next()) {
                    Map row = new HashMap();
                    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                        row.put(rsmd.getColumnName(i), results.getString(rsmd.getColumnName(i)));
                    }
                    list.add(row);
                }
                return list;
            }
        } catch (SQLException e) {
            LOG.error("ExeSql:{}", sql);
            e.printStackTrace();
        }
        return null;
    }
}
