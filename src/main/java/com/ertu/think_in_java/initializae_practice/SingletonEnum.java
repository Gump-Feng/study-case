package com.ertu.think_in_java.initializae_practice;

/**
 * @author hxf
 * @date 2019/6/9 23:52
 */
public class SingletonEnum {
    private SingletonEnum() {
    }

    public static SingletonEnum getInstance() {
        Singleton instance = Singleton.INSTANCE;
        return Singleton.INSTANCE.getInstance();
    }

    private static enum Singleton {
        INSTANCE;

        private SingletonEnum singleton;

        //JVM会保证此方法绝对只调用一次
        Singleton() {
            singleton = new SingletonEnum();
        }

        public SingletonEnum getInstance() {
            return singleton;
        }
    }

    public static void main(String[] args) {
        SingletonEnum obj1 = SingletonEnum.getInstance();
        SingletonEnum obj2 = SingletonEnum.getInstance();
        //输出结果：obj1==obj2?true
        System.out.println("obj1==obj2?" + (obj1 == obj2));
    }


}
