package com.hzx.Algorithm.LeetCode刷题;

public class Solution_42_TrapRainWater2_接雨水问题2 {

    public static int trap(int[] heights) {

        int left = 0, right = heights.length - 1;
        int maxL = heights[left], maxR = heights[right];
        int water = 0;
        while (left < right) {
            maxL = Math.max(maxL, heights[left]);
            maxR = Math.max(maxR, heights[right]);
            water += maxR > maxL ? maxL - heights[left++] : maxR - heights[right--];
        }
        return water;

    }

    public static void main(String[] args) {

        int[] heights = {4, 1, 2, 1, 5};  //输出：8
//        int[] heights = {4, 3, 2, 1, 2};  //输出：1
//        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};  //输出：6

        System.out.println(trap(heights));
    }

}
