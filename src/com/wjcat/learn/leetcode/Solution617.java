package com.wjcat.learn.leetcode;

public class Solution617 {

    public static void main(String[] args) {
        Solution617 solution617 = new Solution617();

    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return dfs(root1, root2);
    }

    private TreeNode dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        } else if (root2 == null){
            return root1;
        } else {
            TreeNode cur = new TreeNode(root1.val + root2.val);
            cur.left = dfs(root1.left, root2.left);
            cur.right = dfs(root1.right, root2.right);
            return cur;
        }
    }

}