package com.atguigu.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author SongYu
 * @version 1.0.0
 * @ClassName PolandNotation.java
 * @Description 逆波兰表达式计算器
 * @createTime 2022年06月15日 23:04:00
 */
public class PolandNotation {
    public static void main(String[] args) {
        //先定义给逆波兰表达式
        //(3+4)×5-6   =>  3 4 + 5 × 6 -
        //说明为了方便，逆波兰表达式的数字和符号用空格隔开
//        String suffixExpression = "3 4 + 5 × 6 -";
        String suffixExpression = "30 4 + 5 × 6 -";

        //将内容放到数组中，更方便操作
        List<String> listStrings = getListStrings(suffixExpression);
        int calculate = calculate(listStrings);
        System.out.println(calculate);

    }

    public static List<String> getListStrings(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        List<String> stringList = Arrays.asList(split);
        return stringList;
    }

    public static int calculate(List<String> stringList) {
        Stack<String> stack = new Stack<String>();
        for (String str : stringList) {
            if (str.matches("\\d+")) {
                stack.push(str);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (str.equals("+")) {
                    res = num1 + num2;
                } else if (str.equals("-")) {
                    res = num1 - num2;
                } else if (str.equals("×")) {
                    res = num1 * num2;
                } else if (str.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                //把结果res 入栈
                stack.push("" + res);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
