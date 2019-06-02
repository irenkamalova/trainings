package com.kamalova.leetcode;

import java.util.*;

/*
Success
Details 
Runtime: 2 ms, faster than 99.28% of Java online submissions for All Paths From Source to Target.
Memory Usage: 41.3 MB, less than 84.91% of Java online submissions for All Paths From Source to Target.
*/

class AllPathsFromSourcetoTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> l = new ArrayList<>();
        l.add(0);
        List<List<Integer>> res = new ArrayList<>();
        dfs(graph, graph[0], 0, l, res);
        return res;
    }
    
    void dfs(int[][] graph, int[] nodes, int node, List<Integer> l, List<List<Integer>> res) {
        if (node == graph.length - 1) {
            res.add(new ArrayList<>(l));
        }
        
        for (int nod : nodes) {
            l.add(nod);
            dfs(graph, graph[nod], nod, l, res);
            l.remove(l.size() - 1);
        }
    }
}
