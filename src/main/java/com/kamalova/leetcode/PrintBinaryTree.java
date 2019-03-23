package com.kamalova.leetcode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
Time complexity :
O(n). The preorder traversal is done over the n
n nodes of the given Binary Tree.

Space complexity :
O(n). The depth of the recursion tree can go upto n
n in case of a skewed tree.
 */

public class PrintBinaryTree {
    public String tree2str(TreeNode t) {
        if (t == null) return "";

        // induct step
        StringBuilder sb = new StringBuilder();

        sb.append(t.val);
        if (t.left != null) {
            sb.append("(");
            sb.append(tree2str(t.left));
            sb.append(")");
            if (t.right != null) {
                sb.append("(");
                sb.append(tree2str(t.right));
                sb.append(")");
            }
        } else if (t.right != null) {
            sb.append("()(");
            sb.append(tree2str(t.right));
            sb.append(")");
        }
        return sb.toString();
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}