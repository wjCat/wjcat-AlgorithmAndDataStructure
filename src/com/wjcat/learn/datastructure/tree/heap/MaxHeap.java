package com.wjcat.learn.datastructure.tree.heap;

import com.wjcat.learn.datastructure.array.ArrayList;

/**
 * @Description 最大堆
 * Created by 厕所里拉屎的猫 on 2019/5/22.
 */
public class MaxHeap<E extends Comparable<E>> {

    private ArrayList<E> data;

    public MaxHeap(int capacity) {
        this.data = new ArrayList<>(capacity);
    }

    public MaxHeap() {
        this(10);
    }

    /**
     * 获取元素个数
     *
     * @return 元素个数
     */
    public int getSize() {
        return this.data.getSize();
    }

    /**
     * 判断是否为空
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    /**
     * 获取父节点对应的索引值
     *
     * @param index 子节点索引
     * @return 父节点索引
     */
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index - 1) / 2;
    }

    /**
     * 获取左节点对应的索引值
     *
     * @param index 父节点索引
     * @return 左节点索引
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * 获取右节点对应的索引值
     *
     * @param index 父节点索引
     * @return 右节点索引
     */
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    public void add(E element) {
        this.data.addLast(element);
        this.siftUp(data.getSize() - 1);
    }

    /**
     * 元素上浮
     *
     * @param index 元素索引
     */
    private void siftUp(int index) {
        while (index > 0 && data.get(index).compareTo(data.get(parent(index))) > 0) {
            int parentIndex = this.parent(index);
            this.data.swap(index, parentIndex);
            index = parentIndex;
        }
    }

    /**
     * 获取堆中最大元素
     *
     * @return 元素对象
     */
    public E findMax() {
        if (data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        return this.data.get(0);
    }

    /**
     * 弹出优先级最高的元素
     * @return 元素对象
     */
    public E extractMax() {
        E element = this.findMax();
        this.data.swap(0, this.data.getSize() - 1);
        this.data.removeLast();
        this.siftDown(0);
        return element;
    }

    /**
     * 元素下沉
     * @param index 元素索引
     */
    private void siftDown(int index) {
        while (leftChild(index) < this.getSize()) {
            int targetIndex = leftChild(index);
            if (targetIndex + 1 < data.getSize() && data.get(targetIndex + 1).compareTo(data.get(targetIndex)) > 0)
                targetIndex++;
            if (this.data.get(index).compareTo(this.data.get(targetIndex)) > 0)
                break;
            this.data.swap(index, targetIndex);
            index = targetIndex;
        }
    }

    /**
     * 弹出优先级最高的元素并替换为传入的元素
     * @param element 元素对象
     * @return 元素对象
     */
    public E replace(E element){
        E resultElement = this.findMax();
        this.data.set(0, element);
        this.siftDown(0);
        return resultElement;
    }

}
