package com.hzx.Algorithm.树;

import com.hzx.util.node.HuffmanNode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 哈夫曼树
 */
public class HuffmanTree {

    public static HuffmanNode<Character> buildHuffmanTree(Map<Character, Integer> frequencies) {
        PriorityQueue<HuffmanNode<Character>> priorityQueue = new PriorityQueue<>();

        for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            priorityQueue.offer(new HuffmanNode<>(entry.getKey(), entry.getValue()));
        }

        while (priorityQueue.size() > 1) {
            HuffmanNode<Character> left = priorityQueue.poll();
            HuffmanNode<Character> right = priorityQueue.poll();
            int mergedFrequency = left.frequency + right.frequency;

            HuffmanNode<Character> mergedNode = new HuffmanNode<>(null, mergedFrequency);
            mergedNode.left = left;
            mergedNode.right = right;

            priorityQueue.offer(mergedNode);
        }

        return priorityQueue.poll();
    }

    public static Map<Character, String> encode(HuffmanNode<Character> node, String code, Map<Character, String> codes) {
        if (node != null) {
            if (node.val != null) {
                codes.put(node.val, code);
            } else {
                encode(node.left, code + "0", codes);
                encode(node.right, code + "1", codes);
            }
        }
        return codes;
    }

    public static int calculateWPL(HuffmanNode<Character> node, int depth) {
        if (node == null) {
            return 0;
        }
        if (node.val != null) {
            return node.frequency * depth;
        }
        return calculateWPL(node.left, depth + 1) + calculateWPL(node.right, depth + 1);
    }

    public static Map<Character, Integer> calculateFrequencies(String str) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (char ch : str.toCharArray()) {
            frequencies.put(ch, frequencies.getOrDefault(ch, 0) + 1);
        }
        return frequencies;
    }

    public static String decode(HuffmanNode<Character> root, String encodedString) {
        StringBuilder decodedString = new StringBuilder();
        HuffmanNode<Character> currentNode = root;

        // 逐位读取编码：从编码字符串中逐位读取每个比特（0 或 1）。
        for (char bit : encodedString.toCharArray()) {
            // 如果读取到 0，就向左子树移动；如果读取到 1，就向右子树移动。
            currentNode = (bit == '0') ? currentNode.left : currentNode.right;

            if (currentNode.val != null) {
                // 找到叶子节点。
                // 当前节点是叶子节点时，表示找到了一个字符。
                // 将该字符记录下来，并重置当前节点回到树的根节点，继续读取下一个比特。
                decodedString.append(currentNode.val);
                currentNode = root; // 重置为根节点
            }
        }
        return decodedString.toString();
    }

    public static int calculateOriginalSize(String str) {
        // 每个字符占用16位
        return str.length() * Character.SIZE;
    }

    public static int calculateEncodedSize(String encodedString) {
        // 编码后的字符串占用的位数
        return encodedString.length();
    }

    public static double calculateCompressionRate(int originalSize, int encodedSize) {
        // 压缩率计算公式
        return (1 - (double) encodedSize / originalSize) * 100;
    }

    public static String serializeHuffmanTree(HuffmanNode<Character> root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private static void serializeHelper(HuffmanNode<Character> node, StringBuilder sb) {
        if (node == null) {
            sb.append("#");
            return;
        }
        sb.append(node.val != null ? node.val : "*");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    public static HuffmanNode<Character> deserializeHuffmanTree(String data) {
        int[] index = {0};
        return deserializeHelper(data, index);
    }

    private static HuffmanNode<Character> deserializeHelper(String data, int[] index) {
        if (index[0] >= data.length()) return null;
        char ch = data.charAt(index[0]++);
        if (ch == '#') return null;

        HuffmanNode<Character> node = new HuffmanNode<>(ch, 0);
        node.left = deserializeHelper(data, index);
        node.right = deserializeHelper(data, index);
        return node;
    }


    public static void main(String[] args) {
        String str = "ABRACADABRA";

        Map<Character, Integer> frequencies = calculateFrequencies(str);

        HuffmanNode<Character> root = buildHuffmanTree(frequencies);

        Map<Character, String> codes = encode(root, "", new HashMap<>());

        System.out.print("字符及其哈夫曼编码：");
        codes.forEach((ch, code) -> System.out.print(ch + ": " + code + ", "));
        System.out.println();

        int wpl = calculateWPL(root, 0);
        System.out.println("哈夫曼树的带权路径长度 WPL: " + wpl);

        StringBuilder encodedString = new StringBuilder();
        for (char ch : str.toCharArray()) {
            encodedString.append(codes.get(ch));
        }
        System.out.println("编码后的最短编码: " + encodedString);

        // 解码编码后的字符串
        String decodedString = decode(root, encodedString.toString());
        System.out.println("解码后的字符串: " + decodedString);

        // 计算占用长度和压缩率
        int originalSize = calculateOriginalSize(str);
        int encodedSize = calculateEncodedSize(encodedString.toString());
        double compressionRate = calculateCompressionRate(originalSize, encodedSize);

        System.out.println("编码前占用长度: " + originalSize + " 位");
        System.out.println("编码后占用长度: " + encodedSize + " 位");
        System.out.printf("压缩率: %.2f%%\n", compressionRate);
    }

}
