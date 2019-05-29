package com.kamalova.leetcode;

import java.util.*;


class BinaryTreeMaximumPathSum {
    /*
    Brute force solution
    Time Limit Exceeded on the big tree
    */
    
    Map<TreeNode, TreeNode> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    
    public int maxPathSum(TreeNode root) {
        // step 1 - collect nodes with parents
        if (root == null) return 0;
        map.put(root, null);
        collectParent(root);
        
        for (TreeNode tr : map.keySet()) {
            Set<TreeNode> visited = new HashSet<>();
            findPath(tr, visited, 0);
        }
        
        int max = root.val;
        for (Integer i : list) {
            max = Math.max(i, max);
        }
        
        return max;
    }
    
    private void findPath(TreeNode node, Set<TreeNode> visited,
                         int result) {
        if (node == null) return;
        visited.add(node);
        result += node.val;
        TreeNode parent = map.get(node);
        if (parent != null && !visited.contains(parent)) {
            findPath(parent, visited, result);
        }
        TreeNode left = node.left;
        if (left != null && !visited.contains(left)) {
            findPath(left, visited, result);
        }
        TreeNode right = node.right;
        if (right != null && !visited.contains(right)) {
            findPath(right, visited, result);
        }
        list.add(result);
    }
    
    private void collectParent(TreeNode node) {
        if (node == null) return;
        
        if (node.left != null) {
            map.put(node.left, node);
            collectParent(node.left);
        }
        
        if (node.right != null) {
            map.put(node.right, node);
            collectParent(node.right);
        }
    }
    
}
