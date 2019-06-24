package com.ertu.think_in_java.multiplex_practice.extend_practice;

/**
 * @author hxf
 * @date 2019/6/11 23:27
 */
public class Son extends Parent {

    public Son(int i) {
        super(i);
        System.out.println("孩子："+i);
    }

    public static void main(String[] args) {
        Son son = new Son(2);
    }
}
