package com.hzx.JUC.并发练习题;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * 抢红包也用到了多线程。假设：100块，分成了3个包，现在有5个人去抢。其中，红包是共享数据。5个人是5条线程。
 */
class MyThread_Test4_2 extends Thread {

    //总金额
    static BigDecimal money = BigDecimal.valueOf(100.0);
    //个数
    static int count = 3;
    //最小抽奖金额
    static final BigDecimal MIN = BigDecimal.valueOf(0.01);
    
    @Override
    public void run() {
        synchronized (MyThread_Test4_2.class) {
            if (count == 0) {
                System.out.println(getName() + "没有抢到红包！");
            } else {
                BigDecimal prize;  //中奖金额
                if (count == 1) {
                    prize = money;
                } else {
                    Random r = new Random();
                    prize = BigDecimal.valueOf(r.nextDouble());

                    if (prize.subtract(MIN).compareTo(BigDecimal.ZERO) < 0) {
                        prize = MIN;
                    }
                }
                //设置抽中红包，小数点保留两位，四舍五入
                prize = prize.setScale(2, RoundingMode.HALF_UP);
                //在总金额中去掉对应的钱
                money = money.subtract(prize);
                count--;
                System.out.println(getName() + "抽中了" + prize + "元");
            }
        }
    }
}

public class Test_4_抢红包_2 {
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


        MyThread_Test4_2 t1 = new MyThread_Test4_2();
        MyThread_Test4_2 t2 = new MyThread_Test4_2();
        MyThread_Test4_2 t3 = new MyThread_Test4_2();
        MyThread_Test4_2 t4 = new MyThread_Test4_2();
        MyThread_Test4_2 t5 = new MyThread_Test4_2();

        t1.setName("小A");
        t2.setName("小QQ");
        t3.setName("小哈哈");
        t4.setName("小诗诗");
        t5.setName("小丹丹");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
