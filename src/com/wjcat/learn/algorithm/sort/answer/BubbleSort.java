package com.wjcat.learn.algorithm.sort.answer;

import java.util.Arrays;

/**
 * 冒泡排序
 * <p>
 * 每次轮回，都从左到右不断交换相邻逆序的元素，
 * 直到当此轮回不出现交换时退出。
 * Created by 厕所里拉屎的猫 on 2019/5/23.
 */
public class BubbleSort {

    private BubbleSort() {
    }

    public static void sort(Comparable[] array) {
        boolean isSort;
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

    public static void sort2(Comparable[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (SortHelper.less(array[j + 1], array[j])) {
                    SortHelper.swap(array, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        boolean result = true;
        for (int i = 0; i < 1000 && result; i++) {
            Integer[] param = new Integer[100];
            for (int j = 0; j < 100; j++) {
                param[j] = (int) (Math.random() * 100);
            }
            Integer[] param2 = Arrays.copyOf(param, 100);
            BubbleSort.sort(param);
            BubbleSort.sort2(param2);
            System.out.println(Arrays.toString(param));
            System.out.println(Arrays.toString(param2));
            for (int a = 0; a < 100; a++) {
                if (!param[a].equals(param2[a])) {
                    result = false;
                }
            }
        }
        System.out.println(result);
    }

}
