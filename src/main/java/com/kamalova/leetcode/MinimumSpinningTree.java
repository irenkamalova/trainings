package com.kamalova.leetcode;

import java.util.HashSet;
import java.util.Set;

public class MinimumSpinningTree {

    public int[][][] find(int[][][] graph) {
        int[][][] answer = new int[graph.length - 1][1][2];
        Set<Integer> visited = new HashSet<>();

        int numberOfnode = 0;
        for(; numberOfnode < graph.length - 1; numberOfnode++) {
            int[][] edges = graph[numberOfnode];
            int min = Integer.MAX_VALUE;
            int numberOfMin = 0;
            int numberOfEdge = 0;
            for(int[] edge : edges) {
                if (edge[1] < min && !visited.contains(edge[0])) {
                    min = edge[1];
                    numberOfMin = numberOfEdge;
                }
                numberOfEdge++;
            }
            answer[numberOfnode][0][0] = edges[numberOfMin][0];
            answer[numberOfnode][0][1] = min;
            visited.add(edges[numberOfMin][0]);
        }
        return answer;

    }

    public static void main(String[] args) {
        int[][][] graph =
                new int[][][]{
                        {{2, 3}, {3, 5}, {4, 3}},
                        {{1, 3}, {3, 1}},
                        {{1, 5}, {2, 1}, {4, 1}},
                        {{1, 3}, {3, 4}}
                };

        MinimumSpinningTree m = new MinimumSpinningTree();
        int[][][] answer = m.find(graph);

        int i = 1;
        for (int[][] nodes: answer) {
            System.out.print(i + " -> ");
            for (int[] node : nodes) {
                System.out.print(node[0] + "(" + node[1] + ")");
            }
            System.out.println();
            i++;
        }
    }

    /*
    Graph:

            1
     (3) /  |  \ (3)
       2   (5)  4
     (1) \  |  / (1)
            3

     1 -> 2(3), 3(5), 4(3)
     2 -> 1(3), 3(1)
     3 -> 1(5), 2(1), 4(1)
     4 -> 1(3), 3(4)

     Answer:

            1
     (3) /
       2        4
     (1) \     / (1)
            3

     1 -> 2(3)
     2 -> 3(1)
     3 -> 4(1)

     */
}
