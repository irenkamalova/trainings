package com.kamalova.pramp;

public class NumberOfPaths {
    static int numOfPathsToDest(int n) {
        if (n == 0) return 0;
        int[][] result = new int[n][n];

        result[n - 1][n - 1] = helper(n - 1, n - 1, result);
        return result[n - 1][n - 1];
    }

    private static int helper(int i, int j, int result[][]) {
        if (i == 0 && j == 0) {
            return 1;
        }

        if (i > j) {
            return 0;
        }

        if (result[i][j] == 0) {
            if (i - 1 >= 0 && j - 1 >= 0) {
                result[i][j] = helper(i - 1, j, result) + helper(i, j - 1, result);
            } else if (i - 1 >= 0 && j >= 0) {
                result[i][j] = helper(i - 1, j, result);
            } else if (i >= 0 && j - 1 >= 0) {
                result[i][j] = helper(i, j - 1, result);
            }
        }

        return result[i][j];
    }

    public static void main(String[] args) {
        int result = numOfPathsToDest(4);
        System.out.println(result);
    }
}
