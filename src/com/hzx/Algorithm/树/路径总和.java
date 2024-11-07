package com.hzx.Algorithm.树;

import com.hzx.util.node.BinaryNode;


public class 路径总和 {

    // 主要方法，判断是否存在路径和等于 targetSum
    public boolean hasPathSum(BinaryNode<Integer> root, int targetSum) {
        if (root == null) {
            return false;
        }
        return hasPathSumHelper(root, targetSum);
    }

    // 辅助递归方法
    private boolean hasPathSumHelper(BinaryNode<Integer> node, int remainingSum) {
        if (node == null) {
            return false;
        }

        // 如果当前节点是叶子节点，检查剩余和是否为 0
        if (node.left == null && node.right == null) {
            return remainingSum - node.val == 0;
        }

        // 递归检查左子树和右子树
        return hasPathSumHelper(node.left, remainingSum - node.val) ||
                hasPathSumHelper(node.right, remainingSum - node.val);
    }

    public static void main(String[] args) {
        // 构建示例二叉树
        BinaryNode<Integer> root = new BinaryNode<>(5);
        root.left = new BinaryNode<>(4);
        root.right = new BinaryNode<>(8);
        root.left.left = new BinaryNode<>(11);
        root.left.left.left = new BinaryNode<>(7);
        root.left.left.right = new BinaryNode<>(2);
        root.right.left = new BinaryNode<>(13);
        root.right.right = new BinaryNode<>(4);
        root.right.right.right = new BinaryNode<>(1);

        路径总和 solution = new 路径总和();
        int targetSum = 22;
        boolean result = solution.hasPathSum(root, targetSum);
        System.out.println("Path exists with sum " + targetSum + ": " + result);
    }
}