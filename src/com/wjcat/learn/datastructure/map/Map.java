package com.wjcat.learn.datastructure.map;


/**
 * @Description 映射（接口）
 * Created by 厕所里拉屎的猫 on 2019/5/21.
 */
public interface Map<K, V> {

    /**
     * 添加元素
     * @param key 键
     * @param value 值
     */
    void add(K key, V value);

    /**
     * 删除元素
     * @param key 键
     * @return 值
     */
    V remove(K key);

    /**
     * 查询是否包含该键
     * @param key 键
     * @return boolean
     */
    boolean contains(K key);

    /**
     * 获取键对应的值
     * @param key 键
     * @return 值
     */
    V get(K key);

    /**
     * 设置键为key的值
     * @param key 键
     * @param newValue 值
     */
    void set(K key, V newValue);

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
}