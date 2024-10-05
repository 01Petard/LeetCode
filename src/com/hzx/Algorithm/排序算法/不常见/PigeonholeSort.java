package com.hzx.Algorithm.排序算法.不常见;

import java.util.Arrays;

public class PigeonholeSort {
    public static void PigeonholeSort(int[] arr) {
        int minValue = Arrays.stream(arr).min().orElse(Integer.MIN_VALUE);
        int maxValue = Arrays.stream(arr).max().orElse(Integer.MAX_VALUE);
        int range = maxValue - minValue + 1; // 计算范围大小

        // 创建并初始化"鸽巢"数组
        int[] pigeonholes = new int[range];
        Arrays.fill(pigeonholes, 0);

        // 将每个元素放入对应的“鸽巢”中
        for (int num : arr) {
            pigeonholes[num - minValue]++;
        }

        // 将鸽巢中的元素按顺序返回到数组中
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (pigeonholes[i]-- > 0) {
                arr[index++] = i + minValue;
            }
        }
    }
}
