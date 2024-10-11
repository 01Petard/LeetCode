package com.hzx.Algorithm.字符串;

public class 最长回文子串和子串的长度 {


    public static int longestPalindromeLength(String s) {
        if (s == null || s.isEmpty()) return 0;


        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);

            max = Math.max(max, Math.max(len1, len2));
        }
        return max;
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";

        int start = 0, end = 0;
        String substring = null;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);

            // 截取回文子序列
            if (end - start < len) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
            substring = s.substring(start, end + 1);
        }
        return substring;

    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {

        System.out.println(longestPalindrome("babiibad"));
    }
}
