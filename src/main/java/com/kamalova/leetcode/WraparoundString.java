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

    private boolean isWrapAround(String p, Map<String, Boolean> map) {
        if (p.equals("")) return false;
        String s = "abcdefghijklmnopqrstuvwxyz";
        if (p.length() > 26) {
            for (int i = 0; i < p.length() / 26; i++) {
                if (!map.containsKey(p.substring(i * 26, i * 26 + 26))) {
                    boolean answer = isWrapAround(p.substring(i * 26, i * 26 + 26), map);
                    map.put(p.substring(i * 26, i * 26 + 26), answer);
                    if (!answer) return false;
                }
            }
            return true;
        }

        if (map.containsKey(p)) return map.get(p);

        for (int i = 0; i < 26; i++) {
            if (s.contains(p)) return true;
            s = s.charAt(25) + s.substring(0, 25);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findSubstringInWraproundString("zab"));
        int a = s.findSubstringInWraproundString("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz");
        System.out.println(a); // 34151
    }
}
