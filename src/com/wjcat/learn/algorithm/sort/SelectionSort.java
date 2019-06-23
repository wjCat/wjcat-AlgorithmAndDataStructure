package com.wjcat.learn.algorithm.sort;

/**
 * @decription 选择排序
 *
 * 遍历数组依次找出为排序子数组的最小元素放置于子数组的第一个位置
 *
 * Created by 厕所里拉屎的猫 on 2019/6/17.
 */
public class SelectionSort {

    private SelectionSort() {}

    public void sort(Comparable[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (SortHelper.less(array[j], array[min])) {
                    min = j;
                }
            }
            SortHelper.swap(array, i, min);
        }
    }

}
