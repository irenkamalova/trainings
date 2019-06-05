package com.kamalova.leetcode;

import java.util.*;

class ValidParentheses {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                stack.push(map.get(s.charAt(i)));
            } else if (map.containsValue(s.charAt(i))) {
                if (stack.isEmpty() || stack.pop() != s.charAt(i)) return false;
            }
        }
        
        return stack.isEmpty();
        
    }
}
