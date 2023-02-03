package com.wjcat.learn.leetcode;

public class Solution876 {

    public static void main(String[] args) {
        Solution876 solution876 = new Solution876();
        System.out.println(solution876.middleNode(solution876.constructParam(new int[]{1,2,3,4,5})).val);
        System.out.println(solution876.middleNode(solution876.constructParam(new int[]{1,2,3,4,5,6})).val);
    }

    public ListNode constructParam(int[] param) {
        ListNode head = new ListNode(param[0]);
        ListNode temp = head;
        for (int i = 1; i < param.length; i++) {
            temp = temp.next = new ListNode(param[i]);
        }
        return head;
    }

    public ListNode middleNode(ListNode head) {
        ListNode s = head, f = head;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
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

}