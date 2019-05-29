package com.kamalova.image;

import java.util.*;

/*
Get from discussions (good approach!)

Success
Details 
Runtime: 7 ms, faster than 58.81% of Java online submissions for Word Break II.
Memory Usage: 39.1 MB, less than 45.81% of Java online submissions for Word Break II.
*/

public class WordBreakIIOffset {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Map<Integer, List<String>> map = new HashMap<>();
        return find(s, set, 0, map);
    }

    List<String> find(String s, Set<String> dict, int offset,
                      Map<Integer, List<String>> map) {
        //if (dict.contains(s.substring(offset))) return new ArrayList<String>(){{add(s.substring(offset));}};

        if (map.containsKey(offset)) return map.get(offset);

        List<String> result = new ArrayList<>();
        if (offset == s.length()) {
            result.add("");
            return result;
        }


        for (int i = offset; i < s.length(); i++) {
            String str = s.substring(offset, i + 1);
            if (dict.contains(str)) {
                List<String> res = find(s, dict, i + 1, map);
                for (String subString : res) {
                    result.add((str + " " + subString).trim());
                }
            }
        }
        map.put(offset, result);
        return result;
    }


    public static void main(String[] args) {
        WordBreakIIOffset solution = new WordBreakIIOffset();
//        String s = "catsanddog";
//        String[] ss = new String[]{"cat", "cats", "and", "sand", "dog"};
//        String s = "aaa";
//        String[] ss = new String[]{"a", "aa", "aaa"};
//        List<String> strings = Arrays.asList(ss);
//        List<String> res = solution.wordBreak(s, strings);
//        System.out.println(res);

        String s1 = "pineapplepenapple";
        String[] ss1 = new String[]{"apple", "pen", "applepen", "pine", "pineapple"};
        List<String> strings1 = Arrays.asList(ss1);
        List<String> res1 = solution.wordBreak(s1, strings1);
        System.out.println(res1);
    }

}
