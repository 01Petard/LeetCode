package com.hzx.Algorithm;


/**
 * 八皇后算法 第二种解法
 */
public class Queue8_2 { // 定义一个数组表示每个皇后在棋盘上的位置，index 表示行号，queens[index] 表示该行上的皇后所在的列号

    // 输出八皇后问题的所有解法
    private int[] queens = new int[8];

    // 回溯算法主体函数，index 表示当前处理的行号
    public void solve() {
        backtrack(0);
    }

    private static int solveCount = 0;

    private void backtrack(int index) { // 如果已经处理完所有行，则输出一组解法
        if (index == 8) {
            printSolution();
            return;
        } // 在该行上依次尝试放置皇后，并检查是否合法
        for (int i = 0; i < 8; i++) {
            queens[index] = i;
            if (isValid(index)) {
                backtrack(index + 1);
            }
        }
    } // 检查当前放置皇后的状态是否合法，即不在同一列或同一对角线上

    private boolean isValid(int index) {
        for (int i = 0; i < index; i++) {
            if (queens[i] == queens[index] || Math.abs(queens[i] - queens[index]) == index - i) {
                return false;
            }
        }
        return true;
    } // 输出一组解法

    private void printSolution() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (queens[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
        solveCount++;
    }

    public static void main(String[] args) {
        Queue8_2 solution = new Queue8_2();
        solution.solve();
        System.out.println("总共有" + solveCount + "种解法");
    }
}