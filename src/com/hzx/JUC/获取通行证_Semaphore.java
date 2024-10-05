package com.hzx.JUC;

import java.util.concurrent.Semaphore;

class MyRunnable_Semaphore implements Runnable {
    //1.获得管理员对象，
    private final Semaphore semaphore = new Semaphore(3);

    @Override
    public void run() {
        try {
            //2.获得通行证
            semaphore.acquire();

            System.out.println("获得了通行证");
            //3.开始运行
            Thread.sleep(1000);


            //4.归还通行证
            semaphore.release();
            System.out.println("归还通行证");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class 获取通行证_Semaphore {

    public static void main(String[] args) {

        MyRunnable_Semaphore mr = new MyRunnable_Semaphore();

        for (int i = 0; i < 10; i++) {
            new Thread(mr).start();
        }
    }
}
