package com.hzx.Algorithm;

/**
 * 完全背包问题
 */
public class KnapsackComplete {
    // 求解完全背包问题，返回最大价值
    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        // 创建动态规划数组，dp[j]表示容量为j的背包所能装下的最大价值
        int[] dp = new int[capacity + 1];

        // 动态规划求解
        for (int i = 0; i < n; i++) {
            for (int j = weights[i]; j <= capacity; j++) {
                // 装入第i个物品，更新背包容量j的最大价值
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
        }

        // 返回背包能够获得的最大价值
        return dp[capacity];
    }

    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};
        int[] values = {6, 5, 8, 9};
        int capacity = 10;
        System.out.println("完全背包问题最大价值：" + knapsack(weights, values, capacity)); // 输出：30
    }
}

