package com.tutu.reading.design_pattern.factory;

/**
 * @Description: 简单工厂模式
 * @Author: hxf
 * @CreateDate: 2020/9/12$ 10:04$
 * @Version: 1.0
 */
public class MaskFactory {

    public Mask createMask() {
        Mask mask = new Mask();
        //初始化口罩方法
        String s = mask.toString();
        System.out.println(s);
        return mask;
    }

    public Mask createMask(String type) {
        Mask mask = null;
        if ("高端口罩".equals(type)) {
            mask = new HighMask();
            // .....
            // HighEndMask的100行初始化代码
        } else if ("低端口罩".equals(type)) {
            mask = new LowerMask();
            // .....
            // LowEndMask的100行初始化代码
        }
        return mask;
    }

}
