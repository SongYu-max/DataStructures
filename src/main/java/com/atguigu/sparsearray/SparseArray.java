package com.atguigu.sparsearray;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @author SongYu
 * @version 1.0.0
 * @ClassName SparseArray.java
 * @Description 稀疏数组       棋盘问题
 * @createTime 2022年06月06日 10:00:00
 */
public class SparseArray {
    public static void main(String[] args) throws IOException {
        //创建一个原始的二维数组  11*11
        //0表示没有棋子，1表示黑子，2表示蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //输出原始的二维数组
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        //将二维数组 转 稀疏数组
        //1.先遍历二维数组，得到非0的数据的个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        //2.创建对应的稀疏数组
        //给稀疏数组赋值
        int sparseArr1[][] = new int[sum + 1][3];
        sparseArr1[0][0] = chessArr1.length;
        sparseArr1[0][1] = chessArr1[1].length;
        sparseArr1[0][2] = sum;
        int count = 0; //用于记录是第几个非O
        //遍历二维数组，将非0的值存放到稀疏数组中
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr1[count][0] = i;
                    sparseArr1[count][1] = j;
                    sparseArr1[count][2] = chessArr1[i][j];
                }
            }
        }
        System.out.println();
        System.out.println("得到的稀疏数组为:");
        for (int[] arr : sparseArr1) {
            for (int data : arr) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //将稀疏数组恢复成原始数组
        int chessArr2[][] = new int[sparseArr1[0][0]][sparseArr1[0][1]];
        for (int i = 0; i < sparseArr1.length - 1; i++) {
//            int m = sparseArr1[i+1][0];
//            int n = sparseArr1[i+1][1];
//            int value = sparseArr1[i+1][2];
//            chessArr2[m][n] = value;
            chessArr2[sparseArr1[i + 1][0]][sparseArr1[i + 1][1]] = sparseArr1[i + 1][2];
        }
        System.out.println("还原的原始数组:");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        File f = new File("D:\\songyu\\test\\out.txt");
        f.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(f);
        PrintStream printStream = new PrintStream(fileOutputStream);
        System.setOut(printStream);
//        System.out.println("666");
        System.out.println("还原的原始数组:");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
