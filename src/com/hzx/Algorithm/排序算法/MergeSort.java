package com.hzx.Algorithm.排序算法;

public class MergeSort {

    public static void MergeSort(int[] R) {
        MergeSort(R, 0, R.length - 1);
    }

    /**
     * 递归地将数组分成两部分进行排序
     * @param R     需要排序的数组
     * @param low   当前排序部分的左边界
     * @param high  当前排序部分的右边界
     */
    public static void MergeSort(int[] R, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            MergeSort(R, low, mid);
            MergeSort(R, mid + 1, high);
            merge(R, low, mid, high);
        }
    }

    private static void merge(int[] R, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;

        int k = 0;
        while (i <= mid && j <= high) {
            if (R[i] <= R[j]) {
                temp[k++] = R[i++];
            } else {
                temp[k++] = R[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = R[i++];
        }
        while (j <= high) {
            temp[k++] = R[j++];
        }
        System.arraycopy(temp, 0, R, low, temp.length);
    }


    /**
     * 归并排序
     * @param R    待排序数组
     * @param low  开始位置
     * @param high 结束位置
     */
    public static void mergeSort(int[] R, int low, int high) {
        if (low >= high) return;
        int mid = low + (high - low) / 2;
        mergeSort(R, low, mid);
        mergeSort(R, mid + 1, high);
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (R[i] <= R[j]) {
                temp[k++] = R[i++];
            } else {
                temp[k++] = R[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = R[i++];
        }
        while (j <= high) {
            temp[k++] = R[j++];
        }
        for (i = low, k = 0; i <= high; i++, k++) {
            R[i] = temp[k];
        }
    }
}
