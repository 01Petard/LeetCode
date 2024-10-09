package com.hzx.JUC;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;


public class OrderManagementSystem {

    private static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    private static volatile boolean isPaid = false;

    public static void main(String[] args) throws InterruptedException {
        // 模拟系统关闭订单
        ScheduledFuture<?> closeOrderTask = scheduleTask(12345L, 5, TimeUnit.SECONDS);
        // 模拟用户付款
        new Thread(() -> {
            try {
                Thread.sleep(6 * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            isPaid = true; // 标记订单为已付款
        }).start();

        // 用户完成付款，取消关闭订单的任务
        if (closeOrderTask.isDone()) {
            if (!isPaid) {
                cancelCloseOrder(closeOrderTask);
            } else {
                System.out.println("订单已付款，无需关闭");
            }
        }

        // 关闭线程池
        executor.shutdown();
    }

    /**
     * 调度一个任务，在指定时间后关闭订单。
     * @param orderId 订单ID
     * @param delay   延迟时间
     * @param unit    时间单位
     * @return ScheduledFuture 对象，用于取消任务
     */
    public static ScheduledFuture<?> scheduleTask(Long orderId, long delay, TimeUnit unit) {
        return executor.schedule(
                () -> {
                    // 检查用户是否已经付款
                    if (isPaid) {
                        System.out.println("Order with ID: " + orderId + " is paid successfully.");
                    } else {
                        // 这里可以添加关闭订单的业务逻辑
                        System.out.println("Order with ID: " + orderId + " is closed due to timeout.");
                    }
                    return isPaid;
                },
                delay,
                unit);
    }

    /**
     * 取消关闭订单的任务。
     * @param closeOrderTask 要取消的任务
     */
    public static void cancelCloseOrder(ScheduledFuture<?> closeOrderTask) {
        if (closeOrderTask.cancel(true)) {
            System.out.println("Order closing cancelled successfully.");
        } else {
            System.out.println("Order closing cancelled error.");
        }
    }
}