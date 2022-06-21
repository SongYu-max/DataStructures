package com.atguigu.recursion;

/**
 * @author SongYu
 * @version 1.0.0
 * @ClassName MiGong.java
 * @Description 递归迷宫问题--小球找路
 * @createTime 2022年06月21日 16:37:00
 */
public class MiGong {
    public static void main(String[] args) {
        //先定义地图，用二维数组表示
        int[][] map = new int[8][7];
        //使用1表示墙和挡板
        //设置上下横墙设置左右竖墙
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置上下横墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        map[3][3] = 1;
        map[3][4] = 1;
        //看一下迷宫地图效果
        for (int i = 0; i < map.length; i++) {
            for (int i1 = 0; i1 < map[0].length; i1++) {
                System.out.printf(map[i][i1] + " ");
            }
            System.out.println();
        }
        //递归找路
        setWay(map, 1, 1);
        System.out.println("看结果");
        //看结果
        for (int i = 0; i < map.length; i++) {
            for (int i1 = 0; i1 < map[0].length; i1++) {
                System.out.printf(map[i][i1] + " ");
            }
            System.out.println();
        }
    }

    //使用递归回溯来给小球找路

    /**
     * @param map 地图
     * @param i   和 j 共同构成了起点位置
     * @return 如果找到通路，就返回true，否则false
     * 额外说明：
     * 1.终点：如果小球能到map[6][5]位置，则说明通路找到
     * 2.约定：当map[i][j]为0表示该点没有走过，当为1表示墙，2表示通路可以走,3表示该位置已经走过，但是走不通
     * 3.在走迷宫时，需要确定一个策略（方法）下->右->上->左
     */

    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }


    }
}
