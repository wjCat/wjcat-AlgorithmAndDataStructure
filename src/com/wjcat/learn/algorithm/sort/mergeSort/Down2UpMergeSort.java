package com.wjcat.learn.algorithm.sort.mergeSort;

import com.wjcat.learn.algorithm.sort.InsertionSort;

/**
 * @decription 自底向上归并排序
 * Created by 厕所里拉屎的猫 on 2019/6/18.
 */
public class Down2UpMergeSort {

    private Down2UpMergeSort() {
    }

    public void sort(Comparable[] array) {
        // Merge Sort Bottom Up 优化
        // 对于小数组, 使用插入排序优化
//        for( int i = 0 ; i < n ; i += 16 )
//            InsertionSort.sort(array, i, Math.min(i+15, n-1) );
//
//        for (int i = 1; i < array.length; i += i) {
//
//        }
    }

}
