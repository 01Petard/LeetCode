package com.hzx.Algorithm.树;

import com.hzx.util.node.BinaryNode;

import java.util.*;

/**
 * 二叉树
 */
public class BinaryTree {

    // 查找
    public static BinaryNode<Integer> search(BinaryNode<Integer> root, int key) {
        if (root == null || root.val == key) {
            return root;
        }

        if (key < root.val) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    // 插入新节点
    public static BinaryNode<Integer> insert(BinaryNode<Integer> root, int data) {
        if (root == null) {
            return new BinaryNode<>(data);
        }

        if (data <= root.val) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    // 批量插入新节点
    public static void insertBatch(BinaryNode<Integer> root, List<Integer> datas) {
        datas.forEach(data -> insert(root, data));
    }

    // 批量插入新节点
    public static void insertBatch(BinaryNode<Integer> root, int[] datas) {
        insertBatch(root, Arrays.stream(datas).boxed().toList());
    }

    // 删除节点
    public static BinaryNode<Integer> delete(BinaryNode<Integer> root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = delete(root.left, key);
        } else if (key > root.val) {
            root.right = delete(root.right, key);
        } else {
            // 找到了要删除的节点
            if (root.left == null) {
                // 如果没有左子节点或没有子节点，则返回右子节点
                return root.right;
            } else if (root.right == null) {
                // 如果没有右子节点，则返回左子节点
                return root.left;
            }

            // 如果有两个子节点，则找到右子树中的最小节点（即后继节点）
            root.val = searchMin(root.right).val;

            // 删除找到的后继节点
            root.right = delete(root.right, root.val);
        }

        return root;
    }

    // 查找子树中的最小值节点
    private static BinaryNode<Integer> searchMin(BinaryNode<Integer> root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static BinaryNode<Integer> update(BinaryNode<Integer> root, Integer key, Integer val) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = update(root.left, key, val); // 如果 key 小于当前节点的值，则递归左子树
        } else if (key > root.val) {
            root.right = update(root.right, key, val); // 如果 key 大于当前节点的值，则递归右子树
        } else {
            // 找到了要更新的节点
            root.val = val; // 更新节点的值
        }

        return root;
    }

    // 查找节点是否存在
    public static boolean contains(BinaryNode<Integer> root, int data) {
        return search(root, data) != null;
    }


    // 前序遍历  （根-左-右）
    private static void preOrder(BinaryNode<Integer> root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // 中序遍历  （左-根-右）
    private static void inOrder(BinaryNode<Integer> root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }

    // 后序遍历  （左-右-根）
    private static void postOrder(BinaryNode<Integer> root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + " ");
        }
    }

    // 层次遍历
    public static List<List<Integer>> levelOrder(BinaryNode<Integer> root) {
        // 层次遍历的结果集
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 等待遍历的节点队列
        Queue<BinaryNode<Integer>> queue = new LinkedList<>();
        // 首次遍历的节点是根节点
        queue.add(root);
        // 一直遍历到所有节点的叶子节点
        while (!queue.isEmpty()) {
            // 当前层的遍历结果集
            List<Integer> level = new ArrayList<>();
            // 当前层的节点数量
            int size = queue.size();
            // 遍历当前层的所有节点
            for (int i = 0; i < size; i++) {
                BinaryNode<Integer> node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(level);
        }
        return result;
    }

    //翻转二叉树
    public static BinaryNode<Integer> invertTree(BinaryNode<Integer> root) {
        if (root == null) {
            return null;
        }

        // 交换左右子树
        BinaryNode<Integer> temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }

    public static void main(String[] args) {
        BinaryNode<Integer> root = new BinaryNode<>(5);
        insertBatch(root, new int[]{3, 7, 2, 4, 6, 8});
        test_order(root);
        test_delete(root);
        test_invert(root);
    }

    private static void test_order(BinaryNode<Integer> root) {
        BinaryNode<Integer> temp = root;

        System.out.println("+++++++++++是否存在+++++++++++");
        System.out.println(contains(temp, 4));
        System.out.println(contains(temp, 0));


        System.out.println("+++++++++++++遍历+++++++++++++");
        preOrder(temp); // 输出: 5 3 2 4 7 6 8
        System.out.println();
        inOrder(temp); // 输出: 2 3 4 5 6 7 8
        System.out.println();
        postOrder(temp); // 输出: 2 4 3 6 8 7 5
        System.out.println();
        List<List<Integer>> lists = levelOrder(temp);
        lists.forEach(System.out::print); // 输出: [5], [3, 7], [2, 4, 6, 8]
        System.out.println();
    }

    private static void test_delete(BinaryNode<Integer> root) {
        BinaryNode<Integer> temp = root;

        System.out.println("+++++++++++++删除+++++++++++++");
        delete(temp, 5);
        inOrder(temp); // 输出: 2 3 4 6 7 8
        System.out.println();
    }

    private static void test_invert(BinaryNode<Integer> root) {
        BinaryNode<Integer> temp = root;

        System.out.println("+++++++++++++翻转+++++++++++++");
        invertTree(temp);
        inOrder(temp); // 输出翻转后的二叉树: 8 7 6 5 4 3 2
        System.out.println();
    }
}
