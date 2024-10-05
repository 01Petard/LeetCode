package com.hzx.Thread线程相关;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyThread1 implements Runnable {
    private volatile int count = 0; //送冰淇淋的数量
    private final Lock lock = new ReentrantLock();

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (lock) {
                count++;
                System.out.println("已经送了" + count + "个冰淇淋");
            }
        }
    }
}


class MyAtomThread implements Runnable {
    AtomicInteger ac = new AtomicInteger(0);

    int count = ac.get();

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            //1,从共享数据中读取数据到本线程栈中.
            //2,修改本线程栈中变量副本的值
            //3,会把本线程栈中变量副本的值赋值给共享数据.
            count = ac.incrementAndGet();

            System.out.println("已经送了" + count + "个冰淇淋");
        }
    }
}

public class 送冰淇淋问题 {

    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        for (int i = 0; i < 10; i++) {
            myThread1.run();
        }

        MyAtomThread atom = new MyAtomThread();
        for (int i = 0; i < 10; i++) {
            new Thread(atom).start();
        }
    }

}
