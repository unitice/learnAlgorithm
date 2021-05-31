package com.it.api;

import javax.swing.*;

/**
 * @author LY
 * @PackageName:com.it.api
 * @ClassName:Heap
 * @date 2021/5/31 10:16
 * 类说明: <br>
 */
public class Heap<T extends Comparable<T>> {

    /**存储堆中的元素*/
    private T[] items;
    /**记录堆中元素的个数*/
    private int N;

    public Heap(int capacity){
        this.items = (T[]) new Comparable[capacity+1];
        this.N = 0;
    }

    /**
     * @Param [i, j] 索引i和索引j
     * @return boolean 返回True表示i索引位置的值小于j索引位置的值
     * 功能说明: <br>
     *     判断堆中索引i处的元素是否小于索引j处元素
     */
    private boolean less(int i,int j){
        return items[i].compareTo(items[j]) < 0;
    }

    /**
     * @Param [i, j]索引i和j
     * 功能说明: <br>
     *     交换堆中索引i和j索引处的值
     */
    private void exch(int i, int j){
        T item = items[i];
        items[i] = items[j];
        items[j] = item;
    }


    /**
     * @Param [t] 待添加值
     * 功能说明: <br>
     *     往堆中插入一个元素
     */
    public void insert(T t){
        items[++N] = t;
        swim(N);
    }

    /**
     * @return T 返回被删除值
     * 功能说明: <br>
     *     删除堆中最大的元素，并返回这个最大的元素
     */
    public T delMax(){
        T max = items[1];
        // 交换索引1和索引N处的值
        exch(1,N);
        // 删除最后位置上的元素
        items[N] = null;
        this.N--;
        sink(1);
        return max;
    }

    /**
     * @Param [N] 最后一个位置
     * 功能说明: <br>
     *     使用上浮点算法，使索引k处的元素能在堆中处于一个不错的位置
     */
    private void swim(int N){
        // 如果已经到了根结点，就不需要循环了
        while (N >1){
            // 比较当前结点和其父节点
            if (less(N/2,N)){
                // 父节点小于当前结点，需要交换
                exch(N/2,N);
            }
            N = N/2;
        }
    }

    /**
     * @Param [k] 索引k
     * 功能说明: <br>
     *    使用下沉算法，使索引k处于的元素能在堆中处于一个正确的位置
     */
    private void sink(int k){
        // 如果当前已经是最底层了，就不需要循环了
        while (2 * k <= N){
            // 找到子节点中的较大者
            int max;
            if (2 * k + 1 <= N){
                // 存在右结点
                if (less(2 * k,2 * k + 1)){
                    max = 2 * k + 1;
                }else {
                    max = 2 * k;
                }
            } else {
                // 不存在右子结点
                max = 2 * k;
            }

            // 比较当前结点和子节点中的较大者，如果当前结点不小，则结束循环
            if (!less(k, max)){
                break;
            }
            // 当前结点小，则交换
            exch(k, max);
            k = max;
        }
    }
}
