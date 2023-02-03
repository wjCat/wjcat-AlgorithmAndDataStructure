package com.wjcat.learn.leetcode;

public class Solution1145 {

    public static void main(String[] args) {
        Solution1145 solution1145 = new Solution1145();
//        solution1145.btreeGameWinningMove(
//                new TreeNode(1,
//                        new TreeNode(2,
//                                new TreeNode(4, new TreeNode(8), new TreeNode(9)),
//                                new TreeNode(5, new TreeNode(10), new TreeNode(11))),
//                        new TreeNode(3, new TreeNode(6), new TreeNode(7))),
//                11, 3);
        solution1145.btreeGameWinningMove(new TreeNode(1, new TreeNode(2), new TreeNode(3)), 3, 1);
    }

    int a = 0;
    int b = 0;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        int count = dfs(root, x);
        return b > count / 2 || a > count / 2 || a + b < count / 2;
    }

    public int dfs(TreeNode node, int x) {
        if (node == null) {
            return 0;
        }
        int ans = 1;
        int l = dfs(node.left, x);
        int r = dfs(node.right, x);
        if (node.val == x) {
            a = l;
            b = r;
        }
        return ans + l + r;
    }

}