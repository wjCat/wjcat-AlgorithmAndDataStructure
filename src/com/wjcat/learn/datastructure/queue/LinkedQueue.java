package com.wjcat.learn.datastructure.queue;

/**
 * @Description 链表队列
 * Created by 厕所里拉屎的猫 on 2019/5/20.
 */
public class LinkedQueue<E> implements Queue<E> {

    private class Node {
        private E element;
        private Node next;

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }

        public Node(E element) {

            this(element, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }

    private Node head, tail;
    private int size;

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void enqueue(E element) {
        if (isEmpty())
            this.head = this.tail = new Node(element);
        else
            this.tail = this.tail.next = new Node(element);
        this.size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        Node delNode = this.head;
        this.head = delNode.next;
        delNode.next = null;
        if (this.head == null)
            this.tail = null;
        this.size--;
        return delNode.element;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return this.head.element;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");

        Node cur = head;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }

    public static void main(String[] args) {

        LinkedQueue<Integer> queue = new LinkedQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
