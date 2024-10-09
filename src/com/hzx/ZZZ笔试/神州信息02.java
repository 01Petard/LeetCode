package com.hzx.ZZZ笔试;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 神州信息02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[][] bc = new int[m][2];
        for (int i = 0; i < m; i++) {
            bc[i][0] = scanner.nextInt();
            bc[i][1] = scanner.nextInt();
        }
        scanner.close();


        Arrays.sort(a);
        Arrays.sort(bc, (o1, o2) -> o2[1] - o1[1]);
        int totalCost = 0;
        int[] tableUsed = new int[n];
        for (int[] guest : bc) {
            for (int i = 0; i < n; i++) {
                if (tableUsed[i] + guest[0] <= a[i]) {
                    tableUsed[i] += guest[0];
                    totalCost += guest[1];
                    break;
                }
            }
        }
        System.out.println(totalCost);
    }

}