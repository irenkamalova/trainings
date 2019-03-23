package com.kamalova.pramp;

public class ToeplitzMatrix {

    static boolean isToeplitz(int[][] arr) {
        // your code goes here
        if (arr.length == 0 || arr.length == 1
                || arr[0].length == 1) return true;

        int N = arr.length; // 2 0,0 0,1 ; 1,0, 1,1
        int M = arr[0].length; // 2

        for (int k = 0; k < Math.min(N,M); k++) { // k = 1; val 0
            int val = arr[0][k]; // 0,1
            for (int i = 1; i + k < Math.min(N,M); i++) { // i = 1 // [1, 2]
                if (arr[i][i + k] != val) { // 1, 2
                    // 0,0, 1,1, 2,2
                    //
                    return false;
                }
            }
        }

        for (int k = 1; k < Math.min(N,M); k++) {
            int val = arr[k][0]; // 0,1
            for (int i = 0; i + k < Math.min(M,N); i++) { // i = 1
                if (arr[i + k][i] != val) { // 1, 2
                    // 0,0, 1,1, 2,2
                    //
                    return false;
                }
            }
        }
   /*
    if (N > M) {
      int val = arr[M - 1][M - 1];
      for (int i = M - 1; i < N; i++) {
        if (arr[i][M - 1] != val) {
          return false;
        }
      }
    }
    */
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isToeplitz(
                new int[][]{
                {1,2,3,4},
                {5,1,2,3},
                {6,5,1,2}}));
    }
}

/*
[[3,9],
[5,3],
[6,5]]



[[0,0],[0,1],[0,2],[0,3]]
[1,0],[1,1],[1,2],[1,3]
[2,0],[2,1],[2,2],[2,3]
[3,0],[3,1],[3,2],[3,3]

1,0 & 2,1
2,1 & 3,2


// 0,0 , 1,1

// 0,1 , 1,2;


/*
[[]]
[[1]]


*/
/*
111
211
321
221
321

a[0][0] -> value
a[i][i] -> ? value
raws N, columns M
N steps

234
525
432

[[8,8,8,8,8],
[8,8,8,8,9],
[8,8,8,8,8],
[8,8,8,8,8],
[8,8,8,8,8]]

[[1,2,3,4],
 [5,1,2,3],
 [6,5,1,2]]


*/

