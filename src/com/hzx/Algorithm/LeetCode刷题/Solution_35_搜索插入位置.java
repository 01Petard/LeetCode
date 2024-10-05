package com.hzx.Algorithm.LeetCode刷题;

/*
 * 原题链接：https://leetcode.cn/problems/search-insert-position/description/
 * 35.搜索插入位置
 * */
public class Solution_35_搜索插入位置 {


    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
//        int target = 5;
//        int target = 2;
//        int target = 7;
        int target = 0;


        int i = searchInsert(nums, target);
        System.out.println(i);
    }

    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

}
