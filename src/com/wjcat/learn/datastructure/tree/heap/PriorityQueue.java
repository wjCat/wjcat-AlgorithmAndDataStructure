package com.wjcat.learn.datastructure.tree.heap;


import com.wjcat.learn.datastructure.queue.Queue;

/**
 * @Description 优先队列
 * Created by 厕所里拉屎的猫 on 2019/5/22.
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    MaxHeap<E> maxHeap;

    public PriorityQueue() {
        this.maxHeap = new MaxHeap<>();
    }

    @Override
    public int getSize() {
        return this.maxHeap.getSize();
    }

    @Override
    public boolean isEmpty() {
        return this.maxHeap.isEmpty();
    }

    @Override
    public void enqueue(E element) {
        this.maxHeap.add(element);
    }

    @Override
    public E dequeue() {
        return this.maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return this.maxHeap.findMax();
    }

}
