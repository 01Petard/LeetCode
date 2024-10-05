package com.hzx.Algorithm.数学问题;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class 寻找TopK数字 {

    /**
     * 找出数据流中的前 K 大的元素。
     * @param data 数据流
     * @param k    要找出的最大元素的数量
     * @return 前 K 大的元素
     */
    public static int[] findTopK(int[] data, int k) {
        if (k > data.length) throw new IllegalArgumentException("K 大于数据流长度");

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k); // 创建一个小顶堆，大小为 k
        // 遍历数据流
        for (int num : data) {
            if (minHeap.size() < k) {
                // 如果堆的大小还没有达到 k，直接加入元素
                minHeap.offer(num);
            } else {
                // 如果当前元素大于堆顶元素，则替换堆顶元素
                if (num > minHeap.peek()) {
                    minHeap.poll(); // 移除堆顶元素
                    minHeap.offer(num); // 加入当前元素
                }
            }
        }

        // 将堆转换为数组
        return IntStream.range(0, k)
                .map(topK -> minHeap.poll())
                .toArray();
    }


    // 暴力排序法
    public static int[] findTopK2(int[] nums, int k) {
        if (k > nums.length) throw new IllegalArgumentException("K 大于数据流长度");

        Arrays.sort(nums);  // 升序排列
        int[] result = new int[k];
        System.arraycopy(nums, nums.length - k, result, 0, k);  // 取最后k个最大数
        return result;
    }


    public static void main(String[] args) {

        int k = 100;

        int[] data = {1, 11, 3, 4, 5, 6, 7, 8, 9, 10, 2, 12, 13, 14, 15, 100, 1, 555};

        // 找出前 K 大的元素
        int[] topKElements = findTopK(data, k);
//        int[] topKElements = findTopK2(data, k);


        // 输出结果
        System.out.print("Top " + k + " elements: ");
        for (int num : topKElements) {
            System.out.print(num + " ");
        }
    }
}