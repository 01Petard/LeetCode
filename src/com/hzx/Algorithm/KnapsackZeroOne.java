package com.hzx.Algorithm;


/**
 * 0-1背包问题
 */
public class KnapsackZeroOne {
    // 求解0-1背包问题，返回最大价值
    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        // 创建动态规划数组，dp[i][j]表示前i个物品装进容量为j的背包的最大价值
        int[][] dp = new int[n + 1][capacity + 1];

        // 动态规划求解
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                // 如果当前物品的重量大于当前背包容量，不能放入背包，取前一个物品的最大价值
                if (weights[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 否则，可以选择放入或不放入背包，取价值较大者
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                }
            }
        }

        // 返回背包能够获得的最大价值
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};
        int[] values = {6, 5, 8, 9};
        int capacity = 10;
        System.out.println("0-1背包问题最大价值：" + knapsack(weights, values, capacity)); // 输出：23
    }
}

