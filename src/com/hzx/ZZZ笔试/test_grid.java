package com.hzx.ZZZ笔试;

public class test_grid {

    private static int[][] parseToArray(String input) {
        String[] lines = input.split("],");

        int[][] inputArray = new int[lines.length][];

        int i = 0;

        for (String line : lines) {
            int j = 0;
            String[] elements = line.split(",");

            inputArray[i] = new int[elements.length];

            for (String element : elements) {
                inputArray[i][j++] = Integer.parseInt(element.replace("[", "").replace("]", ""));
            }

            i++;
        }

        return inputArray;
    }


    private static int getMin(int[][] array) {
        int m = array.length;
        int n = array[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = array[0][0];

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + array[i][0];
        }

        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + array[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + array[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {

        String input = "[[1,2,3],[1,5,1],[3,1,1]]";
        int[][] array = parseToArray(input);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }


}
