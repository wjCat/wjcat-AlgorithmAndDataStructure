package com.wjcat.learn.algorithm.sort.answer.quickSort;

import com.wjcat.learn.algorithm.sort.answer.InsertionSort;
import com.wjcat.learn.algorithm.sort.answer.SortHelper;

/**
 * @decription 快速排序
 * Created by 厕所里拉屎的猫 on 2019/6/18.
 */
public class QuickSort {

    private QuickSort() {
    }

    public static void sort(Comparable[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(Comparable[] array, int left, int right) {

        if (right - left <= 15) {
            InsertionSort.sort(array, left, right);
            return;
        }
        SortHelper.swap(array, left, (int) ((Math.random() * 1000) % (right - left + 1) + left));

        int i = left;
        for (int j = left + 1; j <= right; j++) {
            if (SortHelper.less(array[j], array[left]))
                SortHelper.swap(array, ++i, j);
        }
        SortHelper.swap(array, left, i);
        sort(array, left, i - 1);
        sort(array, i + 1, right);

    }

}
