package com.it.api;

import java.io.Serializable;
import java.util.Iterator;

/**
 * @author LY
 * @PackageName:com.it.api
 * @ClassName:LinkList
 * @date 2021/5/25 11:44
 * 类说明: <br> 链表实现线性表
 */
public class LinkList<T> implements Iterable<T>, Serializable {
    private static final long serialVersionUID = -421727129766465801L;

    /**记录头节点*/
    private Node head;
    /**记录链表的长度*/
    private int N;

    public LinkList(){
        // 初始化头节点
        this.head = new Node(null,null);
        N = 0;
    }

    /**
     * 功能说明: <br>
     *    清空链表
     */
    public void clear(){
        this.head.next = null;
        this.head.item = null;
        this.N = 0;
    }

    /**
     * @return int 返回值为int类型线性表长度
     * 功能说明: <br>
     *      获取链表的长度
     */
    public int length(){
        return this.N;
    }

    /**
     * @return boolean 返回是否为TRUE或FALSE TRUE为NULL FALSE不为NULL
     * 功能说明: <br>
     *
     */
    public boolean isEmpty(){
        return this.N == 0;
    }

    /**
     *
     * @Param [i] 索引
     * @return T 返回值
     * 功能说明: <br>
     *      获取指定位置i出的元素
     */
    public T get(int i){
        if (i < 0 || i >= N) {
            throw new RuntimeException("位置不合法");
        }
        Node next = head.next;
        for (int index = 0; index < i; index++){
            next = next.next;
        }
        return (T) next.item;
    }

    /**
     *
     * @Param [t] 存储的值
     * 功能说明: <br>
     *        向链表中添加元素
     */
    public void insert(T t){
        // 找到最后一个节点
        Node head = this.head;
        while (head.next != null) {
            head = head.next;
        }
        Node newNode = new Node(t,null);
        head.next = newNode;
        // 链表长度+1
        N++;
    }

    /**
     *
     * @Param [i, t] 索引位置i，添加元素t
     * 功能说明: <br>
     *     向指定位置i处，添加元素t
     */
    public void insert(int i,T t){
        if (i < 0 || i > N){
            throw new RuntimeException("位置不合法");
        }
        // 寻找位置i之前的结点
        Node head = this.head;
        for (int index = 0; index <= i-1; index++){
            head = head.next;
        }
        // 位置i的结点
        Node next = head.next;
        Node tNode = new Node(t, next);
        // 让之前的节点指向新节点
        head.next = tNode;
        // 长度加一
        N++;
    }

    /**
     *
     * @Param [i] 待删除索引
     * @return T 待删除索引对应值
     * 功能说明: <br>
     *     删除指定位置i处的元素，并返回被删除的元素
     */
    public T remove(int i){
        if (i < 0 || i >= N){
            throw new RuntimeException("位置不合法");
        }
        // 寻找i之前的元素
        Node per = this.head;
        for (int index = 0; index < i; index++){
            per = per.next;
        }
        // 当前i位置的结点
        Node next = per.next;
        // 其前一个结点指向下一个结点
        per.next = next.next;
        // 长度-1
        N--;
        return (T) next.item;
    }

    /**
     *
     * @Param [t] 带查找元素
     * @return int 返回索引
     * 功能说明: <br>
     *     查找元素t在链表中第一次出现的位置
     */
    public int indexOf(T t){
        Node n = this.head;
        for (int index = 0; n.next != null; index++){
            n = n.next;
            if (n.item.equals(t)){
                return index;
            }
        }
        return -1;
    }

    /**
     * 功能说明: <br>
     *     结点内部类
     */
    private class Node{
        // 存储数据
        T item;
        // 下一个结点
        Node next;
        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }



    @Override
    public Iterator<T> iterator() {
        return new LIterator();
    }

    private class LIterator implements Iterator<T> {
        private Node next;
        public LIterator(){
            this.next = head;
        }


        @Override
        public boolean hasNext() {
            return next.next != null;
        }

        @Override
        public T next() {
            next = next.next;
            return next.item;
        }
    }

}
