package com.atguigu.sort;

/**
 * @author SongYu
 * @version 1.0.0
 * @ClassName SelectSort.java
 * @Description TODO
 * @createTime 2022年06月23日 16:05:00
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 6, 2, 1};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static void sort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int minValue = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (minValue>arr[j]){
                    minValue=arr[j];
                    minIndex = j;
                }
            }
            if (minIndex!=i){
                arr[minIndex] = arr[i];
                arr[i] = minValue;
            }
        }
    }
}
