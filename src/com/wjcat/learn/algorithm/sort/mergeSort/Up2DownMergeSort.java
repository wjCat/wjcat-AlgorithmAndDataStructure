package com.wjcat.learn.algorithm.sort.mergeSort;

/**
 * @decription 自顶向下归并排序
 * Created by 厕所里拉屎的猫 on 2019/6/18.
 */
public class Up2DownMergeSort {

    private Up2DownMergeSort() {
    }

    private static Comparable[] aux;

    private static void merge(Comparable[] array, int left, int mid, int right) {

        int i = left;
        int j = mid + 1;

        System.arraycopy(array, left, aux, left, right - left + 1);

        for (int k = left; k <= right; k++)
            if (i > mid)
                array[k] = aux[j++];
            else if (j > right)
                array[k] = aux[i++];
            else if (aux[i].compareTo(aux[j]) > 0)
                array[k] = aux[j++];
            else
                array[k] = aux[i++];
    }

    public static void sort(Comparable[] array) {
        aux = new Comparable[array.length];
        sort(array, 0, array.length - 1);
    }

    private static void sort(Comparable[] array, int left, int right) {

        if (left >= right)
            return;

        int mid = left + (right - left) / 2;
        sort(array, left, mid);
        sort(array, mid + 1, right);
        merge(array, left, mid, right);

    }

}
