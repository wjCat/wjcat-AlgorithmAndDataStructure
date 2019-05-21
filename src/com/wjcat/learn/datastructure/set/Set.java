package com.wjcat.learn.datastructure.set;

/**
 * @Description 集合（接口）
 * Created by 厕所里拉屎的猫 on 2019/5/21.
 */
public interface Set<E> {

    /**
     * 添加元素
     * @param element 元素对象
     */
    void add(E element);

    /**
     * 判断是否包含元素
     * @param element 元素对象
     * @return boolean
     */
    boolean contains(E element);

    /**
     * 删除元素
     * @param element 元素对象
     */
    void remove(E element);

    /**
     * 获取元素个数
     * @return 元素个数
     */
    int getSize();

    /**
     * 是否为空
     * @return boolean
     */
    boolean isEmpty();

}