package com.hzx.Algorithm.线性表;

import com.hzx.util.node.ListNode;

public class 链表反转 {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null; // 用于指向反转后的前一个节点
        ListNode curr = head; // 当前节点
        ListNode next; // 用于暂存当前节点的下一个节点

        while (curr != null) {
            next = curr.next; // 暂存当前节点的下一个节点
            curr.next = prev; // 将当前节点的 next 指向前一个节点
            prev = curr; // 移动 prev 指针
            curr = next; // 移动 curr 指针
        }
        return prev; // 返回反转后的头节点
    }

    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode listNode = reverseList2(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
