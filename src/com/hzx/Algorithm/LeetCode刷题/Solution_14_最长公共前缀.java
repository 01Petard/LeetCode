package com.hzx.Algorithm.LeetCode刷题;

/*
 * 原题链接：https://leetcode.cn/problems/longest-common-prefix/
 * 14.最长公共前缀
 * */
public class Solution_14_最长公共前缀 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String s = strs[0]; //公共前缀比所有字符串都短，随便选一个先
        for (String string : strs) {
            while (!string.startsWith(s)) {
                s = s.substring(0, s.length() - 1); //公共前缀不匹配就倒退一位
            }
        }
        return s;
    }

    public static void main(String[] args) {
//        String[] strs = new String[]{"flower", "flow", "flight"};
//        String[] strs = new String[]{"a"};
        String[] strs = new String[]{"c","acc","ccc"};
        System.out.println(longestCommonPrefix(strs));

        String s = "123";
        System.out.println(s.contains("f"));
    }


}
