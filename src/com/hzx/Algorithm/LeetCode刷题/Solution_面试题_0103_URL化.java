package com.hzx.Algorithm.LeetCode刷题;

/*
 * 原题链接：https://leetcode.cn/problems/search-insert-position/description/
 * 35.搜索插入位置
 * */
public class Solution_面试题_0103_URL化 {


    public static void main(String[] args) {
        String s = "Mr John Smith    ";
        int length = 13;
        System.out.println(replaceSpaces(s, length));
    }

    public static String replaceSpaces(String s, int length) {

        String substring = s.substring(0, length);
        String string = substring.replaceAll(" ", "%20");

        return string;




    }


}
