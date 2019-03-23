package com.kamalova.pramp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PairsWithGivenDifference {

    static int[][] findPairsWithGivenDifference(int[] arr, int k) {
        Set<Integer> setX = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            setX.add(arr[i]); // add is O(1)
        }

        List<int[]> list = new ArrayList<>();
        // x - y = k
        for (int y : arr) {
            int x = y + k;
            // looking on containing element is O(1)
            if (setX.contains(x)) {
                list.add(new int[]{x, y});
            }
        }

        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i)[0];
            result[i][1] = list.get(i)[1];
        }
        return result;
        // time is O(N)
        // memory is O(N)
    }


    static int[][] findPairsWithGivenDifferenceBad(int[] arr, int k) {
        // your code goes here
        // arr = [0, -1, -2, 2, 1], k = 1
        // -1 - (-2) = k = 1;
        Set<Integer> set = new HashSet<>();
        int diff = arr[0] - k; // {-1}
        // int[][] result = new int[arr.length * arr.length][2];
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        set.add(arr[0]);
        set.add(diff);
        for (int i = 1; i < arr.length; i++) { // 4 a[3] = 1
            if (set.contains(arr[i])) {
                int[] arrayInt = new int[] {k + arr[i], arr[i]}; // [2 , 1]
                Pair<Integer, Integer> pair = new Pair<>(k + arr[i], arr[i]);
                list.add(pair);
                // result[j] = arrayInt; // res[0]
                // j++;
            }
            // -1 set.add(2 - 1) = add (1)
            set.add(arr[i] - k); // {-1, -2, -3, }
            // x - y = k => y = x - k
        }
        int[][] res = new int[list.size()][2];
        return res;
    }

    static class Pair<K, V> {
        K v1;
        V v2;
        Pair(K v1, V v2) {
            this.v1 = v1;
            this.v2 = v2;
        }
    }

    public static void main(String[] args) {
        // arr = [0, -1, -2, 2, 1], k = 1

        // 0
        // -1
        // 0 - (-1) = k ?

        // 0 = x (x - y) = k = 1 -> -1
        // ? -1



    }


}
