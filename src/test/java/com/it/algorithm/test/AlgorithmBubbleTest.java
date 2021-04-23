package com.it.algorithm.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class AlgorithmBubbleTest {


    /**
     * 冒泡排序算法实现
     */
    @Test
    @DisplayName("bubble")
    public void bubbleTest() {
        // 定义数组
//        int[] arr = {2, 4, 1, 5, 8, 3, 6, 7, 9};
        int[] arr = {9, 1, 2, 3, 4, 5, 6, 7, 8};
        // 冒泡排序方法体
        // 方法一
       /* for (int i = 0; i < arr.length; i++) {
            // 标记是否进行了替换 如果没有替换则为true 则说明不需要排序
            boolean mark = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    mark = false;
                    DataCheckerUtils.swap(arr, j, j+1);
                }
            }
            // 终止循环
            if (mark) break;
        }*/
        // 方法二
        for (int i = arr.length -1;i > 0 ;i--){
            // 标记是否进行了替换 如果没有替换则为true 则说明不需要排序
            boolean mark = true;
            // 进行比对判断
            findMax(arr,i,mark);
            // 终止循环
            if (mark) break;
        }
        Arrays.stream(arr).forEach(System.out::println);
    }

    /**
     * 将数组中的最大的数值移动到最后一位
     * @param arr
     * @param n
     */
    static void findMax(int[] arr,int n,boolean mark){
        for (int j = 0 ;j< n ; j++){
            mark = false;
            if (arr[j] > arr[j+1]) DataCheckerUtils.swap(arr,j,j+1);
        }
    }
}
