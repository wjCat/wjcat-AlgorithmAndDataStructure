package com.wjcat.learn.algorithm.sort.mergeSort;

/**
 * @decription @TODO
 * Created by 厕所里拉屎的猫 on 2019/6/18.
 */
public class Up2DownMergeSort<E extends Comparable<E>> extends MergeSort<E> {

    @Override
    public String sort(E[] array) {

        Long startTime = System.currentTimeMillis();

        super.aux = (E[]) new Comparable[array.length];

        sort(array, 0, array.length -1);

        Long endTime = System.currentTimeMillis();
        return (endTime - startTime) + "ms";
    }

    private void sort(E[] array, int left, int right) {

        if (left >= right)
            return;

        int mid = left + (right - left) / 2;
        sort(array, left, mid);
        sort(array, mid + 1, right);
        merge(array, left, mid, right);

    }

}
