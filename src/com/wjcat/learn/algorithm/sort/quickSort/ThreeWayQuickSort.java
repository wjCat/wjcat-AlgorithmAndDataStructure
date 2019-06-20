package com.wjcat.learn.algorithm.sort.quickSort;

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
            insertionSort(array, left, right);
            return;
        }

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(array, left, (int) (Math.random() * (right - left + 1)) + left);

        // lt min
        // gt max
        // i equals
        int min = left, max = right + 1, equals = left;

        while (equals < max) {

            if (array[equals].compareTo(array[left]) == 0)
                equals++;
            else if (array[equals].compareTo(array[left]) < 0)
                swap(array, equals++, ++min);
            else
                swap(array, equals, --max);
        }

        swap(array, left, min);

        sort(array, left, min - 1);
        sort(array, max, right);

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
