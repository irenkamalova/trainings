package com.kamalova.rank;

public class MinMax {
    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        long minSum = Long.MAX_VALUE;
        long maxSum = 0;

        for (int i = 0; i < arr.length; i++) {
            long curSum = 0;
            for (int j = 0; j < arr.length; j++) {
                if (i != j) {
                    curSum += arr[j];
                }
            }
            minSum = Math.min(minSum, curSum);
            maxSum = Math.max(maxSum, curSum);
        }

        System.out.println(minSum + " " + maxSum);




    }

    public static void main(String[] args) {
        int[] arr = new int[]{793810624, 895642170, 685903712, 623789054, 468592370};
        miniMaxSum(arr);
        // 2572095760

    }
}
