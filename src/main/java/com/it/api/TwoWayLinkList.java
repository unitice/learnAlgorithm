package com.it.api;

import java.io.Serializable;
import java.net.PasswordAuthentication;
import java.util.Iterator;

/**
 * @author LY
 * @PackageName:com.it.api
 * @ClassName:TwoWayLinkList
 * @date 2021/5/25 14:27
 * 类说明: <br> 双向链表实现线性表
 */
public class TwoWayLinkList<T> implements Iterable<T>,Serializable {
    private static final long serialVersionUID = -361404679260518510L;

    /**头结点*/
    private Node head;

    /**尾结点*/
    private Node last;

    /**连接长度*/
    private int length;


    public TwoWayLinkList(){
        this.last = null;
        this.head = new Node(null,null,null);
        this.length = 0;
    }

    /**
     * 功能说明: <br>
     *      清空双向链表
     */
    public void clear() {
        this.last = null;
        this.head.perNode = null;
        this.head.item = null;
        this.head.nextNode = last;
        length = 0;
    }

    /**
     * @return int 返回链表长度
     * 功能说明: <br>
     *    获取链表的长度
     */
    public int length() {
        return this.length;
    }

    /**
     * @return boolean TRUE 表示链表为NULL FALSE 表示链表为非NULL
     * 功能说明: <br>
     *     判断链表是否为NULL
     */
    public boolean isEmpty() {
        return this.length == 0;
    }

    /**
     *
     * @Param [t] 待保存的值
     * 功能说明: <br>
     *    插入元素t
     */
    public void insert(T t){
        if (this.last == null){
            this.last = new Node(t,head,null);
            this.head.nextNode = this.last;
        } else {
            Node last = this.last;
            Node node = new Node(t, last, null);
            last.nextNode = node;
            this.last = node;
        }
        // 长度加一
        this.length++;
    }


    /**
     *
     * @Param [i, t] 带插入的结点位置
     * 功能说明: <br>
     *    向指定位置i处插入元素t
     */
    public void insert(int i,T t){
        if (i < 0 || i >= this.length) {
            if (i == this.length) {
                // 当i等于链表长度时相当于在链表尾添加新的元素结点
                insert(t);
                return;
            } else {
                throw new RuntimeException("位置不合法");
            }
        }
        // 找到位置i的结点
        Node node = null;
        if (this.length/2 > i){
            node = this.head;
            for (int index = 0; index <= i; index++) {
                node = node.nextNode;
            }
        } else {
            node = this.last;
            for (int index = this.length-1; index > i; index--){
                node = node.perNode;
            }
        }
        // 获取位置i前一个结点
        Node perNode = node.perNode;
        // 构建新结点
        Node node1 = new Node(t, perNode, node);
        // 将原i位置索引的结点的前结点指向新结点
        node.perNode = node1;
        // 将位置i前一个结点的尾结点指向新结点
        perNode.nextNode = node1;
        // 长度加一
        this.length++;
    }


    /**
     *
     * @Param [i] 索引值
     * @return T 返回值值
     * 功能说明: <br>
     *     获取指定位置i处的元素
     */
    public T get(int i){
        if (i < 0 || i >= this.length){
            throw new RuntimeException("位置不合法");
        }
        // 找到位置i的结点
        Node node = null;
        if (this.length/2 > i){
            node = this.head;
            for (int index = 0; index <= i; index++) {
                node = node.nextNode;
            }
        } else {
            node = this.last;
            for (int index = this.length-1; index > i; index--){
                node = node.perNode;
            }
        }
        return node.item;
    }


    /**
     *
     * @Param [t] 元素t
     * @return int 返回索引值
     * 功能说明: <br>
     *    找到元素t在链表中第一次出现的位置
     */
    public int indexOf(T t){
        Node node = this.head;
        for(int i = 0; node.nextNode != null; i++){
            node = node.nextNode;
            if (node.item.equals(t)) {
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @Param [i] 待删除索引位置
     * @return T 待删除索引指定元素
     * 功能说明: <br>
     *    删除位置i处的元素，并返回该元素
     */
    public T remove(int i){
        if (i < 0 || i >= this.length) {
            throw new RuntimeException("位置不合法");
        }
        // 找到位置i的结点
        Node node = null;
        if (this.length/2 > i){
            node = this.head;
            for (int index = 0; index <= i; index++) {
                node = node.nextNode;
            }
        } else {
            node = this.last;
            for (int index = this.length-1; index > i; index--){
                node = node.perNode;
            }
        }
        // 获取i前一个位置的元素
        Node perNode = node.perNode;
        // 获取i位置后一个元素
        Node nextNode = node.nextNode;
        // 将前一个位置的元素的尾结点指向后一个位置的 将后一个位置的前结点指向前一个结点
        nextNode.perNode = perNode;
        perNode.nextNode = nextNode;
        // 链表长度减一
        this.length--;
        // 返回元素
        return node.item;
    }

    /**
     * 功能说明: <br>
     *     获取第一个元素
     */
    public T getFirst(){
        if (isEmpty()){
            return null;
        }
        return this.head.nextNode.item;
    }

    /**
     * 功能说明: <br>
     *     获取最后一个元素
     */
    public T getLast(){
        if (isEmpty()){
            return null;
        }
        return this.last.item;
    }

    /**
     * 功能说明: <br>
     *     通过快慢指针的方法获取链表中间值
     */
    public T getMid(){
        if (isEmpty()){
            throw new RuntimeException("链表为null！");
        }
        Node slow = this.head;
        Node fast = this.head;
        while (fast != null && fast.nextNode != null){
            fast = fast.nextNode.nextNode;
            slow = slow.nextNode;
        }
        return slow != null ? slow.item : null;
    }

    /**
     * 功能说明: <br>
     *     链表反转
     */
    public void reverse(){
        if (isEmpty()){
            // 当前为NULL链表，不需要反转
            return;
        }
        reverse(head.nextNode);
    }

    /**
     *
     * @Param [current] 当前遍历的结点
     * @return com.it.api.TwoWayLinkList<T>.Node 反转后当前结点的上一个结点
     * 功能说明: <br>
     *    通过递归实现链表反转
     */
    public Node reverse(Node current){
        // 已经到了最后一个元素
        if (current.nextNode == null){
            // 反转后，头结点因该指向原链表中的最后一个元素
            head.nextNode = current;
            return current;
        }
        // 当前结点的上一个结点
        Node reverse = reverse(current.nextNode);
        reverse.nextNode = current;
        // 当前结点的下一个结点设置为null
        current.nextNode = null;
        return current;
    }

    @Override
    public Iterator<T> iterator() {
        return new TIterator();
    }

    private class TIterator implements Iterator{
        private  Node node = head;

        @Override
        public boolean hasNext() {
            return node.nextNode != null;
        }

        @Override
        public Object next() {
            node = node.nextNode;
            return node.item;
        }
    }

    /**
     * 功能说明: <br>
     *      结点类
     */
    public class Node{
        /**指向头节点*/
        public Node perNode;
        /**参数值*/
        public T item;
        /**指向尾结点*/
        public Node nextNode;

        public Node(T item,Node perNode,Node nextNode){
            this.perNode = perNode;
            this.item = item;
            this.nextNode = nextNode;
        }

    }

}
