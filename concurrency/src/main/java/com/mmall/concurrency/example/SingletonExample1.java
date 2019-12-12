package com.mmall.concurrency.example;

/**
 * 饿汉模式本来就是线程安全的
 * 线程安全的饿汉模式二
 */
public class SingletonExample1 {

    private SingletonExample1(){}
    //必须写在静态代码块前，否则会NPE
    private static SingletonExample1 instance = null;

    static {
        instance =new SingletonExample1();
    }

    public static SingletonExample1 getInstance() {
        return instance;
    }
}
