package com.wjcat.learn.design.creational.factorymethod;

import com.wjcat.learn.design.creational.factorymethod.factory.AbstractRoomFactory;
import com.wjcat.learn.design.creational.factorymethod.factory.BabyRoomFactory;
import com.wjcat.learn.design.creational.factorymethod.factory.ReadingRoomFactory;
import com.wjcat.learn.design.creational.factorymethod.pojo.AbstractRoom;

/**
 * @author yupeijiang
 * @date 2020/7/15 0015
 */
public class Test {

    public static void main(String[] args) {
        AbstractRoomFactory factory = new BabyRoomFactory();
        AbstractRoom room = factory.getRoom();
        room.doSomething();
    }

}
