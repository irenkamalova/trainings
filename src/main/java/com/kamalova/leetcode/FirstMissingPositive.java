package com.kamalova.leetcode;

/*
Success
Details 
Runtime: 12 ms, faster than 5.56% of Java online submissions for First Missing Positive. (SLOW)
Memory Usage: 35.4 MB, less than 98.39% of Java online submissions for First Missing Positive. (No extra space)

*/

class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        // step 1 - sort array and don't use any space :)
        int n = nums.length;
        // edge
        if (n == 0) return 1;
        // edge
        int[] a = nums;
        if (n == 1) {
            return a[0] == 1 ? 2 : 1; 
        }
        
        int i = 0;
        while (i < n) {
            int j = 0; // count of operations
            while (a[i] != i + 1 && a[i] > 0 && a[i] <= n && j < n) {
                int temp = a[a[i] - 1];
                a[a[i] - 1] = a[i];
                a[i] = temp;
                j++;
            } 
            i++;
        }
        for (i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        
        for (i = 0; i < n; i++) {
            if (a[i] != i + 1) return i + 1;
        }
                
        return i + 1;
    }
}
