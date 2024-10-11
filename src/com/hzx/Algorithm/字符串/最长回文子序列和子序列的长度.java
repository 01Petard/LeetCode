package com.hzx.Algorithm.字符串;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 最长回文子序列和子序列的长度 {


    public static int longestPalindromeSubseqLength(String s) {
        if (s == null || s.isEmpty()) return 0;

        int n = s.length();
        int[][] dp = new int[n][n];

        // 初始化对角线上的值
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // 填充 dp 数组
        for (int len = 2; len <= n; len++) { // 子序列长度
            for (int i = 0; i <= n - len; i++) { // 起始索引
                int j = i + len - 1; // 结束索引
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }


    public static String longestPalindromeSubseq(String s) {
        if (s == null || s.isEmpty()) return "";

        int n = s.length();
        int[][] dp = new int[n][n];
        boolean[][] isPalindrome = new boolean[n][n];

        // 初始化对角线上的值
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            isPalindrome[i][i] = true;
        }

        // 填充 dp 数组和 isPalindrome 数组
        for (int len = 2; len <= n; len++) { // 子序列长度
            for (int i = 0; i <= n - len; i++) { // 起始索引
                int j = i + len - 1; // 结束索引
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                    isPalindrome[i][j] = true;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    isPalindrome[i][j] = false;
                }
            }
        }

        // 回溯构造最长回文子序列
        StringBuilder result = new StringBuilder();
        int i = 0, j = n - 1;
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                result.append(s.charAt(i));
                i++;
                j--;
            } else if (dp[i + 1][j] > dp[i][j - 1]) {
                i++;
            } else {
                j--;
            }
        }

        // 添加后半部分
        int mid = result.length();
        for (int k = mid - 1; k >= 0; k--) {
            result.append(result.charAt(k));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "babiibavb";
        System.out.println(longestPalindromeSubseqLength(s));
        System.out.println(longestPalindromeSubseq(s));
        System.out.println(lengthOfLongestSubsequence("pwwkewaipw"));
    }


    public static int lengthOfLongestSubsequence(String s) {
        if (s == null || s.length() == 0) return 0;

        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        // dp[i] 表示以第 i 个字符结尾的最长无重复字符子序列的长度
        int[] dp = new int[n];
        dp[0] = 1; // 第一个字符自己构成的子序列长度为1
        map.put(s.charAt(0), 0);

        for (int i = 1; i < n; i++) {
            char curChar = s.charAt(i);
            if (!map.containsKey(curChar)) {
                // 如果当前字符没有出现过，则最长子序列长度加1
                dp[i] = dp[i - 1] + 1;
            } else {
                // 如果当前字符出现过，找到它上次出现的位置
                int lastIndex = map.get(curChar);
                // 计算从上次出现位置到当前位置的距离
                int distance = i - lastIndex;

//                dp[i] = Math.min(distance, dp[i - 1]) + 1;

                if (distance > dp[i - 1]) {
                    // 如果中间相隔的字符数量大于上一个最长子序列的长度，则最长子序列长度+1
                    dp[i] = dp[i - 1] + 1;
                } else {
                    // 如果中间相隔的字符数量小于上一个最长子序列的长度，则最长子序列长度=中间相隔的字符数量-1
                    dp[i] = distance - 1;
                }
            }
            map.put(curChar, i); // 更新字符的最后出现位置
        }

        int maxLength = 0;
        for (int len : dp) {
            maxLength = Math.max(maxLength, len);
        }

        return maxLength;
    }



}
