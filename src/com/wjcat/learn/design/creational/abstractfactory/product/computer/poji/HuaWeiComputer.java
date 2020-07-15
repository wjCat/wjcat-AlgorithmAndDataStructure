package com.wjcat.learn.design.creational.abstractfactory.product.computer.poji;

/**
 * @author yupeijiang
 * @date 2020/7/15 0015
 */
public class HuaWeiComputer extends AbstractComputer {
    @Override
    public void introduce() {
        System.out.println("我是华为电脑！");
    }
}
