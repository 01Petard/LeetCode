package com.hzx.Thread线程相关.并发练习题;

class MyRunable_Test3 implements Runnable {

    // Runnable只创建一次，所以不需要加static
    int number = 1;

    @Override
    public void run() {
        while (true) {
            // 同步代码块
            synchronized (MyRunable_Test3.class) {
                // 判断共享数据（已经到末尾）
                if (number <= 1000) {
                    // 判断共享数据（没有到末尾）
                    if (number % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + "打印数字" + number);
                    }
                    number++;
                } else {
                    break;
                }
            }
        }
    }
}


public class Test_3_打印数字 {
    public static void main(String[] args) {
        /*
           同时开启两N个线程，共同获取1-1000之间的所有数字。
           要求：将输出所有的奇数。
        */


        //创建参数对象
        MyRunable_Test3 mr = new MyRunable_Test3();

        //创建线程对象
        Thread t1 = new Thread(mr, "线程A");
        Thread t2 = new Thread(mr, "线程B");
        Thread t3 = new Thread(mr, "线程C");

        //启动线程
        t1.start();
        t2.start();
        t3.start();
    }
}

