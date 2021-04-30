package com.wjcat.learn.leetcode;

import java.util.List;

public class Solution23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode res = new ListNode();
        doing(lists, getMinIndex(lists, null), res);
        return res.next;
    }

    public void doing(ListNode[] lists, Integer nodeIndex, ListNode tempNode) {
        if (nodeIndex == null) {
            return;
        }
        ListNode cur = lists[nodeIndex];
        Integer nextMinIndex = getMinIndex(lists, nodeIndex);
        if (nextMinIndex == null) {
            while (cur != null) {
                tempNode.next = new ListNode(cur.val);
                cur = cur.next;
                tempNode = tempNode.next;
            }
            return;
        }
        ListNode nextMin = lists[nextMinIndex];
        while (cur != null && cur.val <= nextMin.val) {
            tempNode.next = new ListNode(cur.val);
            cur = cur.next;
            tempNode = tempNode.next;
        }
        lists[nodeIndex] = cur;
        doing(lists, nextMinIndex, tempNode);
    }

    public Integer getMinIndex(ListNode[] lists, Integer curIndex) {
        Integer res = null;
        Integer min = null;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && (curIndex == null || curIndex != i)) {
                if (min == null) {
                    min = lists[i].val;
                    res = i;
                } else if (lists[i] != null && lists[i].val < min) {
                    min = lists[i].val;
                    res = i;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(4);
        a.next.next = new ListNode(5);
        ListNode b = new ListNode(1);
        b.next = new ListNode(3);
        b.next.next = new ListNode(4);
        ListNode c = new ListNode(2);
        c.next = new ListNode(6);
        Solution23 solution23 = new Solution23();
        ListNode[] param = {a, b, c};
        ListNode listNode = solution23.mergeKLists(new ListNode[]{null});
        System.out.println(1111111111);
    }

}

class ListNode {
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