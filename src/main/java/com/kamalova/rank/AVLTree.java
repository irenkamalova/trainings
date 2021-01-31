/*
 * Copyrights: Asset Control International B.V.
 * All Rights Reserved.
 *
 */
package com.kamalova.rank;

/*
https://www.hackerrank.com/challenges/self-balancing-tree/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign

    3
  /  \
 2    4
       \
        5

    3
  /  \
 2    5
     / \
    4   6


*/


import com.kamalova.utils.Node;

public class AVLTree
{
    public static void main(String[] args)
    {
        example2();
    }

    public static void example1() {
        Node root = insert(null, 3);
        int[] intArray = new int[]{2, 4, 5};
        for (int i : intArray)
        {
            root = insert(root, i);
        }
        System.out.println(root);
        insert(root, 6);
        System.out.println(root);
    }

    public static void example2()
    {
        Node root = insert(null, 14);
        int[] intArray = new int[]{25, 21, 10, 23, 7, 26, 12, 30, 16};
        for (int i : intArray)
        {
            root = insert(root, i);
        }
        System.out.println(root);
        root = insert(root, 19);
        System.out.println(root);
    }

    static Node insert(Node node, int val) {
        if (node == null) {
            Node result =  new Node();
            result.val = val;
            result.ht = 1;
            return result;
        }
        if (node.val == val) return node; // nothing should be changed
        if (node.val > val) {
            node.left = insert(node.left, val);
            node.ht = node.left.ht + 1;
        } else {
            node.right = insert(node.right, val);
            node.ht = node.right.ht + 1;
        }
        int leftHeight = node.left != null ? node.left.ht : 0;
        int rightHeight = node.right != null ? node.right.ht : 0;
        if (rightHeight - leftHeight > 1) {
            return rotateRight(node);
        }
        if (leftHeight - rightHeight > 1) {
            return rotateLeft(node);
        }
        return node;
    }

    static Node rotateRight(Node root) {
        Node newRoot = root.right;
        root.ht = root.right.ht - 1;
        root.right = root.right.left;
        newRoot.left = root;
        return newRoot;
    }

    static Node rotateLeft(Node root) {
        Node newRoot = root.left;
        root.ht = root.left.ht - 1;
        root.left = root.left.right;
        newRoot.right = root;
        return newRoot;
    }

}

/*
Your
2(BF=0) 3(BF=-3) 4(BF=0) 5(BF=2) 6(BF=0)
5(BF=2) 3(BF=-3) 2(BF=0) 4(BF=0) 6(BF=0)

Expected:
2(BF=0) 3(BF=-1) 4(BF=0) 5(BF=0) 6(BF=0)
3(BF=-1) 2(BF=0) 5(BF=0) 4(BF=0) 6(BF=0)
--

after

Your
2(BF=0) 3(BF=-1) 4(BF=0) 5(BF=0) 6(BF=0)
5(BF=0) 3(BF=-1) 2(BF=0) 4(BF=0) 6(BF=0)



 */