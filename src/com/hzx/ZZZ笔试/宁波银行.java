package com.hzx.ZZZ笔试;

import java.util.*;

//给定一个字符串，统计每个字符出现的次数
public class 宁波银行 {
    public static void main(String[] args) {
        String input1 = "tree";
        String result1 = frequencySort(input1);
        System.out.println(result1); // 输出 "eert"

        String input2 = "cccaaa";
        String result2 = frequencySort(input2);
        System.out.println(result2); // 输出 "aaaccc"

        String input3 = "Aabb";
        String result3 = frequencySort(input3);
        System.out.println(result3); // 输出 "bbAa"
    }

    public static String frequencySort(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        // 统计每个字符出现的次数
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // 将字符及其频率放入优先队列中，按频率降序排序，频率相同则按字典顺序排序
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> {
                    if (!a.getValue().equals(b.getValue())) {
                        return b.getValue() - a.getValue(); // 按频率降序
                    } else {
                        return a.getKey().compareTo(b.getKey()); // 按字典顺序升序
                    }
                }
        );

        maxHeap.addAll(frequencyMap.entrySet());

        // 构建结果字符串
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                result.append(entry.getKey());
            }
        }

        return result.toString();
    }

}


class 宁波银行11 {
    public static void main(String[] args) {
        String input1 = "tree";
        System.out.println(frequencySort(input1));

        String input2 = "cccaaa";
        System.out.println(frequencySort(input2));

        String input3 = "Aabb";
        System.out.println(frequencySort(input3));
    }

    public static Map<Character, Integer> frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }


}

class 宁波银行2{
    public static void main(String[] args) {
        String input = "tree";
        List<Map.Entry<Character, Integer>> result = getCharacterFrequencies(input);
        printFrequencies(result);
    }

    public static List<Map.Entry<Character, Integer>> getCharacterFrequencies(String s) {
        if (s == null || s.isEmpty()) {
            return Collections.emptyList();
        }

        // 统计每个字符出现的次数
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // 将字符及其频率放入优先队列中，按频率降序排序，频率相同则按字典顺序排序
        PriorityQueue<Map.Entry<Character, Integer>> heap = new PriorityQueue<>(
                (a, b) -> {
                    if (!a.getValue().equals(b.getValue())) {
                        return b.getValue() - a.getValue(); // 按频率降序
                    } else {
                        return a.getKey().compareTo(b.getKey()); // 按字典顺序升序
                    }
                }
        );

        heap.addAll(frequencyMap.entrySet());
        System.out.println(heap);

        // 将优先队列中的元素转换为列表
        List<Map.Entry<Character, Integer>> sortedList = new ArrayList<>();
        while (!heap.isEmpty()) {
            sortedList.add(heap.poll());
        }

        return sortedList;
    }

    public static void printFrequencies(List<Map.Entry<Character, Integer>> frequencies) {
        for (Map.Entry<Character, Integer> entry : frequencies) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}