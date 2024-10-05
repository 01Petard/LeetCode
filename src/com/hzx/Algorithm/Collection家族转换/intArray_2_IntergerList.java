package com.hzx.Algorithm.Collection家族转换;

import java.util.Arrays;
import java.util.List;

public class intArray_2_IntergerList {
    public static void main(String[] args) {

        int[] nums = {5, 2, 1, 4, 3};

        // 装箱
        Integer[] array = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        // 将数组转换为List
        List<Integer> list1 = Arrays.asList(array);

        // 用 Stream API 将数组转换为List
        List<Integer> list2 = Arrays.stream(nums).boxed().toList();

    }
}
