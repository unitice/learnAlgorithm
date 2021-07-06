package com.it.clickhouse.test;

import com.it.config.ClickHouseConfig;
import com.it.util.ListUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @author LY
 * @PackageName:com.it.clickhouse.test
 * @ClassName:ClickhouseTest
 * @date 2021/7/5 16:53
 * 类说明: <br>
 */
@SpringBootTest
@Slf4j
public class ClickhouseTest {

    @Test
    public void exeSql() {
        String sql = "show databases";
        runSql(sql);
    }

    @Test
    public void createDataBase() {
        String sql = "create database if not exists me_test";
        runSql(sql);
    }

    @Test
    public void createTables(){
        String sql = "create table me_test.test_learn(id Int,name String) engine=Memory";
        runSql(sql);
    }

    @Test
    public void tableInsert(){
        String sql = "insert into me_test.test_learn(id,name) values(1,'test'),(2,'aaa'),(3,'ccc')";
        runSql(sql);
    }

    @Test
    public void tableSelect(){
        String sql = "select * from me_test.test_learn";
        runSql(sql);
    }

    /**
     * 运行clickhouse的sql语句
     *
     * @param sql clickhouse的sql语句
     */
    private void runSql(String sql) {
        List<Map> result = ClickHouseConfig.exeSql(sql);
        if (ListUtils.isNotEmpty(result)) {
            result.stream().forEach(System.out::println);
        }
    }
}
