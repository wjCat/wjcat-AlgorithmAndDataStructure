package com.wjcat.learn.algorithm.sort.quickSort;

import com.wjcat.learn.algorithm.sort.Sort;

/**
 * @decription @TODO
 * Created by 厕所里拉屎的猫 on 2019/6/18.
 */
public class DoubleWayQuickSort<E extends Comparable<E>> extends Sort<E> {

    @Override
    public String sort(E[] array) {

        Long startTime = System.currentTimeMillis();

        sort(array, 0, array.length - 1);

        Long endTime = System.currentTimeMillis();
        return (endTime - startTime) + "ms";
    }

    private void sort(E[] array, int left, int right) {

        if (left >= right)
            return;

    }

}
