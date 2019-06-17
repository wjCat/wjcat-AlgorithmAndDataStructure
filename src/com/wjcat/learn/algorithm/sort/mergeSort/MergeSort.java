package com.wjcat.learn.algorithm.sort.mergeSort;

import com.wjcat.learn.algorithm.sort.Sort;

/**
 * @Description 归并排序
 * Created by 厕所里拉屎的猫 on 2019/5/15.
 */
public abstract class MergeSort<E extends Comparable<E>> extends Sort<E> {

    protected E[] aux;

    protected void merge(E[] array, int left, int mid, int right) {

        int i = left;
        int j = mid + 1;

        System.arraycopy(array, left, this.aux, left, right - left + 1);

        for (int k = left; k <= right; k++)
            if (i > mid)
                array[k] = this.aux[j++];
            else if (j > right)
                array[k] = this.aux[i++];
            else if (this.aux[i].compareTo(this.aux[j]) > 0)
                array[k] = this.aux[j++];
            else
                array[k] = this.aux[i++];
    }

}
