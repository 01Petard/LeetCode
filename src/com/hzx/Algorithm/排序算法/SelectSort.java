package com.hzx.Algorithm.排序算法;

public class SelectSort extends swap {
    /**
     * 选择排序
     * @param R 待排序数组
     */
    public static void SelectSort(int[] R) {
        int i, j, k, temp;
        for (i = 0; i < R.length; i++) {
            k = i;
            for (j = i + 1; j < R.length; j++) {
                if (R[j] < R[k]) {
                    k = j;
                }
            }
            swap(R, i, k);
        }
    }

    /**
     * 选择排序（优化版）
     * 优化操作：
     * 1、减少交换次数：当前实现中，每次在内部循环中找到最小值后，都会进行一次交换。可以优化为只在外部循环结束时进行一次交换。
     * 2、减少比较次数：内部循环中，可以避免对已排序部分的元素进行比较。
     * @param R 待排序数组
     */
    public static void SelectSort_optimized(int[] R) {
        int i, j, k, temp;
        for (i = 0; i < R.length - 1; i++) {
            k = i;
            for (j = i + 1; j < R.length; j++) {
                if (R[j] < R[k]) {
                    k = j;
                }
            }
            // 只在外部循环结束时进行交换
            if (k != i) swap(R, i, k);
        }
    }
}
