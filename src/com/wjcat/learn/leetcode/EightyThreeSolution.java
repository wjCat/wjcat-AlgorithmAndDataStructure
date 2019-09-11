package com.wjcat.learn.leetcode;

/**
 * @Description 83、 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * Created by yupeijiang on 2019/7/25.
 */
public class EightyThreeSolution {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        if (cur != null)
            if (cur.next != null) {
                if (cur.val == cur.next.val) {
                    cur.next = cur.next.next;
                    deleteDuplicates(cur);
                } else {
                    deleteDuplicates(cur.next);
                }
            }
        return head;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            ListNode cur = new ListNode(0);
            cur.next = this;
            StringBuffer sb = new StringBuffer();
            while (cur.next != null) {
                sb.append(cur.next.val + "->");
                cur = cur.next;
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(deleteDuplicates(buildNode("1->1->1")).toString());
    }

    private static ListNode buildNode(String a) {
        String[] list = a.split("->");
        ListNode node = new ListNode(0);
        ListNode cur = node;
        for (String b : list) {
            cur.next = new ListNode(Integer.valueOf(b));
            cur = cur.next;
        }
        return node.next;
    }

}
