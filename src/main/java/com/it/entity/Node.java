package com.it.entity;

import java.io.Serializable;

/**
 * @author LY
 * @PackageName:com.it.Entity
 * @ClassName:Node
 * @date 2021/5/25 11:11
 * 类说明: <br>
 *     构建链表节点
 */
public class Node<T> implements Serializable {
    private static final long serialVersionUID = -9002622577510248542L;

    public T item;

    public Node next;

    public Node(T item,Node next){
        this.item = item;
        this.next = next;
    }
}
