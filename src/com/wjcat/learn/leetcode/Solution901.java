package com.wjcat.learn.leetcode;

import java.util.*;

public class Solution901 {

    public static void main(String[] args) {
//        doNext(new int[]{100, 80, 60, 70, 60, 75, 85});
//        doNext(new int[]{29, 91, 62, 76, 51});
//        doNext(new int[]{32, 82, 73, 99, 91});
        doNext(new int[]{28, 14, 28, 17, 46, 53, 66, 80, 87, 88});
    }

    public static void doNext(int[] params) {
        System.out.println(Arrays.toString(params));
//        System.out.println("===============================StockSpanner1=======================================");
//        StockSpanner stockSpanner = new StockSpanner();
//        System.out.print("[");
//        for (int param : params) {
//            System.out.print(stockSpanner.next(param) + ", ");
//        }
//        System.out.println("]");
//        System.out.println("===============================StockSpanner1=======================================");
//        System.out.println("===============================StockSpanner2=======================================");
//        StockSpanner2 stockSpanner2 = new StockSpanner2();
//        System.out.print("[");
//        for (int param : params) {
//            System.out.print(stockSpanner2.next(param) + ", ");
//        }
//        System.out.println("]");
//        System.out.println("===============================StockSpanner2=======================================");
        System.out.println("===============================StockSpanner3=======================================");
        StockSpanner3 stockSpanner3 = new StockSpanner3();
        System.out.print("[");
        for (int param : params) {
            System.out.print(stockSpanner3.next(param) + ", ");
        }
        System.out.println("]");
        System.out.println("===============================StockSpanner3=======================================");
    }

}

class StockSpanner {

    class Node {
        int price;
        Node next;
        boolean max;

        public Node(int price, Node next, boolean max) {
            this.price = price;
            this.next = next;
            this.max = max;
        }
    }

    Node head = new Node(0, null, false);
    int size = 0;

    public StockSpanner() {
    }

    public int next(int price) {
        Node temp = head;
        int res = 0;
        while (temp.next != null && temp.next.price <= price && !temp.max) {
            temp = temp.next;
            res++;
        }

        if (temp.next == null || temp.max) {
            head.next = new Node(price, head.next, true);
            return size++ + 1;
        } else {
            head.next = new Node(price, head.next, false);
            size++;
            return res + 1;
        }
    }

}

class StockSpanner2 {

    class Param {
        int price;
        boolean isMax;

        public Param(int price, boolean isMax) {
            this.price = price;
            this.isMax = isMax;
        }
    }

    Deque<Param> deque = new ArrayDeque<>();


    public StockSpanner2() {
    }

    public int next(int price) {
        Queue<Param> temp = new LinkedList<>();
        int res = 0;
        Param current = new Param(price, true);
        if (deque.isEmpty()) {
            deque.push(current);
            return res + 1;
        }
        while (!deque.isEmpty()) {
            Param top = deque.pop();
            if (top.price <= price && top.isMax) {
                temp.add(top);
                res = deque.size() + temp.size() + 1;
                break;
            } else if (top.price <= price) {
                temp.add(top);
            } else {
                deque.push(top);
                res = temp.size() + 1;
                current = new Param(price, false);
                break;
            }
        }
        while (!temp.isEmpty()) {
            deque.push(temp.poll());
        }
        deque.push(current);
        return res;
    }

}

class StockSpanner3 {

    Deque<int[]> stack;
    int idx;

    public StockSpanner3() {
        stack = new ArrayDeque<>();
        stack.push(new int[]{-1, Integer.MAX_VALUE});
        idx = -1;
    }

    public int next(int price) {
        idx++;
        while (price >= stack.peek()[1]) {
            stack.pop();
        }
        int ret = idx - stack.peek()[0];
        stack.push(new int[]{idx, price});
        return ret;
    }

}
