/*
 * Copyrights: Asset Control International B.V.
 * All Rights Reserved.
 *
 */
package com.kamalova.utils;

public class TreeNode
{
    public Integer val; //Value
    public Integer ht; //Height
    public TreeNode left = null; //Left child
    public TreeNode right = null; //Right child

    public TreeNode() {}

    public TreeNode(Integer x) {
        val = x;
    }

    public TreeNode(Integer x, Integer ht) {
        val = x;
    }

    @Override
    public String toString()
    {
        return "TreeNode{" +
            "val=" + val +
            ", ht=" + ht +
            ", left=" + left.toString() +
            ", right=" + right.toString() +
            '}';
    }
}

