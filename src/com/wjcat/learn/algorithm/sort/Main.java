package com.wjcat.learn.algorithm.sort;

import com.wjcat.learn.algorithm.sort.mergeSort.Down2UpMergeSort;
import com.wjcat.learn.algorithm.sort.mergeSort.Up2DownMergeSort;
import com.wjcat.learn.algorithm.sort.quickSort.DoubleWayQuickSort;
import com.wjcat.learn.algorithm.sort.quickSort.QuickSort;
import com.wjcat.learn.algorithm.sort.quickSort.ThreeWayQuickSort;

import java.lang.reflect.Method;
import java.security.InvalidAlgorithmParameterException;

/**
 * @decription @TODO
 * Created by 厕所里拉屎的猫 on 2019/6/17.
 */
public class Main {

    private static Comparable[] array;

    static {
        array = new Comparable[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10000);
//            array[i] = i;
        }
    }

    public static void main(String[] args) throws Exception {
        Integer[] array2 = new Integer[10000];
        Integer[] array3 = new Integer[10000];
        Integer[] array4 = new Integer[10000];
        Integer[] array5 = new Integer[10000];
        Integer[] array6 = new Integer[10000];
        Integer[] array7 = new Integer[10000];
        Integer[] array8 = new Integer[10000];
        System.arraycopy(array, 0, array2, 0, array.length);
        System.arraycopy(array, 0, array3, 0, array.length);
        System.arraycopy(array, 0, array4, 0, array.length);
        System.arraycopy(array, 0, array5, 0, array.length);
        System.arraycopy(array, 0, array6, 0, array.length);
        System.arraycopy(array, 0, array7, 0, array.length);
        System.arraycopy(array, 0, array8, 0, array.length);

        execute(getArray(), "com.wjcat.learn.algorithm.sort.BubbleSort");
        execute(getArray(), "com.wjcat.learn.algorithm.sort.InsertionSort");
        execute(getArray(), "com.wjcat.learn.algorithm.sort.SelectionSort");
        execute(getArray(), "com.wjcat.learn.algorithm.sort.mergeSort.Down2UpMergeSort");
        execute(getArray(), "com.wjcat.learn.algorithm.sort.mergeSort.Up2DownMergeSort");
        execute(getArray(), "com.wjcat.learn.algorithm.sort.quickSort.DoubleWayQuickSort");
        execute(getArray(), "com.wjcat.learn.algorithm.sort.quickSort.QuickSort");
        execute(getArray(), "com.wjcat.learn.algorithm.sort.quickSort.ThreeWayQuickSort");

    }

    private static Comparable[] getArray() {
        Comparable[] result = new Comparable[array.length];
        System.arraycopy(array, 0, result, 0, array.length);
        return result;
    }

    private static void execute(Comparable[] array, String className) throws Exception {

        Class sortClass = Class.forName(className);

        Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable.class});

        Object[] params = new Object[]{array};

        long startTime = System.currentTimeMillis();
        // 调用排序函数
        sortMethod.invoke(null, params);
        long endTime = System.currentTimeMillis();

        if (!isSorted(array))
            throw new InvalidAlgorithmParameterException("sort failed!");

        System.out.println(sortClass.getSimpleName() + " : " + (endTime - startTime) + "ms");

        sortMethod.invoke(params);

    }

    // 判断arr数组是否有序
    public static boolean isSorted(Comparable[] arr) {

        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i].compareTo(arr[i + 1]) > 0)
                return false;
        return true;
    }


}
