package com.hzx.JUC.并发练习题;


import java.util.Random;

/**
 * 抢红包也用到了多线程。假设：100块，分成了3个包，现在有5个人去抢。其中，红包是共享数据。5个人是5条线程。
 */
class DeliveryPocket extends Thread {

    static double money = 100;
    static int count = 3;

    //最小的中奖金额
    static final double MIN = 0.01;

    public DeliveryPocket(String threadName) {
        super(threadName);
    }

    @Override
    public void run() {
        synchronized (DeliveryPocket.class) {
            if (count == 0) {
                System.out.println(getName() + "没有抢到红包！");
            } else {
                //中奖的金额
                double prize;
                if (count == 1) {
                    //表示此时是最后一个红包
                    //就无需随机，剩余所有的钱都是中奖金额
                    prize = money;
                } else {
                    Random r = new Random();
                    prize = r.nextDouble();
                    prize = Math.max(prize, MIN);
                }
                //设置抽中红包，小数点保留两位，四舍五入
                prize = Math.round(prize * 100.0) / 100.0;
                //从money中减掉当前中奖的金额，红包的个数-1
                money = money - prize;
                count--;
                System.out.println(getName() + "抢到了" + prize + "元");
            }
        }
    }
}

public class Test_4_抢红包 {
    public static void main(String[] args) {
        /*
            微信中的抢红包也用到了多线程。
            假设：100块，分成了3个包，现在有5个人去抢。
            其中，红包是共享数据。
            5个人是5条线程。
            打印结果如下：
            	XXX抢到了XXX元
            	XXX抢到了XXX元
            	XXX抢到了XXX元
            	XXX没抢到
            	XXX没抢到
        */

        //创建线程的对象
        DeliveryPocket t1 = new DeliveryPocket("小A");
        DeliveryPocket t2 = new DeliveryPocket("小QQ");
        DeliveryPocket t3 = new DeliveryPocket("小哈哈");
        DeliveryPocket t4 = new DeliveryPocket("小诗诗");
        DeliveryPocket t5 = new DeliveryPocket("小丹丹");

        //启动线程
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}

