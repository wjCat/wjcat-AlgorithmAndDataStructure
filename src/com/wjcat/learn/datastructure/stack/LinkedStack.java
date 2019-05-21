package com.wjcat.learn.datastructure.stack;

import com.wjcat.learn.datastructure.linked.LinkedList;

/**
 * @Description 链表栈
 * Created by 厕所里拉屎的猫 on 2019/5/20.
 */
public class LinkedStack<E> implements Stack<E> {

    LinkedList<E> list;

    public LinkedStack() {
        this.list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return this.list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public void push(E element) {
        this.list.addFirst(element);
    }

    @Override
    public E pop() {
        return this.list.removeFirst();
    }

    @Override
    public E peek() {
        return this.list.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(this.list);
        return res.toString();
    }

    public static void main(String[] args) {

        LinkedStack<Integer> stack = new LinkedStack<>();

        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
