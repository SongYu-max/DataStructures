package com.atguigu.linkedlist;

import java.util.Stack;

/**
 * @author SongYu
 * @version 1.0.0
 * @ClassName SingleLinkedListDemo.java
 * @Description 模拟双向链表
 * @createTime 2022年06月08日 09:42:00
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        //进行测试
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "公孙胜", "入云龙");
        HeroNode2 hero5 = new HeroNode2(5, "关胜", "大刀");
        HeroNode2 hero6 = new HeroNode2(6, "林冲", "豹子头");

        //创建要给链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
//        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
//        singleLinkedList2.addByOrder(hero3);
//        singleLinkedList2.addByOrder(hero2);
//        singleLinkedList2.addByOrder(hero5);
//        singleLinkedList2.addByOrder(hero6);


        //测试普通加入
//        doubleLinkedList.add(hero1);
//        doubleLinkedList.add(hero2);
//        doubleLinkedList.add(hero3);
//        doubleLinkedList.add(hero4);
        //测试按编号排序加入
        doubleLinkedList.add(hero4);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero1);
        //展示
        System.out.println("================初次展示");
        doubleLinkedList.list();
        System.out.println("================测试更新");
        HeroNode2 heroNode = new HeroNode2(2, "张三丰", "太极掌门人");
        doubleLinkedList.updated(heroNode);
        doubleLinkedList.list();
        System.out.println("================测试删除");
//        doubleLinkedList.del(2);
//        doubleLinkedList.del(1);
//        doubleLinkedList.del(4);
        doubleLinkedList.del(2);
        doubleLinkedList.list();
        System.out.println("================");
        int length = getLength(doubleLinkedList.getHead());
        System.out.println("链表有效节点个数为：" + length);
        System.out.println("================");
        HeroNode2 node = findLastIndexNode(doubleLinkedList.getHead(), 2);
        System.out.println("您所查找的倒数节点为" + node);
        System.out.println("================反转链表");
        reversetList(doubleLinkedList.getHead());
        doubleLinkedList.list();
        System.out.println("================反转打印");
        backPrintByStack(doubleLinkedList.getHead());
        System.out.println("================合并两个链表");
        //先把上面反转的链表1再反转回去
        reversetList(doubleLinkedList.getHead());
        System.out.println("================链表1：");
        doubleLinkedList.list();
        System.out.println("================链表2：");
//        singleLinkedList2.list();
        System.out.println("================合并两个链表");
//        mergeLinkedList(singleLinkedList.getHead(), singleLinkedList2.getHead());
//        singleLinkedList.list();

    }

    //链表面试题1：获取单链表的有效节点个数（注意不统计头节点）
    public static int getLength(HeroNode2 head) {
        if (head.next == null) {
            return 0;
        }
        HeroNode2 temp = head;
        int length = 0;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }
        return length;
    }

    //链表面试题2：查找单链表中的倒数第k个节点【新浪面试题】
    public static HeroNode2 findLastIndexNode(HeroNode2 head, int index) {
        HeroNode2 temp = head.next;
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
    public static void reversetList(HeroNode2 head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode2 reverseHead = new HeroNode2(0, "", "");
        HeroNode2 temp = head.next;
        HeroNode2 next = null;       //指向当前节temp的下一个节点
        while (temp != null) {
            next = temp.next;       //因为下面第1行会把temp后面的节点改变，当下面第4行再取原temp后面的节点时就取不到了
            temp.next = reverseHead.next;
            reverseHead.next = temp;
            temp = next;
        }
        head.next = reverseHead.next;
    }

    //链表面试题4：从尾到头打印单链表【百度面试题，要求方式：1.反向遍历。方式2：Stack栈】
    //方式1：反向遍历，就是利用上面的reverseList方法将数组反转，缺点是遍历打印完，原链表的顺序也逆转了
    //方式2：
    public static void backPrintByStack(HeroNode2 head) {
        Stack<HeroNode2> stack = new Stack<HeroNode2>();
        HeroNode2 temp = head.next;
        if (temp == null) {
            System.out.println("链表为空，无法打印");
        } else if (temp.next == null) {
            System.out.println(temp);
            return;
        }
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int stackLength = stack.size();
        for (int i = 0; i < stackLength; i++) {
            String s = stack.pop().toString();
            System.out.println(s);
        }
    }

    //链表面试题5：合并两个有序的单链表，合并之后的链表依然有序(和并到链表1并返回)
    public static void mergeLinkedList(HeroNode2 left, HeroNode2 right) {
        if (left.next == null && right.next == null) {
            System.out.println("链表不能都为空");
            return;
        }
        HeroNode2 cur1 = left;
        HeroNode2 cur2 = right.next;
        HeroNode2 t1 = null;
        HeroNode2 t2 = null;

        while (cur1 != null) {
            while (cur2 != null) {
                t1 = cur2.next;
                if (cur1.next != null && cur2.no < cur1.next.no) {
                    t2 = cur1.next;
                    cur1.next = cur2;
                    cur2.next = t2;
                } else if (cur1.next != null && cur2.no > cur1.next.no) {
                    break;
                } else {
                    cur1.next = cur2;
                }
                cur2 = t1;
            }
            cur1 = cur1.next;
        }
    }


    //单个节点
    static class HeroNode2 {
        public int no;
        public String name;
        public String nickname;
        public HeroNode2 next;
        public HeroNode2 pre;

        public HeroNode2(int no, String name, String nickname) {
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
    static class DoubleLinkedList {

        //定义头节点
        private HeroNode2 head = new HeroNode2(0, "", "");

        public HeroNode2 getHead() {
            return head;
        }

        //添加节点到双向链表
        public void add(HeroNode2 node) {
            HeroNode2 temp = head;
            //找到最后一个节点
            while (true) {
                if (temp.next == null) {
                    break;
                }
                temp = temp.next;
            }
            temp.next = node;
            node.pre = temp;

        }

        //显示链表[遍历]
        public void list() {
            if (head.next == null) {
                System.out.println("链表为空");
                return;
            }
            //因为头节点不能动，因此我们也需要一个辅助变量来遍历
            HeroNode2 temp = head.next;
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
        public void addByOrder(HeroNode2 heroNode) {
            HeroNode2 temp = head.next;
            boolean flag = false;
            while (true) {
                if (temp == null) {
                    break;
                }
                if (temp.no == heroNode.no) {
                    flag = true;
                    break;
                }
                if (temp.no > heroNode.no) {
                    break;
                }
                temp = temp.next;
            }
            if (flag) {
                System.out.printf("该序号%d已存在,不能加入\n", heroNode.no);
                return;
            } else {
                heroNode.next = temp.next;
                temp.next.pre = heroNode;
                heroNode.pre = temp;
                temp.next = heroNode;
            }

        }

        //修改节点信息，跟据no编号来修改，no编号不能改
        public void updated(HeroNode2 heroNode) {
            HeroNode2 temp = head;
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
            //判断当前链表是否为空
            if (head.next == null) {
                return;
            }
            HeroNode2 temp = head.next;
            boolean flag = false;
            while (true) {
                if (temp.no == no) {
                    flag = true;
                    break;
                }
                if (temp == null) {
                    break;
                }
                temp = temp.next;
            }
            if (flag) {
                temp.pre.next = temp.next;
                //如果是最后一个节点，就不需要执行下面这句话，否则会出现空指针异常
                if (temp.next != null) {
                    temp.next.pre = temp.pre;
                }
            } else {
                System.out.println("该用户不存在");
                return;
            }
        }

    }
}
