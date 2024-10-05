package com.hzx.Thread线程相关;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class 线程交替打印数字_PrintOddEvenLock {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private int number = 1;

    public void printOdd() {
        lock.lock();
        try {
            while (number < 100) {
                if (number % 2 == 0) {
                    condition.await();
                } else {
                    System.out.println(Thread.currentThread().getName() + ": " + number);
                    number++;
                    condition.signal();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public void printEven() {
        lock.lock();
        try {
            while (number < 100) {
                if (number % 2 != 0) {
                    condition.await();
                } else {
                    System.out.println(Thread.currentThread().getName() + ": " + number);
                    number++;
                    condition.signal();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        线程交替打印数字_PrintOddEvenLock poe = new 线程交替打印数字_PrintOddEvenLock();
        Thread t1 = new Thread(poe::printOdd, "Odd");
        Thread t2 = new Thread(poe::printEven, "Even");
        t1.start();
        t2.start();
    }
}
