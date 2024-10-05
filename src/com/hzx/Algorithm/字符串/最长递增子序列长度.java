package com.hzx.Algorithm.字符串;

import java.util.Arrays;

public class 最长递增子序列长度 {
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int longest = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            longest = Math.max(longest, dp[i]);
        }
        return longest;
    }


    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 8, 4};
        System.out.println(lengthOfLIS(nums));
    }
}
