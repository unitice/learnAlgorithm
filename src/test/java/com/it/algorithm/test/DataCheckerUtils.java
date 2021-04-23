package com.it.algorithm.test;

import java.util.Random;

public class DataCheckerUtils {
    /**
     * 随机生成数组，但数据存在重复
     */
    static int[] genertateRandomArray(){
        // 声明Random方法，生成随机数
        Random random = new Random();
        // 定义一个容量为10000的数组
        int[] arr = new int[10000];
        for (int i =0;i<arr.length;i++){
            // 获取界限内的随机数并存储到数组中
            arr[i] = random.nextInt(arr.length);
        }
        return arr;
    }

    /**
     * 数组内两字符交换
     */
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
