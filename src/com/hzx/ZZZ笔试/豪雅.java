package com.hzx.ZZZ笔试;


import java.util.HashMap;
import java.util.Map;

/**
 * 输入一个字符串，输出该字符串中出现次数最多的字符,以及其出现次数。如果有多个字符出现次数相同，则输出最先出现的字符。（测试字符串: wgfgwaagee84hhfagfaw3f32r2）
 */
public class 豪雅 {


    public static void main(String[] args) {
        String testString = "wgfgwaagee84hhfagfaw3f32r2";
        findMostFrequentCharacter(testString);
    }

    public static void findMostFrequentCharacter(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("string is null");
        }

        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        char mostFreqChar = str.charAt(0);
        int maxCount = 0;

        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFreqChar = entry.getKey();
            }
        }

        System.out.println("Most frequent character: " + mostFreqChar);
        System.out.println("Frequency: " + maxCount);
    }


}
