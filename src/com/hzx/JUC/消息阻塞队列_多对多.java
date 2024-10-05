package com.hzx.JUC;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Consumer3 implements Runnable {
    private BlockingQueue<Integer> queue;

    public Consumer3(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                int message = queue.take(); // 消费消息
                System.out.println("消费者正在消费消息：" + message);
                // 模拟消费耗时
                Thread.sleep(1000); // 假设消费速度较慢
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // 重新设置中断状态
        }
    }
}

class Producer3 implements Runnable {
    private BlockingQueue<Integer> queue;

    public Producer3(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            int messageIndex = 0;
            while (!Thread.currentThread().isInterrupted()) {
                // 生产消息
                queue.put(messageIndex);
                System.out.println("生产者正在生产消息：" + messageIndex);
                messageIndex++;
                // 模拟生产耗时
                Thread.sleep(500); // 假设生产速度较快
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // 重新设置中断状态
        }
    }
}

public class 消息阻塞队列_多对多 {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10); // 设置队列容量为10


//        Producer3 producer = new Producer3(queue);
//        Consumer3 consumer = new Consumer3(queue);
//        producer.run();
//        consumer.run();


        ExecutorService executor = Executors.newFixedThreadPool(2); // 创建线程池

        // 启动生产者和消费者线程
        executor.execute(new Producer3(queue));
        executor.execute(new Consumer3(queue));

        // 模拟程序运行一段时间后停止
        try {
            Thread.sleep(10000); // 运行10秒钟
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 停止生产者和消费者线程
            executor.shutdownNow();
        }

    }
}
