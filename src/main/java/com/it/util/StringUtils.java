package com.it.util;

/**
 * @author LY
 * @PackageName:com.proinnova.util
 * @ClassName:StringUtils
 * @date 2021/6/28 9:31
 * 类说明: <br> StringUtils 处理字符串的工具类
 */
public class StringUtils extends org.springframework.util.StringUtils {

    /**
     * 判断字符串是否为非null
     * @param str 原字符串
     * @return 返回true则为非null
     */
    public static boolean isNotEmpty(String str){
        return !StringUtils.isEmpty(str);
    }




}
