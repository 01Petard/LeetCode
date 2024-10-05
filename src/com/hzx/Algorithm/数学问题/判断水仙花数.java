package com.hzx.Algorithm.数学问题;

import java.util.Scanner;

public class 判断水仙花数 {

    /**
     * 判断一个整数是否为水仙花数。
     * @param number 待检查的整数
     * @return 如果是水仙花数返回 true，否则返回 false
     */
    public static boolean isNarcissisticNumber(int number) {
        // 计算数字的位数
        int numDigits = String.valueOf(number).length();

        // 分离各个位上的数字
        int temp = number;
        int sum = 0;

        while (temp > 0) {
            int digit = temp % 10;
            sum += (int) Math.pow(digit, numDigits);
            temp /= 10;
        }

        // 检查各个位上的数字的次方和是否等于原数
        return sum == number;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = sc.nextInt();
        for (int i = 0; i <= max; i++) {
            if (isNarcissisticNumber(i)) {
                System.out.println(i + " 是水仙花数。");
            }
        }
    }
}
