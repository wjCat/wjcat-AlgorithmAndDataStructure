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
            insertionSort(array, left, right);
            return;
        }

        swap(array, left, (int) (Math.random() * (right - left + 1)) + left);



        int min = left + 1, max = right;
        while (true) {
            while (min <= right && less(array[min], array[left])) min++;
            while (max >= left+1 && less(array[left], array[max])) max--;
            if (min > max) break;
            swap(array, min, max);
            min++;
            max--;
        }
        swap(array, left, max);



        sort(array, left, max - 1);
        sort(array, max + 1, right);

    }

    private void insertionSort(E[] array, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            E element = array[i];
            int j = i;
            for (; j > 0 && less(element, array[j - 1]); j--)
                array[j] = array[j - 1];
            array[j] = element;
        }
    }

}
