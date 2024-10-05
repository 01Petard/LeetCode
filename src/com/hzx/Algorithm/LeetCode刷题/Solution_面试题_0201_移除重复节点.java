package com.hzx.Algorithm.LeetCode刷题;

import com.hzx.util.node.MyListNode;

import java.util.HashSet;
import java.util.Set;

/*
 * 原题链接：https://leetcode.cn/problems/string-rotation-lcci/
 */
public class Solution_面试题_0201_移除重复节点 {


    public static void main(String[] args) {
        MyListNode head = new MyListNode(1);
        head.addLast(1);
        head.addLast(1);
        head.addLast(1);
        head.addLast(2);
        MyListNode listNode = removeDuplicateNodes(head);
        listNode.printList();
    }


    static MyListNode removeDuplicateNodes(MyListNode head) {
        if (head == null) {
            return head;
        }
        Set<Integer> set = new HashSet<>();
        set.add((Integer) head.object);
        MyListNode pos = head;
        while (pos.next != null) {
            head.printList();
            if (set.add((Integer) pos.next.object)) {
                pos = pos.next;
            } else {
                pos.next = pos.next.next;
            }
        }
        pos.next = null;
        return head;
    }

}
