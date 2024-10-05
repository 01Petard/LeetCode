package com.hzx.ZZZ笔试;

public class PrimeNumbersInRange {

    public static void main(String[] args) {
        int count = 0;
        System.out.println("1000至2000之间的素数有：");

        for (int num = 1000; num <= 2000; num++) {
            if (isPrime(num)) {
                System.out.print(num + " ");
                count++;
            }
        }
        System.out.println("\n素数总数: " + count);
    }

    /**
     * 判断一个数是否为素数。
     * @param number 要判断的数
     * @return 如果是素数则返回true，否则返回false
     */
    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number <= 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
