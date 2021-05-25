package com.it.time.test;

import com.it.Entity.Node;
import com.it.api.LinkList;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;

/**
 * @author LY
 * @PackageName:com.it.time.test
 * @ClassName:LinkedListTest
 * @date 2021/5/25 11:17
 * 类说明: <br>
 */
@SpringBootTest
public class LinkedListTest {

    @Test
    public void test01(){
        TectonicNode();



    }

    private void TectonicNode() {
        // 构建节点
        Node<Integer> first = new Node<>(11, null);
        Node<Integer> second = new Node<>(13, null);
        Node<Integer> third = new Node<>(1, null);
        Node<Integer> fourth = new Node<>(5, null);
        Node<Integer> fifth = new Node<>(9, null);
        Node<Integer> six = new Node<>(8, null);

        // 生成链表
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = six;


        System.out.println(second.next.item);
    }


    @Test
    public void test02(){
        LinkList<String> list = new LinkList<>();
        list.insert(0,"张山");
        list.insert("李四");
        list.insert(2,"老王");
        list.insert("赵兴");

        // 测试length方法
        for(String str : list){
            System.out.println(str);
        }

        System.out.println("链表长度："+list.length());

        System.out.println("获取索引为2："+list.get(2));

        System.out.println("删除索引为1："+list.remove(1));

        for (String str : list) {
            System.out.println(str);
        }

    }
}
