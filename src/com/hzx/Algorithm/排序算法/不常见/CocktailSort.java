package com.hzx.Algorithm.排序算法.不常见;

public class CocktailSort {

    // 鸡尾酒排序主方法
    public static void CocktailSort(int[] arr) {
        boolean swapped = true;
        int start = 0;
        int end = arr.length - 1;

        while (swapped) {
            swapped = false;

            // 从左到右进行冒泡排序，将最大的元素移到末尾
            for (int i = start; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }

            // 如果没有发生交换，说明数组已经排序好
            if (!swapped) {
                break;
            }

            // 向前缩小排序范围
            swapped = false;
            end--;

            // 从右到左进行冒泡排序，将最小的元素移到开头
            for (int i = end; i > start; i--) {
                if (arr[i] < arr[i - 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    swapped = true;
                }
            }

            // 向后缩小排序范围
            start++;
        }
    }

}
