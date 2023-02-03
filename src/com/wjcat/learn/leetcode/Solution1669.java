package com.wjcat.learn.leetcode;

public class Solution1669 {

    public static void main(String[] args) {
        Solution1669 solution1669 = new Solution1669();

    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp = list1;
        for (int i = 0; i < a - 1; i++) {
            temp = temp.next;
        }
        ListNode del = temp.next;
        temp.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        for (int i = 0; i < b - a; i++) {
            del = del.next;
        }
        list2.next = del.next;
        return list1;
    }

}