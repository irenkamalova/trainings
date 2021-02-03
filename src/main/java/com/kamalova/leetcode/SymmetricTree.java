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
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode nodeRight = queue.poll();
            TreeNode nodeLeft = queue.poll();
            if (nodeRight == null && nodeLeft == null) {
                continue;
            }
            if (nodeRight == null || nodeLeft == null || nodeRight.val != nodeLeft.val) {
                return false;
            }

            queue.add(nodeRight.left);
            queue.add(nodeLeft.right);
            queue.add(nodeRight.right);
            queue.add(nodeLeft.left);

        }
        return true;

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
