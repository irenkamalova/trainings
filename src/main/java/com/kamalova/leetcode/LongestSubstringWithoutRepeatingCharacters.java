package com.kamalova.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {


        int result = lengthOfLongestSubstring("tmmzuxt");
        String s = "";
        System.out.println(result);

    }

//    static int lengthOfLongestSubstring(String s) {
//        HashMap<Character, Integer> map = new HashMap<>();
//        int guessVal = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            if (!map.containsKey(s.charAt(i))) {
//
//            }
//        }
//        return guessVal;
//    }

    static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int guessVal = 0;

        int i = 0;
        int j = 0;
        while (i < s.length() && j < s.length()) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
                i++;
                guessVal = Math.max(guessVal, i - j);
            } else {
                if (map.get(s.charAt(i)) >= j) {
                    j = map.get(s.charAt(i)) + 1;
                    map.put(s.charAt(i), i);
                    i++;
                } else {
                    map.put(s.charAt(i), i);
                    i++;
                    guessVal = Math.max(guessVal, i - j);
                }
            }
        }

        return guessVal;
    }

    static int lengthOfLongestSubstring75(String s) {
        Set<Character> set = new HashSet<>();
        int guessVal = 0;

        int i = 0;
        int j = 0;
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                i++;
                guessVal = Math.max(guessVal, i - j);
            } else {
                set.remove(s.charAt(j));
                j++;
            }
        }

        return guessVal;
    }

    static int lengthOfLongestSubstringFaster60(String s) {
        if (s.isEmpty()) return 0;
        Set<Character> set = new HashSet<>();
        int guessVal = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char str = s.charAt(i);
            guessVal = Math.max(guessVal, i - j);
            if (!set.contains(str)) {
                set.add(str);
            } else {
                while (set.contains(str)) {
                    set.remove(s.charAt(j));
                    j++;
                }
                set.add(str);
            }
        }
        guessVal = Math.max(guessVal, s.length() - j);

        return guessVal;
    }

    static int lengthOfLongestSubstringSlow(String s) {
        if (s.isEmpty()) return 0;
        LinkedList<String> list = new LinkedList<>();
        String[] array = s.split("");
        Set<String> set = new HashSet<>();
        int guessVal = 1;

        for (String str : array) {
            if (!set.contains(str)) {
                list.add(str);
                set.add(str);
                guessVal = Math.max(guessVal, list.size());
            } else {
                while (!list.getFirst().equals(str)) {
                    set.remove(list.getFirst());
                    list.removeFirst();
                }
                list.removeFirst();
                list.add(str);
                set.addAll(list);
            }
        }

        return guessVal;
    }
}
