package com.atguigu.recursion;

/**
 * @author SongYu
 * @version 1.0.0
 * @ClassName Queue8.java
 * @Description 八皇后问题-暴力递归解法
 * @createTime 2022年06月21日 23:38:00
 */
public class Queen8 {
    //定义共几个皇后
    int max = 8;
    //定义一个数组来存放结果（数组下标代表行，数组的每个值代表列）
    int[] arr = new int[max];
    //定义一个变量记录8皇后问题解法总数
    static int resCount = 0;
    //运算次数
    static int calCount = 0;

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.printf("一共有%d解法", resCount);
        System.out.printf("一共运算%d次", calCount);
    }

    //打印结果的方法
    private void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
        resCount++;
        System.out.println();
    }

    //放置棋子
    private void check(int n) {
        if (n == max) {
            print();
            return;
        }
        //依次放入皇后,并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后n放在该行的第1列
            arr[n] = i;
            //判断当放置第n个皇后到i列时，是否冲突
            if (judge(n)) {//不冲突
                check(n + 1);
            }
            calCount++;
        }
    }

    //检查当前棋子有没有和前面的棋子冲突
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

}
