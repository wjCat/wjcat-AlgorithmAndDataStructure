package com.wjcat.learn.algorithm.sort;

/**
 * @decription @TODO
 * Created by 厕所里拉屎的猫 on 2019/6/23.
 */
public class SortHelper {

    /**
     * 判断e1数组对象是否小于后者e2数组对象
     * @param e1 数组对象1
     * @param e2 数组对象2
     * @return 返回前者是否小于后者
     */
    public static boolean less(Comparable e1, Comparable e2) {
        return e1.compareTo(e2) < 0;
    }

    /**
     * 将数组array中索引为i与索引为j的两个对象对调
     * @param array 数组
     * @param i 数组索引
     * @param j 数组索引
     */
    public static void swap(Comparable[] array, int i, int j) {
        Comparable t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

}
