package com.kamalova.leetcode;

import java.util.HashMap;

public class Trie {
    /*
    Success
    Details
    Runtime: 88 ms, faster than 42.70% of Java online submissions for Implement Trie (Prefix Tree).
    Memory Usage: 50.9 MB, less than 98.36% of Java online submissions for Implement Trie (Prefix Tree).
     */

    private TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            current = current.children
                    .computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) return false;
            current = node;
        }
        return current.isWord;
    }

    public boolean startsWith(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) return false;
            current = node;
        }
        return true;
    }

    public class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isWord;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("a"));
        System.out.println(trie.startsWith("ap"));
        System.out.println(trie.startsWith("app"));
        System.out.println(trie.startsWith("appl"));
        System.out.println(trie.startsWith("appple"));
        System.out.println("m is " + trie.search("m"));
        System.out.println("m is " + trie.startsWith("m"));
    }
}
