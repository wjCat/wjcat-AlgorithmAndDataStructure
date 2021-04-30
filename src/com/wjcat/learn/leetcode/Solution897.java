package com.wjcat.learn.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution897 {

    public TreeNode increasingBST(TreeNode root) {
        Queue<Integer> queue = new LinkedList<>();
        doing(root, queue);
        TreeNode res = new TreeNode();
        TreeNode temp = res;
        while (!queue.isEmpty()) {
            temp.right = new TreeNode(queue.poll());
            temp = temp.right;
        }
        return res.right;
    }

    public void doing(TreeNode root, Queue<Integer> queue) {
        if (root == null) return;
        doing(root.left, queue);
        queue.add(root.val);
        doing(root.right, queue);
    }

    public static void main(String[] args) {
        Solution897 solution897 = new Solution897();
        TreeNode param = new TreeNode(5);
        param.left = new TreeNode(3);
        param.left.left = new TreeNode(2);
        param.left.left.left = new TreeNode(1);
        param.left.right = new TreeNode(4);
        param.right = new TreeNode(6);
        param.right.right = new TreeNode(8);
        param.right.right.left = new TreeNode(7);
        param.right.right.right = new TreeNode(9);
        TreeNode treeNode = solution897.increasingBST(param);
        System.out.println(11111111);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}