package com.kamalova.leetcode;

/*
Easy level

Success
Details 
Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
Memory Usage: 37.9 MB, less than 61.34% of Java online submissions for Merge Two Sorted Lists.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {        
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode result;
        ListNode current;
        
        if (l1.val < l2.val) {
            result = new ListNode(l1.val);
            l1 = l1.next;
            current = result;
        } else {
            result = new ListNode(l2.val);
            l2 = l2.next;
            current = result;
        }
        
        while (l1 != null && l2 != null) {            
            if (l1.val < l2.val) {
                ListNode l = new ListNode(l1.val);
                current.next = l;
                current = l;
                l1 = l1.next;
            } else {
                ListNode l = new ListNode(l2.val);
                current.next = l;
                current = l;
                l2 = l2.next;
            }
        }
        
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }
        return result;
    }
}
