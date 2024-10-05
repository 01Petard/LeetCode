package com.hzx.Algorithm.排序算法;

public class swap {
    /**
     * 交换数组R中索引i和j的元素
     * @param R 待排序数组
     * @param i 索引i
     * @param j 索引j
     */
    static void swap(int[] R, int i, int j) {
        int temp = R[i];
        R[i] = R[j];
        R[j] = temp;
    }
}
