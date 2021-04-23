package com.it.algorithm.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class AlgorithmSelectionTest {

    /**
     * 快速排序
     */
    @Test
    @DisplayName("selection")
    public void selectionTest() {
        // 定义一个数组
        int[] arr = {2, 4, 1, 5, 8, 3, 6, 7, 9};
        // 快速排序方法体
        // 方法一
        // int temp;
        /*for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length - 2; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }*/
        // 方法二
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length - 1; j++) {
                // 优化前
                if (arr[minPos] > arr[j]) {
                    minPos = j;
                }
                // 优化后 通过三元运算符进行优化
                minPos = arr[minPos] > arr[j] ? j : minPos;
            }
            DataCheckerUtils.swap(arr, i, minPos);
        }
        // 输出
        arrayOutput(arr);
    }

    /**
     * 数组输出
     * @param arr 待输出数组
     */
    private void arrayOutput(int[] arr) {
        // 循环打印
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    /**
     * 选择排序静态方法
     *
     * @param arr 待排序数组
     */
    static void SeletionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length - 1; j++) {
                // 优化前
                if (arr[minPos] > arr[j]) {
                    minPos = j;
                }
                // 优化后 通过三元运算符进行优化
                minPos = arr[minPos] > arr[j] ? j : minPos;
            }
            DataCheckerUtils.swap(arr, i, minPos);
        }
    }

    /**
     * 验证方法
     */
    @Test
    public void checkTest() {
        int[] arr = DataCheckerUtils.genertateRandomArray();
        int[] arr1 = arr;
//        Arrays.stream(arr).forEach(System.out::println);
        Arrays.sort(arr);
//        Arrays.stream(arr).forEach(System.out::println);
        SeletionSort(arr1);
//        Arrays.stream(arr1).forEach(System.out::println);

        boolean same = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr1[i]) {
                same = false;
                break;
            }
        }
        System.out.println(same ? "right" : "wrong");

    }

    /**
     * 验证是否为不稳定
     */
    @Test
    public void selectionTest01() {
        // 定义一个数组
        double[] arr = {2.1, 2.3, 3.4, 5.5, 5.6, 3.2, 6.1,6.2,5.4};
        // 快速排序方法体
        // 方法二
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length ; j++) {
                // 优化前
                if ((int)Math.floor(arr[minPos]) > (int)Math.floor(arr[j])) {
                    minPos = j;
                }
                // 优化后 通过三元运算符进行优化
                // minPos = arr[minPos] > arr[j] ? j : minPos;
            }
            double temp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = temp;
        }
        // 循环打印
        for (double v : arr) {
            System.out.print(v + " ");
        }
        System.out.println();
        System.out.println("2.1 2.3 3.4 3.2 5.6 5.5 5.4 6.2 6.1 ");
    }
}
