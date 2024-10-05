package com.hzx.Algorithm.排序算法.不常见;

import java.util.Arrays;

public class RadixSort {
    // 基数排序
    public static void RadixSort(int[] R) {
        if (R == null || R.length == 0) return;
        // 找到数组中的最大数，确定最高位数
        int min = Arrays.stream(R).min().getAsInt();
        int max = Arrays.stream(R).max().getAsInt();

        // 从个位数开始排序，直到最高位
        for (int exp = 1; max / exp > 0; exp *= 10) {
            // 基于当前位数的计数排序
            int n = R.length;
            int[] output = new int[n]; // 输出数组
            int[] count = new int[10]; // 计数数组，基数范围为 0-9

            // 统计每个数位出现的次数
            for (int j : R) {
                int index = (j / exp) % 10;
                count[index]++;
            }

            // 计算累计和，调整 count 数组，使其存储排序后数字的位置
            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }

            // 从后往前遍历原数组，按照当前位数将元素放入正确位置
            for (int i = n - 1; i >= 0; i--) {
                int index = (R[i] / exp) % 10;
                output[count[index] - 1] = R[i];
                count[index]--;
            }

            // 将排序好的数组复制回原数组
            System.arraycopy(output, 0, R, 0, n);
        }
    }

    /**
     * 计数排序（优化版）
     * 优化操作：普通计数排序在待排序数组范围较大时会浪费大量空间。优化的计数排序通过统计每个元素出现的频率来避免为每个可能的值分配计数数组的空间。
     * @param R 待排序数组
     */
    public static void RadixSort_optimized(int[] R) {
        if (R == null || R.length == 0) return;

        int min = Arrays.stream(R).min().getAsInt();
        int max = Arrays.stream(R).max().getAsInt();
        int range = max - min + 1;

        int[] count = new int[range];
        for (int num : R) {
            count[num - min]++;
        }

        int index = 0;
        for (int i = 0; i < range; i++) {
            while (count[i] > 0) {
                R[index++] = i + min;
                count[i]--;
            }
        }
    }

}
