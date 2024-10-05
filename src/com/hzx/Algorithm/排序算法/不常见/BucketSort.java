package com.hzx.Algorithm.排序算法.不常见;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    static final int bucketSize = 10;

    public static void BucketSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        // 找到最大值和最小值
        float min = arr[0];
        float max = arr[0];
        for (float num : arr) {
            if (num < min) {
                min = num;
            } else if (num > max) {
                max = num;
            }
        }

        // 计算桶的数量
        int bucketCount = (int) Math.floor((max - min) / bucketSize) + 1;

        // 初始化桶
        List<List<Float>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        // 将元素分配到桶中
        for (float num : arr) {
            int bucketIndex = (int) Math.floor((num - min) / bucketSize);
            buckets.get(bucketIndex).add(num);
        }

        // 对每个桶进行排序（这里使用内置的 Collections.sort 方法）
        for (List<Float> bucket : buckets) {
            Collections.sort(bucket);
        }

        // 将排序后的桶合并回原数组
        int index = 0;
        for (List<Float> bucket : buckets) {
            for (float num : bucket) {
                arr[index++] = (int) num;
            }
        }
    }
}
