package com.tutu.reading.design_pattern.factory;

/**
 * @Description: 口罩基础类
 * @Author: hxf
 * @CreateDate: 2020/9/12$ 10:02$
 * @Version: 1.0
 */
public class Mask implements IMask {
    public Mask() {
        System.out.println("初始化口罩实例");
    }


    @Override
    public void show() {

    }
}
