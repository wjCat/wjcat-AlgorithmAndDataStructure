package com.wjcat.learn.leetcode;/**
 * Created by yupeijiang on 2019/5/20.
 */

/**
 * @ClassName TowHundredAndThree
 * @Description 203. 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * @Author yupeijiang
 * @Date 2019/5/20
 */
public class TwoHundredAndThree {

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

        ListNode res = (new TwoHundredAndThree()).removeElements(head, 6);
        System.out.println("after[" + res + "]");

        System.out.println("================================================================================");

        ListNode head1 = new ListNode(new int[]{1, 2, 6, 3, 6, 4, 5, 6, 7, 8, 9});
        System.out.println("before:[" + head1 + "]");

        ListNode res1 = (new TwoHundredAndThree()).removeElements(head1, 6);
        System.out.println("after[" + res1 + "]");

        System.out.println("================================================================================");

        ListNode head2 = new ListNode(new int[]{6});
        System.out.println("before:[" + head2 + "]");

        ListNode res2 = (new TwoHundredAndThree()).removeElements(head2, 6);
        System.out.println("after[" + res2 + "]");

        System.out.println("================================================================================");

        ListNode head3 = null;
        System.out.println("before:[" + head3 + "]");

        ListNode res3 = (new TwoHundredAndThree()).removeElements(head3, 6);
        System.out.println("after[" + res3 + "]");
    }

}
