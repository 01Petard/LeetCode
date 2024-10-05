package com.hzx.JUC.并发练习题;

import java.util.*;

/**
 * 有一个抽奖池，该抽奖池中存放了奖励的金额，该抽奖池中的奖项为{10,5,20,50,100,200,500,800,2,80,300,70};
 * 创建两个抽奖箱（线程）设置线程名称分别为“抽奖箱1”，“抽奖箱2",
 * 随机从抽奖池中获取奖项元素并打印在控制台上，格式如下：
 * 每次抽出一个奖项就打印一个(随机)
 * 抽奖箱1又产生了一个10元大奖
 * 抽奖箱1又产生了一个100元大奖
 * 抽奖箱1又产生了一个200元大奖
 * 抽奖箱1又产生了一个800元大奖
 * 抽奖箱2又产生了下个700元大奖
 */
import java.util.concurrent.CountDownLatch;

public class Test_5_抽奖 {
    public static void main(String[] args) {
        // 创建抽奖池
        Map<Integer, Integer> prizePool = new HashMap<>();
        prizePool.put(10, 2);
        prizePool.put(5, 2);
        prizePool.put(20, 2);
        prizePool.put(50, 2);
        prizePool.put(100, 2);
        prizePool.put(200, 2);
        prizePool.put(500, 2);
        prizePool.put(800, 2);
        prizePool.put(2, 2);
        prizePool.put(80, 2);
        prizePool.put(300, 2);
        prizePool.put(70, 2);

        // 设置每个抽奖箱的出奖次数
        int drawCountBox1 = 20; // 抽奖箱1的出奖次数
        int drawCountBox2 = 20; // 抽奖箱2的出奖次数

        // 创建一个共享的最大值存储器
        MaxPrizeTracker maxPrizeTracker = new MaxPrizeTracker();

        // 使用 CountDownLatch 来确保所有线程准备好后再开始
        CountDownLatch latch = new CountDownLatch(1);

        // 创建两个抽奖箱线程
        Thread drawBox1 = new Thread(new DrawTask(prizePool, "抽奖箱1", drawCountBox1, maxPrizeTracker, latch));
        Thread drawBox2 = new Thread(new DrawTask(prizePool, "抽奖箱2", drawCountBox2, maxPrizeTracker, latch));

        // 启动线程
        drawBox1.start();
        drawBox2.start();

        try {
            // 模拟开奖前的准备时间
            System.out.println("等待所有抽奖箱准备...");
            Thread.sleep(2000);  // 等待2秒，模拟准备时间
            latch.countDown();   // 所有准备工作完成，开始抽奖
            System.out.println("开始抽奖！");

            // 等待所有抽奖完成
            drawBox1.join();
            drawBox2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 打印最终哪个抽奖箱中的奖项最大
        System.out.println("最终产生的最大奖项为：" + maxPrizeTracker.getMaxPrize() + " 元，来自：" + maxPrizeTracker.getMaxPrizeBox());
    }
}

// 用于追踪最大奖项的类
class MaxPrizeTracker {
    private int maxPrize = 0;
    private String maxPrizeBox = "";

    public synchronized void updateMaxPrize(int prize, String boxName) {
        if (prize > maxPrize) {
            maxPrize = prize;
            maxPrizeBox = boxName;
        }
    }

    public synchronized int getMaxPrize() {
        return maxPrize;
    }

    public synchronized String getMaxPrizeBox() {
        return maxPrizeBox;
    }
}

class DrawTask implements Runnable {
    private final Map<Integer, Integer> prizePool;
    private final String name;
    private final int maxDraws;
    private final MaxPrizeTracker maxPrizeTracker;
    private final CountDownLatch latch;
    private int draws = 0;
    private final List<Integer> prizesWon = new ArrayList<>();

    public DrawTask(Map<Integer, Integer> prizePool, String name, int maxDraws, MaxPrizeTracker maxPrizeTracker, CountDownLatch latch) {
        this.prizePool = prizePool;
        this.name = name;
        this.maxDraws = maxDraws;
        this.maxPrizeTracker = maxPrizeTracker;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            // 等待开奖信号
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Random random = new Random();
        while (draws < maxDraws && !prizePool.isEmpty()) {
            synchronized (prizePool) {
                if (prizePool.isEmpty()) {
                    System.out.println(name + " 抽奖结束");
                    return;
                }

                // 选择一个奖项
                int prize = selectPrize(prizePool, random);
                if (prize != -1) {
                    prizesWon.add(prize);
                    prizePool.put(prize, prizePool.get(prize) - 1);
                    if (prizePool.get(prize) == 0) {
                        prizePool.remove(prize);
                    }
                    draws++;

                    // 更新最大奖项
                    maxPrizeTracker.updateMaxPrize(prize, name);
                }
            }

            try {
                // 模拟抽奖间隔
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        // 打印结果
        printResults(name, prizesWon);
    }

    private int selectPrize(Map<Integer, Integer> prizePool, Random random) {
        List<Integer> keys = new ArrayList<>(prizePool.keySet());
        int keyIndex = random.nextInt(keys.size());
        int prize = keys.get(keyIndex);
        if (prizePool.get(prize) > 0) {
            return prize;
        }
        return -1; // 如果没有可用奖项，返回-1
    }

    private void printResults(String name, List<Integer> prizesWon) {
        int totalAmount = prizesWon.stream().mapToInt(Integer::intValue).sum();
        int highestPrize = Collections.max(prizesWon);

        System.out.println("在此次抽奖过程中，" + name + " 总共产生了 " + prizesWon.size() + " 个奖项。分别为：" + prizesWon.toString());
        System.out.println(name + " 最高奖项为 " + highestPrize + " 元，总计额为 " + totalAmount + " 元");
    }
}
