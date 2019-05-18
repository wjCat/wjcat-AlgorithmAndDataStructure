package com.wjcat.learn.datastructure.array;

/**
 * Created by 厕所里拉屎的猫 on 2019/5/17.
 */
public class Main {

    public static void main(String[] args) {

        ArrayList arr = new ArrayList(20);
        for(int i = 0 ; i < 40 ; i ++)
            arr.addLast(i);
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);

        for(int i = 0 ; i < 39 ; i ++){
            arr.removeFirst();
            System.out.println(arr);
        }
    }

}
