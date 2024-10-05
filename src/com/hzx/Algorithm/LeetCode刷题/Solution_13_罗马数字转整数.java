package com.hzx.Algorithm.LeetCode刷题;

import java.util.HashMap;

/*
 * 原题链接：https://leetcode.cn/problems/roman-to-integer/
 * 13.罗马数字转整数
 * 解题思路：首先建立一个HashMap来映射符号和值，然后对字符串从左到右来，如果当前字符代表的值不小于其右边，就加上该值；
 * 否则就减去该值。以此类推到最左边的数，最终得到的结果即是答案
 * */
public class Solution_13_罗马数字转整数 {
    public static int romanToInt(String s) {
        int m = 0;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        String[] strings = s.split("");
        for (int i = 0; i < strings.length - 1; i++) {
            if (map.get(strings[i]) >= map.get(strings[i + 1])) {
                m += map.get(strings[i]);
            } else {
                m -= map.get(strings[i]);
            }
        }
        m += map.get(strings[strings.length-1]);
        return m;
    }

    public static void main(String[] args) {
//        String s = "IX";
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }


}
