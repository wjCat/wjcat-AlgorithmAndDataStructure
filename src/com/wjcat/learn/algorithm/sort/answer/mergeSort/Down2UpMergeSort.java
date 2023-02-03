package com.wjcat.learn.algorithm.sort.answer.mergeSort;

import com.wjcat.learn.algorithm.sort.answer.InsertionSort;
import com.wjcat.learn.algorithm.sort.answer.SortHelper;

/**
 * @decription 自底向上归并排序
 * Created by 厕所里拉屎的猫 on 2019/6/18.
 */
public class Down2UpMergeSort {

    private Down2UpMergeSort() {
    }

    public static void sort(Comparable[] array) {

        int n = array.length;

        Comparable[] aux = new Comparable[n];

        // Merge Sort Bottom Up 优化
        // 对于小数组, 使用插入排序优化
        for (int i = 0; i < n; i += 16) {
            InsertionSort.sort(array, i, Math.min(i + 15, n - 1));
        }

        for (int sz = 16; sz < n; sz += sz) {
            for (int i = 0; i < n - sz; i += sz + sz) {
                if (SortHelper.less(array[i + sz], array[i + sz - 1])) {
                    SortHelper.merge(array, aux, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
                }
            }
        }
    }

}
