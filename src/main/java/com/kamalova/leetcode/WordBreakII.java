package com.kamalova.leetcode;

import java.util.*;
/*
The general idea the same as it was - memoization result in map <String, List<String>>

Edit: return result and use it in previous step 

More accuracy code
Good result:

Success
Details 
Runtime: 4 ms, faster than 96.29% of Java online submissions for Word Break II.
Memory Usage: 35.4 MB, less than 99.41% of Java online submissions for Word Break II.

*/

class WordBreakII {
    HashMap<String, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict);
    }

    List<String> helper(String s, List<String> wordDict) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        if (s.length() == 0) {
            return new ArrayList<String>(){{add("");}};
        }
        List<String> result = new ArrayList<>();

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> res = helper(s.substring(word.length()), wordDict);
                for(String s1 : res) {
                    result.add((word + " " + s1).trim());
                }
            }
        }
        map.put(s, result);
        return result;
    }
    
}
