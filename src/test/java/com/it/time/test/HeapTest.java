package com.it.time.test;

import com.it.api.Heap;
import com.it.api.HeapSort;
import com.it.api.MaxPriorityQueue;
import com.it.api.MinPriorityQueue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * @author LY
 * @PackageName:com.it.time.test
 * @ClassName:HeapTest
 * @date 2021/5/31 10:43
 * 类说明: <br>
 */
@SpringBootTest
public class HeapTest {

    @Test
    public void test01(){
        Heap<String> heap = new Heap<>(20);
        heap.insert("S");
        heap.insert("G");
        heap.insert("I");
        heap.insert("E");
        heap.insert("N");
        heap.insert("H");
        heap.insert("O");
        heap.insert("A");
        heap.insert("T");
        heap.insert("P");
        heap.insert("R");
        String del;
        while ((del = heap.delMax()) != null) {
            System.out.print(del+",");
        }
    }

    @Test
    public void test02(){
        String[] arr = {"S","O","R","T","E","X","A","M","P","L","E"};
        HeapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test03(){
        String[] arr = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        MaxPriorityQueue<String> maxpq = new MaxPriorityQueue<>(20);
        for (String s : arr){
            maxpq.insert(s);
        }
        String del;
        while (!maxpq.isEmpty()){
            del = maxpq.delMax();
            System.out.print(del+",");
        }
    }

    @Test
    public void test04(){
        String[] arr = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        MinPriorityQueue<String> minpq = new MinPriorityQueue<>(20);
        for (String s : arr){
            minpq.insert(s);
        }
        System.out.println(minpq.size());
        String del;
        while (!minpq.isEmpty()){
            del = minpq.delMin();
            System.out.print(del+",");
        }
    }
}
