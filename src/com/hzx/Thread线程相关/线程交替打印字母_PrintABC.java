package com.hzx.Thread线程相关;

public class 线程交替打印字母_PrintABC {


    private static final Object object = new Object();

    private static final int rounds = 3;

    private static int runNum = 0;
    private static final int max = 3 * rounds;


    private static void printA() {

        synchronized (object) {
            while (runNum < max) {
                if (runNum % 3 == 0) {
                    System.out.println(Thread.currentThread().getName() + " " + runNum + ":A");
                    runNum++;
                    object.notifyAll();
                } else {
                    try {
                        object.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    private static void printB() {

        synchronized (object) {
            while (runNum < max) {
                if (runNum % 3 == 1) {
                    System.out.println(Thread.currentThread().getName() + " " + runNum + ":B");
                    runNum++;
                    object.notifyAll();
                } else {
                    try {
                        object.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }

                }
            }
        }
    }

    private static void printC() {

        synchronized (object) {
            while (runNum < max) {
                if (runNum % 3 == 2) {
                    System.out.println(Thread.currentThread().getName() + " " + runNum + ":C");
                    runNum++;
                    object.notifyAll();
                } else {

                    try {
                        object.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        Thread threadA = new Thread(线程交替打印字母_PrintABC::printA, "线程A");
        Thread threadB = new Thread(线程交替打印字母_PrintABC::printB, "线程B");
        Thread threadC = new Thread(线程交替打印字母_PrintABC::printC, "线程C");


        threadA.start();
        threadB.start();
        threadC.start();


    }
}
