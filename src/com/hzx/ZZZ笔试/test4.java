package com.hzx.ZZZ笔试;

public class test4 {


    public static double get_max_profit(double M, int N, double[] historyPrices, int K) {
        double profit = 0;
        int shares = 0;

        for (int i = 0; i < N; i++) {
            if (i == N - 1 || historyPrices[i] >= historyPrices[i + 1]) {
                // 卖出股票
                profit += shares * historyPrices[i];
                shares = 0;
            } else {
                // 买入股票
                int buyShares = (int) Math.min(M / historyPrices[i], K);
                shares += buyShares;
                M -= buyShares * historyPrices[i];
            }
        }

        return profit;
    }

    public static void main(String[] args) {

        String input = "10000,7,[1.0, 2.0, 1.0,2.0, 2.0, 3.0, 2.0],2";

        // 按逗号分隔输入内容
        String[] parts = input.split(",");

        // 解析每个部分
        int M = Integer.parseInt(parts[0]);
        int N = Integer.parseInt(parts[1]);

        // 解析列表部分
        String arrayString = parts[2].trim();
        // 去除方括号
        arrayString = arrayString.substring(1, arrayString.length() - 1);
        // 按逗号分隔字符串，并转换为 double 数组
        String[] arrayParts = arrayString.split(",");
        double[] historyPrices = new double[arrayParts.length];
        for (int i = 0; i < arrayParts.length; i++) {
            historyPrices[i] = Double.parseDouble(arrayParts[i]);
        }

        int K = Integer.parseInt(parts[parts.length - 1]);// 调用方法


        double maxProfit = get_max_profit(M, N, historyPrices, K);
        System.out.println(maxProfit);

    }


}
