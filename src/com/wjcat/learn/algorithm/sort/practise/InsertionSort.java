package com.wjcat.learn.algorithm.sort.practise;

/**
 * 插入排序
 *
 * @author tec
 */
public class InsertionSort {

    private InsertionSort() {
    }

    /**
     * 将传入的数组进行【顺序】排序
     * while循环
     *
     * @param array 数组
     */
    public static void sortAsc(Comparable[] array) {
        int i = 0;
        while (i < array.length) {
            Comparable element = array[i];
            int j = i - 1;
            while (j >= 0) {
                if (SortHelper.less(array[j], element)) {
                    break;
                } else {
                    array[j+1] = array[j];
                    array[j] = element;
                }
                j--;
            }
            i++;
        }
    }

    /**
     * 将传入的数组进行【顺序】排序
     * for循环
     *
     * @param array 数组
     */
    public static void sortAsc2(Comparable[] array) {
        for (int i = 0; i < array.length; i++) {
            Comparable temp = array[i];
            for (int j = i - 1; j >= 0; j--) {
                if (SortHelper.less(array[j], temp)) {
                    break;
                } else {
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }

    }

    /**
     * 将传入的数组进行【倒序】排序
     * while循环
     *
     * @param array 数组
     */
    public void sortDesc(Comparable[] array) {
    }

    /**
     * 将传入的数组进行【倒序】排序
     * for循环
     *
     * @param array 数组
     */
    public void sortDesc2(Comparable[] array) {
    }

}
