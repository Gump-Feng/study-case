package com.ertu.think_in_java.internalclass_practice;

/**
 * @author hxf
 * @date 2019/7/1 22:51
 * <p>
 * 内部类中this的引用
 */
public class ThisInternalDemo {

    void f() {
        System.out.println("ThisInternalDemo.f()");
    }

    public class Inner {
        public ThisInternalDemo outer() {

            //this指向外部类的实例化对象
            return ThisInternalDemo.this;
//            return new ThisInternalDemo();
        }
    }

    public Inner inner() {
        return new Inner();
    }

    public static void main(String[] args) {
        ThisInternalDemo thisInternalDemo = new ThisInternalDemo();
        Inner inner = thisInternalDemo.inner();
        inner.outer().f();
    }

}

