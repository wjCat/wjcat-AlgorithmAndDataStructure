package com.wjcat.learn.design.creational.abstractfactory.product.watch.factory;

import com.wjcat.learn.design.creational.abstractfactory.product.watch.poji.AbstractWatch;
import com.wjcat.learn.design.creational.abstractfactory.product.watch.poji.HuaWeiWatch;

/**
 * @author yupeijiang
 * @date 2020/7/15 0015
 */
public class HuaWeiWatchFactory extends AbstractWatchFactory {
    @Override
    public AbstractWatch getWatch() {
        return new HuaWeiWatch();
    }
}
