package com.it.time.test;

import com.it.api.Queue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author LY
 * @PackageName:com.it.time.test
 * @ClassName:QueueTest
 * @date 2021/5/26 14:00
 * 类说明: <br>
 */
@SpringBootTest
public class QueueTest {

    @Test
    public void test01(){
        Queue<String> queue = new Queue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");
        queue.enqueue("f");
        for (String str : queue){
            System.out.print(str+" ");
        }
        System.out.println();
        String dequeue = queue.dequeue();
        System.out.println("出列元素："+dequeue);
        System.out.println(queue.size());
    }
}
