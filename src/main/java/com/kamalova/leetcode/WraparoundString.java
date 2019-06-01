package com.kamalova.image;

import java.util.*;

/*
First attempt - brute force solution (using substring brute method)
(time limited exceed)
*/
class WraparoundString {
    public int findSubstringInWraproundString(String p) {

        int n = p.length();
        Map<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j <= n; j++) {
                if (!map.containsKey(p.substring(i, j))) {
                    map.put(p.substring(i, j), isWrapAround(p.substring(i, j), map));
                }
                if (!map.containsKey(p.substring(j, n))) {
                    map.put(p.substring(j, n), isWrapAround(p.substring(j, n), map));
                }
            }
        }
        int res = 0;
        for (Boolean b : map.values()) {
            if (b) res++;
        }
        return res;
    }

    private boolean isWrapAround(String p) {
        if (p.length() == 0) return false;
        for (int i = 0; i < p.length() - 1; i++) {
            if ( ((p.charAt(i) - 'a') + 1) % 26 != (p.charAt(i + 1) - 'a')) return false;
            // a = 0; a -> next = a + 1 = 1, 1 % 26 = 1 == 'b' -> 'ab' -> true
            // z = 25, z -> next = z + 1 = 26, 26 % 26 == 0 == 'a' -> 'za' -> true
        }
        return true;
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findSubstringInWraproundString("zab"));
        int a = s.findSubstringInWraproundString("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz");
        System.out.println(a); // 34151
    }
}
