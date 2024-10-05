package com.hzx.Algorithm.线性表;


public class 合并数组并保持有序_MergeArray {
    /**
     * @param nums1 待合并数组1
     * @param m     数组1需要合并的长度
     * @param nums2 待合并数组2
     * @param n     数组2需要合并的长度
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        // 从两个数组的末尾开始
        int i = m - 1; // nums1 的末尾指针
        int j = n - 1; // nums2 的末尾指针
        int k = m + n - 1; // nums1 的新末尾指针

        // 合并两个数组
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 9, 8, 7};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 2);
        for (int i : nums1) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
