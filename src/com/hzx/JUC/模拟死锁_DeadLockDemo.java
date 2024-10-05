package com.hzx.JUC;

public class 模拟死锁_DeadLockDemo {

    private static final Object objectA = new Object();
    private static final Object objectB = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyTask(objectA, objectB), "Thread 1");
        Thread thread2 = new Thread(new MyTask(objectB, objectA), "Thread 2");
        thread1.start();
        thread2.start();
    }

    static class MyTask implements Runnable {
        private final Object firstResource;
        private final Object secondResource;
        public MyTask(Object objectA, Object objectB) {
            this.firstResource = objectA;
            this.secondResource = objectB;
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "获取第一个资源");
            synchronized (firstResource) {
                System.out.println(Thread.currentThread().getName() + "已获取第一个资源: " + firstResource);
                try {
                    // 模拟其他线程获取锁
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "获取第二个资源");
                synchronized (secondResource) {
                    System.out.println(Thread.currentThread().getName() + "已获取第二个资源: " + secondResource);
                }
            }
        }
    }
}