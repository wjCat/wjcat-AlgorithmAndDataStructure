package com.wjcat.learn.algorithm.sort.answer;

import com.wjcat.learn.algorithm.sort.answer.SortHelper;

/**
 * @Description 插入排序
 * <p>
 * 每次都将当前元素插入到左侧已经排序的数组中，使得插入之后左侧数组依然有序。
 * <p>
 * Created by 厕所里拉屎的猫 on 2019/5/15.
 */
public class InsertionSort {

    private InsertionSort() {}

    /**
     * 将传入的数组进行顺序排序
     *
     * @param array 需要排序的数组
     */
    public static void sortAsc(Comparable[] array) {
        // for循环实现方式
        for (int i = 0; i < array.length; i++) {
            Comparable element = array[i];
            for (int j = i - 1; j >= 0; j--) {
                if (element.compareTo(array[j]) >= 0)
                    break;
                else {
                    array[j + 1] = array[j];
                    array[j] = element;
                }
            }
        }

        // while循环实现方式
//        for (int i = 0; i < array.length; i++) {
//            E element = array[i];
//            int j = i - 1;
//            while (j >= 0 && array[j].compareTo(element) > 0) {
//                array[j + 1] = array[j];
//                j = j - 1;
//            }
//            array[j + 1] = element;
//        }
    }

    /**
     * 将传入的数组进行倒序排序
     *
     * @param array 需要排序的数组
     */
    public void sortDesc(Comparable[] array) {
        // for循环实现方式
//        for (int i = 0; i < array.length; i++) {
//            E element = array[i];
//            for (int j = i - 1; j >= 0; j--) {
//                if (element.compareTo(array[j])<=0)
//                    break;
//                else {
//                    array[j+1] = array[j];
//                    array[j] = element;
//                }
//            }
//        }

        // while循环实现方式
        for (int i = 0; i < array.length; i++) {
            Comparable element = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].compareTo(element) < 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = element;
        }
    }

    /**
     * 习题2.1-3：在数组array中寻找元素v，若不存在则返回nil>>(-1)
     * 注：线性查找
     *
     * @param array
     * @param v
     * @return
     */
    public int test3(Comparable[] array, Comparable v) {
        int i = -1;
        for (int j = 0; j < array.length; j++) {
            if (array[j].equals(v))
                i = j;
        }
        return i;
    }

    public static void sort(Comparable[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0 && SortHelper.less(array[j], array[j - 1]); j--) {
                SortHelper.swap(array, j, j - 1);
            }
        }
    }

    // 对arr[l...r]的区间使用InsertionSort排序
    public static void sort(Comparable[] arr, int left, int right){

        for( int i = left + 1 ; i <= right ; i ++ ){
            Comparable e = arr[i];
            int j = i;
            for( ; j > left && arr[j-1].compareTo(e) > 0 ; j--)
                arr[j] = arr[j-1];
            arr[j] = e;
        }
    }

}
