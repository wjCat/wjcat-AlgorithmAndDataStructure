package com.wjcat.learn.algorithm.sort;

/**
 * @decription 选择排序
 *
 * 遍历数组依次找出为排序子数组的最小元素放置于子数组的第一个位置
 *
 * Created by 厕所里拉屎的猫 on 2019/6/17.
 */
public class SelectionSort<E extends Comparable<E>> extends Sort<E> {

    @Override
    public String sort(E[] array) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (less(array[j], array[min])) {
                    min = j;
                }
            }
            swap(array, i, min);
        }
        long endTime = System.currentTimeMillis();
        return (endTime - startTime) + "ms";
    }

}
