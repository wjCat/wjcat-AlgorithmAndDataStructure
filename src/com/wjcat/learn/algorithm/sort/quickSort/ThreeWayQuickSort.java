package com.wjcat.learn.algorithm.sort.quickSort;

import com.wjcat.learn.algorithm.sort.InsertionSort;
import com.wjcat.learn.algorithm.sort.Sort;

/**
 * @decription 三路快排
 * Created by 厕所里拉屎的猫 on 2019/6/19.
 */
public class ThreeWayQuickSort<E extends Comparable<E>> extends Sort<E> {

    @Override
    public String sort(E[] array) {

        Long startTime = System.currentTimeMillis();

        sort(array, 0, array.length - 1);

        Long endTime = System.currentTimeMillis();
        return (endTime - startTime) + "ms";
    }

    private void sort(E[] array, int left, int right) {

        // 对于小规模数组, 使用插入排序
        if (right - left <= 15) {
            InsertionSort.sort(array, left, right);
            return;
        }

        swap(array, left, (int) (Math.random() * (right - left + 1)) + left);

        int min = left, max = right + 1, equals = left + 1;

        while (equals < max) {
            if (array[left].compareTo(array[equals]) == 0) {
                equals++;
            } else if (less(array[left], array[equals])) {
                swap(array, equals, --max);
            } else {
                swap(array, equals++, ++min);
            }
        }

        swap(array, left, min);

        sort(array, left, min-1);
        sort(array, max, right);

    }

}
