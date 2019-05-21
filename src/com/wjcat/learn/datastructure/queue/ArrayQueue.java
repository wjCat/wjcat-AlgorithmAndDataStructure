package com.wjcat.learn.datastructure.queue;

import com.wjcat.learn.datastructure.array.ArrayList;

/**
 * @Description 数组队列
 * Created by 厕所里拉屎的猫 on 2019/5/18.
 */
public class ArrayQueue<E> implements Queue<E> {

    ArrayList<E> array;

    public ArrayQueue(int capacity) {
        this.array = new ArrayList<>(capacity);
    }

    public ArrayQueue() {
        this(10);
    }

    @Override
    public int getSize() {
        return this.array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return this.array.isEmpty();
    }

    @Override
    public void enqueue(E element) {
        this.array.addLast(element);
    }

    @Override
    public E dequeue() {
        return this.array.removeFirst();
    }

    @Override
    public E getFront() {
        return this.array.getFirst();
    }
}
