package com.tutu.reading.think_in_java.initializae_practice;

/**
 * @author hxf
 * @date 2019/6/10 0:25
 */
public class OverLoadPractice {

    public static void main(String[] args) {
        add((short) 100);
    }

    private static void add() {

    }

    private static void add(short b) {
        System.out.println(b);
    }
//    private static void add(long l){
//
//    }
}
