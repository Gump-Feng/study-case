package com.tutu.reading.design_pattern.factory;

import com.tutu.reading.httpdemo.pojo.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    @Test
    public void listTest() {
        List<User> loggerList = new ArrayList<>();
        loggerList.add(new User());
        List<User> fileLoggers = Collections.unmodifiableList(loggerList);
        if (!fileLoggers.isEmpty()) {
            User user = fileLoggers.get(0);
            System.out.println(user);
            fileLoggers.clear();
        }
    }
}