package com.hzx.Algorithm.LeetCode刷题;

/*
 * https://leetcode.cn/problems/assign-cookies/description/
 * 455. 分发饼干
 * */


import java.util.Arrays;

public class Solution_455_分发饼干 {

    private static int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;

        for (int i = 0, j = 0; i < g.length && j < s.length; i++, j++) {

            //寻找能满足第i个孩子的最小的饼干
            while (j < s.length && g[i] > s[j]) {
                j++;
            }
            //找到了能满足第i个孩子的最小的饼干，是第j块饼干
            if (j < s.length) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
//        int[] g = {1, 2, 3};  //孩子
//        int[] s = {1, 1};     //饼干

//        int[] g = {1, 2};
//        int[] s = {1, 2, 3};


//        int[] g = {1, 2, 3};
//        int[] s = {3};

        int[] g = {1, 2, 3};
        int[] s = {1, 1};


        System.out.println(findContentChildren(g, s));


    }


}
