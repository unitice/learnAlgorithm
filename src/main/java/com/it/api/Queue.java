package com.it.api;

import java.io.Serializable;
import java.util.Iterator;

/**
 * @author LY
 * @PackageName:com.it.api
 * @ClassName:Queue
 * @date 2021/5/26 13:44
 * 类说明: <br> 队列aip
 */
public class Queue<T> implements Iterable<T>,Serializable {
    private static final long serialVersionUID = -7921893748449561943L;

    /**记录首结点*/
    private Node head;
    /**记录尾结点*/
    private Node last;
    /**记录队列中元素的个数*/
    private int N;

    public Queue(){
        this.head = new Node(null,null);
        last = null;
        N = 0;
    }

    /**
     * @return boolean TURE 队列为null  FALSE 队列不为null
     * 功能说明: <br>
     *    判断队列是否为空
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * @return int 队列元素个数
     * 功能说明: <br>
     *     返回队列中元素的个数
     */
    public int size() {
        return N;
    }

    /**
     * @Param [t] 插入元素
     * 功能说明: <br>
     *    向队列中插入元素
     */
    public void enqueue(T t){
        if (last == null){
           last = new Node(t,null);
           head.next = last;
        } else {
            Node oldLast = last;
            last = new Node(t, null);
            oldLast.next = last;
        }
        // 队列长度加一
        N++;
    }

    /**
     * @return T 返回元素值
     * 功能说明: <br>
     *    从队列中拿出元素
     */
    public T dequeue(){
        if (isEmpty()){
            return null;
        }
        Node oldFirst = head.next;
        head.next = oldFirst.next;
        N--;
        if (isEmpty()){
            last = null;
        }
        return oldFirst.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new QIterator();
    }


    private class QIterator implements Iterator<T> {

        private Node node = head;

        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public T next() {
            Node next = node.next;
            node = node.next;
            return next.item;
        }
    }


    private class Node {
        public T item;
        public Node next;

        public Node(T item,Node next){
            this.item = item;
            this.next = next;
        }
    }

}
