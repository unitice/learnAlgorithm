package com.it.time.test;

import com.it.api.DepthFirstSearch;
import com.it.api.Graph;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author LY
 * @PackageName:com.it.time.test
 * @ClassName:GraphTest
 * @date 2021/6/1 10:28
 * 类说明: <br>
 */
@SpringBootTest
public class GraphTest {

    @Test
    public void test01() throws IOException {
        //创建输入流
        BufferedReader reader = new BufferedReader(new
                InputStreamReader(GraphTest.class.getClassLoader().getResourceAsStream("traffic_proje ct.txt")));
        //读取城市数目，初始化Graph图
        int number = Integer.parseInt(reader.readLine());
        Graph G = new Graph(number);
        //读取已经修建好的道路数目
        int roadNumber = Integer.parseInt(reader.readLine());
        //循环读取已经修建好的道路，并调用addEdge方法
        for (int i = 0; i < roadNumber; i++) {
            String line = reader.readLine();
            int p = Integer.parseInt(line.split(" ")[0]);
            int q = Integer.parseInt(line.split(" ")[1]);
            G.addEdge(p, q);
            //根据图G和顶点9构建图的搜索对象
            // BreadthFirstSearch search = new BreadthFirstSearch(G,9);
            DepthFirstSearch search = new DepthFirstSearch(G, 9);
            //调用搜索对象的marked(10)方法和marked(8)方法
            boolean flag1 = search.marked(10);
            boolean flag2 = search.marked(8);
            System.out.println("9号城市和10号城市是否已相通：" + flag1);
            System.out.println("9号城市和8号城市是否已相通：" + flag2);

        }
    }
}
