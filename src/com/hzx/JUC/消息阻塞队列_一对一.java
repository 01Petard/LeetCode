package com.hzx.JUC;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Consumer1 extends Thread {

    @Override
    public void run() {
        while (true) {
            synchronized (MessageQueue.lock) {

                if (MessageQueue.message_index > MessageQueue.count) {
                    break;
                } else {
                    //判断队列中是否有消息
                    if (MessageQueue.flag == 0) {
                        //没有就等待
                        try {
                            MessageQueue.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        //有消息就消费
                        MessageQueue.count++;
                        System.out.println("消费者：正在消费第" + MessageQueue.message_index + "个消息，队列中还剩" + MessageQueue.count + "个容量");
                        MessageQueue.flag = 0;
                        MessageQueue.lock.notifyAll();  //通知生产者生产
                    }
                }
            }
        }
    }
}


class Producer1 extends Thread {

    @Override
    public void run() {
        while (true) {
            synchronized (MessageQueue.lock) {
                if (MessageQueue.message_index > MessageQueue.count) {
                    break;
                } else {
                    //判断队列中是否有消息
                    if (MessageQueue.flag == 1) {
                        //有消息就等待
                        try {
                            MessageQueue.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        //没有消息就生产
                        MessageQueue.message_index++;
                        MessageQueue.count--;
                        System.out.println("生产者：正在生产第" + MessageQueue.message_index + "个消息，队列中还剩" + MessageQueue.count + "个容量");
                        MessageQueue.flag = 1;
                        MessageQueue.lock.notifyAll(); //通知消息者消费
                    }
                }
            }
        }
    }
}


class MessageQueue {

    public static int flag = 0;  //0：没有消息，1：有消息

    public static int count = 10; //队列容量

    public static int message_index = 0; //消息下标

    public static final Lock lock = new ReentrantLock();  //锁对象


}


public class 消息阻塞队列_一对一 {
    public static void main(String[] args) {

        Consumer1 consumer = new Consumer1();
        Producer1 producer = new Producer1();

        consumer.setName("消费者");
        producer.setName("生产者");

        consumer.start();
        producer.start();
    }


}
