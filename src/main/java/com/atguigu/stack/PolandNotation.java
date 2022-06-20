package com.atguigu.stack;

import java.util.ArrayList;
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
/**        //先定义给逆波兰表达式
 //(3+4)×5-6   =>  3 4 + 5 × 6 -
 //说明为了方便，逆波兰表达式的数字和符号用空格隔开
 //        String suffixExpression = "3 4 + 5 × 6 -";
 String suffixExpression = "30 4 + 5 × 6 -";

 //将内容放到数组中，更方便操作
 List<String> listStrings = getListStrings(suffixExpression);
 int calculate = calculate(listStrings);
 System.out.println(calculate);
 **/
        String expression = "1+((2+3)*4)-5";
        System.out.println("原式子为:" + expression);
        List<String> list = toInfixExpressionList(expression);
        System.out.println("中缀表达式放到list后为：" + list);
        List<String> stringList = parseSuffixExpressionList(list);
        System.out.println("中缀表达式list转后转表达式后为：" + stringList);
        int result = calculate(stringList);
        System.out.println("计算的结果为：" + result);

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
                } else if (str.equals("*")) {
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

    //将中缀表达式转入list，方便后面遍历
    public static List<String> toInfixExpressionList(String s) {
        List<String> ls = new ArrayList<>();
        int i = 0;
        String str;
        char c;
        do {
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {//如果是非数字
                ls.add("" + c);
                i++;
            } else {
                str = "";
                while (i < s.length() && (c = s.charAt(i)) > 48 && ((c = s.charAt(i)) < 57)) {
                    str += c;
                    i++;
                }
                ls.add(str);
            }

        } while (i < s.length());
        return ls;
    }

    //将转成list后的中缀表达式转成后缀表达式
    public static List<String> parseSuffixExpressionList(List<String> ls) {
        //定义两个栈
        Stack<String> s1 = new Stack();//符号栈
//        Stack s2 = new Stack();   //符号栈   但是最后需要反转输出，中途也不需要pop，所以这里使用数组代劳，更方便
        List<String> s2 = new ArrayList<>();
        //遍历
        for (String item : ls) {
            //如果是数，直接加到s2
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {//如果是左括号，直接入符号栈
                s1.push(item);
            } else if (item.equals(")")) {//如果是右括号，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对儿括号去掉
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();//将“(”括号出栈，消除小括号
            } else {
                //当item优先级小于s1栈顶运算符,将s1栈顶的运算符弹出并加入到s2中，再次转到(4.1)与s1中新的栈顶运算符相比较
                //问题：我们缺少一个比较优先级高低的方法
                if (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                //还需要将item压入栈
                s1.push(item);
            }
        }
        //将s1剩余的都依次加到s2
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;
    }
}

//写一个类Operation可以返回一个运算符对应的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String s) {
        int result = 0;
        switch (s) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("您输入的符号有误");
                break;
        }
        return result;
    }
}