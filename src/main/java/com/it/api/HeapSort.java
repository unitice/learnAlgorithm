package com.it.api;

import org.apache.tomcat.util.net.WriteBuffer;

/**
 * @author LY
 * @PackageName:com.it.api
 * @ClassName:HeapSort
 * @date 2021/5/31 11:32
 * 类说明: <br>
 */
public class HeapSort {

    /**
     * @Param [source] 堆数组
     * 功能说明: <br>
     *    对source数组中的数据从小到大排序
     */
    public static void sort(Comparable[] source){
        // 1.创建一个比原数组大于1的数组
        Comparable[] heap = new Comparable[source.length + 1];
        // 2.构造堆
        createHeap(source, heap);
        // 3.堆排序
        // 3.1定义一个变量，记录heap中未排序的所有元素中最大的索引
        int N = heap.length - 1;
        while (N != 1){
            // 3.2 交换heap中索引1处的元素和N处的元素
            exch(heap, 1, N);
            N--;
            // 3.3 对索引1处的元素在0~N范围内做下沉操作
            sink(heap, 1, N);
        }
        // 4.heap中的数据已经有序，拷贝到source中
        System.arraycopy(heap,1,source,0,source.length);
    }

    /**
     * @Param [source, heap] 原数组，新数组
     * 功能说明: <br>
     *    根据原数组source，构建出堆heap
     */
    private static void createHeap(Comparable[] source, Comparable[] heap){
        // 1.把source中的数据拷贝到heap中，从heap的1索引处开始填充
        System.arraycopy(source, 0, heap, 1, source.length);
        // 2.从heap索引的一半开始倒述遍历，对得到的每一个元素做下沉操作
        for (int i = (heap.length - 1)/2 ; i > 0 ; i--){
            sink(heap,i,heap.length-1);
        }
    }


    /**
     * @Param [heap, i, j]heap堆，索引i，索引j
     * @return boolean true表示i索引元素小于j索引元素，false反之
     * 功能说明: <br>
     *    判断heap堆中索引i处元素是否小于索引j处元素
     */
    private static boolean less(Comparable[] heap , int i,int j){
        return  heap[i].compareTo(heap[j]) < 0;
    }

    /**
     * @Param [heap, i, j] 堆heap，索引i，索引j
     * 功能说明: <br>
     *     交换heap堆中i索引和j索引处的值
     */
    private static void exch(Comparable[] heap, int i, int j){
        Comparable tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    private static void sink(Comparable[] heap, int target, int range){
        // 没有子结点了
        while (2 * target <= range){
            // 1.找出target结点的两个子结点中较大值
            int max = 2 * target;
            if (2 * target + 1 <= range){
                // 存在右子结点
                if (less(heap, 2 * target, 2 * target + 1)){
                    max = 2 * target + 1;
                }
            }

            // 2.如果当前结点的值小于子节点中的较大值，则交换
            if (less(heap, target, max)){
                exch(heap,target,max);
            }

            // 3.跟新target值
            target = max;
        }
    }


}
