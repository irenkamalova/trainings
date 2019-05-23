package com.kamalova.leetcode;

class WildcardMatching {
    /*
    Dynamic Programming approach    
    Success
    Details 
    Runtime: 12 ms, faster than 75.84% of Java online submissions for Wildcard Matching.
    Memory Usage: 37.4 MB, less than 98.79% of Java online submissions for Wildcard Matching.
    Get idea from the video https://www.youtube.com/watch?v=l3hda49XcDE
    and adopted to conditions :)
    */
    
    public boolean isMatch(String s, String p) {
        if (s.equals(p)) return true;
        if (p.equals("*")) return true;
        
        char[] text = s.toCharArray();
        char[] pattern = p.toCharArray();
        
        int N = s.length() + 1;
        int M = p.length() + 1;
        boolean[][] T = new boolean[N][M];
        
        T[0][0] = true;
        // deal with *a*b*c*
        for (int i = 1; i < M; i++) {
            if (pattern[i - 1] == '*') {
                T[0][i] = T[0][i - 1];
            }
        }
        
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (pattern[j - 1] == text[i - 1] || pattern[j - 1] == '?') {
                    T[i][j] = T[i - 1][j - 1];
                } else if (pattern[j - 1] == '*') {
                        T[i][j] = T[i - 1][j] || T[i][j - 1];
                } else T[i][j] = false;
            }
        }
        
        return T[N - 1][M - 1];
    }
}
