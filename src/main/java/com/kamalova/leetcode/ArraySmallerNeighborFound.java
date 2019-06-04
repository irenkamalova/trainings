package com.kamalova.leetcode;

import java.util.*;

/*
Simple task is:

[5,4,6,1] -> [4,1,1,0]
*/

class ArraySmallerNeighborFound {
    public List<Integer> smallerNeighbor(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        if (nums.length == 0) return res;
        if (nums.length == 1) {
            res.add(0);
            return res;
        }

        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[j]) {
                for (int k = j; k < i; k++) {
                    res.add(nums[i]);
                }
                j = i;
            }
        }
        
        for (int k = j; k < nums.length; k++) {
            res.add(0);
        }
        
        return res;
    }
}
