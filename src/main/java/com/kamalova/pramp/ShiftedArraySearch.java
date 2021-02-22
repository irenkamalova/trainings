package com.kamalova.pramp;

import java.io.*;
import java.util.*;

/*

Good example for binary search

 */

class ShiftedArraySearch {

    static int shiftedArrSearch(int[] shiftArr, int num) {
        // your code goes here
        // first step
        // find shifted position

        int size = shiftArr.length;
        if (size == 0) return -1;
        if (size == 1)
            return (shiftArr[0] == num) ? 0 : -1;


        int start = 0;
        int end = size - 1;
        //boolean foundShifed = false;
        int shiftedPosition = -1;

        while (start <= end && shiftedPosition == -1) {
            int pos = start + (end - start) / 2;
            if  (pos == 0 || shiftArr[pos] < shiftArr[pos - 1]) {
                shiftedPosition = pos;
            }
            else {
                // [9, 12, 17, 18, 2, 4, 5] 18 <= 9 -> no -> go right
                if (shiftArr[pos] <= shiftArr[0]) {
                    // go left
                    end = pos - 1;
                } else {
                    // go right
                    start = pos + 1;
                }
            }
        }

        if (shiftedPosition == -1) shiftedPosition = 0;

        System.out.println("Shited position: " + shiftedPosition);

        // s = start element for sorted array
        // [17, 2] -> 5
        if (shiftedPosition == 0 || num < shiftArr[0]) {
            // go right
            return findElement(shiftArr, shiftedPosition, shiftArr.length, num);
        } else {
            // go left
            return findElement(shiftArr, 0, shiftedPosition, num);
        }
    }

    static int findElement(int[] a, int start, int end, int num) {
        //  [2,3,4,5,6,7,17,20] -> 1
        // start = 0; end = 7, num = 20; -> pos1 = 3 -> a[3] = 5 < -> start = 3;
        // pos1 = 3 + (7 - 3) / 2 = 5 -> a[5] = 7; a[5] < 20 -> s = 5
        // pos1 = 5 + (7 - 5) / 6 = 6;
        while (start <= end) { // && position == -1
            int pos1 = start + (end - start) / 2;
            if (a[pos1] == num)
                return pos1;
            if  (a[pos1] > num) {
                // go left
                end = pos1 - 1;
            }
            else {
                // go right
                start = pos1 + 1;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        //System.out.println(findElement(new int[]{2,3,4,5,6,7,17,20}, 0, 7, 20));
        System.out.println(shiftedArrSearch(new int[]{9, 12, 17, 18, 2, 4, 5}, 9));
        System.out.println(shiftedArrSearch(new int[]{9, 12, 17, 18, 2, 4, 5}, 12));
        System.out.println(shiftedArrSearch(new int[]{9, 12, 17, 18, 2, 4, 5}, 17));
        System.out.println(shiftedArrSearch(new int[]{9, 12, 17, 18, 2, 4, 5}, 18));
        System.out.println(shiftedArrSearch(new int[]{9, 12, 17, 18, 2, 4, 5}, 2));
        System.out.println(shiftedArrSearch(new int[]{9, 12, 17, 18, 2, 4, 5}, 4));
        System.out.println(shiftedArrSearch(new int[]{9, 12, 17, 18, 2, 4, 5}, 5));

    }

  /*
  edge cases:
  [] -> -1
  [1] != num -> -1 else 0
  [1, 2] length = 2; pos1 = 0; pos2 = 1;



  brute solution:
  just every element with given number
  O(N)


  first:
  sorted array -> binary search O(logN) the number given

  find out where is shifter -> binary search -> O(logN)

  whole complexity: O(logN)


  [9, 12, 17, 2, 4, 5], size = 6

  [2] vs [3]

   [17, 2, 4, 5, 9, 12], size = 6

   [2, 4, 5, 9, 12, 1], size = 6

    [2] vs [3]

    [17, 2, 4]

    [5, 9, 12]

    -> O(NlogN)

  */

}
