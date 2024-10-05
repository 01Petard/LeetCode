package com.hzx.Algorithm.树.BPlus树;

// B+树类
public class BPlusTree<K extends Comparable<K>, V> {
    private AbstractTreeNode<K, V> root;
    private int maxKeys;  // B+树的阶数

    public BPlusTree(int maxKeys) {
        this.maxKeys = maxKeys;
        this.root = new LeafNode<>(maxKeys);  // 初始为叶子节点
    }

    // 查找操作
    public V search(K key) {
        return root.search(key);
    }

    // 插入操作
    public void insert(K key, V value) {
        LeafNode<K, V> newNode = ((LeafNode<K, V>) root);
        if (newNode != null) {
            // 处理根节点分裂的情况，略
        }
    }

    // 删除操作
    public void delete(K key) {
        ((LeafNode<K, V>) root).delete(key);
        // 处理根节点删除后的调整，略
    }
}