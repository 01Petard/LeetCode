package com.hzx.Algorithm.线性表;

import com.hzx.util.node.ListNode;

public class 链表合并拆分 {
    /**
     * 合并两个排序的链表。
     * @param l1 第一个链表
     * @param l2 第二个链表
     * @return 合并后的链表
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // 如果其中一个链表已经为空，将另一个链表的剩余部分直接连接到当前节点后面
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        return dummy.next;
    }

    /**
     * 拆分链表，将奇数节点和偶数节点拆分成两个链表。
     * @param head 输入的链表头节点
     * @return 一个包含两个链表头节点的数组，第一个链表包含所有奇数节点，第二个链表包含所有偶数节点
     */
    public static ListNode[] splitListToParts(ListNode head) {
        ListNode oddDummy = new ListNode(0);
        ListNode evenDummy = new ListNode(0);
        ListNode oddCurrent = oddDummy;
        ListNode evenCurrent = evenDummy;
        ListNode current = head;
        int index = 1; // 用于区分奇数和偶数节点

        while (current != null) {
            if (index % 2 == 1) { // 奇数位置
                oddCurrent.next = current;
                oddCurrent = oddCurrent.next;
            } else { // 偶数位置
                evenCurrent.next = current;
                evenCurrent = evenCurrent.next;
            }
            current = current.next;
            index++;
        }

        // 设置链表结尾
        oddCurrent.next = null;
        evenCurrent.next = null;

        return new ListNode[]{oddDummy.next, evenDummy.next};
    }

    public static void main(String[] args) {
        // 创建一个示例链表
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // 拆分链表
        ListNode[] splitLists = splitListToParts(head);
        System.out.println("Odd List:");
        printList(splitLists[0]);
        System.out.println("Even List:");
        printList(splitLists[1]);

        // 合并两个链表
        ListNode mergedList = mergeTwoLists(splitLists[0], splitLists[1]);
        System.out.println("Merged List:");
        printList(mergedList);
    }

    private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}