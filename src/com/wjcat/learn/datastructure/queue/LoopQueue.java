package com.wjcat.learn.datastructure.queue;

/**
 * Created by 厕所里拉屎的猫 on 2019/5/18.
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front;
    private int tail;

    public LoopQueue(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.front = 0;
        this.tail = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return this.data.length - 1;
    }

    @Override
    public int getSize() {
        if (tail < front)
            return this.tail + 1 + this.data.length - this.front;
        else if (this.tail > this.front)
            return this.tail - this.front;
        else
            return 0;
    }

    @Override
    public boolean isEmpty() {
        return this.tail == this.front;
    }

    @Override
    public void enqueue(E element) {
        if ((this.tail + 1) % this.data.length == this.front)
            this.resize(this.getCapacity() * 2);
        this.data[this.tail] = element;
        this.tail = (this.tail + 1) % this.data.length;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        E element = this.data[this.front];
        this.data[this.front] = null;
        this.front = (this.front + 1) % this.data.length;

        if (this.getSize() == (this.getCapacity() / 4) && (this.getCapacity() / 2) != 0)
            this.resize(this.getCapacity() / 2);
        return element;
    }

    @Override
    public E getFront() {
        return this.data[this.front];
    }

    private void resize(int capacity) {
        E[] data = (E[]) new Object[capacity];
        this.tail = this.getSize();
        for (int i = 0; i < this.tail; i++) {
            data[i] = this.data[(i + this.front) % this.data.length];
        }
        this.data = data;
        this.front = 0;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", getSize(), getCapacity()));
        res.append("front [");
        for (int i = this.front; i != this.tail; i = (i + 1) % this.data.length) {
            res.append(this.data[i]);
            if ((i + 1) % this.data.length != this.tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
}
