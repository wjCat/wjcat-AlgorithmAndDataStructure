package com.wjcat.learn.leetcode;

public class Solution24 {

    public static void main(String[] args) {
        Solution24 solution24 = new Solution24();
        ListNode result = solution24.swapPairs(new ListNode(1));
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode mid = pre.next;
        ListNode next = mid.next;
        while (next != null) {
            pre.next = next;
            mid.next = next.next;
            next.next = mid;
            pre = mid;
            mid = pre.next;
            if (mid == null) {
                break;
            }
            next = mid.next;
        }
        return dummy.next;
    }

}