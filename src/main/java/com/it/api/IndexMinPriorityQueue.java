package com.it.api;

/**
 * @author LY
 * @PackageName:com.it.api
 * @ClassName:IndexMinPriorityQueue
 * @date 2021/5/31 15:44
 * 类说明: <br> 最小索引优先队列
 */
public class IndexMinPriorityQueue<T extends Comparable<T>> {

    /**
     * 存储堆中的元素
     */
    private T[] items;
    /**
     * 保存每一个元素在items数组中的索引，pq数组需要堆有序
     */
    private int[] pq;
    /**
     * 保存qp的逆序，pq的值为索引，pq的索引为值
     */
    private int[] qp;
    /**
     * 记录堆中元素的个数
     */
    private int N;

    public IndexMinPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity + 1];
        this.pq = new int[capacity + 1];
        this.qp = new int[capacity + 1];
        this.N = 0;
        for (int i = 0; i < capacity; i++) {
            // 默认情况下，qp逆序不保存任何索引
            this.qp[i] = -1;
        }
    }

    /**
     * @return int 返回队列元素个数
     * 功能说明: <br>
     *    获取队列中元素的个数
     */
    public int size() {
        return this.N;
    }

    /**
     * @return boolean true 为null
     * 功能说明: <br>
     *    判断队列是否为空
     */
    public boolean isEmpty() {
        return this.N == 0;
    }


    /**
     * @Param [i, j]索引i ，索引j
     * @return boolean true i索引元素小于j索引元素
     * 功能说明: <br>
     *    判断堆中索引i处的元素是否小于索引j处的元素
     */
    private boolean less(int i, int j) {
        // 先通过pq找出items中的索引，然后再找出items中的元素进行对比
        return items[pq[i]].compareTo(items[pq[j]]) < 0;
    }

    /**
     * @Param [i, j]索引i ，索引j
     * 功能说明: <br>
     *    /交换堆中i索引和j索引处的值
     */
    private void exch(int i, int j) {
        // 先交换pq数组中的值
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
        // 更新qp数组中的值
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    /**
     * @Param [k] 索引k
     * @return boolean ture 索引所在元素存在
     * 功能说明: <br>
     *    判断k对应的元素是否存在
     */
    public boolean contains(int k) {
        // 默认情况下，qp的所有元素都为-1，如果某个位置插入了数据，则不为-1
        return qp[k] != -1;
    }

    /**
     * @return int 返回最小元素索引
     * 功能说明: <br>
     *    最小元素关联的索引
     */
    public int minIndex() {
        // pq的索引1处，存放的最小元素在items中的索引
        return pq[1];
    }

    /**
     * @Param [i, t] 索引i 元素k
     * 功能说明: <br>
     *    往队列中插入一个元素,并关联索引i
     */
    public void insert(int i, T t) {
        // 如果索引i处已经存在了元素，则不让插入
        if (contains(i)) {
            throw new RuntimeException("该索引已经存在");
        }
        // 个数+1
        N++;
        // 把元素存放到items数组中
        items[i] = t;
        // 使用pq存放i这个索引
        pq[N] = i;
        // 在qp的i索引处存放N
        qp[i] = N;
        // 上浮items[pq[N]] ,让pq堆有序
        swin(N);
    }


    /**
     * @return int 返回删除元素
     * 功能说明: <br>
     *    删除队列中最小的元素,并返回该元素关联的索引
     */
    public int delMin() {
        // 找到items中最小元素的索引
        int minIndex = pq[1];
        // 交换pq中索引1处的值和N处的值
        exch(1, N);
        // 删除qp中索引pq[N]处的值
        qp[pq[N]] = -1;
        // 删除pq中索引N处的值
        pq[N] = -1;
        // 删除items中的最小元素
        items[minIndex] = null;
        // 元素数量-1
        N--;
        // 对pq[1]做下沉，让堆有序
        sink(1);
        return minIndex;
    }

    /**
     * @Param [i] 删除索引i关联元素
     * 功能说明: <br>
     *     删除索引i关联的元素
     */
    public void delete(int i) {
        // 找出i在pq中的索引
        int k = qp[i];
        // 把pq中索引k处的值和索引N处的值交换
        exch(k, N);
        // 删除qp中索引pq[N]处的值
        qp[pq[N]] = -1;
        // 删除pq中索引N处的值
        pq[N] = -1;
        // 删除items中索引i处的值
        items[i] = null;
        // 元素数量-1
        N--;
        // 对pq[k]做下沉，让堆有序
        sink(k);
        // 对pq[k]做上浮处理，让堆有序
        swin(k);
    }

    /**
     * @Param [i, t] 索引i 元素t
     * 功能说明: <br>
     *     把与索引i关联的元素修改为为t
     */
    public void changeItem(int i,T t){
        // 修改items数组中索引i处的值为t
        items[i] = t;
        // 找到i在pq中的位置
        int k = qp[i];
        // 对pq[k]做下沉，让堆有序
        sink(k);
        // 对pq[k]做上浮，让堆有序
        swin(k);
    }

    /**
     * 功能说明: <br>
     *    使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
     */
    private void swin(int k){
        // 如果已经到了跟结点，则结束上浮
        while (k > 1){
            // 比较当前结点和父节点，如果当前结点比父节点小，则交换位置
            if (less(k,k/2)){
                exch(k,k / 2);
            }
            k = k/2;
        }
    }

    /**
     * 功能说明: <br>
     *    使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
     */
    private void sink(int k){
        // 如果当前结点已经没有子节点了 则结束下沉
        while (2*k <= N){
            // 找出子节点中的较小值
            int min = 2 * k;
            if (2*k+1 <= N && less(2*k+1,2*k)){
                min = 2*k+1;
            }
            // 如果当前结点的值比子结点中的较小值小，则结束下沉
            if (less(k,min)){
                break;
            }
            exch(k,min);
            k = min;
        }
    }


}
