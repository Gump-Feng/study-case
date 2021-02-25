package com.tutu.reading.think_in_java.initializae_practice;

/**
 * @author hxf
 * @date 2019/6/9 23:16
 */
public class InitializePractice {
    private String str = "22";
    private static String staticStr = "33";

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        System.out.println(staticStr);
//        InitializePractice initializePractice = new InitializePractice();
//        initializePractice.print();
        Class<?> aClass = Class.forName("com.tutu.reading.think_in_java.initializae_practice.InitializePractice");
        Object o = aClass.newInstance();
        InitializePractice initializePractice = (InitializePractice) o;
        initializePractice.print();
    }

    public void print() {
        System.out.println(str);
    }

    public static void add() {
        System.out.println("add方法运行");
    }
}
