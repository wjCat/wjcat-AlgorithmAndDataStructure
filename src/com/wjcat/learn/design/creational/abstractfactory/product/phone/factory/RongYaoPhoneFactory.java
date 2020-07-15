package com.wjcat.learn.design.creational.abstractfactory.product.phone.factory;

import com.wjcat.learn.design.creational.abstractfactory.product.phone.poji.AbstractPhone;
import com.wjcat.learn.design.creational.abstractfactory.product.phone.poji.RongYaoPhone;

/**
 * @author yupeijiang
 * @date 2020/7/15 0015
 */
public class RongYaoPhoneFactory extends AbstractPhoneFactory {
    @Override
    public AbstractPhone getPhone() {
        return new RongYaoPhone();
    }
}
