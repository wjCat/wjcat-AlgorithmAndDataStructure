package com.wjcat.learn.design.creational.simplefactory;

/**
 * @author yupeijiang
 * @date 2020/7/15 0015
 */
public class Cow extends AbstractAnimal {
    @Override
    void sound() {
        System.out.println("哞哞哞");
    }
}
