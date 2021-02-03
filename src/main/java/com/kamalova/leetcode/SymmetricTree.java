package com.kamalova.leetcode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        List<Integer> right = bfsRight(root.right);
        List<Integer> left = bfsLeft(root.left);
        System.out.println(right);
        System.out.println(left);
        return right.equals(left);
    }

    Comparator<TreeNode> comparator = (o1, o2) -> {
        if (o1 == null && o2 == null) return 0;
        if (o1 == null) return -1;
        return Integer.compare(o1.val, o2.val);
    };

    //boolean compare()

    List<Integer> bfsRight(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Set<TreeNode> seen = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (!seen.contains(node)) {
                list.add(node.val);
                seen.add(node);
                if (node.right != null)
                    queue.add(node.right);
                if (node.left != null)
                    queue.add(node.left);
            }
        }
        return list;
    }


    List<Integer> bfsLeft(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Set<TreeNode> seen = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (!seen.contains(node)) {
                list.add(node.val);
                seen.add(node);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return list;
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
