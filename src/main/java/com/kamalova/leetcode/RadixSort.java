package com.kamalova.leetcode;

/*
Checked in HackerRank (accepted)
*/
public class RadixSort {
    public int[] sort(int[] a) {
        if (a.length == 0) return a;
        int m = getMax(a);
        for (int divider = 1; m / divider > 0; divider *= 10) {
            sortByDigit(a, divider);
        }
        return a;
    }

    private void sortByDigit(int[] a, int digit) {
        int[] digits = new int[10];
        for (int i = 0; i < a.length; i++) {
            int d = (a[i] / digit) % 10;
            digits[d]++;
        }

        for (int i = 1; i < digits.length; i++) {
            digits[i] += digits[i - 1];
        }

        int[] tmp = new int[a.length];

        // Reverse order!
        for (int i = a.length - 1; i >= 0; i--) {
            int d = (a[i] / digit) % 10;
            tmp[ digits[d] - 1 ] = a[i];
            digits[d]--;
        }

        for (int i = 0; i < a.length; i++) {
            a[i] = tmp[i];
        }
    }

    private int getMax(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            max = Math.max(max, a[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        RadixSort rs = new RadixSort();
        int[] a = new int[]{170, 45, 75, 90, 802, 24, 2, 66};
        rs.sort(a);

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    
        /*
    Example:
    170, 45, 55, 90, 802, 24, 2, 66
    max = 802

    STEP 1: divider = 1;

    digits:
    [0][1][2][3][4][5][6][7][8][9]
    170 0  2  0 24  45 66 0  0  0
     90             55

    [0][1][2][3][4][5][6][7][8][9]
     2  0  2  0  1  2  1  0  0  0

    Replace to new nums values:
    [0][1][2][3][4][5][6][7][8][9]
     2  2  4  4  5  7  8  8  8  8

    Tmp array is:
    [0] [1] [2] [3] [4] [5] [6] [7]
    170 90  2   802  24  45  55  66

    STEP 1: divider = 10;
     digits:
    [0][1][2][3][4][5][6][7][8][9]
     2  0  1  0  1  1  1  1  0  1

    etc...

     */
}
