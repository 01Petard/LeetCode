package com.hzx.Algorithm.手写数据结构;

import java.util.Arrays;


/*
 * 在这个实现中，我们定义了一个泛型数组`elements`来存储队列的元素，并使用`size`变量来跟踪队列中当前元素的数量。当队列满时，我们通过调用`resize`方法将数组的大小加倍。
 * `enqueue`方法用于向队列中添加元素。首先，我们检查队列是否已满，如果是，则调用`resize`方法扩展数组。然后，我们将新元素添加到数组的末尾，并调用`siftUp`方法将其上浮到正确的位置，以保持堆的性质。
 * `dequeue`方法用于从队列中移除并返回最小元素（即堆的根）。首先，我们检查队列是否为空。然后，我们将数组的最后一个元素移动到根的位置，并将队列大小减1。最后，我们调用`siftDown`方法将根元素下沉到正确的位置。
 * `siftUp`和`siftDown`方法用于维护堆的性质。`siftUp`方法将给定索引处的元素上浮到正确的位置，而`siftDown`方法将给定索引处的元素下沉到正确的位置。
 * 此外，我们还提供了一些辅助方法，如`parent`、`firstChild`、`leftChild`、`rightChild`、`hasLeftChild`和`hasRightChild`，用于计算节点的父节点、子节点以及检查节点是否有左子节点或右子节点。
 * 在`main`方法中，我们创建了一个`PriorityQueue`对象，并向其中添加了一些整数。然后，我们打印出队列的内容，并通过循环调用`dequeue`方法将队列中的元素逐个移除并打印出来，每次打印的都是当前队列中的最小元素。
 */
public class 用数组实现优先队列<T extends Comparable<T>> {


    private T[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public 用数组实现优先队列() {
        this.elements = (T[]) new Comparable[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void enqueue(T element) {
        if (size == elements.length) {
            resize();
        }

        elements[size] = element;
        siftUp(size);
        size++;
    }

    public T dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Priority queue is empty");
        }

        T root = elements[0];
        elements[0] = elements[size - 1];
        size--;
        siftDown(0);

        return root;
    }

    private void siftUp(int k) {
        while (k > 0 && elements[parent(k)].compareTo(elements[k]) > 0) {
            swap(k, parent(k));
            k = parent(k);
        }
    }

    private void siftDown(int k) {
        while (hasLeftChild(k)) {
            int j = firstChild(k);
            if (hasRightChild(k) && elements[rightChild(j)].compareTo(elements[leftChild(j)]) < 0) {
                j = rightChild(j);
            }
            if (elements[j].compareTo(elements[k]) < 0) {
                swap(k, j);
                k = j;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        T temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    private int parent(int k) {
        return (k - 1) / 2;
    }

    private int firstChild(int k) {
        return 2 * k + 1;
    }

    private int leftChild(int k) {
        return 2 * k + 1;
    }

    private int rightChild(int k) {
        return 2 * k + 2;
    }

    private boolean hasLeftChild(int k) {
        return firstChild(k) < size;
    }

    private boolean hasRightChild(int k) {
        return rightChild(k) < size;
    }

    private void resize() {
        elements = Arrays.copyOf(elements, elements.length * 2);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        用数组实现优先队列<Integer> queue = new 用数组实现优先队列<>();
        queue.enqueue(3);
        queue.enqueue(1);
        queue.enqueue(4);
        queue.enqueue(1);
        queue.enqueue(5);
        queue.enqueue(9);
        queue.enqueue(2);
        queue.enqueue(6);
        queue.enqueue(5);
        queue.enqueue(3);
        queue.enqueue(5);

        System.out.println(queue); // 输出: [1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9]

        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());// 输出队列中的元素，每次输出最小的元素
        }
    }
}
