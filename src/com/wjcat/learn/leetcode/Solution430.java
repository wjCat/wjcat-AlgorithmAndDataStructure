package com.wjcat.learn.leetcode;

public class Solution430 {

    public static void main(String[] args) {
        Solution430 solution430 = new Solution430();
        Node param = solution430.flatten(get());
        Node temp = param;
        System.out.print("[");
        do {
            System.out.print(temp.val + ", ");
            if (temp.next != null) {
                temp = temp.next;
            } else {
                break;
            }
        } while (temp != null);
        System.out.println("]");
        System.out.print("[");
        do {
            System.out.print(temp.val + ", ");
            temp = temp.prev;
        } while (temp != null);
        System.out.println("]");
    }

    public Node flatten(Node head) {
        return dfs(head, null);
    }

    private Node dfs(Node node, Node otherLine) {
        if (node == null) {
            return otherLine;
        }
        Node next = node.next;
        if (node.child != null) {
            Node child = dfs(node.child, dfs(next, otherLine));
            node.next = child;
            child.prev = node;
            node.child = null;
        } else {
            next = dfs(next, otherLine);
            node.next = next;
            if (next != null) {
                next.prev = node;
            }
        }
        return node;
    }

    private static Node get() {
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        Node node6 = new Node();
        Node node7 = new Node();
        Node node8 = new Node();
        Node node9 = new Node();
        Node node10 = new Node();
        Node node11 = new Node();
        Node node12 = new Node();

        node1.val = 1;
        node1.next = node2;

        node2.val = 2;
        node2.prev = node1;
        node2.next = node3;

        node3.val = 3;
        node3.prev = node2;
        node3.next = node4;
        node3.child = node7;

        node4.val = 4;
        node4.prev = node3;
        node4.next = node5;

        node5.val = 5;
        node5.prev = node4;
        node5.next = node6;

        node6.val = 6;
        node6.prev = node5;

        node7.val = 7;
        node7.next = node8;

        node8.val = 8;
        node8.prev = node7;
        node8.next = node9;
        node8.child = node11;

        node9.val = 9;
        node9.prev = node8;
        node9.next = node10;

        node10.val = 10;
        node10.prev = node9;

        node11.val = 11;
        node11.next = node12;

        node12.val = 12;
        node12.prev = node11;

        return node1;
    }

}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}
