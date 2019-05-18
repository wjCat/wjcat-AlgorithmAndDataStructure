package com.wjcat.learn.datastructure.queue;

/**
 * Created by 厕所里拉屎的猫 on 2019/5/18.
 */
public interface Queue<E> {

    /**
     * 获取元素个数
     * @return 元素个数
     */
    int getSize();

    /**
     * 判断是否为空
     * @return boolean
     */
    boolean isEmpty();

    /**
     * 入队
     * @param element 元素对象
     */
    void enqueue(E element);

    /**
     * 出队
     * @return 元素对象
     */
    E dequeue();

    /**
     * 获取队首元素
     * @return 元素对象
     */
    E getFront();

}
