package com.wjcat.learn.algorithm.sort.quickSort;

import com.wjcat.learn.algorithm.sort.InsertionSort;
import com.wjcat.learn.algorithm.sort.SortHelper;

/**
 * @decription 两路快排
 * Created by 厕所里拉屎的猫 on 2019/6/18.
 */
public class DoubleWayQuickSort {

    private DoubleWayQuickSort() {}

    public static void sort(Comparable[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(Comparable[] array, int left, int right) {

        if (right - left <= 15) {
            InsertionSort.sort(array, left, right);
            return;
        }

        SortHelper.swap(array, left, (int) (Math.random() * (right - left + 1)) + left);

        int min = left + 1, max = right;
        while (true) {
            while (min <= right && SortHelper.less(array[min], array[left])) min++;
            while (max >= left+1 && SortHelper.less(array[left], array[max])) max--;
            if (min > max) break;
            SortHelper.swap(array, min, max);
            min++;
            max--;
        }
        SortHelper.swap(array, left, max);

        sort(array, left, max - 1);
        sort(array, max + 1, right);

    }

}
