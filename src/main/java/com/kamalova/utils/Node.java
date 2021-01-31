/*
 * Copyrights: Asset Control International B.V.
 * All Rights Reserved.
 *
 */
package com.kamalova.utils;


public class Node
{
    public Integer val; //Value
    public Integer ht; //Height
    public Node left = null; //Left child
    public Node right = null; //Right child

    public Node() {}

    public Node(Integer x) {
        val = x;
    }

    public Node(Integer x, Integer ht) {
        val = x;
    }

    @Override
    public String toString()
    {
        return "Node{" +
            "val=" + val +
            ", ht=" + ht +
            ", BF=" + bFactor(this) +
            (left == null ? "" : "\n\tleft=" + left.toString("\t")) +
            (right == null ? "" : "\n\tright=" + right.toString("\t")) +
            '}';
    }

    public String toString(String tab)
    {
        return "Node{" +
            "val=" + val +
            ", ht=" + ht +
            ", BF=" + bFactor(this) +
            (left == null ? "" : "\n\t" + tab + "left=" + left.toString("\t" + tab)) +
            (right == null ? "" : "\n\t" + tab + "right=" + right.toString("\t" + tab)) +
            '}';
    }

    // to help:
    // https://www.hackerrank.com/challenges/self-balancing-tree/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign

    static int bFactor(Node node) {
        return getSize(node.left) - getSize(node.right);
    }

    static int getSize(Node node) {
        return node == null ? 0 : node.ht;
    }
}
