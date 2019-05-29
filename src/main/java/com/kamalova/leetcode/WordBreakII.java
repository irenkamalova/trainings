package com.kamalova.leetcode;

class WordBreakII {
    /*
    Trying to cache result in map
    But still Status: Time Limit Exceeded
    */
    List<String> result = new ArrayList<>();
    HashMap<String, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        helper(s, wordDict, "");
        return result;
    }

void helper(String s, List<String> wordDict,
                String res) {
        if (map.containsKey(s)) {
            List<String> previousResults = map.get(s);
            for(String s1 : previousResults) {
                result.add(res + s1);
            }
            return;
        }
        for (String word : wordDict) {
            if ((s.length() >= word.length()) &&
                    s.substring(0, word.length()).equals(word)) {
                if (s.length() != word.length()) {
                    String r = res + word + " ";
                    String key = s.substring(word.length());
                    helper(key, wordDict, r);
                    if (map.containsKey(key)) {
                        List<String> previousResults = map.get(key);
                        map.computeIfAbsent(s, k -> new ArrayList<>());
                        for (String s1 : previousResults) {
                            map.get(s).add(word + " " + s1);
                        }
                    }
                } else {
                    List<String> lr = new ArrayList<String>() {{add(word);}};
                    map.put(word, lr);
                    result.add(res + word);
                }
            }
        }
    }
    
}
