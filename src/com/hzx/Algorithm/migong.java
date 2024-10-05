package com.hzx.Algorithm;


/**
 * 走迷宫算法
 */
public class migong {

    public static void main(String[] args) {

        int row = 8; //行数

        int col = 7; // 列数

        final int WALL = 1;

        int[][] migong = new int[row][col];

        //设置墙
        for (int i = 0; i < row; i++) {
            migong[i][0] = WALL;
            migong[i][col - 1] = WALL;
        }
        for (int j = 0; j < col; j++) {
            migong[0][j] = WALL;
            migong[row - 1][j] = WALL;
        }

        //设置地图内部的墙
        migong[3][1] = WALL;
        migong[3][2] = WALL;
        migong[4][4] = WALL;
        migong[5][3] = WALL;
        migong[5][4] = WALL;


        //查看地图
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(migong[i][j] + "  ");
            }
            System.out.println();
        }


        boolean flag = findWay(migong, 1, 1, 6, 5);
        System.out.println(flag);

        //查看地图
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(migong[i][j] + "  ");
            }
            System.out.println();
        }
    }

    /**
     * 使用递归回溯找路
     * @param migong 地图,0表示没走过,1表示墙,2表示通路可以走,3表示已经走过但是走不通
     *               走迷宫的策略为: 下 -> 右 -> 上 -> 左,如果走不通,再回溯
     * @param i      起点的x坐标
     * @param j      起点的y坐标
     * @param end_i  终点的x坐标
     * @param end_j  终点的x坐标
     * @return 是否找到了路
     */
    public static boolean findWay(int[][] migong, int i, int j, int end_i, int end_j) {
        if (migong[end_i][end_j] == 2) {  //通路已经找到
            return true;
        } else {
            if (migong[i][j] == 0) { //如果还没找到
                //假定该点可以走
                migong[i][j] = 2;
                if (findWay(migong, i + 1, j, end_i, end_j)) {         //向下走
                    return true;
                } else if (findWay(migong, i, j + 1, end_i, end_j)) {  //向右走
                    return true;
                } else if (findWay(migong, i - 1, j, end_i, end_j)) {  //向上走
                    return true;
                } else if (findWay(migong, i, j - 1, end_i, end_j)) {  //向左走
                    return true;
                } else {  //该点走不通,是死路
                    migong[i][j] = 3;
                    return false;
                }
            } else {  //如果migong[i][j] != 0,可能是1,2,3
                return false;
            }
        }
    }


}
