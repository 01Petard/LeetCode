package com.hzx.util.node;

/**
 * 哈夫曼树节点
 */
public class HuffmanNode<T> extends BinaryNode<T> implements Comparable<HuffmanNode<T>> {
    public T val;
    public HuffmanNode<T> left;
    public HuffmanNode<T> right;
    public int frequency;

    public HuffmanNode(T val, int frequency) {
        super(val);
        this.val = val;  // 添加这一行
        this.frequency = frequency;
    }

    public HuffmanNode(HuffmanNode<T> left, HuffmanNode<T> right) {
        super(null, left, right);  // 将 val 设置为 null
        this.val = null;  // 合并节点不需要值
        this.frequency = left.frequency + right.frequency;
    }

    public HuffmanNode(T val, HuffmanNode<T> left, HuffmanNode<T> right) {
        super(val, left, right);
        this.val = val;
        this.left = left;
        this.right = right;
        this.frequency = left.frequency + right.frequency;
    }

    @Override
    public int compareTo(HuffmanNode<T> other) {
        return Integer.compare(this.frequency, other.frequency);
    }
}