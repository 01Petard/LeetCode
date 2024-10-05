package com.hzx.Algorithm.树.BPlus树;

import java.util.ArrayList;
import java.util.List;

// 定义B+树节点的抽象类
abstract class AbstractTreeNode<K extends Comparable<K>, V> {
    protected int maxKeys;  // 最大键值数
    protected List<K> keys;  // 保存节点中的键

    public AbstractTreeNode(int maxKeys) {
        this.maxKeys = maxKeys;
        this.keys = new ArrayList<>();
    }

    // 查找操作
    abstract V search(K key);

    // 判断是否为叶子节点
    abstract boolean isLeaf();
}


