package com.hzx.ZZZ笔试;

import java.util.*;

class Solution {

    public int find(int[] nums) {

        int[] bitSum = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bitSum[i] += (num >> i) & 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result |= (bitSum[i] % 3) << i;
        }
        return result;
    }
}

public class haikang_mianshi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        System.out.println(new Solution().find(nums));

    }
}
