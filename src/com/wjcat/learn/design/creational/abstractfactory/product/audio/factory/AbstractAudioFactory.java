package com.wjcat.learn.design.creational.abstractfactory.product.audio.factory;

import com.wjcat.learn.design.creational.abstractfactory.product.audio.poji.AbstractAudio;

/**
 * @author yupeijiang
 * @date 2020/7/15 0015
 */
public abstract class AbstractAudioFactory {
    public abstract AbstractAudio getAudio();
}
