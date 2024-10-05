package com.hzx.Algorithm;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 荷兰三色旗问题
 */

public class DutchNationalFlag {

    public static void sort(int[] array) {
        int cur = 0;
        int one = 0;
        int two = array.length - 1;
        while (cur <= two) {
            switch (array[cur]) {
                case 0 -> {
                    swap(array, one, cur);
                    one++;
                    cur++;
                }
                case 1 -> {
                    cur++;
                }
                case 2 -> {
                    swap(array, cur, two);
                    two--;
                }
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void sort2(int[] array){
        int[] sorted = IntStream.of(array)
                .parallel()
                .boxed()
                .sorted((a, b) -> {
                    if (a.equals(b)) return 0;
                    else if (a == 0) return -1;
                    else if (b == 0) return 1;
                    else if (a == 1) return -1;
                    else if (b == 1) return 1;
                    else return 1;
                })
                .mapToInt(Integer::intValue)
                .toArray();
        System.arraycopy(sorted, 0, array, 0, sorted.length);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 0, 2, 1, 2, 1, 0, 1, 0, 2, 1};
        sort(array);
//        sort2(array);
        System.out.println(Arrays.toString(array));
    }
}
