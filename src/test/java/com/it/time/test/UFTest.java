package com.it.time.test;

import com.it.api.UF;
import com.it.api.UFTreeWeighted;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.Scanner;

/**
 * @author LY
 * @PackageName:com.it.time.test
 * @ClassName:UFTest
 * @date 2021/5/31 18:00
 * 类说明: <br>
 */
@SpringBootTest
public class UFTest {

    @Test
    public void test01(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请录入并查集中元素的个数:");
        int N = sc.nextInt();
        UF uf = new UF(N);
        while(true) {
            System.out.println("请录入您要合并的第一个点:");
            int p = sc.nextInt();
            System.out.println("请录入您要合并的第二个点:");
            int q = sc.nextInt();
            //判断p和q是否在同一个组
            if (uf.connected(p,q)){
                System.out.println("结点："+p+"结点"+q+"已经在同一个组");
                continue;
            }
            uf.union(p,q);
            System.out.println("总共还有"+uf.count()+"个分组");
        }
    }

    @Test
    public void test03() throws IOException {
        //创建输入流
        BufferedReader reader = new BufferedReader(new
                InputStreamReader(UFTest.class.getClassLoader().getResourceAsStream("traffic_projec t.txt")));
//读取城市数目，初始化并查集
        int number = Integer.parseInt(reader.readLine());
        UFTreeWeighted uf = new UFTreeWeighted(number);
//读取已经修建好的道路数目
        int roadNumber = Integer.parseInt(reader.readLine());
//循环读取已经修建好的道路，并调用union方法
        for (int i = 0; i < roadNumber; i++) {
            String line = reader.readLine();
            int p = Integer.parseInt(line.split(" ")[0]);
            int q = Integer.parseInt(line.split(" ")[1]);
            uf.union(p,q);
        }
//获取剩余的分组数量
        int groupNumber = uf.count();
//计算出还需要修建的道路
        System.out.println("还需要修建"+(groupNumber-1)+"道路，城市才能相通");
    }
}
