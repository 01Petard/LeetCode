package com.hzx.ZZZ笔试;


import java.util.*;

public class 永辉超市1 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        // 使用一个 HashSet 来存储字典中的单词，便于快速查找
        Set<String> wordSet = new HashSet<>(wordDict);

        // dp[i] 表示前 i 个字符能否拆分为字典中的单词
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;  // 空字符串可以拆分

        // 遍历所有的字符位置
        for (int i = 1; i <= s.length(); i++) {
            // 从 0 到 i 之间查找能组成字典中的单词的分割点
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        // 最终返回 dp[s.length()]，即整个字符串是否能拆分为字典中的单词
        return dp[s.length()];
    }

    public static void main(String[] args) {
        // 示例测试
        List<String> wordDict = List.of("鸡", "你", "太", "美");
        String s = "鸡你太美";
        System.out.println(wordBreak(s, wordDict));  // 输出 true
    }
}