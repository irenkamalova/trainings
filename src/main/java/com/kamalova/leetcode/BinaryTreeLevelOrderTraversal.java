package kamalova.com.leetcode;

import java.util.*;

class BinaryTreeLevelOrderTraversal {
    Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
    Map<TreeNode, Integer> depths = new HashMap<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        
        levelOrder(root, null); // 3, null
        
        for (List<Integer> l : map.values()) {
            res.add(l);
        }
        return res;
    }
    
    void levelOrder(TreeNode node, TreeNode parent) {
        if (node != null) { // reduce later
            Integer depth = 0;
            if (parent != null) {
                depth = depths.get(parent) + 1; // 1
            }
            depths.put(node, depth); // 3 -> 0; 9 -> 1; 1 -> 2; 2 -> 2; 20 -> 1;
            
            map.computeIfAbsent(depth, d -> new ArrayList<Integer>()); // 0 -> [3]; 1 -> [9];
            map.get(depth).add(node.val); // 2 -> [1]; 2 -> [1, 2]; 1 -> [9, 20];
            
            if (node.left != null) { // 20 -> 15;
                levelOrder(node.left, node); // 1
            }
            if (node.right != null) { // 20 -> 7
                levelOrder(node.right, node);
            }
        }
    }
}
