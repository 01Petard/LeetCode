package com.hzx.Algorithm.排序算法;

public class InsertSort {
    /**
     * 插入排序
     * @param R 待排序数组
     */
    public static void InsertSort(int[] R) {
        int i, j, temp;
        for (i = 1; i < R.length; i++) {
            temp = R[i];
            for (j = i - 1; j >= 0; j--) {
                if (temp < R[j]) R[j + 1] = R[j];
                else break;
            }
            R[j + 1] = temp;
        }
    }

    /**
     * 插入排序（优化版）
     * 优化操作：
     * 1、减少赋值操作：在当前元素找到合适位置之前，需要将比它大的元素都向右移动一位，这会导致多次赋值操作。可以使用一个临时变量来保存当前元素的值，在找到合适位置后再进行赋值操作。
     * 2、减少比较次数：内部循环中，可以在不满足条件时就退出，而不必继续比较。可以改用 while 循环来实现这一点。
     * @param R 待排序数组
     */
    public static void InsertSort_optimized(int[] R) {
        int i, j, temp;
        for (i = 1; i < R.length; i++) {
            temp = R[i];
            j = i - 1;
            // 移动比当前元素大的元素，为当前元素腾出插入位置
            while (j >= 0 && R[j] > temp) {
                R[j + 1] = R[j];
                j--;
            }
            // 将当前元素插入合适的位置
            R[j + 1] = temp;
        }
    }
}
