package com.hzx.Algorithm.线性表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class 找出数组中重复元素_findDuplicates {


    //方法一，遍历法
    public static List<Integer> findDuplicates_Compare(int[] nums) {

        List<Integer> res = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;
            if (nums[i] == nums[j]) {
                res.add(nums[i]);
            }
        }
        return res;
    }

    //方法二，哈希表法
    public static List<Integer> findDuplicates_HashSet(int[] nums) {

        List<Integer> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();


        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
            } else {
                res.add(num);
            }
        }
        return res;
    }

    //方法三，抽屉法
    public static List<Integer> findDuplicates_drawerList(int[] nums) {

        List<Integer> res = new ArrayList<>();
        int[] visited = new int[nums.length];

        for (int num : nums) {
            if (visited[num - 1] == 0) {
                visited[num - 1] = 1;
            } else {
                res.add(num);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 2, 1, 3};

        //方法一
//        List<Integer> res = findDuplicates(nums);
        //方法二
//        List<Integer> res = findDuplicates_HashSet(nums);
        //方法三
        List<Integer> res = findDuplicates_drawerList(nums);


        for (Integer r : res) {
            System.out.println(r);
        }

    }


}
