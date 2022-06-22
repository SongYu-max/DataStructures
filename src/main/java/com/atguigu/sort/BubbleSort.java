package com.atguigu.sort;

/**
 * @author SongYu
 * @version 1.0.0
 * @ClassName BubbleSort2.java
 * @Description 韩顺平的冒泡排序
 * @createTime 2022年06月23日 00:03:00
 */
public class BubbleSort {
    static int count = 0;

    public static void main(String[] args) {
//        int[] arr = {5, 4, 3, 2, 1};
//        int[] arr = {3, 2, 1, 4, 5, 6};
//        int[] arr = {1, 2, 3, 4, 5};
        int[] arr = {1, 2, 3, 4, 5, 6};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("次数为" + count);
    }

    public static void sort(int[] arr) {
        int tem = 0;
        boolean flag = false;
        for (int i = 0; i < (arr.length - 1); i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                count++;
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    tem = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tem;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }
}
