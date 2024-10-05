package com.hzx.Algorithm.字符串;

public class 最长公共前缀子串 {


    public static void main(String[] args) {

        String[] strs = new String[]{"flaaaower", "flaaaow", "flaaaight"};

        String prefix = getLongestPrefix2(strs);

        System.out.println(prefix);
    }

    private static String getLongestPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];
        for (String str : strs) {
            while (!str.startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    private static String getLongestPrefix2(String[] strs) {
        if (strs.length == 0) return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}

