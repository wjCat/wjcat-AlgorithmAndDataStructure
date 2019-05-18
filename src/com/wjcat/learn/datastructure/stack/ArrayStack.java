package com.wjcat.learn.datastructure.stack;

import com.wjcat.learn.datastructure.array.ArrayList;

/**
 * Created by 厕所里拉屎的猫 on 2019/5/18.
 */
public class ArrayStack<E> implements Stack<E> {

    private ArrayList<E> array;

    public ArrayStack(int capacity) {
        this.array = new ArrayList(capacity);
    }

    public ArrayStack() {
        this.array = new ArrayList();
    }

    @Override
    public int getSize() {
        return this.array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return this.array.isEmpty();
    }

    public int getCapacity() {
        return this.array.getCapacity();
    }

    @Override
    public void push(E element) {
        this.array.addLast(element);
    }

    @Override
    public E pop() {
        return this.array.removeLast();
    }

    @Override
    public E peek() {
        return this.array.getLast();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for(int i = 0 ; i < this.array.getSize() ; i ++){
            res.append(this.array.get(i));
            if(i != this.array.getSize() - 1)
                res.append(", ");
        }
        res.append("] top");
        return res.toString();
    }
}
