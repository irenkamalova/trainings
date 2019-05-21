package com.kamalova.leetcode;

import java.util.*;

public class TreeTraversesIterable {

    // the most popular - postOrder
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        if (root == null) return l;
        funcPostOrder(root, l);
        return l;
    }

    // for comparing
    private void funcPostOrder(TreeNode c, List<Integer> l) {
        if (c.left != null) {
            funcPostOrder(c.left, l);
        }
        if (c.right != null) {
            funcPostOrder(c.right, l);
        }
        l.add(c.val);
    }

    public List<Integer> postorderTraversalIterable(TreeNode root) {

        List<Integer> l = new ArrayList<>();
        if (root == null) return l;
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode c = stack.peek();
            if (c.left != null && !visited.contains(c.left)) {
                stack.push(c.left);
            } else
            if (c.right != null && !visited.contains(c.right)) {
                stack.push(c.right);
            } else {
                stack.pop();
                visited.add(c);
                l.add(c.val);
            }
        }
        return l;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Integer[] tree = new Integer[]{1, 2, 3, null, null, 5, 6};
        TreeTraversesIterable tr = new TreeTraversesIterable();
        //  binary tree from given array IN LEVEL ORDER FASHION
        TreeNode treeNode = tr.fromArray(tree);
        List<Integer> list = tr.postorderTraversalIterable(treeNode);
        list.forEach(System.out::println); // postOrder is 2 4 6 3 1

    }

    //  binary tree from given array IN LEVEL ORDER FASHION
    public TreeNode fromArray(Integer[] tree) {
        if (tree.length == 0) return null;
        TreeNode root = addNode(tree, 0);
        return root;
    }

    //  binary tree from given array IN LEVEL ORDER FASHION
    private TreeNode addNode(Integer[] tree, int i) {
        if (i < tree.length && tree[i] != null) {
            TreeNode node = new TreeNode(tree[i]);
            node.left = addNode(tree, 2 * i + 1);
            node.right = addNode(tree, 2 * i + 2);
            return node;
        } else return null;
    }
}
