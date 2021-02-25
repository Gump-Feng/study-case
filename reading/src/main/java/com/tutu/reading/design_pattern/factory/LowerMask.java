package com.tutu.reading.design_pattern.factory;

/**
 * @Description: java类作用描述
 * @Author: hxf
 * @CreateDate: 2020/9/12$ 10:08$
 * @Version: 1.0
 */
public class LowerMask extends Mask implements IMask {
    @Override
    public void show() {
        System.out.println("我是低端口罩");
    }
}
