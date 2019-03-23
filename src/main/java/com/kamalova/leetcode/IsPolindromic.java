package com.kamalova.leetcode;

public class IsPolindromic {

    private boolean isPolindrom(String s) {
        final int size = s.length();
        int i = 0;
        int j = 0;
        if (size % 2 == 0) { // 6 -> 0,1,2|3,4,5
            i = size / 2 - 1; // i = 2
            j = size / 2;     // j = 3
        } else { // 7 -> 0,1,2|3|4,5,6
            i = size / 2 - 1; // i = 2
            j = size / 2 + 1; // j = 4
        }
        while (i >= 0 && j <= size - 1) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            } else {
                i--;
                j++;
            }
        }
        return true;
    }
}
