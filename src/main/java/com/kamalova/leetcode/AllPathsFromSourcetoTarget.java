package com.kamalova.leetcode;

import java.util.*;

/*
Success
Details 
Runtime: 4 ms, faster than 42.67% of Java online submissions for All Paths From Source to Target.
Memory Usage: 39 MB, less than 99.93% of Java online submissions for All Paths From Source to Target.
*/

class AllPathsFromSourcetoTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<Integer> l = new ArrayList<>();
        l.add(0);
        return dfs(graph, graph[0], l);
    }
    
    List<List<Integer>> dfs(int[][] graph, int[] nodes, List<Integer> l) {
        List<List<Integer>> res = new ArrayList<>();
        for (int node : nodes) {
            List<Integer> nL = new ArrayList<>();
            nL.addAll(l);
            nL.add(node);
            List<List<Integer>> res2 = dfs(graph, graph[node], nL);
            if (res2.isEmpty()) {
            res.add(nL);
            } else {
            res.addAll(res2);
            }
        }
        
        return res;
    }
}
