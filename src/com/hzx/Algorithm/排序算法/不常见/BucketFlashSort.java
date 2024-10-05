package com.hzx.Algorithm.排序算法.不常见;

import java.util.Arrays;

public class BucketFlashSort {

    // 闪电排序的主方法
    public static void BucketFlashSort(int[] arr) {
        int n = arr.length;
        if (n == 0) return;

        // 找到数组中的最大值和最小值
        int min = Arrays.stream(arr).min().orElse(Integer.MIN_VALUE);
        int max = Arrays.stream(arr).max().orElse(Integer.MAX_VALUE);

        if (min == max) return; // 如果所有元素相等，直接返回

        // 定义桶的数量
        int numBuckets = (int) (0.43 * n); // 经验值，一般设置为0.43倍的数组长度
        int[] count = new int[numBuckets]; // 计数数组，记录每个桶中的元素数量

        // 计算每个元素所属的桶
        double bucketFactor = (double) (numBuckets - 1) / (max - min);
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) ((arr[i] - min) * bucketFactor);
            count[bucketIndex]++;
        }

        // 将计数数组转换为位置数组
        for (int i = 1; i < numBuckets; i++) {
            count[i] += count[i - 1];
        }

        // 进行置换，将元素放入正确的桶中
        int move = 0;
        int j = 0;
        int k = numBuckets - 1;
        int temp, flash;
        while (move < n - 1) {
            while (j > count[k] - 1) {
                j++;
                k = (int) ((arr[j] - min) * bucketFactor);
            }
            flash = arr[j];
            while (j != count[k]) {
                k = (int) ((flash - min) * bucketFactor);
                temp = arr[--count[k]];
                arr[count[k]] = flash;
                flash = temp;
                move++;
            }
        }

        // 使用插入排序对每个桶内部进行排序
        for (int i = 1; i < numBuckets; i++) {
            insertionSort(arr, count[i - 1], count[i] - 1);
        }
    }

    // 插入排序，用于桶内部的局部排序
    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
