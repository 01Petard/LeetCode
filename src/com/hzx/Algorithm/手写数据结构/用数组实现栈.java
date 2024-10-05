package com.hzx.Algorithm.手写数据结构;

import java.util.Arrays;

public class 用数组实现栈<K> {
    private K[] storage;//存放栈中元素的数组
    private int capacity;//栈的容量
    private int count;//栈中元素数量
    private static final int GROW_FACTOR = 2;

    //不带初始容量的构造方法。默认容量为8
    public 用数组实现栈() {
        this.capacity = 8;
        this.storage = (K[]) new Object[8];
        this.count = 0;
    }

    //带初始容量的构造方法
    public 用数组实现栈(int initialCapacity) {
        if (initialCapacity < 1)
            throw new IllegalArgumentException("Capacity too small.");

        this.capacity = initialCapacity;
        this.storage = (K[]) new Object[initialCapacity];
        this.count = 0;
    }

    //入栈
    public void push(K value) {
        if (count == capacity) {
            ensureCapacity();
        }
        storage[count] = value;
        count++;
    }

    //确保容量大小
    private void ensureCapacity() {
        int newCapacity = capacity * GROW_FACTOR;
        storage = Arrays.copyOf(storage, newCapacity);
        capacity = newCapacity;
    }

    //返回栈顶元素并出栈
    private K pop() {
        if (count == 0)
            throw new IllegalArgumentException("Stack is empty.");
        count--;
        return storage[count];
    }

    //返回栈顶元素不出栈
    private K peek() {
        if (count == 0) {
            throw new IllegalArgumentException("Stack is empty.");
        } else {
            return storage[count - 1];
        }
    }

    //判断栈是否为空
    private boolean isEmpty() {
        return count == 0;
    }

    //返回栈中元素的个数
    private int size() {
        return count;
    }

    public static void main(String[] args) {
        用数组实现栈<Integer> myStack = new 用数组实现栈<>(3);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);

        System.out.println(myStack.peek());//5
        System.out.println(myStack.size());//5
        for (int i = 0; i < 5; i++) {
            System.out.println(myStack.pop());
        }
        System.out.println(myStack.isEmpty());//true


        //用栈判断回文串
        String string = "aaabbcbbaaa";
        用数组实现栈<String> stack = new 用数组实现栈<>();

        String[] strings = string.split("");
        for (String s : strings) {
            stack.push(s);
        }
        StringBuilder reverse_string = new StringBuilder();
        while (!stack.isEmpty()) {
            reverse_string.append(stack.pop());
        }

        System.out.println(reverse_string.toString().equals(string));


    }

}

