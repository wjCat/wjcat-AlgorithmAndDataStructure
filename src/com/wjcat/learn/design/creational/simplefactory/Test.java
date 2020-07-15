package com.wjcat.learn.design.creational.simplefactory;

/**
 * @author yupeijiang
 * @date 2020/7/15 0015
 */
public class Test {

    public static void main(String[] args) {
        AbstractAnimal animal = AnimalFactory.getAnimal("Cat");
        assert animal != null;
        animal.sound();
    }

}
