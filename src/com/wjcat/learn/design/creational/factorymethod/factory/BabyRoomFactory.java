package com.wjcat.learn.design.creational.factorymethod.factory;

import com.wjcat.learn.design.creational.factorymethod.pojo.AbstractRoom;
import com.wjcat.learn.design.creational.factorymethod.pojo.BabyRoom;

/**
 * @author yupeijiang
 * @date 2020/7/15 0015
 */
public class BabyRoomFactory extends AbstractRoomFactory {
    @Override
    public AbstractRoom getRoom() {
        return new BabyRoom();
    }
}
