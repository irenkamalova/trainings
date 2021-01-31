package com.kamalova.leetcode;

import java.util.*;

/*
Get (good) decision from discussion

Success
Details 
Runtime: 6 ms, faster than 93.71% of Java online submissions for Unique Substrings in Wraparound String.
Memory Usage: 35 MB, less than 98.75% of Java online submissions for Unique Substrings in Wraparound String.

*/
class WraparoundString {
    public int findSubstringInWraproundString(String p) {
        int n = p.length();
        int[] lenghts = new int[26];

        int start;
        int current = 0;
        while (current < n) {
            start = current;
            while ((current < n - 1) && (getInt(p, current) + 1) % 26 == getInt(p, current + 1)) {
                current++;
            }

            for (int i = start; i <= current; i++) {
                int numberOfAppearances = current - i + 1; // 1 - about letter exactly
                if (numberOfAppearances <= lenghts[getInt(p, i)]) {
                    break;
                }
                lenghts[getInt(p, i)] = numberOfAppearances;
            }
            current++;
        }

        int res = 0;
        for (int i : lenghts) {
            res += i;
        }
        return res;
    }

    private int getInt(String p, int index) {
        return p.charAt(index) - 'a';
    }

    public static void main(String[] args) {
        WraparoundString s = new WraparoundString();
        System.out.println(s.findSubstringInWraproundString("erflokatkn"));
        int a = s.findSubstringInWraproundString("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz");
        System.out.println(a);
    }

    /*
    For debugging:
    
    a b c d e f g h i j k  l  m  n  o   p   q   r   s  t  u  v   w   x  y   z
    0 1 2 3 4 5 6 7 8 9 10 11 12 13 14  15  16  17 18 19 20 21  22  23 24  25

     */
}
