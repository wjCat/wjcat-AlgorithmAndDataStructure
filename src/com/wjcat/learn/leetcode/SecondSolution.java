package com.wjcat.learn.leetcode;

/**
 * @Description 2、给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 *      输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 *      输出：7 -> 0 -> 8
 *      原因：342 + 465 = 807
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Definition for singly-linked list.
 */
public class SecondSolution {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int carryBit = 0;
//        ListNode result = new ListNode(0);
//        do {
//            if (l1.next != null && l2.next != null) {
//                result.val = (l1.val + l2.val + carryBit) % 10;
//                carryBit = (l1.val + l2.val + carryBit) / 10;
//                result.next = new ListNode(0);
//                result = result.next;
//                l1 = l1.next;
//                l2 = l2.next;
//            } else {
//                if (l1.next == null) {
//                    result.val = l2.val;
//                    l2 = l2.next;
//                } else {
//                    result.val = l1.val;
//                    l1 = l1.next;
//                }
//                result.next = new ListNode(0);
//                result = result.next;
//            }
//        } while ((l1 != null && l1.next != null) || (l2 != null && l2.next != null));
//        return result;

        int carryBit = 0;
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null || l2 != null) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carryBit;
            carryBit = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l1 = l2.next;
        }
        if (carryBit > 0)
            cur.next = new ListNode(carryBit);
        return dummyHead.next;


    }
}