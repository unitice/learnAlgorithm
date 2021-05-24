package com.it.api;

import java.io.Serializable;
import java.util.Iterator;

/**
 * @author LY
 * @PackageName:com.it.api
 * @ClassName:SequenceList
 * @date 2021/5/24 13:43
 * 类说明: <br> 顺序表实现类
 */
public class SequenceList<T> implements Iterable<T>, Serializable {


    private static final long serialVersionUID = -5351796034000534723L;
    /**存储元素的数组*/
    private T[] eles;
    /**记录当前顺序表中的元素个数*/
    private int N;
    /**定义数组的长度阈值*/
    private final int four = 4;
    private final int twe = 2;

    /**
     *
     * @Param [capacity]
     * 功能说明: <br>
     *     构造方法
     */
    public SequenceList(int capacity){
        eles = (T[])new Object[capacity];
        N = 0;
    }

    /**
     * 功能说明: <br>
     *     将一个线性表置为NULL表
     */
    public void clear(){
        N = 0;
    }

    /**
     * @return boolean 返回TRUE或FALSE
     * 功能说明: <br>
     *    判断线性表是否为NULL
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     *
     * @return int 返回线性表的长度值
     * 功能说明: <br>
     *     获取线性表的长度
     */
    public int length(){
        return N;
    }
    /**
     *
     * @Param [i] 索引
     * @return T 索引指定元素
     * 功能说明: <br>
     *    获取指定位置的元素
     */
    public T get(int i){
        if (i < 0 || i >= N){
            throw new RuntimeException("当前元素不存在！");
        }
        return eles[i];
    }

    /**
     *
     * @Param [t] 元素t
     * 功能说明: <br>
     *    向线性表中添加元素t
     */
    public void insert(T t){
        if (N == eles.length){
            resize(eles.length * twe);
//            throw new RuntimeException("当前表已满！");
        }
        eles[N++] = t;
    }

    /**
     *
     * @Param [i, t] 对顺序表中第i个位置插入t元素
     * 功能说明: <br>
     *    在i索引处插入元素t
     */
    public void insert(int i, T t){
        if (i == eles.length){
//            throw new RuntimeException("当前表已满！");
            resize(eles.length * this.twe);
        }
        if (i < 0 || i > N) {
            throw new RuntimeException("插入位置不合法！");
        }
        // 把i位置空出来，i位置及其后面元素依次向后移动一位
        for (int index = N; index > i; index--){
            eles[index] = eles[index-1];
        }
        // 把t放到i位置处
        eles[i] = t;
        // 元素数量+1
        N++;
    }

    /**
     *
     * @Param [ts] 待插入数组长度
     * 功能说明: <br>
     *    批量添加数据到线性表中
     */
    public void insert(T[] ts){
        if ((eles.length - N) < ts.length){
            // 如果带插入数组长度低于两倍线性表长度将线性表扩展为原长度二倍
            if (ts.length < (eles.length + eles.length - N)){
                resize(eles.length + eles.length);
            } else {
                // 否则扩展为带插入数组长度加原数组长度
                resize(eles.length + ts.length);
            }
        }
        // 将数组后面添加想数据 src表示源数组(数据源)，srcPos表示源数组要复制的起始位置，destPos  目标数组的起始位置.，desc表示目标数组，length表示要复制的长度。
        System.arraycopy( ts, 0,eles, N, ts.length);
        // 数组长度
        N = N+ts.length;
    }
    /**
     *
     * @Param [i] 索引值
     * @return T 返回该索引对应的值
     * 功能说明: <br>
     *    删除指定位置i处的元素，并返回该元素
     */
    public T remove(int i){
        if (i < 0 || i > N-1){
            throw new RuntimeException("当前要删除的元素不存在");
        }
        // 记录i位置处的元素
        T result = eles[i];
        // 把i位置后面的元素都向前移动一位
        if (N - 1 - i >= 0) {
            System.arraycopy(eles, i + 1, eles, i, N - 1 - i);
        }
        // 将最后一个元素置null
        eles[N-1] = null;
        // 当前元素数量-1
        N--;
        if (N < eles.length/this.four){
            resize(eles.length/this.four);
        }
        return result;
    }

   /**
    *
    * @Param [t] 请求参数，查询该参数是否存在该顺序表中
    * @return int 返回值 返回其位置，当不存在时返回-1
    * 功能说明: <br>
    *    查找t元素第一次出现的位置
    */
    public int indexOf(T t){
        if(t == null){
            throw new RuntimeException("查找的元素不合法");
        }
        for (int i = 0; i < N; i++){
            if (eles[i].equals(t)){
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * 功能说明: <br>
     *   返回线性表中所有元素
     */
    public Object[] getEles() {
        return eles;
    }


    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{
        private int cur;
        public SIterator() {
            this.cur = 0;
        }
        @Override
        public boolean hasNext(){
            return cur < N;
        }
        @Override
        public T next() {
            return eles[cur++];
        }
    }

    private void resize(int newSize){
        // 记录旧数组
        T[] temp = eles;
        // 创建新数组
        eles = (T[])new Object[newSize];
        // 将原线性表的值copy到新线性表
        System.arraycopy(temp,0,eles,0,this.N);
    }

}
