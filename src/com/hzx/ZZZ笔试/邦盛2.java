package com.hzx.ZZZ笔试;

import java.util.Arrays;
import java.util.List;

public class 邦盛2 {
    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(50, 55, 56, 57, 58);
        int t = 163;
        int k = 3;
        System.out.println(chooseBestSum(t, k, ls)); // Output: 163

        ls = Arrays.asList(50);
        t = 163;
        k = 3;
        System.out.println(chooseBestSum(t, k, ls)); // Output: 0

        ls = Arrays.asList(91, 74, 73, 85, 73, 81, 87);
        t = 230;
        k = 3;
        System.out.println(chooseBestSum(t, k, ls)); // Output: 228
    }

    public static int chooseBestSum(int t, int k, List<Integer> ls) {
        if (ls == null || ls.size() < k) {
            return 0;
        }

        return backtrack(ls, 0, 0, k, t);
    }

    private static int backtrack(List<Integer> ls, int start, int currentSum, int remaining, int maxSum) {
        if (remaining == 0) {
            return currentSum <= maxSum ? currentSum : 0;
        }

        int bestSum = 0;
        for (int i = start; i < ls.size(); i++) {
            int nextSum = currentSum + ls.get(i);
            if (nextSum <= maxSum) {
                bestSum = Math.max(bestSum, backtrack(ls, i + 1, nextSum, remaining - 1, maxSum));
            }
        }

        return bestSum;
    }
}