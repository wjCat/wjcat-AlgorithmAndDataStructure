package com.wjcat.learn.algorithm.sort.quickSort;

import com.wjcat.learn.algorithm.sort.InsertionSort;
import com.wjcat.learn.algorithm.sort.SortHelper;

/**
 * @decription 三路快排
 * Created by 厕所里拉屎的猫 on 2019/6/19.
 */
public class ThreeWayQuickSort {

    private ThreeWayQuickSort() {
    }

    public void sort(Comparable[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(Comparable[] array, int left, int right) {

        // 对于小规模数组, 使用插入排序
        if (right - left <= 15) {
            InsertionSort.sort(array, left, right);
            return;
        }

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        SortHelper.swap(array, left, (int) (Math.random() * (right - left + 1)) + left);

        // lt min
        // gt max
        // i equals
        int min = left, max = right + 1, equals = left;

        while (equals < max) {

            if (array[equals].compareTo(array[left]) == 0)
                equals++;
            else if (array[equals].compareTo(array[left]) < 0)
                SortHelper.swap(array, equals++, ++min);
            else
                SortHelper.swap(array, equals, --max);
        }

        SortHelper.swap(array, left, min);

        sort(array, left, min - 1);
        sort(array, max, right);

    }

}
