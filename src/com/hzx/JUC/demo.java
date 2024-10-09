package com.hzx.JUC;

public class demo {
    interface Callback {
        void onComplete(boolean success);
    }

    static class WorkerThread extends Thread {
        private final Callback callback;

        WorkerThread(Callback callback) {
            this.callback = callback;
        }

        @Override
        public void run() {
            try {
                // 模拟任务
                Thread.sleep(1000);
                System.out.println("子线程执行完成");
                callback.onComplete(true); // 通知主线程任务完成
            } catch (InterruptedException e) {
                e.printStackTrace();
                callback.onComplete(false);
            }
        }
    }

    public static void main(String[] args) {

        WorkerThread worker = new WorkerThread(msg -> System.out.println("子线程执行成功: " + msg));
        worker.start();
        // 可死循环监听 success 状态
    }
}
