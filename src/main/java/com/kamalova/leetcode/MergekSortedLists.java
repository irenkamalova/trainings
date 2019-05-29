package com.kamalova.leetcode;

/*
Brute force - but, accepted

Success
Details 
Runtime: 124 ms, faster than 16.50% of Java online submissions for Merge k Sorted Lists.
Memory Usage: 49.6 MB, less than 10.79% of Java online submissions for Merge k Sorted Lists.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        
        ListNode fL = lists[0];
        ListNode sL = lists[1];
        
        ListNode res = mergeTwoLists(fL, sL);
        if (lists.length == 2) return res;
        
        for(int i = 2; i < lists.length; i++) {
            res = mergeTwoLists(res, lists[i]);
        }
        return res;
        
        
    }
    
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
