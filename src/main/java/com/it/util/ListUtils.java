package com.it.util;

import java.util.Collections;
import java.util.List;

/**
 * @author LY
 * @PackageName:com.proinnova.util
 * @ClassName:ListUtils
 * @date 2021/6/28 9:40
 * 类说明: <br> 处理List集合的工具类
 */
public class ListUtils {


    /**
     * 判断list集合是否为null 不为空返回true
     * @param list 原list
     * @return true表示不为null false表示为null
     */
    public static boolean isNotEmpty(List<?> list){
        return list != null && !list.isEmpty();
    }

    /**
     * 去除list表里面的null数据
     * @param list 原list集合
     */
    public static void goEmpty(List<?> list){
        list.removeAll(Collections.singleton(null));
    }



}
