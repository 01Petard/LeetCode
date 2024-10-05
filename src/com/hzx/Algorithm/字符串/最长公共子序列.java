package com.hzx.Algorithm.字符串;

/*
 * 找出两个序列中的一个具有最长长度的公共子序列。
 * 与子字符串不同，子序列不需要在原序列中是连续的。
 */
public class 最长公共子序列 {
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        int length = longestCommonSubsequence(text1, text2);
        System.out.println("最长公共子序列的长度为：" + length); // 输出：最长公共子序列的长度为：3
    }
}

