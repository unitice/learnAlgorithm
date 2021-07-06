package com.it.redis.test;

import com.alibaba.fastjson.JSONObject;
import com.it.util.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.*;

/**
 * @author LY
 * @PackageName:com.it.redis.test
 * @ClassName:RedisTest
 * @date 2021/7/2 16:47
 * 类说明: <br>
 */
@SpringBootTest
public class RedisTest {


    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test01() {
        redisTemplate.opsForValue().set("111", "111");
        Object o = redisTemplate.opsForValue().get("111");
        System.out.println(o);

        Map<String,String> map = new HashMap<>();
        map.put("111", "111");
        map.put("222", "aaa");
        map.put("333", "bbb");
        map.put("444", "ccc");
        redisTemplate.opsForValue().multiSet(map);
        Object o1 = redisTemplate.randomKey();
        System.out.println(JSONObject.toJSONString(o1));
        Set keys = redisTemplate.keys("3");
        System.out.println(JSONObject.toJSONString(keys));

        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        redisTemplate.opsForList().set("aaa",1,list);


    }


}
