package com.it.algorithm.test;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class AlgorithmInsertionTest {

    @Test
    @DisplayName("insertion")
    public void insertionTest(){
        int[] arr = {2, 4, 1, 5, 8, 3, 6, 7, 9};
        // 插入排序方法体
        // 方法一
      /*  for (int i = 1; i < arr.length ;i++){
           for (int j = 0 ;j < i; j++){
               if (arr[i]<arr[j])
               DataCheckerUtils.swap(arr,i,j);
           }
        }*/
        // 方法二 最优插入排序方法
        for (int i = 1; i < arr.length ;i++){
            // 后者大于前者，则跳过本次循环
            if(arr[i] < arr[i-1]){
                for (int j = i ;j > 0 ; j--){
                    if (arr[j]<arr[j-1]){
                        // 当后者小于前者进行交换
                        DataCheckerUtils.swap(arr,j-1,j);
                    } else {
                        // 后者大于前者，则跳过内循环
                        break;
                    }
                }
            }
        }
        Arrays.stream(arr).forEach(System.out::println);
    }
}
