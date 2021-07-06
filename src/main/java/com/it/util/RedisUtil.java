package com.it.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author LY
 * @PackageName:com.it.util
 * @ClassName:RedisUtil
 * @date 2021/7/2 16:55
 * 类说明: <br>
 */
public class RedisUtil {


    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 判断key是否存在与redis里面
     * @param key key值
     * @return 返回true时表示存在， 返回false时表示不存在
     */
    public boolean existKey(Object key){
        if (key != null && key != ""){
            return redisTemplate.hasKey(key);
        }
        return false;
    }




}
