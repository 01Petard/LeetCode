package com.hzx.util.node;

/**
 * 双向链表节点
 */
public class MyListNode {
    public Object object; //结点的值
    public MyListNode prior; //前一个结点
    public MyListNode next; //下一个结点

    public MyListNode() {
        this.prior = null;
        this.next = null;
    }

    public MyListNode(Object object) {
        this.object = object;
        this.prior = null;
        this.next = null;
    }

    public MyListNode(Object object, MyListNode prior, MyListNode next) {
        this.object = object;
        this.prior = prior;
        this.next = next;
    }

    public void add(Object object) {
        this.object = object;
        this.next = new MyListNode();
    }

    public void add(MyListNode curr, Object object) {
        curr.object = object;
        curr.next = new MyListNode();

    }

    // 添加一个新节点到链表的末尾
    public void addLast(Object object) {
        MyListNode newNode = new MyListNode(object);
        if (this.next == null) {
            // 如果链表为空，新节点就是第一个节点
            this.next = newNode;
            newNode.prior = this;
        } else {
            // 否则，找到链表的最后一个节点并添加新节点
            MyListNode current = this;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prior = current;
        }
    }

    // 添加一个新节点到链表的开头
    public void addFirst(int val) {
        MyListNode newNode = new MyListNode(val);
        if (this.next != null) {
            // 如果链表不为空，新节点就是第一个节点；否则，将新节点添加到链表的开头
            newNode.next = this.next;
            this.next.prior = newNode;
        }
        this.next = newNode;
        newNode.prior = this;
    }

    // 在当前节点之后添加一个新节点
    public void addAfter(Object object) {
        MyListNode newNode = new MyListNode(object);
        if (this.next != null) {
            newNode.next = this.next;
            this.next.prior = newNode;
            this.next = newNode;
            newNode.prior = this;
        } else {
            System.out.println("当前节点是链表的最后一个节点，无法在其后添加新节点。");
        }
    }

    // 删除当前节点
    public void deleteNode() {
        if (this.next != null && this.prior != null) {
            // 如果当前节点不是头节点也不是尾节点
            this.next.prior = this.prior;
            this.prior.next = this.next;
        } else if (this.next != null) {
            // 如果当前节点是头节点
            this.next.prior = null;
            this.next = null;
        } else {
            // 如果当前节点是尾节点，或者链表为空
            System.out.println("无法删除当前节点，因为它是链表的最后一个节点或链表为空。");
        }
    }

    // 打印链表中的所有节点值
    public void printList() {
        MyListNode currentNode = this; // 假设从当前节点开始遍历
        while (currentNode != null) {
            System.out.print(currentNode.object + " ");
            currentNode = currentNode.next;
        }
        System.out.println(); // 打印换行符以美观输出
    }

}

