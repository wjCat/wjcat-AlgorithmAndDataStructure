package com.wjcat.learn.datastructure.Arrays;

/**
 * Created by 厕所里拉屎的猫 on 2019/5/17.
 */
public class ArrayList <E> {

    private E[] data;
    private int size;

    public ArrayList(int capacity) {
        this.data = (E[]) new Object[capacity];
        size = 0;
    }

    public ArrayList() {
        this(10);
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity(){
        return this.data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addLast(E element){
        this.add(size, element);
    }


    public void add(int index, E element){
        if (index<0 || index>=size)
            throw new IllegalArgumentException();
        System.arraycopy(data, index, data, index+1, size-index);
        data[index] = element;
        size++;
    }

}
