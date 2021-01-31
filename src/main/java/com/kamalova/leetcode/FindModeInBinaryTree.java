package com.kamalova.leetcode;

/*
Easy task
Apllyed from the first attempt
*/
import com.kamalova.utils.TreeNode;

import java.util.*;

class FindModeInBinaryTree {
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;
    List<Integer> l = new ArrayList<>();
    
    public int[] findMode(TreeNode root) {
        check(root);
        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
            if (i.getValue() == max) {
                l.add(i.getKey());
            }
        }
        
        int[] res = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            res[i] = l.get(i);
        }
        return res;
    }
    
    private void check(TreeNode node) {
        if (node != null) {
            map.put(node.val, map.getOrDefault(node.val, 0) + 1);
            max = Math.max(map.get(node.val), max);
            check(node.left);
            check(node.right);
        }
    }
}
