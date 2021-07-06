package com.it.mysql.test;

import com.it.mapper.CreateTablesMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author LY
 * @PackageName:com.it.mysql.test
 * @ClassName:MysqlTest
 * @date 2021/7/6 11:39
 * 类说明: <br>
 */
@SpringBootTest
public class MysqlTest {

    @Resource
    private CreateTablesMapper createTablesMapper;


    @Test
    public void test01(){
        String sql = "create table learn_test(id int  NOT NULL AUTO_INCREMENT,name varchar(10) not null , PRIMARY KEY (id));";
        createTablesMapper.createNewTable(sql);
    }

}
