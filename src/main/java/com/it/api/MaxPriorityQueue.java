package com.it.api;

/**
 * @author LY
 * @PackageName:com.it.api
 * @ClassName:MaxPriorityQueue
 * @date 2021/5/31 13:50
 * 类说明: <br> 最大优先队列代码
 */
public class MaxPriorityQueue<T extends Comparable<T>> {

    /**存储堆中的元素*/
    private T[] items;
    /**记录堆中元素的个数*/
    private int N;

    public MaxPriorityQueue(int capacity){
        items = (T[]) new  Comparable[capacity+1];
    }

    /**
     * 功能说明: <br>
     *    获取队列中元素个数
     */
    public int size() {
        return this.N;
    }

    /**
     * @return boolean ture为null false 不为空
     * 功能说明: <br>
     *     判断队列是否为NULL
     */
    public boolean isEmpty() {
        return this.N == 0;
    }

    /**
     * @Param [i, j]索引i，索引j
     * @return boolean 索引i小于索引j元素为TRUE
     * 功能说明: <br>
     *     判断堆中索引i处的元素是否小于索引j处元素
     */
    private boolean less(int i,int j){
        return items[i].compareTo(items[j]) < 0;
    }

    /**
     * @Param [i, j] 索引i 索引j
     * 功能说明: <br>
     *    交换堆中i索引和索引j处的值
     */
    private void exch(int i, int j){
        T item = items[i];
        items[i] = items[j];
        items[j] = item;
    }

    /**
     * @Param [t] 元素t
     * 功能说明: <br>
     *     往堆中插入一个元素
     */
    public void insert(T t){
        items[++N] = t;
        swim(N);
    }

    /**
     * @return T 返回删除元素
     * 功能说明: <br>
     *     删除堆中最大的元素，返回这个最大元素
     */
    public T delMax(){
        T max = items[1];
        // 交换索引i处和索引N处的值
        exch(1,N);
        // 删除最后位置上的元素
        items[N] = null;
        // 个数减一
        N--;
        sink(1);
        return max;
    }


    /**
     * @Param [k] 索引k处元素
     * 功能说明: <br>
     *     使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
     */
    private void swim(int k){
        // 如果已经到了根节点，就不需要循环了
        while (k>1){
            // 比较当前结点和父节点
            if (less(k / 2,k)){
                //父节点小于当前结点，需要交换
                exch(k/2,k);
            }

            k = k/2;
        }
    }

    /**
     * @Param [k] k索引元素
     * 功能说明: <br>
     *    使用下沉算法，使索引k处的元素在堆中处于一个正确的位置
     */
    private void sink(int k){
        // 如果当前已经是最底层了，就不需要循环了
        while (2 * k <= this.N){
            // 找到子节点中的较大者
            int max = 2 * k;
            if (2 * k + 1 <= N){
                if (less(2*k,2*k+1)){
                    max = 2*k+1;
                }
            }

            // 比较当前结点和子结点中较大者，如果当前结点不小，则结束循环
            if (!less(k,max)){
                break;
            }

            // 当前结点小，则交换
            exch(k,max);
            k = max;
        }
    }

}
