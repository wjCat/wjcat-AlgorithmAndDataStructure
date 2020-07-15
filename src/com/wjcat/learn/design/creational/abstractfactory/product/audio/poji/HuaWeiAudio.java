package com.wjcat.learn.design.creational.abstractfactory.product.audio.poji;

/**
 * @author yupeijiang
 * @date 2020/7/15 0015
 */
public class HuaWeiAudio extends AbstractAudio {
    @Override
    public void introduce() {
        System.out.println("我是华为音响设备！");
    }
}
