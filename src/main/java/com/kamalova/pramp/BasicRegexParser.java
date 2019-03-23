package com.kamalova.pramp;

import java.util.Stack;

public class BasicRegexParser {

    public static void main(String[] args) {

    }

    static boolean isMatch(String text, String pattern) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

        for (int i = 0; i < pattern.length(); i++) {
            s1.push(pattern.charAt(i));
        }
        for (int i = 0; i < text.length(); i++) {
            s2.push(text.charAt(i));
        }

        if (s1.empty()) return false;

        while (!s1.empty()) {
            Character c1 = s1.pop();
            if (c1.equals('.')) {
                if (s2.empty()) return false;
                else s2.pop();
            } else {
                Character c2 = s1.pop();
                if (c2.equals('*')) {
                    Character c3 = s2.pop();
                    if (c3.equals(c1)) {
                        while (c3.equals(c1)) c3 = s2.pop();
                    }
                } else {
                    Character c3 = s2.pop();
                    if (!c2.equals(c3)) return false;
                }
            }
        }
        return true;
        // your code goes here
    }
}
