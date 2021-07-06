package com.it.util;

import java.util.Map;

/**
 * @author LY
 * @PackageName:com.proinnova.util
 * @ClassName:CollectionUtils
 * @date 2021/6/28 9:45
 * 类说明: <br>
 */
public class CollectionUtils extends org.springframework.util.CollectionUtils {

    /**
     * 判断map是否不为null 如果不为null 返回true 否则返回false
     * @param map 原map
     * @return 返回值true 表示不为null
     */
    public static boolean isNotEmpty(Map<?,?> map){
        return !CollectionUtils.isEmpty(map);
    }
}
