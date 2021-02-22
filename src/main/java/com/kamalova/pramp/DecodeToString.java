package com.kamalova.pramp;

/*

Good example for dynamic programming task

 */

public class DecodeToString {

    static int decodeVariations(String S) {
        return dynamicHelper(S);
    }

    public static int dynamicHelper(String s) {
        int n = s.length();
        int[] dp = new int[n];

        if (s.charAt(n - 1) != '0') {
            dp[n - 1] = 1;
        } else {
            return 0;
        }

        if (s.charAt(n - 2) == '1') {
            dp[n - 2] = 2;
        } else {
            if (s.charAt(n - 2) == '2' && s.charAt(n - 1) <= '6') {
                dp[n - 2] = 2;
            }
            else {
                dp[n - 2] = 1;
            }
        }


        for (int i = n - 3; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                //dp[i] = 0;
                return 0;
            } else {
                if (s.charAt(i) == '1') {
                    dp[i] = dp[i + 1] + dp[i + 2];
                } else if (s.charAt(i) == '2') {
                    dp[i] = dp[i + 1];
                    if (i + 1 < s.length() && s.charAt(i + 1) <= '6') {
                        dp[i] += dp[i + 2];
                    }
                } else {
                    dp[i] = dp[i + 1];
                }
            }
        }
        return dp[0];
    }


    public static int recursiveHelper(String s, int i) {
        if (i == s.length()) {
            return 1;
        }

        int current = Integer.parseInt(s.substring(i, i + 1));
        if (current < 1)
            return 0;

        if (i == s.length() - 1) {
            return 1;
        }

        if (i < s.length() - 1 && Integer.parseInt(s.substring(i, i + 2)) > 26) {
            return recursiveHelper(s, i + 1);
        } else {
            return recursiveHelper(s, i + 1) + recursiveHelper(s, i + 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(decodeVariations("1262"));
    }
}
