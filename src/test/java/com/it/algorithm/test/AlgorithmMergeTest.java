package com.it.algorithm.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author feather
 * @Date 2021/3/6
 */
@SpringBootTest
public class AlgorithmMergeTest {

    /**
     * 归并算法
     */
    @Test
    @DisplayName("merge")
    public void mergeTest() {
        int[] arr = {2, 4, 1, 5, 8, 3, 6, 7, 9};
        int[] temp = new int[arr.length];
        sort(arr,temp,0,arr.length-1);
        for (int i : temp)
            System.out.print(i+" ");
    }

    /**
     * 数组细分
     * @param arr 原数组
     * @param temp 存储数组
     * @param left 左指针
     * @param right 右指针
     */
    public static void sort(int[] arr,int[] temp,int left,int right){
        if (left < right){
            int mid = (left + right)/2;
            // 左数组细分
            sort(arr,temp,left,mid);
            // 右数组细分
            sort(arr,temp,mid+1,right);
            // 数组合并
            merge(arr,left,mid,right,temp);
        }
    }

    /**
     * 数组归并
     * @param arr 原数组
     * @param left 左最大极限
     * @param mid 右指针
     * @param right 右最大极限
     * @param temp 存储数组
     */
    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        //左序列指针
        int i = left;
        //右序列指针
        int j = mid+1;
        //临时数组指针
        int t = 0;
        // 对比 存储 合并
        while (i<=mid && j<=right){
            // 三目
            temp[t++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
          /*  if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }*/
        }
        //将左边剩余元素填充进temp中
        while(i<=mid){
            temp[t++] = arr[i++];
        }
        //将右序列剩余元素填充进temp中
        while(j<=right){
            temp[t++] = arr[j++];
        }
        // 重置记录指针
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }

}
