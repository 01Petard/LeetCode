package com.hzx.Algorithm;

import java.util.Arrays;

/**
 * 贪心算法
 */
public class GreedyAlgorithm {

    public static void findChange(int[] coins, int amount) {
        Arrays.sort(coins); // 将货币面额按从小到大排序
        int n = coins.length;

        int remainingAmount = amount;
        System.out.print("找零" + amount + "元需要的货币组合为：");

        for (int i = n - 1; i >= 0; i--) {
            while (remainingAmount >= coins[i]) {
                System.out.print(coins[i] + " ");
                remainingAmount -= coins[i];
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] coins = {1, 5, 10, 20, 50, 100};
        int amount = 234;
        findChange(coins, amount); // 输出: 找零78元需要的货币组合为：50 20 5 1 1 1
    }
}

