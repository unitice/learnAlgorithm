package com.it.algorithm.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class AlgorithmShellTest {

    @Test
    @DisplayName("shell")
    public void shellTest(){
        // 定义一个数组
        int[] arr = {2, 4, 1, 5, 8, 3, 6, 7, 9,2, 4, 1, 5, 8, 3, 6, 7, 9,2, 4, 1, 5, 8, 3, 6, 7, 9,2, 4, 1, 5, 8, 3, 6, 7, 9};
        int k = 1;
        while (k <= arr.length/3){
            k = k * 3 +1;
        }
        // 控制间隔
        for (int i = k; i > 0; i/=2){
            sort(arr,i);
        }
        // 数组打印
        arrayOutput(arr);
    }

    private void arrayOutput(int[] arr) {
        for (int i : arr){
            System.out.println(i +" ");
        }
    }

    /**
     * 希尔排序时，思考：从设置的间隔开始，进行排序，按照固定的间隔
     * 本质上的i++实际上是同时开始几个数组的同时排序
     * @param arr 待排序数组
     */
    public static void sort(int[] arr,int gam){
        for (int i = gam; i < arr.length ;i++){
            for (int j = i ;j >= gam; j-=gam){
                if (arr[j]<arr[j-gam]){
                    DataCheckerUtils.swap(arr,j-gam,j);
                } else{
                    break;
                }
            }
        }
    }


}
