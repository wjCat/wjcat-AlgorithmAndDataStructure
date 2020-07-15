package com.wjcat.learn.design.creational.abstractfactory.company;

import com.wjcat.learn.design.creational.abstractfactory.product.audio.factory.AbstractAudioFactory;
import com.wjcat.learn.design.creational.abstractfactory.product.audio.poji.AbstractAudio;
import com.wjcat.learn.design.creational.abstractfactory.product.computer.factory.AbstractComputerFactory;
import com.wjcat.learn.design.creational.abstractfactory.product.computer.poji.AbstractComputer;
import com.wjcat.learn.design.creational.abstractfactory.product.phone.factory.AbstractPhoneFactory;
import com.wjcat.learn.design.creational.abstractfactory.product.phone.poji.AbstractPhone;
import com.wjcat.learn.design.creational.abstractfactory.product.watch.factory.AbstractWatchFactory;
import com.wjcat.learn.design.creational.abstractfactory.product.watch.poji.AbstractWatch;

import javax.swing.*;

/**
 * @author yupeijiang
 * @date 2020/7/15 0015
 */
public abstract class AbstractCompany {

    public abstract AbstractAudio getAudio();

    public abstract AbstractComputer getComputer();

    public abstract AbstractPhone getPhone();

    public abstract AbstractWatch getWatch();

}
