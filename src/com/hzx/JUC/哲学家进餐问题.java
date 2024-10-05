package com.hzx.JUC;

import java.util.concurrent.Semaphore;

class Philosopher implements Runnable {
    private final Semaphore leftChopstick;
    private final Semaphore rightChopstick;
    private final int philosopherNumber;

    public Philosopher(int philosopherNumber, Semaphore leftChopstick, Semaphore rightChopstick) {
        this.philosopherNumber = philosopherNumber;
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                pickUpChopsticks();
                eat();
                putDownChopsticks();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void think() throws InterruptedException {
        System.out.println("Philosopher " + philosopherNumber + " is thinking.");
        Thread.sleep((long) (Math.random() * 1000));
    }

    private void pickUpChopsticks() throws InterruptedException {
        leftChopstick.acquire();
        rightChopstick.acquire();
        System.out.println("Philosopher " + philosopherNumber + " picked up chopsticks.");
    }

    private void eat() throws InterruptedException {
        System.out.println("Philosopher " + philosopherNumber + " is eating.");
        Thread.sleep((long) (Math.random() * 1000));
    }

    private void putDownChopsticks() {
        leftChopstick.release();
        rightChopstick.release();
        System.out.println("Philosopher " + philosopherNumber + " put down chopsticks.");
    }
}

public class 哲学家进餐问题 extends Thread {

    public static void main(String[] args) throws InterruptedException {
        int numberOfPhilosophers = 5;
        Semaphore[] chopsticks = new Semaphore[numberOfPhilosophers];
        for (int i = 0; i < numberOfPhilosophers; i++) {
            chopsticks[i] = new Semaphore(1);
        }

        Thread[] philosophers = new Thread[numberOfPhilosophers];
        for (int i = 0; i < numberOfPhilosophers; i++) {
            Semaphore leftChopstick = chopsticks[i];
            Semaphore rightChopstick = chopsticks[(i + 1) % numberOfPhilosophers];
            philosophers[i] = new Thread(new Philosopher(i, leftChopstick, rightChopstick), "Philosopher " + i);
            philosophers[i].start();
        }

        // Wait for all philosophers to finish
        for (Thread philosopher : philosophers) {
            philosopher.join();
        }
    }
}