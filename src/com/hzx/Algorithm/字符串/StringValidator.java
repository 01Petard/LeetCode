package com.hzx.Algorithm.字符串;

/**
 * 判断字符串是否符合条件
 */
public class StringValidator {

    // 判断字符串是否全部为空格
    public static boolean isAllSpace(String str) {
        return str.matches("\\s+");
    }

    // 判断字符串是否全部为数字
    public static boolean isAllDigit(String str) {
        return str.matches("\\d+");
    }

    // 判断字符串是否全部为字母
    public static boolean isAllLetters(String str) {
        return str.matches("\\p{L}+");
    }

    // 判断字符串是否全部为字母、数字或下划线
    public static boolean isAllChar(String str) {
        return str.matches("\\w+");
    }

    // 判断字符串是否全部为小写字母
    public static boolean isAllLowerCaseLetters(String str) {
        return str.matches("[a-z]+");
    }

    // 判断字符串是否全部为大写字母
    public static boolean isAllUpperCaseLetters(String str) {
        return str.matches("[A-Z]+");
    }

    public static boolean isEmail(String str) {
        return str.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
    }

    public static boolean isPhoneNumber(String str) {
        return str.matches("\\d{10,11}");
    }

    public static boolean isURL(String str) {
        return str.matches("https?://[a-zA-Z0-9.-]+(/[a-zA-Z0-9.-]*)*");
    }

    public static boolean isDate(String str) {
        return str.matches("\\d{4}-\\d{2}-\\d{2}");
    }

    public static boolean isLowercaseLetters(String str) {
        return str.matches("[a-z]+");
    }

    public static boolean isUppercaseLetters(String str) {
        return str.matches("[A-Z]+");
    }

    public static boolean isHexadecimal(String str) {
        return str.matches("[0-9a-fA-F]+");
    }

    public static boolean isIPv4(String str) {
        return str.matches("\\b((?:\\d{1,3}\\.){3}\\d{1,3})\\b");
    }

    public static boolean isIPv6(String str) {
        return str.matches("([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}");
    }

    public static boolean isChineseCharacters(String str) {
        return str.matches("[\\u4e00-\\u9fa5]+");
    }

    public static boolean isAlphanumeric(String str) {
        return str.matches("[a-zA-Z0-9]+");
    }

    public static boolean isLength(String str, int length) {
        return str.length() == length;
    }

    public static boolean startsWithPrefix(String str, String prefix) {
        return str.startsWith(prefix);
    }

    public static boolean endsWithSuffix(String str, String suffix) {
        return str.endsWith(suffix);
    }

    public static void main(String[] args) {
        System.out.println(isAllSpace("   ")); // true
        System.out.println(isAllDigit("12345")); // true
        System.out.println(isAllLetters("HelloWorld")); // true
        System.out.println(isAllChar("Hello123")); // true
        System.out.println(isEmail("example@example.com")); // true
        System.out.println(isPhoneNumber("1234567890")); // true
        System.out.println(isURL("http://example.com")); // true
        System.out.println(isDate("2023-10-05")); // true
        System.out.println(isLowercaseLetters("hello")); // true
        System.out.println(isUppercaseLetters("WORLD")); // true
        System.out.println(isHexadecimal("1A2B3C")); // true
        System.out.println(isIPv4("192.168.1.1")); // true
        System.out.println(isIPv6("2001:0db8:85a3:0000:0000:8a2e:0370:7334")); // true
        System.out.println(isChineseCharacters("你好世界")); // true
        System.out.println(isAlphanumeric("Hello123")); // true
        System.out.println(isLength("12345", 5)); // true
        System.out.println(startsWithPrefix("hello", "he")); // true
        System.out.println(endsWithSuffix("world", "ld")); // true
    }
}
