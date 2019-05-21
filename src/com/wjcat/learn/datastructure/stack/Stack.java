package com.wjcat.learn.datastructure.stack;

/**
 * @Description 栈（接口）
 * Created by 厕所里拉屎的猫 on 2019/5/18.
 */
public interface Stack<E> {

    /**
     * 获取栈中元素个数
     * @return 元素个数
     */
    int getSize();

    /**
     * 判断是否为空栈
     * @return boolean
     */
    boolean isEmpty();

    /**
     * 入栈
     * @param element 元素对象
     */
    void push(E element);

    /**
     * 出栈
     * @return 元素对象
     */
    E pop();

    /**
     * 查询栈中元素
     * @return 元素对象
     */
    E peek();

}
