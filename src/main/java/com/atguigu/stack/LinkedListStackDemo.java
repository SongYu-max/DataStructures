package com.atguigu.stack;

import java.util.Scanner;

/**
 * @author SongYu
 * @version 1.0.0
 * @ClassName LinkedListStackDemo.java
 * @Description 链表模拟栈
 * @createTime 2022年06月14日 16:44:00
 */
public class LinkedListStackDemo {
    public static void main(String[] args) {
        LinkedListStack linkedListStack = new LinkedListStack(5);
        //链表测试
//        Student student1 = new Student(1);
//        Student student2 = new Student(2);
//        Student student3 = new Student(3);
//        Student student4 = new Student(4);
//        Student student5 = new Student(5);
//        linkedListStack.add(student1);
//        linkedListStack.add(student2);
//        linkedListStack.add(student3);
//        linkedListStack.add(student4);
//        linkedListStack.add(student5);
//        linkedListStack.list();
        //链表实现栈测试
//        linkedListStack.push(2);
//        linkedListStack.push(4);
//        linkedListStack.push(6);
//        linkedListStack.push(8);

        String key = "";
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("show:显示栈");
            System.out.println("exit:退出");
            System.out.println("push:添加数据到栈（入栈）");
            System.out.println("pop:从栈取出数据（出栈）");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key) {
                case "show":
//                    linkedListStack.list();
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                case "push":
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    linkedListStack.push(value);
                    break;
                case "pop":
                    try {
                        int res = linkedListStack.pop();
                        System.out.println("取出的数据是:" + res);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        }


    }
}

class LinkedListStack {
    //链表代码
//    Student head = new Student(0);
//
//    public void add(Student student) {
//        Student temp = head;
//        while (true) {
//            if (temp.getNext() == null) {
//                break;
//            }
//            temp = temp.getNext();
//        }
//        temp.setNext(student);
//    }
//
//    public void list() {
//        Student temp = head.getNext();
//        while (true) {
//            if (temp == null) {
//                break;
//            }
//            System.out.println(temp);
//            temp = temp.getNext();
//        }
//    }
    //模拟栈
    private int maxSize;
    private int top = -1;
    private Student head = new Student(0);

    //入栈
    public void push(int no) {
        Student temp = head;
        if (top == maxSize - 1) {
            throw new RuntimeException("栈满");
        }
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
        }
        top++;
        temp.setNext(new Student(no));
    }

    //出栈
    public int pop() {
        Student temp = head;
        if (top == -1) {
            throw new RuntimeException("栈空");
        }
        while (true) {
            if (temp.getNext().getNext() == null) {
                break;
            }
            temp = temp.getNext();
        }
        int value = temp.getNext().getId();
        top--;
        temp.setNext(null);
        return value;
    }

    public LinkedListStack(int maxSize) {
        this.maxSize = maxSize;
    }
}

class Student {
    private int id;
    private Student next;

    public Student(int id) {
        this.id = id;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getNext() {
        return next;
    }

    public void setNext(Student next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }
}

