package com.wjcat.learn.design.creational.abstractfactory;

import com.wjcat.learn.design.creational.abstractfactory.company.AbstractCompany;
import com.wjcat.learn.design.creational.abstractfactory.company.HuaWei;

/**
 * @author yupeijiang
 * @date 2020/7/15 0015
 */
public class Test {

    public static void main(String[] args) {
        AbstractCompany company = new HuaWei();
        company.getAudio().introduce();
        company.getComputer().introduce();
        company.getPhone().introduce();
        company.getWatch().introduce();
    }

}
