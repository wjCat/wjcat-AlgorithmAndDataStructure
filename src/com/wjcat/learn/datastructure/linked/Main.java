package com.wjcat.learn.datastructure.linked;

/**
 * Created by 厕所里拉屎的猫 on 2019/5/19.
 */
public class Main {

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0 ; i < 5 ; i ++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);

        linkedList.removeElement(3);
        System.out.println(linkedList);

        linkedList.removeElement(2);
        System.out.println(linkedList);
    }

}
