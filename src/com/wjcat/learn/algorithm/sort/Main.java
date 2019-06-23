package com.wjcat.learn.algorithm.sort;

import java.lang.reflect.Method;
import java.security.InvalidAlgorithmParameterException;

/**
 * @decription 测试方法，提供各种数组来对比性能
 * Created by 厕所里拉屎的猫 on 2019/6/17.
 */
public class Main {

    private static Comparable[] array;

    static {
        array = new Comparable[10000];
        for (int i = 0; i < array.length; i++) {
            // 数组元素随机，且无序
//            array[i] = (int) (Math.random() * 10000);
            // 数组中大量重复元素
            // 如果数组元素过大，将导致快排栈内存溢出
            array[i] = (int) (Math.random() * 10);
            // 数组近乎有序或已经有序
//            array[i] = i;
        }
    }

    public static void main(String[] args) throws Exception {
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

    private static void execute(Comparable[] arr, String className) throws Exception {
        new Thread(() -> {
            // 通过Java的反射机制，通过排序的类名，运行排序函数
            try {
                // 通过sortClassName获得排序函数的Class对象
                Class sortClass = Class.forName(className);
                // 通过排序函数的Class对象获得排序方法
                Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable[].class});
                // 排序参数只有一个，是可比较数组arr
                Object[] params = new Object[]{arr};

                long startTime = System.currentTimeMillis();
                // 调用排序函数
                sortMethod.invoke(null, params);
                long endTime = System.currentTimeMillis();

                assert isSorted(arr);
                if (!isSorted(arr))
                    throw new InvalidAlgorithmParameterException("sort failed!");

                System.out.println(sortClass.getSimpleName() + " : " + (endTime - startTime) + "ms");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    // 判断arr数组是否有序
    public static boolean isSorted(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i].compareTo(arr[i + 1]) > 0)
                return false;
        return true;
    }


}
