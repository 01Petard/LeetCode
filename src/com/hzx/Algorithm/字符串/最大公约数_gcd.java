package com.hzx.Algorithm.字符串;

public class 最大公约数_gcd {

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        int result = gcd(12, 8);
        System.out.println("GCD of 8 and 12 is: " + result); // 输出 4
    }
}
