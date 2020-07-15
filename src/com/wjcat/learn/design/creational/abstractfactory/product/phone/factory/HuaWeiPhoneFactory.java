package com.wjcat.learn.design.creational.abstractfactory.product.phone.factory;

import com.wjcat.learn.design.creational.abstractfactory.product.computer.factory.AbstractComputerFactory;
import com.wjcat.learn.design.creational.abstractfactory.product.computer.poji.AbstractComputer;
import com.wjcat.learn.design.creational.abstractfactory.product.computer.poji.HuaWeiComputer;
import com.wjcat.learn.design.creational.abstractfactory.product.phone.poji.AbstractPhone;
import com.wjcat.learn.design.creational.abstractfactory.product.phone.poji.HuaWeiPhone;

/**
 * @author yupeijiang
 * @date 2020/7/15 0015
 */
public class HuaWeiPhoneFactory extends AbstractPhoneFactory {
    @Override
    public AbstractPhone getPhone() {
        return new HuaWeiPhone();
    }
}
