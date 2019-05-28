package com.kamalova.leetcode;


class ValidateBinarySearchTree {
    
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean result = true;
        if (root.left != null) {
            if (root.left.val >= root.val) return false;
            result = isValidBST(root.left, null, root.val);
        }
        if (result && root.right != null) {
            if (root.right.val <= root.val) return false;
            result = isValidBST(root.right, root.val, null);
        }
        return result;
    }

    private boolean isValidBST(TreeNode root,
                               Integer minVal,
                               Integer maxVal) {
        
        if (minVal != null && root.val <= minVal) return false;
        if (maxVal != null && root.val >= maxVal) return false;
        
        boolean result = true;
        if (root.left != null) {
            Integer val = root.left.val;
            if (val >= root.val) return false;
            result = isValidBST(root.left, minVal, root.val);
        }
        if (result && root.right != null) {
            Integer val = root.right.val;
            if (val <= root.val) return false;
            result = isValidBST(root.right, root.val, maxVal);
        }
        return result;
    }

}
