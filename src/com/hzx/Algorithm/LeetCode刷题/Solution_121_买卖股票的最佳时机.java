package com.hzx.Algorithm.LeetCode刷题;

/*
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/
 * 121. 买卖股票的最佳时机
 * */


public class Solution_121_买卖股票的最佳时机 {

    //暴力法，O(n^2)
    public static int maxProfit(int[] prices) {
        int left = 0;
        int right = 0;
        int max_profit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                if (prices[i] < prices[j]) {
                    max_profit = Math.max(max_profit, prices[j] - prices[i]);
                    left = i;
                    right = j;
                }
            }
        }
        return max_profit;
    }

    //优化，O(n)
    public static int maxProfit_error(int[] prices) {
        int left = 0;
        int right = 0;

        int min_price = Integer.MAX_VALUE;

        int max_profit = 0;

        //记录买入日
        for (int i = 0; i < prices.length - 1; i++) {
            if (min_price > prices[i]) {
                min_price = prices[i];
                left = i;
            }
        }
        //记录卖出日
        for (int j = left; j < prices.length; j++) {
            int profit = prices[j] - prices[left];
            if (profit > 0) {
                max_profit = Math.max(max_profit, profit);
                right = j;
            }
        }
        System.out.println("left:" + left + " right:" + right);
        return max_profit;
    }


    public static int maxProfit_best(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int price : prices) {
            if (price < minprice) {
                minprice = price;
            }
            if (price - minprice > maxprofit) {
                maxprofit = price - minprice;
            }
        }
        return maxprofit;
    }


    public static void main(String[] args) {
//        int[] nums = {7, 1, 5, 3, 6, 4};
//        int[] nums = {7, 6, 4, 3, 1};
//        int[] nums = {2, 4, 1};
        int[] nums = {3, 2, 6, 5, 0, 3};
//        System.out.println(maxProfit(nums));
        System.out.println(maxProfit_best(nums));
    }


}
