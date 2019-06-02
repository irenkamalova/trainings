package com.kamalova.leetcode;

import java.util.*;
/*
Details 
Runtime: 14 ms, faster than 40.28% of Java online submissions for Serialize and Deserialize Binary Tree.
Memory Usage: 37.2 MB, less than 99.94% of Java online submissions for Serialize and Deserialize Binary Tree.
*/


public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            if (sb.length() != 0) {
                sb.append(",");
            }
            TreeNode curr = q.remove();
            if (curr == null) {
                sb.append("null");
            } else {
                sb.append(curr.val);
                q.add(curr.left);
                q.add(curr.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;

        String[] split = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        int val = Integer.valueOf(split[0]);
        TreeNode root = new TreeNode(val);
        q.add(root);
        int i = 1;
        while (i < split.length) {
            TreeNode tr = q.poll();
            TreeNode left = getFromData(split, i);
            if (left != null) {
                tr.left = left;
                q.add(left);
            }
            i++;
            if (i < split.length) {
                TreeNode right = getFromData(split, i);
                if (right != null) {
                    tr.right = right;
                    q.add(right);
                }
                i++;
            }
        }
        return root;
    }

    private TreeNode getFromData(String[] split, int i) {
        if (!"null".equals(split[i])) {
            int vl = Integer.valueOf(split[i]);
            return new TreeNode(vl);
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        String s = "1,2,3,null,null,4,null,null,5";
        //String s = "1,null,2";
        //String s = "";
        Codec codec = new Codec();

        TreeNode deserialize = codec.deserialize(s);
        String serialize = codec.serialize(deserialize);
        System.out.println(serialize);

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
