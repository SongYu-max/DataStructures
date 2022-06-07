package com.atguigu.queue;

import java.util.Scanner;

/**
 * @author SongYu
 * @version 1.0.0
 * @ClassName ArrayQueueDemo.java
 * @Description 基于数组的环形数组队列
 * @createTime 2022年06月07日 09:31:00
 */
public class CircleArrayQueueDemo {

    public static void main(String[] args) {
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(3);
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):显示队列头部");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    circleArrayQueue.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    circleArrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = circleArrayQueue.getQueue();
                        System.out.println("取出的数据是:" + res);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    try {
                        circleArrayQueue.showHead();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");

    }

    //使用数组模拟队列
    static class CircleArrayQueue {
        private int maxSize;    //最大容量
        private int front;      //队列头
        private int rear;       //队列尾
        private int[] arr;      //存放数据，模拟队列

        //队列的构造器
        public CircleArrayQueue(int arrMaxSize) {
            maxSize = arrMaxSize;
            arr = new int[arrMaxSize];
            front = 0;     //指向队列头，队列头前的一个位置
            rear = 0;      //指向队列尾，队列尾所在的位置
        }

        //判断是否满
        public boolean isFull() {
            return (rear + 1) % maxSize == front;
        }

        //判断是否空
        public boolean isEmpty() {
            return front == rear;
        }

        //加数据的方法
        public void addQueue(int n) {
            if (isFull()) {
                System.out.println("队列满了，加不进来了！");
                return;
            }
            arr[rear] = n;
            //将rear后移
            rear = (rear + 1) % maxSize;
        }

        //获取队列数据，出队列
        public int getQueue() {
            if (isEmpty()) {
                System.out.println("队列为空，你取不到的！");
                throw new RuntimeException("队列为空，你取不到的！");
            }
            //这里需要分析出front是指向队列的第一个元素
            //1.先把front对应的值保留到一个临时变量中
            //2.将front后移
            //3.将临时保存的变量返回
            int value = arr[front];
            front = (front + 1) % maxSize;
            return value;
        }

        //显示队列所有数据
        public void showQueue() {
            if (isEmpty()) {
                System.out.println("队列为空，你取不到的！");
                return;
            }
            //思路：从front开始遍历，遍历多少个元素
            for (int i = front; i < front + ((rear + maxSize - front) % maxSize); i++) {
                System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
            }
        }

        //显示队列的头，不是取出
        public void showHead() {
            if (isEmpty()) {
                System.out.println("队列为空，你取不到的！");
                throw new RuntimeException("队列为空，你取不到的！");
            }
            System.out.println(arr[front]);
        }

    }


}
