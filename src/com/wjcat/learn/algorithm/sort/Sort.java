package com.wjcat.learn.algorithm.sort;

import java.util.Arrays;

/**
 * @Description 排序抽象类，抽取公共方法
 * Created by 厕所里拉屎的猫 on 2019/5/23.
 */
public abstract class Sort<E extends Comparable<E>> {

    /**
     * 排序抽象方法
     * @param array 需要排序的数组
     * @return 使用时长
     */
    public abstract String sort(E[] array);

    /**
     * 判断e1数组对象是否小于后者e2数组对象
     * @param e1 数组对象1
     * @param e2 数组对象2
     * @return 返回前者是否小于后者
     */
    protected boolean less(E e1, E e2) {
        return e1.compareTo(e2) < 0;
    }

    /**
     * 将数组array中索引为i与索引为j的两个对象对调
     * @param array 数组
     * @param i 数组索引
     * @param j 数组索引
     */
    protected void swap(E[] array, int i, int j) {
        E t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}