package com.hzx.Algorithm.LeetCode刷题;

import java.util.HashSet;

/*
 * 原题链接：https://leetcode.cn/problems/search-insert-position/description/
 * 35.搜索插入位置
 * */
public class Solution_面试题_0101_判定字符是否唯一 {


    public static void main(String[] args) {
        String astr = "abcdefg";
        System.out.println(isUnique((astr)));
        System.out.println(isUnique2((astr)));

    }
    //用java的stream
    public static boolean isUnique(String astr) {
        return astr.chars().distinct().count() == astr.length();
    }

    //用HashSet
    public static boolean isUnique2(String astr) {
        HashSet<Character> hashSet = new HashSet<>();
        for (char c : astr.toCharArray()) {
            boolean contains = hashSet.contains(c);
            if (contains) {
                return false;
            }
            hashSet.add(c);
        }
        return true;

    }

}
