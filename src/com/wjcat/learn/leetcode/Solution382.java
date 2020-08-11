package com.wjcat.learn.leetcode;

import java.util.Random;

/**
 * @author yupeijiang
 * @date 2020/8/6 0006
 */
public class Solution382 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    ListNode head;
    Random random = new Random();

    public Solution382(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        ListNode cur = head;
        int n = 1;
        int result = 0;
        while (cur != null) {
            if (n <= 1) {
                result = cur.val;
            } else {
                int i = random.nextInt(n);
                if (i <= 1) {
                    result = cur.val;
                }
            }
            n++;
            cur = cur.next;
        }
        return result;
    }

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 1; i < 10; i++) {
            System.out.println(random.nextInt(20));
        }
    }

}
