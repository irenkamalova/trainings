/*
 * Copyrights: Asset Control International B.V.
 * All Rights Reserved.
 *
 */
package com.kamalova.leetcode;

//https://leetcode.com/problems/string-compression/solution/
public class StringCompression
{

    // O(1) space and O(n) complexity
    // one cycle
    // we can store two pointers
    // both pointers start with beginning of the string
    // the first go fast and analyze char array
    // the second - go slow - only of there new character analyzed and put to an array

    public int compress(char[] chars) {
        if (chars.length == 1) return 1;
        int slow = 0;
        int k = 1;  // quantity of repeated symbols
        for (int i = 1; i < chars.length + 1; i++) {
            if (i != chars.length && chars[i - 1] == chars[i]) {
                k++;
            } else {
                chars[slow] = chars[i - 1];
                slow++;
                if (k != 1)
                {
                    if (k / 1000 > 0)
                        chars[slow++] = (char) (k / 1000 + '0');
                    if (k / 100 > 0)
                        chars[slow++] = (char) (k / 100 + '0');
                    if (k / 10 > 0)
                        chars[slow++] = (char) (k / 10 + '0');
                    chars[slow] = (char) (k % 10 + '0');
                    slow++;
                    k = 1;
                }
            }
        }
        System.out.println(chars);
        return slow;
    }
}