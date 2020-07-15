package com.wjcat.learn.design.creational.abstractfactory.company;

import com.wjcat.learn.design.creational.abstractfactory.product.audio.factory.AbstractAudioFactory;
import com.wjcat.learn.design.creational.abstractfactory.product.audio.factory.HuaWeiAudioFactory;
import com.wjcat.learn.design.creational.abstractfactory.product.audio.poji.AbstractAudio;
import com.wjcat.learn.design.creational.abstractfactory.product.computer.factory.AbstractComputerFactory;
import com.wjcat.learn.design.creational.abstractfactory.product.computer.factory.HuaWeiComputerFactory;
import com.wjcat.learn.design.creational.abstractfactory.product.computer.poji.AbstractComputer;
import com.wjcat.learn.design.creational.abstractfactory.product.phone.factory.AbstractPhoneFactory;
import com.wjcat.learn.design.creational.abstractfactory.product.phone.factory.HuaWeiPhoneFactory;
import com.wjcat.learn.design.creational.abstractfactory.product.phone.factory.RongYaoPhoneFactory;
import com.wjcat.learn.design.creational.abstractfactory.product.phone.poji.AbstractPhone;
import com.wjcat.learn.design.creational.abstractfactory.product.watch.factory.AbstractWatchFactory;
import com.wjcat.learn.design.creational.abstractfactory.product.watch.factory.HuaWeiWatchFactory;
import com.wjcat.learn.design.creational.abstractfactory.product.watch.poji.AbstractWatch;

/**
 * @author yupeijiang
 * @date 2020/7/15 0015
 */
public class HuaWei extends AbstractCompany {

    private final AbstractAudioFactory audioFactory;
    private final AbstractComputerFactory computerFactory;
    private final AbstractPhoneFactory phoneFactory;
    private final AbstractWatchFactory watchFactory;

    public HuaWei() {
        this.audioFactory = new HuaWeiAudioFactory();
        this.computerFactory = new HuaWeiComputerFactory();
        this.phoneFactory = new RongYaoPhoneFactory();
        this.watchFactory = new HuaWeiWatchFactory();
    }

    @Override
    public AbstractAudio getAudio() {
        return this.audioFactory.getAudio();
    }

    @Override
    public AbstractComputer getComputer() {
        return this.computerFactory.getComputer();
    }

    @Override
    public AbstractPhone getPhone() {
        return this.phoneFactory.getPhone();
    }

    @Override
    public AbstractWatch getWatch() {
        return this.watchFactory.getWatch();
    }
}
