package com.wjcat.learn.leetcode;

/**
 * @Description leetcode -> 203、移除链表元素
 * <p>
 * 删除链表中等于给定值 val 的所有节点。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * Created by yupeijiang on 2019/5/20.
 */
public class Solution203 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        // 链表节点的构造函数
        // 使用arr为参数，创建一个链表，当前的ListNode为链表头结点
        public ListNode(int[] arr) {

            if (arr == null || arr.length == 0)
                throw new IllegalArgumentException("arr can not be empty");

            this.val = arr[0];
            ListNode cur = this;
            for (int i = 1; i < arr.length; i++) {
                cur.next = new ListNode(arr[i]);
                cur = cur.next;
            }
        }

        // 以当前节点为头结点的链表信息字符串
        @Override
        public String toString() {

            StringBuilder s = new StringBuilder();
            ListNode cur = this;
            while (cur != null) {
                s.append(cur.val + "->");
                cur = cur.next;
            }
            s.append("NULL");
            return s.toString();
        }

    }

    public ListNode removeElements(ListNode head, int val) {

        // ================================================== 👇递归求解start👇 ================================================== //

        if (head == null)
            return head;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;

        // ================================================== 👆递归求解end👆 ================================================== //

        // ================================================== 👇递归求解start👇 ================================================== //

//        if (head == null)
//            return head;
//
//        ListNode res = removeElements(head.next, val);
//        if (head.val == val)
//            return res;
//        else {
//            head.next = res;
//            return head;
//        }

        // ================================================== 👆递归求解end👆 ================================================== //

        // ================================================== 👇普通求解start👇 ================================================== //

        // 先循环将值为val的头节点全部删了
//        while (head != null && head.val == val)
//            head = head.next;
//
//        // 将值为val的头节点全部删除之后判断链表是否为空，若为空则返回空链表
//        if (head == null)
//            return null;
//
//        ListNode pre = head;
//        while (pre.next != null) {
//            if (pre.next.val == val)
//                pre.next = pre.next.next;
//            else
//                pre = pre.next;
//
//        }
//
//        return head;

        // ================================================== 👆普通求解end👆 ================================================== //

        // ================================================== 👇虚拟头节点求解start👇 ================================================== //

//        ListNode dummyHead = new ListNode(-1);
//        dummyHead.next = head;
//
//        ListNode pre = dummyHead;
//        while (pre.next != null) {
//            if (pre.next.val == val)
//                pre.next = pre.next.next;
//            else
//                pre = pre.next;
//        }
//
//        return dummyHead.next;
        // ================================================== 👆虚拟头节点求解end👆 ================================================== //
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(new int[]{1, 2, 6, 3, 6, 4, 5, 6, 7, 8, 9, 6});
        System.out.println("before:[" + head + "]");

        ListNode res = (new Solution203()).removeElements(head, 6);
        System.out.println("after[" + res + "]");

        System.out.println("================================================================================");

        ListNode head1 = new ListNode(new int[]{1, 2, 6, 3, 6, 4, 5, 6, 7, 8, 9});
        System.out.println("before:[" + head1 + "]");

        ListNode res1 = (new Solution203()).removeElements(head1, 6);
        System.out.println("after[" + res1 + "]");

        System.out.println("================================================================================");

        ListNode head2 = new ListNode(new int[]{6});
        System.out.println("before:[" + head2 + "]");

        ListNode res2 = (new Solution203()).removeElements(head2, 6);
        System.out.println("after[" + res2 + "]");

        System.out.println("================================================================================");

        ListNode head3 = null;
        System.out.println("before:[" + head3 + "]");

        ListNode res3 = (new Solution203()).removeElements(head3, 6);
        System.out.println("after[" + res3 + "]");
    }

}
