package com.wjcat.learn.leetcode;

public class Solution19 {

    public static void main(String[] args) {
        Solution19 solution19 = new Solution19();
        solution19.removeNthFromEnd(solution19.constructParam(new int[]{1, 2, 3, 4, 5}), 2);
        solution19.removeNthFromEnd(solution19.constructParam(new int[]{1}), 1);
    }

    public ListNode constructParam(int[] param) {
        ListNode head = new ListNode(param[0]);
        ListNode temp = head;
        for (int i = 1; i < param.length; i++) {
            temp = temp.next = new ListNode(param[i]);
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode s = dummy;
        ListNode f = head;
        while (n > 0) {
            f = f.next;
            n--;
        }
        while (f != null) {
            s = s.next;
            f = f.next;
        }
        s.next = s.next.next;
        return dummy.next;
    }

}
