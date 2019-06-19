package com.kamalova.leetcode;

import java.util.*;

/*
Brute
Time limit exceeded
*/

public class CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            l.add(0);
        }

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (map.containsKey(nums[i])) {
                freq.put(nums[i], freq.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 0);
                freq.put(nums[i], 0);
            }

            Integer diff = map.get(nums[i]);

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer prevNum = entry.getKey();
                if (nums[i] > prevNum) {
                    map.put(nums[i], map.get(nums[i]) + 1 + freq.get(prevNum));
                }
            }
            l.set(i, map.get(nums[i]) - diff);
        }

        return l;
    }
}
    
