package com.it.time.test;

import com.it.api.Stack;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.lang.model.element.VariableElement;

/**
 * @author LY
 * @PackageName:com.it.time.test
 * @ClassName:StackTest
 * @date 2021/5/26 10:33
 * 类说明: <br>
 */
@SpringBootTest
public class StackTest {


    @Test
    public void test01() {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");

        for (String string : stack) {
            System.out.print(string + " ");
        }
        System.out.println();
        System.out.println("--------------------------");
        String pop = stack.pop();
        System.out.println("弹出的元素: " + pop);
        System.out.println(stack.size());
    }


    @Test
    public void test02() {
        String str = "((上海(长安)))";
        boolean matcher = isMatch(str);
        System.out.println(str + "中的括号是否匹配：" + matcher);
    }

    private boolean isMatch(String str) {
        Stack<String> stack = new Stack<>();
        String[] split = str.split("");
        for (String s : split) {
            if (s.equals("(")) {
                stack.push(s);
            } else if (s.equals(")")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void test03() {
        String str = "(上海(长安))";
        String[] split = str.split("");
        for (String s : split) {
            System.out.println(s);
        }
//        System.out.println(bytes);
    }

    @Test
    public void test04(){
        String[] notations = {"3","17","15","-","*","18","6","/","+"};
        int result = caculate(notations);
        System.out.println(result);
    }

    private int caculate(String[] notations) {
        Stack<String> stack = new Stack<>();
        for (String s : notations) {
           if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
               String per = stack.pop();
               String next = stack.pop();
               int arithmetic = arithmetic(s, Integer.parseInt(next), Integer.parseInt(per));
               stack.push(""+arithmetic);
           } else {
               stack.push(s);
           }
        }
        return Integer.parseInt(stack.pop());
    }

    private int arithmetic(String expression,int a,int b){
        int result = 0;
        switch (expression){
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                break;
        }
        return result;
    }
}
