package com.hzx.Algorithm.字符串;

public class 判断是否是回文 {


    // 双指针比较法
    public static boolean isPalindrome(String str) {
        str = getString(str);
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // API法
    public static boolean isPalindrome2(String str) {
        str = getString(str);
        return str.contentEquals(new StringBuilder(str).reverse());
    }

    // 除空格和非字母数字字符，并转换为小写
    private static String getString(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        str = sb.toString();
        return str;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome2("A man, a plan, a canal: Panama")); // true
        System.out.println(isPalindrome2("race a car")); // false
        System.out.println(isPalindrome2("acbbca")); // true
        System.out.println(isPalindrome2("abcba")); // true
    }
}
