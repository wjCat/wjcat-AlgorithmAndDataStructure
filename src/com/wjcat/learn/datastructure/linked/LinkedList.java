package com.wjcat.learn.datastructure.linked;

/**
 * Created by 厕所里拉屎的猫 on 2019/5/19.
 */
public class LinkedList<E> {

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

    //    private Node head;
    // 虚拟头节点
    private Node dummyHead;
    private int size;

    public LinkedList() {
        this.dummyHead = new Node();
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void addFirst(E element) {
//        this.head = new Node(element, this.head);
//        this.size++;
        this.add(0, element);
    }

    public void add(int index, E element) {
        if (index < 0 || index > this.size)
            throw new IllegalArgumentException("Add failed. Illegal index.");
//        if (index == 0)
//            this.addFirst(element);
//        else {
//            Node pre = this.head;
//            for (int i = 0; i < index - 1; i++)
//                pre = pre.next;
//            pre.next = new Node(element, pre.next);
//            this.size++;
//        }
        Node pre = this.dummyHead;
        for (int i = 0; i < index; i++)
            pre = pre.next;

        pre.next = new Node(element, pre.next);
        size++;
    }

    public void addLast(E element) {
        this.add(this.size, element);
    }

    public E get(int index) {

        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Illegal index.");

        Node node = this.dummyHead.next;
        for (int i = 0; i < index; i++)
            node = node.next;
        return node.element;
    }

    public E getFirst() {
        return this.get(0);
    }

    public E getLast() {
        return this.get(this.size - 1);
    }

    public void set(int index, E element) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Illegal index.");

        Node pre = this.dummyHead.next;
        for (int i = 0; i < index; i++)
            pre = pre.next;
        pre.element = element;
    }

    public boolean contains(E element){
        Node node = this.dummyHead.next;
        while (node.next != null)
            if (node.element.equals(element))
                return true;
            else
                node = node.next;
        return false;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        for(Node cur = dummyHead.next ; cur != null ; cur = cur.next)
            res.append(cur + "->");
        res.append("NULL");

        return res.toString();
    }
}
