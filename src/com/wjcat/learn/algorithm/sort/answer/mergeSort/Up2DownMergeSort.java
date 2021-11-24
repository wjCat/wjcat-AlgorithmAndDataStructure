package com.wjcat.learn.algorithm.sort.answer.mergeSort;

import com.wjcat.learn.algorithm.sort.answer.SortHelper;

/**
 * @decription 自顶向下归并排序
 * Created by 厕所里拉屎的猫 on 2019/6/18.
 */
public class Up2DownMergeSort {

    private Up2DownMergeSort() {
    }


    public static void sort(Comparable[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(Comparable[] array, int left, int right) {

        Comparable[] aux = new Comparable[array.length];

        if (left >= right)
            return;

        int mid = left + (right - left) / 2;
        sort(array, left, mid);
        sort(array, mid + 1, right);
        SortHelper.merge(array, aux, left, mid, right);

    }

}
