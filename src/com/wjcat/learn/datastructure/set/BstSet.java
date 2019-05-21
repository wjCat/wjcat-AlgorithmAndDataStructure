package com.wjcat.learn.datastructure.set;

import com.wjcat.learn.datastructure.tree.BinarySearchTree.BSTree;

/**
 * @Description 二分搜索树集合
 * Created by 厕所里拉屎的猫 on 2019/5/21.
 */
public class BstSet<T extends Comparable<T>> implements Set<T> {

    BSTree<T> bst;

    public BstSet() {
        this.bst = new BSTree<T>();
    }

    @Override
    public void add(T element) {
        bst.add(element);
    }

    @Override
    public boolean contains(T element) {
        return bst.contains(element);
    }

    @Override
    public void remove(T element) {
        bst.remove(element);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
