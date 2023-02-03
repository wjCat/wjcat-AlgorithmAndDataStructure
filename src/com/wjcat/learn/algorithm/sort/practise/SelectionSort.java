package com.wjcat.learn.algorithm.sort.practise;

/**
 * @author tec
 */
public class SelectionSort {

    private SelectionSort() {
    }

    /**
     * 选择排序
     *
     * @param array 数组
     */
    public static void sort(Comparable[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (SortHelper.less(array[j], array[min])) {
                    min = j;
                }
            }
            SortHelper.swap(array, min, i);
        }
    }

}
