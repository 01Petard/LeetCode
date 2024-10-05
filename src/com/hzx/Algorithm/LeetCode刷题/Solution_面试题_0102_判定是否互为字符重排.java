package com.hzx.Algorithm.LeetCode刷题;

import java.util.Arrays;

import static java.util.Collections.sort;

/*
 * 原题链接：https://leetcode.cn/problems/search-insert-position/description/
 * 35.搜索插入位置
 * */
public class Solution_面试题_0102_判定是否互为字符重排 {


    public static void main(String[] args) {
        String s1 = "leet";
        String s2 = "tlee";
        System.out.println(CheckPermutation(s1, s2));;

    }

    public static boolean CheckPermutation(String s1, String s2) {
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        return Arrays.equals(charArray1, charArray2);
    }


}
