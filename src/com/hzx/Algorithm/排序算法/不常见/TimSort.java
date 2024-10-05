package com.hzx.Algorithm.排序算法.不常见;

public class TimSort {


    // 定义最小run长度，实际中可以根据输入大小动态调整
    static int RUN = 32;

    // Tim排序实现
    public static void TimSort(int[] R) {
        int n = R.length;
        // 先用插入排序对每个小块进行排序
        for (int i = 0; i < n; i += RUN) {
            insertionSort(R, i, Math.min(i + RUN - 1, n - 1));
        }

        // 开始归并
        for (int size = RUN; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));

                // 归并
                if (mid < right) {
                    merge(R, left, mid, right);
                }
            }
        }
    }

    // 插入排序
    public static void insertionSort(int[] R, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = R[i];
            int j = i - 1;
            while (j >= left && R[j] > temp) {
                R[j + 1] = R[j];
                j--;
            }
            R[j + 1] = temp;
        }
    }

    // 归并两个有序部分
    public static void merge(int[] R, int l, int m, int r) {
        int len1 = m - l + 1, len2 = r - m;
        int[] left = new int[len1];
        int[] right = new int[len2];

        // 复制到临时数组
        System.arraycopy(R, l, left, 0, len1);
        for (int x = 0; x < len2; x++) right[x] = R[m + 1 + x];

        int i = 0, j = 0, k = l;

        // 合并
        while (i < len1 && j < len2) {
            if (left[i] <= right[j]) {
                R[k++] = left[i++];
            } else {
                R[k++] = right[j++];
            }
        }

        // 复制剩余元素
        while (i < len1) R[k++] = left[i++];
        while (j < len2) R[k++] = right[j++];
    }

}
