package com.it.time.test;

import com.it.api.BinaryTree;
import com.it.api.Queue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LY
 * @PackageName:com.it.time.test
 * @ClassName:BinaryTreeTest
 * @date 2021/5/26 17:40
 * 类说明: <br>
 */
@SpringBootTest
public class BinaryTreeTest {

    @Test
    public void test01() {
        BinaryTree<Integer, String> bt = new BinaryTree<>();
        bt.put(2, "aa");
        bt.put(1, "dd");
        bt.put(6, "bb");
        bt.put(5, "ff");
        bt.put(3, "ee");
        bt.put(9, "ss");
        bt.put(7, "ww");
        System.out.println(bt.size());
        bt.put(1, "cc");
        System.out.println(bt.size());
        System.out.println(bt.get(1));
        System.out.println(bt.size());
        bt.delete(1);
        bt.delete(5);
        System.out.println(bt.size());
        System.out.println(bt.getMax());
        System.out.println(bt.getMin());
        Queue<Integer> integers = bt.perErgodices();
        Queue<Integer> integers1 = bt.midErgodic();
        Queue<Integer> integers2 = bt.afterErgodic();
        System.out.println("=====前序遍历======");
        for (Integer i : integers) {
            System.out.print(i);
        }
        System.out.println();
        System.out.println("======中序遍历======");
        for (Integer i : integers1) {
            System.out.print(i);
        }
        System.out.println();
        System.out.println("======后序遍历======");
        for (Integer i : integers2) {
            System.out.print(i);
        }
        System.out.println();
        System.out.println("======层次遍历======");
        Queue<Integer> integers3 = bt.layerErgodic();
        for (Integer i : integers3) {
            System.out.print(i);
        }
        System.out.println();
        System.out.println("树的最大深度：" + bt.maxDepth());

    }


    @Test
    public void test02() {
        Node creaseTree = createCreaseTree(4);
        System.out.println(creaseTree);
    }

    @Test
    public void test03() {
        List list = new ArrayList();
        list.add("1111");
        List list1 = list;

        System.out.println(list1.get(0));
        list1.add(0, "2222");
        System.out.println(list.get(0));

    }


    public static Node createCreaseTree(int n) {
        Node root = null;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                // 第一次对折，只有一条折痕，创建根节点
                root = new Node("down", null, null);
            } else {
                // 2.如果不是第一次对折，则使用队列保存根结点；
                Queue<Node> queue = new Queue<>();
                queue.enqueue(root);
                // 循环遍历队列
                while (!queue.isEmpty()) {
                    //3.1从队列中拿出一个结点；
                    Node tmp = queue.dequeue();
                    //3.2如果这个结点的左子结点不为空，则把这个左子结点添加到队列中；
                    if (tmp.left != null) {
                        queue.enqueue(tmp.left);
                    }
                    //3.3如果这个结点的右子结点不为空，则把这个右子结点添加到队列中；
                    if (tmp.right != null) {
                        queue.enqueue(tmp.right);
                    }
                    //3.4判断当前结点的左子结点和右子结点都不为空，如果是，则需要为当前结点创建一个值为down的左子结点，一个值为up的右子结点。
                    if (tmp.left == null && tmp.right == null) {
                        tmp.left = new Node("down", null, null);
                        tmp.right = new Node("up", null, null);
                    }
                }
            }
        }
        return root;
    }


    //1.定义结点类
    private static class Node {
        //存储结点元素
        String item;
        //左子结点
        Node left;
        //右子结点
        Node right;

        public Node(String item, Node left, Node right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }

}
