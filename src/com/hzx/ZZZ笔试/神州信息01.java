package com.hzx.ZZZ笔试;


import java.util.Scanner;

public class 神州信息01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();

        StringBuilder res = new StringBuilder();

        for (char c : n.toCharArray()) {
            if ((c - '0') % 2 == 0) {
                res.append('0');
            } else {
                res.append('1');
            }
        }


        // 处理结果为空或全零的情况
        String result = res.toString();
        if (result.equals("0".repeat(result.length()))) {
            System.out.println("0");
        } else {
            System.out.println(result.replaceFirst("^0+", ""));
        }
    }

}

