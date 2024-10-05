package com.hzx.Algorithm.排序算法;

import com.hzx.util.data.RandomNumGenerator;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static com.hzx.Algorithm.排序算法.HeapSort.HeapSort;
import static com.hzx.Algorithm.排序算法.MergeSort.MergeSort;
import static com.hzx.Algorithm.排序算法.QuickSort.QuickSort_optimized;
import static com.hzx.Algorithm.排序算法.不常见.BucketFlashSort.BucketFlashSort;
import static com.hzx.Algorithm.排序算法.不常见.BucketSort.BucketSort;
import static com.hzx.Algorithm.排序算法.不常见.PigeonholeSort.PigeonholeSort;
import static com.hzx.Algorithm.排序算法.不常见.RadixSort.RadixSort_optimized;
import static com.hzx.Algorithm.排序算法.不常见.TimSort.TimSort;

public class SortAlgorithmsRanking {

    static final ExecutorService tpe = Executors.newFixedThreadPool(10);

    private static void test_performance() {
        // 快速初始化一个数组
        int[] nums = RandomNumGenerator.rangeArray(-10000, 10000, 100000000, "1");

        // 存储任务的 Future 对象
        List<Future<?>> futures = new ArrayList<>();
        Map<String, Long> results = new HashMap<>();

        // 测试比较慢的排序算法
//        futures.add(testSortAlgorithm("冒泡排序", () -> BobSort_optimized(Arrays.copyOf(nums, nums.length))));
//        futures.add(testSortAlgorithm("鸡尾酒排序", () -> CocktailSort(Arrays.copyOf(nums, nums.length))));
//        futures.add(testSortAlgorithm("地精排序", () -> GnomeSort(Arrays.copyOf(nums, nums.length))));
//        futures.add(testSortAlgorithm("选择排序", () -> SelectSort_optimized(Arrays.copyOf(nums, nums.length))));
//        futures.add(testSortAlgorithm("插入排序", () -> InsertSort_optimized(Arrays.copyOf(nums, nums.length))));

        // 测试比较快的排序算法
        futures.add(testSortAlgorithm("桶排序", () -> BucketSort(Arrays.copyOf(nums, nums.length))));
        futures.add(testSortAlgorithm("堆排序", () -> HeapSort(Arrays.copyOf(nums, nums.length))));
        futures.add(testSortAlgorithm("闪电桶排序", () -> BucketFlashSort(Arrays.copyOf(nums, nums.length))));
        futures.add(testSortAlgorithm("归并排序", () -> MergeSort(Arrays.copyOf(nums, nums.length))));
        futures.add(testSortAlgorithm("Tim排序", () -> TimSort(Arrays.copyOf(nums, nums.length))));
        futures.add(testSortAlgorithm("快速排序", () -> QuickSort_optimized(Arrays.copyOf(nums, nums.length))));

        // 测试非常快的排序算法
        futures.add(testSortAlgorithm("鸽巢排序", () -> PigeonholeSort(Arrays.copyOf(nums, nums.length))));
        futures.add(testSortAlgorithm("计数排序", () -> RadixSort_optimized(Arrays.copyOf(nums, nums.length))));


        // 等待所有排序任务完成
        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        tpe.shutdown();
    }

    private static Future<?> testSortAlgorithm(String name, Runnable sortAlgorithm) {
        return tpe.submit(() -> {
            long startTime = System.currentTimeMillis();
            sortAlgorithm.run();
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            System.out.println(name + " 运行时间（毫秒）：" + duration + " ms");
        });
    }


    public static void main(String[] args) {
        test_performance();
    }
}