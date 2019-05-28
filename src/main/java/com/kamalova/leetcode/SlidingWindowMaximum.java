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
    
    /*
    Details 
    Runtime: 39 ms, faster than 19.86% of Java online submissions for Sliding Window Maximum.
    Memory Usage: 40.2 MB, less than 86.63% of Java online submissions for Sliding Window Maximum.
    */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int N = nums.length;
        if (N == 0 || k == 0) return new int[0];
        int[] result = new int[N - k + 1];
        
        // with prioprity queue
        PriorityQueue<Integer> set = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            set.add(nums[i]);
        }
        result[0] = set.peek();
        
        for (int i = 1; i < N - k + 1; i++) {
            set.remove(nums[i - 1]);
            set.add(nums[i + k - 1]);
            result[i] = set.peek();
        }
        return result;
    }
    
    /*
    Success
Details 
Runtime: 11 ms, faster than 56.08% of Java online submissions for Sliding Window Maximum.
Memory Usage: 40.3 MB, less than 85.82% of Java online submissions for Sliding Window Maximum.
Get idea from discussions.
    */
    public int[] maxSlidingWindow3(int[] nums, int k) {
        int N = nums.length;
        if (N == 0 || k == 0) return new int[0];
        int[] result = new int[N - k + 1];
        
        LinkedList<Integer> l = new LinkedList<>();
        
        for (int i = 0; i < k; i++) {
            insert(l, nums[i]);
        }
        result[0] = l.peekFirst();
        
        for (int i = 1; i < N - k + 1; i++) {
            
            if (l.peekFirst() == nums[i - 1]) {
                l.removeFirst();
            }
            insert(l, nums[i + k - 1]);
            result[i] = l.peekFirst();

        }
        return result;
    }
    
    private void insert(LinkedList<Integer> l, int number) {
        while(!l.isEmpty() && l.peekLast() < number) {
            l.removeLast();
        }
        l.add(number);
    }

}
