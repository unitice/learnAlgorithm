package com.it.algorithm.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author feather
 * @Date 2021/3/10
 */
@SpringBootTest
public class AlgorithmQuickTest {

    @Test
    @DisplayName("quick")
    public void quickTest(){
        int[] arr = {1,3,7,3,5,2,11,3,8,9,12};
        quickSort(arr,0,arr.length-1);
        getPrint(arr);
    }

    private static void quickSort(int[] arr,int startNumber,int endNumber){
        if (startNumber >= endNumber){
            return;
        }
        sort(arr,startNumber,endNumber);
    }

    public static void sort(int[] arr,int startNumber,int endNumber){
        if (startNumber >= endNumber){
            return;
        }
        int provt = arr[endNumber];
        int start = startNumber;
        int end = endNumber - 1;

        while (start < end){
            while (arr[start] <= provt && start < end) {
                start++;
            }
            while (arr[end] >= provt && start < end){
                end--;
            }
            tweNumberExchange(arr,start,end);
        }

        tweNumberExchange(arr,start,endNumber);

        sort(arr,startNumber,end);

        sort(arr,end,endNumber);

    }



    /**
     * 两数交换
     * @param arr 数组
     * @param i 标记1
     * @param j 标记2
     */
    public static void tweNumberExchange(int[] arr,int i,int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * 输出打印
     * @param arr 数组
     */
    public static void getPrint(int[] arr){
        for (int i = 0;i < arr.length;i++){
            System.out.print(arr[i] +" ");
        }
    }

  /*  @Test
    public void test(){
        int[] arr = {1,4};
        tweNumberExchange(arr,0,1);
        getPrint(arr);
    }*/



}
