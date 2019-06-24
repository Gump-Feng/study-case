package com.ertu.think_in_java.initializae_practice;

/**
 * @author hxf
 * @date 2019/6/9 23:33
 *
 * 枚举类型练习
 */
public enum EnumPractice {
    RED("red"),GREEN("green"),BLUE("blue");
    //防止字段值被修改，增加的字段也统一final表示常量

    private String value;

    EnumPractice(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static void main(String[] args) {
        System.out.println(EnumPractice.BLUE.getValue());
    }
}
