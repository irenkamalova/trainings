package com.kamalova.leetcode;

/*
Success
Details 
Runtime: 1 ms, faster than 99.77% of Java online submissions for Trapping Rain Water.
Memory Usage: 36.5 MB, less than 99.70% of Java online submissions for Trapping Rain Water.

The simple and fast, but wrote from ideas in solutions 
*/

class TrappingRainWater {
    public int trap(int[] height) {
        int sum = 0;
        int[] h = height; // to shorter writing
        int size = h.length;
        int[] maxLeft = new int[size];
        int[] maxRight = new int[size];
        
        int max = 0;
        for (int i = 0; i < size; i++) {
            max = Math.max(max, h[i]);
            maxLeft[i] = max;
        }
        max = 0;
        for (int i = size - 1; i >= 0; i--) {
            max = Math.max(max, h[i]);
            maxRight[i] = max;
        } 
        
        for (int i = 0; i < size; i++) {
            sum += Math.min(maxLeft[i], maxRight[i]) - h[i];
        }
        return sum;
    }
}
