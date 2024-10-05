package com.hzx.util.node;

/**
 * 二叉树节点
 */
public class BinaryNode<T> {
    public T val;
    public BinaryNode<T> left;
    public BinaryNode<T> right;


    public BinaryNode(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public BinaryNode(T val, BinaryNode<T> left, BinaryNode<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
