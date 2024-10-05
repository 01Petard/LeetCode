package com.hzx.JUC.并发练习题;


import java.util.Random;

/**
 * 抢红包也用到了多线程。假设：100块，分成了3个包，现在有5个人去抢。其中，红包是共享数据。5个人是5条线程。
 */
class MyThread_Test4_1 extends Thread {

    //共享数据
    //100块，分成了3个包
    static double money = 100;
    static int count = 3;

    //最小的中奖金额
    static final double MIN = 0.01;

    @Override
    public void run() {
        //同步代码块
        synchronized (MyThread_Test4_1.class) {
            if (count == 0) {
                //判断，共享数据是否到了末尾（已经到末尾）
                System.out.println(getName() + "没有抢到红包！");
            } else {
                //判断，共享数据是否到了末尾（没有到末尾）
                //定义一个变量，表示中奖的金额
                double prize = 0;
                if (count == 1) {
                    //表示此时是最后一个红包
                    //就无需随机，剩余所有的钱都是中奖金额
                    prize = money;
                } else {

                    Random r = new Random();

                    prize = r.nextDouble();
                    if (prize < MIN) {
                        prize = MIN;
                    }
                }
                //设置抽中红包，小数点保留两位，四舍五入
                prize = Math.round(prize * 100.0) / 100.0;

                //从money当中，去掉当前中奖的金额
                money = money - prize;
                //红包的个数-1
                count--;
                //本次红包的信息进行打印
                System.out.println(getName() + "抢到了" + prize + "元");
            }
        }
    }
}

public class Test_4_抢红包_1 {
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
        MyThread_Test4_1 t1 = new MyThread_Test4_1();
        MyThread_Test4_1 t2 = new MyThread_Test4_1();
        MyThread_Test4_1 t3 = new MyThread_Test4_1();
        MyThread_Test4_1 t4 = new MyThread_Test4_1();
        MyThread_Test4_1 t5 = new MyThread_Test4_1();

        //给线程设置名字
        t1.setName("小A");
        t2.setName("小QQ");
        t3.setName("小哈哈");
        t4.setName("小诗诗");
        t5.setName("小丹丹");

        //启动线程
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}

