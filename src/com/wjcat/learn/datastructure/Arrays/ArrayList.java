package com.wjcat.learn.datastructure.Arrays;

/**
 * Created by 厕所里拉屎的猫 on 2019/5/17.
 */
public class ArrayList<E> {

    private E[] data;
    private int size;

    public ArrayList(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public ArrayList() {
        this(10);
    }

    /**
     * 获取元素个数
     *
     * @return 元素个数
     */
    public int getSize() {
        return this.size;
    }

    /**
     * 获取数组容量
     *
     * @return 数组容量
     */
    public int getCapacity() {
        return this.data.length;
    }

    /**
     * 数组是否为空
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 在数组尾部添加元素
     *
     * @param element 元素对象
     */
    public void addLast(E element) {
        this.add(size, element);
    }

    /**
     * 在数组头部添加元素
     *
     * @param element 元素对象
     */
    public void addFirst(E element) {
        this.add(0, element);
    }

    /**
     * 添加元素
     *
     * @param index   索引
     * @param element 元素对象
     */
    public void add(int index, E element) {

        if (index < 0 || index > this.size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

        if (this.size == this.data.length)
            this.resize(2 * this.data.length);

        System.arraycopy(this.data, index, this.data, index + 1, this.size - index);
        this.data[index] = element;
        this.size++;
    }

    /**
     * 获取元素
     *
     * @param index 索引
     * @return 元素对象
     */
    public E get(int index) {
        if (index < 0 || index >= this.size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        return this.data[index];
    }

    /**
     * 设置元素
     *
     * @param index   索引
     * @param element 元素对象
     */
    public void set(int index, E element) {
        if (index < 0 || index >= this.size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        this.data[index] = element;
    }

    /**
     * 判断是否包含该元素
     *
     * @param element 元素对象
     * @return boolean
     */
    public boolean contains(E element) {
        for (int i = 0; i < this.size; i++)
            if (this.data[i].equals(element))
                return true;
        return false;
    }

    /**
     * 查找元素
     *
     * @param element 元素对象
     * @return 索引
     */
    public int find(E element) {
        for (int i = 0; i < this.size; i++)
            if (this.data[i].equals(element))
                return i;
        return -1;
    }

    /**
     * 删除元素
     *
     * @param index 索引
     * @return 元素对象
     */
    public E remove(int index) {
        if (index < 0 || index >= this.size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        E element = this.data[index];
        System.arraycopy(this.data, index + 1, this.data, index, this.size - index);
        this.size--;
        this.data[this.size] = null;

        if (this.size == this.data.length / 4 && this.data.length / 2 != 0)
            resize(this.data.length / 2);

        return element;
    }

    /**
     * 删除数组第一个元素
     *
     * @return 元素对象
     */
    public E removeFirst() {
        return this.remove(0);
    }

    /**
     * 删除数组最后一个元素
     *
     * @return 元素对象
     */
    public E removeLast() {
        return this.remove(size - 1);
    }

    /**
     * 删除元素
     *
     * @param element 元素对象
     */
    public void removeElement(E element) {
        int index = this.find(element);
        if (index != -1)
            this.remove(index);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

    private void resize(int capacity) {
        E[] data = (E[]) new Object[capacity];
        System.arraycopy(this.data, 0, data, 0, this.size);
        this.data = data;
    }
}
