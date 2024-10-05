package com.hzx.Algorithm.数学问题;

import com.hzx.util.data.RandomNumGenerator;

import java.util.Arrays;
import java.util.Scanner;


/**
 * 搜索算法
 */
public class Search {

    /**
     * 二分查找，自定义查找的开始位置和结束位置
     * @param R    待查找数组
     * @param low  开始位置
     * @param high 结束位置
     * @param key  查找关键字
     * @return 返回关键字的下标
     */
    public static int BinSearch(int[] R, int key, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key == R[mid]) {
                return mid;
            } else if (key < R[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找，查找整个数组
     * @param R   待查找数组
     * @param key 查找关键字
     * @return 返回关键字的下标
     */
    public static int BinSearch(int[] R, int key) {
        return BinSearch(R, key, 0, R.length - 1);
    }


    public static void main(String[] args) {

        int[] nums = RandomNumGenerator.rangeArray();
        Arrays.sort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }

        System.out.println("\n请输入你要查找的关键字：");
        Scanner s = new Scanner(System.in);
        int key = s.nextInt();
        s.close();
        System.out.println("待查找关键字" + key + "的下标是：" + BinSearch(nums, key));
        System.out.println("待查找关键字" + key + "的下标是：" + BinSearch(nums, key));

    }

}
