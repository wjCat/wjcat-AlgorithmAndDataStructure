package com.wjcat.learn.algorithm.sort.practise.merge;


import com.wjcat.learn.algorithm.sort.practise.SortHelper;

/**
 * 自顶向下归并排序
 *
 * @author tec
 */
public class Up2DownMergeSort {

    private Up2DownMergeSort() {
    }

    /**
     * 自顶向下归并排序
     *
     * @param array 数组
     */
    public static void sort(Comparable[] array) {
        doSort(array, 0, array.length - 1);
    }

    /**
     * 自顶向下归并排序
     *
     * @param array 数组
     */
    private static void doSort(Comparable[] array, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (r - l) / 2 + l;
        doSort(array, l, mid);
        doSort(array, mid + 1, r);
        SortHelper.merge(array, l, mid, r);
    }

}
