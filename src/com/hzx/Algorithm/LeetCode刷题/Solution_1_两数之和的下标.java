package com.hzx.Algorithm.LeetCode刷题;

/*
 * 原题链接：https://leetcode.cn/problems/two-sum/description//
 * 1.两数之和
 * 给定一个数组和目标值，返回数组中相加等于目标值的元素的下标
 * */

import java.util.HashMap;
import java.util.Map;

public class Solution_1_两数之和的下标 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                //通过匿名数组返回结果
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
//            System.out.println(map);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 7, 2, 15};
        int[] res = twoSum(nums, 9);
        for (int i : res) {
            System.out.println(i);
        }
    }


}
