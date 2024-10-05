package com.hzx.util.data;

import java.util.Arrays;
import java.util.List;

public class RandomNumGenerator {

    public static void printList(int[] nums, int maxElementsToPrint) {
        List<Integer> list = Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new));

        if (list.size() <= maxElementsToPrint) {
            for (Object object : list) {
                System.out.print(object + " ");
            }
        } else {
            for (int i = 0; i < maxElementsToPrint; i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println(" ...");
        }
    }

    public static int[] rangeArray(int min, int max, int length, String repeat) {
        return generateArray(min, max, length, repeat);
    }

    /**
     * 返回一个随机数组
     * @param repeat 0:不能出现重复数字；1:可以出现重复数字
     */
    public static int[] rangeArray(String repeat) {
        return generateArray(0, 10, 5, repeat);
    }


    //返回一个不重复的随机数组
    public static int[] rangeArray() {
        return generateArray(0, 10, 5, "0");
    }

    /**
     * 获得一个随机数组
     * @param min    最小值
     * @param max    最大值
     * @param length 长度（即生成随机数的个数，数组下标是0～length-1）
     * @param repeat 是否允许重复，"0"不重复，"1"可以重复，不填默认"0"不重复
     * @return 随机数组
     */
    public static int[] generateArray(int min, int max, int length, String repeat) {
        if (min > max) {
            return null;
        }
        if (length > (max - min + 1) && repeat.equals("0")) {
            return null;
        }
        int[] arr = new int[length];
        //repeat==0表示不能出现重复
        if (repeat.equals("0")) {
            int count = 0;//count表示当前的数组下标
            while (count < length) {
                int num = (int) (Math.random() * (max - min)) + min;//随机数
                boolean flag = true;
                for (int j = 0; j < length; j++) {//for循环用来遍历之前的数组和num比较，判断num是否是重复的数字
                    if (num == arr[j]) {
                        flag = false;//说明随机到了一个重复的数字，num这个数出现过了
                        break;//随机到重复的数字会打破这层for循环，flag==false使得下面的if方法也不会执行。因此之后会在while中再循环一个随机数num，直到一个不重复的数字出现为止
                    }
                }
                if (flag) {//只有当上面的for循环里的语句不执行，即数字没重复时，才会执行一下语句
                    arr[count] = num;//说明这个随机数没重复，可以添加到数组中
                    count++;
                }
            }
        }
        //repeat==1表示可以出现重复
        if (repeat.equals("1")) {
            for (int i = 0; i < length; i++) {
                int num = (int) (Math.random() * (max - min)) + min;//随机数
                arr[i] = num;
            }
        }
        return arr;
    }

}
