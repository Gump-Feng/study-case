package com.tutu.reading.think_in_java.internalclass_practice;

/**
 * @author hxf
 * @date 2019/7/1 23:15
 */
public class InterfaceInternalImpl {

    public static void main(String[] args) {
        InterfaceInternalDemo interfaceInternalDemo = new InterfaceInternalDemo();
        Contents contents = interfaceInternalDemo.contents();
        Destination destination = interfaceInternalDemo.destination("destination");
    }
}
