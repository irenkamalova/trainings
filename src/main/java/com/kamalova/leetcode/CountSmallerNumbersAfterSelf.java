package com.kamalova.leetcode;

import java.util.*;

class CountSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> smallerIntegers = new ArrayList<>();
        if (nums.length == 0) return smallerIntegers;
        TreeNode root = new TreeNode(nums[nums.length - 1]);
        smallerIntegers.add(0);
        for (int i = nums.length - 2; i >= 0; i--) {
            helper(root, nums[i], 0, smallerIntegers);
        }
        
        return smallerIntegers;
    }
    
    private void helper(TreeNode node, int data, 
                        int smallerCount, List<Integer> smInt) {
        if (node == null) {
            node = new TreeNode(data);
            smInt.add(0, smallerCount);
            return;
        }
        //System.out.println(data + "node data is " + node.data);
        
        if (data <= node.data) {
            node.leftsize++;
            if (node.left == null) {
                node.left = new TreeNode(data);
                smInt.add(0, smallerCount);
            } else {
                helper(node.left, data, smallerCount, smInt);
            }         
        } else {
            if (node.right == null) {
                node.right = new TreeNode(data);
                smInt.add(0, smallerCount + 1 + node.leftsize);
            } else {
                helper(node.right, data, smallerCount + 1 + node.leftsize, smInt);
            }
        }
    }
    
    private class TreeNode {
        int data;
        int leftsize;
        TreeNode right;
        TreeNode left;
        
        TreeNode(int data) {
            this.data = data;
        }
    }
}
