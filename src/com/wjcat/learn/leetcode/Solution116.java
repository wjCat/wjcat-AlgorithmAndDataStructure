package com.wjcat.learn.leetcode;

public class Solution116 {

    public static void main(String[] args) {
        Solution116 solution116 = new Solution116();

    }

    public Node connect(Node root) {
        dfs(root, null);
        return root;
    }

    public void dfs(Node cur, Node next) {
        if (cur == null) {
            return;
        }
        cur.next = next;
        dfs(cur.left, cur.right);
        dfs(cur.right, next == null ? null : next.left);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int val) {
            val = val;
        }

        public Node(int val, Node left, Node right, Node next) {
            val = val;
            left = left;
            right = right;
            next = next;
        }
    }

}

