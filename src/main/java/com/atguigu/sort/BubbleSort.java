package com.atguigu.sort;

/**
 * @author SongYu
 * @version 1.0.0
 * @ClassName BubbleSort2.java
 * @Description 韩顺平的冒泡排序
 * @createTime 2022年06月23日 00:03:00
 */
public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr = {5, 4, 3, 2, 1};
        int[] arr = {3, 2, 1, 4, 5};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void sort(int[] arr) {
        int tem = 0;
        for (int i = 0; i < (arr.length - 1); i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    tem = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tem;
                }
            }
        }
    }
}
