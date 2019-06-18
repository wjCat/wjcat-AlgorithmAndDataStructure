package com.wjcat.learn.algorithm.sort.quickSort;

import com.wjcat.learn.algorithm.sort.Sort;

/**
 * @decription 三路快排
 * Created by 厕所里拉屎的猫 on 2019/6/19.
 */
public class ThreeWayQuickSort<E extends Comparable<E>> extends Sort<E> {

    @Override
    public String sort(E[] array) {

        Long startTime = System.currentTimeMillis();

        sort(array, 0, array.length - 1);

        Long endTime = System.currentTimeMillis();
        return (endTime - startTime) + "ms";
    }

    private void sort(E[] array, int left, int right) {

        int i = left + 1, j = right, k = left + 1;

//        for (int a = left + 1; a < gt)

    }

}
