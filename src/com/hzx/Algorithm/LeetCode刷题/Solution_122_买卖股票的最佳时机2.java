package com.hzx.Algorithm.LeetCode刷题;

/*
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/
 * 122. 买卖股票的最佳时机2
 * */


public class Solution_122_买卖股票的最佳时机2 {

    private static int maxProfit2(int[] prices) {

        int maxprofit = 0;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] > prices[i - 1]) {
                maxprofit += prices[i] - prices[i - 1];
            }

        }

        return maxprofit;
    }

    public static void main(String[] args) {
//        int[] prices = {7, 1, 5, 3, 6, 4}; //7
//        int[] prices = {1, 2, 3, 4, 5};  //4
        int[] prices = {7, 6, 4, 3, 1};  //0

        System.out.println(maxProfit2(prices));
    }


}
