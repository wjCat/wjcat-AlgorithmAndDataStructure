package com.wjcat.learn.datastructure.set;

import com.wjcat.learn.datastructure.linked.LinkedList;

/**
 * @Description 链表集合
 * Created by 厕所里拉屎的猫 on 2019/5/21.
 */
public class LinkedSet<T> implements Set<T> {

    LinkedList<T> list;

    public LinkedSet() {
        this.list = new LinkedList<>();
    }

    @Override
    public void add(T element) {
        if (!this.list.contains(element))
            this.list.addFirst(element);
    }

    @Override
    public boolean contains(T element) {
        return this.list.contains(element);
    }

    @Override
    public void remove(T element) {
        this.list.removeElement(element);
    }

    @Override
    public int getSize() {
        return this.list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }
}
