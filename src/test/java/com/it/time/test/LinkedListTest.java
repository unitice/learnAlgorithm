package com.it.time.test;

import com.it.entity.Node;
import com.it.api.LinkList;
import com.it.api.TwoWayLinkList;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
        six.next = third;

        boolean circle = isCircle(first);

        System.out.println(circle);
        Node entrance = getEntrance(first);
        System.out.println(entrance.item);
    }
    /**
     * @return boolean TRUE 表示有环 FALSE 表示无环
     * 功能说明: <br>
     *      判断单向链表是否有环
     */
    public boolean isCircle(Node head){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            System.out.println(fast);
            System.out.println(slow);
            // 当两者的指针值相等时出现闭环
            if (slow == fast){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @Param [head] 头结点
     * @return java.lang.Object 返回闭环的入口点
     * 功能说明: <br>
     *      查找有环链表中环的入口结点的值
     */
    public Node getEntrance(Node head){
        Node slow = head;
        Node fast = head;
        Node index = null;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            System.out.println(fast);
            System.out.println(slow);
            // 当两者的指针值相等时出现闭环
            if (slow == fast){
               index = head;
               continue;
            }
            if (index != null){
                index = index.next;
                if (index == slow){
                    return index;
                }
            }
        }
        return null;
    }


    /**
     * 功能说明: <br>
     *    单向链表测试
     */
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

    /**
     * 功能说明: <br>
     *    双向链表测试
     */
    @Test
    public void test03(){
        TwoWayLinkList<String> list = new TwoWayLinkList<>();
        list.insert("强风");
        list.insert("虚竹");
        list.insert(2,"短语");
        list.insert(1,"小龙女");
        list.insert(0,"猪猪侠");
        list.insert(4,"君落羽");

        for (String str : list) {
            System.out.println(str);
        }

        System.out.println("索引2："+list.get(2));

        System.out.println("删除2："+list.remove(2));

        System.out.println("链表长度:"+list.length());

        System.out.println("获取首结点："+list.getFirst());

        System.out.println("获取尾结点："+list.getLast());

        list.reverse();
        System.out.println("===================");
        for (String str : list) {
            System.out.println(str);
        }

        System.out.println("获取中间结点："+list.getMid());
    }


    /**
     * 功能说明: <br>
     *    约瑟夫问题解决实现通过链表实现
     */
    @Test
    public void test04(){
        // 1.构建循环链表
        Node first = null;
        // 记录前一个结点
        Node pre = null;
        int length = 30;
        for (int i = 1; i <= length; i++){
            // 第一个元素
            if (i == 1){
                first = new Node(i, null);
                pre = first;
                continue;
            }

            Node node = new Node(i, null);
            pre.next = node;
            pre = node;
            if (i == length){
                // 构建循环链表，让最后一个结点指向第一个结点
                pre.next = first;
            }
        }

        // 使用count，记录当前的报数值
        int count = 0;
        // 遍历链表，每循环一次，count++
        Node n = first;
        Node before = null;
//        int aa = length;
        while (n!=n.next){
            count++;
            if (count == 3){
                // 删除当前结点
                before.next = n.next;
                System.out.print(n.item+",");
                count = 0;
                n = n.next;
//                aa--;
//                if (aa <= length/2){
//                    return;
//                }
            }else {
                before = n;
                n = n.next;
            }
        }
        System.out.println();
        System.out.println(n.item);
    }

}
