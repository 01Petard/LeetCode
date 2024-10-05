package com.hzx.Algorithm.排序算法;

public class HeapSort {
    public static void HeapSort(int[] R) {

        // 生成堆（重新排列数组）
        for (int i = R.length / 2 - 1; i >= 0; i--) {
            heapify(R, R.length, i);
        }

        // 逐个从堆中提取元素
        for (int i = R.length - 1; i > 0; i--) {
            // Move current root to end
            int temp = R[0];
            R[0] = R[i];
            R[i] = temp;

            // 在缩减的堆上调用max heapify
            heapify(R, i, 0);
        }
    }

    // 将以节点i为根的子树进行重排序，节点i是arr[]中的索引。
    private static void heapify(int[] R, int n, int i) {
        int largest = i; // 初始化根节点为最大值
        int left = 2 * i + 1; // 左子树
        int right = 2 * i + 2; // 右子树

        // 如果左子树大于根
        if (left < n && R[left] > R[largest]) {
            largest = left;
        }

        // 如果右子树大于根和最大值
        if (right < n && R[right] > R[largest]) {
            largest = right;
        }

        // 如果最大值不是根节点
        if (largest != i) {
            int swap = R[i];
            R[i] = R[largest];
            R[largest] = swap;

            // 递归排受影响的子树
            heapify(R, n, largest);
        }
    }
}
