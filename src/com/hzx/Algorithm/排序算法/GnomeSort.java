package com.hzx.Algorithm.排序算法;

public class GnomeSort {

    // 地精排序算法
    public static void GnomeSort(int[] arr) {
        int n = arr.length;
        int index = 0;

        while (index < n) {
            if (index == 0 || arr[index] >= arr[index - 1]) {
                index++;  // 如果顺序正确，继续向前
            } else {
                // 如果顺序不正确，交换元素并向后退一步
                int temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
    }
}