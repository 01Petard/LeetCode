package com.hzx.Algorithm.字符串;

public class 最长连续递增子串长度 {

    public static int longestContinuousSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int longest = 1;
        int curLength = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                curLength++;
            } else {
                longest = Math.max(longest, curLength);
                curLength = 1;
            }
        }
        // 更新最长连续子序列的长度，以防止最后一段最长序列没有更新
        longest = Math.max(longest, curLength);
        return longest;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 5, 7, 8, 9};
        System.out.println(longestContinuousSubsequence(nums));
    }
}
