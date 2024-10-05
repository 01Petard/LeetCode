package com.hzx.Algorithm.LeetCode刷题;

/*
 * 原题链接：https://leetcode.cn/problems/valid-palindrome/description/
 * 125.验证回文串
 * */


public class Solution_125_验证回文串 {

    public static boolean isPalindrome(String s) {

        String string = s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase();
        String reverse_string = new StringBuilder(string).reverse().toString();

        return string.equals(reverse_string);
    }


    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }


}
