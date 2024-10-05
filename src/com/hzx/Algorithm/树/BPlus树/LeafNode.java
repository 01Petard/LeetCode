package com.hzx.Algorithm.树.BPlus树;

import java.util.ArrayList;
import java.util.List;

// 叶子节点类
public class LeafNode<K extends Comparable<K>, V> extends AbstractTreeNode<K, V> {
    private List<V> values;  // 叶子节点中的数据
    private LeafNode<K, V> next;  // 下一个叶子节点的指针

    public LeafNode(int maxKeys) {
        super(maxKeys);
        this.values = new ArrayList<>();
    }

    @Override
    public V search(K key) {
        int pos = binarySearch(key);
        if (pos >= 0 && pos < keys.size() && keys.get(pos).compareTo(key) == 0) {
            return values.get(pos);
        }
        return null;  // 未找到
    }

    // 二分查找
    private int binarySearch(K key) {
        int low = 0, high = keys.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = key.compareTo(keys.get(mid));
            if (cmp == 0) return mid;
            else if (cmp < 0) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }

    @Override
    public boolean isLeaf() {
        return true;
    }

    // 插入键值对
    public void insert(K key, V value) {
        int pos = binarySearch(key);
        if (pos < keys.size() && keys.get(pos).compareTo(key) == 0) {
            // 如果键已经存在，更新值
            values.set(pos, value);
        } else {
            // 插入键值对
            keys.add(pos, key);
            values.add(pos, value);
        }

        // 如果超出最大容量，返回分裂的新节点
        if (keys.size() > maxKeys) {
            split();
        }
    }

    // 分裂叶子节点
    public LeafNode<K, V> split() {
        int mid = keys.size() / 2;
        LeafNode<K, V> newNode = new LeafNode<>(maxKeys);

        // 将右半部分的键值对移动到新节点
        newNode.keys.addAll(keys.subList(mid, keys.size()));
        newNode.values.addAll(values.subList(mid, values.size()));

        keys.subList(mid, keys.size()).clear();
        values.subList(mid, values.size()).clear();

        // 更新链表指针
        newNode.next = this.next;
        this.next = newNode;

        return newNode;
    }

    // 删除键
    public void delete(K key) {
        int pos = binarySearch(key);
        if (pos >= 0 && pos < keys.size() && keys.get(pos).compareTo(key) == 0) {
            keys.remove(pos);
            values.remove(pos);
        }
    }
}
