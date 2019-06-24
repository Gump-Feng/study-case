package com.ertu.think_in_java.interface_practice;

/**
 * @author hxf
 * @date 2019/6/20 23:25
 */
public class Mouse extends AbstractRodent {
    public static void main(String[] args) {
        Mouse abstractRodent = new Mouse();
        abstractRodent.eat();

    }

//    @Override
//    public void eat() {
//        System.out.println("导出类打印："+2);
//    }`

    public void eat(){
        System.out.println("导出类打印："+2);
    }
}
