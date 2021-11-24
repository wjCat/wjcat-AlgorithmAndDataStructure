package com.wjcat.learn.leetcode;

/**
 * @author tec
 */
public class Solution206 {

    private ListNode res;

    public ListNode reverseList1(ListNode head) {

        if (head == null) {
            return null;
        }
        doReverse(head);
        return res;
    }

    private ListNode doReverse(ListNode node) {
        if (node.next == null) {
            res = node;
            return node;
        }
        doReverse(node.next).next = node;
        node.next = null;
        return node;
    }

    public ListNode reverseList2(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode cur = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        Solution206 solution206 = new Solution206();
        ListNode listNode = solution206.reverseList1(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(8, new ListNode(5))))));
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}