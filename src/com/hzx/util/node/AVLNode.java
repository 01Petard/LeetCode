package com.hzx.util.node;

/**
 * 二叉平衡树节点
 */
public class AVLNode<T> extends BinaryNode<T> {
    public T val;
    public AVLNode<T> left;
    public AVLNode<T> right;
    public int height = 1; // 当前节点的高度

    public AVLNode(T val) {
        super(val);
    }

    public AVLNode(T val, AVLNode<T> left, AVLNode<T> right) {
        super(val, left, right);
    }

}
