package com.wjcat.learn.algorithm.sort;

/**
 * @Description 冒泡排序
 * <p>
 * 每次轮回，都从左到右不断交换相邻逆序的元素，
 * 直到当此轮回不出现交换时退出。
 * Created by 厕所里拉屎的猫 on 2019/5/23.
 */
public class BubbleSort<E extends Comparable<E>> extends Sort<E> {

    @Override
    public String sort(E[] array) {

        Long startTime = System.currentTimeMillis();

        boolean isSort = false;
        do {
            isSort = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (less(array[i + 1], array[i])) {
                    swap(array, i, i + 1);
                    isSort = false;
                }
            }
        } while(!isSort);

        Long endTime = System.currentTimeMillis();
        return (endTime - startTime) + "ms";
    }

}
