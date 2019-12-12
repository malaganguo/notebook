package com.mmall.concurrency.example;

import com.mmall.concurrency.annoations.ThreadSafe;

/**
 * 线程安全的懒汉模式
 *  volatile + 双重检测机制 ->禁止指令重排
 */
@ThreadSafe
public class SingletonExample {

    private SingletonExample(){}
    //volatile保证创建对象的有序性
    public static volatile SingletonExample instance = null;

    public static SingletonExample getInstance() {
        if(instance == null) {//双重锁
            synchronized (SingletonExample.class) {
                if(instance == null) {
                    instance = new SingletonExample();
                }
            }
        }
        return instance;
    }
}
