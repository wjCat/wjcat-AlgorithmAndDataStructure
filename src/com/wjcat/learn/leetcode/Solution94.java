package com.wjcat.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yupeijiang
 * @date 2020/7/21 0021
 */
public class Solution94 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            loop(root);
        }
        return result;
    }

    public void loop(TreeNode root) {
        if (root.left != null) {
            inorderTraversal(root.left);
        }
        result.add(root.val);
        if (root.right != null) {
            inorderTraversal(root.right);
        }
    }


}
