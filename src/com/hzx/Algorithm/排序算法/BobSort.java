package com.hzx.Algorithm.排序算法;

public class BobSort extends swap {
    /**
     * 冒泡排序
     * @param R 待排序数组
     */
    public static void BobSort(int[] R) {
        int i, j, temp;
        for (i = R.length - 1; i > 0; i--) {
            for (j = 0; j < i; j++) {
                if (R[j] > R[j + 1]) swap(R, j, j + 1);

            }
        }
    }

    /**
     * 冒泡排序（优化版）
     * 优化操作：
     * 1、添加早期退出条件：在内部循环中，如果某次迭代没有发生交换，说明数组已经是有序的，可以提前退出外部循环，而不必继续迭代。
     * 2、减少比较次数：外部循环每迭代一次，就会确定一个最大值，所以内部循环可以减少一次迭代。
     * 3、检查边界：在交换元素之前，应该确保 j + 1 不超出数组边界。
     * @param R 待排序数组
     */
    public static void BobSort_optimized(int[] R) {
        int i, j, temp;
        boolean swapped;
        for (i = R.length - 1; i > 0; i--) {
            swapped = false;
            for (j = 0; j < i; j++) {
                if (R[j] > R[j + 1]) {
                    swap(R, j, j + 1);
                    swapped = true;
                }
            }
            // 如果没有发生交换，说明数组已经是有序的，提前退出循环
            if (!swapped) {
                break;
            }
        }
    }
}
