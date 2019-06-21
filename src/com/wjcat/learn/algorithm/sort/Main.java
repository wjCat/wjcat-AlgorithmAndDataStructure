package com.wjcat.learn.algorithm.sort;

import com.wjcat.learn.algorithm.sort.quickSort.DoubleWayQuickSort;
import com.wjcat.learn.algorithm.sort.quickSort.QuickSort;
import com.wjcat.learn.algorithm.sort.quickSort.ThreeWayQuickSort;

/**
 * @decription @TODO
 * Created by 厕所里拉屎的猫 on 2019/6/17.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        Integer[] array = new Integer[100000000];
//        Integer[] array2 = new Integer[1000000];
//        Integer[] array3 = new Integer[1000000];
//        Integer[] array4 = new Integer[1000000];
//        Integer[] array5 = new Integer[1000000];
//        Integer[] array6 = new Integer[100000000];
        Integer[] array7 = new Integer[100000000];
        for (int i = 0;i<array.length;i++){
//            array[i] = (int) (Math.random() * 10000000);
            array[i] = i;
        }
//        System.arraycopy(array, 0, array2, 0, array.length);
//        System.arraycopy(array, 0, array3, 0, array.length);
//        System.arraycopy(array, 0, array4, 0, array.length);
//        System.arraycopy(array, 0, array5, 0, array.length);
//        System.arraycopy(array, 0, array6, 0, array.length);
        System.arraycopy(array, 0, array7, 0, array.length);

//        execute(array, new SelectionSort());
//        execute(array2, new InsertionSort());
//        execute(array3, new BubbleSort());
//        execute(array4, new Up2DownMergeSort());
//        execute(array6, new DoubleWayQuickSort());
        execute(array7, new ThreeWayQuickSort());

    }

    private static void execute(Integer[] array, Sort sort) throws Exception {

        String time = sort.sort(array);

//        for (int i = 0; i<array.length-1; i++)
//            if (array[i].compareTo(array[i+1]) > 0)
//                throw new Exception("排序出错！");
        System.out.println(String.format("%s========排序所需时间：%s；", sort.getClass().getSimpleName(), time));

    }


}
