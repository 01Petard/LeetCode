package com.hzx.JUC;

public class 线程交替打印数字_PrintOddEven {

    static final Object object = new Object();
    static int number = 0;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            synchronized (object) {
                while (number < 100) {
                    if (number % 2 == 0) {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + ": " + number);
                        number++;
                        object.notify();
                    }
                }
            }
        }, "Odd");


        Thread t2 = new Thread(() -> {
            synchronized (object) {
                while (number < 100) {
                    if (number % 2 != 0) {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + ": " + number);
                        number++;
                        object.notify();
                    }
                }
            }
        }, "Even");


        t1.start();
        t2.start();
    }
}
