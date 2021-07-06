package com.it.time.test;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author LY
 * @PackageName:com.it.time.test
 * @ClassName:DataSystemTest
 * @date 2021/6/18 14:02
 * 类说明: <br>
 */
@SpringBootTest
public class DataSystemTest {

    @Test
    public void test01(){
       /* Date date = new Date();
        System.out.println(date);

        System.out.println(System.currentTimeMillis());
        System.out.println(date.getTime());

        Date date1 = new Date(date.getTime());
        System.out.println(date1.getTime());
        System.out.println(date1.toString());*/

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.toString());
        System.out.println(JSONObject.toJSONString(now));

        DateTimeFormatter.ofPattern("yyyy");

        Instant now1 = Instant.now();
        System.out.println(now1);

        Instant instant = now.toInstant(ZoneOffset.MAX);
        System.out.println(instant);

    }
}
