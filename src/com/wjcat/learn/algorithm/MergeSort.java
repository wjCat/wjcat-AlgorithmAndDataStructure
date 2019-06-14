package com.wjcat.learn.algorithm;

/**
 * @Description 归并排序
 * Created by 厕所里拉屎的猫 on 2019/5/15.
 */
public class MergeSort<E extends Comparable> {

    public void sort(E[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(E[] array, int left, int right) {
        int sum = right - left + 1; // 此次排序的总元素个数
        int leftEnd = left + (right - left) / 2;// 左排序数组元素的末尾索引
        int rightStart = leftEnd + 1;// 左排序数组元素的起始索引
        if (left >= right)
            return;
        mergeSort(array, left, leftEnd);
        mergeSort(array, rightStart, right);
        E[] newArray = (E[]) new Comparable[sum];
        int leftPoint = left;
        int rightPoint = rightStart;
        while (true) {
            if (leftPoint > leftEnd || rightPoint > right) {
                System.arraycopy(array, (leftPoint - left) > (rightPoint - rightStart) ? rightPoint : leftPoint, newArray, (leftPoint - left) + (rightPoint - rightStart), sum - ((leftPoint - left) + (rightPoint - rightStart)));
                System.arraycopy(newArray, 0, array, left, sum);
                return;
            }
            if (array[leftPoint].compareTo(array[rightPoint]) > 0) {
                newArray[(leftPoint - left) + (rightPoint - rightStart)] = array[rightPoint];
                rightPoint++;
            } else {
                newArray[(leftPoint - left) + (rightPoint - rightStart)] = array[leftPoint];
                leftPoint++;
            }
        }
    }

}
