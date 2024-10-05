package com.hzx.Algorithm.LeetCode刷题;

/*
 * https://leetcode.cn/problems/jump-game-ii/description/
 * 45. 跳跃游戏 II
 * */


public class Solution_45_跳跃游戏2 {

    private static int jump(int[] nums) {

        int begin = 0;   //起跳点
        int end = 0;     //最远落点
        int count = 0;   //跳跃次数

        while (end < nums.length - 1) {
            int maxDistance = 0;   //记录起跳点后面的点，得到能跳到的最远距离
            for (int i = begin; i <= end; i++) {
                maxDistance = Math.max(nums[i] + i, maxDistance);  //遍历起跳点后面的点，得到能跳到的最远距离
            }
            begin = end + 1;    //下一次起跳点为最远落点的下一个点
            end = maxDistance;  //更新最远落点
            count++;            //跳跃次数加一
        }
        return count;
    }

    private static int jump_better(int[] nums) {

        int begin = 0;   //起跳点
        int end = 0;     //最远落点
        int count = 0;   //跳跃次数
        int maxDistance = 0;   //记录起跳点后面的点，得到能跳到的最远距离

        for (int i = 0; i < nums.length - 1; i++) {
            maxDistance = Math.max(nums[i] + i, maxDistance);  //遍历起跳点后面的点，得到能跳到的最远距离
            //从起跳点遍历到能跳到的最远距离，寻找最远落点
            if (i == end) {
                end = maxDistance;
                count++;
            }

        }
        return count;
    }

    public static void main(String[] args) {

//        int[] nums = {2, 3, 1, 1, 4};
//        int[] nums = {2, 3, 0, 1, 4};

        int[] nums = {5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0};


        System.out.println(jump(nums));
        System.out.println(jump_better(nums));


    }


}
