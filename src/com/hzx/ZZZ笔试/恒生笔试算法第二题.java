package com.hzx.ZZZ笔试;

public class 恒生笔试算法第二题 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 根据输入计算最大收益
     * @param M double浮点型 初始资金
     * @param N int整型 历史价格天数
     * @param historyPrices double浮点型一维数组 N天历史价格
     * @param K int整型 最大允许交易次数
     * @return double浮点型
     */
    public static double get_max_profit(double M, int N, double[] historyPrices, int K) {
        double[][] dp = new double[K+1][N];
        for (int j=1; j<N; j++) {
            dp[0][j] = M;
        }
        for (int i=0; i<=K; i++) {
            dp[i][0] = M;
        }
        for (int i=1; i<=K; i++) {
            for (int j = 1; j < N; j++) {
                double max = dp[i][j - 1];
                for (int t = 0; t < j; t++) {
                    double rest = dp[i - 1][t] % historyPrices[t], buy = (dp[i - 1][t] - rest) / historyPrices[t];
                    max = Math.max(max, buy * historyPrices[j] + rest);
                }
                dp[i][j] = max;
            }
        }
        return dp[K][N-1]-dp[0][0];
    }


    public static void main(String[] args) {
        double maxProfit = get_max_profit(10000, 7, new double[]{1.0, 2.0, 1.0, 2.0, 2.0, 3.0, 2.0}, 2);
        System.out.println(maxProfit);
    }

}
