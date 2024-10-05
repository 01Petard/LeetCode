package com.hzx.Algorithm.LeetCode刷题;

/*
 * 原题链接：https://leetcode.cn/problems/two-sum/description/
 * 2.两数相加
 * 给你两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * */


import com.hzx.util.node.MyListNode;

public class Solution_2_两数相加 {

    public MyListNode addTwoNumbers(MyListNode l1, MyListNode l2) {
        MyListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? (int) l1.object : 0;
            int n2 = l2 != null ? (int) l2.object : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new MyListNode(sum % 10);
            } else {
                tail.next = new MyListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new MyListNode(carry);
        }
        return head;
    }


    public static void main(String[] args) {
        MyListNode l1 = new MyListNode();
        MyListNode l2 = new MyListNode();
        l1.add(2);
        l1.add(4);
        l1.add(3);
        l2.add(5);
        l2.add(6);
        l2.add(4);
        System.out.println(new Solution_2_两数相加().addTwoNumbers(l1, l2));

    }
}






