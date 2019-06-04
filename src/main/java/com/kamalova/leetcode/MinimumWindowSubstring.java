package com.kamalova.leetcode;

import java.util.*;

class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";
        
        Map<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int count = dict.getOrDefault(c, 0);
            dict.put(c, count + 1);
        }
        int req = dict.keySet().size();
        
        int minWin = Integer.MAX_VALUE;
        int indexLeft = 0;
        int indexRight = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        int formed = 0;
        
        int right = 0;
        int left = 0;
        
        while (right < s.length()) {
            char c = s.charAt(right);
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
            
            if (dict.containsKey(c) && dict.get(c).equals(map.get(c))) {
                formed++;
            }
            
            while (left <= right && formed == req) {
                if (right - left + 1 < minWin) {
                    minWin = right - left + 1;
                    indexLeft = left;
                    indexRight = right;
                }
                         
                c = s.charAt(left);
                map.put(c, map.get(c) - 1);
                if (dict.containsKey(c) && 
                    map.get(c).intValue() < dict.get(c).intValue()) {
                    formed--;
                }
                left++;    
            }
            
            right++;
        }
        
        return minWin == Integer.MAX_VALUE ? "" : s.substring(indexLeft, indexRight + 1); 
    }
}
