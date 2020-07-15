package com.wjcat.learn.design.creational.abstractfactory.product.computer.factory;

import com.wjcat.learn.design.creational.abstractfactory.product.audio.factory.AbstractAudioFactory;
import com.wjcat.learn.design.creational.abstractfactory.product.computer.poji.AbstractComputer;
import com.wjcat.learn.design.creational.abstractfactory.product.computer.poji.HuaWeiComputer;

/**
 * @author yupeijiang
 * @date 2020/7/15 0015
 */
public class HuaWeiComputerFactory extends AbstractComputerFactory {
    @Override
    public AbstractComputer getComputer() {
        return new HuaWeiComputer();
    }
}
