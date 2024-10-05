package com.hzx.JUC;

import java.util.concurrent.*;


class CalSum implements Callable<Integer> {

    static int sum = 0;

    @Override
    public Integer call() {
        for (int i = 0; i <= 10; i++) {
            sum += i;
        }
        return sum;
    }
}


class PrintNums implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}


public class 线程池的简单用法 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 线程池的实现方式一：
//        ExecutorService pool = Executors.newFixedThreadPool(5);

         // 线程池的实现方式二：
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3,
                5,
                1,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3)
        );

        pool.submit(new PrintNums());
        Future<Integer> sum = pool.submit(new CalSum());
        System.out.println(sum.get());


        pool.shutdown();


    }


}
