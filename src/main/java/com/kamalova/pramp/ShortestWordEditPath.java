package com.kamalova.pramp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class ShortestWordEditPath {
    // "bit", "dog", ["but","put","big","pot","pog","dog","lot"]

    // complexity???

    static int shortestWordEditPath(String source, String target, String[] words) {
        if (source.equals(target)) return 0;
        if (words.length == 0) return -1;

        Set<String> visitedSet = new HashSet<>();
        PriorityQueue<String> queue = new PriorityQueue<>();
        Map<String, Integer> map = new HashMap<>();

        queue.add(source);
        map.put(source, 0);
        int path = 0;
        while(!queue.isEmpty()) {
            String currentWord = queue.remove();
            Integer currentPath = map.get(currentWord);
            //System.out.println(currentWord + ", " + currentPath);
            path = currentPath;
            visitedSet.add(currentWord);
            if (currentWord.equals(target)) return path;
            path++;
            for (String word : words) {
                if (isNeighbour(currentWord, word) && !visitedSet.contains(word)) {
                    int newPath = currentPath + 1;
                    //System.out.println("Added: " + word + ", " + (currentPath + 1));
                    queue.add(word);
                    map.put(word, currentPath + 1);
                }
            }
        }
        return -1;

        // O(N) N = source.length
        //  Source = bit
        //  Neighbours  of `bit` in words Array => ?

        // "but", "put", "big", "pot", "pog", "dog", "lot"
        // "b" -> u
        // b -> i
        // bit -> dog

        // bit -> big
        // bit -> but

        // How do you know 2 words are neighbors? Can you think of some helper function?
        // are you trying Breadth First Search or Depth FS?
        // you need to implement BFS
    }


    static boolean isNeighbour(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
            if (diff > 1) return false;
        }
        return diff == 1;
    }

    public static void main(String[] args) {
        //System.out.println(shortestWordEditPath(
        //  "bit", "dog", new String[]{"but","put","big","pot","pog","dog","lot"}
        //));
        //System.out.println(shortestWordEditPath(
        //  "bit", "pog", new String[]{"but","put","big","pot","pog","pig","dog","lot"}
        //));
        System.out.println(shortestWordEditPath(
                "abc", "ab", new String[]{"abc","ab"}
        ));
    }
}

