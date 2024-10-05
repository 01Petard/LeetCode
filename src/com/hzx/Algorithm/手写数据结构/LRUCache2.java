package com.hzx.Algorithm.手写数据结构;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU缓存机制（手写）
 */
public class LRUCache2 {

    //定义一个双向链表
    static class LinkedNode {
        int key;
        int value;
        LinkedNode prev;
        LinkedNode next;

        public LinkedNode() {
        }

        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, LinkedNode> cache = new LinkedHashMap<>();
    private final int capacity;
    private int size;
    private LinkedNode head, tail;


    public LRUCache2(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    //最重要的两个方法（1/2）
    public int get(int key) {
        LinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    //最重要的两个方法（2/2）
    public void put(int key, int value) {
        LinkedNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            LinkedNode newNode = new LinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                LinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        } else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(LinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(LinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(LinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private LinkedNode removeTail() {
        LinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }


    public static void main(String[] args) {
        LRUCache2 cache = new LRUCache2(3);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);

        System.out.println(cache.get(1)); // 返回 1
        cache.put(4, 4); // 这将使得 2 被淘汰

        System.out.println(cache.get(2)); // 返回 -1
        cache.put(5, 5); // 这将使得 3 被淘汰

        System.out.println(cache.get(1)); // 返回 1
        System.out.println(cache.get(3)); // 返回 -1
        System.out.println(cache.get(4)); // 返回 4
        System.out.println(cache.get(5)); // 返回 5
    }
}
