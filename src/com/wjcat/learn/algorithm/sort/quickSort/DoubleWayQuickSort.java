package com.wjcat.learn.algorithm.sort.quickSort;

import com.wjcat.learn.algorithm.sort.Sort;

/**
 * @decription 两路快排
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

        if (right - left <= 15) {
            insertionSort(array);
            return;
        }

        int i = left + 1, j = right;
        while (true) {
            while (i <= right && less(array[i], array[left])) i++;
            while (j >= left && less(array[left], array[j])) j--;
            if (i > j) break;
            swap(array, i, j);
            i++;
            j--;
        }
        swap(array, left, j);
        sort(array, left, j - 1);
        sort(array, left, j + 1);

    }

    private void insertionSort(E[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0 && less(array[j], array[j - 1]); j--) {
                swap(array, j, j - 1);
            }
        }
    }

}
