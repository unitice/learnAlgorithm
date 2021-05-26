package com.it.api;

import java.io.Serializable;
import java.util.Iterator;

/**
 * @author LY
 * @PackageName:com.it.api
 * @ClassName:Stack
 * @date 2021/5/26 9:54
 * 类说明: <br> 栈api
 */
public class Stack<T> implements Iterable<T>,Serializable {
    private static final long serialVersionUID = -3400397604076926848L;

    private Node head;

    private int N;

    public Stack(){
        this.head = new Node(null,null);
        this.N = 0;
    }

    /**
     * @return boolean TRUE 表示NULL栈 FALSE 表示非NULL栈
     * 功能说明: <br>
     *     判断当前栈中元素是否为0
     */
    public boolean isEmpty(){
        return this.N == 0;
    }

    /**
     * @Param [t] 入栈元素
     * 功能说明: <br>
     *     把元素进行入栈处理
     */
    public void push(T t) {
        Node next = this.head.next;
        Node node = new Node(t, next);
        this.head.next = node;
        // 个数加一
        this.N++;
    }

    /**
     * @return T 弹栈返回值
     * 功能说明: <br>
     *     弹出栈顶元素
     */
    public T pop(){
        // 活动首结点
        Node next = this.head.next;
        // 判断首结点是否为null
        if (next == null){
            return null;
        }
        // 删除首元素
        head.next = head.next.next;
        // 个数减一
        this.N--;
        return next.item;
    }

    /**
     * @return int 返回栈长度
     * 功能说明: <br>
     *    获取栈中元素的个数
     */
    public int size() {
        return this.N;
    }



    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }


    private class SIterator implements Iterator<T>{
        private Node n = head;

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public T next() {
            Node next = n.next;
            n = n.next;
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
