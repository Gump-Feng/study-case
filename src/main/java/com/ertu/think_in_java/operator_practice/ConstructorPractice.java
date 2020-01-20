package com.ertu.think_in_java.operator_practice;

/**
 * @author hxf
 * @date 2019/6/8 23:09
 * <p>
 * ThinkInJava---操作符练习
 */
public class ConstructorPractice {

    public ConstructorPractice() {
        System.out.println(this);
        System.out.println("无参构造器创建！！");
        ConstructorPractice operatorPractice = new ConstructorPractice(1);
        System.out.println("有参对象：" + operatorPractice);
    }

    public ConstructorPractice(int detail) {
        System.out.println("有参构造器创建！！！" + detail);
        System.out.println("有参构造器输出" + this);
    }

    public static void main(String[] args) {
        ConstructorPractice operatorPractice = new ConstructorPractice();
        System.out.println("无参对象：" + operatorPractice);
    }

    public void add() {
        System.out.println(2);
    }

    public void add(int i) {
        this.add();
        System.out.println("add" + i);
    }

    static class displacementPractice extends ConstructorPractice {
        public void add() {
            System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqq");
        }

        public void add(int i) {
            ConstructorPractice operatorPractice = new ConstructorPractice();
            operatorPractice.add(4);
            add();
            System.out.println("add" + i);
        }


        public static void main(String[] args) {
            displacementPractice displacementPractice = new displacementPractice();
            displacementPractice.add(2);
        }
    }

    public static void bitwiseTest() {
        int i = 1;
        System.out.println(Integer.toBinaryString(i));

        i >>>= 10;
        System.out.println(Integer.toBinaryString(i));
    }

}
