package com.mmall.concurrency.example;

import com.mmall.concurrency.annoations.Recommand;
import com.mmall.concurrency.annoations.ThreadSafe;

/**
 * 枚举实现线程安全
 */
@ThreadSafe
@Recommand
public class SingletonExample2 {
    private SingletonExample2(){}

    public static SingletonExample2 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;
        private SingletonExample2 singleton;
        //JVM保证这个方法绝对只调用一次
        Singleton() {
            singleton = new SingletonExample2();
        }

        public SingletonExample2 getInstance() {
            return singleton;
        }
    }
}
