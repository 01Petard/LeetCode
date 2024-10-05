package com.hzx.Algorithm.LeetCode刷题;


/*
 * 原题链接：https://leetcode-cn.com/problems/replace-the-substring-for-balanced-string/
 * 1234.替换子串得到平衡字符串
 * 给定一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串，
 * 如果每个字符出现频率相等，这就是一个"平衡字符串"，
 * 如果不符就"替换一个子串"，使其变成"平衡字符串"。
 * 请返回待替换子串的最小可能长度。
 * 如果原字符串自身就是一个平衡字符串，则返回 0。
 * */

public class Solution_1234_替换子串得到平衡字符串 {
    public int balancedString(String s) {
        /*
        统计字符个数
        然后将字符个数超过 n / 4 的字符通过滑动窗口找出来

        因为少的字符必定是从多的字符修改过来的，那么我们只需要找到多出来的字符所构成的最短的子串即可
        比如 "WQWRQQQW"
        W 有 3 个，那么多出 1 个
        Q 有 4 个，那么多出 2 个
        多出的这几个都需要修改成 E 和 R
        我们只需要找到包含 1 个 W 和 2 个 Q 的最短子串即可
        */

        char[] chs = s.toCharArray();
        int time = s.length() / 4;

        //统计四种字符的个数
        int[] charNum = new int[97];
        for(char ch : chs)charNum[ch]++;

        //如果个数都是 len / 4，那么无需修改
        if(charNum['Q'] == time && charNum['W'] == time && charNum['E'] == time)return 0;

        //sum 是总的需要找到的字符个数
        int sum = helper(charNum, time);

        //以下为滑动窗口

        int valid = 0;

        int[] have = new int[97];
        int left = 0;
        int right = 0;

        int minLen = Integer.MAX_VALUE;
        while(right < s.length()){
            char ch = chs[right];
            right++;

            if(have[ch] < charNum[ch])valid++;

            have[ch]++;

            while(valid == sum){
                minLen = Math.min(right - left, minLen);
                ch = chs[left];
                have[ch]--;
                if(have[ch] < charNum[ch])valid--;
                left++;
            }
        }
        return minLen;
    }
    /*
    统计每个字符多出的个数总数
    */
    private int helper(int[] charNum, int time){
        int sum = 0;
        for(char ch : "QWER".toCharArray()){
            if(charNum[ch] > time){
                charNum[ch] -= time;
                sum += charNum[ch];//sum加上多出来的字符个数
            }else{
                charNum[ch] = 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution_1234_替换子串得到平衡字符串 solution_1234 = new Solution_1234_替换子串得到平衡字符串();
        System.out.println(solution_1234.balancedString("WWEQERQWQWWRWWERQWEQ"));
    }
}

