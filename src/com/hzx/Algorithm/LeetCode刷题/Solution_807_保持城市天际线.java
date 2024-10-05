package com.hzx.Algorithm.LeetCode刷题;


/*
* 原题链接：https://leetcode-cn.com/problems/max-increase-to-keep-city-skyline/
* 807.保持城市天际线
* 输入一个二维数组，每个元素代表一做建筑物，元素的值代表建筑物高度
* 在不改变从任何主要方向观测到的城市天际线的前提下，返回建筑物可以增加的最大高度增量总和。
* */

public class Solution_807_保持城市天际线 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int ans = 0; //高度增量总和
        //获得建筑的行、列，比较得出每行、每列的最大值
        int[] rowMax = new int[grid.length];
        int[] colMax = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);//{8,7,9,3}
                colMax[j] = Math.max(colMax[j], grid[i][j]);//{9,4,8,7}
            }
        }
        //每个建筑所能增加的最大高度 = min{每行最大值，每列最大值}
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                ans += Math.min(rowMax[i], colMax[j]) - grid[i][j];
                //System.out.println(ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {3, 0, 8, 4},
                {2, 4, 5, 7},
                {9, 2, 6, 3},
                {0, 3, 1, 0}
        };
        System.out.println(new Solution_807_保持城市天际线().maxIncreaseKeepingSkyline(grid));
    }
}
