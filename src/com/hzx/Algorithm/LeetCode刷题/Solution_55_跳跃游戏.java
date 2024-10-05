package com.hzx.Algorithm.LeetCode刷题;

/*
 * https://leetcode.cn/problems/jump-game/description/
 * 55. 跳跃游戏
 * */


public class Solution_55_跳跃游戏 {


    /*
    解题思路：
        1. 如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点
        2. 可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新
        3. 如果可以一直跳到最后，就成功了
     */
    private static boolean canJump(int[] nums) {

        int k = 0;  //记录“能跳到最远的距离”

        for (int i = 0; i < nums.length; i++) {

            //如果“当前能跳到的最远距离”都小于“i”了，说明跳不到了，直接返回false
            if (i > k) {
                return false;
            }

            //更新“当前能跳到的最远距离”
            k = Math.max(k, i + nums[i]);

            //如果已经能跳到最后一个格子了，直接返回true
            if (k >= nums.length - 1){
                return true;
            }
        }

        return true;
    }

    public static void main(String[] args) {

//        int[] nums = {2, 3, 1, 1, 4};
//        int[] nums = {0};  //true
//        int[] nums = {1, 2};  //true
//        int[] nums = {0, 1};   //false
//        int[] nums = {3, 2, 1, 0, 4};
//        int[] nums = {0, 2};
//        int[] nums = {1, 2, 3};
//        int[] nums = {0, 2, 3};
//        int[] nums = {1, 0, 1, 0};
//        int[] nums = {1, 1, 1, 0};
        int[] nums = {5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0};


        System.out.println(canJump(nums));


    }


}
