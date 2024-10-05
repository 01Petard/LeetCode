package com.hzx.Algorithm.LeetCode刷题;

import java.util.HashSet;

/*
 * 原题链接：https://leetcode.cn/problems/search-insert-position/description/
 * 104. 回文排列
 * */
public class Solution_面试题_0104_回文排列 {


    public static void main(String[] args) {
        String s = "tactcoa";
        System.out.println(canPermutePalindrome(s));
    }

    public static boolean canPermutePalindrome(String s) {

        HashSet<Object> hashSet = new HashSet<>();
        for (char c : s.toCharArray()) {
            boolean add = hashSet.add(c);
            if (!add) {
                hashSet.remove(c);
            }

        }
        // 最后判断set的长度是否小于等于1，
        // 如果等于1，说明只有一个字符的个数是奇数，其他的都是偶数。
        // 如果等于0，说明每个字符都是偶数，否则不可能构成回文字符串

        return hashSet.size() <= 1;
    }


}
