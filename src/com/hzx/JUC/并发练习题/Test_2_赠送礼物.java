package com.hzx.JUC.并发练习题;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 需求：
 * 有100份礼品,两人同时发送，当剩下的礼品小于10份的时候则不再送出。
 * 利用多线程模拟该过程并将线程的名字和礼物的剩余数量打印出来.
 */
class GivePresents1 implements Runnable {

    // Runnable只创建一次，所以不需要加static
    int tickets;

    public GivePresents1(int tickets){
        this.tickets = tickets;
    }

    @Override
    public void run() {
        //1.循环
        while (true) {
            //2.同步代码块
            synchronized (GivePresents1.class) {
                //3.判断共享数据（已经到末尾）
                if (tickets <= 10) {
                    System.out.println("礼物还剩下" + tickets + "个，不再赠送");
                    break;
                } else {
                    //4.判断共享数据（没有到末尾）
                    System.out.print(Thread.currentThread().getName() + "在赠送第" + tickets + "个礼物");
                    tickets--;
                    System.out.println("，还剩下" + tickets + "个礼物");
                }
            }
        }
    }
}

class GivePresents2 implements Runnable {

    // Runnable只创建一次，所以不需要加static
    static int count;

    Lock lock = new ReentrantLock();

    public GivePresents2(int tickets){
        count = tickets;
    }

    @Override
    public void run() {
        //1.循环
        while (true) {
            //2.同步代码块
            lock.lock();

            try {
                //3.判断共享数据（已经到末尾）
                if (count <= 10) {
                    System.out.println("礼物还剩下" + count + "个，不再赠送");
                    break;
                } else {
                    //4.判断共享数据（没有到末尾）
                    System.out.print(Thread.currentThread().getName() + "在赠送第" + count + "个礼物");
                    count--;
                    System.out.println("，还剩下" + count + "个礼物");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }


        }
    }
}


public class Test_2_赠送礼物 {

    static final int tickets = 100;

    public static void main(String[] args) {
        /*
            有100份礼品,两人同时发送，当剩下的礼品小于10份的时候则不再送出，
            利用多线程模拟该过程并将线程的名字和礼物的剩余数量打印出来.
        */

        //创建参数对象
        GivePresents1 mr1 = new GivePresents1(tickets);
        GivePresents2 mr2 = new GivePresents2(tickets);

        //创建线程对象
        Thread t1 = new Thread(mr2, "圣诞老人1");
        Thread t2 = new Thread(mr2, "圣诞老人2");
        Thread t3 = new Thread(mr2, "圣诞老人3");

        //启动线程
        t1.start();
        t2.start();
        t3.start();
    }
}
