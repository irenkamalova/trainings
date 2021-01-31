/*
 * Copyrights: Asset Control International B.V.
 * All Rights Reserved.
 *
 */
package com.kamalova.rank;

import com.kamalova.utils.Node;

public class AVLTree2
{
    static Node insert(Node node, int val) {
        if (node == null) {
            Node result = new Node();
            result.val = val;
            result.ht = 1;
            return result;
        }
        if (node.val == val) return node; // nothing should be changed
        if (node.val > val) {
            node.left = insert(node.left, val);
        } else {
            node.right = insert(node.right, val);
        }
        int leftHeight = getSize(node.left);
        int rightHeight = getSize(node.right);
        if (rightHeight - leftHeight > 1) {
            return rotateRight(node);
        }
        if (leftHeight - rightHeight > 1) {
            return rotateLeft(node);
        }
        node.ht = getSize(node.left) + getSize(node.right) + 1;
        return node;
    }

    static Node rotateRight(Node root) {
        Node newRoot = root.right;
        root.right = root.right.left;
        newRoot.left = root;
        correctHeight(newRoot);
        return newRoot;
    }

    static Node rotateLeft(Node root) {
        Node newRoot = root.left;
        root.left = root.left.right;
        newRoot.right = root;
        correctHeight(newRoot);
        return newRoot;
    }

    static int bFactor(Node node) {
        return getSize(node.left) - getSize(node.right);
    }

    static int getSize(Node node) {
        return node == null ? 0 : node.ht;
    }

    static void correctHeight(Node node){
        int heightLeft = getSize(node.left);
        int heightRight = getSize(node.right);
        node.ht = Math.max(heightLeft, heightRight) + 1;
    }

}
