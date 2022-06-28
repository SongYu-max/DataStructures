package com.atguigu.sort;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

/**
 * @author SongYu
 * @version 1.0.0
 * @ClassName InsertSort.java
 * @Description 插入排序
 * @createTime 2022年06月24日 10:06:00
 */
public class InsertSort {
    public static void main(String[] args) {
//        int[] arr = {5, 4, 7, 3, 8, 6};
//        sort(arr);
        int[] arr2 = new int[80000];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] =(int)(Math.random() * 80000);
        }
        LocalTime start = LocalTime.now();
        sort(arr2);
        LocalTime end = LocalTime.now();
        Duration duration = Duration.between(start, end);
        System.out.println(duration);
    }

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int index = i - 1;
            int value = arr[i];
            while (index >= 0 && value < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = value;
//            System.out.println("第" + i + "轮插入");
//            System.out.println(Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));
    }
}
