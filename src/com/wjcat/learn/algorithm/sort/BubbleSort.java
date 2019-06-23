package com.wjcat.learn.algorithm.sort;

/**
 * @Description 冒泡排序
 * <p>
 * 每次轮回，都从左到右不断交换相邻逆序的元素，
 * 直到当此轮回不出现交换时退出。
 * Created by 厕所里拉屎的猫 on 2019/5/23.
 */
public class BubbleSort {

    private BubbleSort() {
    }

    public static void sort(Comparable[] array) {
        boolean isSort = false;
        do {
            isSort = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (SortHelper.less(array[i + 1], array[i])) {
                    SortHelper.swap(array, i, i + 1);
                    isSort = false;
                }
            }
        } while (!isSort);
    }

}
