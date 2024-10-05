package com.hzx.Algorithm.LeetCode刷题;

public class Solution_42_TrapRainWater_接雨水问题 {

    public static int trap(int[] heights) {

        int left = 0; // 左指针
        int right = heights.length - 1; // 右指针
        int leftMax = 0; // 左侧最高墙
        int rightMax = 0; // 右侧最高墙
        int water = 0; // 雨水总量

        while (left <= right) {
            // 更新最高墙
            if (heights[left] > leftMax) {
                leftMax = heights[left];
            }
            if (heights[right] > rightMax) {
                rightMax = heights[right];
            }

            // 更新水量
            if (leftMax < rightMax) {
                water += leftMax - heights[left];
                left++;
            } else {
                water += rightMax - heights[right];
                right--;
            }
        }

        return water;
    }

    public static void main(String[] args) {

//        int[] heights = {4, 1, 2, 1, 5};
        int[] heights = {4, 3, 2, 1};
//        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};


        System.out.println(trap(heights));
    }

}
