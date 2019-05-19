package com.kamalova.leetcode;

import java.util.*;

/*
Success (but very slow! and heavy!)
Details 
Runtime: 143 ms, faster than 26.68% of Java online submissions for Word Search II. 
Memory Usage: 58.4 MB, less than 5.00% of Java online submissions for Word Search II.
*/

public class WordSearchII {

    Map<Character, List<Pair>> map = new HashMap<>();

    public List<String> findWords(char[][] board, String[] words) {
        boardAnalyse(board);
        TrieNode root = buildTrie(words);
        //printTrie(root);
        return findWords(root);
    }

    private void boardAnalyse(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                map.computeIfAbsent(c, key -> new ArrayList<>());
                map.get(c).add(new Pair(i, j));
            }
        }
    }

    private List<String> findWords(TrieNode root) {
        List<String> result = new ArrayList<>();

        for (Map.Entry<Character, TrieNode> entry
                : root.chields.entrySet()) {
            char c = entry.getKey();
            TrieNode node = entry.getValue();
            Set<Pair> visited = new HashSet<>();
            if (map.containsKey(c)) {
                for (Pair p : map.get(c)) {
                    visited.add(p);
                    compute(p, node, result, visited);
                    visited.remove(p);
                }
            }
        }
        return result;
    }


    private void compute(Pair currentPair, TrieNode node, List<String> result,
                         Set<Pair> visited) {
        if (node.word != null && !result.contains(node.word)) result.add(node.word);

        for (Map.Entry<Character, TrieNode> entry : node.chields.entrySet()) {
            char c = entry.getKey();
            TrieNode nextNode = entry.getValue();
            if (map.containsKey(c)) {
                for (Pair pair : map.get(c)) {
                    if (isNeighboard(currentPair, pair) && !visited.contains(pair)) {
                        visited.add(pair);
                        compute(pair, nextNode, result, visited);
                        visited.remove(pair);
                    }
                }
            }
        }
    }

    private boolean isNeighboard(Pair p1, Pair p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y) <= 1;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            insertNode(root, word);
        }
        return root;
    }

    private void insertNode(TrieNode root, String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            current = current.chields
                    .computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }
        current.word = word;
    }

    private class TrieNode {
        Map<Character, TrieNode> chields = new HashMap<>();
        String word;
    }

    private class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private void printTrie(TrieNode root) {
        if (!root.chields.entrySet().isEmpty()) System.out.print("Values: ");
        for (Map.Entry<Character, TrieNode> entry : root.chields.entrySet()) {
            System.out.print(entry.getKey());
            System.out.print(" ");
        }
        System.out.println();

        for (Map.Entry<Character, TrieNode> entry : root.chields.entrySet()) {
            System.out.println("Level for " + entry.getKey());
            printTrie(entry.getValue());
        }
    }


    public static void main(String[] args) {
        WordSearchII ws = new WordSearchII();
//        char[][] chars = new char[][]
//                {{'o','a','a','n'},
//                        {'e','t','a','e'},
//                        {'i','h','k','r'},
//                        {'i','f','l','v'}};
//        String[] s = new String[]{"oath","eat"};
        char[][] chars = new char[][]{{'a', 'a'}};
        String[] s = new String[]{"aaa"};
        List<String> words = ws.findWords(chars, s);
        words.forEach(System.out::println);
    }
}
