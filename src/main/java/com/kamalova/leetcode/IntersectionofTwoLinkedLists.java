/*
 * Copyrights: Asset Control International B.V.
 * All Rights Reserved.
 *
 */
package com.kamalova.leetcode;

// https://leetcode.com/problems/intersection-of-two-linked-lists/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/*
Inputs:
(null, null) -> null
(listA, null) -> null
(null, listB) -> null
(listA, []) -> []
([], lestB) -> []

([1], [2]) -> []
([1, 2], [2]) -> [2]
([2], [1, 2]) -> [2]
([1], [1, 2]) -> []
([1, 2], [1]) -> []

([1, 2, 3, 4], [5, 3, 4]) -> [3, 4]
([5, 3, 4], [1, 2, 3, 4]) -> [3, 4]

// step 1 - check null / empty
// step 2 - check first element A & B
if it's the same - both next
if it's not the same.
Check all B for current element of A.
if no the same element - next on A.
Not optimal!
Go from tail!
get reversed A and reversed B.
then go from tail and check every element in A and in B both reversed.
After it, go until nextA != nextB


*/

import java.util.*;

public class IntersectionofTwoLinkedLists
{
    public ListNode smartGet(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        boolean continueA = true;
        boolean continueB = true;
        while (pA != null && pB != null) {
            if (pA == pB) return pA;
            pA = pA.next;
            if (pA == null && continueA) {
                pA = headB;
                continueA = false;
            }
            pB = pB.next;
            if (pB == null  && continueB) {
                pB = headA;
                continueB = false;
            }
        }
        return null;
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        // reverse A:
        // O(n) memory!
        ListNode head = headA;
        System.out.println(headA);
        List<ListNode> lA = new ArrayList<>();
        while (head != null) {
            lA.add(head);
            head = head.next;
        }
        System.out.println(headA);
        head = headB;
        List<ListNode> lB = new ArrayList<>();
        while (head != null) {
            lB.add(head);
            head = head.next;
        }
        int i = lA.size() - 1;
        int j = lB.size() - 1;
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        int k = 0;
        while (i >= 0 && j >= 0 && lA.get(i) == lB.get(j)) {
            i--;
            j--;
            k++;
        }
        System.out.println(lB);
        if (k > 0)
            return lA.get(i + 1);
        else
            return null;
        //if (k == 0 || i < 0 || j < 0 || lA.get(i + 1) != lB.get(j + 1)) return null;

    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}