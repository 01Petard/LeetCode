package com.hzx.JUC.并发练习题;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 需求：
 * 一共有1000张电影票,可以在两个窗口领取,假设每次领取的时间为3000毫秒,
 * 请用多线程模拟卖票过程并打印剩余电影票的数量
 */
class SaleTickets extends Thread {

    // Thread会创建多次，需要加static
    static int ticket;

    public SaleTickets(int tickets) {
        ticket = tickets;
    }

    static Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {

            // 同步代码块一
            synchronized (SaleTickets.class) {
                if (!reduce()) {
                    break;
                }
            }
            //同步代码块一
//            lock.lock();
//            if (!reduce()) {
//                break;
//            }
//            lock.unlock();
        }
    }

    private boolean reduce() {
        if (ticket != 0) {
            // 让其他线程能抢到
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(getName() + "在卖票第" + ticket + "张票");
            --ticket;
            System.out.println("，卖票成功，还剩下" + ticket + "张票");
            return true;
        } else {
            return false;
        }
    }
}

public class Test_1_售票 {


    static final int tickets = 1000;

    public static void main(String[] args) {
       /*
            一共有1000张电影票,可以在两个窗口领取,假设每次领取的时间为3000毫秒,
            要求:请用多线程模拟卖票过程并打印剩余电影票的数量
        */


        //创建线程对象
        SaleTickets t1 = new SaleTickets(tickets);
        SaleTickets t2 = new SaleTickets(tickets);
        SaleTickets t3 = new SaleTickets(tickets);

        //给线程设置名字
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        //开启线程
        t1.start();
        t2.start();
        t3.start();

    }
}
