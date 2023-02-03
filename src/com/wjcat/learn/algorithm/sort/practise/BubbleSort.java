package com.wjcat.learn.algorithm.sort.practise;

/**
 * 冒泡排序
 *
 * @author tec
 */
public class BubbleSort {

    private BubbleSort() {
    }

    /**
     * while循环
     *
     * @param array 数组
     */
    public static void sort(Comparable[] array) {
        boolean sort;
        do {
            sort = true;
            int i = 0;
            while (i < array.length - 1) {
                if (SortHelper.less(array[i + 1], array[i])) {
                    SortHelper.swap(array, i, i + 1);
                    sort = false;
                }
                i++;
            }
        } while (!sort);
    }

    /**
     * for循环
     *
     * @param array 数组
     */
    public static void sort2(Comparable[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (SortHelper.less(array[j + 1], array[j])) {
                    SortHelper.swap(array, j, j + 1);
                }
            }
        }
    }

}
