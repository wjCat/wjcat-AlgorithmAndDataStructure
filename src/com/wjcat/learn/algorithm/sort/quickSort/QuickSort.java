package com.wjcat.learn.algorithm.sort.quickSort;

import com.wjcat.learn.algorithm.sort.Sort;

/**
 * @decription 快速排序
 * Created by 厕所里拉屎的猫 on 2019/6/18.
 */
public class QuickSort<E extends Comparable<E>> extends Sort<E> {

    @Override
    public String sort(E[] array) {

        Long startTime = System.currentTimeMillis();

        sort(array, 0, array.length - 1);

        Long endTime = System.currentTimeMillis();
        return (endTime - startTime) + "ms";
    }

    private void sort(E[] array, int left, int right) {

        if (right - left <= 15) {
            insertionSort(array);
            return;
        }
        swap(array, left, (int) ((Math.random()*1000) % (right - left + 1) + left));

        int i = left;
        for (int j = left + 1; j <= right; j++) {
            if (less(array[j], array[left]))
                swap(array, ++i, j);
        }
        swap(array, left, i);
        sort(array, left, i - 1);
        sort(array, i + 1, right);

    }

    private void insertionSort(E[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0 && less(array[j], array[j - 1]); j--) {
                swap(array, j, j - 1);
            }
        }
    }

}
