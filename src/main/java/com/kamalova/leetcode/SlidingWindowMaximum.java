package com.kamalova.leetcode;

/*
Brute force, but Accepted
Runtime: 32 ms, faster than 26.20% of Java online submissions for Sliding Window Maximum.
Memory Usage: 41.2 MB, less than 79.46% of Java online submissions for Sliding Window Maximum.
*/

class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        if (N == 0 || k == 0) return new int[0];
        int[] result = new int[N - k + 1];
        
        // brute force
        for (int i = 0; i < N - k + 1; i++) {
                result[i] = findMax(nums, i, i + k);
        }
        return result;
    }
    
    private int findMax(int[] nums, int start, int end) {
        int max = nums[start];
        for (int i = start; i < end; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
