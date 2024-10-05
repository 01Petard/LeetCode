package com.hzx.Algorithm.LeetCode刷题;

/*
 * 原题链接：https://leetcode.cn/problems/kth-node-from-end-of-list-lcci/description/
 */
public class Solution_面试题_0202_返回倒数第k个节点 {
    public static int kthToLast(ListNode head, int k) {
        ListNode cur = head, last = head;
        for (int i = 0; i < k; i++) {
            last = last.next;
            System.out.println(last.val);
        }
        while (last != null) {
            cur = cur.next;
            last = last.next;
        }
        return cur.val;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        System.out.println(kthToLast(head, 2));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
