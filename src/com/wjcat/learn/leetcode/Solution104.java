package com.wjcat.learn.leetcode;

/**
 * @Description @TODO
 * Created by yupeijiang on 2019/8/13.
 */
public class Solution104 {

    public int maxDepth(TreeNode root) {

        if (root == null) return 0;
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
