package com.hzx.Algorithm;


/**
 * 求最大连续子序列和的左右边界
 */
public class SlidingWindow {
    public static int[] maxSubarraySum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int windowSum = 0;
        int left = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right];

            if (windowSum > maxSum) {
                maxSum = windowSum;
                leftIndex = left;
                rightIndex = right;
            }

            // 如果窗口和小于等于0，左边界右移
            if (windowSum <= 0) {
                windowSum = 0;
                left = right + 1;
            }
        }

        return new int[]{leftIndex, rightIndex, maxSum};
    }


    public static void main(String[] args) {
        int[] nums = {1, -3, 5, -2, 9, -8, -6, 4};
        int[] result = maxSubarraySum(nums);
        System.out.println("左边界下标：" + result[0] + "，右边界下标：" + result[1] + "，子数组和：" + result[2]); // 输出：左边界下标：2，右边界下标：4，子数组和：12
    }
}
