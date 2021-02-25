package com.tutu.reading.think_in_java.internalclass_practice;

/**
 * @author hxf
 * @date 2019/7/1 22:44
 * <p>
 * .new的使用
 * <p>
 * 在拥有外部类对象是不可能拥有内部类对象的，因为他会自己默认连接到外部类对象上，静态内部类除外
 */
public class NewInternalDemo {

    public class Inner {
    }

    public static void main(String[] args) {
        NewInternalDemo internalClassDemo = new NewInternalDemo();
        //非静态内部类的实例创建必须要通过外部类对象的.new 进行创建
        Inner inner = internalClassDemo.new Inner();
    }
}
