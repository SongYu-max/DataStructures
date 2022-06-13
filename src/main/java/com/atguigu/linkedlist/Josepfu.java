package com.atguigu.linkedlist;

/**
 * @author SongYu
 * @version 1.0.0
 * @ClassName Josepfu.java
 * @Description 约瑟夫、单向环形链表
 * @createTime 2022年06月13日 10:13:00
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();
    }

}

//创建一个环形的单向链表
class CircleSingleLinkedList {
    //创建一个first节点
    private Boy first = null;

    public Boy getFirst() {
        return first;
    }

    //添加小孩节点，构建一个环形的链表
    public void addBoy(int nums) {
        if ((nums < 1)) {
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null;//辅助指针
        for (int i = 0; i < nums; i++) {
            Boy boy = new Boy(i);
            if (i == 0) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    public void showBoy() {
        if (first == null) {
            System.out.println("没有任何小孩~");
            return;
        }
        Boy tem = first;
        while (true) {
            System.out.println(tem);
            if (tem.getNext() == first) {
                break;
            }
            tem = tem.getNext();
        }

    }

    /**
     * 产生一个出圈的顺序
     *
     * @param startNo  表示从第几个小孩开始
     * @param countNum 表示数几下
     * @param nums     表示最初有几个小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        //先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums || countNum < 1) {
            System.out.println("参数输入有误，请重新输入~");
            return;
        }
        Boy helper = first;
        while (true) {
            if ((helper.getNext() == first)) {
                break;
            }
            helper = helper.getNext();
        }
    }
}

//创建一个BOY类，表示一个节点
class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}
