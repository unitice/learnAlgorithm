package com.it.api;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author LY
 * @PackageName:com.it.api
 * @ClassName:SymbolTable
 * @date 2021/5/26 14:12
 * 类说明: <br>
 */
public class OrderSymbolTable<Key extends Comparable<Key> ,Value> implements Iterable<Map<Key, Value>>,Serializable {


    private static final long serialVersionUID = 4297227005971778333L;
    /**记录首结点*/
    private Node head;
    /**记录符合代表中元素的个数*/
    private int N;

    public OrderSymbolTable(){
        this.head = new Node(null,null,null );
        this.N = 0;
    }

    /**
     * @return int 返回链表长度
     * 功能说明: <br>
     *    获取符号表中键值对的个数
     */
    public int size(){
        return this.N;
    }

    /**
     * @Param [key, value] 添加键值对
     * 功能说明: <br>
     *    往符号表中插入键值对
     */
    public void put(Key key,Value value){
        // 记录当前结点
        Node curr = this.head.next;
        // 记录上一个结点
        Node per = this.head;
        // 如果key大于当前结点key，则一致寻找下一个结点
        while (curr != null && key.compareTo(curr.key) > 0){
            per = curr;
            curr = curr.next;
        }
        // 如果当前结点curr的key和即将插入的key一样。则替换value
        if (curr != null && curr.key.compareTo(key)==0){
            curr.value = value;
            return;
        }
        // 没有找到相同的key，把新结点插入到之前的curr之前
        Node node = new Node(key, value, curr);
        per.next = node;
        // 数量加一
        this.N++;
    }

    /**
     * @Param [key] key值
     * 功能说明: <br>
     *    删除符合表中键为key的键值对
     */
    public void delete(Key key){
        Node node = this.head;
        while (node.next != null){
            if (node.next.key.equals(key)){
                node.next = node.next.next;
                N--;
                return;
            }
            node = node.next;
        }
    }


    /**
     *
     * @Param [key] 键值对中key值
     * @return Value 键值对中value值
     * 功能说明: <br>
     *    从符号表中获取key对应的值
     */
    public Value get(Key key) {
        Node node = getNode(key);
        if (node != null){
            return node.value;
        }
        return null;
    }

    /**
     * @Param [key] 键值对中key值
     * @return com.it.api.SymbolTable<Key,Value>.Node 对应的结点
     * 功能说明: <br>
     *     通过key值查找所在结点
     */
    private Node getNode(Key key){
        Node n = this.head;
        while (n.next != null) {
            n = n.next;
            if (n.key.equals(key)){
                return n;
            }
        }
        return null;
    }

    @Override
    public Iterator<Map<Key, Value>> iterator() {
        return new SIterator();
    }


    private class SIterator implements Iterator<Map<Key, Value>> {
        private Node n = head;

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Map<Key, Value> next() {
            Node next = n.next;
            n = n.next;
            Map<Key, Value> map = new HashMap<>();
            map.put(next.key,next.value);
            return map;
        }
    }


    private class Node{
        /**键*/
        public Key key;
        /**值*/
        public Value value;
        /**下一个结点*/
        public Node next;

        public Node(Key key,Value value,Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

}
