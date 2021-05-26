package com.it.time.test;

import com.it.api.BinaryTree;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
    public void test01(){
        BinaryTree<Integer,String> bt = new BinaryTree<>();
        bt.put(2,"aa");
        bt.put(1,"dd");
        bt.put(6,"bb");
        bt.put(5,"ff");
        bt.put(3,"ee");
        bt.put(9,"ss");
        bt.put(7,"ww");
        System.out.println(bt.size());
        bt.put(1,"cc");
        System.out.println(bt.size());
        System.out.println(bt.get(1));
        System.out.println(bt.size());
        bt.delete(1);
        bt.delete(5);
        System.out.println(bt.size());
        System.out.println(bt.getMax());
        System.out.println(bt.getMin());
    }
}
