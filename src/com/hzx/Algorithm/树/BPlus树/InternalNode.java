package com.hzx.Algorithm.树.BPlus树;

import java.util.ArrayList;
import java.util.List;

// 内部节点类
public class InternalNode<K extends Comparable<K>, V> extends AbstractTreeNode<K, V> {
    private List<AbstractTreeNode<K, V>> childrenNodes;  // 孩子节点

    public InternalNode(int maxKeys) {
        super(maxKeys);
        this.childrenNodes = new ArrayList<>();
    }

    @Override
    public V search(K key) {
        int pos = binarySearch(key);
        return childrenNodes.get(pos).search(key);
    }

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
        return false;
    }

    // 插入内部节点逻辑略
}