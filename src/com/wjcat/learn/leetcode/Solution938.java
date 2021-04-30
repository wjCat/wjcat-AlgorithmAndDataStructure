package com.wjcat.learn.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution938 {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int res = root.val <= high && root.val >= low ? root.val : 0;
        if(root.val < high ) {
            res += rangeSumBST(root.right, low, high);
        }
        if (root.val > low) {
            res += rangeSumBST(root.left, low, high);
        }
        return res;
    }

    public int rangeSumBST1(TreeNode root, int low, int high) {
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                continue;
            }
            if (node.val > high) {
                q.offer(node.left);
            } else if (node.val < low) {
                q.offer(node.right);
            } else {
                sum += node.val;
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return sum;
    }

}
