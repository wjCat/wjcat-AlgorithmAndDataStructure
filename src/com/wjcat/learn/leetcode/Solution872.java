package com.wjcat.learn.leetcode;

import java.util.Objects;
import java.util.Stack;

public class Solution872 {

    public static class TreeNode {
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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<Integer> temp1 = new Stack<>();
        Stack<Integer> temp2 = new Stack<>();
        doing(root1, temp1);
        doing(root2, temp2);
        while (!temp1.isEmpty() && !temp2.isEmpty()) {
            if (!Objects.equals(temp1.pop(), temp2.pop())) {
                return false;
            }
        }
        return temp1.isEmpty() && temp2.isEmpty();
    }

    public void doing(TreeNode root, Stack<Integer> temp) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            temp.push(root.val);
        } else {
            doing(root.left, temp);
            doing(root.right, temp);
        }
    }

    public static void main(String[] args) {
        Solution872 solution872 = new Solution872();
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(1);
        System.out.println(solution872.leafSimilar(root1, root2));
    }

}
