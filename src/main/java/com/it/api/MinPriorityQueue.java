package com.it.api;
/**
 * @author LY
 * @PackageName:com.it.api
 * @ClassName:MinPriorityQueue
 * @date 2021/5/31 14:50
 * 类说明: <br>最小优先队列
 */
public class MinPriorityQueue<T extends Comparable<T>> {

    /**存储堆中的元素*/
    private T[] items;
    /**记录堆中元素个数*/
    private int N;

    public MinPriorityQueue(int capacity){
        items = (T[]) new Comparable[capacity+1];
        N = 0;
    }

    /**
     * @return int 返回队列元素个数
     * 功能说明: <br>
     *    获取队列中元素的个数
     */
    public int size(){
        return this.N;
    }

    /**
     * @return boolean NULL为true
     * 功能说明: <br>
     *    判断队列是否为空
     */
    public boolean isEmpty(){
        return this.N == 0;
    }

    /**
     * @Param [i, j] 索引i，索引j
     * @return boolean ture小于，false大于
     * 功能说明: <br>
     *     判断堆中索引i处的元素是否小于索引j处元素
     */
    private boolean less(int i,int j){
        return items[i].compareTo(items[j]) < 0;
    }

    /**
     * @Param [i, j]索引i，索引j
     * 功能说明: <br>
     *     交换堆总i索引和j索引处的值
     */
    private void exch(int i,int j){
        T item = items[i];
        items[i] = items[j];
        items[j] = item;
    }

    /**
     * @Param [t] 新元素
     * 功能说明: <br>
     *     往堆中插入一个元素
     */
    public void insert(T t){
        items[++N] = t;
        swim(N);
    }

    /**
     * @return T 被删除的最小值
     * 功能说明: <br>
     *     删除堆中最小的元素，并返回这个最小元素
     */
    public T delMin(){
        // 索引1处的值为最小值
        T min = items[1];
        // 交换索引1处和索引N处的值
        exch(1,N);
        // 删除索引N处的值
        items[N] = null;
        // 数据元素-1
        N--;
        // 对索引1处的值做下沉，使堆重新有序
        sink(1);
        // 返回被删除的值
        return min;
    }

    /**
     * @Param [k] 索引k
     * 功能说明: <br>
     *     使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
     */
    private void swim(int k){
        // 如果没有父节点，则不再上浮
        while (k > 1){
            // 如果当前结点比父节点小，则交换
            if (less(k,k/2)){
                exch(k,k / 2);
            }
            k = k/2;
        }
    }

    /**
     * @Param [k] 索引k
     * 功能说明: <br>
     *    使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
     */
    private void sink(int k){
        // 如果没有子结点，则不再下沉
        while (2 * k <= N){
            // 找出子节点中的较小值的索引
            int min = 2 * k;
            if (2 * k + 1 <= N && less(2 * k + 1,2 * k)){
                min = 2 * k + 1;
            }
            // 如果当前结点小于子节点中较小值，则结束循环
            if (less(k,min)){
                break;
            }
            // 当前结点大，交换
            exch(min,k);
            k = min;
        }
    }

}
