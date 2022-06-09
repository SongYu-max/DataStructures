package com.atguigu.linkedlist;

/**
 * @author SongYu
 * @version 1.0.0
 * @ClassName SingleLinkedListDemo.java
 * @Description 模拟单向链表
 * @createTime 2022年06月08日 09:42:00
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //进行测试
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "公孙胜", "入云龙");

        //创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //测试普通加入
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);
        //测试按编号排序加入
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero1);
        //展示
        singleLinkedList.list();
        System.out.println("================");
        HeroNode heroNode = new HeroNode(6, "张三丰", "太极掌门人");
        singleLinkedList.updated(heroNode);
        singleLinkedList.list();
        System.out.println("================");
        HeroNode heroNode2 = new HeroNode(1, "张三丰", "太极掌门人");
//        singleLinkedList.del(2);
//        singleLinkedList.del(1);
//        singleLinkedList.del(4);
//        singleLinkedList.del(3);
        singleLinkedList.list();
        System.out.println("================");
        int length = getLength(singleLinkedList.getHead());
        System.out.println("链表有效节点个数为：" + length);
        System.out.println("================");
        HeroNode node = findLastIndexNode(singleLinkedList.getHead(), 2);
        System.out.println("您所查找的倒数节点为" + node);
        System.out.println("================1");
        reversetList(singleLinkedList.getHead());
        singleLinkedList.list();

    }

    //链表面试题1：获取单链表的有效节点个数（注意不统计头节点）
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        HeroNode temp = head;
        int length = 0;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }
        return length;
    }

    //链表面试题2：查找单链表中的倒数第k个节点【新浪面试题】
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        HeroNode temp = head.next;
        int length = getLength(head);
        if (head.next == null) {
            return null;
        }
        if (index <= 0 || index > length) {
            return null;
        }
        for (int i = 0; i < length - index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    //链表面试题3：单链表的反转【腾讯面试题】
    public static void reversetList(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode reverseHead = new HeroNode(0, "", "");
        HeroNode temp = head.next;
        HeroNode next = null;       //指向当前节temp的下一个节点
        while (temp != null) {
            next = temp.next;       //因为下面第1行会把temp后面的节点改变，当下面第4行再取原temp后面的节点时就取不到了
            temp.next = reverseHead.next;
            reverseHead.next = temp;
            temp = next;
        }
        head.next = reverseHead.next;
    }

    //单个节点
    static class HeroNode {
        public int no;
        public String name;
        public String nickname;
        public HeroNode next;

        public HeroNode(int no, String name, String nickname) {
            this.no = no;
            this.name = name;
            this.nickname = nickname;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickname='" + nickname +
                    '}';
        }
    }

    //管理链表
    static class SingleLinkedList {

        //定义头节点
        private HeroNode head = new HeroNode(0, "", "");

        public HeroNode getHead() {
            return head;
        }

        //添加节点到单向链表
        public void add(HeroNode node) {
            HeroNode temp = head;
            //找到最后一个节点
            while (true) {
                if (temp.next == null) {
                    break;
                }
                temp = temp.next;
            }
            temp.next = node;

        }

        //显示链表[遍历]
        public void list() {
            if (head.next == null) {
                System.out.println("链表为空");
                return;
            }
            //因为头节点不能动，因此我们也需要一个辅助变量来遍历
            HeroNode temp = head.next;
            while (true) {
                //判断是否到链表最后
                if (temp == null) {
                    break;
                }
                System.out.println(temp);
                //将temp后移
                temp = temp.next;
            }
        }

        //第二种方式在添加英雄时，跟据排名将英雄插到指定位置
        public void addByOrder(HeroNode heroNode) {
            HeroNode temp = head;
            boolean flag = false;
            while (true) {
                if (temp.next == null) {
                    break;
                }
                if (temp.no == heroNode.no) {
                    flag = true;
                    break;
                }
                if (temp.next.no > heroNode.no) {
                    break;
                }

                temp = temp.next;
            }
            if (flag) {
                System.out.printf("该序号%d已存在,不能加入\n", heroNode.no);
                return;
            } else {
                heroNode.next = temp.next;
                temp.next = heroNode;
            }

        }

        //修改节点信息，跟据no编号来修改，no编号不能改
        public void updated(HeroNode heroNode) {
            HeroNode temp = head;
            boolean flag = false;
            while (true) {
                if (temp.no == heroNode.no) {
                    break;
                }
                temp = temp.next;
                if (temp.next == null) {
                    break;
                }
            }
            if (flag) {
                System.out.println("该用户不存在");
                return;
            } else {
                temp.name = heroNode.name;
                temp.nickname = heroNode.nickname;
            }
        }

        //删除节点功能
        public void del(int no) {
            HeroNode temp = head;
            boolean flag = false;
            while (true) {
                if (temp.next.no == no) {
                    break;
                }
                if (temp.next == null) {
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (flag) {
                System.out.println("该用户不存在");
                return;
            } else {
                temp.next = temp.next.next;
            }
        }

    }
}
