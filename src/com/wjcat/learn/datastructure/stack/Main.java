package com.wjcat.learn.datastructure.stack;

/**
 * Created by 厕所里拉屎的猫 on 2019/5/18.
 */
public class Main {

    public static void main(String[] args) {

        ArrayStack<Integer> stack = new ArrayStack<>();

        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        for(int i = 0 ; i < 5 ; i ++){
            stack.pop();
            System.out.println(stack);
        }
    }

}
