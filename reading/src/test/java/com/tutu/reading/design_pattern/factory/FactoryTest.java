package com.tutu.reading.design_pattern.factory;

import org.junit.Test;

/**
 * @Description: java类作用描述
 * @Author: hxf
 * @CreateDate: 2020/9/12$ 10:14$
 * @Version: 1.0
 */
public class FactoryTest {

    @Test
    public void typeFactoryTest() {
        MaskFactory maskFactory = new MaskFactory();
        Mask highMask = maskFactory.createMask("高端口罩");
        Mask lowerMask = maskFactory.createMask("低端口罩");

        highMask.show();
        lowerMask.show();
    }

    @Test
    public void factoryTest() {
        MaskFactory maskFactory = new MaskFactory();
        Mask mask = maskFactory.createMask();
        mask.show();
    }

    @Test
    public void factoryMethodTest() {
        HighMaskFactory highMaskFactory = new HighMaskFactory();
        LowerMaskFactory lowerMaskFactory = new LowerMaskFactory();
        IMask mask = highMaskFactory.createMask();
        IMask mask1 = lowerMaskFactory.createMask();
        mask.show();
        mask1.show();

        String s = String.valueOf(1);
    }

}