package com.hzx.Algorithm.排序算法;

import java.util.Random;
import java.util.Stack;

public class QuickSort extends swap {
    /**
     * 快速排序，自定义排序的开始位置和结束位置
     * @param R    待排序数组
     * @param low  开始位置
     * @param high 结束位置
     */
    public static void QuickSort(int[] R, int low, int high) {
        int i = low, j = high, temp;
        if (low < high) {
            temp = R[low];
            while (i < j) {
                while (i < j && temp < R[j]) --j;
                if (i < j) {
                    R[i] = R[j];
                    ++i;
                }
                while (i < j && temp > R[i]) ++i;
                if (i < j) {
                    R[j] = R[i];
                    --j;
                }
            }
            R[i] = temp;
            QuickSort(R, low, i - 1);
            QuickSort(R, i + 1, high);
        }
    }

    /**
     * 快速排序，排序整个数组
     * @param R 待排序数组
     */
    public static void QuickSort(int[] R) {
        QuickSort(R, 0, R.length - 1);
    }



    private static void QuickSort_optimized(int[] R, int low, int high) {
        if (low < high) {
            int pivot = getPartition(R, low, high);
            QuickSort_optimized(R, low, pivot - 1);
            QuickSort_optimized(R, pivot + 1, high);
        }
    }

    private static int getPartition(int[] R, int low, int high) {
        int i = low;
        int j = high;
        int tmp = R[low];
        while (i < j) {
            while (i < j && R[j] > tmp) {
                j--;
            }
            if (i < j) {
                R[i] = R[j];
                i++;
            }
            while (i < j && R[i] < tmp) {
                i++;
            }
            if (i < j) {
                R[j] = R[i];
                j--;
            }
        }
        R[i] = tmp;
        return i;
    }

    public static void QuickSort_optimized(int[] R) {
        QuickSort_optimized(R, 0, R.length - 1);
    }



    /**
     * 非递归快速排序
     * 优化操作：
     * 1、优化递归：当前实现使用了递归来对分割后的子数组进行排序，但是递归深度可能会很大，导致栈溢出。可以使用非递归的方式来实现快速排序，使用一个栈或者队列来模拟递归的过程。
     * 2、优化划分点选择：当前实现中，划分点选择的方式是选取子数组的第一个元素，这可能导致最坏情况的发生。可以采用更加合理的方式选择划分点，如取中值或者随机选择。
     * 3、优化对于已经有序数组的性能：当前实现对于已经有序的数组或者部分有序数组的性能不佳。可以在划分阶段对数组进行预处理，例如使用三数取中法等方式来避免最坏情况的发生。
     * @param R 待排序数组
     */
    public static void QuickSort_alternative(int[] R, int low, int high) {
        Stack<Integer> stack = new Stack<>();
        stack.push(low);
        stack.push(high);

        Random rand = new Random();

        while (!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();

            if (low < high) {
                int pivotIndex = partition(R, low, high, rand);

                if (pivotIndex - 1 > low) {
                    stack.push(low);
                    stack.push(pivotIndex - 1);
                }

                if (pivotIndex + 1 < high) {
                    stack.push(pivotIndex + 1);
                    stack.push(high);
                }
            }
        }
    }

    /**
     * 划分操作：将数组分割成两部分，并返回划分点的索引
     * @param R    待排序数组
     * @param low  划分的起始位置
     * @param high 划分的结束位置
     * @param rand 随机数生成器
     * @return 划分点的索引
     */
    private static int partition(int[] R, int low, int high, Random rand) {
        int pivotIndex = low + rand.nextInt(high - low + 1);
        int pivotValue = R[pivotIndex];
        swap(R, pivotIndex, high);

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (R[j] < pivotValue) {
                i++;
                swap(R, i, j);
            }
        }

        swap(R, i + 1, high);
        return i + 1;
    }

    /**
     * 快速排序，使用随机数生成器来优化划分点选择
     * @param R 待排序数组
     */
    public static void QuickSort_alternative(int[] R) {
        QuickSort_alternative(R, 0, R.length - 1);
    }
}
