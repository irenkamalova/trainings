package com.kamalova.leetcode;

import java.util.*;

/*
Success
Details 
Runtime: 140 ms, faster than 5.13% of Java online submissions for Word Search.
Memory Usage: 45.3 MB, less than 13.04% of Java online submissions for Word Search.
*/

class WordSearchMedium {
    Map<String, List<Pair>> map = new HashMap<>();

    public boolean exist(char[][] board, String word) {
        // edges
        if (word.length() == 0) return true;
        
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                String s = String.valueOf(c);
                map.computeIfAbsent(s, key -> new ArrayList<Pair>());
                map.get(s).add(new Pair(i, j));
            }
        }
        
        String a = word.substring(0,1);
        List<Pair> firstPairs;
        Set<Pair> set = new HashSet<>();
        if (map.containsKey(a)) {
            if (word.length() == 1) return true;
            else {
                firstPairs = map.get(a);
                for (Pair p : firstPairs) {
                    set.add(p);
                    if (compute(word.substring(1), p, set)) {
                        return true;
                    } else {
                        set.remove(p);
                    }
                }
            }
        }
       
        return false;
    }
    
    private boolean compute(String word, Pair currentP, Set<Pair> set) {
        if (word.length() == 0) return true;
        String a = word.substring(0,1);
        if (map.containsKey(a)) {
            List<Pair> pairs = map.get(a);
            for (Pair p : pairs) {
               if (!set.contains(p) && isNeighboard(p, currentP)) {
                   set.add(p);
                   if (compute(word.substring(1), p, set)) {
                        return true;
                    } else {
                       set.remove(p);
                   }
                } 
            } // cycle ended, but we don't found value:
            return false;
        } else return false;
    }
    
    private boolean isNeighboard(Pair p1, Pair p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y) <= 1;
    }
    
    private class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
