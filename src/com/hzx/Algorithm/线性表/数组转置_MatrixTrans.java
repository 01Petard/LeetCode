package com.hzx.Algorithm.线性表;

/**
 * 将一个矩阵（数组）转置
 */
public class 数组转置_MatrixTrans {

    private static int[][] trans(int[][] arr) {
        int[][] arrtrans = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arrtrans[j][i] = arr[i][j];
            }
        }
        return arrtrans;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{4, 5, 6}, {2, 3, 9}, {1, 2, 3}, {11, 22, 33}};
        int[][] arrtrans = trans(arr);
        for (int[] arrtran : arrtrans) {
            for (int i : arrtran) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

//        for (int[] arrtran : arrtrans) {
//            for (int j = 0; j < arrtrans[0].length; j++) {
//                System.out.print(arrtran[j] + " ");
//            }
//            System.out.println();
//        }
    }


}
