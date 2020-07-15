package com.wjcat.learn.design.creational.abstractfactory.product.audio.factory;

import com.wjcat.learn.design.creational.abstractfactory.product.audio.poji.AbstractAudio;
import com.wjcat.learn.design.creational.abstractfactory.product.audio.poji.HuaWeiAudio;

/**
 * @author yupeijiang
 * @date 2020/7/15 0015
 */
public class HuaWeiAudioFactory extends AbstractAudioFactory {
    @Override
    public AbstractAudio getAudio() {
        return new HuaWeiAudio();
    }
}
