package com.hzx.Algorithm.LeetCode刷题;

import java.util.HashMap;
import java.util.Map;

/*
 * 原题链接：https://leetcode.cn/problems/compress-string-lcci/description/
 */
public class Solution_面试题_0106_字符串压缩 {


    public static void main(String[] args) {
        String s = "aabcccccaaa";
        System.out.println(compressString(s));
        System.out.println(compressString1(s));
    }



    //个人理解，不重复的计算方法
    public static String compressString(String s) {
        String[] strings = s.split("");
        HashMap<String, Integer> map = new HashMap<>();
        for (String string : strings) {
            map.put(string, map.getOrDefault(string, 0) + 1);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            stringBuilder.append(entry.getKey()).append(entry.getValue());
        }
        if (stringBuilder.length()>= s.length()){
            return s;
        }else {
            return stringBuilder.toString();
        }
    }
    public static String compressString1(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        StringBuilder compressed = new StringBuilder();
        char currentChar = s.charAt(0);
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == currentChar) {
                count++;
            } else {
                compressed.append(currentChar);
                compressed.append(count);
                currentChar = s.charAt(i);
                count = 1;
            }
        }

        // Append the last character and its count
        compressed.append(currentChar);
        compressed.append(count);

        // Compare the compressed string with the original and return the shortest
        return compressed.length() < s.length() ? compressed.toString() : s;
    }
}
