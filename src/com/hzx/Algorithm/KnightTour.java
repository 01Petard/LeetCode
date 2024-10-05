package com.hzx.Algorithm;

import java.util.ArrayList;
import java.util.List;


/**
 * 骑士周游问题
 */
public class KnightTour {
    private static final int SIZE = 8;
    private static final int[][] MOVES = {
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
            {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
    };

    private static final List<List<Integer>> solutions = new ArrayList<>(); // 存储所有解决方案

    public static void main(String[] args) {
        int[][] board = new int[SIZE][SIZE]; // 棋盘，0表示未访问，1表示已访问
        System.out.println("Start solving...");
        solve(board, 0, 0, new ArrayList<>()); // 从(0, 0)位置开始求解
        System.out.println("Total solutions found: " + solutions.size());
        // 打印所有解决方案（如果需要）
        for (List<Integer> solution : solutions) {
            printSolution(solution);
        }
    }

    private static void solve(int[][] board, int x, int y, List<Integer> path) {
        if (path.size() == SIZE * SIZE) {
            // 如果路径长度正确，则找到一个解
            solutions.add(new ArrayList<>(path));
            System.out.println("Found a solution: " + path);
            return;
        }

        // 标记当前位置为已访问
        board[x][y] = 1;
        path.add(x * SIZE + y); // 将当前棋盘的位置索引添加到路径中

        // 尝试所有可能的走法
        for (int[] move : MOVES) {
            // 计算下一个位置的坐标
            int nextX = x + move[0];
            int nextY = y + move[1];
            // 检查下一个位置是否有效且未被访问
            if (isValidMove(board, nextX, nextY)) {
                // 如果下一个位置有效，则递归尝试
                solve(board, nextX, nextY, path);
            }
        }
        // 如果下一个位置无效,就回溯，将当前位置标记为未访问，并从路径中移除
        board[x][y] = 0;
        path.remove(path.size() - 1);
    }

    private static boolean isValidMove(int[][] board, int x, int y) {
        return x >= 0 && x < SIZE && y >= 0 && y < SIZE && board[x][y] == 0;
    }

    private static void printSolution(List<Integer> solution) {
        for (int pos : solution) {
            int x = pos / SIZE;
            int y = pos % SIZE;
            System.out.print("(" + x + ", " + y + ") ");
        }
        System.out.println();
    }
}