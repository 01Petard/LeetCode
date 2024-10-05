package com.hzx.ZZZ笔试;

import java.util.concurrent.Callable;

public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        new Thread(()->{
            StringBuilder sb1 = new StringBuilder();
            sb1.append(1);
            sb1.append(2);
            System.out.println(sb1);
        });

        new Runnable() {
            @Override
            public void run() {
                sb.append(3);
                sb.append(4);
                System.out.println(sb);
            }
        };

        new Callable<>() {
            @Override
            public Object call() throws Exception {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(5);
                sb3.append(6);
                return sb3;
            }
        };
    }
}
