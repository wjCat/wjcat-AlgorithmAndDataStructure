package com.wjcat.learn.design.creational.simplefactory;

/**
 * @author yupeijiang
 * @date 2020/7/15 0015
 */
public class AnimalFactory {

    static AbstractAnimal getAnimal(String animal) {
        if (Dog.class.getSimpleName().equals(animal)) {
            return new Dog();
        } else if (Cat.class.getSimpleName().equals(animal)) {
            return new Cat();
        } else if (Cow.class.getSimpleName().equals(animal)) {
            return new Cow();
        } else {
            return null;
        }
    }
}
