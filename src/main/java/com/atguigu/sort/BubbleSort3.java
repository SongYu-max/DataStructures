package com.atguigu.sort;

/**
 * @author SongYu
 * @version 1.0.0
 * @ClassName BubbleSort.java
 * @Description 冒泡排序  //todo 好像写的不是冒泡排序   (lll￢ω￢)  果然不是，后续看看我这是什么排序
 * @createTime 2022年06月22日 23:17:00
 */
public class BubbleSort3 {
    public static void main(String[] args) {
//        int[] arr = {3, 2, 1, 4, 5};
        int[] arr = {5,4,3,2,1};
        sort(arr);
        System.out.println("排序后：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void sort(int[] arr) {
        int tem = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    tem = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tem;
                }
            }
        }

    }

}
