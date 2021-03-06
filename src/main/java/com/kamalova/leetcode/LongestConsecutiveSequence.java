package com.kamalova.leetcode;

import java.util.*;
/*
Success
Details 
Runtime: 7 ms, faster than 56.55% of Java online submissions for Longest Consecutive Sequence.
Memory Usage: 35.8 MB, less than 77.91% of Java online submissions for Longest Consecutive Sequence.
*/
class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }   
        int max = 1;
        int curMax = 1;
        
        for (int num : nums) {
            if (set.contains(num + 1)) {
                int next = num + 1;
                while (set.contains(next)) {
                    set.remove(next);
                    next = next + 1;
                    curMax++;
                }
            }
            if (set.contains(num - 1)) {
                int next = num - 1;
                while (set.contains(next)) {
                    set.remove(next);
                    next = next - 1;
                    curMax++;
                }
            }
            max = Math.max(max, curMax);
            curMax = 1;
        }
        
        return max;
    }
}
