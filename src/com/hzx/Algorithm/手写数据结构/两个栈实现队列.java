package com.hzx.Algorithm.手写数据结构;

import java.util.Stack;

public class 两个栈实现队列 {

    private Stack<Integer> stackA; // 用于入队
    private Stack<Integer> stackB; // 用于出队

    public 两个栈实现队列() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    // 入队操作
    public void enqueue(int value) {
        stackA.push(value);  // 将元素压入 stackA
    }

    // 出队操作
    public int dequeue() {
        if (stackB.isEmpty()) {
            // 如果 stackB 为空，则将 stackA 中的元素依次弹出并压入 stackB
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
        }
        // 返回并弹出 stackB 的顶部元素
        return stackB.pop();
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return stackA.isEmpty() && stackB.isEmpty();
    }

    // 获取队列的大小
    public int size() {
        return stackA.size() + stackB.size();
    }

    public static void main(String[] args) {
        两个栈实现队列 queue = new 两个栈实现队列();

        System.out.println(queue.isEmpty()); // 输出 true
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue()); // 输出 1
        System.out.println(queue.dequeue()); // 输出 2
        queue.enqueue(4);
        System.out.println(queue.dequeue()); // 输出 3
        queue.enqueue(5);
        queue.enqueue(6);
        System.out.println(queue.size()); // 输出 3
        System.out.println(queue.isEmpty()); // 输出 false
    }
}
