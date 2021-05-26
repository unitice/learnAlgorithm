package com.it.time.test;

import com.it.api.OrderSymbolTable;
import com.it.api.SymbolTable;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;

import java.util.Map;

/**
 * @author LY
 * @PackageName:com.it.time.test
 * @ClassName:SymbolTableTest
 * @date 2021/5/26 14:33
 * 类说明: <br>
 */
@SpringBootTest
public class SymbolTableTest {


    @Test
    public void test01(){
        SymbolTable<Integer,String> symbolTable = new SymbolTable<>();
        symbolTable.put(1,"小米");
        symbolTable.put(2,"小张");
        symbolTable.put(3,"小红");
        symbolTable.put(4,"小蓝");
        symbolTable.put(5,"小绿");
        System.out.println(symbolTable.size());
        symbolTable.put(1,"飞翔");
        System.out.println(symbolTable.get(1));
        System.out.println(symbolTable.size());
        symbolTable.delete(1);
        System.out.println(symbolTable.size());
        for (Map map : symbolTable){
            System.out.println(map);
        }
    }

    @Test
    public void test02(){
        OrderSymbolTable<Integer,String> bt = new OrderSymbolTable<>();
        bt.put(4,"呵呵");
        bt.put(1,"嗯嗯");
        bt.put(3,"哇哇");
        bt.put(2,"图腾");
        bt.put(5,"格格");

        for (Map map : bt){
            System.out.println(map);
        }

    }

    @Test
    public void test03(){
        String version = SpringVersion.getVersion();
        String version1 = SpringBootVersion.getVersion();
        System.out.println(version);
        System.out.println(version1);
    }
}
